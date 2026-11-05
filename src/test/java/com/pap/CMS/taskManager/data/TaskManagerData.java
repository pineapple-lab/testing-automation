package com.pap.CMS.taskManager.data;

import com.pap.CMS.base.GeneratorData;

public class TaskManagerData {
    GeneratorData generator = new GeneratorData();
    public String getImage(){
        return generator.generateImage();
    }
    public String getTaskName(){
        return generator.generateTaskName();
    }
    public String getTaskDescription(){
        return generator.generateTaskDescription();
    }
}
