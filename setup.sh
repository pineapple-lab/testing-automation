#!/usr/bin/env bash
# Playwright (Java) framework - environment setup for macOS and Linux.
# Run from the root of the cloned repository:
#   chmod +x setup.sh && ./setup.sh
# Idempotent: skips what is installed, updates what already exists.

set -euo pipefail

# ----------------------------- CONFIGURATION -----------------------------
JDK_VERSION=17                        # JDK major version (Temurin)
MAVEN_VERSION="3.9.9"                 # Maven version managed by this script
TEST_NAME="AuthTest"                  # Smoke test executed at the end
TOOLS_DIR="$HOME/.pw-tools"
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
# --------------------------------------------------------------------------

ts()   { date +"%H:%M:%S"; }
log()  { echo "[$(ts)] $*"; }
ok()   { echo -e "[$(ts)] \033[32m[OK]\033[0m   $*"; }
warn() { echo -e "[$(ts)] \033[33m[WARN]\033[0m $*"; }
fail() { echo -e "[$(ts)] \033[31m[FAIL]\033[0m $*" >&2; exit 1; }
has()  { command -v "$1" >/dev/null 2>&1; }

OS="$(uname -s)"
ARCH_RAW="$(uname -m)"
case "$OS" in
  Darwin) ADOPTIUM_OS="mac" ;;
  Linux)  ADOPTIUM_OS="linux" ;;
  *) fail "Unsupported OS: $OS (use setup.ps1 on Windows)" ;;
esac
case "$ARCH_RAW" in
  x86_64|amd64)  ADOPTIUM_ARCH="x64" ;;
  arm64|aarch64) ADOPTIUM_ARCH="aarch64" ;;
  *) fail "Unsupported architecture: $ARCH_RAW" ;;
esac

SUDO=""
if [ "$(id -u)" -ne 0 ] && has sudo; then SUDO="sudo"; fi

log "=== Playwright Java framework setup ($OS/$ARCH_RAW) ==="
log "Project directory: $PROJECT_DIR"
mkdir -p "$TOOLS_DIR"

download() { # url dest
  if has curl; then curl -fL --retry 3 -o "$2" "$1"
  elif has wget; then wget -O "$2" "$1"
  else fail "Neither curl nor wget is available."; fi
}

# ------------------------------- 1. Git ----------------------------------
log "--- Step 1/6: Git ---"
if has git; then
  ok "Git already installed: $(git --version)"
else
  log "Installing Git..."
  if [ "$OS" = "Darwin" ]; then
    if has brew; then brew install git
    else xcode-select --install || true; fail "Complete the Xcode Command Line Tools installation (provides Git) and re-run."; fi
  elif has apt-get; then $SUDO apt-get update -y && $SUDO apt-get install -y git curl unzip
  elif has dnf;     then $SUDO dnf install -y git curl unzip
  elif has pacman;  then $SUDO pacman -Sy --noconfirm git curl unzip
  else fail "No supported package manager found to install Git."; fi
  ok "Git installed: $(git --version)"
fi
if [ "$OS" = "Darwin" ] && has brew; then brew upgrade git >/dev/null 2>&1 || true; fi

# ------------------------------- 2. JDK ----------------------------------
log "--- Step 2/6: JDK $JDK_VERSION (Temurin) ---"
JDK_HOME="$TOOLS_DIR/jdk-$JDK_VERSION"
JDK_TMP="$(mktemp -d)"
JDK_URL="https://api.adoptium.net/v3/binary/latest/${JDK_VERSION}/ga/${ADOPTIUM_OS}/${ADOPTIUM_ARCH}/jdk/hotspot/normal/eclipse"
log "Downloading latest JDK $JDK_VERSION build (updates existing install if newer)..."
download "$JDK_URL" "$JDK_TMP/jdk.tar.gz"
tar -xzf "$JDK_TMP/jdk.tar.gz" -C "$JDK_TMP"
NEW_JDK="$(find "$JDK_TMP" -maxdepth 1 -type d -name 'jdk-*' | head -n 1)"
[ -n "$NEW_JDK" ] || fail "Could not extract the JDK archive."
if [ "$OS" = "Darwin" ]; then NEW_JAVA_HOME="$NEW_JDK/Contents/Home"; else NEW_JAVA_HOME="$NEW_JDK"; fi
NEW_REL="$(grep -h '^JAVA_VERSION=' "$NEW_JAVA_HOME/release" | head -n1)"
OLD_REL=""
if [ -d "$JDK_HOME" ]; then
  if [ "$OS" = "Darwin" ]; then OLD_JH="$JDK_HOME/Contents/Home"; else OLD_JH="$JDK_HOME"; fi
  OLD_REL="$(grep -h '^JAVA_VERSION=' "$OLD_JH/release" 2>/dev/null | head -n1 || true)"
fi
if [ -n "$OLD_REL" ] && [ "$OLD_REL" = "$NEW_REL" ]; then
  ok "JDK already up to date ($NEW_REL) - skipping."
else
  rm -rf "$JDK_HOME"; mv "$NEW_JDK" "$JDK_HOME"
  ok "JDK installed/updated at $JDK_HOME ($NEW_REL)"
fi
rm -rf "$JDK_TMP"
if [ "$OS" = "Darwin" ]; then export JAVA_HOME="$JDK_HOME/Contents/Home"; else export JAVA_HOME="$JDK_HOME"; fi
export PATH="$JAVA_HOME/bin:$PATH"
ok "Java ready: $(java -version 2>&1 | head -n 1)"
if [ "$OS" = "Darwin" ]; then
  mkdir -p "$HOME/Library/Java/JavaVirtualMachines"
  ln -sfn "$JDK_HOME" "$HOME/Library/Java/JavaVirtualMachines/temurin-$JDK_VERSION.jdk"
  ok "JDK linked for macOS/IDE discovery: ~/Library/Java/JavaVirtualMachines/temurin-$JDK_VERSION.jdk"
fi

# ------------------------------ 3. Maven ---------------------------------
log "--- Step 3/6: Maven $MAVEN_VERSION ---"
MAVEN_HOME="$TOOLS_DIR/apache-maven-$MAVEN_VERSION"
if [ -x "$MAVEN_HOME/bin/mvn" ]; then
  ok "Maven $MAVEN_VERSION already installed - skipping download."
else
  M_TMP="$(mktemp -d)"
  download "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" "$M_TMP/maven.tar.gz"
  tar -xzf "$M_TMP/maven.tar.gz" -C "$TOOLS_DIR"
  rm -rf "$M_TMP"
  ok "Maven $MAVEN_VERSION installed."
fi
for d in "$TOOLS_DIR"/apache-maven-*; do
  [ -d "$d" ] && [ "$d" != "$MAVEN_HOME" ] && { log "Removing old Maven: $(basename "$d")"; rm -rf "$d"; }
done
export MAVEN_HOME M2_HOME="$MAVEN_HOME"
export PATH="$MAVEN_HOME/bin:$PATH"
ok "$(mvn -version | head -n 1)"

# ------------------- Persist environment variables -----------------------
log "Persisting environment variables in shell profiles..."
BEGIN="# >>> playwright-framework env >>>"
END="# <<< playwright-framework env <<<"
BLOCK="$BEGIN
export JAVA_HOME=\"$JAVA_HOME\"
export MAVEN_HOME=\"$MAVEN_HOME\"
export M2_HOME=\"$MAVEN_HOME\"
export PATH=\"\$JAVA_HOME/bin:\$MAVEN_HOME/bin:\$PATH\"
$END"
for rc in "$HOME/.bashrc" "$HOME/.zshrc" "$HOME/.bash_profile" "$HOME/.profile"; do
  if [ "$OS" = "Darwin" ] && { [ "$rc" = "$HOME/.zshrc" ] || [ "$rc" = "$HOME/.bash_profile" ]; }; then touch "$rc"; fi
  [ -f "$rc" ] || continue
  if grep -qF "$BEGIN" "$rc"; then
    tmp="$(mktemp)"
    awk -v b="$BEGIN" -v e="$END" '$0==b{skip=1} !skip{print} $0==e{skip=0}' "$rc" > "$tmp"
    cat "$tmp" > "$rc"; rm -f "$tmp"
    log "Updating existing block in $rc"
  else
    log "Adding block to $rc"
  fi
  printf '\n%s\n' "$BLOCK" >> "$rc"
done
ok "JAVA_HOME=$JAVA_HOME"
ok "MAVEN_HOME=$MAVEN_HOME"

# ---------------------- 4. Dependencies and Chromium ---------------------
log "--- Step 4/6: Dependencies and Chromium ---"
cd "$PROJECT_DIR"
if [ -d .git ]; then log "Updating repository (git pull --ff-only)..."; git pull --ff-only || warn "git pull failed - continuing with local copy."; fi
log "Resolving/updating Maven dependencies..."
mvn -U -B -q dependency:resolve || fail "Maven dependency resolution failed."

log "Installing/updating Playwright Chromium..."
if [ "$OS" = "Linux" ]; then PW_ARGS="install --with-deps chromium"; else PW_ARGS="install chromium"; fi
if [ "$OS" = "Linux" ] && [ -n "$SUDO" ]; then $SUDO -v || true; fi
mvn -B exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="$PW_ARGS" || fail "Playwright Chromium installation failed."
ok "Chromium ready."

# ------------------------ 5. VS Code configuration -----------------------
log "--- Step 5/6: VS Code configuration ---"
CODE_BIN=""
if has code; then CODE_BIN="code"
elif [ -x "/Applications/Visual Studio Code.app/Contents/Resources/app/bin/code" ]; then
  CODE_BIN="/Applications/Visual Studio Code.app/Contents/Resources/app/bin/code"
fi
if [ -n "$CODE_BIN" ]; then
  log "Installing/updating VS Code extension: Extension Pack for Java..."
  "$CODE_BIN" --install-extension vscjava.vscode-java-pack --force && ok "VS Code Java extensions ready." \
    || warn "Could not install the VS Code extension - install 'Extension Pack for Java' manually."
else
  warn "VS Code CLI ('code') not found - install the 'Extension Pack for Java' manually."
fi

mkdir -p "$PROJECT_DIR/.vscode"
SETTINGS_FILE="$PROJECT_DIR/.vscode/settings.json"
if [ ! -f "$SETTINGS_FILE" ]; then
  cat > "$SETTINGS_FILE" <<EOF
{
  "java.jdt.ls.java.home": "$JAVA_HOME",
  "java.configuration.runtimes": [
    { "name": "JavaSE-$JDK_VERSION", "path": "$JAVA_HOME", "default": true }
  ],
  "maven.executable.path": "$MAVEN_HOME/bin/mvn"
}
EOF
  ok "VS Code settings written: $SETTINGS_FILE"
elif has python3; then
  SETTINGS_FILE="$SETTINGS_FILE" JH="$JAVA_HOME" MH="$MAVEN_HOME" JV="$JDK_VERSION" python3 - <<'PY' \
    && ok "VS Code settings updated: $SETTINGS_FILE" \
    || warn "Existing .vscode/settings.json could not be parsed (comments?) - left untouched. Add java.jdt.ls.java.home=$JAVA_HOME manually."
import json, os
p = os.environ["SETTINGS_FILE"]
with open(p) as f:
    data = json.load(f)
data["java.jdt.ls.java.home"] = os.environ["JH"]
data["java.configuration.runtimes"] = [{"name": "JavaSE-" + os.environ["JV"], "path": os.environ["JH"], "default": True}]
data["maven.executable.path"] = os.environ["MH"] + "/bin/mvn"
with open(p, "w") as f:
    json.dump(data, f, indent=2)
PY
else
  warn "Existing .vscode/settings.json found and python3 is unavailable - add java.jdt.ls.java.home=$JAVA_HOME manually."
fi
# Keep this machine-specific file out of git without touching the shared .gitignore
if [ -d "$PROJECT_DIR/.git" ]; then
  mkdir -p "$PROJECT_DIR/.git/info"
  grep -qxF ".vscode/settings.json" "$PROJECT_DIR/.git/info/exclude" 2>/dev/null \
    || { echo ".vscode/settings.json" >> "$PROJECT_DIR/.git/info/exclude"; log "Added .vscode/settings.json to .git/info/exclude (local only)."; }
fi

# ---------------------------- 6. Smoke test ------------------------------
log "--- Step 6/6: Running $TEST_NAME ---"
mvn -B test -Dtest="$TEST_NAME" -DfailIfNoTests=false || fail "$TEST_NAME failed. Review the log above."
ok "$TEST_NAME passed."

ok "=== Setup completed successfully ==="
warn "Open a NEW terminal so the environment variables take effect."
warn "If VS Code is already open: Cmd+Shift+P > Developer: Reload Window."