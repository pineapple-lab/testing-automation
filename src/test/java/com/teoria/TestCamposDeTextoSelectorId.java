package com.teoria;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCamposDeTextoSelectorId extends ScriptBase{
    @Test
    public void idSelectorsTest(){
            Page page = browser.newPage();
            page.navigate(home);

            page.fill("id=surnameInput","John");
            page.fill("data-test-id=surnameInput","sarah");

            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag"));
        }
    }

