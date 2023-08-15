package Peppermint;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.options.LoadState;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class peppermintScanner extends robotBasePeppermint {
    @Test
    public void iniciarPeppermintScaner(){
        linkDeNavegacion="http://localhost:4200/";
        emailLogin="pineappleuser1687208170027@mailinator.com";
        passwordLogin="123123aA";
        iniciarNavegacion();
        login();
        scannearDashboard();
        scannearPopupsDashboard();
    }
    public void scannearDashboard(){
        //Titulo dashboard
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(1) > h1");
        //Titulo slider de workshops
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(1)  h2");
        //Boton izquierdo slider workshops
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)");
        //Btoton derecho slider workshops
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(2)");
        //Workshop en rojo
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > h4");
        //Titulo workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > div h2");
        //Barra de progreso workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) mat-progress-bar");
        //Boton go to workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(3) >  button");
        //Three dots button
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(3) >  div app-three-dots");
        //Imagen slider workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card img");
        //Slider workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card");
        //Text area dashboard
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(1) textarea");
        //Boton grabar video
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(1)");
        //Boton grabar audio
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)");
        //Boton subir archivos
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(3)");
        //Assertions
        try{
            StringBuilder errorMessage = new StringBuilder();
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(1) > h1")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(1) > h1\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(1)  h2")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(1)  h2\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(2)")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(2)\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > h4")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > h4\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > div h2")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > div h2\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) mat-progress-bar")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) mat-progress-bar\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(3) >  div app-three-dots")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(3) >  div app-three-dots\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card img")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card img\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(1) textarea")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(1) textarea\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(1)")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(1)\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)\n");
            }
            if(!page.isVisible("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(3)")){
                errorMessage.append("No se encontro el elemento: app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(3)\n");
            }
            if (errorMessage.length() > 0) {
                throw new AssertionError(errorMessage);
            }
        }catch(AssertionError e0){
            System.err.println(e0.getMessage());
        }
    }
    public void scannearPopupsDashboard(){
        //scan popup grabar video
        page.click("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(1)");
        //titulo record video
        page.waitForSelector("app-record-video > mat-card > mat-card-title > span");
        //Boton close popup grabar video
        page.waitForSelector("app-record-video > mat-card > mat-card-title > mat-icon");
        //vista previa
        page.waitForSelector("app-record-video > mat-card > mat-card-content");
        //Boton record
        page.waitForSelector("app-record-video > mat-card > mat-card-actions > button");
        //Assertions
        try{
            StringBuilder errorMessage = new StringBuilder();
            if(!page.isVisible("app-record-video > mat-card > mat-card-title > span")){
                errorMessage.append("No se encontro el elemento: app-record-video > mat-card > mat-card-title > span\n");
            }
            if(!page.isVisible("app-record-video > mat-card > mat-card-title > mat-icon")){
                errorMessage.append("No se encontro el elemento: app-record-video > mat-card > mat-card-title > mat-icon\n");
            }
            if(!page.isVisible("app-record-video > mat-card > mat-card-content")){
                errorMessage.append("No se encontro el elemento: app-record-video > mat-card > mat-card-content\n");
            }
            if(!page.isVisible("app-record-video > mat-card > mat-card-actions > button")){
                errorMessage.append("No se encontro el elemento: app-record-video > mat-card > mat-card-actions > button\n");
            }
            if (errorMessage.length() > 0) {
                throw new AssertionError(errorMessage);
            }
        }catch(AssertionError e1){
            System.err.println(e1.getMessage());
        }
        page.click("app-record-video > mat-card > mat-card-title > mat-icon");
        //scan popup grabar audio
        page.click("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-title span");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-content > app-audio");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-actions > button");

        try{
            StringBuilder errorMessage = new StringBuilder();
            if(!page.isVisible("mat-dialog-container > app-record-audio > mat-card > mat-card-title span")){
                errorMessage.append("No se encontro el elemento: mat-dialog-container > app-record-audio > mat-card > mat-card-title span\n");
            }
            if(!page.isVisible("mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon")){
                errorMessage.append("No se encontro el elemento: mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon\n");
            }
            if(!page.isVisible("mat-dialog-container > app-record-audio > mat-card > mat-card-content > app-audio")){
                errorMessage.append("No se encontro el elemento: mat-dialog-container > app-record-audio > mat-card > mat-card-content > app-audio\n");
            }
            if(!page.isVisible("mat-dialog-container > app-record-audio > mat-card > mat-card-actions > button")){
                errorMessage.append("No se encontro el elemento: mat-dialog-container > app-record-audio > mat-card > mat-card-actions > button\n");
            }
            if (errorMessage.length() > 0) {
                throw new AssertionError(errorMessage);
            }
        }catch(AssertionError e2){
            System.err.println(e2.getMessage());
        }
        page.click("mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon");
    }
    /*public void scannearColumnaDashbord(){
        if()
    }*/
}
