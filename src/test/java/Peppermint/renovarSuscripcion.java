package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

public class renovarSuscripcion extends robotBasePeppermint {
    @Test
    public void iniciarRenovacion(){
        ejecutar=400;
        linkDeNavegacion="http://localhost:4200/";

        Keyboard kb = page.keyboard();
        //iniciarContexto();
        iniciarNavegacion();
        for(contador = 0; contador <= ejecutar; ejecutar++){
            //iniciarVariablesLogin();
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
