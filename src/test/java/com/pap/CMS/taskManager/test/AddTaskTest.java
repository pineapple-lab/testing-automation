package com.pap.CMS.taskManager.test;

import com.pap.CMS.auth.data.AuthData;
import com.pap.CMS.auth.task.AuthTask;
import com.pap.CMS.base.BaseTest;
import com.pap.CMS.base.ConsoleMessage;
import com.pap.CMS.base.GeneratorData;
import com.pap.CMS.base.TestExecutionUtils;
import com.pap.CMS.navigation.task.NavigationTask;
import com.pap.CMS.taskManager.data.TaskManagerData;
import com.pap.CMS.taskManager.task.AddTaskTask;
import com.pap.core.verification.CustomAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AddTaskTest extends BaseTest {
    NavigationTask navTask = new NavigationTask();
    TaskManagerData taskData = new TaskManagerData();
    AddTaskTask addTask = new AddTaskTask();
    CustomAssertions assertions = new CustomAssertions();
    @DisplayName("Create task happy path test_001")
    @Test
    @Tag("regresion")
    void test_pineappleCMS001_createTask(){
        int quantityTask = 5;
        int quantityImage = 5;
        utils.runSafely(()->{
        authTask.enterToSystem(URL);
        authTask.loginToSystem(authData.userTest, authData.passwordTest);
        navTask.goToTaskManagmentMenu();
        addTask.goProject();
        for(int i=1; i<=quantityTask; i++) {
            String taskName = taskData.getTaskName();
            addTask.createTask(taskName, taskData.getTaskDescription(), quantityImage, taskData.getImage());
            console.printProgress("Progress",i, quantityTask);
            assertions.assertTextExistsInList(addTask.getFirstColumnTaskTitles(taskName), taskName);
            }
        });
    }
}
