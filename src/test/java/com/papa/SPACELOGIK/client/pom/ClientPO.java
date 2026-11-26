package com.papa.SPACELOGIK.client.pom;

import com.papa.core.action.ElementActions;

public class ClientPO {
    ElementActions action = new ElementActions();
    private final static String BUTTON_NEW_CLIENT = ".generic-button.medium.primary.icon-left";
    private final static String RADIOBUTTON_OPTION_CORPORATEACCOUNT ="//h3[text()='Corporate account']/../../..";
    private final static String BUTTON_CONTINUE = "//button[text()='Continue']";
    private final static String BUTTON_UPLOADPHOTO_OPEN = "//button[text()='Edit']";
    private final static String INPUT_PHOTO = "input[name='filepond']";
    private final static String BUTTON_PHOTO_SAVE = "//button[text()='Upload']";
    private final static String INPUT_COMPANYNAME = "input[placeholder='Company name']";
    private final static String SELECT_INDUSTRY = "//div[text()='Select']";
    private static String SELECT_INDUSTRY_OPTION (String industry){
        return "//div[text()='"+industry+"']";
    }
    private final static String INPUT_NAME = "input[placeholder='Enter tenant name']";
    private final static String INPUT_LAST_NAME = "input[placeholder='Enter tenant last name']";
    private final static String SELECT_SALUTATION = "//div[text()='Mr.']/..";
    private static String SELECT_SALUTATION_OPTION (String salutation){
        return "//p[text()='"+salutation+"']/..";
    }
    private final static String INPUT_TITLE = "input[placeholder='Eg. Director']";
    private final static String INPUT_EMAIL = "input[placeholder='name@example.com']";
    private final static String INPUT_PASSWORD = "input[placeholder='Enter your password']";
    private final static String INPUT_CONFIRM_PASSWORD = "input[placeholder='Confirm your password']";
    private final static String INPUT_MOBILE = "//label[text()='Mobile*']/..//input";
    private final static String INPUT_PHONE = "//label[text()='Phone*']/..//input";
    private final static String INPUT_ADRESS = "input[placeholder='Address']";

    public void clickButtonNewClient(){
        action.click(BUTTON_NEW_CLIENT);
    }
    public void clickCorporateAccount(){
        action.click(RADIOBUTTON_OPTION_CORPORATEACCOUNT);
    }
    public void clickButtonContinue(){
        action.click(BUTTON_CONTINUE);
    }
    public void clickButtonOpenUploadPhotoModal(){
        action.click(BUTTON_UPLOADPHOTO_OPEN);
    }
    public void inputPhoto(String filePath){
        action.uploadFile(INPUT_PHOTO, filePath);
    }
    public void clickSavePhoto(){
        action.click(BUTTON_PHOTO_SAVE);
    }
    public void inputCompanyName(String companyName){
        action.type(INPUT_COMPANYNAME, companyName);
    }
    public void clickSelectIndustry(){
        action.click(SELECT_INDUSTRY);
    }
    public void clickOptionIndustry(String industry){
        action.click(SELECT_INDUSTRY_OPTION(industry));
    }
    public void inputNameClient(String nameClient){
        action.type(INPUT_NAME, nameClient);
    }
    public void inputLnameClient(String lastNameClient){
        action.type(INPUT_LAST_NAME, lastNameClient);
    }
    public void clickSelectSalutation(){
        action.click(SELECT_SALUTATION);
    }
    public void clickOptionSalutation(String salutation){
        action.click(SELECT_SALUTATION_OPTION(salutation));
    }
    public void inputTitle(String title){
        action.type(INPUT_TITLE, title);
    }
    public void inputEmail(String email){
        action.type(INPUT_EMAIL, email);
    }
    public void inputPassword(String password){
        action.type(INPUT_PASSWORD, password);
    }
    public void inputConfirmPassword(String confirmPassword){
        action.type(INPUT_CONFIRM_PASSWORD, confirmPassword);
    }
    public void inputMobile(String mobile){
        action.type(INPUT_MOBILE, mobile);
    }
    public void inputPhone(String phone){
        action.type(INPUT_PHONE, phone);
    }
    public void inputAdress(String adress){
        action.type(INPUT_ADRESS, adress);
    }
}
