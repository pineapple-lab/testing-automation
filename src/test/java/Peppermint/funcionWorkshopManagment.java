package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionWorkshopManagment extends robotBasePeppermint {

    @Test
    public void validarCrearWorkshop() {

        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionWorkshop();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces");
        iniciarNavegacion();
        login();
        for (contador = 1; contador <= ejecutar; contador++) {
            iniciarVariablesCrearWorkshop();
            System.out.println("title workshop: "+titleWorkshop);
            crearWorkshop();
            page.focus("app-mat-table");
            page.focus("tbody");
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto " + contador + " veces");
        }
    }

}
