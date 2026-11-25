package com.papa.CMS.base;
import com.papa.CMS.auth.data.AuthData;
import com.papa.CMS.auth.task.AuthTask;
import com.papa.CMS.config.CMSConfig;
import com.papa.core.browser.instance.PlaywrightManager;
import com.papa.core.util.ConsoleMessage;
import com.papa.core.util.ExecutionUtils;
import com.papa.core.verification.CustomAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    protected static String URL;
    protected ConsoleMessage console;
    protected ExecutionUtils run;
    protected AuthData authData;
    protected AuthTask authTask;
    protected CustomAssertions assertions;
    @BeforeEach
    void setUp(TestInfo testInfo) {
        PlaywrightManager.initBrowser();
        URL = CMSConfig.getUrl() + "/login";
        console = new ConsoleMessage();
        run = new ExecutionUtils();
        authData = new AuthData();
        authTask = new AuthTask();
        assertions = new CustomAssertions();
        console.messageStartTest(testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown() {
        console.messageEndTest();
        PlaywrightManager.quit();
    }
}
