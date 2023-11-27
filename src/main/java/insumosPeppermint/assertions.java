package insumosPeppermint;
import insumosPeppermint.methodsPeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;


public class assertions extends queriesSQLcasesFailed {
    @Test
    public void iniciarPeppermintScaner(){
        linkNavigation="http://localhost:4200/";
        emailLogin="pineappleuser1687208170027@mailinator.com";
        passwordLogin="123123aA";
        //iniciarNavegacion();
        //login();
        assertionsDashboard();
        assertionsPopupsDashboard();
    }
    public void assertionsHeader(){
        page.waitForSelector("app-header > mat-toolbar");
        page.waitForSelector("app-header > mat-toolbar > div> a > img:nth-of-type(2)");
        page.waitForSelector("app-header > mat-toolbar > div:nth-of-type(3) > div > span > button:nth-of-type(1)");
        page.waitForSelector("app-header > mat-toolbar > div:nth-of-type(3) > div > span > button:nth-of-type(2)");
        page.waitForSelector("app-header > mat-toolbar > div:nth-of-type(3) > div > span > button:nth-of-type(3)");
        page.waitForSelector("app-header > mat-toolbar > div:nth-of-type(3) > div > button:nth-of-type(1)");
    }
    public void assertionsDashboard(){
        System.out.println("Comprobando elementos del dashboard");
        printStream.println("Comprobando elementos del dashboard");
        //Titulo dashboard
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(1) > h1");
        //Titulo slider de workshops
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(1)  h2");
        page.waitForTimeout(1000);
        if(page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)")){
            //Boton izquierdo slider workshops
            page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)");
            //Btoton derecho slider workshops
            page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(2)");
            Assertions.assertTrue(page.isDisabled("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(1)"));
            Assertions.assertTrue(page.isEnabled("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(1) > div:nth-of-type(2) > button:nth-of-type(2)"));
        }
        //Workshop en rojo
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > h4");
        //Titulo workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(1) > div h2");
        page.waitForTimeout(1000);
        if(page.isVisible("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) mat-progress-bar")==true){
            //Barra de progreso workshop
            page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) mat-progress-bar");
        }
        //Boton go to workshop
        //page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(2) >  button");
        //Three dots button
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card > div:nth-of-type(1) > div:nth-of-type(3) >  div app-three-dots");
        //Imagen slider workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card img");
        //Slider workshop
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(2) > div > div > div > app-slider > div > div:nth-of-type(2) app-workshop-card > mat-card");
        //Text area dashboard
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(1) quill-editor");
        //Boton grabar video
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(1)");
        //Boton grabar audio
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)");
        //Boton subir archivos
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(3)");
        //Boton agregar link
        page.waitForSelector("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(4)");
    }
    public void assertionsPopupsDashboard(){
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
        page.click("app-record-video > mat-card > mat-card-title > mat-icon");
        //scan popup grabar audio
        page.click("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) .bg-primary-darker > div:nth-of-type(2) > button:nth-of-type(2)");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-title span");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-content > app-audio");
        page.waitForSelector("mat-dialog-container > app-record-audio > mat-card > mat-card-actions > button");
        page.click("mat-dialog-container > app-record-audio > mat-card > mat-card-title mat-icon");

    }
    public void assertionsAllWorkshop(){
        page.waitForSelector("app-editorial-workshop > h1");
        page.waitForSelector("app-workshops > div > div:nth-of-type(1) > h2");
        page.waitForSelector("app-workshops > div > div:nth-of-type(2) > app-all-cards");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(1) > div > div > div");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(1) > div > app-three-dots");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(1) > app-dynamic-image");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > h4");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(2) > div:nth-of-type(1) > mat-card-title");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > p");
        page.waitForSelector("app-all-cards > div:nth-of-type(1) > div > div:nth-of-type(1) > app-workshop-card > mat-card > div:nth-of-type(2) > div:nth-of-type(2) > mat-progress-bar");
    }
    public void assertionsInsideWorkshop(){
        page.waitForSelector("app-breadcrumb > ul > li:nth-of-type(1) > a");
        page.waitForSelector("app-breadcrumb > ul > li:nth-of-type(1) > span");
        page.waitForSelector("app-breadcrumb > ul > li:nth-of-type(2) > a");
        page.waitForSelector("app-workshops-details > div > div > div > div  h1");
        page.waitForSelector("app-workshops-details > div > div > div > div > div a:nth-of-type(1)");
        page.waitForSelector("app-workshops-details > div > div > div > div > div a:nth-of-type(2)");
        page.waitForSelector("app-workshops-details > div > div > div  > p");
        page.waitForSelector("app-workshops-details > div > div > div  > h2");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > app-video");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > app-video  vg-player > div:nth-of-type(1) mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > app-video  vg-player > div:nth-of-type(1)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(1) > p");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(2) > h4");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(2) > div > p");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(1)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(2)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(3)");
        page.click("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(1)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group  > div p");
        page.click("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(2)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group  > div p");
        page.click("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group > mat-tab-header > div:nth-of-type(2) > div > div > div:nth-of-type(3)");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > mat-tab-group  > div p");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(3) > h3");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(3) > app-extensible-list");
        if(page.isVisible("text=Reviews")){
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(4) > div:nth-of-type(1) h3");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(4) > div:nth-of-type(2) > app-review-comment > mat-card > div:nth-of-type(1) h2");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(4) > div:nth-of-type(2) > app-review-comment > mat-card > div:nth-of-type(2) b");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(4) > div:nth-of-type(2) > app-review-comment > mat-card > div:nth-of-type(2) > mat-card > span");
        }
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(5) h3");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(5) app-extensible-list");
        if (page.isVisible("text=Member Gallery")) {
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(6) > div:nth-of-type(2) > div > app-project-card > mat-card > div > img");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(6) > div:nth-of-type(2) > div > app-project-card > mat-card > mat-card-content > app-avatar > div > div:nth-of-type(1) > div > h4");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(1) > div:nth-of-type(6) > div:nth-of-type(2) > div > app-project-card > mat-card > mat-card-content > app-avatar > div > div:nth-of-type(2) > span:nth-of-type(1) > b");
        }
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(1)  mat-card > div > button");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(1)  mat-card > div > app-three-dots");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > mat-card-title > b");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(1) > mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(2) > mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(3) > mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(4) > mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(5) > mat-icon");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(1) > span");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(2) > span");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(3) > span");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(4) > span");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(2) > app-about-content > mat-card > div > div:nth-of-type(5) > span");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(3) > h3");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(3) > app-creator");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(3) > app-creator > mat-card > app-avatar");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(3) > app-creator > mat-card > app-avatar");
        page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(3) > app-creator > mat-card > p:nth-of-type(1)");
    }
    public void assertionsPopUpModalitysPaso1(){
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > h4");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > p > b");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(3) > button:nth-of-type(1)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(3) > button:nth-of-type(2)");
    }
    public void assertionsPopUpModalitysPaso2(){
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > h3");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(1) > div > mat-card-title");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(1) > span");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(1) > div > span");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(1) > p");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(1) > span");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(1)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(1) > app-mat-form-field:nth-of-type(1)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(1) > app-mat-form-field:nth-of-type(2)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > span");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > app-mat-form-field");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(1) > mat-card > mat-card-content:nth-of-type(3) > span > mat-icon");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(2) > div button:nth-of-type(1)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(2) > div button:nth-of-type(2)");
        page.waitForSelector("mat-dialog-container  mat-stepper > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > app-guest-invite > div > div:nth-of-type(2) > div > p");
    }
    public void assertionAllArticle(){
        page.waitForSelector("app-editorial-article > h1");
        page.waitForSelector("app-articles > div > div:nth-of-type(1) > h2");
        page.waitForSelector("app-articles > div > div:nth-of-type(2) > app-all-cards");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(1) > div > div");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(1) img");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(2) > mat-card-title:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(2) > mat-card-title:nth-of-type(2)");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(2) > div:nth-of-type(1) > i");
        page.waitForSelector("app-all-cards > div:nth-of-type(4) > div:nth-of-type(1) > div:nth-of-type(1) > app-article-card > mat-card > div:nth-of-type(2) > div:nth-of-type(2) > p");
    }
    public void assertionAllTechnique(){
        page.waitForSelector("app-editorial-technique > h1");
        page.waitForSelector("app-techniques > div > div:nth-of-type(1) > h2");
        page.waitForSelector("app-techniques > div > div:nth-of-type(2) > app-all-cards");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-technique-card > mat-card > div:nth-of-type(1) > div > div");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-technique-card > mat-card > div:nth-of-type(1) img");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-technique-card > mat-card > div:nth-of-type(2) > h4:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-technique-card > mat-card > div:nth-of-type(2) > h4:nth-of-type(2)");
        page.waitForSelector("app-all-cards > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-technique-card > mat-card > div:nth-of-type(2) > div > span");
    }
    public void assertionAlLClub(){
        page.waitForSelector("app-editorial-clubs > h1");
        page.waitForSelector("app-clubs > div > div:nth-of-type(1) > h2");
        page.waitForSelector("app-clubs > div > div:nth-of-type(2) > app-all-cards");
        page.waitForSelector("app-all-cards > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1)");
        page.waitForSelector("app-all-cards > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) > app-club-card > mat-card > div:nth-of-type(1) app-three-dots");
        page.waitForSelector("app-all-cards > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) > app-club-card > mat-card > div:nth-of-type(2) > h4 > b");
        page.waitForSelector("app-all-cards > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) > app-club-card > mat-card > div:nth-of-type(3) > h4");
    }
}
