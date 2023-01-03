package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class funcionTechniqueCreate extends robotBasePeppermint {
    @Test
    public void validacionCreateTechnique(){
        iniciarNavegacion();
        login();
        createTechnique();
        page.focus("app-root");
        Assertions.assertTrue(page.isVisible("text=The event was created successfully"));
    }
    public void createTechnique(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar div:nth-of-type(2) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(2)");
        page.click("body app-header mat-toolbar div:nth-of-type(2) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(13)");
        page.click("app-side-bar a:nth-of-type(3)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText("primera automatizacion");
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2) textarea");
        kb.insertText("primera automatizacion");
        page.focus("app-events-form > div > div > div:nth-of-type(2)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText("www.estoesunapruebaautomatica.com");
        page.focus("app-events-form > div > div > div:nth-of-type(2) mat-chip-list input");
        kb.insertText("Club 1");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1)  .mat-button-wrapper");
        page.click("tbody tr:nth-of-type(3) td:nth-of-type(5)");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2)  input:nth-of-type(1)");
        page.click(".clock-face div:nth-of-type(2) button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3)  input:nth-of-type(1)");
        page.click(".clock-face div:nth-of-type(5) button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-publish-status-flow button:nth-of-type(3)");
        page.click("mat-dialog-container div:nth-of-type(2) button:nth-of-type(1)");
    }
}
