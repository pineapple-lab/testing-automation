package testEnConstruccionPeppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionArticleManagment extends robotBasePeppermint {

    @Test
    public void validacionCrearClub(){
        iniciarVariablesCrearClub();
        iniciarVariablesCrearTechnique();
        iniciarNavegacion();
        login();
        crearArticulo();
    }

    public void crearArticulo(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(13)");
        page.click("a:nth-of-type(6)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field input");
        kb.insertText(titleClub);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorClub+")");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        kb.insertText(descriptionClub);
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagClub+")");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1)  > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText("2");
        page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(2) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryClub+")");
        page.click(".container > div:nth-of-type(2) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("form button");
        page.click("form button:nth-of-type(4)");
        page.locator("app-video input[type=file]").setInputFiles(Paths.get(pathVideo));
        page.pause();

    }

}
