package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionWorkshopManagment extends robotBasePeppermint {

    @Test
    public void validarCrearWorkshop() {

        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionWorkshop();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces\n");
        iniciarNavegacion();
        login();
        for (contador = 1; contador <= ejecutar; contador++) {
            iniciarVariablesCrearWorkshop();
            System.out.println("\nTitle workshop: "+titleWorkshop+"\n");
            crearWorkshop();
            assertions="text=The workshop was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            //Assertions.assertTrue(page.isVisible(assertions));
            searchingElement=titleWorkshop;
            page.waitForSelector("app-paging-search mat-form-field");
            buscarContenido();
            assertions="text="+titleWorkshop;
            page.focus("table tbody");
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso se ejecuto " + contador + " veces\n");
        }
    }
//"text=The workshop was edited successfully" VALIDACION PARA CUANDO CREE EL CASO PARA VALIDAR EDICION
}
