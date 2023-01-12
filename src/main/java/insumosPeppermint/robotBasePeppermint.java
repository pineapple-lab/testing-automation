package insumosPeppermint;

import com.microsoft.playwright.Keyboard;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class robotBasePeppermint extends contextoBasePeppermint {
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

    public void createEvent(){
        Keyboard kb = page.keyboard();
        page.click("body app-header mat-toolbar > div:nth-of-type(3) button:nth-of-type(4)");
        page.click("#cdk-overlay-1 button:nth-of-type(2)");
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
}
