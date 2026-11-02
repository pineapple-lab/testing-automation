package com.pap.core.browser.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    private BrowserFactory(){}

    public static Browser getBrowser(Playwright playwright, BrowserType type){
        com.microsoft.playwright.BrowserType.LaunchOptions options = new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false);
        switch (type) {
            case CHROMIUM:
                return playwright.chromium().launch(options);
            case FIREFOX:
                return playwright.firefox().launch(options);
            case WEBKIT:
                return playwright.webkit().launch(options);
            default:
                throw new IllegalArgumentException("Tipo de navegador no soportado: " + type);
        }
    }

}
