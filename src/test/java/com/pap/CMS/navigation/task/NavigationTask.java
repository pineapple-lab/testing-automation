package com.pap.CMS.navigation.task;

import com.pap.CMS.navigation.pom.NavigationPO;

public class NavigationTask {
    private NavigationPO nav = new NavigationPO();

    public void goToTaskManagmentMenu(){
        nav.clickTaskManagmentNavButton();
    }
}
