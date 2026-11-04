package com.pap.CMS.navigation.pom;
import com.pap.core.action.ElementActions;
import com.pap.core.browser.instance.PlaywrightManager;

public class NavigationPO {
    private ElementActions actions = new ElementActions();
    private final String taskManagmentNavButton = "[data-testid='nav-tasks']";

    public void clickTaskManagmentNavButton (){
        actions.click(taskManagmentNavButton);
    }
}
