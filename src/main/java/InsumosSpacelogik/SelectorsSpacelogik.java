package InsumosSpacelogik;

import com.intellij.psi.util.PropertyUtilBase;
import org.jetbrains.kotlin.backend.common.serialization.signature.PublicIdSignatureComputer;

public class SelectorsSpacelogik extends VariablesSpacelogik {
    //WAIT COMPONENT
    public static final String WAIT_RECOMPANIE_TABLE_FIRSTROW = ".MuiDataGrid-virtualScrollerContent > div > div:nth-of-type(1)";

    //TOASTER
    public static final String APP_TOASTERS = ".Toastify__toast";

    //MODAL
    public static final String GENERIC_MODAL = ".ReactModal__Content";

    //SELECTORS LOGIN
    public static final String LOGIN_EMAIL = ".login-form-children-container > label:nth-of-type(1) input";
    public static final String LOGIN_PASSWORD = ".login-form-children-container > label:nth-of-type(2) input";
    public static final String LOGIN_BUTTON = ".login-form-main-container button";

    //GENERAL MENU SELECTORS
    public static final String MENU_ADMIN = ".app-sidebar ul > div:nth-of-type(5) > div:nth-of-type(1)";

    public String StateOption(int statePosition){
        return ".MuiPopover-root ul > li:nth-of-type("+statePosition+")";
    }
    public String CityOption(int cityPosition){
        return ".MuiPopover-root ul > li:nth-of-type("+cityPosition+")";
    }
    public String ZipcodeOption(int zipcodePosition){
        return ".MuiPopover-root ul > li:nth-of-type("+zipcodePosition+")";
    }
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
    public String SalutationOption(int salutationPosition){
        return ".MuiPaper-root > ul > li:nth-of-type("+salutationPosition+")";
    }
    public static final String RECOMPANIE_CONTACTITLE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(1) > label input";
    public static final String RECOMPANIE_CONTACTNAME_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > label:nth-of-type(1) input";
    public static final String RECOMPANIE_CONTACTLASTNAME_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > label:nth-of-type(2) input";
    public static final String RECOMPANIE_CONTACTMOBILE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > label:nth-of-type(1) input";
    public static final String RECOMPANIE_CONTACTPHONE_INPUT = "body .ReactModal__Content > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > label:nth-of-type(2) input";
    public static final String RECOMPANIE_SAVE_BUTTON = "body .ReactModal__Content > div:nth-of-type(3) > button:nth-of-type(2)";

    //NATIONAL ACCOUNT
    public static final String NACCOUNT_MENU_BUTTON = ".MuiCollapse-wrapperInner > .MuiList-root > a:nth-of-type(7)";
    public static final String NACCOUNT_NEW_BUTTON = ".app-main__inner .generic-header-container button";
    public static final String NACCOUNT_COMPANY_NAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(2) label > input";
    public static final String NACCOUNT_COMPANY_INDUSTRY_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(2) .MuiInputBase-root";
    public String IndustryOption(int industryPosition){
        return ".MuiPopover-root > .MuiPaper-root > ul > li:nth-of-type("+industryPosition+")";
    }
    public static final String NACCOUNT_COMPANY_ADDRESS_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > label > input";
    public static final String NACCOUNT_COMPANY_ADDRESS_OPTION = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String NACCOUNT_COMPANY_STATE_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(1)";
    public static final String NACCOUNT_COMPANY_CITY_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_ZIPCODE_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > .d-flex:nth-of-type(3) > .w-100:nth-of-type(3)";
    public static final String NACCOUNT_COMPANY_LOGO_MODAL_OPEN = ".image-holder > button";
    public static final String NACCOUNT_COMPANY_LOGO_UPLOAD = ".filepond--browser";
    public static final String NACCOUNT_COMPANY_LOGO_SAVE = ".modal-buttons > button:nth-of-type(2)";
    public static final String NACCOUNT_COMPANY_CONTINUE_BUTTON = ".national-account-modal-container > .display-flex-column-space-between > .justify-content-end button";
    public static final String NACCOUNT_TENANT_FNAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(2) > .d-flex-column:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_LNAME_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(2) > .d-flex-column:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_SALUTATION_SELECT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(3) > .generic-select-container";
    public static final String NACCOUNT_TENANT_TITLE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(3) > .d-flex-column input";
    public static final String NACCOUNT_TENANT_MOBILE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(4) > .generic-input-label:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_PHONE_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(4) > .generic-input-label:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_EMAIL_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > label input";
    public static final String NACCOUNT_TENANT_PASSWORD_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(5) > label:nth-of-type(1) input";
    public static final String NACCOUNT_TENANT_CPASSOWRD_INPUT = ".national-account-modal-container > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .d-flex-column > div > .d-flex:nth-of-type(5) > label:nth-of-type(2) input";
    public static final String NACCOUNT_TENANT_SAVE_BUTTON = ".national-account-modal-container > .display-flex-column-space-between > .content-between > button:nth-of-type(2)";

    //PEOPLE
    public static final String PEOPLE_FORM_NEWGURU_BUTTON = ".represented-tenants-header-container button";
    public static final String PEOPLE_FORM_SALUTATION_SELECT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(1) > div > div";
    public static final String PEOPLE_FORM_TITLE_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(1) > label > input";
    public static final String PEOPLE_FORM_NAME_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(2) > label:nth-of-type(1) input";
    public static final String PEOPLE_FORM_LNAME_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(2) > label:nth-of-type(2) input";
    public static final String PEOPLE_FORM_EMAIL_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(3) input";
    public static final String PEOPLE_FORM_MOBILE_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(4) > label:nth-of-type(1) input";
    public static final String PEOPLE_FORM_PHONE_INPUT = ".guru-modal-main-container > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(4) > label:nth-of-type(2) input";
    public static final String PEOPLE_FORM_CONTINUEANDSAVE_BUTTON = ".justify-content-between > button:nth-of-type(2)";
    public static final String PEOPLE_FORM_OFFICE_SELECT = ".guru-modal-main-container > .generic-select-container > div";
    public String oficeOption (int officePosition){
        return ".MuiPaper-root > ul > li:nth-of-type("+officePosition+")";
    }
    public static final String PEOPLE_FORM_SKILL_SELECT = ".offices-and-skill-children-container .MuiFormControl-root";
    public static final String PEOPLE_FORM_SKILL_OPTION = ".MuiPaper-root > ul > li:nth-of-type(1)";
    public static final String PEOPLE_FORM_DESCRIPTION_INPUT = ".generic-text-area";
    public static final String PEOPLE_FORM_PAYMENT_OPTION = ".payment-main-container > div > div:nth-of-type(1)";
    public static final String PEOPLE_FORM_POPUP_SUCCESSFULLY = ".modal > .generic-action-modal-body";
    public static final String PEOPLE_FORM_POPUP_OK_BUTTON = ".modal > .modal-buttons > button:nth-of-type(2)";

    //CLIENT
    //public static final String CLIENT_CARD = ".represented-tenants-children-container > span span > div > div";
    public static final String CLIENT_NEW_BUTTON = ".locations-filters-header button";
    public static final String CLIENT_COMPANY_NAME_INPUT = ".tenant-registration-step-container .row-container > div:nth-of-type(1) input";
    public static final String CLIENT_INDUSTRY_SELECT = ".tenant-registration-step-container .row-container > div:nth-of-type(2)";
    public static final String CLIENT_CONTINUESTEP1_BUTTON = ".tenant-registration-buttons-right button";
    public static final String CLIENT_TENANT_NAME_INPUT = ".tenant-section-form > .row-container:nth-of-type(1) > .info-component:nth-of-type(1) input";
    public static final String CLIENT_TENANT_LNAME_INPUT = ".tenant-section-form > .row-container:nth-of-type(1) > .info-component:nth-of-type(2) input";
    public static final String CLIENT_TENANT_SALUTATION_SELECT = ".tenant-section-form > .row-container:nth-of-type(2) > .info-component:nth-of-type(1) .MuiInputBase-root";
    public static final String CLIENT_TENANT_SALUTATION_OPTION = ".MuiPaper-root > ul > li:nth-of-type(2)";
    public static final String CLIENT_TENANT_TITLE_INPUT = ".tenant-section-form > .row-container:nth-of-type(2) > .info-component:nth-of-type(2) input";
    public static final String CLIENT_TENANT_EMAIL_INPUT = ".tenant-section-form > .row-container:nth-of-type(3) input";
    public static final String CLIENT_TENANT_PASSWORD_INPUT = ".tenant-section-form > .row-container:nth-of-type(4) > .info-component:nth-of-type(1) input";
    public static final String CLIENT_TENANT_CPASSWORD_INPUT = ".tenant-section-form > .row-container:nth-of-type(4) > .info-component:nth-of-type(2) input";
    public static final String CLIENT_TENANT_MOBILE_INPUT = ".tenant-section-form > .row-container:nth-of-type(5) > .info-component:nth-of-type(1) input";
    public static final String CLIENT_TENANT_PHONE_INPUT = ".tenant-section-form > .row-container:nth-of-type(5) > .info-component:nth-of-type(2) input";
    public static final String CLIENT_TENANT_ADRESS_INPUT = ".tenant-section-form > .row-container:nth-of-type(6) > .info-component input";
    public static final String CLIENT_TENANT_ADDRESS_OPTION = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String CLIENT_TENANT_STATE_SELECT = ".tenant-section-form > .row-container:nth-of-type(7) > .info-component:nth-of-type(1) .MuiInputBase-root";
    public static final String CLIENT_TENANT_CITY_SELECT = ".tenant-section-form > .row-container:nth-of-type(7) > .info-component:nth-of-type(2) .MuiInputBase-root";
    public static final String CLIENT_TENANT_ZIPCODE_SELECT = ".tenant-section-form > .row-container:nth-of-type(7) > .info-component:nth-of-type(3) .MuiInputBase-root";
    public static final String CLIENT_TENANT_CONTINUESTEP2_BUTTON = ".tenant-registration-buttons > div > button";
    public static final String CLIENT_LOCATION_NEW_BUTTON = ".tenant-registration-step-container > div > button";
    public static final String CLIENT_MODAL_LOCATION_CARD = ".location-item";

    //LOCATIONS
    public static final String LOCATION_NEW_BUTTON = ".locations-filters-header > div > div:nth-of-type(4) button";
    public static final String LOCATION_NAME_INPUT = ".location-form-content > div > div:nth-of-type(1) input";
    public static final String LOCATION_OFICCE_DISTANCE_SELECT = ".location-form-content > div > div:nth-of-type(3) .select-row-container > .info-component:nth-of-type(1) .generic-select-container";
    public String LocationOfficeDistanceOption (int distanceOfficePosition){
        return ".MuiPaper-root > ul > li:nth-of-type("+distanceOfficePosition+")";
    }
    public static final String LOCATION_OFFICE_FROM_SELECT = ".location-form-content > div > div:nth-of-type(3) .select-row-container > .info-component:nth-of-type(2) .generic-select-container";
    public String LocationOfficeFromOption (int officeFromPosition){
        return ".MuiPaper-root > ul > li:nth-of-type("+officeFromPosition+")";
    }
    public static final String LOCATION_OFFICE_ADRESS_INPUT = ".location-form-content > div > div:nth-of-type(3) > .row-container > .info-component input";
    public static final String LOCATION_OFFICE_ADRESS_OPTION = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String LOCATION_CONTINUESTEP1_BUTTON = ".new-location-modal-footer > button:nth-of-type(2)";
    public static final String LOCATION_CURRESNTRSF_INPUT = ".lease-details-container > div:nth-of-type(1) > .row-container  > .info-component:nth-of-type(1) input";
    public static final String LOCATION_ANTICIPATEDRSF_INPUT = ".lease-details-container > div:nth-of-type(1) > .row-container  > .info-component:nth-of-type(2) input";
    public static final String LOCATION_EXPIRATIONDAY_CALENDAR_OPEN_BUTTON = ".lease-details-container > div:nth-of-type(1) > .timing-container > .row-container > div:nth-of-type(1) button";
    public static final String LOCATION_NEXT_WEEK_BUTTON = ".MuiPickersLayout-root .MuiPickersArrowSwitcher-root > button:nth-of-type(2)";
    public static final String LOCATION_EXPIRATIONDAY_CALENDAR_DAY_OPTION = ".MuiPickersLayout-root .MuiDayCalendar-monthContainer > div:nth-of-type(2) > button:nth-of-type(3)";
    public static final String LOCATION_NEWOCCUPATION_CALENDAR_OPEN_BUTTON = ".lease-details-container > div:nth-of-type(1) > .timing-container > .row-container > div:nth-of-type(2) button";
    public static final String LOCATION_NEWOCCUPATION_CALENDAR_DAY_OPTION = ".MuiPickersLayout-root .MuiDayCalendar-monthContainer > div:nth-of-type(2) > button:nth-of-type(6)";
    public static final String LOCATION_COMPANYSIZE_ADD_BUTTON = ".lease-details-container > div:nth-of-type(2) .employee-seats-container > div:nth-of-type(1) > div > button:nth-of-type(2)";
    public static final String LOCATION_CONTINUESTEP2_BUTTON = ".new-location-modal-footer > button:nth-of-type(2)";
    public static final String LOCATION_CONTINUESTEP3_BUTTON = ".new-location-modal-footer > button:nth-of-type(2)";
    public static final String LOCATION_SAVE_BUTTON = ".new-location-modal-footer > button:nth-of-type(2)";
    public static final String LOCATION_SELECTTRANSACTION_BUTTON = ".location-form-content > div > div:nth-of-type(2) > div:nth-of-type(1) button";
    public static final String LOCATION_OPTIONTRANSACTION_BUTTON = ".MuiDataGrid-virtualScrollerRenderZone > div:nth-of-type(2) button";
    public static final String CLIENT_CREATE_BUTTON = ".tenant-registration-buttons > div > button";
    public static final String CLIENT_RETURNTOMYCLIENT_BUTTON = ".ReactModal__Content .action-buttons > button:nth-of-type(1)";
    public static final String CLIENT_POPUP_SUCCESS = ".ReactModal__Content";
    public static final String CLIENT_CARD = ".represented-tenants-children-container > span  .represented-tenants-cards-grid-container > .represented-tenants-card-main-container:last-of-type";

    //OFFICES
    public static final String OFFICES_HEADERMENU_BUTTON = ".app-header > div:nth-of-type(4) > button:nth-of-type(2)";
    public static final String OFFICES_NEW_BUTTON = ".offices-page-main-container .content-between > div > button:nth-of-type(2)";
    public static final String OFFICES_LOCATION_NAME_INPUT = ".ReactModal__Content > label input";
    public static final String OFFICES_ADRESS_INPUT = ".ReactModal__Content > div:nth-of-type(2) label input";
    public static final String OFFICES_ADRESS_OPTION = ".pac-container > .pac-item:nth-of-type(1)";
    public static final String OFFICES_STATE_SELECTOR = ".ReactModal__Content > div:nth-of-type(2) > div > div:nth-of-type(1) > div";
    public static final String OFFICES_CITY_SELECTOR = ".ReactModal__Content > div:nth-of-type(2) > div > div:nth-of-type(2) > div";
    public static final String OFFICES_ZIPCODE_SELECTOR = ".ReactModal__Content > div:nth-of-type(2) > div > div:nth-of-type(3) > div";
    public static final String OFFICES_SAVE_BUTTON = ".ReactModal__Content > div:nth-of-type(3) > button:nth-of-type(2)";

    //ACTIVATE LOCATION
    public static final String LOCATION_ACTIVATE_BUTTON = ".locations-grid-container > .location-item:last-of-type button:nth-of-type(1)";
    public static final String LOCATION_ACTIVATE_BUY_CREDITS_BUTTON = ".main-shared-container-body > div:nth-of-type(2) > div:nth-of-type(2) > button:nth-of-type(1)";
    public static final String LOCATION_ACTIVATE_PACKAGE_BRONZE_BUTTON = ".credit-packages-body > div:nth-of-type(2) > div:nth-of-type(1) button";
    public static final String LOCATION_ACTIVATE_PACKAGE_CARDNUMBER_INPUT = ".p-Tabs-group form .p-CardForm > div:nth-of-type(1) input";
    public static final String LOCATION_ACTIVATE_PACKAGE_EXPIRATIONDATE_INPUT = ".p-Tabs-group form .p-CardForm > div:nth-of-type(2) input";
    public static final String LOCATION_ACTIVATE_PACKAGE_CVC_INPUT = ".p-Tabs-group form .p-CardForm > div:nth-of-type(3) input";
    public static final String LOCATION_ACTIVATE_PACKAGE_PAYMENTTERMS_CHECKBOX = "form > div:nth-of-type(2) > label:nth-of-type(1) input";
    public static final String LOCATION_ACTIVATE_PACKAGE_AUTOMATICPAYMENT_CHECKBOX = "form > div:nth-of-type(2) > label:nth-of-type(2) input";
    public static final String LOCATION_ACTIVATE_PACKAGE_PAYNOW_BUTTON = "form > button";
    public static final String LOCATION_ACTIVATE_PACKAGE_GOTOHOME_BUTTON = ".main-shared-container-body > div > div:nth-of-type(3) > button:nth-of-type(1)";
    public static final String LOCATION_ACTIVATE_PACKAGE_PAYMENT_COMPLETED_MESSAGE = ".main-shared-container-body > div:nth-of-type(1) h1";

}
