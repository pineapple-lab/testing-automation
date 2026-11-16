package com.pap.CMS.base;

import com.microsoft.playwright.BrowserContext;

import java.util.function.Supplier;

public class ConsoleMessage {

      public void messageStartTest(String nameTest) {
        System.out.println("\n----------------------START TEST-----------------------");
        System.out.println("Execution test: " + nameTest);
    }

    public void messageResultObtained(Object result) {
        messageReport("Result", result);
    }

    public void messageReport(String label, Object result) {
        if (result == null) {
            System.out.println(label + ": nulo");
            return;
        }
        System.out.println(label + ": " + result);
        System.out.println("Tipo: " + result.getClass().getSimpleName());
    }

    public void messageEndTest() {
        System.out.println("\n----------------------END TEST-----------------------");
    }
    private static final String RESET = "\u001B[0m";
    private static final String CYAN_BOLD = "\u001B[1;36m";
    private static final String GREEN_BOLD = "\u001B[1;32m";

    public void printProgress(String label, int current, int total) {
        int width = 20;
        int filled = total == 0 ? 0 : (int) Math.round((double) current / total * width);
        int percent = total == 0 ? 0 : (int) Math.round((double) current / total * 100);
        String bar = "█".repeat(filled) + "░".repeat(width - filled);
        String color = current >= total ? GREEN_BOLD : CYAN_BOLD;

        System.out.println("\n" + color + "▶ " + label + "  [" + bar + "]  "
                + current + " / " + total + "  (" + percent + "%)" + RESET + "\n");
    }
}