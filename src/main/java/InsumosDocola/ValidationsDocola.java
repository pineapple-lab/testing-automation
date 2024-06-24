package InsumosDocola;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ValidationsDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    WaitingsDocola waiting = new WaitingsDocola();
    GeneratorDocola generate = new GeneratorDocola();
    GeneratorDocola.EmailInfo emailInfo;
    MethodsDocola methods = new MethodsDocola();
    boolean isVisible;
    boolean isDisabled;
    //METHODS VALIDATIONS LOGIN
    public void validationLoginEmailIncorrect(){
        System.out.println("En este test se validara que al poner un email incorrecto aparezca el mensaje de error correspondiente\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                email = "esteEmailNoexiste@mailinator.com";
                System.out.println("Email para la prueba: "+email);
                page.fill(selector.loginEmail,email);
                methods.completeloginPassword();
                page.click(selector.loginButton);
                waiting.waitingLoginSelectorIncorrectCredentials();
                isVisible = page.isVisible(selector.loginIncorrectCredentials);
                Assertions.assertTrue(isVisible);
                if (isVisible = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isVisible= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationLoginPasswordIncorrect(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que al poner un password incorrecto aparezca el mensaje de error correspondiente\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                password = "EstePasswordNoExiste";
                System.out.println("Password para la prueba: "+email);
                page.fill(selector.loginPassword,password);
                page.click(selector.loginButton);
                waiting.waitingLoginSelectorIncorrectCredentials();
                isVisible = page.isVisible(selector.loginIncorrectCredentials);
                Assertions.assertTrue(isVisible);
                if (isVisible = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isVisible= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationLoginEmailEmpty(){
        System.out.println("En este test se validara que el boton login se mantenga deshabilitado al dejar el campo email vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginPassword();
                Locator loginButton = page.locator(selector.loginButton);
                isDisabled = !loginButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationLoginPasswordEmpty(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton login se mantenga deshabilitado al dejar el campo password vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                Locator loginButton = page.locator(selector.loginButton);
                isDisabled = !loginButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    //METHODS VALIDATIONS REGISTER
    public void validationRegisterFirstName(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo first name vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
            methods.goToRegisterForm();
            waiting.waitingJoinsSelectorStep1(generate.generateRol());
            methods.completeLastNameARegister(generate.generateLastName());
            methods.completeemail(emailInfo.getEmail());
            Locator nextButton = page.locator(selector.registerNextButtonStep1);
            isDisabled = !nextButton.isEnabled();
            Assertions.assertTrue(isDisabled);
            if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
            }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationRegisterLastName(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo last name vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeemail(emailInfo.getEmail());
                Locator nextButton = page.locator(selector.registerNextButtonStep1);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationRegisterEmail(){
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo email vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeLastNameARegister(generate.generateLastName());
                Locator nextButton = page.locator(selector.registerNextButtonStep1);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationRegisterPassword(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo pasword vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.registerPasswordConfirmation,password);
                Locator nextButton = page.locator(selector.registerNextButtonStep2);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationRegisterConfirmPassword(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo confirm pasword vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                page.fill(selector.registerPassword,password);
                Locator nextButton = page.locator(selector.registerNextButtonStep2);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationRegisterPasswordConditions(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que todas las condiciones del password sean requeridas\n");
        Keyboard kb = page.keyboard();
        String confirmPassword = "";
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                    methods.goToRegisterForm();
                    waiting.waitingJoinsSelectorStep1(generate.generateRol());
                    methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                    page.click(selector.registerNextButtonStep1);
                    waiting.waitingJoinSelectorStep2();
                for(int passwordCondition=1; passwordCondition <=6;passwordCondition++ ) {
                    switch (passwordCondition){
                        case  1:
                            System.out.println("\n>Probando password con solo numeros");
                            password ="123";
                            confirmPassword="123";
                            break;
                        case  2:
                            System.out.println("\n>Probando password con solo numeros y letra mayuscula");
                            password ="12312312A";
                            confirmPassword="12312312A";
                            break;
                        case  3:
                            System.out.println("\n>Probando password con solo numeros y letra minuscula");
                            password ="12312312a";
                            confirmPassword="12312312a";
                            break;
                        case  4:
                            System.out.println("\n>Probando password con solo letras");
                            password ="AAAAAAAA";
                            confirmPassword="AAAAAAAA";
                            break;
                        case  5:
                            System.out.println("\n>Probando password sin caracter especial");
                            password ="123123aA";
                            confirmPassword="123123aA";
                            break;
                        case  6:
                            System.out.println("\n>Probando que password y confirm password no puedan ser diferentes");
                            password ="123123aA-";
                            confirmPassword="123123bB-";
                            break;
                    }
                    System.out.println("Password usada para la prueba: "+password);
                    System.out.println("Confirm password usado para la prueba: "+confirmPassword);
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
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton register se mantenga deshabilitado al dejar el campo terms and conditions vacio\n");
        for (contador = 1; contador <= generate.generateExecutions(); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.registerNextButtonStep2);
                page.click(selector.registerCaptchat);
                Locator nextButton = page.locator(selector.registerNextButtonStep3);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationCaptcha(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton register se mantenga deshabilitado al dejar el campo captcha vacio\n");
        for (contador = 1; contador <= Integer.parseInt(ejecuciones); contador++) {
            if (!shouldStopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(selector.registerNextButtonStep1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(selector.registerNextButtonStep2);
                page.click(selector.registerTermsAndConditions);
                Locator nextButton = page.locator(selector.registerNextButtonStep3);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                if (isDisabled = true){
                    System.out.println("\nEl test paso sin errores");
                }else if(isDisabled= false){
                    System.out.println("\nEl test no paso");
                }
            }
        }
        closeContext();
    }
    public void validationTitleResource(){
        typeContent = 1;
        joinRol="Content provider";
        System.out.println("En este test se validara que el campo title del contenido "+typeResource+" sea requerido\n");
        for (contador = 1; contador <= Integer.parseInt(ejecuciones); contador++) {
            if (!shouldStopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(selector.contentDescription,generate.generateContentDescription());
                page.locator(selector.contentUpload).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(selector.selectPreviewImage);
                page.click(selector.contentButtonContinue);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+selector.messageErrorTitleRequired+"')).color; }").toString();
                if (color.equals("rgb(170, 34, 34)")) {
                    System.out.println("El campo title se requiere correctamente");
                } else {
                    System.out.println("El campo title no esta siendo requerido");
                }
            }
        }
        methods.limpiarEjecuciones();
        closeContext();
    }
    public void validationDescriptionResource(){
        typeContent = 1;
        joinRol="Content provider";
        System.out.println("En este test se validara que el campo description del contenido "+typeResource+" sea requerido\n");
        for (contador = 1; contador <= Integer.parseInt(ejecuciones); contador++) {
            if (!shouldStopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(selector.contentTitle,generate.generateContentTitle());
                page.locator(selector.contentUpload).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(selector.selectPreviewImage);
                page.click(selector.contentButtonContinue);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+selector.messageErrorDescriptionRequired+"')).color; }").toString();
                if (color.equals("rgb(170, 34, 34)")) {
                    System.out.println("El campo description se requiere correctamente");
                } else {
                    System.out.println("El campo description no esta siendo requerido");
                }
            }
        }
        methods.limpiarEjecuciones();
        closeContext();
    }
}
