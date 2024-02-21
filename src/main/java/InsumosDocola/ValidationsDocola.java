package InsumosDocola;
import com.microsoft.playwright.Keyboard;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ValidationsDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    WaitingsDocola waiting = new WaitingsDocola();
    GeneratorDocola generate = new GeneratorDocola();
    GeneratorDocola.EmailInfo emailInfo = generate.generateEmail();
    MethodsDocola methods = new MethodsDocola();
    //METHODS VALIDATIONS LOGIN
    public void validationLoginEmailIncorrect(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                email = "esteEmailNoexiste@mailinator.com";
                page.fill(selector.loginEmail,email);
                methods.completeloginPassword();
                page.click(selector.loginButton);
                waiting.waitingLoginSelectorIncorrectCredentials();
                Assertions.assertTrue(page.isVisible(selector.loginIncorrectCredentials));
            }
        }
        closeContext();
    }
    public void validationLoginPasswordIncorrect(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                password = "EstePasswordNoExiste";
                page.fill(selector.loginPassword,password);
                page.click(selector.loginButton);
                waiting.waitingLoginSelectorIncorrectCredentials();
                Assertions.assertTrue(page.isVisible(selector.loginIncorrectCredentials));
            }
        }
        closeContext();
    }
    public void validationLoginEmailEmpty(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginPassword();
                assertThat(page.locator(selector.loginButton)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationLoginPasswordEmpty(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                assertThat(page.locator(selector.loginButton)).isDisabled();
            }
        }
        closeContext();
    }
    //METHODS VALIDATIONS REGISTER
    public void validationRegisterFirstName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
            methods.goToRegisterForm();
            waiting.waitingJoinsSelectorStep1(generate.generateRol());
            methods.completeLastNameARegister(generate.generateLastName());
            methods.completeemail(emailInfo.getEmail());
            assertThat(page.locator(selector.registerNextButtonStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationRegisterLastName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeemail(emailInfo.getEmail());
                assertThat(page.locator(selector.registerNextButtonStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationRegisterEmail(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeLastNameARegister(generate.generateLastName());
                assertThat(page.locator(selector.registerNextButtonStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationRegisterPassword(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.registerPasswordConfirmation,password);
                assertThat(page.locator(selector.registerNextButtonStep2)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationRegisterConfirmPassword(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.registerPassword,password);
                assertThat(page.locator(selector.registerNextButtonStep2)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationRegisterPasswordConditions(){
        Keyboard kb = page.keyboard();
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                    methods.goToRegisterForm();
                    waiting.waitingJoinsSelectorStep1(generate.generateRol());
                    methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                    page.click(selector.registerNextButtonStep1);
                    waiting.waitingJoinSelectorStep2();
                for(passwordCondition=1; passwordCondition <=5;passwordCondition++ ) {
                    switch (passwordCondition){
                        case  1:
                            password ="123";
                            confirmPassword="123";
                            break;
                        case  2:
                            password ="12312312A";
                            confirmPassword="12312312A";
                            break;
                        case  3:
                            password ="12312312a";
                            confirmPassword="12312312a";
                            break;
                        case  4:
                            password ="AAAAAAAA";
                            confirmPassword="AAAAAAAA";
                            break;
                        case  5:
                            password ="123123aA-";
                            confirmPassword="123123bB-";
                            break;
                    }
                    page.fill(selector.registerPassword, password);
                    page.fill(selector.registerPasswordConfirmation, confirmPassword);
                    String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+selector.passwordConditionSelector(passwordCondition)+"')).color; }").toString();
                    if (color.equals("rgb(255, 0, 0)")) {
                        System.out.println("La condicion "+passwordCondition+" se valida correctamente");
                    } else {
                        System.out.println("La condicion "+passwordCondition+" no se esta validando correctamente.");
                    }
                    page.focus(selector.registerPassword);
                    kb.press("Control+Shift+ArrowLeft");
                    kb.press("Delete");
                    page.focus(selector.registerPasswordConfirmation);
                    kb.press("Control+Shift+ArrowLeft");
                    kb.press("Delete");
                }
            }
        }
        closeContext();
    }
    public void validationTermsAndConditions(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.registerNextButtonStep2);
                page.click(selector.registerCaptchat);
                assertThat(page.locator(selector.registerNextButtonStep3)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationCaptcha(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.registerNextButtonStep2);
                page.click(selector.registerTermsAndConditions);
                assertThat(page.locator(selector.registerNextButtonStep3)).isDisabled();
            }
        }
        closeContext();
    }
}
