package com.pap.CMS.taskManager.pom;

import com.pap.core.action.ElementActions;

public class AddTaskPO {
    ElementActions actions = new ElementActions();
    private final String buttonEnterProject = ".project-grid > button:nth-of-type(1)";
    private final String buttonColumnAddTask = ".board > .column:nth-of-type(1) button";
    private final String inputTaskTitle = "[formcontrolname=title]";
    private final String buttonTaskOpenDescriptionInput = ".task-description-view";
    private final String inputTaskDescription = ".ql-editor.ql-blank";
    private final String selectTaskStatus = "";
    private final String selectTaskStatusOption = "";
    private final String selectTaskSprintOption = "";
    private final String selectTaskAssigneeOption = "";
    private final String buttonTaskAddImage = "";
    private final String buttonTaskSave = "mat-dialog-actions .mdc-button.mat-primary";

    public void clickButtonEnterProject(){
        actions.click(buttonEnterProject);
    }
    public void clickButtonColumnAddTask(){
        actions.click(buttonColumnAddTask);
    }
    public void typeInputTaskTitle(String title){
        actions.type(inputTaskTitle, title);
    }
    public void clickButtonOpenDescriptionInput(){
        actions.click(buttonTaskOpenDescriptionInput);
    }
    public void typeInputTaskDescription(String description){
        actions.type(inputTaskDescription, description);
    }
    public void clickButtonTaskSave(){
        actions.click(buttonTaskSave);
    }
}
