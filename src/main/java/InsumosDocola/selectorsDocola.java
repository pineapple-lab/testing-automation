package InsumosDocola;

public class selectorsDocola extends variablesDocola{
    //SELECTORS CLASS AND COMPONENTS
    public String selectForm = "form > ";
    public String selectAppRegister = "app-register ";
    public String selectMatStepper = "mat-stepper > ";
    public String selectRegistrationTypePadding= ".registration-type-padding ";
    //SELECTORS WARNING
    public String loginIncorrectCredentials = "text=invalid_user_or_password";
    //SELECTORS LOGIN
    public String selectFormLogin = "form > div:nth-of-type(2) > div:nth-of-type(2) > ";
    public String loginEmail = selectFormLogin+"app-form-block-input:nth-of-type(1) input";
    public String loginPassword = selectFormLogin+"app-form-block-input:nth-of-type(2) input";
    public String loginButton = selectForm+"div:nth-of-type(2) > div:nth-of-type(3) button";
    //SELECTORS REGISTER//
    public String singUp = "text=Sign up free";
    public String continueWithEmail = ".border-primary > div > button:nth-of-type(3)";
    public String selectFormRegisterStep1TopDiv = selectAppRegister+selectMatStepper+"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public String selectFormRegisterStep1BottomDiv = selectAppRegister+selectMatStepper+"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > ";
    public String selectFormRegisterStep2 = selectMatStepper+"div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public String selectFormRegisterStep3 = selectMatStepper+"div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) ";
    public String registerFirstName = selectFormRegisterStep1TopDiv+"app-form-block-input:nth-of-type(1) mat-form-field input";
    public String registerLastName = selectFormRegisterStep1TopDiv+"app-form-block-input:nth-of-type(2) mat-form-field input";
    public String email = selectFormRegisterStep1BottomDiv+"app-form-block-input mat-form-field input";
    public String rolRegister(int rol){
        return selectFormRegisterStep1BottomDiv+"div:nth-of-type(3) > mat-card:nth-of-type("+rol+")";
    }

    public String registerPassword = selectFormRegisterStep2+"app-form-block-input:nth-of-type(1) input";
    public String passwordConditionSelector(int passwordCondition){
        return "app-password-verification > div > div:nth-of-type("+passwordCondition+")";
    }
    public String registerPasswordConfirmation = selectFormRegisterStep2+"app-form-block-input:nth-of-type(2) input";

    public String registerTermsAndConditions = "mat-checkbox input";
    public String registerCaptchat = selectFormRegisterStep3+selectMatStepper+"div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) re-captcha > div > div > iframe";
    public String selectDivNextButtons = selectFormRegisterStep3+"mat-stepper > div > div:nth-of-type(2) > ";
    public String registerNextButtonStep1 = selectDivNextButtons+"div:nth-of-type(1) > div:nth-of-type(2) > button";
    public String registerNextButtonStep2 = selectDivNextButtons+"div:nth-of-type(2) > div:nth-of-type(2) > div > button";
    public String registerNextButtonStep3 = selectDivNextButtons+"div:nth-of-type(3) > div:nth-of-type(2) > div > button";

    //SELECTORS ONBOARDING CLINICIAN//
    public String onboardingClinicianCompanyName = "app-form-block-input:nth-of-type(1) input";
    public String clinicianOnboardingWebSite = selectRegistrationTypePadding+"app-form-block-input:nth-of-type(2) input";
    public String onboardingClinicianNextButtonStep1 = selectRegistrationTypePadding+"button";
    public String VerifyPhoneSkipForNow = selectRegistrationTypePadding+"div > div:nth-of-type(2) > div:nth-of-type(2) > span";
}
