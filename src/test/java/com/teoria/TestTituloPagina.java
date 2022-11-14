package com.teoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTituloPagina {
    String home = "file:///" + System.getProperty("user.dir")+ "\\src\\web\\home.html";
    @Test
    public void testSelectorTest(){
        try(Playwright pw = Playwright.create();) {
            BrowserType browserType = pw.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            page.click("text=More Info");
            assertEquals(page.title(), "Advantages");

            }
        }
     @ParameterizedTest
     @ValueSource(strings = {
            "text = More Info",
            "text = more info",
            "'More info'"})
    public void textSelectorsTestParametrized(String stringSelector) {
        try(Playwright pw = Playwright.create()){
            BrowserType browserType = pw.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);
            page.click(stringSelector);
            assertEquals(page.title(), "Advantages");
        }
    }
    }


