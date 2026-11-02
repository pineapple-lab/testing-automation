package com.pap.CMS.auth.task;

import com.pap.CMS.auth.pom.LoginPO;

public class LoginTask {
    private LoginPO loginPO = new LoginPO();

    public void loginToSystem(String url, String user, String password){
        loginPO.navigateTo(url);
        loginPO.enterUsername(user);
        loginPO.enterPassword(password);
        loginPO.clickLoginButton();
    }
}
