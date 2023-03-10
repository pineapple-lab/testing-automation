package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionTag extends robotBasePeppermint {

    @Test
    public void validacionCrearTag(){
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionTag();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces\n");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesTag();
            System.out.println("\nTitle tag: "+titleTag+"\n");
            crearTag();
            assertions="text=The tag was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            //Assertions.assertTrue(page.isVisible(assertions));
            searchingElement=titleTag;
            page.waitForSelector("app-paging-search mat-form-field");
            //buscarContenido();
            assertions="text="+titleTag;
            page.focus("table tbody ");
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso se ejecuto " + contador + " veces\n");
        }
    }


}
