package InsumosDocola;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Paths;
public class ValidationsDocola extends ContextBaseDocola {
    private final SelectorsDocola selector = new SelectorsDocola();
    private final WaitingsDocola waiting = new WaitingsDocola();
    private final GeneratorDocola generate = new GeneratorDocola();
    private GeneratorDocola.EmailInfo emailInfo;
    private final MethodsDocola methods = new MethodsDocola();
    private boolean isVisible;
    private boolean isDisabled;
    //METHODS VALIDATIONS LOGIN
    public void validationLoginEmailIncorrect(){
        System.out.println("En este test se validara que al poner un email incorrecto aparezca el mensaje de error correspondiente\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                userEmail = "esteEmailNoexiste@mailinator.com";
                System.out.println("Email para la prueba: "+ userEmail);
                page.fill(SelectorsDocola.LOGIN_EMAIL, userEmail);
                methods.completeloginPassword();
                page.click(SelectorsDocola.LOGIN_BUTTON);
                waiting.waitingLoginSelectorIncorrectCredentials();
                isVisible = page.isVisible(SelectorsDocola.LOGIN_INCORRECT_CREDENTIALS);
                Assertions.assertTrue(isVisible);
                System.out.println(isVisible ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationLoginPasswordIncorrect(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que al poner un password incorrecto aparezca el mensaje de error correspondiente\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                userPassword = "EstePasswordNoExiste";
                System.out.println("Password para la prueba: "+ userEmail);
                page.fill(SelectorsDocola.LOGIN_PASSWORD, userPassword);
                page.click(SelectorsDocola.LOGIN_BUTTON);
                waiting.waitingLoginSelectorIncorrectCredentials();
                isVisible = page.isVisible(SelectorsDocola.LOGIN_INCORRECT_CREDENTIALS);
                Assertions.assertTrue(isVisible);
                System.out.println(isVisible ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationLoginEmailEmpty(){
        System.out.println("En este test se validara que el boton login se mantenga deshabilitado al dejar el campo email vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginPassword();
                Locator loginButton = page.locator(SelectorsDocola.LOGIN_BUTTON);
                isDisabled = !loginButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationLoginPasswordEmpty(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton login se mantenga deshabilitado al dejar el campo password vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToLogin();
                waiting.waitingLoginSelectors();
                methods.completeloginEmail();
                Locator loginButton = page.locator(SelectorsDocola.LOGIN_BUTTON);
                isDisabled = !loginButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    //METHODS VALIDATIONS REGISTER
    public void validationRegisterFirstName(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo first name vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
            methods.goToRegisterForm();
            waiting.waitingJoinsSelectorStep1(generate.generateRol());
            methods.completeLastNameARegister(generate.generateLastName());
            methods.completeEmail(emailInfo.getEmail());
            Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
            isDisabled = !nextButton.isEnabled();
            Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationRegisterLastName(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo last name vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeEmail(emailInfo.getEmail());
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationRegisterEmail(){
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo email vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeregisterFirstName(generate.generateFirstName());
                methods.completeLastNameARegister(generate.generateLastName());
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationRegisterPassword(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo pasword vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                waiting.waitingJoinSelectorStep2();
                page.fill(SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION, userPassword);
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_2);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationRegisterConfirmPassword(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton continue se mantenga deshabilitado al dejar el campo confirm pasword vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                waiting.waitingJoinSelectorStep2();
                page.fill(SelectorsDocola.REGISTER_PASSWORD, userPassword);
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_2);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationRegisterPasswordConditions(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que todas las condiciones del password sean requeridas\n");
        Keyboard kb = page.keyboard();
        String confirmPassword = "";
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                    methods.goToRegisterForm();
                    waiting.waitingJoinsSelectorStep1(generate.generateRol());
                    methods.completeFirstStepRegister(generate.generateFirstName(),generate.generateLastName(),emailInfo.getEmail());
                    page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                    waiting.waitingJoinSelectorStep2();
                for(int passwordCondition=1; passwordCondition <=6;passwordCondition++ ) {
                    switch (passwordCondition){
                        case  1:
                            System.out.println("\n>Probando password con solo numeros");
                            userPassword ="123";
                            confirmPassword="123";
                            break;
                        case  2:
                            System.out.println("\n>Probando password con solo numeros y letra mayuscula");
                            userPassword ="12312312A";
                            confirmPassword="12312312A";
                            break;
                        case  3:
                            System.out.println("\n>Probando password con solo numeros y letra minuscula");
                            userPassword ="12312312a";
                            confirmPassword="12312312a";
                            break;
                        case  4:
                            System.out.println("\n>Probando password con solo letras");
                            userPassword ="AAAAAAAA";
                            confirmPassword="AAAAAAAA";
                            break;
                        case  5:
                            System.out.println("\n>Probando password sin caracter especial");
                            userPassword ="123123aA";
                            confirmPassword="123123aA";
                            break;
                        case  6:
                            System.out.println("\n>Probando que password y confirm password no puedan ser diferentes");
                            userPassword ="123123aA-";
                            confirmPassword="123123bB-";
                            break;
                    }
                    System.out.println("Password usada para la prueba: "+ userPassword);
                    System.out.println("Confirm password usado para la prueba: "+confirmPassword);
                    page.fill(SelectorsDocola.REGISTER_PASSWORD, userPassword);
                    page.fill(SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION, confirmPassword);
                    String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+ selector.passwordConditionSelector(passwordCondition)+"')).color; }").toString();
                    System.out.println(color.equals("rgb(255, 0, 0)") ? "La condicion "+passwordCondition+" se valida correctamente" : "\nELa condicion "+passwordCondition+" no se esta validando correctamente");
                    page.focus(SelectorsDocola.REGISTER_PASSWORD);
                    kb.press("Control+Shift+ArrowLeft");
                    kb.press("Delete");
                    page.focus(SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION);
                    kb.press("Control+Shift+ArrowLeft");
                    kb.press("Delete");
                }
            }
        }
        cleanupContext();
    }
    public void validationTermsAndConditions(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton register se mantenga deshabilitado al dejar el campo terms and conditions vacio\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_2);
                page.click(SelectorsDocola.REGISTER_CAPTCHAT);
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_3);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationCaptcha(){
        emailInfo= generate.generateEmail();
        System.out.println("En este test se validara que el boton register se mantenga deshabilitado al dejar el campo captcha vacio\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.goToRegisterForm();
                waiting.waitingJoinsSelectorStep1(generate.generateRol());
                methods.completeFirstStepRegister(emailInfo.getFirstName(),emailInfo.getLastName(),emailInfo.getEmail());
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_1);
                waiting.waitingJoinSelectorStep2();
                methods.completeSecondStepRegister();
                page.click(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_2);
                page.click(SelectorsDocola.REGISTER_TERMS_AND_CONDITIONS);
                Locator nextButton = page.locator(SelectorsDocola.REGISTER_NEXT_BUTTON_STEP_3);
                isDisabled = !nextButton.isEnabled();
                Assertions.assertTrue(isDisabled);
                System.out.println(isDisabled ? "\nEl test paso sin errores" : "\nEl test no paso");
            }
        }
        cleanupContext();
    }
    public void validationTitleResource(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo title del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+ SelectorsDocola.MESSAGE_ERROR_TITLE_REQUIRED +"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo title se requiere correctamente" : "El campo title no esta siendo requerido");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationDescriptionResource(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo description del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+ SelectorsDocola.MESSAGE_ERROR_DESCRIPTION_REQUIRED +"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo description se requiere correctamente" : "El campo description no esta siendo requerido");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationFileResource(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo file del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+ SelectorsDocola.MESSAGE_ERROR_FILE_REQUIRED +"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo file se requiere correctamente" : "El campo file no esta siendo requerido");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationTagsResource(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo file del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+ SelectorsDocola.MESSAGE_ERROR_TAGS_REQUIRED +"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo tags se requiere correctamente" : "El campo tags no esta siendo requerido");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationTwoTagsResource(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo file del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                for(int tagPosition = 1; tagPosition<=1;tagPosition++) {
                    page.click(SelectorsDocola.CONTENT_TAG_ICD_10_TYPE);
                    page.click(selector.contentSelectTagICD10(tagPosition));
                    page.click(SelectorsDocola.CONTENT_ADD_TAGS);
                }
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+SelectorsDocola.MESSAGE_ERROR_TAGS_REQUIRED+"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo tags requiere dos tags correctamente" : "El campo tags no esta requiriendo 2 tags");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationICD10TagResoruce(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo file del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                page.click(SelectorsDocola.CONTENT_TAG_ICD_10_TYPE);
                page.click(selector.contentSelectTagICD10(1));
                page.click(SelectorsDocola.CONTENT_ADD_TAGS);
                for(int tagPosition = 1; tagPosition<=2;tagPosition++) {
                    page.click(SelectorsDocola.CONTENT_TAG_NORMAL_TYPE_TWO);
                    page.click(selector.contentSelectTagICD10(tagPosition));
                    page.click(SelectorsDocola.CONTENT_ADD_TAGS);
                }
                page.click(SelectorsDocola.CONTENT_DELETE_TAGS);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+SelectorsDocola.MESSAGE_ERROR_TAGS_REQUIRED+"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo tags requiere  al menos una tag ICD10 correctamente" : "El campo tags no esta requiriendo al menos una tag ICD10");
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
    public void validationMonthlyPrice(){
        contentType = 1;
        userRole ="Content provider";
        System.out.println("En este test se validara que el campo file del contenido "+ resourceType +" sea requerido\n");
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
            if (!stopTest) {
                methods.login();
                methods.goToContentCreateForm();
                methods.goToResourceCreateForm();
                page.fill(SelectorsDocola.CONTENT_TITLE,generate.generateContentTitle());
                page.fill(SelectorsDocola.CONTENT_DESCRIPTION,generate.generateContentDescription());
                page.locator(SelectorsDocola.CONTENT_UPLOAD).setInputFiles(Paths.get(generate.generateImage()));
                page.waitForSelector(SelectorsDocola.SELECT_PREVIEW_IMAGE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                page.click(SelectorsDocola.CONTENT_TAG_ICD_10_TYPE);
                page.click(selector.contentSelectTagICD10(1));
                page.click(SelectorsDocola.CONTENT_ADD_TAGS);
                for(int tagPosition = 1; tagPosition<=2;tagPosition++) {
                    page.click(SelectorsDocola.CONTENT_TAG_NORMAL_TYPE_TWO);
                    page.click(selector.contentSelectTagICD10(tagPosition));
                    page.click(SelectorsDocola.CONTENT_ADD_TAGS);
                }
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                page.click(SelectorsDocola.CONTENT_BUTTON_CONTINUE);
                String color = page.evaluate("() => { return window.getComputedStyle(document.querySelector('"+SelectorsDocola.MESSAGE_ERROR_MONTHLYPRICE_REQUIRED+"')).color; }").toString();
                System.out.println(color.equals("rgb(170, 34, 34)") ? "El campo monthly price se requiere correctamente" : "El campo monthly price no esta siendo requerido");
                page.waitForTimeout(1000000);
            }
        }
        methods.cleanExecutionDetails();
        cleanupContext();
    }
}
