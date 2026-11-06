package com.pap.CMS.taskManager.task;

import com.pap.CMS.taskManager.pom.AddTaskPO;

import java.util.List;
public class AddTaskTask {
    AddTaskPO taskPO = new AddTaskPO();

    public void goProject(){
        taskPO.clickButtonEnterProject();
    }
    public void createTask(String title, String description, int quantityImage, String pathfile){
            taskPO.clickButtonColumnAddTask();
            taskPO.typeInputTaskTitle(title);
            taskPO.clickButtonOpenDescriptionInput();
            taskPO.typeInputTaskDescription(description);
            for(int i=1; i<=quantityImage;i++){
            taskPO.uploadImage(pathfile);
            }
            taskPO.clickButtonTaskSave();

    }
    public List<String> getFirstColumnTaskTitles(String text){
       return taskPO.focusFirstColumnTaskTitle(text);
    }
}
