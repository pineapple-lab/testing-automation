package com.pap.CMS.taskManager.task;

import com.pap.CMS.taskManager.pom.AddTaskPO;

public class AddTaskTask {
    AddTaskPO taskPO = new AddTaskPO();

    public void createTask(int cant, String title, String description){
        taskPO.clickButtonEnterProject();
        for(int i =1; i<=cant; i++){
            taskPO.clickButtonColumnAddTask();
            taskPO.typeInputTaskTitle(title);
            taskPO.clickButtonOpenDescriptionInput();
            taskPO.typeInputTaskDescription(description);
            taskPO.clickButtonTaskSave();
        }
    }
}
