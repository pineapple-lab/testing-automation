package Peppermint;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionEventManagment extends robotBasePeppermint {
    @Test
    public void validacionCreateEvent(){
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionEvent();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces\n");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesEvent();
            System.out.println("\ntitle event: "+titleEvent+"\n");
            createEvent();
            assertions="text=The event was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            Assertions.assertTrue(page.isVisible(assertions));
            searchingElement=titleEvent;
            page.waitForSelector("app-paging-search mat-form-field");
            buscarContenido();
            assertions="text="+titleEvent;
            page.focus("table tbody");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso se ejecuto " + contador + " veces\n");
        }

    }
    @Test
    public void validacionDeleteEvent(){
        Keyboard kb = page.keyboard();
        iniciarNavegacion();
        iniciarVariablesEvent();
        System.out.println(titleEvent);
        login();
        createEvent();
        deleteEvent();
        page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
        assertions="text=Item deleted successfully";
        //Assertions.assertTrue(page.isVisible(assertions));
        page.reload();
        page.focus("table");
        assertions = "text="+titleEvent;
        Assertions.assertFalse(page.isVisible(assertions));
    }



}
