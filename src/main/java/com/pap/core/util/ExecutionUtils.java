package com.pap.core.util;

import com.microsoft.playwright.PlaywrightException;

public class ExecutionUtils {
    public void runSafely(Runnable testSteps) {
        try {
            testSteps.run();
        } catch (PlaywrightException e) {
            if (isBrowserClosed(e)) {
                System.out.println("\nEjecucion detenida por cierre del navegador.");
            } else {
                throw e;
            }
        }
    }

    private boolean isBrowserClosed(PlaywrightException e) {
        String msg = e.getMessage();
        if (msg == null) {
            return false;
        }
        String lower = msg.toLowerCase();
        return lower.contains("target page, context or browser has been closed")
                || lower.contains("target closed")
                || lower.contains("browser has been closed")
                || lower.contains("page closed")
                || lower.contains("connection closed");
    }
}
