package InsumosDocola;
public class WaitingsDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    public void waitingLoginSelectors(){
        page.waitForSelector(selector.loginEmail);
        page.waitForSelector(selector.loginPassword);
        page.waitForSelector(selector.loginButton);
    }
    public void waitingLoginSelectorIncorrectCredentials(){
        page.waitForSelector(selector.loginIncorrectCredentials);
    }
    public void waitingJoinsSelectorStep1(int rol){
        page.waitForSelector(selector.registerFirstName);
        page.waitForSelector(selector.registerLastName);
        page.waitForSelector(selector.email);
        page.waitForSelector(selector.rolRegister(rol));
    }
    public void waitingJoinSelectorStep2(){
        page.waitForSelector(selector.registerPassword);
        page.waitForSelector(selector.registerPasswordConfirmation);
    }
    public void waitingJoinSelectorStep3(){
        page.waitForSelector(selector.registerTermsAndConditions);
        page.waitForSelector(selector.registerCaptchat);
    }
    public void waitingOnboardingSelectorContentProviderStep1(){
        page.waitForSelector(selector.onboardingClinicianCompanyName);
        page.waitForSelector(selector.clinicianOnboardingWebSite);
        page.waitForSelector(selector.onboardingClinicianNextButtonStep1);
    }
    public void waitingOnboardingSelectorContentProviderStep2(){
        page.waitForSelector(selector.VerifyPhoneSkipForNow);
    }
    public void waitingCreateUploadFileSelectorsStep1(){
        page.waitForSelector(selector.contentTitle);
        page.waitForSelector(selector.contentDescription);
        //page.waitForSelector(selector.contentUploadFile);
        page.waitForSelector(selector.contentButtonContinue);
    }
    public void waitingConfigurationStepSelector() {
        page.waitForSelector(selector.contentTagICD10Type);
        //page.waitForSelector(selector.contentConfigurationMarketPlace);
        //page.waitForSelector(selector.contentButtonContinue);
    }
    public void waitingPricingStepSelector(){
        page.waitForSelector(selector.contentPricingMonthlyPrice);
        page.waitForSelector(selector.contentPricingYearlyPrice);
        page.waitForSelector(selector.contentButtonContinue);
    }
    public void waitingThumbnailStepSelector(){
        page.waitForSelector(selector.contentThumbnailUnsplash);
        page.waitForSelector(selector.contentThumbnailUploadFile);
    }
    public void waitingUnshplashPopUpSelectors (){
        page.waitForSelector(selector.contentUnsplashCategorie);
        //page.waitForSelector(selector.contentUnsplashSelectButton);
    }
    public void waitingUnsplashPhotos(){
        page.waitForSelector(selector.contentUnsplashPhoto);
    }
}
