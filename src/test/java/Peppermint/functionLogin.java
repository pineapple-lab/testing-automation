package Peppermint;
import insumosPeppermint.methodsPeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class functionLogin extends methodsPeppermint {
    @Test
    public void validationLogin(){
        startNavigation();
        login();
        page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
        Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
    }
    //@Test
    /*public void validationLogin2(){
        iniciarEjecucionesLogin();
        System.out.println("Iniciando caso de prueba...");
        System.out.println("El caso CA0321 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            startVariablesLogin();
            iniciarNavegacion();
            login();
            assertions = "text=Login Successfull!";
            page.waitForSelector("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
            page.focus("app-root");
            sqlGuardarCasoSiFallaLogin();
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto "+counter+" veces");
            logout();
        }*/
    //}
}
