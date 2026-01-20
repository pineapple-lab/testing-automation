package InsumosSpacelogik;

import InsumosArla.SelectorsArla;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class MethodsSpacelogik extends ContextBaseSpacelogik {
    private static final List<String> errores = new ArrayList<>();
    GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    GeneratorSpaceLogik.EmailInfo emailInfo;
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
    public void login(){
        page.fill(SelectorsSpacelogik.LOGIN_EMAIL,userEmail);
        page.fill(SelectorsSpacelogik.LOGIN_PASSWORD,userPassword);
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
            System.out.println("✅ Todas las comprobaciones pasaron.");
        }
    }
    public boolean verifyAssertions(Runnable... assertions){
        boolean allPassed = true;
        for (Runnable assertion : assertions) {
            try {
                assertion.run();
            } catch (AssertionError | Exception e) {
                allPassed = false;
                System.out.println("❌ Falló una validación: " + e.getMessage());
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
        Locator toast = page.locator(SelectorsSpacelogik.APP_TOASTERS);
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            assertThat(()-> Assertions.assertEquals(expectedMessage, actualText), "El mensaje de confirmación no coincide. "+expectedMessage);
        } catch (TimeoutError e) {
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
