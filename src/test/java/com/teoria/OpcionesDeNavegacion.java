package com.teoria;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpcionesDeNavegacion extends ScriptBase {
    @Test
    public void navigationOptions() {
        page.navigate(home, new Page.NavigateOptions()
                .setTimeout(0)

                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );
        page.goBack();
        page.goForward();
        Assertions.assertEquals(page.title(), "Home Page");
    }

}
