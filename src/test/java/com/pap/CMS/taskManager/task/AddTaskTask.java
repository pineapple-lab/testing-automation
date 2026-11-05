package com.pap.CMS.taskManager.task;

import com.pap.CMS.taskManager.pom.AddTaskPO;

public class AddTaskTask {
    AddTaskPO taskPO = new AddTaskPO();

    public void goProject(){
        taskPO.clickButtonEnterProject();
    }
    public void createTask(String title, String description){
            taskPO.clickButtonColumnAddTask();
            taskPO.typeInputTaskTitle(title);
            taskPO.clickButtonOpenDescriptionInput();
            taskPO.typeInputTaskDescription(description);
            taskPO.clickButtonTaskSave();

    }
}
