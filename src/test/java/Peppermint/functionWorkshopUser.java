package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

public class functionWorkshopUser extends robotBasePeppermint {

    @Test
    public void ValidarWorkshopEnrollmente(){
        iniciarEjecucionesLogin();
        System.out.println("El caso se va a ejecutar " + ejecutar + " veces\n");
        iniciarNavegacion();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesLogin();
            System.out.println("usuario logeado: "+emailLogin);
            login();
            enrollWorkshop();
            page.waitForTimeout(4000);
            logout();
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");

        }
    }

    public void enrollWorkshop(){
        page.waitForTimeout(10000);
        page.navigate("http://localhost:4200/content/workshops");//ESTO ES UNA CHANCHADA HAY QUE REFACTORIZARLO
        page.waitForTimeout(12000);
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2)");
        page.click("app-all-cards .container > div:nth-of-type(2)");
        page.click(".bg-primary-contrast div:nth-of-type(2) > div > mat-card > div > button");
        page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button");
        page.click(".mat-horizontal-content-container > div > div:nth-of-type(2) button:nth-of-type(2)");
        page.click("app-guest-invite .bg-primary-contrast > div p");
    }
}
