package com.papa.CMS.taskManager.data;

import com.papa.CMS.base.CmsDataGenerator;

public class TaskManagerData {
    CmsDataGenerator data = new CmsDataGenerator();
    public String getImage(){
        return data.image();
    }
    public String getTaskName(){
        return data.taskName();
    }
    public String getTaskDescription(){
        return data.taskDescription();
    }
}
