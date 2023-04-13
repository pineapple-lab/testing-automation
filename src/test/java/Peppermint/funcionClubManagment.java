package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionClubManagment extends robotBasePeppermint {
    @Test
    public void vaidacionCrearClub() {
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionClub();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces\n");
        iniciarNavegacion();
        login();
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearClub();
                System.out.println("\ntitle club: " + titleClub + "\n");
                crearClub();
                assertions = "text=The club was created successfully";
                //page.waitForSelector("text=The club was created successfully");
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleClub;
                //page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                //sqlGuardarCasoSiFallaCrearClub();
                //Assertions.assertTrue(page.isVisible(assertions));
                assertions = "text=" + titleClub;
                //page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                //sqlGuardarCasoSiFallaCrearClub();
                System.out.println("El caso se ejecuto " + contador + " veces\n");
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}