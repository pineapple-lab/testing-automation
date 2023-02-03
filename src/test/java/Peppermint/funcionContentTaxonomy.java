package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

public class funcionContentTaxonomy extends robotBasePeppermint {

    @Test
    public void validacionCrearTaxonomy(){
        iniciarNavegacion();
        login();
        crearCategory();R
    }

    public void crearCategory(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(13)");
        page.click("mat-nav-list a:nth-of-type(11)");
        page.click("text=Content taxonomy");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText("prueba"); //hardcode falta conexion con bd
        page.click("form mat-dialog-content .mat-button-wrapper");
        page.focus("form mat-dialog-content  .ng-star-inserted mat-form-field input");
        kb.insertText("prueba"); //hardcode falta conexion con bd
        page.click("form mat-dialog-actions button:nth-of-type(2)");
    }
}
