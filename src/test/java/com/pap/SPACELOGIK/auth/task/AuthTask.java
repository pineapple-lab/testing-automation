package com.pap.SPACELOGIK.auth.task;

import com.pap.SPACELOGIK.auth.pom.AuthPO;

public class AuthTask {
    private AuthPO auth = new AuthPO();

    public void enterSystem(String url){
        auth.navigateToSystem(url);
    }
    public void fillFormLoginAndEnter(String email, String password){
        auth.enterEmail(email);
        auth.enterPassword(password);
        auth.clickButtonLogin();
    }

}
