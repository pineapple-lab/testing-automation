package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionEventManagment extends robotBasePeppermint {
    @Test
    public void validacionCreateEvent(){
        iniciarNavegacion();
        iniciarVariablesEvent();
        login();
        createEvent();
        page.focus("app-root");
        Assertions.assertTrue(page.isVisible("text=The event was created successfully"));
    }
    @Test
    public void validacionDeleteEvent(){
        iniciarNavegacion();
        iniciarVariablesEvent();
        login();
        createEvent();
        deleteEvent();
        page.focus("app-root");
        assertions="text=Item deleted successfully";
        Assertions.assertTrue(page.isVisible(assertions));
        page.focus("tbody");
        assertions = "text="+titleEvent;
        Assertions.assertFalse(page.isVisible(assertions));
    }

    public void deleteEvent(){
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search input");
        kb.insertText(titleEvent);
        page.click("tbody tr:last-child td:last-child button:nth-of-type(2)");
        page.click("app-alert div > div:nth-of-type(3) button:nth-of-type(2)");
    }

}
