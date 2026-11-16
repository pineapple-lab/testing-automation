package com.pap.SPACELOGIK.createGuru.test;

import com.pap.SPACELOGIK.base.BaseTest;
import com.pap.SPACELOGIK.createGuru.data.CreateGuruData;
import com.pap.SPACELOGIK.createGuru.task.CreateGuruTask;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CreateGuruTest extends BaseTest {

    CreateGuruTask createTask = new CreateGuruTask();
    CustomAssertions asser = new CustomAssertions();
    @DisplayName("Create guru transaction success - test001")
    @Test
    @Tag("regresion")
    public void testCreateGuruTransactionSuccess(){
        CreateGuruData guru = CreateGuruData.builder().build();
        utils.runSafely(()->{
            authTask.enterSystem(URL);
            authTask.fillFormLoginAndEnter(authData.emailReCompanie, authData.password);
            createTask.createNewGuru(guru, guru.getImage());
        });
    }
}
