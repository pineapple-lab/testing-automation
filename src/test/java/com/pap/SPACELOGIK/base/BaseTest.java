package com.pap.SPACELOGIK.base;
import com.pap.CMS.auth.data.AuthData;
import com.pap.CMS.auth.task.AuthTask;
import com.pap.CMS.config.CMSConfig;
import com.pap.SPACELOGIK.config.SPACELOGIKConfig;
import com.pap.core.browser.instance.PlaywrightManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    protected static String URL;
    protected ConsoleMessage console;
    protected TestExecutionUtils utils;
    protected AuthData authData;
    protected AuthTask authTask;
    @BeforeEach
    void setUp(TestInfo testInfo) {
        PlaywrightManager.initBrowser();
        URL = SPACELOGIKConfig.getUrl() + "/login";
        console = new ConsoleMessage();
        utils = new TestExecutionUtils();
        authData = new AuthData();
        authTask = new AuthTask();
        console.messageStartTest(testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown() {
        console.messageEndTest();
        PlaywrightManager.quit();
    }
}
