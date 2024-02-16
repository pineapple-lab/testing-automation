package InsumosDocola;


public class waitingsDocola extends contextBaseDocola{
    selectorsDocola selector = new selectorsDocola();
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
}
