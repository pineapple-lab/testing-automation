package com.teoria;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpcionesDeClick extends ScriptBase{
    @Test
    public void  clickOptionsCount(){

        page.navigate(home);
        page.click("#clap-image", new Page.ClickOptions().setClickCount(2));
        Assertions.assertTrue(page.isVisible("#thank-you-2"));
    }
}
