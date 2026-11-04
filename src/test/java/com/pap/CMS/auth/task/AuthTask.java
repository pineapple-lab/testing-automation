package com.pap.CMS.auth.task;

import com.pap.CMS.auth.pom.AuthPO;

public class AuthTask {
    private AuthPO authPO = new AuthPO();

    public void enterToSystem(String url){
        authPO.navigateTo(url);
    }
    public void loginToSystem(String user, String password){
        authPO.enterUsername(user);
        authPO.enterPassword(password);
        authPO.clickLoginButton();
    }
}
