package com.pap.core.monitoring;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;
import com.pap.core.config.ConfigReader;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BackendMonitor {
    private static final Set<String> API_TYPES = Set.of("xhr", "fetch");
    private static final int MAX_BODY_LENGTH = 500;

    private final List<String> errors = new CopyOnWriteArrayList<>();
    private final boolean verbose;

    private BackendMonitor(boolean verbose) {
        this.verbose = verbose;
    }

    public static BackendMonitor attach(BrowserContext context) {
        boolean verbose = Boolean.parseBoolean(ConfigReader.getProperty("monitor.verbose"));
        BackendMonitor monitor = new BackendMonitor(verbose);
        context.onResponse(monitor::handleResponse);
        context.onRequestFailed(monitor::handleRequestFailed);
        return monitor;
    }

    // ---------- Para usar desde los tests ----------

    public List<String> getErrors() {
        return Collections.unmodifiableList(List.copyOf(errors));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void clear() {
        errors.clear();
    }

    public void assertNoErrors() {
        if (errors.isEmpty()) return;
        throw new AssertionError(
                "Se detectaron " + errors.size() + " error(es) de backend/red:\n - "
                        + String.join("\n - ", errors));
    }

    // ---------- Listeners ----------

    private void handleResponse(Response response) {
        Request request = response.request();
        if (!API_TYPES.contains(request.resourceType())) return;

        int status = response.status();
        String method = request.method();
        String url = response.url();

        if (status < 400) {
            if (verbose) System.out.println(method + " ✅ [" + status + "]: " + url);
            return;
        }

        String contentType = response.headerValue("content-type");
        String body = readBody(response);

        errors.add("[" + status + "] " + method + " " + url);

        System.err.println("\n⚠️ BACKEND [" + status + "] " + method + " " + url);
        System.err.println("Tipo de contenido: " + (contentType != null ? contentType : "N/A"));
        System.err.println("Respuesta: " + body);
        System.err.println("-----------------------------------\n");
    }

    private void handleRequestFailed(Request request) {
        if (!API_TYPES.contains(request.resourceType())) return;

        String reason = request.failure();
        if (reason != null && reason.contains("ERR_ABORTED")) return;   // ruido típico al navegar

        String detail = request.method() + " " + request.url()
                + " -> " + (reason != null ? reason : "motivo desconocido");
        errors.add("[RED] " + detail);

        System.err.println("\n🔌 FALLO DE RED " + detail);
        System.err.println("-----------------------------------\n");
    }

    private static String readBody(Response response) {
        try {
            String body = response.text();
            return body.length() > MAX_BODY_LENGTH ? body.substring(0, MAX_BODY_LENGTH) + "..." : body;
        } catch (PlaywrightException e) {
            return "Cuerpo no legible.";
        }
    }
}