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
}