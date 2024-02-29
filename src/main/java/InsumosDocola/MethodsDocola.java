package InsumosDocola;
import com.microsoft.playwright.ElementHandle;

import java.nio.file.Paths;

public class MethodsDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    QueriesDocola queries = new QueriesDocola();
    GeneratorDocola generate = new GeneratorDocola();
    public void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*printStream.println("\n-----------------------------------------------------------");
        printStream.println("Iniciando ejecucion....");
        printStream.println("-----------------------------------------------------------");*/
        launchBrowser();
        createContextAndPage();
    }
    public void startNavigation(){
        page.navigate(linkNavigation);
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    public void startTest(){
        shouldStopTest = false;
    }
    public void stopTest(){
        shouldStopTest = true;
    }

    public void goToLogin(){
        page.click("text=Login");
    }
    public void login(String email){
        goToLogin();
        System.out.println(email);
        page.fill(selector.loginEmail,email);
        page.fill(selector.loginPassword,password);
        page.click(selector.loginButton);
    }
    public void signOut(){
        ElementHandle targetElement = page.querySelector(selector.menuProfile);
        targetElement.hover();
        page.click(selector.signOut);
    }
    public void goToRegisterForm(){
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
    }
    public void completeloginEmail(){
        page.fill(selector.loginEmail,queries.getEmailUser(joinRol));
    }
    public void completeloginPassword(){
        System.out.println(password);
        page.fill(selector.loginPassword, password);
    }
    public void completeregisterFirstName(String firstName){
        page.fill(selector.registerFirstName,firstName);
    }
    public void completeLastNameARegister(String lastName){
        page.fill(selector.registerLastName,lastName);
    }
    public void completeemail(String email){
        page.fill(selector.email, email);
    }
    public void completeFirstStepRegister(String firstName, String lastName, String email){
        page.fill(selector.registerFirstName,firstName);
        page.fill(selector.registerLastName,lastName);
        page.fill(selector.email,email);
    }
    public void completeSecondStepRegister(){
        page.fill(selector.registerPassword,password);
        page.fill(selector.registerPasswordConfirmation,password);
    }
    public void goToContentCreateForm(){
        page.click(selector.headerMyCoursesButton);
        page.click(selector.createNewContentButton);
        page.click(selector.createContent(generate.generateTypeContent()));
    }
    public void completeContentUploadFile(){
        page.fill(selector.contentTitle, "test");
        page.fill(selector.contentDescription, "test");
        page.locator(selector.contentUpload).setInputFiles(Paths.get(pathImage));
        page.click(selector.contentButtonContinue);
    }
    public void completeContentImportWebContent(){
        page.fill(selector.contentTitle, "test");
        page.fill(selector.contentDescription, "test");
        page.fill(selector.contentUpload,"https://www.youtube.com/embed/myDW_WPRHq0?si=bdkGE69WDFZXf7cj");
        page.click(selector.contentButtonContinue);
    }
    public void completeContentQuiz(){
        page.fill(selector.contentTitle, "test");
        page.fill(selector.contentDescription, "test");
        page.click(selector.contentAddQuestionsQuiz);
        if(typeQuestion == 0){
            typeQuestion=1;
        }
        page.waitForSelector(selector.contentTypeQuestionQuiz(typeQuestion));
        page.click(selector.contentTypeQuestionQuiz(typeQuestion));
        switch (typeQuestion) {
            case 1:
                completeContentQuestionTrueOrFalse();
                break;
            /*case 2:
                break;
            case 3:
                break;*/
        }
        page.waitForTimeout(6000);
        page.click(selector.contentButtonContinue);
    }
    public void completeContentSurvey(){
        page.fill(selector.contentTitle, "test");
        page.fill(selector.contentDescription, "test");
        page.click(selector.contentAddQuestionsQuiz);
        if(typeQuestion == 0){
            typeQuestion=1;
        }
        page.waitForSelector(selector.contentTypeQuestionQuiz(typeQuestion));
        page.click(selector.contentTypeQuestionQuiz(typeQuestion));
        switch (typeQuestion) {
            case 1:
               completeContentQuestionTrueOrFalse();
                break;
            /*case 2:
                break;
            case 3:
                break;*/
        }
        page.waitForTimeout(6000);
        page.click(selector.contentButtonContinue);
    }
    public void completeContentQuestionTrueOrFalse (){
        page.fill(selector.writeaQuestionQuiz, "test");
    }
}
