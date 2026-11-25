package com.papa.SPACELOGIK.guru.pom;

import com.papa.core.action.ElementActions;

import java.util.List;

public class CreateGuruPO {
    ElementActions actions = new ElementActions();
    private static final String BUTTON_NEW_GURU = "//button[normalize-space()='New user']";
    private static final String SELECT_SALUTATION = ".ReactModal__Content .MuiSelect-select";
    private String SALUTATION_OPTION (String salutationOption){
        return "//li[normalize-space()='"+salutationOption+"']";
    }
    private static final String INPUT_TITLE = "[placeholder='Eg. Director']";
    private static final String INPUT_NAME = "[placeholder='Enter name']";
    private static final String INPUT_LNAME = "[placeholder='Enter last name']";
    private static final String INPUT_EMAIL = "[placeholder='Enter email']";
    private static final String INPUT_MOBILE = "//span[text()='Mobile*']/following-sibling::input";
    private static final String INPUT_PHONE = "//span[text()='Phone*']/following-sibling::input";
    private static final String BUTTON_CONTINUEANDSAVE = ".modal-buttons .primary";
    private static final String SELECT_OFFICE = ".ReactModal__Overlay .generic-select-container [aria-haspopup='listbox']";
    private String OFFICE_OPTION (int officePosition){
        return ".MuiPaper-root > ul > li:nth-of-type("+officePosition+")";
    }
    private static final String SELECT_SKILL = ".ReactModal__Overlay .d-flex [aria-haspopup='listbox']";
    private String SELECT_SKILL_OPTION(String skillOption){
        return "//span[text()='"+skillOption+"']/parent::*/preceding-sibling::label";
    }
    private static final String INPUT_DESCRIPTION = ".generic-text-area";
    private static final String BUTTON_EDIT_IMAGE_PROFILE = ".image-holder button";
    private static final String INPUT_IMAGE_PROFILE = "[name='filepond']";
    private static final String BUTTON_UPLOAD_IMAGE_PROFILE = "//button[normalize-space()='Upload']";
    private static final String BUTTON_REMOVE_IMAGE = "button.delete";
    private static final String POPUP_SUCCESSFULLY = ".ReactModal__Content.modal";
    private static final String BUTTON_MODALSUCCESS_OK= "//button[normalize-space()='Ok']";
    private String GURU_SKILL (String guruEmail){
        return "//*[@title='"+guruEmail+"']/preceding-sibling::*[@data-field='skill_sets'] //span[text()]";
    }

    public void clickButtonNewGuru(){
        actions.click(BUTTON_NEW_GURU);
    }
    public void clickSelectSalutation(){
        actions.click(SELECT_SALUTATION);
    }
    public void clickOptionSalutation(String salutationOption){
        actions.click(SALUTATION_OPTION(salutationOption));
    }
    public void fillInputTitle(String title){
        actions.type(INPUT_TITLE, title);
    }
    public void filLInputName(String name){
        actions.type(INPUT_NAME, name);
    }
    public void fillInputLName(String lname){
        actions.type(INPUT_LNAME, lname);
    }
    public void fillInputEmail(String email){
        actions.type(INPUT_EMAIL, email);
    }
    public void fillInputMobile(String mobile){
        actions.type(INPUT_MOBILE, mobile);
    }
    public void fillInputPhone(String phone){
        actions.type(INPUT_PHONE, phone);
    }
    public void clickButtonContinueAndSave(){
        actions.click(BUTTON_CONTINUEANDSAVE);
    }
    public void clickSelectOffice(){
        actions.click(SELECT_OFFICE);
    }
    public void clickOptionOffice(int officeOption){
        actions.click(OFFICE_OPTION(officeOption));
    }
    public void clickSelectSkill(){
        actions.click(SELECT_SKILL);
    }
    public void clickOptionSkill(String skillOption){
        actions.check(SELECT_SKILL_OPTION(skillOption));
        actions.pressKey("Escape");
    }
    public void fillInputDescription(String description){
        actions.type(INPUT_DESCRIPTION, description);
    }
    public void clickButtonOpenModalEditImageProfile(){
        actions.click(BUTTON_EDIT_IMAGE_PROFILE);
    }
    public void uploadProfileImage(String filePath){
        actions.uploadFile(INPUT_IMAGE_PROFILE, filePath);
    }
    public void clickButtonUploadImage(){
        actions.click(BUTTON_UPLOAD_IMAGE_PROFILE);
    }
    public List<String> getTextModalSuccess(){
        actions.waitForVisible(POPUP_SUCCESSFULLY);
        return actions.getTexts(POPUP_SUCCESSFULLY);
    }
    public void clickButtonOkSuccessModal(){
        actions.click(BUTTON_MODALSUCCESS_OK);
    }
    public void waitForRemoveImageButton(){
        actions.waitForVisible(BUTTON_REMOVE_IMAGE);
    }
    public String getGuruSkill(String guruEmail){
      return actions.getText(GURU_SKILL(guruEmail));
    }
}
