package com.pap.CMS.auth.test;

import com.pap.CMS.auth.data.AuthData;
import com.pap.CMS.base.BaseTest;
import com.pap.CMS.auth.task.AuthTask;
import com.pap.CMS.config.CMSConfig;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class LoginTest extends BaseTest {
    AuthData data = new AuthData();
    AuthTask authTask = new AuthTask();
    CustomAssertions assertions = new CustomAssertions();
    @DisplayName("Login success test_001")
    @Test
    @Tag("regresion")
    public void testSuccesfullLogin(){
        authTask.enterToSystem(URL);
        authTask.loginToSystem(data.userTest,data.passwordTest);
        assertions.assertPageUrl("https://app.dev.pineapplelab.com/auth/login");
    }
}
