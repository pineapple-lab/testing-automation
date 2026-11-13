package com.pap.SPACELOGIK.auth.pom;

import com.pap.core.action.ElementActions;

public class AuthPO {
    private ElementActions actions = new ElementActions();
    private static final String INPUT_EMAIL = ".login-form-children-container [placeholder='Enter your email']";
    private static final String INPUT_PASSWORD = ".login-form-children-container [type='password']";
    private static final String BUTTON_LOGIN = "[type='submit']";


    public void navigateToSystem(String url){
        actions.navigateTo(url);
    }

    public void enterEmail (String email){
        actions.type(INPUT_EMAIL, email);
    }
    public void enterPassword(String password){
        actions.type(INPUT_PASSWORD, password);
    }
    public void clickButtonLogin(){
        actions.click(BUTTON_LOGIN);
    }
}
