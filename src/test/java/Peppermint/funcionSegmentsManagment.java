package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionSegmentsManagment extends robotBasePeppermint {

    @Test
    public void vaidacionCreacionSegment() {
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionSegments();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces\n");
        iniciarNavegacion();
        login();
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearSegments();
                System.out.print("\ntitle segments: " + titleSegments + "\n");
                crearSegment();
                assertions = "text=The segment was created successfully";
                page.waitForSelector("text=The segment was created successfully");
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleSegments;
                page.waitForSelector("app-paging-search mat-form-field");
                buscarContenido();
                assertions = "text=" + titleSegments;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El caso se ejecuto " + contador + " veces\n");
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}