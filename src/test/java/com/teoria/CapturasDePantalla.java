package com.teoria;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CapturasDePantalla extends ScriptBase{
    @Test
    public void ScreenshotTest(){
        page.navigate(home);

        page.selectOption("select#contactReason","Bored");
        assertTrue(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason", "Question");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("box.png")));

        //se espera que esta linea falle
        assertFalse(page.isVisible("#boredOption"),
                "The blue box should've disappered after selecting another option");

    }
}
