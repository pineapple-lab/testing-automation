package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionWorkshopManagment extends robotBasePeppermint {
    @Test
    public void validarCrearWorkshop(){
        iniciarNavegacion();
        login();
        iniciarVariablesCrearWorkshop();
        crearWorkshop();
    }

    public void crearWorkshop(){
        Keyboard kb = page.keyboard();
        page.click("text=My Stuff");
        page.click("text=Dashboard");
        page.click("text=My Stuff");
        page.click("text=Admin Area");
        page.click("a:nth-of-type(5)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.focus(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-mat-form-field input");
        kb.insertText(titleWorkshop);
        page.click(".ng-star-inserted app-select-creator");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-text-box quill-editor > div:nth-of-type(2)");
        kb.insertText(descriptionWorkshop);
        page.click(".ng-star-inserted .mat-chip-list-wrapper");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagWorkshop+")");
        page.click(".ng-star-inserted app-generic-selects > div > div > p");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) quill-editor >div:nth-of-type(2)");
        kb.insertText(targetAudienceWorkshop);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) quill-editor >div:nth-of-type(2)");
        kb.insertText(learningObjectiveWorkshop);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(3) quill-editor >div:nth-of-type(2)");
        kb.insertText(whatDoYouNeed);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(1)");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+purposeWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(2)");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+skillsWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(3)");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+physicalActvityWorkshop+")");
        page.click("form > div:nth-of-type(1) button");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) button");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(2) button");
        page.click("form > div:nth-of-type(3) > div:nth-of-type(1) button");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
        kb.insertText(questionWorkshop);
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
        kb.insertText(answerWorkshop);
        page.click("form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+reviewerWorkshop+")");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
        kb.insertText(reviewWorkshop);
        page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.click("form > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-list app-generic-selects > div > div app-select-creator");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+studentWorkshop+")");
        page.click("form > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-list textarea ");
        kb.insertText(descriptionWorkshop);
        //page.click("orm > div:nth-of-type(2) > div:nth-of-type(2) button");

    }
}
