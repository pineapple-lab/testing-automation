package com.teoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dialogos extends ScriptBase {

    @Test
    public void alertTest(){
        page.navigate(home);

        page.fill("#donation", "50");

       // page.onDialog(dialog -> dialog.accept());

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you!"));
    }

    @Test
    public void confirmTestAccept(){
        page.navigate(home);
        page.fill("#donation","200");

         page.onDialog(dialog -> dialog.accept());

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thanks for confirming"));
    }

    @Test
    public void confirmTestDismiss(){
        page.navigate(home);
        page.fill("#donation", "200");

        page.onDialog(dialog -> dialog.dismiss());

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=It's OK to change one's mind"));
    }

    @Test
    public void promptTest(){
        page.navigate(home);
        page.fill("#donation", "2000");

        page.onDialog(dialog -> dialog.accept("Yes"));

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you for your generosity"));

    }
}
