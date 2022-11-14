package com.teoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class Inspector {
    Playwright pw;
    Browser browser;

    @Test
    public void inspectrDemo(){
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newContext().newPage();
        page.navigate("https://space-logic.web.app/react/login");
        page.fill("#txtMail","admin");
        page.fill("#txtPassword","pickle30");
        page.click("'LOG IN'");
        page.click("text=Proposals");
        //page.click("#root > div.app-main > div.app-main__outer > div > div > div > div.proposal-list-landlord-button-container > div > button:nth-child(2)");
        page.pause();
        page.click("text=GetStarted");
    }
    @AfterEach
    public void cleanup(){
        pw.close();
    }
}
