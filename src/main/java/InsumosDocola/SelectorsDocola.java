package InsumosDocola;
public class SelectorsDocola extends VariablesDocola{
    //SELECTORS MAILINATOR
    public static final String MAILINATOR_INPUT = "body > div:nth-of-type(1) > header:nth-of-type(1) > div:nth-of-type(1) input";
    public static final String NEW_MESSAGE = "main > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(4) table > tbody > tr";
    public static final String TEXT_TAB = "ul > li:nth-of-type(2) a";
    public static final String LINK_REGISTRATION = "#texthtml_msg_body";
    //SELECTORS CLASS AND COMPONENTS
    public static final String FORM = "form > ";
    public static final String APP_REGISTER = "app-register ";
    public static final String MAT_STEPPER = "mat-stepper > ";
    public static final String APP_TERMS_CONDITION = "app-terms-condition > ";
    public static final String MAT_DIALOG_CONTAINER = "mat-dialog-container";
    public static final String CLASS_MAT_DIALOG_CONTAINER = ".mdc-dialog__container";
    public static final String CLASS_MAT_MDC_DIALOG_SURFACE = ".mat-mdc-dialog-surface";
    public static final String REGISTRATION_TYPE_PADDING = ".registration-type-padding ";
    public static final String APP_SELECT_CONTENT = "app-select-content > ";
    public static final String APP_SELECT_RESOURCE = "app-select-resource >";
    public static final String APP_CONFIGURATION_STEP = "app-configuration-step > ";
    public static final String APP_TAGS_SEARCH_OVERLAY = "app-tags-search-overlay > ";
    public static final String APP_PRICING_STEP = "app-pricing-step > ";
    public static final String APP_THUMBNAIL_STEP = "app-thumbnail-step > ";
    public static final String APP_UPLOADER_DROP_BOX = "app-uploader-drop-box > ";
    //SELECTORS WARNING
    public static final String LOGIN_INCORRECT_CREDENTIALS = "text=invalid_user_or_password";
    //SELECTORS HEADER
    public static final String APP_HEADER = "app-header > ";
    public static final String HEADER_DIV_BUTTONS = APP_HEADER +"div > div > div:nth-of-type(1) > div > button:nth-of-type";
    public static final String HEADER_MY_LIBRARY_BUTTON = HEADER_DIV_BUTTONS +"(1) > span:nth-of-type(1)";
    //SELECTORS FOOTER
    public static final String FOOTER_DIV_BUTTONS = FORM +"div:nth-of-type(4) > div > ";
    //SELECTORS LOGIN
    public static final String FORM_LOGIN = "app-login > div > div > form > div:nth-of-type(2) > ";
    public static final String LOGIN_EMAIL = FORM_LOGIN +"app-form-block-input:nth-of-type(1) input";
    public static final String LOGIN_PASSWORD = FORM_LOGIN +"app-form-block-input:nth-of-type(2) input";
    public static final String LOGIN_BUTTON = FORM +"div:nth-of-type(3) button";
    //SELECTOR SIGN OUT
    public static final String SIGN_OUT = ".mat-mdc-menu-content > div > button:nth-of-type(4)";
    //SELECTORS REGISTER//
    public static final String SING_UP = "text=Sign up free";
    public static final String CONTINUE_WITH_EMAIL = ".border-primary > div > button:nth-of-type(3)";
    public static final String SELECT_DIV_NEXT_BUTTONS = MAT_STEPPER +"div > div:nth-of-type(2) > ";
    //REGISTER STEP 1//
    public static final String FORM_REGISTER_STEP_1_TOP_DIV = APP_REGISTER + MAT_STEPPER +"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public static final String FORM_REGISTER_STEP_1_BOTTOM_DIV = APP_REGISTER + MAT_STEPPER +"div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > ";
    public static final String REGISTER_FIRST_NAME = FORM_REGISTER_STEP_1_TOP_DIV +"app-form-block-input:nth-of-type(1) input";
    public static final String REGISTER_LAST_NAME = FORM_REGISTER_STEP_1_TOP_DIV +"app-form-block-input:nth-of-type(2) input";
    public static final String EMAIL = FORM_REGISTER_STEP_1_BOTTOM_DIV +"div:nth-of-type(2) > div input";
    public String rolRegister(int rol){
        return FORM_REGISTER_STEP_1_BOTTOM_DIV +"div:nth-of-type(3) > mat-card:nth-of-type("+rol+")";
    }
    public static final String REGISTER_NEXT_BUTTON_STEP_1 = SELECT_DIV_NEXT_BUTTONS +"div:nth-of-type(1) > div > div:nth-of-type(4) button";
    //REGISTER STEP 2//
    public static final String FORM_REGISTER_STEP_2 = MAT_STEPPER +"div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > ";
    public static final String REGISTER_PASSWORD = FORM_REGISTER_STEP_2 +"app-form-block-input:nth-of-type(1) input";
    public String passwordConditionSelector(int passwordCondition){
        return "app-password-verification > div > div:nth-of-type("+passwordCondition+")";
    }
    public static final String REGISTER_PASSWORD_CONFIRMATION = FORM_REGISTER_STEP_2 +"app-form-block-input:nth-of-type(2) input";
    public static final String REGISTER_NEXT_BUTTON_STEP_2 = SELECT_DIV_NEXT_BUTTONS +"div:nth-of-type(2) > div > div:nth-of-type(3) > div > button";
    //REGISTER STEP 3//
    public static final String FORM_REGISTER_STEP_3 = APP_TERMS_CONDITION +"div > div:nth-of-type(2) > ";
    public static final String REGISTER_TERMS_AND_CONDITIONS = FORM_REGISTER_STEP_3 +"mat-checkbox > div input";
    public static final String REGISTER_CAPTCHAT = FORM_REGISTER_STEP_3 +"re-captcha > div > div > iframe";
    public static final String REGISTER_NEXT_BUTTON_STEP_3 = SELECT_DIV_NEXT_BUTTONS +"div:nth-of-type(3) > app-terms-condition > div > div:nth-of-type(3) > div button";
    //SELECTORS ONBOARDING CLINICIAN//
    public static final String SELECT_GENERIC_ONBOARDING_FIELDS = "app-onboarding > div > div";
    public static final String ONBOARDING_CONTENT_PROVIDER_COMPANY_NAME = SELECT_GENERIC_ONBOARDING_FIELDS +" > div:nth-of-type(2) > mat-form-field:nth-of-type(1) input";
    public static final String ONBOARDING_CONTENT_PROVIDER_WEB_SITE = SELECT_GENERIC_ONBOARDING_FIELDS +" > div:nth-of-type(2) > mat-form-field:nth-of-type(2) input";
    public static final String ONBOARDING_CONTENT_PROVIDER_NEXT_BUTTON_STEP_1 = SELECT_GENERIC_ONBOARDING_FIELDS +" > div:nth-of-type(3) button";
    public static final String SELECT_GENERIC_ONBOARDING_CLINICIAN = "app-clinitian-onboarding > div ";
    public static final String ONBOARDING_CLINICIANC_CONTINUE = SELECT_GENERIC_ONBOARDING_CLINICIAN +"> div:nth-of-type(2) button";
    public static final String ONBOARDING_CLINICIANC_CONTINUE_STEP_2 = SELECT_GENERIC_ONBOARDING_CLINICIAN +"> div:nth-of-type(3) button";
    public static final String ONBOARDING_CLINICIAN_SELECTOR = SELECT_GENERIC_ONBOARDING_CLINICIAN +"> mat-form-field > div:nth-of-type(1)";
    public static final String ONBOARDING_CLINICIAN_SELECTOR_OPTION = ".cdk-overlay-connected-position-bounding-box > .cdk-overlay-pane > div > mat-option:nth-of-type(1)";
    public static final String ONBOARDING_CLINICIAN_PRACTICE_NAME = SELECT_GENERIC_ONBOARDING_CLINICIAN +"> div:nth-of-type(2) input";
    public static final String ONBOARDING_CLINICIAN_PRACTICE_NOT_FOR_NOW = SELECT_GENERIC_ONBOARDING_CLINICIAN +"> div:nth-of-type(2) > button:nth-of-type(1)";
    public static final String CLOSE_GUIDE = ".introjs-tooltipReferenceLayer > div > div:nth-of-type(1) a";
    public static final String VERIFY_PHONE_SKIP_FOR_NOW = REGISTRATION_TYPE_PADDING +"div > div:nth-of-type(2) > div:nth-of-type(2) > span";
    //SELECT PROFILE MENU
    public static final String MENU_PROFILE = APP_HEADER +"div > div:nth-of-type(1) > div:nth-of-type(2) > div";
    public static final String ACCOUNT_SETINGS = "text=Account settings";
    //SELECTORS ACCOUNT SETTINGS
    public static final String UPLOAD_PROFILE_PICTURE = "app-profile-tab > div > div > input";
    public static final String SAVE_UPLOAD_PICTURE = "app-cropper-core > div > div:nth-of-type(2) > button";
    public static final String SAVE_CHANGES = "app-profile > div:nth-of-type(1) button";
    //SELECT CONTENT CREATOR COMPONENTS
    public static final String CREATE_NEW_RESOURCE_BUTTON = "text= New";
    public static final String SELECT_GENERIC_RESOURCE_TYPE = APP_SELECT_RESOURCE +"div > div > div:nth-of-type";
    public String createNewContentButton(int typeContent) {
        return SELECT_GENERIC_RESOURCE_TYPE + "(" + typeContent + ") > span";
    }
    public static final String SELECT_DIV_ALL_RESOURCE_CREATOR = APP_SELECT_CONTENT +"div > div > div:nth-of-type";
    public String createResource(int resourceTypePosition){
        return SELECT_DIV_ALL_RESOURCE_CREATOR +"("+resourceTypePosition+")";
    }
    //SELECT CONTENT COMPONENTS
    public static final String SELECT_GENERIC_INPUTS_CONTENT_CREATOR = "app-details-and-file-step > div > div:nth-of-type";
    public static final String SELECT_GENERIC_TYPE_QUESTION = ".cdk-overlay-pane> div > div > button:nth-of-type";
    public static final String SELECT_GENERIC_QUIZ_CARD_QUESTION = "app-quiz-question > div > div:nth-of-type(1) > div > ";
    public static final String SELECT_GENERIC_CONFIGURATION_STEP = APP_CONFIGURATION_STEP +"div:nth-of-type(1) > div > div:nth-of-type(2) > mat-radio-group > ";
    public static final String SELECT_GENERIC_PRICING_STEP = APP_PRICING_STEP +"div > div:nth-of-type(";
    public static final String SELECT_PREVIEW_IMAGE = APP_UPLOADER_DROP_BOX +"div > div > div:nth-of-type(2) > i:nth-of-type(1)";
    public static final String SELECT_GENERIC_THUMBNAIL_STEP = APP_THUMBNAIL_STEP + FORM +"div > div > app-uploader-drop-box > div > div > button:nth-of-type(";
    public static final String SELECT_GENERIC_UNSPLASH = MAT_DIALOG_CONTAINER +" > div > div > app-unsplash > form > div:nth-of-type(";
    public static final String SELECT_GENERIC_TAG_TYPE = FORM +"div > app-configuration-step > div > app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > app-tag-type-button:nth-of-type";
    public static final String SELECT_GENERIC_TAG = APP_TAGS_SEARCH_OVERLAY +"div > cdk-virtual-scroll-viewport > div > button:nth-of-type";
    public static final String CONTENT_TITLE = SELECT_GENERIC_INPUTS_CONTENT_CREATOR +"(1) input";
    public static final String CONTENT_DESCRIPTION = SELECT_GENERIC_INPUTS_CONTENT_CREATOR +"(2) textarea";
    public static final String CONTENT_UPLOAD = SELECT_GENERIC_INPUTS_CONTENT_CREATOR +"(3) > div:nth-of-type(1) input";
    public static final String CONTENT_ADD_URL = SELECT_GENERIC_INPUTS_CONTENT_CREATOR +"(3) input";
    public static final String CONTENT_ADD_QUESTIONS_QUIZ = SELECT_GENERIC_INPUTS_CONTENT_CREATOR +"(3) > div:nth-of-type(2)";

    public String contentTypeQuestionQuiz(int typeQuestion){
        return SELECT_GENERIC_TYPE_QUESTION +"("+typeQuestion+")";
    }
    public static final String CONTENT_TITLE_TRUE_OR_FALSE_QUIZ = SELECT_GENERIC_QUIZ_CARD_QUESTION +"mat-form-field input";
    public static final String SELECT_GENERIC_DIV_MULTIPLE_CHOICE = "app-survey-question > div > div:nth-of-type(1) > div:nth-of-type";
    public static final String CONTENT_TITLE_MULTIPLE_CHOICE_SURVEY = SELECT_GENERIC_DIV_MULTIPLE_CHOICE +"(1) mat-form-field input";
    public static final String CONTENT_OPTION_1_MULTIPLE_CHOICE_SURVEY = SELECT_GENERIC_DIV_MULTIPLE_CHOICE +"(2) > div:nth-of-type(1) mat-form-field input";
    public static final String CONTENT_OPTION_2_MULTIPLE_CHOICE_SURVEY = SELECT_GENERIC_DIV_MULTIPLE_CHOICE +"(2) > div:nth-of-type(2) mat-form-field input";
    public static final String CONTENT_TAG_ICD_10_TYPE = SELECT_GENERIC_TAG_TYPE +"(1) > button";
    public static final String CONTENT_SELECT_TAG_ICD_10 = SELECT_GENERIC_TAG +"(1)";
    public static final String CONTENT_TAG_SEARCH_OVERLAY = "app-tags-search-overlay";
    public static final String CONTENT_TAG_ICD10_FIRST = "app-tags-search-overlay > div > cdk-virtual-scroll-viewport > div > button:nth-of-type(1)";
    public static final String CONTENT_TAG_NORMAL_TYPE_TWO = SELECT_GENERIC_TAG_TYPE+"(2) > button";
    public String contentTagType(int tagTypePosition){
        return SELECT_GENERIC_TAG_TYPE+"("+tagTypePosition+") button";
    }
    public String contentSelectTag(int tagPosition){
        return SELECT_GENERIC_TAG +"("+tagPosition+")";
    }
    public static final String CONTENT_ADD_TAGS = APP_TAGS_SEARCH_OVERLAY +"div > div > button:nth-of-type(2)";
    public static final String CONTENT_LABEL_TAGS = "app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1)";
    public static final String CONTENT_DELETE_TAGS = "app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) .gap > div:nth-of-type(1) i";
    public static final String CONTENT_CONFIGURATION_CMECE = SELECT_GENERIC_CONFIGURATION_STEP +"div mat-radio-button";
    public static final String CONTENT_CONFIGURATION_MARKET_PLACE = SELECT_GENERIC_CONFIGURATION_STEP +"2) > mat-checkbox input";
    public static final String CONTENT_PRICING_CONTENT_FOR_FREE = SELECT_GENERIC_PRICING_STEP +"1) mat-slide-toggle";
    public static final String CONTENT_PRICING_LIFETIME_PURCHASE = SELECT_GENERIC_PRICING_STEP +"2) mat-slide-toggle";
    public static final String CONTENT_PRICING_MONTHLY_PRICE = SELECT_GENERIC_PRICING_STEP +"2) > div:nth-of-type(2) input";
    public static final String CONTENT_PRICING_YEARLY_PRICE = SELECT_GENERIC_PRICING_STEP +"2) > div:nth-of-type(3) > div:nth-of-type(2) mat-form-field input";
    public static final String CONTENT_THUMBNAIL_UPLOAD_FILE = SELECT_GENERIC_THUMBNAIL_STEP +"1)";
    public static final String CONTENT_THUMBNAIL_UNSPLASH = SELECT_GENERIC_THUMBNAIL_STEP +"2)";
    public static final String WAIT_CATEGORY_UNPLASH = SELECT_GENERIC_UNSPLASH +"2) > div > div > button:nth-of-type(7)";
    public String contentUnsplashCategorie(int thumbnailCategory){
        return SELECT_GENERIC_UNSPLASH +"2) > div > div > button:nth-of-type("+thumbnailCategory+")";
    }
    public static final String WAITING_UNPLASH = SELECT_GENERIC_UNSPLASH +"3) > img:nth-of-type(10)";
    public String contentUnsplashPhoto(int thumbnail){
        return SELECT_GENERIC_UNSPLASH +"3) > img:nth-of-type("+thumbnail+")";
    }
    public static final String CONTENT_UNSPLASH_SELECT_BUTTON = SELECT_GENERIC_UNSPLASH +"4) > div > button";
    public static final String CONTENT_UNSPLASH_SAVE_BUTTON = "app-cropper-core > div > div:nth-of-type(2) > button";
    public static final String CONTENT_THUMBNAIL_DELETE = APP_THUMBNAIL_STEP + FORM +"div > div > button";
    public static final String CONTENT_THUMBNAIL_FIRST_IMAGE = "mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(3) > img:nth-of-type(1)";
    public static final String CONTENT_PUBLISH_BUTTON = "text = Publish";
    public static final String SELECT_GENERIC_COURSE_CONTENT = "app-crud app-cards-container > div > app-card:nth-of-type";
    public String courseSelectContent(int contentPosition){
        return SELECT_GENERIC_COURSE_CONTENT +"("+contentPosition+")";
    }
    public static final String CONTENT_TAB_COURSES = "mat-tab-header > div .mat-mdc-tab-labels > div:nth-of-type(2)";
    public static final String CONTENT_GO_TO_MY_PRACTICES = "app-header .container > div:nth-of-type(1) > div > button:nth-of-type(1)";
    public static final String CONTENT_GO_TO_PRACTICE = "app-practices > div:nth-of-type(1) > div:nth-of-type(2) button";
    //SELECT CERTIFICATE
    public static final String CONTENT_CERTIFICATE_CUSTOMIZE = "app-configuration-step > div > div > div:nth-of-type(2) >  mat-radio-group > div > div > div";
    public static final String CONTENT_CERTIFICATE_DESCRIPTION = "app-certificate-dialog .container-border > div:nth-of-type(1) > div:nth-of-type(5) textarea";
    public static final String CONTENT_CERTIFICATE_SIGNATURE = "app-certificate-dialog > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) >div:nth-of-type(2) input";
    public static final String CONTENT_CERTIFICATE_SAVE = "app-certificate-dialog > div > div:nth-of-type(3) > button:nth-of-type(2)";
    //SELECT PRACTICE CREATE
    public static final String PRACTICE_CREATE_BUTTON = "app-my-practices > div > div:nth-of-type(1) > button";
    public static final String PRACTICE_NAME = "form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) input";
    public static final String PRACTICE_DESCRIPTION = "form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) textarea";
    public static final String PRACTICE_ADD_MEMBERS = "form > div:nth-of-type(2) button";
    public String practiceEmailInvite (int membersAmountEmail){
        return "form > div:nth-of-type(2) > div:nth-of-type("+membersAmountEmail+") input";
    }
    public String practiceRolInvite (int membersAmountRol){
        return "form > div:nth-of-type(2) > div:nth-of-type("+membersAmountRol+") > mat-form-field:nth-of-type(2) > div:nth-of-type(1)";
    }
    public String practiceRolSendInvite(int rolPosition){
        return ".cdk-overlay-pane > div > mat-option:nth-of-type("+rolPosition+")";
    }
    public static final String PRACTICE_UPLOAD_IMAGE = "form > div:nth-of-type(1) > div:nth-of-type(2) input";
    public static final String PRACTICE_PUBLISH_BUTTON = "form > div:nth-of-type(3) > button";
    //SELECT PRESCRIBE
    public static final String PRESCRIBE_BUTTON = "app-header > div > div > div:nth-of-type(2) > button:nth-of-type(1)";
    public static final String PRESCRIBE_TO_PATIENT = "app-options > div:nth-of-type(2) > div:nth-of-type(1)";
    public static final String PRESCRIBE_VIA_EMAIL_RADIOBUTTON = "app-prescription mat-radio-group > mat-radio-button:nth-of-type(1) input";
    public static final String PRESCRIBE_WITHOUT_EMAIL_RADIOBUTTON = "app-prescription mat-radio-group > mat-radio-button:nth-of-type(2) input";
    public String prescribeFirstName(int firstNamePosition){
        return "mat-radio-group > div > div > div:nth-of-type("+firstNamePosition+") mat-form-field:nth-of-type(1) input";
    }
    public String prescribeLastName(int firstNamePosition){
        return "mat-radio-group > div > div > div:nth-of-type("+firstNamePosition+") mat-form-field:nth-of-type(2) input";
    }
    public static final String PRESCRIBE_ADD_PATIENT = "mat-radio-group > div > div p";
    public static final String PRESCRIBE_PATIENTS_EMAIL_INPUT = "mat-radio-group > div > div > div:nth-of-type(1) app-progressive-list input";
    //SELECT CONTINUE
    public static final String CONTINUE_CONTENT_BUTTON = FOOTER_DIV_BUTTONS +"div > button:nth-of-type(2)";
    public static final String CONTINUE_PRESCRIBE_BUTTON = "form .sticky-footer > div > div > button";
    //INVITATION FORM
    public static final String REGISTER_INVITATION_BUTTON = "app-register button";
    public static final String REGISTER_INVITATION_FIRST_NAME = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > app-form-block-input:nth-of-type(1) input";
    public static final String REGISTER_INVITATION_LAST_NAME = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > app-form-block-input:nth-of-type(2) input";
    public static final String REGISTER_INVITATION_CONTINUE_STEP_1 = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) button";
    public static final String REGISTER_INVITATION_CONTINUE_STEP_2 = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > div > button";
    public static final String REGISTER_INVITATION_BUTTON_STEP_3 = "app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div > div > button";
    //SELECT MESSAGE ERROR
    public static final String MESSAGE_ERROR_TITLE_REQUIRED = "app-details-and-file-step > div > div:nth-of-type(1) mat-error";
    public static final String MESSAGE_ERROR_DESCRIPTION_REQUIRED = "app-details-and-file-step > div > div:nth-of-type(2) mat-error";
    public static final String MESSAGE_ERROR_FILE_REQUIRED = "app-details-and-file-step > div > div:nth-of-type(3) > div:nth-of-type(1) span";
    public static final String MESSAGE_ERROR_TAGS_REQUIRED = "app-tags > div > div:nth-of-type(3) span";
    public static final String MESSAGE_ERROR_MONTHLYPRICE_REQUIRED = "app-pricing-step mat-form-field mat-error";
}
