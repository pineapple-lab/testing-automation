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
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
        cleanupContext();
    }
 //SEARCH
    public void happyPathSearchBuilding(){
        methods.setAdminUser();
        //methods.startBackendMOnitoring(page);
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        System.out.println("Se va a comprobar la informacion de "+generate.generateExecutions()+" buildings\n");
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
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
        try{
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.createRecCompanie();
            methods.verifyToast(toast.RECOMPANIE_SUCCESS);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
            methods.printErrores();
            methods.reset();
    }finally{
            cleanupContext();
        }
    }
    public void assertReCompanieFormEmptyInputs() {
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 1 del formulario de creacion de re companies\n");
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
               boolean verify1 = errorPath.verifyReCompanieFormStep1EmptyInputs();
               boolean verify2 = errorPath.verifyReCompanieFormStep2EmptyInputs();
               boolean verify3 = errorPath.verifyReCompanieFormStep3EmptyInputs();
                variables.allStepsPassed &= (verify1 && verify2 && verify3);
            }
            methods.printFinalTestResult(variables.allStepsPassed);
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathNationalAccountCreate(){
        methods.setAdminUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.goToNationalAccountPage();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                methods.createNationalAccount();
                methods.verifyToast(toast.NATIONALACCOUNT_SUCCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
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
        methods.login(VariablesSpacelogik.userEmail, VariablesSpacelogik.userPassword);
        methods.goToNationalAccountPage();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                boolean verify1 = errorPath.verifyNationalAccountFormStep1EmptyInputs();
                boolean verify2 = errorPath.verifyNationalAccountFormStep2EmptyInputs();
                variables.allStepsPassed &= (verify1 && verify2);
            }
            methods.printFinalTestResult(variables.allStepsPassed);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathOfficeCreate(){
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" offices\n");
        methods.login(reCompanieEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewOfficesForm();
                methods.createOffice();
                methods.verifyToast(toast.OFFICES_SUCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathGuruCreate(){
        methods.setReCompanieUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Guru\n");
        methods.login(reCompanieEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewGuruForm();
                methods.createNewGuru(reCompanieEmail);
                methods.assertComponent(SelectorsSpacelogik.PEOPLE_FORM_POPUP_SUCCESSFULLY);
                methods.verifyToast(toast.GURU_SUCCESS);
                page.click(SelectorsSpacelogik.PEOPLE_FORM_POPUP_OK_BUTTON);
                methods.assertComponent(SelectorsSpacelogik.WAIT_RECOMPANIE_TABLE_FIRSTROW);
                System.out.println("\nse compeleto "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathClientCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" Clients\n");
        methods.login(userEmail, userPassword);
        try{
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
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathLocationCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        System.out.println("Se van a crear "+generate.generateExecutions()+" locations\n");
        methods.login(userEmail, userPassword);
        page.waitForTimeout(3000);
        methods.assertComponent(SelectorsSpacelogik.CLIENT_CARD);
        methods.goToLocationView();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewLocationForm();
                methods.createLocation();
                page.waitForTimeout(3000);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathAutoofficeProgramCreate(){
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        methods.login(userEmail, userPassword);
        page.waitForSelector(SelectorsSpacelogik.CLIENT_CARD);
        page.waitForTimeout(3000);
        methods.goToProgramView();
        System.out.println("Se van a crear "+generate.generateExecutions()+" programs\n");
        try{
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
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void executeSweetCaseNewAutoofficeProgram(){
        String urlMiTabla = "https://docs.google.com/spreadsheets/d/1Goc7muuoXZ3FEzFpZ4ol7aSASlZum7ubgEmmLSZbuUc/export?format=csv";
        List<Map<String, String>> testCaseList = methods.getTestCase(urlMiTabla);
        methods.setGuruUser();
        methods.startBackendMOnitoring(page);
        methods.login(userEmail, userPassword);
        page.waitForSelector(SelectorsSpacelogik.CLIENT_CARD);
        page.waitForTimeout(3000);
        methods.goToProgramView();
        System.out.println("Se van a crear "+generate.generateExecutions()+" programs\n");
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                Map<String, String> currentRow = testCaseList.get((executeCounter-1) % testCaseList.size());
                int testCaseId = executeCounter+1;
                System.out.println("\n----------------------------------------------------");
                System.out.println("📊 TESTEANDO CASO DE PRUEBA: " + testCaseId);
                page.click(SelectorsSpacelogik.MENU_SPACE);
                page.click(SelectorsSpacelogik.PROGRAM_MENU_BUTTON);
                methods.goToNewProgramForm();
                methods.executeSweetTestAutoOfficeProgram(currentRow);
                methods.verifyToast(toast.PROGRAM_SUCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
                page.waitForTimeout(3000);
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }

}
