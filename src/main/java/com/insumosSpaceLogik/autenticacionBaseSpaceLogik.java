package com.insumosSpaceLogik;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class autenticacionBaseSpaceLogik extends variablesIniciadas {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    //protected static String base = "https://space-logic.web.app/react/login";

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(900));
       // Assertions.assertEquals(page.url(), "https://space-logic.web.app/react/login");
       // context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }
   @BeforeEach
       public void createContextAndPage(){
           context = browser.newContext();
           page = context.newPage();
           page.setViewportSize(1366, 768);
    }

    @AfterEach
    void closeContext() {context.close();}
    @AfterAll
    static void closeBrowser() {playwright.close();}
}

