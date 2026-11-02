package com.pap.CMS.base;
import com.pap.core.browser.instance.PlaywrightManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class BaseTest {
    @BeforeEach
    public void setUp() {
        PlaywrightManager.initBrowser();
    }

    @AfterEach
    public void tearDown() {
        PlaywrightManager.quit();
    }
}
