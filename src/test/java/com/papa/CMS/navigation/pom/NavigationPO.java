package com.papa.CMS.navigation.pom;
import com.papa.core.action.ElementActions;

public class NavigationPO {
    private ElementActions actions = new ElementActions();
    private final String taskManagmentNavButton = "[data-testid='nav-tasks']";

    public void clickTaskManagmentNavButton (){
        actions.click(taskManagmentNavButton);
    }
}
