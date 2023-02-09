package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionLogin extends robotBasePeppermint {
    @Test
    public void validacionLogin(){
        iniciarNavegacion();
        login();
        page.focus("app-header div:nth-of-type(2) button:nth-of-type(3)");
        page.focus("app-root");
        //Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
    }
    //@Test
    /*public void validacionLogin2(){
        iniciarEjecucionesLogin();
        System.out.println("Iniciando caso de prueba...");
        System.out.println("El caso CA0321 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesLogin();
            iniciarNavegacion();
            login();
            assertions = "text=Login Successfull!";
            page.waitForSelector("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
            page.focus("app-root");
            sqlGuardarCasoSiFallaLogin();
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
            logout();
        }*/
    //}


}
