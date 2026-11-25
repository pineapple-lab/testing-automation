package com.papa.CMS.taskManager.pom;

import com.papa.core.action.ElementActions;

import java.util.List;

public class AddTaskPO {
    ElementActions actions = new ElementActions();
    private final static String BUTTON_ENTER_PROJECT = ".project-grid > button:nth-of-type(1)";
    private final static String DIVCONTAINER_FIRST_COLUMN_TASK_TITLE = "app-task-board section:first-child div .card-heading strong";
    private final static String BUTTON_COLUMN_ADD_TASK = ".board > .column:nth-of-type(1) button";
    private final static String INPUT_TASK_TITLE = "[formcontrolname=title]";
    private final static String BUTTON_TASK_OPEN_DESCRIPTION_INPUT = ".task-description-view";
    private final static String INPUT_TASK_DESCRIPTION = ".ql-editor.ql-blank";
    private final static String SELECT_TASK_STATUS = "";
    private final static String SELECT_TASK_STATUS_OPTION = "";
    private final static String SELECT_TASK_SPRINT_OPTION = "";
    private final static String SELECT_TASK_ASSIGNE_OTPION = "";
    private final static String BUTTON_TASK_ADD_IMAGE = "app-task-attachments .upload-input";
    private final static String BUTTON_TASK_SAVE = "mat-dialog-actions .mdc-button.mat-primary";


    public void clickButtonEnterProject(){
        actions.click(BUTTON_ENTER_PROJECT);
    }
    public void clickButtonColumnAddTask(){
        actions.click(BUTTON_COLUMN_ADD_TASK);
    }
    public void typeInputTaskTitle(String title){
        actions.type(INPUT_TASK_TITLE, title);
    }
    public void clickButtonOpenDescriptionInput(){
        actions.click(BUTTON_TASK_OPEN_DESCRIPTION_INPUT);
    }
    public void typeInputTaskDescription(String description){
        actions.type(INPUT_TASK_DESCRIPTION, description);
    }
    public void clickButtonTaskSave(){
        actions.click(BUTTON_TASK_SAVE);
    }
    public void uploadImage(String pathFile){
        actions.uploadFile(BUTTON_TASK_ADD_IMAGE,pathFile);
    }
    public List<String> focusFirstColumnTaskTitle(String text){
        actions.waitForText(DIVCONTAINER_FIRST_COLUMN_TASK_TITLE, text);
        return actions.getTexts(DIVCONTAINER_FIRST_COLUMN_TASK_TITLE);
    }
}
