package com.pap.CMS.auth.test;

import com.pap.CMS.auth.data.DataLogin;
import com.pap.CMS.base.BaseTest;
import com.pap.CMS.auth.task.LoginTask;
import com.pap.CMS.config.CMSConfig;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    DataLogin data = new DataLogin();
    LoginTask loginTask = new LoginTask();
    CustomAssertions assertions = new CustomAssertions();

    @Test
    public void testSuccesfullLogin(){
        String url = CMSConfig.getUrl() + "/login";
        loginTask.loginToSystem(url,data.userTest,data.passwordTest);
        assertions.assertPageUrl("https://app.dev.pineapplelab.com/auth/login");
    }
}
