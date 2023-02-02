package testEnConstruccionPeppermint;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
import insumosPeppermint.robotBasePeppermint;
import kotlin.annotation.Target;
import org.apache.bcel.generic.FLOAD;
import org.apache.tools.ant.taskdefs.LoadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.function.Consumer;


public class funcionTechniqueManagment extends robotBasePeppermint {
    @Test
    public void validacionCreateTechnique(){
        System.out.println("iniciando caso de prueba...");
        iniciarNavegacion();
        login();
        createTechnique();
        page.focus("app-mat-table");
        assertions="text="+titleTechnique;
        Assertions.assertTrue(page.isVisible(assertions));
    }
    public void createTechnique(){
        System.out.println("Creando technique...");
            Keyboard kb = page.keyboard();
            page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
            page.click(".cdk-overlay-pane button:nth-of-type(2)");
            page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
            page.click(".cdk-overlay-pane button:nth-of-type(13)");
            page.click("app-side-bar a:nth-of-type(2)");
            page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
            iniciarVariablesCrearTechnique();
            //page.click(".image-container:nth-of-type(2)");
            page.locator(".image-container:nth-of-type(2)").click();
             page.onFileChooser( fileChooser ->{
                fileChooser.setFiles(Paths.get(pathVideo));
            } );
            System.out.println(pathVideo);

            /*FileChooser fileChooser = page.waitForFileChooser(()->{
                page.locator(".image-container:nth-of-type(2)").click();
            });
            fileChooser.setFiles(Paths.get(pathVideo));*/

            FileChooser fileChooser1 = page.waitForFileChooser(()->{
                 page.locator(".image-container:nth-of-type(1)").click();
            });
            fileChooser1.setFiles(Paths.get(pathImage));
            page.click(".ma-auto button");
            page.focus("app-movement-form >div>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
            kb.insertText(titleTechnique);
            page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");
            kb.insertText(descriptionTechnique);
            page.click("app-movement-form >div>div>div>div:nth-of-type(3) .width input");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click(".margin-box  app-generic-selects > div > div > p");
            page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(3) mat-form-field");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click("app-admin-top-bar > div button:nth-of-type(3)");
            page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        sqlclose();
    }
}
