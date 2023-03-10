package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionLessonManagment extends robotBasePeppermint {
    @Test
    public void vaidacionCrearLesson(){
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionLesson();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces\n");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesCrearLesson();
            System.out.println("\nTitle lesson: "+titleLesson+"\n");
            crearLesson();
            assertions="text=The lesson was created successfully";
            page.waitForSelector("text=The lesson was created successfully");
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            //Assertions.assertTrue(page.isVisible(assertions));
            searchingElement=titleLesson;
            page.waitForSelector("app-paging-search mat-form-field");
            buscarContenido();
            assertions="text="+titleLesson;
            page.focus("table tbody");
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso se ejecuto " + contador + " veces\n");
        }
    }
}
