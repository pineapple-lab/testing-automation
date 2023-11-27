package insumosSpaceLogik;

import com.microsoft.playwright.Keyboard;

public class comportamientoBaseExcepciones extends queriesSQLcasesFailed{
    public void excepcionLogin(){
        page.navigate("https://space-logic.web.app/react/login");
        page.click("'LOG IN'");
    }
    public void excepcionProposalNombreVacio(){
        //page.click(".app-sidebar__inner > div > ul > li:nth-of-type(4)");
        page.click("text=Proposals");
        page.click("[class=\"default-spacelogik-button\"]");
        page.click(".new-proposal-modal-button-container button:nth-of-type(1)");
    }
    public void excepcionProgramNombreVacio(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".container-types div:nth-child(1)");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.click(".add-program-modal-button-container button:nth-of-type(1)");
    }
    public void excepcionAutoProgramNombreVacio(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.selectOption(".office-question-info-container select",industryAutoProgram);
        page.click(".office-setup-container div:nth-of-type(2) #option-construction-level-3");
        page.click(".office-setup-container .office-question-info-container div:nth-of-type(2) .office-setup-level-selection-container div:nth-of-type(4) button");
        page.fill(".create-plan-info-input-container input",nameRoomAutoProgram);
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Private Office(s)\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Locate on interior\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"10*15\"]");
        page.fill(".plan-info-option-component-wrapper div:nth-of-type(2) .plan-info-quantity-container input",quantityAutoProgram);
        page.click(".create-plan-info-container div .plan-add-room-button-container button:nth-of-type(1)");
        page.click(".create-plan-info-container div:nth-of-type(5) button");
    }
    public void excepcionProgramRoomNameVacio(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.fill(".office-question-info-container input",nameCase);
        page.selectOption(".office-question-info-container select",industryAutoProgram);
        page.click(".office-setup-container div:nth-of-type(2) #option-construction-level-3");
        page.click(".office-setup-container .office-question-info-container div:nth-of-type(2) .office-setup-level-selection-container div:nth-of-type(4) button");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Private Office(s)\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Locate on interior\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"10*15\"]");
        page.fill(".plan-info-option-component-wrapper div:nth-of-type(2) .plan-info-quantity-container input",quantityAutoProgram);
        page.click(".create-plan-info-container div .plan-add-room-button-container button:nth-of-type(1)");
    }
    public void excepcionProgramLevelVacio(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(5)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.fill(".office-question-info-container input",nameAutoProgram);
        page.selectOption(".office-question-info-container select",industryAutoProgram);
        page.fill(".create-plan-info-input-container input",nameRoomAutoProgram);
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Private Office(s)\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Locate on interior\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"10*15\"]");
        page.fill(".plan-info-option-component-wrapper div:nth-of-type(2) .plan-info-quantity-container input",quantityAutoProgram);
        page.click(".create-plan-info-container div .plan-add-room-button-container button:nth-of-type(1)");
        page.click(".create-plan-info-container div:nth-of-type(5) button");
    }
    public void excepcionProgramAreaListVacio(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.click(".my-programs-header div:nth-of-type(3) button");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.fill(".office-question-info-container input",nameCase);
        page.selectOption(".office-question-info-container select",industryAutoProgram);
        page.click(".office-setup-container div:nth-of-type(2) #option-construction-level-3");
        page.click(".office-setup-container .office-question-info-container div:nth-of-type(2) .office-setup-level-selection-container div:nth-of-type(4) button");
        page.fill(".create-plan-info-input-container input",nameRoomAutoProgram);
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Private Office(s)\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Locate on interior\"]");
        page.click(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"10*15\"]");
        page.fill(".plan-info-option-component-wrapper div:nth-of-type(2) .plan-info-quantity-container input",quantityAutoProgram);
        page.click(".create-plan-info-container div:nth-of-type(5) button");
    }
    public void excepcionProspectCompanyNamevacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
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
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectEmailVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
        page.fill(".contact-info-container > label:nth-of-type(2)", firstNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(3)", lastNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(4)", titleProspect);
        page.fill(".contact-info-container > label:nth-of-type(5)", adress1Prospect);
        page.fill(".contact-info-container > label:nth-of-type(6)", adress2Prospect);
        page.selectOption(".contact-info-container label:nth-of-type(7) > .add-prospect-form-input", stateProspect);
        page.selectOption(".contact-info-container label:nth-of-type(8) > .add-prospect-form-input", cityProspect);
        page.selectOption(".contact-info-container label:nth-of-type(9) > .add-prospect-form-input", zipcodeProspect);
        page.fill(".contact-info-container > label:nth-of-type(11)", phoneProspect);
        page.selectOption(".general-info-container > label:nth-of-type(1)", industryProspect);
        page.fill(".general-info-container > label:nth-of-type(2)", approxRsfProspect);
        page.focus(".general-info-container > label:nth-of-type(3)");
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectFormatoEmailIncorrecto(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
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
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectFirstNameVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
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
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");}
    public void excepcionProspectLastNameVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
        page.fill(".contact-info-container > label:nth-of-type(2)", firstNameProspect);
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
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectCityVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
        page.fill(".contact-info-container > label:nth-of-type(2)", firstNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(3)", lastNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(4)", titleProspect);
        page.fill(".contact-info-container > label:nth-of-type(5)", adress1Prospect);
        page.fill(".contact-info-container > label:nth-of-type(6)", adress2Prospect);
        page.fill(".contact-info-container > label:nth-of-type(10)", emailProspect);
        page.fill(".contact-info-container > label:nth-of-type(11)", phoneProspect);
        page.selectOption(".general-info-container > label:nth-of-type(1)", industryProspect);
        page.fill(".general-info-container > label:nth-of-type(2)", approxRsfProspect);
        page.focus(".general-info-container > label:nth-of-type(3)");
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectZipCodeVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
        page.selectOption(".contact-info-container > label:nth-of-type(1)", salutationProspect);
        page.fill(".contact-info-container > label:nth-of-type(2)", firstNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(3)", lastNameProspect);
        page.fill(".contact-info-container > label:nth-of-type(4)", titleProspect);
        page.fill(".contact-info-container > label:nth-of-type(5)", adress1Prospect);
        page.fill(".contact-info-container > label:nth-of-type(6)", adress2Prospect);
        page.selectOption(".contact-info-container label:nth-of-type(7) > .add-prospect-form-input", stateProspect);
        page.selectOption(".contact-info-container label:nth-of-type(8) > .add-prospect-form-input", cityProspect);
        page.fill(".contact-info-container > label:nth-of-type(10)", emailProspect);
        page.fill(".contact-info-container > label:nth-of-type(11)", phoneProspect);
        page.selectOption(".general-info-container > label:nth-of-type(1)", industryProspect);
        page.fill(".general-info-container > label:nth-of-type(2)", approxRsfProspect);
        page.focus(".general-info-container > label:nth-of-type(3)");
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectIndustryVacio(){
        Keyboard kb = page.keyboard();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        page.click(".prospect-list-landlord-button-container > button:nth-of-type(1)");
        page.fill(".add-prospect-company-container > label:nth-of-type(1)", nameCase);
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
        page.fill(".general-info-container > label:nth-of-type(2)", approxRsfProspect);
        page.focus(".general-info-container > label:nth-of-type(3)");
        kb.insertText(ocupancyDateProspect);
        page.click(".add-prospect-modal-button-container > button:nth-of-type(1)");
    }
    public void excepcionProspectCompetitiveSetBuildingVacio(){
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(3)");
        page.click(".competitive-prospect-header > button:nth-of-type(1)");
        page.fill(".form-container > label:nth-of-type(2) > textarea", notesCompetitiveSetProspect);
        page.click(".add-competitive-header button:nth-of-type(1)");
    }
    public void excepcionProspectTrackingSubjectVacio(){
        Keyboard kb = page.keyboard();
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(2)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(4)");
        page.focus(".tracking-modal-container-body-date input[type=date]");
        kb.type(dateTrackingProspect);
        page.fill(".tracking-modal-container-body-comments textarea", commentsTrackingProspect);
        page.focus(".tracking-modal-container-body-follow input[type=date]");
        kb.type(followupTrackingProspect);
        page.click(".tracking-modal-container-header button:nth-of-type(1)");
    }
    public void excepcionProspectDateSubjectVacio(){
        Keyboard kb = page.keyboard();
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(2)");
        page.click(".view-prospect-list-landlord-button-container > button:nth-of-type(4)");
        page.fill(".tracking-modal-container-body-subject input[type=text]", subjectTrackingProspect);
        page.fill(".tracking-modal-container-body-comments textarea", commentsTrackingProspect);
        page.focus(".tracking-modal-container-body-follow input[type=date]");
        kb.type(followupTrackingProspect);
        page.click(".tracking-modal-container-header button:nth-of-type(1)");
    }
    public void excepcionProspectFirstNameVacioEditBrokerInfo(){
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-broker-info-contact button");
        page.selectOption(".contact-info-container label:nth-of-type(1) select", salutationEditBrokerManual);
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
    public void excepcionProspectLastNameVacioEditBrokerInfo(){
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-broker-info-contact button");
        page.selectOption(".contact-info-container label:nth-of-type(1) select", salutationEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(2) input", firstNameEditBrokerManual);
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
    public void excepcionProspectEmailVacioEditBrokerInfo(){
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
        page.fill(".general-info-container label:nth-of-type(2) input", phoneEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(3) input", mobileEditBrokerManual);
        page.click(".edit-broker-modal-manual-button-action-container button:nth-of-type(1)");
    }
    public void excepcionProspectEmailFormatoIncorrectoEditBrokerInfo(){
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
    public void excepcionProspectCityVacionEditBrokerInfo(){
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-broker-info-contact button");
        page.selectOption(".contact-info-container label:nth-of-type(1) select", salutationEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(2) input", firstNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(3) input", lastNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(4) input", titleEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(5) input", address1EditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(6) input", address2EditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(1) input", emailEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(2) input", phoneEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(3) input", mobileEditBrokerManual);
        page.click(".edit-broker-modal-manual-button-action-container button:nth-of-type(1)");
    }
    public void excepcionProspectZipCodeVacioEditBrokerInfo(){
        page.click(".prospect-list-landlord-table tr:last-child div > button:nth-of-type(1)");
        page.click(".view-prospect-general-broker-info-contact button");
        page.selectOption(".contact-info-container label:nth-of-type(1) select",salutationEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(2) input", firstNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(3) input", lastNameEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(4) input", titleEditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(5) input", address1EditBrokerManual);
        page.fill(".contact-info-container label:nth-of-type(6) input", address2EditBrokerManual);
        page.selectOption(".contact-info-container label:nth-of-type(7) select", stateEditBrokerManual);
        page.selectOption(".contact-info-container label:nth-of-type(8) select", cityEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(1) input", emailEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(2) input", phoneEditBrokerManual);
        page.fill(".general-info-container label:nth-of-type(3) input", mobileEditBrokerManual);
        page.click(".edit-broker-modal-manual-button-action-container button:nth-of-type(1)");
    }
}
