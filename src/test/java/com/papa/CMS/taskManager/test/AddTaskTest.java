package com.papa.CMS.taskManager.test;

import com.papa.CMS.base.BaseTest;
import com.papa.CMS.navigation.task.NavigationTask;
import com.papa.CMS.taskManager.data.TaskManagerData;
import com.papa.CMS.taskManager.task.AddTaskTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddTaskTest extends BaseTest {
    NavigationTask navTask = new NavigationTask();
    TaskManagerData taskData = new TaskManagerData();
    AddTaskTask addTask = new AddTaskTask();
    @DisplayName("Create task happy path test_001")
    @Test
    @Tag("regresion")
    void test_pineappleCMS001_createTask(){
        int quantityTask = 3;
        int quantityImage = 5;
        run.runSafely(()->{
        authTask.enterToSystem(URL);
        authTask.loginToSystem(authData.userTest, authData.passwordTest);
        navTask.goToTaskManagmentMenu();
        addTask.goProject();
        for(int i=1; i<=quantityTask; i++) {
            String taskName = taskData.getTaskName();
            addTask.createTask(taskName, taskData.getTaskDescription(), quantityImage, taskData.getImage());
            assertions.assertTextExistsInList(addTask.getFirstColumnTaskTitles(taskName), taskName);
            console.printProgress("Progress",i, quantityTask);
            }
        });
    }
}
