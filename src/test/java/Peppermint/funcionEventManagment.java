package Peppermint;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import insumosPeppermint.casosDePruebaEvent;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionEventManagment extends casosDePruebaEvent {
    @Test
    public void validacionCreateEvent() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionEvent();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearEvent();
    }
        /*@Test
        public void validacionDeleteEvent() {
            Keyboard kb = page.keyboard();
            iniciarNavegacion();
            iniciarVariablesEvent();
            System.out.println(titleEvent);
            login();
            createEvent();
            deleteEvent();
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            assertions = "text=Item deleted successfully";
            //Assertions.assertTrue(page.isVisible(assertions));
            page.reload();
            page.focus("table");
            assertions = "text=" + titleEvent;
            Assertions.assertFalse(page.isVisible(assertions));
        }*/
}