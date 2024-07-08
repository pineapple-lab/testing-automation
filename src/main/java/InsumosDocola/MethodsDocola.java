package InsumosDocola;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;
/**
 * Clase que contiene métodos para interactuar con páginas web utilizando Playwright.
 * Extiende ContextBaseDocola para aprovechar la configuración del contexto del navegador.
 */
public class MethodsDocola extends ContextBaseDocola{
    private int typeQuestion = 0;
    private final SelectorsDocola selector = new SelectorsDocola();
    private final QueriesDocola queries = new QueriesDocola();
    private final GeneratorDocola generate = new GeneratorDocola();
    private final WaitingsDocola waiting = new WaitingsDocola();
    GeneratorDocola.EmailInfo emailInfo;
   //Metodos publicos
    public void cleanExecutionDetails(){

        executionDetails = "";
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
    }
    public void goToLogin(){
        page.click("text=Login");
    }
    public void login(){
        goToLogin();
        if(userEmail == null) {
            userEmail = queries.getUndefinedUser(userRole);
        }
        completeLogin();
        System.out.println("Usuario: "+ userEmail +"\n");
    }
    public void signOut(){
        ElementHandle targetElement = page.querySelector(SelectorsDocola.MENU_PROFILE);
        targetElement.hover();
        page.click(SelectorsDocola.SIGN_OUT);
    }
    public void completeOnboarding(){
        Keyboard kb = page.keyboard();
        if(generate.generateRol() == 1){
           completeOnboardingForRole1(kb);
        }
        if(generate.generateRol() == 2){
            completeOnboardingForRole2(kb);
        }
        if(generate.generateRol() == 3) {
            completeOnboardingForRole3(kb);
        }
    }
    public void verifyLoginAndOnboarding(){
        waitForLoginSuccess();
        Assertions.assertTrue(page.isVisible("text=Login successful"));
        queries.saveUser(userEmail);
        completeOnboarding();
        page.waitForSelector(SelectorsDocola.MENU_PROFILE);
    }
    public void goToRegisterForm(){
        page.click(SelectorsDocola.SING_UP);
        page.click(SelectorsDocola.CONTINUE_WITH_EMAIL);
    }
    public void completeRegisterUser(GeneratorDocola.EmailInfo emailInfo){
        startRegistrationFlow();
        completeRegistrationForm(emailInfo);
    }
    public void completeResourceForm(){
        goToContentCreateForm();
        goToResourceCreateForm();
        completeContentCreationProcess();
    }
    public void completeCourseForm(){
        goToContentCreateForm();
        completeCourseSetup();
    }
    public void completeCollectionForm(){
        goToContentCreateForm();
        completeCollectionSetup();
    }
    public void publishContent(){
        page.click(SelectorsDocola.CONTENT_PUBLISH_BUTTON);
        page.waitForTimeout(3000);
    }
    public void completeloginEmail(){
        page.fill(SelectorsDocola.LOGIN_EMAIL,queries.getEmailUser(userRole));
    }
    public void completeloginPassword(){
        page.fill(SelectorsDocola.LOGIN_PASSWORD, userPassword);
    }
    public void completeregisterFirstName(String firstName){
        page.fill(SelectorsDocola.REGISTER_FIRST_NAME,firstName);
    }
    public void completeLastNameARegister(String lastName){
        page.fill(SelectorsDocola.REGISTER_LAST_NAME,lastName);
    }
    public void completeEmail(String email){
        page.fill(SelectorsDocola.EMAIL, email);
    }
    public void completeFirstStepRegister(String firstName, String lastName, String email){
        page.fill(SelectorsDocola.REGISTER_FIRST_NAME,firstName);
        page.fill(SelectorsDocola.REGISTER_LAST_NAME,lastName);
        page.fill(SelectorsDocola.EMAIL,email);
    }
    public void completeSecondStepRegister(){
        page.fill(SelectorsDocola.REGISTER_PASSWORD, userPassword);
        page.fill(SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION, userPassword);
    }
    public void uploadProfilePicture(){
        ElementHandle targetElement = page.querySelector(SelectorsDocola.MENU_PROFILE);
        targetElement.hover();
        page.click(SelectorsDocola.ACCOUNT_SETINGS);
        page.locator(SelectorsDocola.UPLOAD_PROFILE_PICTURE).setInputFiles(Paths.get(generate.generatePictureProfile()));
        page.waitForTimeout(1000);
        page.click(SelectorsDocola.SAVE_CHANGES);
    }
    public void goToContentCreateForm(){
        page.waitForTimeout(2000);
        page.click(SelectorsDocola.HEADER_MY_LIBRARY_BUTTON);
        page.click(SelectorsDocola.CREATE_NEW_RESOURCE_BUTTON);
        page.click(selector.createNewContentButton(contentType));
    }
    public void goToResourceCreateForm(){
        page.click(selector.createResource(generate.generateTypeContent()));
    }
    public void completeResourceStep(){
        completeConfigurationStep();
        completePricingStep();
        completeThumbnailStep();
    }
    //Metodos privados
    private void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*outputStream.println("\n-----------------------------------------------------------");
        outputStream.println("Iniciando ejecucion....");
        outputStream.println("-----------------------------------------------------------");*/
        initializePlaywright();
        setupContextAndPage();
    }
    private void startNavigation(){
        page.navigate(navigationLink);
        System.out.println("Ambiente: "+navigationLink+"\n");
    }
    private void completeLogin(){
        page.fill(SelectorsDocola.LOGIN_EMAIL, userEmail);
        page.fill(SelectorsDocola.LOGIN_PASSWORD, userPassword);
        page.click(SelectorsDocola.LOGIN_BUTTON);
    }
    private void completeOnboardingForRole1(Keyboard kb){
        page.click(SelectorsDocola.VERIFY_PHONE_SKIP_FOR_NOW);
        page.click(SelectorsDocola.CLOSE_GUIDE);
    }
    private void completeOnboardingForRole2(Keyboard kb){
        page.click(SelectorsDocola.ONBOARDING_CLINICIANC_CONTINUE);
        page.click(SelectorsDocola.ONBOARDING_CLINICIAN_SELECTOR);
        page.click(SelectorsDocola.ONBOARDING_CLINICIAN_SELECTOR_OPTION);
        kb.press("Escape");
        page.click(SelectorsDocola.ONBOARDING_CLINICIANC_CONTINUE);
        //page.fill(SelectorsDocola.ONBOARDING_CLINICIAN_PRACTICE_NAME, "test");
        //page.click(SelectorsDocola.ONBOARDING_CLINICIANC_CONTINUE_STEP_2);
        page.click(SelectorsDocola.ONBOARDING_CLINICIAN_PRACTICE_NOT_FOR_NOW);
        page.click(SelectorsDocola.CLOSE_GUIDE);
    }
    private void completeOnboardingForRole3(Keyboard kb){
        String companyName = generate.generateCompanyName();
        waiting.waitingOnboardingSelectorContentProviderStep1();
        page.fill(SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_COMPANY_NAME, companyName);
        String webSite = "https://www."+companyName + ".com";
        page.fill(SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_WEB_SITE, webSite);
        page.click(SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_NEXT_BUTTON_STEP_1);
        waiting.waitingOnboardingSelectorContentProviderStep2();
        page.click(SelectorsDocola.VERIFY_PHONE_SKIP_FOR_NOW);
        page.click(SelectorsDocola.CLOSE_GUIDE);
    }
    private void waitForLoginSuccess(){
        while (true) {
            try {
                page.waitForSelector("text=Login successful");
                break;
            } catch (PlaywrightException e) {}
        }
    }
    private void startRegistrationFlow(){
        page.click(SelectorsDocola.SING_UP);
        page.click(SelectorsDocola.CONTINUE_WITH_EMAIL);
        page.waitForTimeout(1000);
        waiting.waitingJoinsSelectorStep1(generate.generateRol());
    }
    private void completeRegistrationForm(GeneratorDocola.EmailInfo emailInfo){
        page.fill(SelectorsDocola.REGISTER_FIRST_NAME, emailInfo.getFirstName());
        page.fill(SelectorsDocola.REGISTER_LAST_NAME, emailInfo.getLastName());
        page.fill(SelectorsDocola.EMAIL, generate.userEmail);
        page.click(selector.rolRegister(generate.generateRol()));
        page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
        waiting.waitingJoinSelectorStep2();
        page.fill(SelectorsDocola.REGISTER_PASSWORD, userPassword);
        page.fill(SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION, userPassword);
        page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_2);
        waiting.waitingJoinSelectorStep3();
        page.click(SelectorsDocola.REGISTER_TERMS_AND_CONDITIONS);
        page.click(SelectorsDocola.REGISTER_CAPTCHAT);
        page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_3);
    }
   private void completeContentCreationProcess() {
       if (resourceType == null) {
           resourceType = "Upload file";
       }
       switch (resourceType) {
           case "Upload file":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentUploadFile();
               break;
           case "Capture video":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentCaptureVideo();
               break;
           case "Web content":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentImportWebContent();
               break;
           case "Quiz":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentQuiz();
               break;
           case "Survey":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentSurvey();
               break;
           case "VR":
               waiting.waitingCreateUploadFileSelectorsStep1();
               completeContentVr();
               break;
       }
   }
    private void completeCourseSetup(){
        page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
        completeConfigurationStep();
        completeContentStep();
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
        completePricingStep();
        completeThumbnailStep();
    }
    private void completeCollectionSetup(){
        page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
        completeConfigurationStep();
        completeContentStep();
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
        completePricingStep();
        completeThumbnailStep();
    }
    private void completeContentStep() {
        if(contentType == 2){
            selectContentCourses();
        }
        if(contentType == 3){
            selectContentCoursesCollection();
        }
        //page.click(SelectorsDocola.contentConfigurationCMECE);
        //page.click(SelectorsDocola.contentConfigurationMarketPlace);
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void selectContentCourses(){
        page.waitForTimeout(2000);
        for(int contentPosition = contentAmount; contentPosition<= contentAmount; contentPosition++) {
            page.click(selector.courseSelectContent(contentPosition));
        }
    }
    private void selectContentCoursesCollection() {
        page.waitForTimeout(2000);
        for(int contentPosition = contentAmount; contentPosition<= contentAmount; contentPosition++) {
            page.click(selector.courseSelectContent(contentPosition));
        }
        for(int contentPosition = contentAmount; contentPosition<= contentAmount; contentPosition++) {
            page.click(SelectorsDocola.CONTENT_TAB_COURSES);
            page.click(selector.courseSelectContent(contentPosition));
        }
    }
    private void completeContentUploadFile(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
        page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeContentCaptureVideo(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeContentImportWebContent(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.fill(SelectorsDocola.CONTENT_ADD_URL,"https://www.youtube.com/embed/myDW_WPRHq0?si=bdkGE69WDFZXf7cj");
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeContentQuestionTrueOrFalse(){
        page.fill(SelectorsDocola.CONTENT_TITLE_TRUE_OR_FALSE_QUIZ, generate.generateQuestion());
    }
    private void completeContentMultipleChoice(){
        page.fill(SelectorsDocola.CONTENT_TITLE_MULTIPLE_CHOICE_SURVEY, generate.generateQuestion());
        page.fill(SelectorsDocola.CONTENT_OPTION_1_MULTIPLE_CHOICE_SURVEY, generate.generateAnswer());
        page.fill(SelectorsDocola.CONTENT_OPTION_2_MULTIPLE_CHOICE_SURVEY, generate.generateAnswer());
    }
    private void completeContentQuiz(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateQuestion());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.click(SelectorsDocola.CONTENT_ADD_QUESTIONS_QUIZ);
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
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeContentSurvey(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateQuestion());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.click(SelectorsDocola.CONTENT_ADD_QUESTIONS_QUIZ);
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
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeContentVr(){
        page.fill(SelectorsDocola.CONTENT_TITLE, generate.generateContentTitle());
        page.fill(SelectorsDocola.CONTENT_DESCRIPTION, generate.generateContentDescription());
        page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeConfigurationStep() {
        waiting.waitingConfigurationStepSelector();
        for(int tagPosition = 1; tagPosition<=2;tagPosition++) {
            page.click(SelectorsDocola.CONTENT_TAG_ICD_10_TYPE);
            page.click(selector.contentSelectTagICD10(tagPosition));
            page.click(SelectorsDocola.CONTENT_ADD_TAGS);
        }
        page.click(SelectorsDocola.CONTENT_CONFIGURATION_CMECE);
        //page.click(SelectorsDocola.contentConfigurationMarketPlace);
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completePricingStep(){
        waiting.waitingPricingStepSelector();
        page.fill(SelectorsDocola.CONTENT_PRICING_MONTHLY_PRICE,"123");
        //page.fill(SelectorsDocola.contentPricingYearlyPrice,"123");
        page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
    }
    private void completeThumbnailStep(){
        waiting.waitingThumbnailStepSelector();
        page.click(SelectorsDocola.CONTENT_THUMBNAIL_UNSPLASH);
        waiting.waitingUnshplashPopUpSelectors();
        page.click(selector.contentUnsplashCategorie(generate.generateThumbnailCategory()));
        waiting.waitingUnsplashPhotos();
        page.waitForTimeout(4000);
        page.click(selector.contentUnsplashPhoto(generate.generateThumbnailSplash()));
        page.mouse().wheel(1500,1500);
        page.waitForTimeout(1000);
        page.click(SelectorsDocola.CONTENT_UNSPLASH_SELECT_BUTTON);
        page.waitForTimeout(1000);
        page.mouse().wheel(2000,2000);
        page.click(SelectorsDocola.CONTENT_UNSPLASH_SAVE_BUTTON);
        page.waitForSelector(SelectorsDocola.CONTENT_THUMBNAIL_DELETE);
    }
}
