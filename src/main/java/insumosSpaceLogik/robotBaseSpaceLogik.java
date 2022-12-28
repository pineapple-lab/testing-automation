package insumosSpaceLogik;

import com.microsoft.playwright.Keyboard;

import javax.swing.text.DateFormatter;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class robotBaseSpaceLogik extends comportamientoBaseExcepciones {
    public void obtenerFecha() {
        SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        formattedDate = dtf.format(dateObj);
    }
    public void registrarse() {
        page.navigate("https://space-logic.web.app/react/login");
        page.click("text=REGISTER NOW");
        //campo firstname
        page.fill(".register-form > div:nth-child(1) > div:nth-child(3) input[type=text]", firstNameRegistro);
        //campo lastname
        page.fill(".register-form > div:nth-child(1) > div:nth-child(4) input[type=text]", lastNameRegistro);
        //campo company
        page.fill(".register-form > div:nth-child(1) > div:nth-child(5) input[type=text]", companyRegistro);
        //campo title
        page.fill(".register-form > div:nth-child(1) > div:nth-child(6) input[type=text]", titleRegistro);
        //campo mail
        page.fill(".register-form > div:nth-child(1) > div:nth-child(7) input[type=text]", mailRegistro);
        page.click("#checkTenant");
        page.fill(".register-form > div:nth-child(3) > div:nth-child(3) input[type=password]", passwordRegistro);
        page.fill(".register-form > div:nth-child(3) > div:nth-child(4) input[type=password]", verifyPasswordRegistro);
        page.click("#tosCheckBox");
        page.click(".ModalDiv > input[type=button]");
        page.click("text=REGISTER");
    }
    static public void login() {
        page.navigate("https://space-logic.web.app/react/login");
        page.fill("#txtMail", "admin");
        page.fill("#txtPassword", "Pickle30");
        page.click("'LOG IN'");
    }
    public void logout(){
        page.click(".btn-group");
        page.click(".dropdown-menu-header div:nth-of-type(2) .widget-content-wrapper button");
    }
    public void editarMyDealLeaseTypeLocation(){
        sqlconectar();
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text = My Deal");
        page.click(".deal-location-option-container:nth-of-type(1) div:nth-of-type(2) input");
        page.focus(".deal-current-location-container input");
        kb.press("Control+Shift+End");
        kb.press("Delete");
        kb.insertText(ubicacionMyDealLeaseTypeLocation);
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click(".deal-location-header button");
    }
    public void editarMyDealOfficeSize(){
        sqlconectar();
        page.click("text=MY LOGIK");
        page.click("text = My Deal");
        page.click(".deal-lease-selector-container div:nth-of-type(1) input");
        page.fill(".deal-rsf-lease-container input",rsfMyDealOfficeSize);
        //page.click(".future-employees-specific-headcount-container label input");
        //page.fill(".future-headcount-input",specificHeadCountMyDealOfficeSize);
        //page.click(".growth-adjust-container label:nth-of-type(1) input");
        page.click(".type-container:nth-of-type(1) .deal-lease-container .deal-lease-header button");
    }
    public void editarMyDealOccupancyAndSchedule(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text = My Deal");
        page.click(".deal-lease-selector-container div:nth-of-type(1) input");
        page.focus(".date-dates-container div:nth-of-type(1) input");
        kb.insertText(dateExpirationMydealOccupancyAndSchedule);
        page.focus(".date-dates-container div:nth-of-type(2) input");
        kb.insertText(dateLikeOccupyMydealOccupancyAndSchedule);
        page.click(".type-container:nth-of-type(2) .deal-date-size-header button");
    }
    public void editarMyPreferencesConstructionQualityDefault(){
        page.click("text=MY LOGIK");
        page.click("text = My Preferences");
        page.click(".tenant-preference-component:nth-of-type(1) .level-selection-container > div:nth-of-type(3) button");
        page.click(".tenant-preference-component:nth-of-type(1) .component-title button");
    }
    public void editarMyPreferencesFurnitureQualityDefault(){
        page.click("text=MY LOGIK");
        page.click("text = My Preferences");
        page.click(".tenant-preference-component:nth-of-type(2) .level-selection-container > div:nth-of-type(4) button");
        page.click(".tenant-preference-component:nth-of-type(2) .component-title button");
    }
    public void editarMyPreferenceFinancialDefaults(){
        page.click("text=MY LOGIK");
        page.click("text = My Preferences");
        page.click(".number-changer-body:nth-of-type(1) button:nth-of-type(2)");
        page.click(".number-changer-body:nth-of-type(3) button:nth-of-type(1)");
        page.click(".tenant-preference-component:nth-of-type(3) .component-title button");
    }
    public void editarMyPreferencesYourIndustry(){
        page.click("text=MY LOGIK");
        page.click("text = My Preferences");
        page.click(".radio-answer-container #industry_id6");
        page.click(".tenant-preference-component:nth-of-type(4) .component-title button");
    }
    public void editarMyAmenities(){
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(3) td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".amenities-table-container tbody tr:nth-of-type(1) td:nth-of-type(4) button:nth-of-type(1)");
        page.click(".building-info-header button");
    }
    public void crearProspect() {
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCompanyProspect);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
        page.fill(".contact-info-container > label:nth-of-type(2)", firstNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(3)", lastNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(4)", titleProspect);
        page.fill(".contact-info-container > label:nth-of-type(5)", adress1Prospect);
        page.fill(".contact-info-container > label:nth-of-type(6)", adress2Prospect);
        page.selectOption(".contact-info-container label:nth-of-type(7) > .add-prospect-form-input", stateProspect);
        page.selectOption(".contact-info-container label:nth-of-type(8) > .add-prospect-form-input", cityProspect);
        page.selectOption(".contact-info-container label:nth-of-type(9) > .add-prospect-form-input", zipcodeProspect);
        page.fill(".contact-info-container > label:nth-of-type(10)", emailProspect);
        page.fill(".contact-info-container > label:nth-of-type(11)", phoneProspect);
        page.selectOption(".general-info-container > label:nth-of-type(1)", industryProspect);
        page.fill(".general-info-container > label:nth-of-type(2)", approxRsfProspect);
        page.focus(".general-info-container > label:nth-of-type(3)");
        kb.type(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void archivarProspect() {
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(2)");
    }
    public void eliminarProspect() {
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(3)");
        page.click(".decline-prospect-buttons-container button:nth-of-type(1)");
    }
    public void activarProspect() {
        page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
        page.click(".prospect-list-landlord-table tr:last-child td:last-child");
    }
    public void crearCompetitiveSetProspect() {
        Keyboard kb = page.keyboard();
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(3)");
        page.click(".competitive-prospect-header > button:nth-of-type(1)");
        page.fill(".form-container > label:nth-of-type(1)", buildingCompetitiveSetProspect);
        kb.press("ArrowDown");
        kb.press("Enter");
        page.fill(".form-container > label:nth-of-type(2) > textarea", notesCompetitiveSetProspect);
        page.click(".add-competitive-header button:nth-of-type(1)");
    }
    public void crearTrackingProspect() {
        Keyboard kb = page.keyboard();
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(2)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(4)");
        page.focus(".tracking-modal-container-body-date input[type=date]");
        kb.type(dateTrackingProspect);
        page.fill(".tracking-modal-container-body-subject input[type=text]", subjectTrackingProspect);
        page.fill(".tracking-modal-container-body-comments textarea", commentsTrackingProspect);
        page.focus(".tracking-modal-container-body-follow input[type=date]");
        kb.type(followupTrackingProspect);
        page.click(".tracking-modal-container-header button:nth-of-type(1)");
    }
    public void editarManualmenteInfoBrokerage() {
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-broker-info-contact button");
        page.selectOption(".contact-info-container label:nth-of-type(1) select", salutationEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(2) input", firstNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(3) input", lastNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(4) input", titleEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(5) input", address1EditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(6) input", address2EditBrokerManual);
        page.selectOption(".contact-info-container label:nth-of-type(7) select", stateEditBrokerManual);
        page.selectOption(".contact-info-container label:nth-of-type(8) select", cityEditBrokerManual);
        page.selectOption(".contact-info-container label:nth-of-type(9) select", zipcodeEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(1) input", emailEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(2) input", phoneEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(3) input", mobileEditBrokerManual);
        page.click(".edit-broker-modal-manual-button-action-container button:nth-of-type(1)");
    }
    public void editarPorspectGeneralInfo() {
        Keyboard kb = page.keyboard();
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-tenant-info-contact button");
        page.fill(".edit-prospect-company-container input", nameCompanyEditProspectGeneralInfo);
        page.selectOption(".contact-info-container label:nth-of-type(1) select", salutationEditProspectGeneralInfo);
        page.fill(".contact-info-container label:nth-of-type(2) input", firstNameEditProspectGeneralInfo);
        page.fill(".contact-info-container label:nth-of-type(3) input", lastNameEditProspectGeneralInfo);
        page.fill(".contact-info-container label:nth-of-type(4) input", titleEditProspectGeneralInfo);
        page.fill(".contact-info-container label:nth-of-type(5) input", address1EditProspectGeneralInfo);
        page.fill(".contact-info-container label:nth-of-type(6) input", address2EditProspectGeneralInfo);
        page.selectOption(".contact-info-container label:nth-of-type(7) select", stateEditProspectGeneralInfo);
        page.selectOption(".contact-info-container label:nth-of-type(8) select", cityEditProspectGeneralInfo);
        page.selectOption(".contact-info-container label:nth-of-type(9) select", zipcodeEditProspectGeneralInfo);
        //page.fill(".contact-info-container label:nth-of-type(10) input",emailEditProspectGeneralInfo);
        page.selectOption(".general-info-container label:nth-of-type(1) select", industryEditProspectGeneralInfo);
        page.fill(".general-info-container label:nth-of-type(2) input", approxRsfEditProspectGeneralInfo);
        page.focus(".general-info-container label:nth-of-type(3) input");
        kb.type(ocupancyEditProspectDateGeneralInfo);
        page.fill(".general-info-container label:nth-of-type(4) input", phoneEditProspectGeneralInfo);
        page.fill(".general-info-container label:nth-of-type(5) input", mobileEditGProspecteneralInfo);
        page.click(".private-status-options-container label:nth-of-type(2) input");
        page.click(".edit-prospect-modal-button-container button:nth-of-type(1)");
    }
    public void editarListiningGeneralLocationInformation(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.fill(".location-shared-div div:nth-of-type(1) input", yearBuiltListingLocationInformation);
        page.fill(".location-shared-div div:nth-of-type(2) input", totalBuildingRsfListingLocationInformation);
        page.fill(".location-shared-div div:nth-of-type(3) input", numberOfStoriesListingLocationInformation );
        page.focus(".building-hours-container div tbody tr:nth-of-type(1) td:nth-of-type(3) input");
        kb.insertText(dateMondayFridayListingLocationInformation);
        page.focus(".building-hours-container div tbody tr:nth-of-type(2) td:nth-of-type(3) input");
        kb.insertText(dateSaturdayListingLocationInformation);
        page.focus(".building-hours-container div tbody tr:nth-of-type(3) td:nth-of-type(3) input");
        kb.insertText(dateSundayListingLocationInformation);
        page.click(".location-access-div label:nth-of-type(2) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(1) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(2) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(3) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(4) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(5) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(6) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(7) td:nth-of-type(1) input");
        page.click(".building-hours-holidays-table tbody tr:nth-of-type(8) td:nth-of-type(1) input");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(1) .building-info-header button");
    }
    public void editarListingBuildingCertifications(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) div:nth-of-type(2) label:nth-of-type(3) input");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) div:nth-of-type(3) label:nth-of-type(2) input");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) div:nth-of-type(4) label:nth-of-type(2) input");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) .building-info-header button");
    }
    public void editarListingBuildingDescription(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.focus(".building-general-description-container div:nth-of-type(2) textarea");
        kb.insertText(descriptionBuildingListing);
        page.click(".ButtonSwitch input:nth-of-type(2)");
        page.focus(".building-general-description-container div:nth-of-type(2) textarea");
        kb.insertText(locationBuildingListing);
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) .building-info-header button");
    }
    public void editarListingPrimaryLeasingContact(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(2) button:nth-of-type(1)");
        page.selectOption("form > div:nth-of-type(1) select", saludoListingPrimaryLeasingContact);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(2) input",firstNameListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(3) input",lastNameListingPrimaryLeasingContcts);
        page.fill("form > div:nth-of-type(2) > div:nth-of-type(1) input",companyListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(1) input",address1ListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(2) input",address2ListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(1) select",stateListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(2) select",cityListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(3) select",zipCodeListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(1) input",phoneListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(2) input",emailListingPrimaryLeasingContacts);
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(1) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(2) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(4) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(5) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(6) td:nth-of-type(2) input");
        page.click(".button-container input");
    }
    public void editarListingSecondaryLeasingContact(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(3) button:nth-of-type(1)");
        page.selectOption("form > div:nth-of-type(1) select", saludoListingPrimaryLeasingContact);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(2) input",firstNameListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(3) input",lastNameListingPrimaryLeasingContcts);
        page.fill("form > div:nth-of-type(2) > div:nth-of-type(1) input",companyListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(1) input",address1ListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(2) input",address2ListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(1) select",stateListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(2) select",cityListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(3) select",zipCodeListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(1) input",phoneListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(2) input",emailListingPrimaryLeasingContacts);
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(1) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(2) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(4) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(5) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(6) td:nth-of-type(2) input");
        page.click(".button-container input");
    }
    public void editarListingBuildingOwner(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(4) button:nth-of-type(1)");
        page.selectOption("form > div:nth-of-type(1) select", saludoListingPrimaryLeasingContact);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(2) input",firstNameListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(3) input",lastNameListingPrimaryLeasingContcts);
        page.fill("form > div:nth-of-type(2) > div:nth-of-type(1) input",companyListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(1) input",address1ListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(2) input",address2ListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(1) select",stateListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(2) select",cityListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(3) select",zipCodeListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(1) input",phoneListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(2) input",emailListingPrimaryLeasingContacts);
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(1) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(2) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(4) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(5) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(6) td:nth-of-type(2) input");
        page.click(".button-container input");
    }
    public void editarListingAdditionalLeasingContact(){
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".divBuildingDescription > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(5) button:nth-of-type(1)");
        page.selectOption("form > div:nth-of-type(1) select", saludoListingPrimaryLeasingContact);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(2) input",firstNameListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(1) > div:nth-of-type(3) input",lastNameListingPrimaryLeasingContcts);
        page.fill("form > div:nth-of-type(2) > div:nth-of-type(1) input",companyListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(1) input",address1ListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(3) > div:nth-of-type(2) input",address2ListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(1) select",stateListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(2) select",cityListingPrimaryLeasingContacts);
        page.selectOption("form > div:nth-of-type(4) > div:nth-of-type(3) select",zipCodeListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(1) input",phoneListingPrimaryLeasingContacts);
        page.fill("form > div:nth-of-type(5) > div:nth-of-type(2) input",emailListingPrimaryLeasingContacts);
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(1) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(2) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(4) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(5) td:nth-of-type(2) input");
        page.click("form > div:nth-of-type(6) tbody tr:nth-of-type(6) td:nth-of-type(2) input");
        page.click(".button-container input");
    }
    public void editarListingBuildingRsf(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".BuildingInfoHeaderDiv ul li:nth-of-type(2) input");
        page.click(".building-info-header .floor-space-edit-button");
        page.fill(".floor-space-management-floor-display-container > div:nth-of-type(1) div:nth-of-type(3) input",rsfFloorListingSpaceBuilding);
        page.click(".floor-space-management-buttons-container button:nth-of-type(1)");
    }
    public void crearListingSingleSuiteSpace(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".BuildingInfoHeaderDiv ul li:nth-of-type(2) input");
        page.click(".building-floors-table  tbody > tr:nth-of-type(1) td:nth-of-type(5) button");
        page.click(".building-info-container button");
        page.click(".add-suite-button-container button");
        page.fill(".suite-modal-suite-number",suiteNumberListingSpaceBuildin);
        page.click(".modal-buttons button:nth-of-type(1)");
        page.click(".button-container button:nth-of-type(1)");
    }
    public void eliminarSingleSuiteSpace(){
        page.click(".building-info-container button");
        page.click(".floor-suite-modal-display:first-child td:nth-of-type(1) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.click(".button-container button:nth-of-type(1)");

    }
    public void editarListingSingleSuiteSpace(){
        Keyboard kb = page.keyboard();
        page.click(".floor-styled-table tr:last-child > td:last-child button");
        page.click(".suite-edit-status-butttons label:nth-of-type(1) button");
        page.focus(".suite-edit-inline-inputs-labels > div:first-child input");
        kb.type(dateAvailableListingSingleSuite);
        page.focus(".suite-edit-inline-inputs-labels > div:last-child input");
        kb.type(dateAvailableEndListingSingleSuite);
        page.click(".suite-edit-status-butttons:nth-of-type(1) label:nth-of-type(1) button");
        page.fill(".divisible-container > div:last-child input",divisibleToListingSingleSuite);
        page.click(".floor-allocation-number-display button");
        page.fill(".suite-description-label textarea",suiteDescriptionListingSingleSuite);
        page.click(".suite-description-container .building-info-header button");
    }
    public void editarListingFinancialInfoRateUnaSuite(){
        page.click(".building-finances-container > div:first-child > div:first-child .finances-suite-table-container button");
        page.click(".terms-table-container tbody > tr:nth-of-type(3) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(3) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(3) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(3) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(4) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(4) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(4) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(4) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".building-info-header button:nth-of-type(1)");
    }
    public void editarListingFinancialInfoAbatementUnaSuite(){
        page.click(".building-finances-container > div:first-child > div:first-child .finances-suite-table-container button");
        page.click(".terms-table-container tbody > tr:nth-of-type(8) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(8) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(8) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(8) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".building-info-header button:nth-of-type(1)");
    }
    public void editarListingFinancialInfoCommissionUnaSuite(){
        page.click(".building-finances-container > div:first-child > div:first-child .finances-suite-table-container button");
        page.click(".terms-table-container tbody > tr:nth-of-type(11) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(11) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(11) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(11) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(12) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(12) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(12) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(12) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".building-info-header button:nth-of-type(1)");
    }
    public void editarListingFinancialInfoConstructionUnaSuite(){
        page.click(".building-finances-container > div:first-child > div:first-child .finances-suite-table-container button");
        page.click(".terms-table-container tbody > tr:nth-of-type(15) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(15) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(15) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(15) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(16) > td:nth-of-type(4) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(16) > td:nth-of-type(5) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(16) > td:nth-of-type(6) button:nth-of-type(2)");
        page.click(".terms-table-container tbody > tr:nth-of-type(16) > td:nth-of-type(7) button:nth-of-type(2)");
        page.click(".building-info-header button:nth-of-type(1)");
    }
    public void editarListingFinancialInfoVariables(){
        page.click(".building-finances-container > div:first-child > div:first-child .finances-suite-table-container button");
        page.click(".variables-option-component label:nth-of-type(2) input");
        page.click(".variables-option-container:nth-of-type(2) button:nth-of-type(2)");
        page.click(".building-info-header button:nth-of-type(1)");
    }
    public void editarListingAmenitiesInfo(){
        page.click(".amenities-table tbody tr:first-child button");
        page.click(".amenity-question-button-container button:nth-of-type(1)");
        page.click(".amenity-options div:nth-of-type(1) input");
        page.click(".amenity-options div:nth-of-type(2) input");
        page.click(".amenity-options div:nth-of-type(3) input");
        page.click(".amenity-options div:nth-of-type(4) input");
        page.click(".amenities-header button:nth-of-type(1)");
    }
    public void editarListingExpensesPassedThrough(){
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(2) tbody tr:nth-of-type(1) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(2) tbody tr:nth-of-type(2) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(2) tbody tr:nth-of-type(3) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(2) tbody tr:nth-of-type(4) td:nth-of-type(3) button:nth-of-type(2)");
        page.fill(".building-info-column:nth-of-type(1) > div > div:nth-of-type(2) tbody tr:nth-of-type(4) td:nth-of-type(2) > div > div:nth-of-type(2) input",taxesListingExpenses);
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(3) tbody tr:nth-of-type(1) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(3) tbody tr:nth-of-type(2) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(3) tbody tr:nth-of-type(3) td:nth-of-type(3) button:nth-of-type(2)");
        page.click(".building-info-column:nth-of-type(1) > div > div:nth-of-type(3) tbody tr:nth-of-type(4) td:nth-of-type(3) button:nth-of-type(2)");
        page.fill(".building-info-column:nth-of-type(1) > div > div:nth-of-type(3) tbody tr:nth-of-type(4) td:nth-of-type(2) > div > div:nth-of-type(2) input",expensesListingExpenses);
        page.click(".building-expenses-container > div:nth-of-type(1) .building-info-header button");
    }
    public void editarListingAdditionalTenantExpenses(){
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(1) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(2) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(3) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(4) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(5) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(6) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(7) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(8) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) tbody tr:nth-of-type(9) td:nth-of-type(3)");
        page.click(".building-expenses-container > div:nth-of-type(2) .building-info-header button");
    }
    public void editarListingElectricalExpensesInPremises(){
        page.click(".building-expenses-container > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(3) input");
        page.click(".building-expenses-container > div:nth-of-type(3) .building-info-header button");
    }
    public void crearProposal() {
        Keyboard kb = page.keyboard();
        page.click("text=Proposals");
        page.click("[class=\"default-spacelogik-button\"]");
        page.focus(".new-proposal-modal-container label:nth-of-type(1)");
        kb.insertText(nameProposal);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(2)", building);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(3)", prospect);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(4)", program);
        page.click(".new-proposal-modal-button-container button:nth-of-type(1)");
    }
    public void archivarProposal() {
        page.click("text=Proposals");
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:nth-of-type(4)");
        page.click(".proposal-modal-button-container button:nth-of-type(1)");
    }
    public void eliminarProposal() {
        page.click("text=Proposals");
        page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:last-child");
        page.click(".proposal-modal-button-container button:nth-of-type(1)");
    }
    public void activarProposal() {
        page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:nth-of-type(1)");
    }
    public void crearNuevaVersion() {
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:nth-of-type(2)");
        page.click(".proposal-editing-name-header button:nth-of-type(1)");
    }
    public void llenarProposal() {
        Keyboard kb = page.keyboard();
        page.click("text=Proposals");
        page.click("[class=\"default-spacelogik-button\"]");
        page.focus(".new-proposal-modal-container label:nth-of-type(1)");
        kb.insertText(nameProposal);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(2)", building);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(3)", prospect);
        page.selectOption(".new-proposal-modal-container label:nth-of-type(4)", program);
        page.click(".new-proposal-modal-button-container button:nth-of-type(1)");
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:nth-of-type(1)");
        //BOTON EDIT DEL CAMPO SELECTED SUITES
        page.click(".general-shared-container button:nth-of-type(1)");
        //BOTON ADD DE LA PRIMERA SUITE DE LA LISTA
        page.click(".suite-selector-component tr:nth-child(1) button:nth-of-type(1)");
        //BOTON SAVE DE LA LISTA SUITE
        page.click(".suite-selector-modal-button-container button:nth-child(1)");
        page.fill("#termNumber", term);
        page.fill("#stratingRateNumber", startingRate);
        page.fill("#annualIncreasesNumber", annualIncreases);
        page.fill("#rentAbatementNumber", rentAbatement);
        page.fill("#constructionNumber", construction);
        page.fill("#baseBuildingNumber", baseBuilding);
        //BOTON ADD ADDTIONAL LANDLORD COSTS
        page.click(".additional-landlord-costs-header button:nth-of-type(1)");
        page.fill(".add-cost-info-field-container label:nth-of-type(1)", month);
        page.fill(".add-cost-info-field-container label:nth-of-type(2)", cost);
        //BOTON SAVE DE VENTANA EDIT ADDITIONAL COST
        page.click(".add-cost-modal-button-container button:nth-of-type(1)");
        page.focus(".proposal-options-selected-component label:nth-of-type(1) > input[type=date]");
        kb.type(dateOffered);
        page.focus("#inputNumber");
        kb.type(interestRate);
        //Checkboxcost
        page.click(".proposal-options-selected-container label:nth-of-type(5) > input[type=checkbox]");
        page.click(".proposal-options-selected-container label:nth-of-type(6) > input[type=checkbox]");
        page.click(".proposal-options-selected-container label:nth-of-type(7) > input[type=checkbox]");
        page.click(".proposal-options-selected-container label:nth-of-type(8) > input[type=checkbox]");
        //save
        page.click(".proposal-editing-name-header button:nth-of-type(1)");
    }
    public void crearPrograma() {
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".container-types div:nth-child(1)");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.fill(".add-program-modal-info-container > div:nth-of-type(1) input", nameProgram);
        page.focus(".add-program-modal-info-container > div:nth-of-type(2) input[type=date]");
        kb.type(dateProgram);
        page.click(".add-program-modal-info-container > div:nth-of-type(3) > div > div:nth-of-type(2) button");
        page.click(".add-program-modal-info-container > div:nth-of-type(4) > div > div:nth-of-type(3) button");
        page.click(".add-program-modal-info-container > div:nth-of-type(5) label:nth-of-type(2) input");
        page.click(".add-program-modal-info-container > div:nth-of-type(6) label:nth-of-type(3) input");
        page.click(".add-program-modal-button-container button:nth-of-type(1)");
    }
    public void archivarPrograma(){
        page.click(".program-list-table-container tbody tr:last-child div:last-child button:nth-of-type(3)");
        page.click(".new-building-button-div button:nth-of-type(1)");
    }
    public void borrarPrograma() {
        page.click(".my-programs-header button:nth-of-type(2)");
        page.click(".program-list-table-container table thead th:nth-of-type(2)");
        page.click(".program-list-table-container tbody tr:last-child div:last-child button:nth-of-type(2)");
        page.click(".new-building-button-div button:nth-of-type(1)");
    }
    public void crearRoom() {
        page.click(".program-list-table-container tr:last-child div button:nth-of-type(1)");
        page.click(".program-room-header button:nth-of-type(1)");
    }
    public void guardarRoom() {
        page.click(".program-room-selection-header button");
    }
    public void eliminarRoom() {
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.focus(".my-programs-header input");
        kb.insertText(nameProgram);
        page.click(".program-list-table-container tr:last-child div button:nth-of-type(1)");
        page.click(".program-room-list-table-container tr:last-child td:nth-of-type(2)");
        page.click(".program-room-header button:nth-of-type(2)");
        page.click(".new-building-button-div button:nth-of-type(1)");
    }
    public void editarRoomOptions() {
        page.click(".program-room-selection-button-container button:nth-of-type(2)");
        page.fill(".sequence-div input", sequenceRoomOptionsProgram);
        page.click("[value=\""+employeAreaTypesProgram+"\"]");
        page.click("[value=\""+roomSizeProgram+"\"]");
        page.fill(".quantity-input-container input", quantityRoomOptionsProgram);
        page.click(".program-room-selection-header button");
    }
    public void editarSpacePlanRoomDetails() {
        page.click(".program-room-detail-areas-container button:nth-of-type(2)");
        page.click(".room-details-border-container [value=\"1\"]");
        page.click(".adjacencies-color-container div:nth-of-type(6)");
        page.fill(".space-plan-comment-container textarea", commentsRoomDetails);
        page.click(".space-plan-save-container button");
    }
    public void editarConstructionLevelRoomDetails(){
        page.click(".program-room-detail-areas-container button:nth-of-type(3)");
        page.click(".construction-level-container div:nth-of-type(4) button");
        page.click(".room-details-construction-component:nth-of-type(1) .room-details-save-button");
        page.click(".new-building-button-div button:nth-of-type(1)");
    }
    public void editarUpgradeOptionsRoomDetails(){
        page.click(".program-room-detail-areas-container button:nth-of-type(3)");
        page.click(".room-details-construction-component:nth-of-type(2) input");
        page.click(".room-details-construction-component:nth-of-type(2) .room-details-save-button");
    }
    public void editarAlacarteOptionsRoomDetails(){
        page.click(".program-room-detail-areas-container button:nth-of-type(3)");
        page.click(".room-details-construction-component:nth-of-type(3) .construction-expand-button");
        page.click(".room-details-construction-component:nth-of-type(3) .construction-upgrade-level-container div:nth-of-type(4) input");
        page.click(".room-details-construction-component:nth-of-type(3) .room-details-save-button");
    }
    public void crearAutoProgram(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.focus(".office-question-info-container input");
        kb.insertText(nameAutoProgram);
        page.selectOption(".office-question-info-container select",industryAutoProgram);
        page.click(".office-setup-container div:nth-of-type(2) #option-construction-level-3");
        page.click(".office-setup-container .office-question-info-container div:nth-of-type(2) .office-setup-level-selection-container div:nth-of-type(4) button");
        page.focus(".create-plan-info-input-container input");
        kb.insertText(nameRoomAutoProgram);
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Private Office(s)\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Locate on interior\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"10*15\"]");
        page.focus(".plan-info-option-component-wrapper div:nth-of-type(2) .plan-info-quantity-container input");
        kb.insertText(quantityAutoProgram);
        page.click(".create-plan-info-container div .plan-add-room-button-container button:nth-of-type(1)");
        page.click(".create-plan-info-container div:nth-of-type(5) button");
    }
    public void crearLaunch(){
        Keyboard kb = page.keyboard();
        page.click("text=CONTEST");
        page.click("text=Launch");
        page.focus(".contest-details-timing-body input:nth-of-type(1)");
        kb.type(dateDeadLineLaunch);
        page.focus(".contest-details-timing-body input:nth-of-type(2)");
        kb.type(dateOccupancyLaunch);
        page.click(".contest-details-settings-container div:nth-of-type(3) .requested-terms-table tr:nth-of-type(2) td:nth-of-type(2) button");
        page.click(".contest-details-settings-container div:nth-of-type(5) .requested-terms-table tr:nth-of-type(3) td:nth-of-type(2) button");
        page.click(".contest-details-financial-checkbox label:nth-of-type(2) input");
        page.selectOption(".contest-corporation-container select",legalFormationLaunch);
        page.fill(".contest-corporation-container input",bussinesSinceLaunch);
        page.click(".contest-details-buttons-container button:nth-of-type(5)");
        page.click(".saved-buildings-table tbody tr:nth-of-type(7) td:nth-of-type(1) input");
        page.click(".saved-buildings-table tbody tr:nth-of-type(8) td:nth-of-type(1) input");
        page.click(".saved-buildings-table tbody tr:nth-of-type(9) td:nth-of-type(1) input");
        page.click(".contest-details-buttons-container button:nth-of-type(4)");
        page.click(".contest-details-buttons-container button:nth-of-type(5)");
        page.click(".contest-details-buildings-body div:nth-of-type(2).building-display-container div:nth-of-type(6) input");
        page.click(".contest-details-buildings-body div:nth-of-type(2).building-display-container div:nth-of-type(7) input");
        page.click(".contest-details-buildings-body div:nth-of-type(3).building-display-container div:nth-of-type(6) input");
        page.click(".contest-details-buildings-body div:nth-of-type(3).building-display-container div:nth-of-type(7) input");
        page.click(".launch-contest-buttons-container button:nth-of-type(1)");
    }
    public void crearTweak(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Tweak");
        page.focus(".program-selector-wrapper input");
        kb.insertText(selectProgramTweak);
        kb.press("ArrowDown");
        kb.press("Enter");
        page.selectOption(".area-display-size-select", sizeTweak);
        page.fill(".room-list-area-display-row td:nth-of-type(3) .number-input-container #inputNumber",qtyTweak);
        page.click(".saved-building-list li:nth-of-type(2) input");
        page.click(".adjust-program-room-list-selector button:nth-of-type(2)");
        page.fill(".save-program-modal-container input",programNameTweak);
        page.click(".modal-buttons button:nth-of-type(1)");
    }
    public void crearCompareTerm3(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(1)");
        page.focus(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void crearCompareTerm5(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(2)");
        page.focus(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void crearCompareTerm7(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(3)");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void crearCompareTerm10(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(4)");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void crearCompareTerm12(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(5)");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void crearCompareTerm15(){
        Keyboard kb = page.keyboard();
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".term-selection-container button:nth-of-type(6)");
        page.click(".compare-building-list-table tbody tr:nth-of-type(1) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(3) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(4) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(5) input");
        page.click(".compare-building-list-table tbody tr:nth-of-type(6) input");
        page.click(".compare-buildings-info-header button:nth-of-type(4)");
        page.focus(".save-comparison-as-modal-input");
        kb.insertText(nameComparison);
        page.click(".button-container button:nth-of-type(1)");
    }
    public void borrarCompare(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".compare-buildings-info-header button:nth-of-type(2)");
        page.click(".compare-list-modal-table tbody tr:last-child td:last-child button:nth-of-type(2)");
    }
    public void abrirCompare(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Compare");
        page.click(".compare-buildings-info-header button:nth-of-type(2)");
        page.click(".compare-list-modal-table tbody tr:last-child td:last-child button:nth-of-type(1)");
    }
    public void guardarCompare(){
        page.click(".compare-building-list-table tbody tr:nth-of-type(2) input");
        page.click(".compare-buildings-info-header button:nth-of-type(3)");
    }
}
