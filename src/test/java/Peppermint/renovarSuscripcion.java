package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.methodsPeppermint;
import org.junit.jupiter.api.Test;

public class renovarSuscripcion extends methodsPeppermint {
    @Test
    public void iniciarRenovacion(){
        execute=400;
        navigationLink="http://localhost:4200/";

        Keyboard kb = page.keyboard();
        //iniciarContexto();
        startNavigation();
        for(counter = 0; counter <= execute; execute++){
            //startVariablesLogin();
            emailLogin="pineappleuser1683738560616@mailinator.com";
            login();
            page.waitForSelector("text= My workshops");
            if(page.isVisible("mat-dialog-container > app-expired-popup")){
                kb.press("Escape");
                page.click("text=My stuff");
                page.click("text=Account Settings");
                page.click("text=Membership");
                page.click("text=Select");
                logout();
            }else logout();
        }
    }
}
