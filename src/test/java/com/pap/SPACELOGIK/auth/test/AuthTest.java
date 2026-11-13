package com.pap.SPACELOGIK.auth.test;

import com.pap.SPACELOGIK.auth.data.AuthData;
import com.pap.SPACELOGIK.auth.task.AuthTask;
import com.pap.SPACELOGIK.base.BaseTest;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {
    AuthData data = new AuthData();
    AuthTask task = new AuthTask();
    CustomAssertions assertion = new CustomAssertions();

    @DisplayName("Login sucess test_001")
    @Test
    @Tag("regresion")
    public void testSuccessfullLogin(){
        utils.runSafely(()->{
        task.enterSystem(URL);
        task.fillFormLoginAndEnter(data.emailGuruTransaction, data.password);
        assertion.assertPageUrl("https://space-logic.web.app/tenant-clients");
        });
    }
}
