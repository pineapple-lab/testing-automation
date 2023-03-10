package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionContentTaxonomy extends robotBasePeppermint {

    @Test
    public void validacionCrearTaxonomy(){
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionTaxonomy();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces\n");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
           iniciarVariablesTaxonomy();
           System.out.println("\ntitle taxonomy: "+titleCategory+"\n");
           crearTaxonomy();
            assertions="text=The category was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            //Assertions.assertTrue(page.isVisible(assertions));
            searchingElement=titleCategory;
            page.waitForSelector("app-paging-search mat-form-field");
            //buscarContenido();
            assertions="text="+titleCategory;
            page.focus("table tbody ");
            page.reload();
            page.focus("table tbody");
            //page.waitForSelector("text="+titleCategory);
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso se ejecuto " + contador + " veces\n");
        }
    }
}
