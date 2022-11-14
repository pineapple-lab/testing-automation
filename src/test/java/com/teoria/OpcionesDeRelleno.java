package com.teoria;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

public class OpcionesDeRelleno extends ScriptBase{
    @Test
    public void fillOptions() {
        page.navigate(home);
        page.fill("id=exampleMessage", "So I was thinking the other day...",
                                            new Page.FillOptions().setForce(true));
    }
}
