package com.pap.core.monitoring;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.Response;
import com.pap.core.config.ConfigReader;

import java.util.Set;
public class BackendMonitor {
    private static final Set<String> API_TYPES = Set.of("xhr", "fetch");
    private static final int MAX_BODY_LENGTH = 500;

    private BackendMonitor() {}

    public static void attach(BrowserContext context) {
        boolean verbose = Boolean.parseBoolean(ConfigReader.getProperty("monitor.verbose"));
        context.onResponse(response -> handle(response, verbose));
    }

    private static void handle(Response response, boolean verbose) {
        String type = response.request().resourceType();
        if (!API_TYPES.contains(type)) return;   // ignora imágenes, css, js, etc.

        int status = response.status();
        String method = response.request().method();
        String url = response.url();

        if (status < 400) {
            if (verbose) System.out.println(method + " ✅ [" + status + "]: " + url);
            return;
        }

        String contentType = response.headerValue("content-type");
        System.err.println("\n⚠️ BACKEND [" + status + "] " + method + " " + url);
        System.err.println("Tipo de contenido: " + (contentType != null ? contentType : "N/A"));
        System.err.println("Respuesta: " + readBody(response));
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
