package com.pap.SPACELOGIK.auth.pom;

import com.pap.core.action.ElementActions;

public class AuthPO {
    private ElementActions actions = new ElementActions();
    private final String inputEmail = ".login-form-children-container [placeholder='Enter your email']";
    private final String inputPassword = ".login-form-children-container [type='password']";
    private final String buttonLoggin = "[type='submit']";
2

    public void navigateToSystem(String url){
        actions.navigateTo(url);
    }

    public void enterEmail (String email){
        actions.type(inputEmail, email);
    }
    public void enterPassword(String password){
        actions.type(inputPassword, password);
    }
    public void clickButtonLogin(){
        actions.click(buttonLoggin);
    }
}
