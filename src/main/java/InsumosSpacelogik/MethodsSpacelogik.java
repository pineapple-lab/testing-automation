package InsumosSpacelogik;

import InsumosArla.SelectorsArla;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MethodsSpacelogik extends ContextBaseSpacelogik {
    private static final List<String> errores = new ArrayList<>();
    GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    GeneratorSpaceLogik.EmailInfo emailInfo;
    ToastMessageSpacelogik toast = new ToastMessageSpacelogik();
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
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
        page.fill(SelectorsSpacelogik.LOGIN_EMAIL,email);
        page.fill(SelectorsSpacelogik.LOGIN_PASSWORD,password);
        page.click(SelectorsSpacelogik.LOGIN_BUTTON);
    }
    public void goToReCompaniePage(){
        page.click(SelectorsSpacelogik.MENU_ADMIN);
        page.click(SelectorsSpacelogik.RECOMPANIE_MENU_BUTTON);
    }
    public void goToRecompanieForm(){
        page.click(SelectorsSpacelogik.RECOMPANIE_NEW_BUTTON);
    }
    public void completeReCompanieStep1(){
        Keyboard kb = page.keyboard();
        page.fill(SelectorsSpacelogik.RECOMPANIE_COMPANYNAME_INPUT, generate.generateCompanyName());
        page.waitForTimeout(1000);
        page.locator(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_INPUT).type("T", new Locator.TypeOptions().setDelay(200));
        page.click(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_OPTIONS);
        page.waitForTimeout(1000);
        page.click(SelectorsSpacelogik.RECOMPANIE_NEXTBUTTON_STEP1);
    }
    public void completeReCompanieStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.RECOMPANIE_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORD_INPUT,"123123aA.");
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORDCONFIRM_INPUT, "123123aA.");
        page.click(SelectorsSpacelogik.RECOMPANIE_NEXTBUTTON_STEP2);
    }
    public void completeReCompanieStep3(){
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTACTSALUTATION_SELECTOR);
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTACTSALUTATION_OPTION);
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTITLE_INPUT, "Director");
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTNAME_INPUT, emailInfo.getFirstName());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTLASTNAME_INPUT, emailInfo.getLastName());
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTMOBILE_INPUT,"(999) 999-9999");
        page.fill(SelectorsSpacelogik.RECOMPANIE_CONTACTPHONE_INPUT,"(999) 999-9999");
        page.click(SelectorsSpacelogik.RECOMPANIE_SAVE_BUTTON);
    }
    public void createRecCompanie(){
        completeReCompanieStep1();
        completeReCompanieStep2();
        completeReCompanieStep3();
    }
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
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_INDUSTRY_OPTION);
        page.locator(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_INPUT).type("T", new Locator.TypeOptions().setDelay(200));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_STATE_SELECT);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_STATE_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_CITY_SELECT);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_CITY_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ZIPCODE_SELECT);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ZIPCODE_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_MODAL_OPEN);
        page.locator(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
        waitForToast(toast.FILE_UPLOAD_SUCCESS);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_LOGO_SAVE);
        page.waitForTimeout(3000);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_CONTINUE_BUTTON);
    }
    public void completeNationalAccountStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_FNAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_LNAME_INPUT, generate.lastName);
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_SALUTATION_SELECT);
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_SALUTATION_OPTION);
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_TITLE_INPUT, "Director");
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_MOBILE_INPUT,"(999) 999-9999");
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_PHONE_INPUT, "(999) 999-9999");
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_PASSWORD_INPUT,"Pickle30");
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_CPASSOWRD_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_SAVE_BUTTON);
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_SAVE_BUTTON);
    }
    public void createNationalAccount(){
        completeNationalAccountStep1();
        completeNationalAccountStep2();
    }
    public void goToNewGuruForm(){
        page.click(SelectorsSpacelogik.PEOPLE_FORM_NEWGURU_BUTTON);
    }
    public void completeNewGuruStep1(){
        emailInfo = generate.generateEmail();
        userEmail= emailInfo.getEmail();
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SALUTATION_SELECT);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SALUTATION_OPTION);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_TITLE_INPUT, "Director");
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_NAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_LNAME_INPUT, generate.lastName);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_EMAIL_INPUT, generate.userEmail);
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_MOBILE_INPUT, "(999) 999-9999");
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_PHONE_INPUT, "(999) 999-9999");
        page.click(SelectorsSpacelogik.PEOPLE_FORM_CONTINUEANDSAVE_BUTTON);
    }
    public void completeNewGuruStep2(){
        Keyboard kb = page.keyboard();
        page.click(SelectorsSpacelogik.PEOPLE_FORM_OFFICE_SELECT);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_OFFICE_OPTION);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SKILL_SELECT);
        page.click(SelectorsSpacelogik.PEOPLE_FORM_SKILL_OPTION);
        kb.press("Escape");
        page.fill(SelectorsSpacelogik.PEOPLE_FORM_DESCRIPTION_INPUT, generate.generateContentDescription());
        page.click(SelectorsSpacelogik.PEOPLE_FORM_CONTINUEANDSAVE_BUTTON);
    }
    public void completeNewGuruStep3(){
        page.click(SelectorsSpacelogik.PEOPLE_FORM_PAYMENT_OPTION);
    }
    public void createNewGuru(){
        completeNewGuruStep1();
        completeNewGuruStep2();
        completeNewGuruStep3();
        page.click(SelectorsSpacelogik.PEOPLE_FORM_CONTINUEANDSAVE_BUTTON);
    }
    public void goToNewClientForm(){
        page.click(SelectorsSpacelogik.CLIENT_NEW_BUTTON);
    }
    public void completeNewClientStep1(){
        page.fill(SelectorsSpacelogik.CLIENT_COMPANY_NAME_INPUT, generate.generateCompanyName());
        page.click(SelectorsSpacelogik.CLIENT_INDUSTRY_SELECT);
        page.click(SelectorsSpacelogik.CLIENT_INDUSTRY_OPTION);
        page.click(SelectorsSpacelogik.CLIENT_CONTINUESTEP1_BUTTON);
    }
    public void completeNewClientStep2(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_NAME_INPUT, generate.firstName);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_LNAME_INPUT, generate.lastName);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_TITLE_INPUT, "Director");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_EMAIL_INPUT, userEmail);
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_PASSWORD_INPUT, "Pickle30");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_CPASSWORD_INPUT, "Pickle30");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_MOBILE_INPUT, "(999) 999-9999");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_PHONE_INPUT, "(999) 999-9999");
        page.fill(SelectorsSpacelogik.CLIENT_TENANT_ADRESS_INPUT, "Test");
        page.click(SelectorsSpacelogik.CLIENT_TENANT_STATE_SELECT);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_STATE_OPTION);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_CITY_SELECT);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_CITY_OPTION);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_ZIPCODE_SELECT);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_ZIPCODE_OPTION);
        page.click(SelectorsSpacelogik.CLIENT_TENANT_CONTINUESTEP2_BUTTON);
    }
    public void goToNewLocationFromNewClientForm(){
        page.click(SelectorsSpacelogik.CLIENT_LOCATION_NEW_BUTTON);
    }
    public void completeNewLocationStep1(){
        long timeStamp = Instant.now().toEpochMilli();
        page.fill(SelectorsSpacelogik.LOCATION_NAME_INPUT,"Automatic location"+timeStamp);
        page.click(SelectorsSpacelogik.LOCATION_OFICCE_DISTANCE_SELECT);
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_DISTANCE_OPTION);
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_FROM_SELECT);
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_FROM_OPTION);
        page.locator(SelectorsSpacelogik.LOCATION_OFFICE_ADRESS_INPUT).type("T", new Locator.TypeOptions().setDelay(200));
        page.click(SelectorsSpacelogik.LOCATION_OFFICE_ADRESS_OPTION);
        page.click(SelectorsSpacelogik.LOCATION_CONTINUESTEP1_BUTTON);
    }
    public void completeNewLocationStep2(){
        page.fill(SelectorsSpacelogik.LOCATION_CURRESNTRSF_INPUT, "35000");
        page.fill(SelectorsSpacelogik.LOCATION_ANTICIPATEDRSF_INPUT, "35000");
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
        page.click(SelectorsSpacelogik.LOCATION_SAVE_BUTTON);
    }
    public void createDraftClient(){
        completeNewClientStep1();
        completeNewClientStep2();
    }
    public void createFullClient(){
        createDraftClient();
        goToNewLocationFromNewClientForm();
        createLocation();
        waitForComponent(SelectorsSpacelogik.CLIENT_MODAL_LOCATION_CARD);
        page.click(SelectorsSpacelogik.CLIENT_CREATE_BUTTON);
    }
    public static void assertThat(Runnable assertion, String mensaje) {
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
            System.out.println("\n✅ Todas las comprobaciones pasaron.");
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
    public void waitForToast(String expectedMessage) {
        Locator toast = page.locator(SelectorsSpacelogik.APP_TOASTERS).filter(new Locator.FilterOptions().setHasText(expectedMessage)).first();
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            assertThat(()-> Assertions.assertEquals(expectedMessage, actualText), "El mensaje de confirmación no coincide. "+expectedMessage);
        } catch (PlaywrightException e) {
            assertThat(() -> {throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);}, "Timeout esperando el toast con mensaje: " + expectedMessage);
        }
    }
    public void waitForModalMessage(String expectedMessage) {
        Locator toast = page.locator(SelectorsSpacelogik.GENERIC_MODAL).filter(new Locator.FilterOptions().setHasText(expectedMessage)).first();
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            assertThat(()-> Assertions.assertEquals(expectedMessage, actualText), "El mensaje de confirmación no coincide. "+expectedMessage);
        } catch (PlaywrightException e) {
            assertThat(() -> {throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);}, "Timeout esperando el toast con mensaje: " + expectedMessage);
        }
    }
    public void waitForComponent(String selector) {
        Locator componentLocator = page.locator(selector);
        try {
            componentLocator.waitFor();
            PlaywrightAssertions.assertThat(componentLocator).isVisible();
            System.out.println("Componente encontrado: " + selector);
        } catch (TimeoutError e) {
            assertThat(() -> {
                throw new AssertionError("\n¡Error de Timeout! El componente no apareció en el DOM.\n -> Selector fallido: \"" + selector + "\"");
            }, "Timeout esperando el componente: " + selector);

        } catch (AssertionError e) {
            assertThat(() -> {
                throw new AssertionError("\n¡Error de Visibilidad! El componente no es visible.\n -> Selector fallido: \"" + selector + "\"\nDetalles: " + e.getMessage());
            }, "Verificación de visibilidad fallida: " + selector);
        }
    }
    public void waitForInputErrorMessage(String selector, String expectedMessage) {
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
}
