package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.security.Key;

public class funcionTechniqueManagment extends robotBasePeppermint {
    @Test
    public void validacionCreateTechnique(){
        iniciarNavegacion();
        login();
        createTechnique();
    }

    public void createTechnique(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(2)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(13)");
        page.click("app-side-bar a:nth-of-type(2)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.getByLabel("app-upload-image").setInputFiles(Paths.get("C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\IMAGENPARAPRUEBAS.png"));
        page.click("mat-dialog-container > div > div > button");
    }
}
