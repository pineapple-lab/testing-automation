package InsumosDocola;
import com.microsoft.playwright.Keyboard;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class validationsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
    waitingsDocola waiting = new waitingsDocola();
    generatorDocola trigger = new generatorDocola();
    methodsDocola methods = new methodsDocola();

    public void validationsRegisterFirstName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
            methods.goToRegisterForm();
            waiting.waitingJoinsSelectorStep1(trigger.generateRol());
            methods.completeLastNameARegister(trigger.generateLastName());
            methods.completeEmailRegister(trigger.generateEmail());
            assertThat(page.locator(selector.nextButtonRegisterStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsRegisterLastName(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstNameRegister(trigger.generateFirstName());
                methods.completeEmailRegister(trigger.generateEmail());
                assertThat(page.locator(selector.nextButtonRegisterStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsRegisterEmail(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstNameRegister(trigger.generateFirstName());
                methods.completeLastNameARegister(trigger.generateLastName());
                assertThat(page.locator(selector.nextButtonRegisterStep1)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsRegisterPassword(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstStepRegister(trigger.generateFirstName(),trigger.generateLastName(),trigger.generateEmail());
                page.click(selector.nextButtonRegisterStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.passwordConfirmationRegister,password);
                assertThat(page.locator(selector.nextButtonRegisterStep2)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsRegisterConfirmPassword(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstStepRegister(trigger.generateFirstName(),trigger.generateLastName(),trigger.generateEmail());
                page.click(selector.nextButtonRegisterStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.passwordRegister,password);
                assertThat(page.locator(selector.nextButtonRegisterStep2)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationsRegisterPasswordConditions(){
        Keyboard kb = page.keyboard();
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                    methods.goToRegisterForm();
                    waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                    methods.completeFirstStepRegister(trigger.generateFirstName(),trigger.generateLastName(),trigger.generateEmail());
                    page.click(selector.nextButtonRegisterStep1);
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
                    page.fill(selector.passwordRegister, password);
                    page.fill(selector.passwordConfirmationRegister, confirmPassword);
                    String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+selector.passwordConditionSelector(passwordCondition)+"')).color; }").toString();
                    if (color.equals("rgb(255, 0, 0)")) {
                        System.out.println("La condicion "+passwordCondition+" se valida correctamente");
                    } else {
                        System.out.println("La condicion "+passwordCondition+" no se esta validando correctamente.");
                    }
                    page.focus(selector.passwordRegister);
                    kb.press("Control+Shift+ArrowLeft");
                    kb.press("Delete");
                    page.focus(selector.passwordConfirmationRegister);
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
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstStepRegister(trigger.generateFirstName(),trigger.generateLastName(),trigger.generateEmail());
                page.click(selector.nextButtonRegisterStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.nextButtonRegisterStep2);
                page.click(selector.captchaRegister);
                assertThat(page.locator(selector.nextButtonRegisterStep3)).isDisabled();
            }
        }
        closeContext();
    }
    public void validationCaptcha(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(trigger.generateRol());
                methods.completeFirstStepRegister(trigger.generateFirstName(),trigger.generateLastName(),trigger.generateEmail());
                page.click(selector.nextButtonRegisterStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.nextButtonRegisterStep2);
                page.click(selector.termsAndConditionsRegister);
                assertThat(page.locator(selector.nextButtonRegisterStep3)).isDisabled();
            }
        }
        closeContext();
    }
}
