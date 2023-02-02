package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

public class funcionTag extends robotBasePeppermint {

    @Test
    public void validacionCrearTag(){
        iniciarNavegacion();
        login();
        crearTag();

    }

    public void crearTag(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(13)");
        page.click("mat-nav-list a:nth-of-type(12)");
        page.click("mat-nav-list a:nth-of-type(8)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText("esto es una prueba");//falta conexion con la base de datos esto esta hardcodeado
        page.click("mat-dialog-actions button:nth-of-type(2)");

    }
}
