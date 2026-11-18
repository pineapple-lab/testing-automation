package com.pap.SPACELOGIK.auth.test;

import com.pap.SPACELOGIK.auth.data.AuthData;
import com.pap.SPACELOGIK.auth.task.AuthTask;
import com.pap.SPACELOGIK.base.BaseTest;
import com.pap.core.util.ExecutionUtils;
import com.pap.core.verification.CustomAssertions;
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
