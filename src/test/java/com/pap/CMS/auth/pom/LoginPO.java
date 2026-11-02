package com.pap.CMS.auth.pom;

import com.pap.core.action.ElementActions;
import com.pap.core.browser.instance.PlaywrightManager;

public class LoginPO {
    private ElementActions actions = new ElementActions();
    private final String userInput = "[data-testid='login-email-input']";
    private final String passInput = "[data-testid='login-password-input']";
    private final String loginButton = "[data-testid='login-submit-btn']";

    public void navigateTo(String url){
        PlaywrightManager.getPage().navigate(url);
    }
    public void enterUsername(String user){
        actions.type(userInput, user);
    }
    public void enterPassword(String password){
        actions.type(passInput, password);
    }
    public void clickLoginButton(){
        actions.click(loginButton);
    }
}
