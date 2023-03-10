package insumosPeppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class robotBasePeppermint extends consultasSQLCasosFallidos {
    public String formattedDate;
    public void iniciarNavegacion(){
        Keyboard kb = page.keyboard();
        kb.press("Control+KeyN");
        page.navigate(linkDeNavegacion);
    }
    public void login(){
        System.out.println("Iniciando login...");
        Keyboard kb = page.keyboard();
        page.click("mat-toolbar > div:nth-of-type(3) button:nth-of-type(1)");
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(1) input");
        kb.insertText(emailLogin);
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input");
        kb.insertText(passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
    }
    public void logout(){
        if(emailLogin.matches("admin@oluko.com")){
            System.out.println("entre");
            page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
            page.click(".cdk-overlay-pane button:nth-of-type(12)");
        }else {
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(11)");}

    }
    public void buscarContenido(){
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search mat-form-field input");
        kb.insertText(searchingElement);
        kb.press("Enter");
        page.waitForSelector("tbody tr:first-child td:last-child button:last-child");
    }
    public void createTechnique(){
        System.out.println("Creando technique...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(2)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));

        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1)").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleTechnique);
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");
        kb.insertText(descriptionTechnique);
        page.click(".container > div:nth-of-type(2) app-generic-selects");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorTechnique+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagTechnique+")");
        page.click(".margin-box  app-generic-selects > div > div > p");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryTechnique+")");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
    }
    public void crearSegment(){
        System.out.println("Creando Segment...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(3)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1)").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("form>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleSegments);
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        kb.insertText(descriptionSegments);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorSegments+")");
        page.click("form>div>div>div:nth-of-type(3) app-mat-chips");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagSegments+")");
        page.click("app-text-box quill-editor > div:nth-of-type(2)");
        kb.insertText(transcriptSegments);
        page.click("text=+ Add category");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categorySegments+")");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicSegments+")");
        page.click("form > div > div > div:nth-of-type(5) > div > button:nth-of-type(1)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div:nth-of-type(1) > button:nth-of-type(1)");
        page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
    }
    public void crearLesson(){
        System.out.println("Creando Lesson...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(4)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.click(".container > div:nth-of-type(4) button");
        page.click("tbody tr:first-child td:first-child label");
        page.click("app-mat-table > div:nth-of-type(1) > button");
        page.locator("app-upload-media input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleLesson);
        page.click(".container > div:nth-of-type(2) app-select-creator input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionLesson);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagLesson+")");
        page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryLesson+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicLesson+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicLesson+")");*/
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
    }
    public void crearWorkshop(){
        System.out.println("Creando Workshop...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
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
        //page.click(".ng-star-inserted app-generic-selects > div > div > p");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryWorkshop+")");
        //page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        //page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicWorkshop+")");
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) quill-editor >div:nth-of-type(2)");
        kb.insertText(targetAudienceWorkshop);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) quill-editor >div:nth-of-type(2)");
        kb.insertText(learningObjectiveWorkshop);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(3) quill-editor >div:nth-of-type(2)");
        kb.insertText(whatDoYouNeed);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(4) quill-editor >div:nth-of-type(2)");
        kb.insertText(howItWorks);
        page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicWorkshop+")");
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
        page.click("form > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-list app-generic-selects > div input");
        page.click(".cdk-overlay-container mat-option:nth-of-type("+studentWorkshop+")");
        page.click("form > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-list textarea");
        kb.insertText(descriptionWorkshop);
        page.click("form > div:nth-of-type(3) > div:nth-of-type(2) button:nth-of-type(1)");
        page.fill("mat-dialog-container input", addLinksWorkshop);
        page.click("mat-dialog-container div:nth-of-type(2) .material-popup button");
        page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
        page.click("form > div:nth-of-type(1) button");
        page.click("app-course-outlet-form app-course-lesson-form > button");
        page.click("app-course-outlet-form app-course-lesson-form > div:nth-of-type(3) button");
        page.click("mat-dialog-container tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div:nth-of-type(1) > button");
        //page.click("app-drag-drop-sorting div:nth-of-type(2) mat-expansion-panel-header");
        page.click("text=+ Add activities");
        page.click(".cdk-overlay-container button:nth-of-type(1)");
        page.click("text=+ Add activities");
        page.click(".cdk-overlay-container button:nth-of-type(2)");
        page.click("app-course-lesson-form > div:nth-of-type(2)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(1)");
        page.click("app-course-lesson-form > div:nth-of-type(2)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(2)");
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(1) mat-form-field input");
        kb.insertText(titleZoomWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) mat-form-field input");
        kb.insertText(deadlineWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) mat-form-field input");
        page.click(".clock-face__container > div:last-child button");
        page.click(".clock-face__container > div:last-child button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(3) mat-form-field input");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(4) mat-form-field input");
        kb.insertText("1");
        page.fill("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(3) textarea",descriptionZoomWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(4) input");
        kb.insertText(zoomUrlWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
        kb.insertText(activitiesTitleWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
        kb.insertText(activitiesDescriptionWorkshop);
        page.locator("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div input[type=file]").setInputFiles(Paths.get(pathVideo));
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
        kb.insertText(syncUpTitleWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(2) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
        kb.insertText(syncUpDescriptionWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) button");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(1)");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(2)");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(3)");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        page.click("mat-calendar tbody tr:last-child td:last-child");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+instructorSoloWithInstructor+")");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) .mat-checkbox-layout ");
        page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        page.click("mat-calendar tbody tr:last-child td:last-child");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+instructorGroupWithInstructor+")");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) .mat-checkbox-layout");
        page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(1) mat-form-field input");
        kb.insertText(maxStudentsGroupWithInstructor);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(2) mat-form-field input");
        kb.insertText(maxStudentsGroupWithInstructor);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        page.click("mat-calendar tbody tr:last-child td:last-child");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(2) input");
        kb.insertText(maxStudentsGroup);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(2)  input");
        kb.insertText(optimalBuddyGroup);
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
    }
    public void crearArticulo(){
        System.out.println("Creando Articulo...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(6)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field input");
        kb.insertText(titleArticle);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorArticle+")");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        kb.insertText(descriptionArticle);
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagArticle+")");
        page.focus(".container > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1)  > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(estimatedReadTime);
        page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(2) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryArticle+")");
        page.click(".container > div:nth-of-type(2) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicArticle+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("form button");
        page.click("form button:nth-of-type(1)");
        page.click("form button:nth-of-type(2)");
        page.click("form button:nth-of-type(3)");
        page.click("form button:nth-of-type(4)");
        page.click("app-text-box quill-editor > div:nth-of-type(2)");
        kb.insertText(textContent);
        kb.press("Control+Shift+ArrowLeft");
        kb.press("Control+Shift+ArrowLeft");
        kb.press("Control+Shift+ArrowLeft");
        page.click("quill-editor > div:nth-of-type(1) button:nth-of-type(7)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div > button");
        page.focus("app-drag-drop-sorting mat-list > div:nth-of-type(1) input");
        kb.insertText(contentTitle);
        kb.press("Tab");
        page.locator("app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
    }
    public void createEvent(){
        System.out.println("Creando Evento...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(7)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(titleEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2) textarea");
        kb.insertText(descriptionEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(2)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(urlZoomEvent);
        page.click("app-events-form > div > div > div:nth-of-type(2) mat-chip-list");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+clubEvent+")");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) button");
        page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
        page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) button");
        page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
        page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        page.click("app-events-form > div > div > .btn-radius-secondary > div:nth-of-type(2) > div:nth-of-type(3) > mat-form-field");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-publish-status-flow button:nth-of-type(3)");
        page.click("mat-dialog-container div:nth-of-type(2) button:nth-of-type(1)");
    }
    public void deleteEvent(){
        System.out.println("Eliminando evento...");
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search input");
        kb.insertText(titleEvent);
        page.click("tbody tr:first-child td:last-child button:last-child");
        page.click("app-alert div > div:nth-of-type(3) button:nth-of-type(2)");
    }
    public void crearTaxonomy(){
        System.out.println("Creando Taxonomy...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content taxonomy");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleCategory); //hardcode falta conexion con bd
        page.click("form mat-dialog-content .mat-button-wrapper");
        page.focus("form mat-dialog-content  .ng-star-inserted mat-form-field input");
        kb.insertText(titleTopic); //hardcode falta conexion con bd
        page.click("text=+ Add subtopic");
        page.click("mat-dialog-content > div:nth-of-type(2) .subTopic mat-form-field");
        kb.insertText(titleSubTopic);
        page.click("form mat-dialog-actions button:nth-of-type(2)");
    }
    public void crearTag(){
        System.out.println("Creando Tag...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content tags");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleTag);
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.waitForSelector("mat-chip");
        page.click("mat-dialog-actions button:nth-of-type(2)");
    }
    public void crearClub(){
        System.out.println("Creando club...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("text=Editorial management"))==false) {
            page.click("text=My Stuff");
            page.click("text=Dashboard");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(13)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".image-container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleClub);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorClub+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionClub);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagClub+")");
        page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryClub+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("app-admin-top-bar > div button:nth-of-type(3)");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");

    }
}
