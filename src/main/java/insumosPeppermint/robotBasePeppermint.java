package insumosPeppermint;

import com.microsoft.playwright.Keyboard;

public class robotBasePeppermint extends contextoBasePeppermint {
    public void iniciarNavegacion(){
        page.navigate(linkDeNavegacion);
    }
    public void login(){
        Keyboard kb = page.keyboard();
        page.click("app-header div:nth-of-type(2) button:nth-of-type(1)");
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(1) input");
        kb.insertText(emailLogin);
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input");
        kb.insertText(passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
    }
}
