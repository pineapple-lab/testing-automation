package insumosPeppermint;

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
        page.navigate(linkDeNavegacion);
    }

    public void login(){

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
    public void createEvent(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(13)");
        page.click("app-side-bar a:nth-of-type(3)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(titleEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2) textarea");
        kb.insertText(descriptionEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(2)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(urlZoomEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(2) mat-chip-list input");
        kb.insertText(clubEvent);
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1)  .mat-button-wrapper");
        page.click("tbody tr:nth-of-type("+weekEventClub+") td:nth-of-type("+dayEventClub+")");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2)  input:nth-of-type(1)");
        page.click(".clock-face div:nth-of-type("+startTimeEventClub+") button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3)  input:nth-of-type(1)");
        page.click(".clock-face div:nth-of-type("+endTimeEventClub+") button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-publish-status-flow button:nth-of-type(3)");
        page.click("mat-dialog-container div:nth-of-type(2) button:nth-of-type(1)");
    }
    public void crearClub(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(13)");
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
    public void crearLesson(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(1)");
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click(".cdk-overlay-pane button:nth-of-type(13)");
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
}
