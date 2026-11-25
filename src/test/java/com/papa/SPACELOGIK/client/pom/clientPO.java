package com.papa.SPACELOGIK.client.pom;

import com.papa.core.action.ElementActions;

public class clientPO {
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
}
