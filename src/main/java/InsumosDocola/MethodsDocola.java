package InsumosDocola;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Keyboard;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MethodsDocola extends ContextBaseDocola{
    int typeQuestion = 0;
    SelectorsDocola selector = new SelectorsDocola();
    QueriesDocola queries = new QueriesDocola();
    GeneratorDocola generate = new GeneratorDocola();
    WaitingsDocola waiting = new WaitingsDocola();
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
    public void login(){
        goToLogin();
        if(email == null) {
            email = queries.getUndefinedUser(joinRol);
        }
        page.fill(selector.loginEmail, email);
        page.fill(selector.loginPassword, password);
        page.click(selector.loginButton);
        System.out.println(email);
    }
    public void signOut(){
        ElementHandle targetElement = page.querySelector(selector.menuProfile);
        targetElement.hover();
        page.click(selector.signOut);
    }
    public void completeOnboarding(){
        Keyboard kb = page.keyboard();
        rol = generate.generateRol();
        if(rol==1){
            page.click(selector.verifyPhoneSkipForNow);
        }
        if(rol==2){
            page.click(selector.onboardingCliniciancContinue);
            page.click(selector.onboardingClinicianSelector);
            page.click(selector.onboardingClinicianSelectorOption);
            kb.press("Escape");
            page.click(selector.onboardingCliniciancContinue);
            page.fill(selector.onboardingClinicianPracticeName, "test");
            page.click(selector.onboardingCliniciancContinueStep2);
            page.click(selector.onboardingClinicianPracticeNotForNow);
        }
        if(rol==3) {
            String companyName = generate.generateCompanyName();
            waiting.waitingOnboardingSelectorContentProviderStep1();
            page.fill(selector.onboardingContentProviderCompanyName, companyName);
            String webSite = "https://www."+companyName + ".com";
            page.fill(selector.onboardingContentProviderWebSite, webSite);
            page.click(selector.onboardingContentProviderNextButtonStep1);
            waiting.waitingOnboardingSelectorContentProviderStep2();
            page.click(selector.verifyPhoneSkipForNow);
            page.click(selector.closeGuide);
        }
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
        page.click(selector.createNewResourceButton);
        page.click(selector.createNewContentButton(typeContent));
    }
    public void goToResourceCreateForm(){
        page.click(selector.createResource(generate.generateTypeContent()));
    }
    public void completeContentUploadFile(){
        page.fill(selector.contentTitle, generate.generateContentName());
        page.fill(selector.contentDescription, generate.generateContentDescription());
        page.locator(selector.contentUpload).setInputFiles(Paths.get(generate.generateImage()));
        page.waitForSelector(selector.selectPreviewImage);
        page.click(selector.contentButtonContinue);
    }
    public void completeContentCaptureVideo(){
        page.fill(selector.contentTitle, generate.generateContentName());
        page.fill(selector.contentDescription, generate.generateContentDescription());
        page.locator(selector.contentUpload).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForSelector(selector.selectPreviewImage);
        page.click(selector.contentButtonContinue);
    }
    public void completeContentImportWebContent(){
        page.fill(selector.contentTitle, generate.generateContentName());
        page.fill(selector.contentDescription, generate.generateContentDescription());
        page.fill(selector.contentAddUrl,"https://www.youtube.com/embed/myDW_WPRHq0?si=bdkGE69WDFZXf7cj");
        page.click(selector.contentButtonContinue);
    }
    public void completeContentQuestionTrueOrFalse(){
        page.fill(selector.contentTitleTrueOrFalseQuiz, generate.generateQuestion());
    }
    public void completeContentMultipleChoice(){
        page.fill(selector.contentTitleMultipleChoiceSurvey, generate.generateQuestion());
        page.fill(selector.contentOption1MultipleChoiceSurvey, generate.generateAnswer());
        page.fill(selector.contentOption2MultipleChoiceSurvey, generate.generateAnswer());
    }
    public void completeContentQuiz(){
        page.fill(selector.contentTitle, generate.generateQuestion());
        page.fill(selector.contentDescription, generate.generateContentDescription());
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
        page.click(selector.contentButtonContinue);
    }
    public void completeContentSurvey(){
        page.fill(selector.contentTitle, generate.generateQuestion());
        page.fill(selector.contentDescription, generate.generateContentDescription());
        page.click(selector.contentAddQuestionsQuiz);
        if(typeQuestion == 0){
            typeQuestion=1;
        }
        page.waitForSelector(selector.contentTypeQuestionQuiz(typeQuestion));
        page.click(selector.contentTypeQuestionQuiz(typeQuestion));
        switch (typeQuestion) {
            case 1:
               completeContentMultipleChoice();
                break;
            /*case 2:
                break;
            case 3:
                break;*/
        }
        page.click(selector.contentButtonContinue);
    }
    public void completeContentVr(){
        page.fill(selector.contentTitle, generate.generateContentName());
        page.fill(selector.contentDescription, generate.generateContentDescription());
        page.locator(selector.contentUpload).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForSelector(selector.selectPreviewImage);
        page.click(selector.contentButtonContinue);
    }
    public void completeConfigurationStep() {
        waiting.waitingConfigurationStepSelector();
        for(int tagPosition = 1; tagPosition<=2;tagPosition++) {
            page.click(selector.contentTagICD10Type);
            page.click(selector.contentSelectTagICD10(tagPosition));
            page.click(selector.contentAddTags);
        }
        //page.click(selector.contentConfigurationCMECE);
        //page.click(selector.contentConfigurationMarketPlace);
        page.click(selector.contentButtonContinue);
    }
    public void completePricingStep(){
        waiting.waitingPricingStepSelector();
        page.fill(selector.contentPricingMonthlyPrice,"123");
        //page.fill(selector.contentPricingYearlyPrice,"123");
        page.click(selector.contentButtonContinue);
    }
    public void completeThumbnailStep(){
        waiting.waitingThumbnailStepSelector();
        page.click(selector.contentThumbnailUnsplash);
        waiting.waitingUnshplashPopUpSelectors();
        page.click(selector.contentUnsplashCategorie(generate.generateThumbnailCategory()));
        waiting.waitingUnsplashPhotos();
        page.click(selector.contentUnsplashPhoto(generate.generateThumbnailSplash()));
        page.waitForTimeout(2000);
        page.mouse().wheel(1500,1500);
        page.waitForTimeout(2000);
        page.click(selector.contentUnsplashSelectButton);
        page.waitForTimeout(2000);
        page.mouse().wheel(2000,2000);
        page.click(selector.contentUnsplashSaveButton);
        page.waitForSelector(selector.contentThumbnailDelete);
    }
    public void selectContentCourses(){
        page.waitForTimeout(2000);
        for(int contentPosition = amountOfContent; contentPosition<=amountOfContent;contentPosition++) {
            page.click(selector.courseSelectContent(contentPosition));
        }
    }
    public void selectContentCoursesCollection() {
        page.waitForTimeout(2000);
        for(int contentPosition = amountOfContent; contentPosition<=amountOfContent;contentPosition++) {
            page.click(selector.courseSelectContent(contentPosition));
        }
        for(int contentPosition = amountOfContent; contentPosition<=amountOfContent;contentPosition++) {
            page.click(selector.contentTabCourses);
            page.click(selector.courseSelectContent(contentPosition));
        }
    }
    public void completeContentStep() {
        if(typeContent == 2){
            selectContentCourses();
        }
        if(typeContent == 3){
            selectContentCoursesCollection();
        }
        //page.click(selector.contentConfigurationCMECE);
        //page.click(selector.contentConfigurationMarketPlace);
        page.click(selector.contentButtonContinue);
    }

}
