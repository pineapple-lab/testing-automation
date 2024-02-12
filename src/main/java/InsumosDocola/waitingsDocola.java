package InsumosDocola;


public class waitingsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
    public void waitingJoinsSelectorStep1(int rol){
        page.waitForSelector(selector.firstNameRegister);
        page.waitForSelector(selector.lastNameRegister);
        page.waitForSelector(selector.emailRegister);
        page.waitForSelector(selector.rolRegister(rol));
    }
    public void waitingJoinSelectorStep2(){
        page.waitForSelector(selector.passwordRegister);
        page.waitForSelector(selector.passwordConfirmationRegister);
    }
    public void waitingJoinSelectorStep3(){
        page.waitForSelector(selector.termsAndConditionsRegister);
        page.waitForSelector(selector.captchaRegister);
    }
    public void waitingOnboardingSelectorContentProviderStep1(){
        page.waitForSelector(selector.companyNameClinicianOnboarding);
        page.waitForSelector(selector.webSiteClinicianOnboarding);
        page.waitForSelector(selector.nextButtonClinicianOnboardingStep1);
    }
    public void waitingOnboardingSelectorContentProviderStep2(){
        page.waitForSelector(selector.skipForNowVerifyPhone);
    }
}
