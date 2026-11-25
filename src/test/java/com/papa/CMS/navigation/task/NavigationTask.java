package com.papa.CMS.navigation.task;

import com.papa.CMS.navigation.pom.NavigationPO;

public class NavigationTask {
    private NavigationPO nav = new NavigationPO();

    public void goToTaskManagmentMenu(){
        nav.clickTaskManagmentNavButton();
    }
}
