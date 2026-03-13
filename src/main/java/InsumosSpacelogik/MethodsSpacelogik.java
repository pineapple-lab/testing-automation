package InsumosSpacelogik;

import InsumosArla.SelectorsArla;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.URL;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MethodsSpacelogik extends ContextBaseSpacelogik {
    String recompanieEmail;
    private static final List<String> errores = new ArrayList<>();
    GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    DataTestCaseSpacelogik dataTestCase= new DataTestCaseSpacelogik(generate);
    GeneratorSpaceLogik.EmailInfo emailInfo;
    SelectorsSpacelogik selector =new SelectorsSpacelogik();
    ToastMessageSpacelogik toast = new ToastMessageSpacelogik();
    QueriesSpacelogik sql = new QueriesSpacelogik();
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
    }
    public void setAdminUser(){
        userEmail="admin";
        userPassword = "Pickle30";
    }
    public void setGuruUser(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                userEmail = "FelipeMontoya1770640706141@pineapple-lab.com";
                userPassword = "Pickle30";
                break;
            case "https://space-logic.web.app/":
                userEmail= "ninfajimenez1769799535493@pineapple-lab.com";
                userPassword = "Pickle30";
                break;
        }
    }
    public void setReCompanieUser(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                reCompanieEmail = "MarinaViana1770640127541@pineapple-lab.com";
                userPassword = "Pickle30";
                break;
            case "https://space-logic.web.app/":
                reCompanieEmail = "ZulemaHernandez1769798909068@pineapple-lab.com";
                userPassword = "Pickle30";
                break;
        }
    }
    public void startNavigation(){
        page.navigate(navigationLink);
    }
    private void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*outputStream.println("\n-----------------------------------------------------------");
        outputStream.println("Iniciando ejecucion....");
        outputStream.println("-----------------------------------------------------------");*/
        initializePlaywright();
        setupContextAndPage();
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    public void login(String email, String password){
        userEmail = email;
        page.fill(SelectorsSpacelogik.LOGIN_EMAIL,email);
        page.fill(SelectorsSpacelogik.LOGIN_PASSWORD,password);
        page.click(SelectorsSpacelogik.LOGIN_BUTTON);
        assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
    }
    //SEARCH
    public void goToSearchPage(){
        page.waitForTimeout(3000);
        page.click(SelectorsSpacelogik.SEARCH_MENU_BUTTON);
    }
    public void searchBuilding(String buildingName){
        page.fill(SelectorsSpacelogik.SEARCH_BUILDINGNAME_INPUT, buildingName);
        page.click(SelectorsSpacelogik.SEARCH_BUTTON);
    }
    //RE COMPANIE
    public void goToReCompaniePage(){
        page.click(SelectorsSpacelogik.MENU_ADMIN);
        page.click(SelectorsSpacelogik.RECOMPANIE_MENU_BUTTON);
    }
    public void goToRecompanieForm(){
        page.click(SelectorsSpacelogik.RECOMPANIE_NEW_BUTTON);
    }
    public void completeReCompanieStep1(){
        page.fill(SelectorsSpacelogik.RECOMPANIE_COMPANYNAME_INPUT, generate.generateCompanyName());
        page.waitForTimeout(1000);
        page.locator(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_OPTIONS);
        page.waitForTimeout(1000);
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP1);
    }
    public void completeReCompanieStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.RECOMPANIE_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORD_INPUT,"Pickle30");
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORDCONFIRM_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        System.out.println("Se creo el usuario: "+userEmail);
    }
    public void completeReCompanieStep3(){
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTACTSALUTATION_SELECTOR);
        page.click(selector.SalutationOption(generate.generateSalutation()));
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTITLE_INPUT, generate.generateProfesionalTitle());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTNAME_INPUT, emailInfo.getFirstName());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTLASTNAME_INPUT, emailInfo.getLastName());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTMOBILE_INPUT,generate.generateMobile());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTPHONE_INPUT,generate.generatePhone());
        page.click(SelectorsSpacelogik.RECOMPANIE_SAVE_BUTTON);
    }
    public void createReCompanie(){
        completeReCompanieStep1();
        completeReCompanieStep2();
        completeReCompanieStep3();
    }
    public void executeSweetTestNewReCompanie(Map<String, String> row){
        userEmail = generate.firstName+generate.firstName+dataTestCase.selectCase(row.get(HEADER_EMAIL))+"@"+emailDomain+".com";
        page.fill(SelectorsSpacelogik.RECOMPANIE_COMPANYNAME_INPUT, dataTestCase.selectCase(row.get(HEADER_COMPANYNAME)));
        page.waitForTimeout(1000);
        page.locator(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_OPTIONS);
        page.waitForTimeout(1000);
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP1);
        page.fill(SelectorsSpacelogik.RECOMPANIE_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORD_INPUT,"Pickle30");
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORDCONFIRM_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        System.out.println("Se creo el usuario: "+userEmail);
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTACTSALUTATION_SELECTOR);
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_SALUTATION, row, dataTestCase.getSalutationPreference()));
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTITLE_INPUT, dataTestCase.selectCase(row.get(HEADER_TITLE)));
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTNAME_INPUT, dataTestCase.selectCase(row.get(HEADER_NAME)));
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTLASTNAME_INPUT, dataTestCase.selectCase(row.get(HEADER_LASTNAME)));
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTMOBILE_INPUT,generate.generateMobile());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTPHONE_INPUT,generate.generatePhone());
        page.click(SelectorsSpacelogik.RECOMPANIE_SAVE_BUTTON);
    }
    //OFFICE
    public void goToNewOfficesForm(){
        page.click(SelectorsSpacelogik.OFFICES_HEADERMENU_BUTTON);
        page.click(SelectorsSpacelogik.OFFICES_NEW_BUTTON);
    }
    public void completeFormNewOffice(){
        page.fill(SelectorsSpacelogik.OFFICES_LOCATION_NAME_INPUT, generate.generateLocationName());
        page.locator(SelectorsSpacelogik.OFFICES_ADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(15));
        page.click(SelectorsSpacelogik.OFFICES_ADRESS_OPTION);
        page.click(SelectorsSpacelogik.OFFICES_STATE_SELECTOR);
        page.click(selector.StateOption(generate.generateState()));
        page.click(SelectorsSpacelogik.OFFICES_CITY_SELECTOR);
        page.click(selector.CityOption(generate.generateCity()));
        page.click(SelectorsSpacelogik.OFFICES_ZIPCODE_SELECTOR);
        page.click(selector.ZipcodeOption(generate.generateZipCode()));
    }
    public void createOffice(){
        completeFormNewOffice();
        page.click(SelectorsSpacelogik.OFFICES_SAVE_BUTTON);
    }
    //NATIONAL ACCOUNT
    public void goToNationalAccountPage(){
        page.click(SelectorsSpacelogik.MENU_ADMIN);
        page.click(SelectorsSpacelogik.NACCOUNT_MENU_BUTTON);
    }
    public void goToNationalAccountForm (){
        page.click(SelectorsSpacelogik.NACCOUNT_NEW_BUTTON);
    }
    public void completeNationalAccountStep1(){
        page.waitForTimeout(1000);
        page.fill(SelectorsSpacelogik.NACCOUNT_COMPANY_NAME_INPUT, generate.generateCompanyName());
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_INDUSTRY_SELECT);
        page.click(selector.IndustryOption(generate.generateIndustry()));
        page.locator(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_STATE_SELECT);
        page.click(selector.StateOption(generate.generateState()));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_CITY_SELECT);
        page.click(selector.CityOption(generate.generateCity()));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ZIPCODE_SELECT);
        page.click(selector.ZipcodeOption(generate.generateZipCode()));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_MODAL_OPEN);
        page.locator(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
        verifyToast(toast.FILE_UPLOAD_SUCCESS);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_SAVE);
        page.waitForTimeout(3000);
        page.click(SelectorsSpacelogik.NACCOUNT_CONTINUE_BUTTON);
    }
    public void completeNationalAccountStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_FNAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_LNAME_INPUT, generate.lastName);
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_SALUTATION_SELECT);
        page.click(selector.SalutationOption(generate.generateSalutation()));
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_TITLE_INPUT, generate.generateProfesionalTitle());
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_MOBILE_INPUT, generate.generateMobile());
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_PHONE_INPUT, generate.generatePhone());
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_EMAIL_INPUT, userEmail);
        System.out.println("Se va a crear el usuario: "+userEmail);
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_PASSWORD_INPUT,"Pickle30");
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_CPASSOWRD_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_CONTINUE_BUTTON);
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_CONTINUE_BUTTON);
    }
    public void createNationalAccount(){
        completeNationalAccountStep1();
        completeNationalAccountStep2();
    }
    //GURU
    public void goToNewGuruForm(){
        page.click(SelectorsSpacelogik.PEOPLE_FORM_NEWGURU_BUTTON);
    }
    public void completeNewGuruStep1(){
        emailInfo = generate.generateEmail();
        guruEmail = emailInfo.getEmail();
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SALUTATION_SELECT);
        page.click(selector.SalutationOption(generate.generateSalutation()));
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_TITLE_INPUT, generate.generateProfesionalTitle());
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_NAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_LNAME_INPUT, generate.lastName);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_EMAIL_INPUT, guruEmail);
        System.out.println("Se va a crear el siguiente usuario: "+guruEmail);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_MOBILE_INPUT, generate.generateMobile());
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_PHONE_INPUT, generate.generatePhone());
        page.click(SelectorsSpacelogik.PEOPLE_FORM_CONTINUEANDSAVE_BUTTON);
    }
    public void completeNewGuruStep2(){
        Keyboard kb = page.keyboard();
        page.click(SelectorsSpacelogik.PEOPLE_FORM_OFFICE_SELECT);
        page.click(selector.oficeOption(generate.generateOffice()));
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SKILL_SELECT);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SKILL_OPTION);
        kb.press("Escape");
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_DESCRIPTION_INPUT, generate.generateProfileDescription());

    }
    public void createNewGuru(String reCompanie){
        completeNewGuruStep1();
        completeNewGuruStep2();
        page.waitForTimeout(2000);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_CONTINUEANDSAVE_BUTTON);
        sql.saveUser(guruEmail,reCompanie,navigationLink);
    }
    //LOCATION
    public void goToNewLocationFromNewClientForm(){
        page.click(SelectorsSpacelogik.CLIENT_LOCATION_NEW_BUTTON);
    }
    public void goToLocationView(){
        page.click(SelectorsSpacelogik.CLIENT_CARD);
    }
    public void goToNewLocationForm(){
        page.click(SelectorsSpacelogik.LOCATION_NEW_BUTTON);
    }
    public void completeNewLocationStep1(){
        page.fill(SelectorsSpacelogik.LOCATION_NAME_INPUT,generate.generateLocationName());
        page.click(SelectorsSpacelogik.LOCATION_OFICCE_DISTANCE_SELECT);
        page.click(selector.LocationOfficeDistanceOption(generate.generateDistanceOption()));
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_FROM_SELECT);
        page.click(selector.LocationOfficeFromOption(generate.generateFromOption()));
        page.locator(SelectorsSpacelogik.LOCATION_OFFICE_ADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_ADRESS_OPTION);
        page.click(SelectorsSpacelogik.LOCATION_CONTINUESTEP1_BUTTON);
    }
    public void completeNewLocationStep2(){
        page.fill(SelectorsSpacelogik.LOCATION_CURRESNTRSF_INPUT, generate.generateRsf());
        page.fill(SelectorsSpacelogik.LOCATION_ANTICIPATEDRSF_INPUT, generate.generateRsf());
        page.click(SelectorsSpacelogik.LOCATION_EXPIRATIONDAY_CALENDAR_OPEN_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_EXPIRATIONDAY_CALENDAR_DAY_OPTION);
        page.click(SelectorsSpacelogik.LOCATION_NEWOCCUPATION_CALENDAR_OPEN_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_NEWOCCUPATION_CALENDAR_DAY_OPTION);
        page.click(SelectorsSpacelogik.LOCATION_COMPANYSIZE_ADD_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_CONTINUESTEP2_BUTTON);
    }
    public void createLocation(){
        completeNewLocationStep1();
        completeNewLocationStep2();
        page.click(SelectorsSpacelogik.LOCATION_CONTINUESTEP3_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_SELECTTRANSACTION_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_OPTIONTRANSACTION_BUTTON);
        page.click(SelectorsSpacelogik.LOCATION_SAVE_BUTTON);
    }
    public void goToActivateLocationForm(){
        page.click(SelectorsSpacelogik.CLIENT_CARD);
        page.click(SelectorsSpacelogik.LOCATION_ACTIVATE_BUTTON);
    }
    //CLIENT
    public void goToNewClientForm(){
        page.click(SelectorsSpacelogik.CLIENT_NEW_BUTTON);
        page.click(SelectorsSpacelogik.CLIENT_NEW_REGULARCLIENT_BUTTON);
        page.click(SelectorsSpacelogik.CLIENT_NEW_MODALNEWCLIENT_CONTINUE_BUTTON);
    }
    public void completeNewClientStep1(){
        page.fill(SelectorsSpacelogik.CLIENT_COMPANY_NAME_INPUT, generate.generateCompanyName());
        page.click(SelectorsSpacelogik.CLIENT_INDUSTRY_SELECT);
        page.click(selector.IndustryOption(generate.generateIndustry()));
        page.click(SelectorsSpacelogik.CLIENT_CONTINUESTEP1_BUTTON);
    }
    public void completeNewClientStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_NAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_LNAME_INPUT, generate.lastName);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_TITLE_INPUT, generate.generateProfesionalTitle());
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_PASSWORD_INPUT, "Pickle30");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_CPASSWORD_INPUT, "Pickle30");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_MOBILE_INPUT, generate.generateMobile());
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_PHONE_INPUT, generate.generatePhone());
        page.locator(SelectorsSpacelogik.CLIENT_TENANT_ADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.CLIENT_TENANT_ADDRESS_OPTION);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_CONTINUESTEP2_BUTTON);
    }
    public void createDraftClient(){
        completeNewClientStep1();
        completeNewClientStep2();
    }
    public void createFullClient(){
        createDraftClient();
        goToNewLocationFromNewClientForm();
        createLocation();
        assertComponent(SelectorsSpacelogik.CLIENT_MODAL_LOCATION_CARD);
        page.click(SelectorsSpacelogik.CLIENT_CREATE_BUTTON);
    }
    //PROGRAM
    public void goToProgramView(){
        page.click(SelectorsSpacelogik.CLIENT_CARD);
        page.click(SelectorsSpacelogik.LOCATION_CARD);
        page.click(SelectorsSpacelogik.MENU_SPACE);
        page.click(SelectorsSpacelogik.PROGRAM_MENU_BUTTON);
    }
    public void goToNewProgramForm(){
        page.click(SelectorsSpacelogik.PROGRAM_NEW_BUTTON);
    }

    private void setConstructionLevel(Map<String, String> row){
        Locator constructionLevel = page.locator(generate.generateDataTestCase(VariablesSpacelogik.HEADER_CONSTRUCTION, row, dataTestCase.getLevelConstruction()));
        Locator constructionThumblr = page.locator(SelectorsSpacelogik.PROGRAM_CONSTRUCTION_THUMBLR);
        String constructionTumblrPosicion = constructionThumblr.locator("input").getAttribute("aria-valuenow");
        String constructionNewLevel = constructionLevel.getAttribute("data-index");
        int indexNumerico = Integer.parseInt(constructionNewLevel);
        int nivelEsperado = indexNumerico+1;
        if (Integer.parseInt(constructionTumblrPosicion) != nivelEsperado) {
            constructionThumblr.dragTo(constructionLevel);
        }
    }
    private void setFurnitureLevel(Map<String, String> row){
        Locator furnitureLevel = page.locator(generate.generateDataTestCase(VariablesSpacelogik.HEADER_FURNITURE, row, dataTestCase.getLevelFurniture()));
        Locator furnitureThumblr = page.locator(SelectorsSpacelogik.PROGRAM_FURNITURE_THUMBLR);
        String furnitureThumblrPosicion = furnitureThumblr.locator("input").getAttribute("aria-valuenow");
        String furnitureNewLevel = furnitureLevel.getAttribute("data-index");
        int indexNumerico = Integer.parseInt(furnitureNewLevel);
        int nivelEsperado = indexNumerico+1;
        if (Integer.parseInt(furnitureThumblrPosicion) != nivelEsperado) {
            furnitureThumblr.dragTo(furnitureLevel);
        }
    }
    public void createAutoOfficeProgram(){
        page.click(SelectorsSpacelogik.PROGRAM_AUTOOFFICE_OPTION);
        page.click(SelectorsSpacelogik.PROGRAM_MODALTYPE_CONTINUE_BUTTON);
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_NAME_INPUT, generate.generateCompanyName());
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_INDUSTRY_SELECT);
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_INDUSTRY_OPTION);
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_ADD_BUTTON);
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_NAME_INPUT, generate.buildingName());
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SIZE_SELECT);
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SIZE_OPTION);
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_QUANTITY_INPUT, generate.generateNumber());
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SAVE_BUTTON);
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_CREATE_BUTTON);
    }
    public void executeSweetTestAutoOfficeProgram(Map<String, String> row){
        String valorPICTpri = row.get(VariablesSpacelogik.HEADER_PRIMARY_PREFERENCE);
        String valorPICTsecond = row.get(VariablesSpacelogik.HEADER_SECONDARY_PREFERENCE);
        page.click(SelectorsSpacelogik.PROGRAM_AUTOOFFICE_OPTION);
        page.click(SelectorsSpacelogik.PROGRAM_MODALTYPE_CONTINUE_BUTTON);
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_NAME_INPUT, dataTestCase.selectCase(row.get(HEADER_PROGRAM_NAME)));
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_INDUSTRY_SELECT);
        page.waitForTimeout(1000);
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_INDUSTRY, row, dataTestCase.getIndustryMap()));
        setConstructionLevel(row);
        setFurnitureLevel(row);
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_PRIMARY_PREFERENCE, row, dataTestCase.getWidthPrimaryPreference()));
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_SECONDARY_PREFERENCE, row, dataTestCase.getWidthSecondaryPreference()));
        if ("1_49".equals(valorPICTpri)||"50_100".equals(valorPICTpri)){
            page.fill(SelectorsSpacelogik.PROGRAM_AUTO_WIDTHPRIMARYPREFERENCE_INPUT,generate.generateNumberbetweenOne_oneHundred(VariablesSpacelogik.HEADER_PRIMARY_PREFERENCE, row));
        }
        if ("1_49".equals(valorPICTsecond)||"50_100".equals(valorPICTsecond)){
            page.fill(SelectorsSpacelogik.PROGRAM_AUTO_WIDTHSECONPREFERENCE_INPUT, generate.generateNumberbetweenOne_oneHundred(VariablesSpacelogik.HEADER_SECONDARY_PREFERENCE, row));
        }
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_ADD_BUTTON);
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_NAME_INPUT, dataTestCase.selectCase(row.get(HEADER_ROOM_NAME)));
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_ROOM_TYPE, row, dataTestCase.getRoomTypePreference()));
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SIZE_SELECT);
            page.locator(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SIZE_LIST).filter(new Locator.FilterOptions().setHasText(row.get(VariablesSpacelogik.HEADER_ROOM_SIZE))).click(new Locator.ClickOptions().setForce(true));
        page.click(generate.generateDataTestCase(VariablesSpacelogik.HEADER_NATURAL_LIGHT_PREFERENCE, row, dataTestCase.getLightPreference()));
        page.fill(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_QUANTITY_INPUT, generate.generateNumberbetweenOne_oneHundred(VariablesSpacelogik.HEADER_QUANTITY, row));
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_ROOM_SAVE_BUTTON);
        page.click(SelectorsSpacelogik.PROGRAM_AUTO_CREATE_BUTTON);

    }
    //BUILDINGS
    public void verifyBuildingComponents(){
     page.click(SelectorsSpacelogik.SEARCH_SELECT_BUTTON);
     page.click(SelectorsSpacelogik.BUILDING_MENU_SPACE_BUTTON);
     verifyComponent(SelectorsSpacelogik.WAIT_BUILDING_CHECK_FLOOR, "Floor");
     verifyComponentsList(SelectorsSpacelogik.WAIT_BUILDING_FLOORS_LIST, "Floors encontrados ");
     page.click(SelectorsSpacelogik.BUILDING_MENU_STACKING_BUTTON);
     verifyComponent(SelectorsSpacelogik.WAIT_BUILDING_CHECK_STACKING, "Stacking");
     verifyComponentsList(SelectorsSpacelogik.WAIT_BUILDING_STACKING_LIST, "Stacking encontrados ");
     page.click(SelectorsSpacelogik.BUILDING_MENU_MEDIA_BUTTON);
     verifyComponent(SelectorsSpacelogik.WAIT_BUILDING_CHECK_MEDIA, "Media");
     verifyComponentsList(SelectorsSpacelogik.WAIT_BUILDING_MEDIA_LIST, "Archivos multimedia encontrados ");
    }
    //UTIL
    public void reportCaseNumberToBeTested(int testCaseId){
        System.out.println("\n----------------------------------------------------");
        System.out.println("📊 TESTEANDO CASO DE PRUEBA: " + testCaseId);
    }
    public void startBackendMOnitoring(Page page){
        page.onResponse(response -> {
            String url = response.url();
            int status = response.status();
            String contentType = response.headerValue("content-type");
            if (contentType != null && contentType.contains("application/json")){
                if(status == 200 || status == 201){
                    System.out.println("✅ BACKEND OK [" + status + "]: " + url);
                } else if (status >= 400) {
                    System.err.println("\n⚠️ FALLO DE BACKEND (SQL/API)");
                    System.err.println("URL: " + response.url());
                    System.err.println("Status: " + status + " " + response.statusText());
                    try{
                        String errorDetall = response.text();
                        System.err.println("Detalle del servidor:"+errorDetall);
                    }catch (Exception e){
                        System.err.println("No se pudo leer el cuerpo del error.");
                    }
                    System.err.println("-----------------------------------\n");
                }
            }
        });
    }
    public static void assertVerify(Runnable assertion, String mensaje) {
        try {
            assertion.run();
        } catch (AssertionError e) {
            String errorMsg = "❌ " + mensaje + ": " + e.getMessage();
            System.out.println(errorMsg);
            errores.add(errorMsg);
        }
    }
    public void printErrores() {
        if (!errores.isEmpty()) {
            System.out.println("\n🧾 Errores detectados:");
            errores.forEach(System.out::println);
        } else {
            System.out.println("\n✅ No hubo errores inesperados.");
        }
    }
    public boolean verifyAssertions(Runnable... assertions){
        boolean allPassed = true;
        for (Runnable assertion : assertions) {
            try {
                assertion.run();
            } catch (AssertionError | Exception e) {
                allPassed = false;
                System.out.println("\n❌ Falló una validación: " + e.getMessage());
            }
        }
        return allPassed;
    }
    public void printFinalTestResult(boolean allPassed){
        if (allPassed) {
            System.out.println("\n✅ Prueba superada con éxito");
        } else {
            System.out.println("\n❌ La prueba tuvo errores");
        }
    }
    public void reset() {
        errores.clear();
    }
    public void verifyToast(String expectedMessage) {
        Locator toast = page.locator(SelectorsSpacelogik.APP_TOASTERS).filter(new Locator.FilterOptions().setHasText(expectedMessage)).first();
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            assertVerify(()-> Assertions.assertEquals(expectedMessage, actualText), "El mensaje de confirmación no coincide. "+expectedMessage);
        } catch (PlaywrightException e) {
            assertVerify(() -> {throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);}, "Timeout esperando el toast con mensaje: " + expectedMessage+"\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        }
    }
    public void verifyModalMessage(String expectedMessage) {
        Locator modal = page.locator(SelectorsSpacelogik.GENERIC_MODAL);
        Locator messageLocator = modal.getByText(expectedMessage);
        assertThat(messageLocator).isVisible();
        System.out.println("El modal contiene el mensaje esperado: " + expectedMessage);
    }
    public void assertComponent(String selector) {
        Locator componentLocator = page.locator(selector);
        try {
            componentLocator.waitFor(new Locator.WaitForOptions().setTimeout(14000));
            assertThat(componentLocator).isVisible();
            System.out.println("Componente encontrado: " + selector);
        } catch (TimeoutError e) {
            assertVerify(() -> {
                throw new AssertionError("\n¡Error de Timeout 14s! El componente no apareció en el DOM.\n -> Selector fallido: \"" + selector + "\""+"\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            }, "Timeout esperando el componente: " + selector);
            System.out.println("");

        } catch (AssertionError e) {
            assertVerify(() -> {
                throw new AssertionError("\n¡Error de Visibilidad! El componente no es visible.\n -> Selector fallido: \"" + selector + "\"\nDetalles: " + e.getMessage());
            }, "Verificación de visibilidad fallida: " + selector);
        }
    }
    public void loading(String selector){
        Locator componentLocator = page.locator(selector);
        AtomicBoolean isLoading = new AtomicBoolean(true);

        Thread spinnerThread = new Thread (() -> {
            String [] frames = {"|", "/", "-", "\\"};
            int i = 0;
            while (isLoading.get()){
                System.out.print("\r"+frames[i % frames.length]+" Cargando ");
                try {
                    Thread.sleep(150);
                } catch(InterruptedException e){break;}
                    i++;
            }
        });
        try {
            assertComponent(selector);
            spinnerThread.start();
            componentLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(14000));
            isLoading.set(false);
            System.out.print("\r✅ Cargando\n");
        } catch (TimeoutError e) {
            assertVerify(() -> {
                isLoading.set(false);
                throw new AssertionError("El componente demoro mucho en cargar\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            }, "\\r❌ Cargando (Timeout 14s) ");
        }
    }
    public void compareContentFoundWithSaved(String selector, String contentSaved){
        Locator componentLocator = page.locator(selector);
        try {
            componentLocator.waitFor(new Locator.WaitForOptions()
                    .setTimeout(14000));
            String contentFound = componentLocator.innerText().trim();
            if (contentFound.equals(contentSaved)) {
                System.out.println("✅ Revisando: " + contentSaved);
            }

        } catch (com.microsoft.playwright.TimeoutError e) {
            System.out.println("⏳ " + contentSaved + " no apareció (Timeout 14s). Continuando ejecución...");

        } catch (Exception e) {
            System.out.println("❌ Error inesperado con " + contentSaved + ": " + e.getMessage());
        }
    }
    public void verifyComponent(String selector, String contexto) {
        Locator componentLocator = page.locator(selector);
        try {
            componentLocator.waitFor(new Locator.WaitForOptions()
                    .setTimeout(14000));
            System.out.println("✅ " + contexto);

        } catch (com.microsoft.playwright.TimeoutError e) {
            System.out.println("⏳ " + contexto + " no apareció (Timeout 14s). Continuando ejecución...");

        } catch (Exception e) {
            System.out.println("❌ Error inesperado con " + contexto + ": " + e.getMessage());
        }
    }
    public void verifyComponentsList(String selector, String contexto) {
        Locator components = page.locator(selector);
        try {
            components.first().waitFor(new Locator.WaitForOptions().setTimeout(2000));
            int count = components.count();
            if (count > 0) {
                System.out.println("✅ " + contexto + ": " + count);
            } else {
                System.out.println("⚠ " + contexto + ": VACÍO.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + contexto + ": 0");
        }
    }
    public void verifyInputErrorMessage(String selector, String expectedMessage) {
        try {
            String actualMessage = page.locator(selector).textContent().trim();
            String cleanedExpected = expectedMessage.trim();
            if (!actualMessage.startsWith(cleanedExpected)) {
                throw new AssertionError(
                        "❌ Verificación de contenido fallida para el selector: \"" + selector + "\".\n" +
                                "El mensaje de error no coincide con el esperado.\n" +
                                " -> Esperado: \"" + cleanedExpected+ "\"\n" +
                                " -> Encontrado: \"" + actualMessage+ "\""
                );
            } else{
                System.out.println("Mensaje de error encontrado: " + cleanedExpected);
            }
        } catch (Exception e) {
            throw new AssertionError("No se pudo encontrar el elemento con el selector: " + selector, e);
        }
    }
    //MAPPING
    public List<Map<String, String>> getTestCase(String urlCsv) {
        List<Map<String, String>> listaFinal = new ArrayList<>();
        try {
            URL url = new URL(urlCsv);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream(), "UTF-8"));
            String primeraLinea = reader.readLine();
            if (primeraLinea == null) return listaFinal;
            if (primeraLinea.startsWith("\uFEFF")) {
                primeraLinea = primeraLinea.substring(1);
            }
            String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
            String[] headers = primeraLinea.split(regex);
            String filaTexto;
            while ((filaTexto = reader.readLine()) != null) {
                if (filaTexto.trim().isEmpty()) continue;
                String[] rowValues = filaTexto.split(regex);
                Map<String, String> filaMap = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    String headerName = headers[i].replace("\"", "").trim();
                    String cellValue = (i < rowValues.length) ? rowValues[i].replace("\"", "").trim() : "";
                    filaMap.put(headerName, cellValue);
                }
                listaFinal.add(filaMap);
            }
            reader.close();
            System.out.println("✅ Filas cargadas: " + listaFinal.size());

        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
        return listaFinal;
    }
}
