package InsumosDocola;
public class SelectorsDocola extends VariablesDocola{
    //SELECTORS CLASS AND COMPONENTS
    public String form = "form > ";
    public String appRegister = "app-register ";
    public String matStepper = "mat-stepper > ";
    public String matDialogContainer = "mat-dialog-container > ";
    public String registrationTypePadding= ".registration-type-padding ";
    public String appSelectContent = "app-select-content > ";
    public String appSelectResource = "app-select-resource >";
    public String appConfigurationStep = "app-configuration-step > ";
    public String appTagsSearchOverlay = "app-tags-search-overlay > ";
    public String appPricingStep = "app-pricing-step > ";
    public String appThumbnailStep = "app-thumbnail-step > ";
    public String appUploaderDropBox = "app-uploader-drop-box > ";
    //SELECTORS WARNING
    public String loginIncorrectCredentials = "text=invalid_user_or_password";
    //SELECTORS HEADER
    public String appHeader = "app-header > ";
    public String headerDivButtons = appHeader+"div > div > div:nth-of-type(1) > button:nth-of-type";
    public String headerMyCoursesButton = headerDivButtons+"(2)";
    //SELECTORS FOOTER
    public String footerDivButtons = form+"div:nth-of-type(4) > div > ";
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
    public String menuProfile = appHeader+"div > div:nth-of-type(1) > button:nth-of-type(2)";
    //SELECT CONTENT CREATOR COMPNENTS
    public String createNewResourceButton = "text= New";
    public String selectGenericResourceType = appSelectResource+"div > div > div:nth-of-type";
    public String createNewContentButton(int typeContent){
        return selectGenericResourceType+"("+typeContent+") > span";
    }

    public String selectDivAllResourceCreator = appSelectContent+"div > div > div:nth-of-type";
    public String createResource(int resourceTypePosition){
        return selectDivAllResourceCreator+"("+resourceTypePosition+")";
    }
    //SELECT CONTENT COMPONENTS
    public String selectGenericInputsContentCreator = "app-details-and-file-step > div > div:nth-of-type";
    public String selectGenericTypeQuestion = ".cdk-overlay-pane> div > div > button:nth-of-type";
    public String selectGenericQuizCardQuestion = "app-quiz-question > div > div:nth-of-type(1) > div > ";
    public String selectGenericConfigurationStep = appConfigurationStep+form+"div:nth-of-type(";
    public String selectGenericPricingStep = appPricingStep+"div > div:nth-of-type(";
    public String selectPreviewImage = appUploaderDropBox+"div > div > div:nth-of-type(2) > i:nth-of-type(1)";
    public String selectGenericThumbnailStep = appThumbnailStep+form+"div > div > app-uploader-drop-box > div > div > button:nth-of-type(";
    public String selectGenericUnsplash = matDialogContainer+"div > div > app-unsplash > form > div:nth-of-type(";
    public String selectGenericTagType = form+"div > app-configuration-step > div > app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > app-tag-type-button:nth-of-type";
    public String selectGenericTag = appTagsSearchOverlay+"div > cdk-virtual-scroll-viewport > div > button:nth-of-type";
    public String contentTitle = selectGenericInputsContentCreator+"(1) input";
    public String contentDescription = selectGenericInputsContentCreator+"(2) textarea";
    public String contentUpload = selectGenericInputsContentCreator+"(3) > div:nth-of-type(1) input";
    public String contentAddUrl = selectGenericInputsContentCreator+"(3) input";
    public String contentAddQuestionsQuiz = selectGenericInputsContentCreator+"(3) > div:nth-of-type(2)";
    public String contentTypeQuestionQuiz(int typeQuestion){
        return selectGenericTypeQuestion+"("+typeQuestion+")";
    }
    public String contentTitleTrueOrFalseQuiz = selectGenericQuizCardQuestion+"mat-form-field input";
    public String selectGenericDivMultipleChoice = "app-survey-question > div > div:nth-of-type(1) > div:nth-of-type";
    public String contentTitleMultipleChoiceSurvey = selectGenericDivMultipleChoice+"(1) mat-form-field input";
    public String contentOption1MultipleChoiceSurvey = selectGenericDivMultipleChoice+"(2) > div:nth-of-type(1) mat-form-field input";
    public String contentOption2MultipleChoiceSurvey = selectGenericDivMultipleChoice+"(2) > div:nth-of-type(2) mat-form-field input";
    public String contentButtonContinue = footerDivButtons+"div > button:nth-of-type(3)";
    public String contentTagICD10Type = selectGenericTagType+"(1) > button";
    public String contentSelectTagICD10 = selectGenericTag+"(1)";
    public String contentSelectTagICD10(int tagPosition){
        return selectGenericTag+"("+tagPosition+")";
    }
    public String contentAddTags = appTagsSearchOverlay+"div > div > button:nth-of-type(2)";
    public String contentConfigurationCMECE = selectGenericConfigurationStep+"1) > mat-slide-toggle";
    public String contentConfigurationMarketPlace = selectGenericConfigurationStep+"2) > mat-slide-toggle";
    public String contentPricingContentForFree = selectGenericPricingStep+"1) mat-slide-toggle";
    public String contentPricingLifetimePurchase = selectGenericPricingStep+"2) mat-slide-toggle";
    public String contentPricingMonthlyPrice = selectGenericPricingStep+"2) > div:nth-of-type(3) > div:nth-of-type(1) mat-form-field input";
    public String contentPricingYearlyPrice = selectGenericPricingStep+"2) > div:nth-of-type(3) > div:nth-of-type(2) mat-form-field input";
    public String contentThumbnailUploadFile = selectGenericThumbnailStep+"1)";
    public String contentThumbnailUnsplash = selectGenericThumbnailStep+"2)";
    public String contentUnsplashCategorie = selectGenericUnsplash+"2) > div > div > button:nth-of-type(1)";
    public String contentUnsplashPhoto = selectGenericUnsplash+"3) > img:nth-of-type(10)";
    public String contentUnsplashSelectButton = selectGenericUnsplash+"4) > div > button";
    public String contentUnsplashSaveButton = "app-cropper-core > div > div:nth-of-type(2) > button";
    public String contentPublishButton = "text = Publish";
    public String selectGenericCourseContent = "app-crud app-cards-container > div > app-card:nth-of-type";
    public String courseSelectContent(int contentPosition){
        return selectGenericCourseContent+"("+contentPosition+")";
    }
    public String contentTabCourses = "mat-tab-header > div .mat-mdc-tab-labels > div:nth-of-type(2)";
}
