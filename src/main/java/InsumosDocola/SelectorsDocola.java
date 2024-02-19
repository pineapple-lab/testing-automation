package InsumosDocola;
public class SelectorsDocola extends VariablesDocola{
    //SELECTORS CLASS AND COMPONENTS
    public String form = "form > ";
    public String appRegister = "app-register ";
    public String matStepper = "mat-stepper > ";
    public String registrationTypePadding= ".registration-type-padding ";
    public String appSelectContent = "app-select-content > ";
    //SELECTORS WARNING
    public String loginIncorrectCredentials = "text=invalid_user_or_password";
    //SELECTORS HEADER
    public String appHeader = "app-header > ";
    public String headerDivButtons = appHeader+"div > div:nth-of-type(1) > button:nth-of-type";
    public String headerMyCoursesButton = headerDivButtons+"(2)";
    //SELECTORS LOGIN
    public String formLogin = "form > div:nth-of-type(2) > div:nth-of-type(2) > ";
    public String loginEmail = formLogin+"app-form-block-input:nth-of-type(1) input";
    public String loginPassword = formLogin+"app-form-block-input:nth-of-type(2) input";
    public String loginButton = form+"div:nth-of-type(2) > div:nth-of-type(3) button";
    //SELECTOR SIGN OUT
    public String signOut = "text=Sign out";
    //SELECTORS REGISTER//
    public String singUp = "text=Sign up free";
    public String continueWithEmail = ".border-primary > div > button:nth-of-type(3)";
    public String selectDivNextButtons = matStepper+"div > div:nth-of-type(2) > ";
    //REGISTER STEP 1//
    public String formRegisterStep1TopDiv = appRegister+matStepper+"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public String formRegisterStep1BottomDiv = appRegister+matStepper+"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > ";
    public String registerFirstName = formRegisterStep1TopDiv+"app-form-block-input:nth-of-type(1) mat-form-field input";
    public String registerLastName = formRegisterStep1TopDiv+"app-form-block-input:nth-of-type(2) mat-form-field input";
    public String email = formRegisterStep1BottomDiv+"app-form-block-input mat-form-field input";
    public String rolRegister(int rol){
        return formRegisterStep1BottomDiv+"div:nth-of-type(3) > mat-card:nth-of-type("+rol+")";
    }
    public String registerNextButtonStep1 = selectDivNextButtons+"div:nth-of-type(1) > div:nth-of-type(2) > button";
    //REGISTER STEP 2//
    public String formRegisterStep2 = matStepper+"div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public String registerPassword = formRegisterStep2+"app-form-block-input:nth-of-type(1) input";
    public String passwordConditionSelector(int passwordCondition){
        return "app-password-verification > div > div:nth-of-type("+passwordCondition+")";
    }
    public String registerPasswordConfirmation = formRegisterStep2+"app-form-block-input:nth-of-type(2) input";
    public String registerNextButtonStep2 = selectDivNextButtons+"div:nth-of-type(2) > div:nth-of-type(2) > div > button";
    //REGISTER STEP 3//
    public String formRegisterStep3 = matStepper+"div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) ";
    public String registerTermsAndConditions = formRegisterStep3+"mat-checkbox input";
    public String registerCaptchat = formRegisterStep3+"re-captcha > div > div > iframe";
    public String registerNextButtonStep3 = selectDivNextButtons+"div:nth-of-type(3) > div:nth-of-type(2) > div > button";
    //SELECTORS ONBOARDING CLINICIAN//
    public String onboardingClinicianCompanyName = "app-form-block-input:nth-of-type(1) input";
    public String clinicianOnboardingWebSite = registrationTypePadding+"app-form-block-input:nth-of-type(2) input";
    public String onboardingClinicianNextButtonStep1 = registrationTypePadding+"button";
    public String VerifyPhoneSkipForNow = registrationTypePadding+"div > div:nth-of-type(2) > div:nth-of-type(2) > span";
    //SELECT PROFILE MENU
    public String menuProfile = appHeader+"div > div:nth-of-type(2) > div";
    //SELECT CONTENT CREATOR COMPNENTS
    public String createNewContentButton = "text= Upload / create new content";
    public String selectDivAllContentsCreator = appSelectContent+"div > div:nth-of-type";
    public String createContent(int contentTypePosition){
        return selectDivAllContentsCreator+"("+contentTypePosition+")";
    }
    //SELECT CONTENT FILE CREATOR COMPONENTS
    public String contentTitle = "";
    public String contentDescription = "";
    public String contentUploadFile = "";
    public String contentButtonContinue = "";
    public String contentConfigurationCMECE = "";
    public String contentConfigurationMarketPlace = "";
    public String contentPircingContentForFree = "";
    public String contentPircingLifetimePurchase = "";
    public String contentPircingMonthlyPrice = "";
    public String contentPircingYearlyPrice = "";
    public String contentThumbnailUploadFile = "";
    public String contentThumbnailUnsplash = "";
}
