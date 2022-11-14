package com.teoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeleccionarOpcionesDeLista extends ScriptBase {
    @Test
    public void SelectScenario(){
        page.navigate (home);
        page.selectOption("id=contactReason", "Bored");
        Assertions.assertTrue(page.isVisible( "text=OK, but please make it interesting"));


    }
}
