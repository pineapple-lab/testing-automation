package com.teoria;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SetHttpAuthentication {

    Playwright pw;
    Browser browser;
    String token = "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";

    @Test
    public void setHttpAuthentication(){
        pw = Playwright.create();
        browser = pw.chromium().launch();
        BrowserContext uiContext = browser.newContext();
        Page uiPage = uiContext.newPage();
        uiPage.navigate("https://github.com/Franciscoubillac");
        Assertions.assertTrue(uiPage.isVisible("text=Repositories 0"));

        BrowserContext apiContext = browser.newContext(new Browser.NewContextOptions()
                        .setHttpCredentials("usr","pwd")
                    .setExtraHTTPHeaders(Map.of("Authorization", "token" + token))
        );
        Page webApiPage = apiContext.newPage();
        Response response = webApiPage.navigate("https://github.com/Franciscoubillac");
        System.out.println(response.text());
        Assertions.assertEquals(200, response.status() );
        Assertions.assertTrue(response.text().contains("\"public:repos\": 10"));

    }
    @AfterEach
    public void cleanup(){pw.close();}
}
