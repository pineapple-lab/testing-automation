package com.papa.CMS.auth.test;

import com.papa.CMS.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @DisplayName("Login success test_001")
    @Test
    @Tag("regresion")
    public void testSuccesfullLogin(){
        run.runSafely(()-> {
            authTask.enterToSystem(URL);
            authTask.loginToSystem(authData.userTest, authData.passwordTest);
            assertions.assertPageUrl("https://app.dev.pineapplelab.com/auth/login");
        });
    }
}
