package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionLogin extends robotBasePeppermint {
    @Test
    public void validacionLogin(){
        iniciarNavegacion();
        login();
        page.focus("app-header div:nth-of-type(2) button:nth-of-type(3)");
        page.focus("app-root");
        Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
    }
}
