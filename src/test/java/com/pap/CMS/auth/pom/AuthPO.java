package com.pap.CMS.auth.pom;

import com.pap.core.action.ElementActions;
import com.pap.core.browser.instance.PlaywrightManager;

public class AuthPO {
    private ElementActions actions = new ElementActions();
    private static final String USERNAME_INPUT = "[data-testid='login-email-input']";
    private static final String PASSWORD_INPUT = "[data-testid='login-password-input']";
    private static final String LOGIN_BUTTON = "[data-testid='login-submit-btn']";

    public void navigateTo(String url){
        actions.navigateTo(url);
    }
    public void enterUsername(String user){
        actions.type(USERNAME_INPUT, user);
    }
    public void enterPassword(String password){
        actions.type(PASSWORD_INPUT, password);
    }
    public void clickLoginButton(){
        actions.click(LOGIN_BUTTON);
    }
}
