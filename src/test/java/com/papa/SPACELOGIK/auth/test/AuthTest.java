package com.papa.SPACELOGIK.auth.test;

import com.papa.SPACELOGIK.auth.data.AuthData;
import com.papa.SPACELOGIK.auth.task.AuthTask;
import com.papa.SPACELOGIK.base.BaseTest;
import com.papa.core.util.ExecutionUtils;
import com.papa.core.verification.CustomAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {
    ExecutionUtils run = new ExecutionUtils();
    AuthData data = new AuthData();
    AuthTask task = new AuthTask();
    CustomAssertions assertion = new CustomAssertions();

    @DisplayName("Login sucess test_001")
    @Test
    @Tag("regresion")
    public void testSuccessfullLogin(){
        run.runSafely(()->{
        task.enterSystem(URL);
        task.fillFormLoginAndEnter(data.emailReCompanie, data.password);
        assertion.assertPageUrl("https://spacelogic-development.web.app/tenant-people");
        });
    }
}
