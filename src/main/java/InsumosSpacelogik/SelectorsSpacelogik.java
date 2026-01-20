package InsumosSpacelogik;

public class SelectorsSpacelogik extends VariablesSpacelogik {
    //TOASTER
    public static final String APP_TOASTERS = ".Toastify__toast";


    //SELECTORS LOGIN
    public static final String LOGIN_EMAIL = ".login-form-children-container > label:nth-of-type(1) input";
    public static final String LOGIN_PASSWORD = ".login-form-children-container > label:nth-of-type(2) input";
    public static final String LOGIN_BUTTON = ".login-form-main-container button";

    //GENERAL MENU SELECTORS
    public static final String MENU_ADMIN = ".app-sidebar ul > div:nth-of-type(5) > div:nth-of-type(1)";

    //RE COMPANIE SELECTORS
    public static final String RECOMPANIE_MENU_BUTTON = ".app-sidebar ul > div:nth-of-type(5) > div:nth-of-type(2) > div > div > div > a:nth-of-type(5)";
    public static final String RECOMPANIE_NEW_BUTTON = ".real-estate-company-admin-container > .generic-header-container button";
    public static final String RECOMPANIE_COMPANYNAME_INPUT = "body > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > label:nth-of-type(1) input";
    public static final String RECOMPANIE_COMPANYADRESS_INPUT = "body > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > label:nth-of-type(2) input";
    public static final String RECOMPANIE_COMPANYADRESS_OPTIONS = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String RECOMPANIE_COMPANYPHOTO_UPDATE = "";
    public static final String RECOMPANIE_NEXTBUTTON_STEP1 = ".justify-content-end button";
    public static final String RECOMPANIE_EMAIL_INPUT = "body > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > label input";
    public static final String RECOMPANIE_PASSWORD_INPUT = "body > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > label:nth-of-type(1) input";
    public static final String RECOMPANIE_PASSWORDCONFIRM_INPUT = "body > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > label:nth-of-type(2) input";
    public static final String RECOMPANIE_NEXTBUTTON_STEP2 = ".content-between > button:nth-of-type(2)";
    public static final String RECOMPANIE_CONTACTSALUTATION_SELECTOR = ".MuiInputBase-root";
    public static final String RECOMPANIE_CONTACTSALUTATION_OPTION = ".MuiPaper-root > ul > li:nth-of-type(2)";
    public static final String RECOMPANIE_CONTACTITLE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > label input";
    public static final String RECOMPANIE_CONTACTNAME_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > label:nth-of-type(1) input";
    public static final String RECOMPANIE_CONTACTLASTNAME_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > label:nth-of-type(2) input";
    public static final String RECOMPANIE_CONTACTMOBILE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > label:nth-of-type(1) input";
    public static final String RECOMPANIE_CONTACTPHONE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > label:nth-of-type(2) input";
    public static final String RECOMPANIE_SAVE_BUTTON = "body .ReactModal__Content > div:nth-of-type(3) > button:nth-of-type(2)";

    //NATIONAL ACCOUNT
    public static final String NACCOUNT_MENU_BUTTON = ".MuiCollapse-wrapperInner > .MuiList-root > a:nth-of-type(6)";
    public static final String NACCOUNT_NEW_BUTTON = ".app-main__inner .generic-header-container button";
    public static final String NACCOUNT_COMPANY_NAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(2) label > input";
    public static final String NACCOUNT_COMPANY_INDUSTRY_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(2) .MuiInputBase-root";
    public static final String NACCOUNT_COMPANY_INDUSTRY_OPTION = ".MuiPopover-root > .MuiPaper-root > ul > li:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_ADDRESS_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > label > input";
    public static final String NACCOUNT_COMPANY_ADDRESS_OPTION = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String NACCOUNT_COMPANY_STATE_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(1)";
    public static final String NACCOUNT_COMPANY_STATE_OPTION = ".MuiPopover-root ul > li:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_CITY_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_CITY_OPTION = ".MuiPopover-root ul > li:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_ZIPCODE_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(3)";
    public static final String NACCOUNT_COMPANY_ZIPCODE_OPTION = ".MuiPopover-root ul > li:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_LOGO_MODAL_OPEN = ".image-holder > button";
    public static final String NACCOUNT_COMPANY_LOGO_UPLOAD = ".filepond--browser";
    public static final String NACCOUNT_COMPANY_LOGO_SAVE = ".modal-buttons > button:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_CONTINUE_BUTTON = ".national-account-modal-container > .display-flex-column-space-between > .justify-content-end button";
    public static final String NACCOUNT_TENANT_FNAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(2) > .d-flex-column:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_LNAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(2) > .d-flex-column:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_SALUTATION_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(3) > .generic-select-container";
    public static final String NACCOUNT_TENANT_SALUTATION_OPTION = ".MuiPaper-root > ul > li:nth-of-type(2)";
    public static final String NACCOUNT_TENANT_TITLE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(3) > .d-flex-column input";
    public static final String NACCOUNT_TENANT_MOBILE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(4) > .generic-input-label:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_PHONE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(4) > .generic-input-label:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_EMAIL_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > label input";
    public static final String NACCOUNT_TENANT_PASSWORD_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(5) > label:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_CPASSOWRD_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(5) > label:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_SAVE_BUTTON = ".national-account-modal-container > .display-flex-column-space-between > .content-between > button:nth-of-type(2)";

}
