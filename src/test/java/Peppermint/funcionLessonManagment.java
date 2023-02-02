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
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesCrearLesson();
            crearLesson();
            assertions = "text=The lesson was created successfully";
            page.waitForSelector("app-informative-notification");
            page.focus("app-informative-notification");
            sqlGuardarCasoSiFallaCrearLesson();
            //Assertions.assertTrue(page.isVisible(assertions));
            assertions="text="+titleLesson;
            page.focus("tbody");
            sqlGuardarCasoSiFallaCrearLesson();
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }
}
