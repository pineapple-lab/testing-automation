package com.pap.SPACELOGIK.base;
import com.pap.core.util.GeneratorData;
import com.pap.SPACELOGIK.auth.data.AuthData;
import com.pap.SPACELOGIK.auth.task.AuthTask;
import com.pap.SPACELOGIK.config.SPACELOGIKConfig;
import com.pap.core.browser.instance.PlaywrightManager;
import com.pap.core.util.ConsoleMessage;
import com.pap.core.util.ExecutionUtils;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    protected static String URL;
    protected ConsoleMessage console;
    protected ExecutionUtils utils;
    protected AuthData authData;
    protected AuthTask authTask;
    protected ExecutionUtils run;
    protected CustomAssertions assertion;
    protected SpacelogikDataGenerator data;
    @BeforeEach
    void setUp(TestInfo testInfo) {
        PlaywrightManager.initBrowser();
        URL = SPACELOGIKConfig.getUrl() + "/login";
        console = new ConsoleMessage();
        utils = new ExecutionUtils();
        authData = new AuthData();
        authTask = new AuthTask();
        run = new ExecutionUtils();
        assertion = new CustomAssertions();
        console.messageStartTest(testInfo.getDisplayName());
        long seed = Long.getLong("seed", System.currentTimeMillis());
        System.out.println("Seed usada: " + seed);
        data = new SpacelogikDataGenerator(new GeneratorData(seed));
    }

    @AfterEach
    void tearDown() {
        console.messageEndTest();
        PlaywrightManager.quit();
    }
}
