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
    public void vaidacionCrearClub(){
        System.out.println("Iniciando caso de prueba...");
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarVariablesCrearClub();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarNavegacion();
            login();
            crearClub();
            assertions = "text=The club was created successfully";
            page.waitForSelector("app-informative-notification");
            page.focus("app-informative-notification");
            sqlGuardarCasoSiFallaCrearClub();
            Assertions.assertTrue(page.isVisible(assertions));
            assertions="text="+titleClub;
            page.focus("tbody");
            sqlGuardarCasoSiFallaCrearClub();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }
}
