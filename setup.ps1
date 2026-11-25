<#
 Playwright (Java) framework - environment setup for Windows.
 Run from the root of the cloned repository:
   powershell -ExecutionPolicy Bypass -File .\setup.ps1
 Idempotent: skips what is installed, updates what already exists.
#>

# ----------------------------- CONFIGURATION -----------------------------
$JdkVersion    = 17                       # JDK major version (Temurin)
$MavenVersion  = "3.9.9"                  # Maven version managed by this script
$TestName      = "AuthTest"               # Smoke test executed at the end
$ToolsDir      = Join-Path $env:USERPROFILE ".pw-tools"
$ProjectDir    = $PSScriptRoot
# --------------------------------------------------------------------------

$ErrorActionPreference = "Continue"   # native tools write progress to stderr; exit codes are checked explicitly
$ProgressPreference    = "SilentlyContinue"

function Log   ($m) { Write-Host ("[{0}] {1}" -f (Get-Date -Format "HH:mm:ss"), $m) }
function Ok    ($m) { Write-Host ("[{0}] [OK]   {1}" -f (Get-Date -Format "HH:mm:ss"), $m) -ForegroundColor Green }
function Warn  ($m) { Write-Host ("[{0}] [WARN] {1}" -f (Get-Date -Format "HH:mm:ss"), $m) -ForegroundColor Yellow }
function Fail  ($m) { Write-Host ("[{0}] [FAIL] {1}" -f (Get-Date -Format "HH:mm:ss"), $m) -ForegroundColor Red; exit 1 }
function Has   ($c) { [bool](Get-Command $c -ErrorAction SilentlyContinue) }

function Set-UserEnv ($name, $value) {
    [Environment]::SetEnvironmentVariable($name, $value, "User")
    Set-Item -Path "Env:$name" -Value $value
    Ok "Environment variable set: $name=$value"
}

function Add-ToUserPath ($dir) {
    $current = [Environment]::GetEnvironmentVariable("Path", "User")
    $parts = @()
    if ($current) { $parts = $current -split ";" | Where-Object { $_ } }
    if ($parts -notcontains $dir) {
        [Environment]::SetEnvironmentVariable("Path", (($parts + $dir) -join ";"), "User")
        Ok "Added to user PATH: $dir"
    } else {
        Log "Already in user PATH: $dir"
    }
    if (($env:Path -split ";") -notcontains $dir) { $env:Path = "$dir;$env:Path" }
}

function Install-Or-Upgrade-Winget ($id, $label) {
    if (-not (Has "winget")) { Fail "winget not found. Install 'App Installer' from the Microsoft Store and re-run." }
    $installed = winget list --id $id --exact --accept-source-agreements 2>&1 | Out-String
    if ($installed -match [regex]::Escape($id)) {
        Log "$label already installed - checking for updates..."
        winget upgrade --id $id --exact --silent --accept-source-agreements --accept-package-agreements
    } else {
        Log "Installing $label..."
        winget install --id $id --exact --silent --accept-source-agreements --accept-package-agreements
    }
}

function Refresh-Path {
    $machine = [Environment]::GetEnvironmentVariable("Path", "Machine")
    $user    = [Environment]::GetEnvironmentVariable("Path", "User")
    $env:Path = "$machine;$user"
}

Log "=== Playwright Java framework setup (Windows) ==="
Log "Project directory: $ProjectDir"
New-Item -ItemType Directory -Force -Path $ToolsDir | Out-Null

# ------------------------------- 1. Git ----------------------------------
Log "--- Step 1/5: Git ---"
Install-Or-Upgrade-Winget "Git.Git" "Git"
Refresh-Path
if (-not (Has "git")) { Fail "Git is still not available in PATH. Open a new terminal and re-run." }
Ok ("Git ready: " + (git --version))

# ------------------------------- 2. JDK ----------------------------------
Log "--- Step 2/5: JDK $JdkVersion ---"
Install-Or-Upgrade-Winget "Microsoft.OpenJDK.$JdkVersion" "OpenJDK $JdkVersion"
Refresh-Path
$jdkHome = Get-ChildItem "C:\Program Files\Microsoft" -Directory -Filter "jdk-$JdkVersion*" -ErrorAction SilentlyContinue |
        Sort-Object Name -Descending | Select-Object -First 1
if (-not $jdkHome) { Fail "Could not locate the JDK $JdkVersion installation directory." }
Set-UserEnv "JAVA_HOME" $jdkHome.FullName
Add-ToUserPath (Join-Path $jdkHome.FullName "bin")
$javaRelease = Join-Path $jdkHome.FullName "release"
$javaVer = if (Test-Path $javaRelease) { (Select-String -Path $javaRelease -Pattern '^JAVA_VERSION=').Line } else { "unknown" }
Ok "Java ready: $javaVer"

# ------------------------------ 3. Maven ---------------------------------
Log "--- Step 3/5: Maven $MavenVersion ---"
$mavenHome = Join-Path $ToolsDir "apache-maven-$MavenVersion"
if (Test-Path (Join-Path $mavenHome "bin\mvn.cmd")) {
    Ok "Maven $MavenVersion already installed at $mavenHome - skipping download."
} else {
    $zip = Join-Path $env:TEMP "apache-maven-$MavenVersion-bin.zip"
    $url = "https://archive.apache.org/dist/maven/maven-3/$MavenVersion/binaries/apache-maven-$MavenVersion-bin.zip"
    Log "Downloading $url"
    Invoke-WebRequest -Uri $url -OutFile $zip -ErrorAction Stop
    Log "Extracting to $ToolsDir"
    Expand-Archive -Path $zip -DestinationPath $ToolsDir -Force -ErrorAction Stop
    Remove-Item $zip -Force
    Ok "Maven $MavenVersion installed."
}
Set-UserEnv "MAVEN_HOME" $mavenHome
Set-UserEnv "M2_HOME"    $mavenHome
Add-ToUserPath (Join-Path $mavenHome "bin")
# Remove older Maven versions managed by this script
Get-ChildItem $ToolsDir -Directory -Filter "apache-maven-*" | Where-Object { $_.FullName -ne $mavenHome } | ForEach-Object {
    Log "Removing old Maven: $($_.Name)"; Remove-Item $_.FullName -Recurse -Force
}
$mvnCmd = Join-Path $mavenHome "bin\mvn.cmd"
if (-not (Test-Path $mvnCmd)) { Fail "Maven was not found at $mvnCmd" }
Ok ((& $mvnCmd -version | Select-Object -First 1))

# ---------------------- 4. Dependencies and Chromium ---------------------
Log "--- Step 4/5: Dependencies and Chromium ---"
Push-Location $ProjectDir
try {
    if (Test-Path ".git") { Log "Updating repository (git pull --ff-only)..."; git pull --ff-only }
    Log "Resolving/updating Maven dependencies..."
    & mvn -U -B -q dependency:resolve
    if ($LASTEXITCODE -ne 0) { Fail "Maven dependency resolution failed." }

    Log "Installing/updating Playwright Chromium..."
    & mvn -B exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=install chromium"
    if ($LASTEXITCODE -ne 0) { Fail "Playwright Chromium installation failed." }
    Ok "Chromium ready."

    # ---------------------------- 5. Smoke test ---------------------------
    Log "--- Step 5/5: Running $TestName ---"
    & mvn -B test "-Dtest=$TestName" "-DfailIfNoTests=false"
    if ($LASTEXITCODE -ne 0) { Fail "$TestName failed. Review the log above." }
    Ok "$TestName passed."
} finally { Pop-Location }

Ok "=== Setup completed successfully ==="
Warn "Open a NEW terminal (or restart VS Code) so the environment variables take effect."