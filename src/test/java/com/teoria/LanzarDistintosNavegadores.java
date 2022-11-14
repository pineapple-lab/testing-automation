package com.teoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LanzarDistintosNavegadores extends ScriptBase{
    Playwright pw;
    Browser browser;
    @ParameterizedTest
    @ValueSource(strings = {
            "chrome",
            "msedge"
    })
    public void chanelDemo(String channel){
        pw = Playwright.create();
        browser=pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel(channel)
                .setHeadless(false)
                .setSlowMo(2000)
        );
        Page page = browser.newContext().newPage();
        page.navigate(home);
    }
}
