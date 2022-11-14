package com.teoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBox extends ScriptBase{
    @Test
    public void HowToCheckbox(){
        page.navigate(home);
        page.fill("#exampleFormControlInput1","francisco.croce.u@gmail.com");
        page.fill("#exampleMessage", "Not sure how to say this...");

        page.check("#sendCopy");

        page.click("#submit-contact");
        Assertions.assertTrue(page.isVisible("text=We sent you a copy of your message : Not sure how to say this..."));
    }
}
