package com.teoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCamposDeTextoSelectorCss {
    String home = "file:///" + System.getProperty("user.dir")+ "\\src\\web\\home.html";
    @Test
    public void idSelectorsTest(){
        try (Playwright pw = Playwright.create()){
            BrowserType browserType = pw.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag"));
            //opcion generica
            page.fill("input","first input box that PW finds");

            //encuentra el primer elemento y lo rellena
            page.fill(".form-control","First box with this class");

            //funciona pero no tan bien
            page.fill("form #exampleFormControlInput1","combined");

            //funciona pero es exagerado
            page.fill(":nth-match(.form-control, 2)","Hello there stranger");


        }
    }
}
