package InsumosSpacelogik;

import InsumosArla.SelectorsArla;
import clojure.lang.Var;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.Map;

public class TestCaseSpacelogik extends ContextBaseSpacelogik{
    private final GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    MethodsSpacelogik methods = new MethodsSpacelogik();
    ToastMessageSpacelogik toast = new ToastMessageSpacelogik();
    ModalMessageSpaceLogik modal = new ModalMessageSpaceLogik();
    ErrorPathSpaceLogik errorPath = new ErrorPathSpaceLogik();
    VariablesSpacelogik variables = new VariablesSpacelogik();
//LOGIN
    public void happyPathLogin(){
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
            methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
        cleanupContext();
    }
 //SEARCH
    public void happyPathSearchBuilding(){
        methods.setAdminUser();
        //methods.startBackendMOnitoring(page);
        System.out.println("Se va a comprobar la informacion de "+generate.generateExecutions()+" buildings\n");
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        methods.assertComponent(SelectorsSpacelogik.MENU_ADMIN);
        System.out.println("----------------------------------------------------------------");
        page.click(SelectorsSpacelogik.MENU_ADMIN);
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            String buildingName = generate.buildingName();
            methods.goToSearchPage();
            methods.searchBuilding(buildingName);
            methods.loading(SelectorsSpacelogik.WAIT_SEARCH_LOADER_CHECK);
            methods.compareContentFoundWithSaved(SelectorsSpacelogik.WAIT_SEARCH_CHECK,buildingName);
            methods.verifyBuildingComponents();
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
        cleanupContext();
    }
//TEST CASE RECOMPANIE
    public void happyPathReCompanieCreate(){
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" ReCompanie\n");
        try{
            methods.runSafely(() -> {
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.goToReCompaniePage();
            methods.goToRecompanieForm();
            methods.createReCompanie();
            methods.verifyToast(toast.RECOMPANIE_SUCCESS);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
            });
            methods.printErrores();
            methods.reset();
    }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewReCompanie(){
        testCaseInitials = "REC";
        String spreadsheetId = "1EpqGvtV-eLPT7KCD2alu3MZWH0k-iMl3BnAD_zZCJS0";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" ReCompanie\n");

        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                if(executeCounter>1){
                    methods.goToRecompanieForm();
                }
                methods.executeSweetTestNewReCompanie(currentRow);
                methods.verifyToast(toast.RECOMPANIE_SUCCESS);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        } catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        } finally{
            cleanupContext();
        }
    }
    public void assertReCompanieFormEmptyInputs() {
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 1 del formulario de creacion de re companies\n");
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        try{
            methods.runSafely(() -> {
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
               boolean verify1 = errorPath.verifyReCompanieFormStep1EmptyInputs();
               boolean verify2 = errorPath.verifyReCompanieFormStep2EmptyInputs();
               boolean verify3 = errorPath.verifyReCompanieFormStep3EmptyInputs();
                variables.allStepsPassed &= (verify1 && verify2 && verify3);
            }
            });
            methods.printFinalTestResult(variables.allStepsPassed);
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    //NATIONAL ACCOUNT
    public void happyPathNationalAccountCreate(){
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        try{
            methods.runSafely(() -> {
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        methods.goToNationalAccountPage();
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                methods.createNationalAccount();
                methods.verifyToast(toast.NATIONALACCOUNT_SUCCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void assertNationalAccountFormEmptyInputs(){
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        try{
            methods.runSafely(() -> {
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        methods.goToNationalAccountPage();
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                boolean verify1 = errorPath.verifyNationalAccountFormStep1EmptyInputs();
                boolean verify2 = errorPath.verifyNationalAccountFormStep2EmptyInputs();
                variables.allStepsPassed &= (verify1 && verify2);
            }
            methods.printFinalTestResult(variables.allStepsPassed);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    //OFFICE
    public void happyPathOfficeCreate(){
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" offices\n");
        try{
            methods.runSafely(() -> {
        methods.login(reCompanieEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewOfficesForm();
                methods.createOffice();
                methods.verifyToast(toast.OFFICES_SUCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    //GURU
    public void happyPathGuruCreate(){
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Guru\n");
        try{
            methods.runSafely(() -> {
        methods.login(reCompanieEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);

                for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                    methods.goToNewGuruForm();
                    methods.createNewGuru(reCompanieEmail);
                    methods.assertComponent(SelectorsSpacelogik.PEOPLE_FORM_POPUP_SUCCESSFULLY);
                    methods.verifyToast(toast.GURU_SUCCESS);
                    page.click(SelectorsSpacelogik.PEOPLE_FORM_POPUP_OK_BUTTON);
                    methods.assertComponent(SelectorsSpacelogik.WAIT_RECOMPANIE_TABLE_FIRSTROW);
                    System.out.println("\nse compeleto " + executeCounter + " ejecuciones");
                    System.out.println("----------------------------------------------------\n");
                }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewGuru(){
        testCaseInitials = "NG";
        String spreadsheetId = "1h0V2UwPbTL-hs2lDya3cskx4BwJjx7IZfDq-muQLbe0";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Guru\n");
        System.out.println(reCompanieEmail);
        methods.login(reCompanieEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                methods.goToNewGuruForm();
                methods.executeSweetTestNewGuru(currentRow);
                methods.assertComponent(SelectorsSpacelogik.PEOPLE_FORM_POPUP_SUCCESSFULLY);
                methods.verifyToast(toast.GURU_SUCCESS);
                page.click(SelectorsSpacelogik.PEOPLE_FORM_POPUP_OK_BUTTON);
                methods.assertComponent(SelectorsSpacelogik.WAIT_RECOMPANIE_TABLE_FIRSTROW);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeleto "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        } catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        } finally{
            cleanupContext();
        }
    }
    //CLIENT
    public void happyPathClientCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Clients\n");
        try{
            methods.runSafely(() -> {
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewClientForm();
                methods.createFullClient();
                methods.assertComponent(SelectorsSpacelogik.CLIENT_POPUP_SUCCESS);
                methods.verifyModalMessage(modal.CLIENT_HEADER_SUCCESSFULLY);
                methods.verifyModalMessage(modal.CLIENT_BODY1_SUCCESSFULLY);
                methods.verifyModalMessage(modal.CLIENT_BODY2_SUCCESSFULLY);
                page.click(SelectorsSpacelogik.CLIENT_RETURNTOMYCLIENT_BUTTON);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewClient(){
        testCaseInitials = "RC";
        String spreadsheetId = "1qlQW4fvPW93Fh6aCFntUBxFzNRLL-fP1Kp7MLweCY3o";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Clients\n");
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                methods.goToNewClientForm();
                methods.executeSweetTestNewClient(currentRow);
                methods.assertComponent(SelectorsSpacelogik.CLIENT_POPUP_SUCCESS);
                methods.verifyModalMessage(modal.CLIENT_HEADER_SUCCESSFULLY);
                methods.verifyModalMessage(modal.CLIENT_BODY1_SUCCESSFULLY);
                methods.verifyModalMessage(modal.CLIENT_BODY2_SUCCESSFULLY);
                page.click(SelectorsSpacelogik.CLIENT_RETURNTOMYCLIENT_BUTTON);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        }finally{
            cleanupContext();
        }
    }
    public void happyPathCreateClientAndLocationMultipleGuru() {
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear " + generate.generateExecutions() + " clientes y locations\n");
        page.waitForTimeout(1000);
            try{
                methods.runSafely(() -> {
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.createClientAndLocationMultipleGuru();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
                });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
    //LOCATION
    public void happyPathLocationCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" locations\n");
        try{
            methods.runSafely(() -> {
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        page.waitForTimeout(3000);
        methods.assertComponent(SelectorsSpacelogik.CLIENT_CARD);
        methods.goToLocationView();
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewLocationForm();
                methods.createLocation();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewLocation(){
        testCaseInitials = "LOC";
        String spreadsheetId = "1vcNY38yuAPCmfhiCjvfode_KzLVo7mV2MF330IEq1Zg";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" locations\n");
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        page.waitForTimeout(3000);
        methods.assertComponent(SelectorsSpacelogik.CLIENT_CARD);
        methods.goToLocationView();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                methods.goToNewLocationForm();
                methods.excuteSweetTestNewLocation(currentRow);
                page.waitForTimeout(1000);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        }finally{
            cleanupContext();
        }
    }
    public void happyPathAcivateLocationMultipleGuru() {
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a activar locations para " + generate.generateExecutions() + " usuarios\n");
        page.waitForTimeout(1000);
        try{
            methods.runSafely(() -> {
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.activateLocationMultipleGuru();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
    //AUTOOFFICE PROGRAM
    public void happyPathAutoofficeProgramCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        try{
            methods.runSafely(() -> {
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        page.waitForSelector(SelectorsSpacelogik.CLIENT_CARD);
        page.waitForTimeout(3000);
        methods.goToProgramView();
        System.out.println("Se van a crear "+generate.generateExecutions()+" programs\n");
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                System.out.println("\n----------------------------------------------------");
                page.click(SelectorsSpacelogik.MENU_SPACE);
                page.click(SelectorsSpacelogik.PROGRAM_MENU_BUTTON);
                methods.goToNewProgramForm();
                methods.createAutoOfficeProgram();
                methods.verifyToast(toast.PROGRAM_SUCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
                page.waitForTimeout(3000);
            }
            });
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewAutoofficeProgram(){
        testCaseInitials = "AP";
        String spreadsheetId = "1Goc7muuoXZ3FEzFpZ4ol7aSASlZum7ubgEmmLSZbuUc";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        page.waitForSelector(SelectorsSpacelogik.CLIENT_CARD);
        page.waitForTimeout(3000);
        methods.goToProgramView();
        System.out.println("Se van a crear "+generate.generateExecutions()+" programs\n");
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                page.click(SelectorsSpacelogik.PROGRAM_MENU_BUTTON);
                methods.goToNewProgramForm();
                methods.executeSweetTestAutoOfficeProgram(currentRow);
                methods.verifyToast(toast.PROGRAM_SUCESS);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
                page.waitForTimeout(2000);
            }
            methods.printErrores();
            methods.reset();
        } catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        } finally{
            cleanupContext();
        }
    }
    //STANDARDPROGRAM
    public void executeSweetCaseNewStandardProgram(){
        testCaseInitials = "SP";
        String spreadsheetId = "1aN1XF-RSJ9nXELu3zZIjfaKx0S0dzsfU4zQlF2HIwFQ";
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/"+spreadsheetId+"/export?format=csv";
        String clientName = "CorporateAccount11372003";
        GoogleSheetsService gSheets = null;
        try {
            gSheets = new GoogleSheetsService("src/main/resources/credentials.json");
        } catch (Exception e) {
            System.err.println("Error crítico: No se pudo cargar el archivo credentials.json");
        }
        if (gSheets != null) gSheets.startReporting(spreadsheetId);
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        methods.login(userEmail, userPassword);
        methods.assertComponent(SelectorsSpacelogik.WAIT_LOGIN_PROFILE);
        page.waitForSelector(SelectorsSpacelogik.CLIENT_CARD);
        page.waitForTimeout(3000);
        methods.searchClient(clientName);
        methods.goToProgramView();
        System.out.println("Se van a crear "+generate.generateExecutions()+" programs\n");
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                methods.reportCaseNumberToBeTested(testCaseInitials, executeCounter);
                page.click(SelectorsSpacelogik.PROGRAM_MENU_BUTTON);
                methods.goToNewProgramForm();
                methods.executeSweetTestStandardProgram(currentRow);
                methods.verifyToast(toast.PROGRAM_SUCESS);
                if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "✅");
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
                page.waitForTimeout(1000);
            }
            methods.printErrores();
            methods.reset();
        } catch (Exception e) {
            if (gSheets != null) gSheets.reportResult(spreadsheetId, executeCounter, "❌");
        } finally{
            cleanupContext();
        }
    }
    public void happyPathCreateProgramMultipleGuru() {
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear programs para " + generate.generateExecutions() + " usuarios\n");
        page.waitForTimeout(1000);
        try{
            methods.runSafely(() -> {
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.createProgramMultipleGuru();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
    //PASSWORD
    public void happyPathConfigPassword() {
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a setear " + generate.generateExecutions() + " contraseñas\n");
        try{
            methods.runSafely(() -> {
        methods.login(reCompanieEmail, userPassword);
        page.waitForTimeout(3000);
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.setPassword();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
    //ONBOARDING
    public void happyPathConfigOnboarding() {
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a setear " + generate.generateExecutions() + " onboarding\n");
        page.waitForTimeout(1000);
        try{
            methods.runSafely(() -> {
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.completeOnboarding();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
    //CREDITS
    public void happyPathBuyCredits() {
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a comprar creditos para " + generate.generateExecutions() + " usuarios\n");
        page.waitForTimeout(1000);
        try{
            methods.runSafely(() -> {
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.buyCredit();
                page.waitForTimeout(1000);
                System.out.println("\nse compeletaron " + executeCounter + " ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            });
            methods.printErrores();
            methods.reset();
        } finally {
            cleanupContext();
        }
    }
}
