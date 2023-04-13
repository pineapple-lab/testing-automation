package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionArticleManagment extends robotBasePeppermint {

    @Test
    public void validacionCrearArticle() {
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces\n");
        iniciarNavegacion();
        login();
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearArticle();
                System.out.println("\ntitle article: " + titleArticle + "\n");
                crearArticulo();
                assertions = "text=Techniques added successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleArticle;
                /*page.waitForSelector("app-paging-search mat-form-field");*/
                assertions = "text=The article was created successfully";
                //page.waitForSelector(assertions);
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                //buscarContenido();
                assertions = "text=" + titleArticle;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El caso se ejecuto " + contador + " veces");
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
