package InsumosDocola;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class validationsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
    methodsDocola methods = new methodsDocola();
    waitingsDocola waiting = new waitingsDocola();
    public void validationsLoginFirstName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
            page.click(selector.singUp);
            page.click(selector.continueWithEmail);
            waiting.waitingJoinsSelectorStep1(methods.asignarRol());
            page.fill(selector.lastNameRegister,methods.generarLastName());
            page.fill(selector.emailRegister, methods.generarEmail());
            assertThat(page.locator(selector.nextButtonRegisterStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsLoginLastName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                page.click(selector.singUp);
                page.click(selector.continueWithEmail);
                waiting.waitingJoinsSelectorStep1(methods.asignarRol());
                page.fill(selector.firstNameRegister,methods.generarFirstName());
                page.fill(selector.emailRegister, methods.generarEmail());
                assertThat(page.locator(selector.nextButtonRegisterStep1)).isDisabled();
            }
        }
        closeContext();
    }
}
