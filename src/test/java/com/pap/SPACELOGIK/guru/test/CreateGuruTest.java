package com.pap.SPACELOGIK.guru.test;

import com.pap.SPACELOGIK.base.BaseTest;
import com.pap.SPACELOGIK.guru.data.CreateGuruData;
import com.pap.SPACELOGIK.guru.task.CreateGuruTask;
import com.pap.SPACELOGIK.search.task.RePeopleSearchTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CreateGuruTest extends BaseTest {
    CreateGuruTask createTask = new CreateGuruTask();
    RePeopleSearchTask search = new RePeopleSearchTask();
    @DisplayName("Create guru transaction success - test001")
    @Test
    @Tag("regresion")
    public void testCreateGuruTransactionSuccess(){
        int quantityCreate = 1;
        run.runSafely(()->{
            authTask.enterSystem(URL);
            authTask.fillFormLoginAndEnter(authData.emailReCompanie, authData.password);
            for (int i = 1; i<=quantityCreate; i++) {
                CreateGuruData guru = CreateGuruData.random(data).build();
                console.printEmail(guru.getEmail());
                createTask.createNewGuru(guru, guru.getImage());
                assertion.assertTextExistsInList(createTask.getTextModalSuccess(), CreateGuruData.TEXT_SUCCESS_MODAL);
                createTask.acceptSuccessModal();
                search.searchCreateGuru(guru.getEmail());
                assertion.assertTextEquals(createTask.getGuruSkill(guru.getEmail()),CreateGuruData.skillTransaction);
                console.printProgress("Progress",i, quantityCreate);
            }
        });
    }
    @DisplayName("Create guru construction success - test002")
    @Test
    @Tag("regresion")
    public void testCreateGuruConstructionSuccess(){
        int quantityCreate = 1;
        run.runSafely(()->{
            authTask.enterSystem(URL);
            authTask.fillFormLoginAndEnter(authData.emailReCompanie, authData.password);
            for (int i = 1; i<=quantityCreate; i++) {
                CreateGuruData guru = CreateGuruData.random(data).skill("Construction guru ").build();
                console.printEmail(guru.getEmail());
                createTask.createNewGuru(guru, guru.getImage());
                assertion.assertTextExistsInList(createTask.getTextModalSuccess(), CreateGuruData.TEXT_SUCCESS_MODAL);
                createTask.acceptSuccessModal();
                search.searchCreateGuru(guru.getEmail());
                assertion.assertTextEquals(createTask.getGuruSkill(guru.getEmail()), CreateGuruData.skillConstruction);
                console.printProgress("Progress",i, quantityCreate);
            }
        });
    }
    @DisplayName("Create guru workplace success - test003")
    @Test
    @Tag("regresion")
    public void testCreateGuruWorkplaceSuccess(){
        int quantityCreate = 1;
        run.runSafely(()->{
            authTask.enterSystem(URL);
            authTask.fillFormLoginAndEnter(authData.emailReCompanie, authData.password);
            for (int i = 1; i<=quantityCreate; i++) {
                CreateGuruData guru = CreateGuruData.random(data).skill("Workplace guru ").build();
                console.printEmail(guru.getEmail());
                createTask.createNewGuru(guru, guru.getImage());
                assertion.assertTextExistsInList(createTask.getTextModalSuccess(), CreateGuruData.TEXT_SUCCESS_MODAL);
                createTask.acceptSuccessModal();
                search.searchCreateGuru(guru.getEmail());
                assertion.assertTextEquals(createTask.getGuruSkill(guru.getEmail()), CreateGuruData.skillWorkplace);
                console.printProgress("Progress",i, quantityCreate);
            }
        });
    }
    @DisplayName("Create guru assistant success - test004")
    @Test
    @Tag("regresion")
    public void testCreateGuruAssistantSuccess(){
        int quantityCreate = 1;
        run.runSafely(()->{
            authTask.enterSystem(URL);
            authTask.fillFormLoginAndEnter(authData.emailReCompanie, authData.password);
            for (int i = 1; i<=quantityCreate; i++) {
                CreateGuruData guru = CreateGuruData.random(data).skill("Assistant").build();
                console.printEmail(guru.getEmail());
                createTask.createNewGuru(guru, guru.getImage());
                assertion.assertTextExistsInList(createTask.getTextModalSuccess(), CreateGuruData.TEXT_SUCCESS_MODAL);
                createTask.acceptSuccessModal();
                search.searchCreateGuru(guru.getEmail());
                assertion.assertTextEquals(createTask.getGuruSkill(guru.getEmail()), CreateGuruData.skillAssistant);
                console.printProgress("Progress",i, quantityCreate);
            }
        });
    }
}
