package InsumosDocola;

public class componentsDocola extends variablesDocola{
    //SELECTORS REGISTER//
    public String singUp = "text=Sign up free";
    public String continueWithEmail = ".border-primary > div > button:nth-of-type(3)";
    public String firstNameRegister = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) mat-form-field input";
    public String lastNameRegister = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) mat-form-field input";
    public String emailRegister = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-form-block-input mat-form-field input";

    public String rolRegister(int rol){
        return "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > mat-card:nth-of-type("+rol+")";
    }
    public String nextButtonRegisterStep1 = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > button";
    public String passwordRegister = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) input";
    public String passwordConfirmationRegister = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) input";
    public String nextButtonRegisterStep2 = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > button";
    public String termsAndConditionsRegister = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-checkbox input";
    public String captchaRegister = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) re-captcha > div > div > iframe";
    public String nextButtonRegisterStep3 = "mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div > button";

    //SELECTORS ONBOARDING CLINICIAN//
    public String companyNameClinicianOnboarding = ".registration-type-padding app-form-block-input:nth-of-type(1) input";
    public String webSiteClinicianOnboarding = ".registration-type-padding app-form-block-input:nth-of-type(2) input";
    public String nextButtonClinicianOnboardingStep1 = ".registration-type-padding button";
    public String skipForNowVerifyPhone = ".registration-type-padding > div > div:nth-of-type(2) > div:nth-of-type(2) > span";
}
