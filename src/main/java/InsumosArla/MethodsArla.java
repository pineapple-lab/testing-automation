package InsumosArla;

import InsumosDocola.GeneratorDocola;
import InsumosDocola.SelectorsDocola;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import javaslang.match.generator.Generator;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodsArla extends ContextArla{
    GeneratorArla generate = new GeneratorArla();
    SelectorsArla selector = new SelectorsArla();
    QueriesArla querie = new QueriesArla();
    GeneratorArla.EmailInfo emailInfo;
    private static final List<String> errores = new ArrayList<>();
    public void F5(){
        page.keyboard().press("F5");
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    public void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*outputStream.println("\n-----------------------------------------------------------");
        outputStream.println("Iniciando ejecucion....");
        outputStream.println("-----------------------------------------------------------");*/
        initializePlaywright();
        setupContextAndPage();
    }
    private void startNavigation(){
        page.navigate(navigationLink);
        System.out.println("Ambiente: "+navigationLink+"\n");
    }
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
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

    public void reset() {
        errores.clear();
    }

    public static boolean hayErrores() {
        return !errores.isEmpty();
    }
    public void goRegisterForm(){
        System.out.println("register 4");
        page.click(SelectorsArla.REGISTER_NAVIGATION_FORM_BUTTON);
    }
    public void register(){
        emailInfo = generate.generateEmail();
        userEmail = emailInfo.getEmail();
        goRegisterForm();
        page.fill(SelectorsArla.REGISTER_FIRSTNAME_INPUT, emailInfo.getFirstName());
        page.fill(SelectorsArla.REGISTER_LASTNAME_INPUT, emailInfo.getFirstName());
        page.fill(SelectorsArla.REGISTER_EMAIL_INPUT, userEmail);
        page.fill(SelectorsArla.REGISTER_PASSWORD_INPUT, password);
        page.fill(SelectorsArla.REGISTER_CONFIRMPASWORD_INPUT, password);
        page.click(SelectorsArla.REGISTER_TERMSANDCONDITION_CHECKBOX);
        page.click(SelectorsArla.REGISTER_BUTTON);
    }
    public void login(){
        page.fill(SelectorsArla.USERNAME_INPUT,username);
        page.fill(SelectorsArla.PASSWORD_INPUT, password);
        page.click(SelectorsArla.LOGIN_BUTTON);
    }
    public void uploadVideo(){
        page.click(SelectorsArla.MEDIA_LIBRARY_MENU);
        page.click(SelectorsArla.MEDIA_LIBRARY_UPLOAD_BUTTON);
        page.locator(SelectorsArla.UPLOAD_VIDEO_INPUT).setInputFiles(Paths.get(generate.generateVideo()));
        page.click(SelectorsArla.UPLOAD_VIDEO_ADD_LENGUAGE);
        page.click(SelectorsArla.UPLOAD_VIDEO_SELECT_LENGUAGE);
        page.click(SelectorsArla.UPLOAD_VIDEO_SAVE_BUTTON);
    }
    public void goToFormCreateCourse(){
        page.click(SelectorsArla.COURSE_MENU_BUTTON);
        page.click(SelectorsArla.COURSE_CREATE_BUTTON);
    }
    public void goToFormCreateCategory(){
        page.click(SelectorsArla.CATEGORY_MENU_BUTTON);
        page.click(SelectorsArla.CATEGORY_CREATE_BUTTON);
    }
    public void goToFormManageClient(){
        page.click(SelectorsArla.CLIENT_MENU_BUTTON);
        page.click(SelectorsArla.CLIENT_NEW_INVITE_BUTTON);
    }
    public void courseFormCompleteStep1(){
        Keyboard kb = page.keyboard();
        page.fill(SelectorsArla.COURSE_NAME_INPUT, generate.generateContentTitle());
        page.fill(SelectorsArla.COURSE_DESCRIBE_INPUT, generate.generateContentDescription());
        page.fill(SelectorsArla.COURSE_ISSUE_INPUT, generate.generateContentTitle());
        page.fill(SelectorsArla.COURSE_KEYWORD_INPUT, generate.generatekeywords());
        kb.press("Enter");
        page.click(SelectorsArla.COURSE_LENGUAGE_SELECTOR);
        page.click(SelectorsArla.COURSE_LENGUAGE_LIST);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
    }
    public void courseFormCompleteStep2(){
        page.locator(SelectorsArla.COURSE_UPLOAD_IMAGE).setInputFiles(Paths.get(generate.generateImage()));
        page.click(SelectorsArla.COURSE_UPLOAD_IMAGE_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
    }
    public void courseFormCompleteStep3(){
        page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
        createQuiz();
        configureApprovalPercentage();
        uploadChapterFile();
        page.click(SelectorsArla.COURSE_CHAPTER_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
    }
    public void uploadChapterFile(){
        page.click(SelectorsArla.COURSE_CHAPTER_ADD_VIDEO);
        page.click(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO_BUTTON);
        page.locator(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForTimeout(1000);
        page.click(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CHAPTER_SELECT_VIDEO_LIST);
    }
    public void createQuiz(){
        page.fill(SelectorsArla.COURSE_CHAPTER_TITLE_INPUT, generate.generateContentTitle());
        page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);

        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_ADDQUESTION_BUTTON);
        page.fill(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_INPUT, generate.generateQuestion());
        for(counter = 1; counter <= generate.generateResponseCount(); counter++) {
            page.fill(selector.courseChapterQuizAnswerInput(counter), generate.generateAnswer());
        }
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_CORRECT_ANSWER_CHECKBOX);
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
    }
    public void configureApprovalPercentage(){
        page.fill(SelectorsArla.COURSE_CHAPTER_APPROVAL_PERCENTAGE_INPUT, "50");
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
    }
    public void createCourse(){
        courseFormCompleteStep1();
        courseFormCompleteStep2();
        courseFormCompleteStep3();
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
    }
    public void createCategory(){
        Keyboard kb = page.keyboard();
        page.fill(SelectorsArla.CATEGORY_NAME_INPUT, generate.generateContentTitle());
        page.fill(SelectorsArla.CATEGORY_DESCRIPTION_INPUT, generate.generateContentDescription());
        page.fill(SelectorsArla.CATEGORY_KEYWORD_INPUT, generate.generatekeywords());
        kb.press("Enter");
        page.click(SelectorsArla.CATEGORY_LENGUAGE_SELECTOR);
        page.click(SelectorsArla.CATEGORY_LENGUAGE_LIST);
        page.fill(SelectorsArla.CATEGORY_PRICE_INPUT, "10");
        page.fill(SelectorsArla.CATEGORY_DISCOUNT_INPUT, "10");
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.locator(SelectorsArla.COURSE_UPLOAD_IMAGE).setInputFiles(Paths.get(generate.generateImage()));
        page.click(SelectorsArla.COURSE_UPLOAD_IMAGE_SAVE_BUTTON);
        page.click(SelectorsArla.CATEGORY_OPENLISTVIDEO_BUTTON);
        page.click(SelectorsArla.CATEGORY_OPENUPLOADVIDEO_MODAL);
        page.locator(SelectorsArla.CATEGORY_VIDEO_UPLOAD).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForTimeout(10000);
        page.click(SelectorsArla.CATEGORY_SAVEVIDEO_BUTTON);
        page.click(SelectorsArla.CATEGORY_VIDEO_LIST);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_SELECT_COURSE_BUTTON);
        page.click(SelectorsArla.CATEGORY_LIST_CHECKBOX);
        page.click(SelectorsArla.CATEGORY_COURSE_SAVE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
    }
    public void inviteClient(){
        emailInfo = generate.generateEmail();
        String companyEmail = emailInfo.getEmail();
        page.fill(SelectorsArla.CLIENT_COMPANY_NAME_INPUT,generate.generateCompanyName());
        page.fill(SelectorsArla.CLIENT_USERNAME_INPUT,generate.generateCompanyName());
        page.fill(SelectorsArla.CLIENT_EMAIL_INPUT,companyEmail);
        page.fill(SelectorsArla.CLIENT_FORMLINK_INPUT,"https://docs.google.com/forms/d/e/1FAIpQLSfqYX7p8WXJqNrRInUHJsuq7DU4L1s55DxRRmw_OYi_K-BZKw/viewform?usp=dialog");
        page.click(SelectorsArla.CLIENT_CONTINUE_BUTTON_STEP1);
        page.click(SelectorsArla.CLIENT_CONTINUE_BUTTON_STEP2);
        page.fill(SelectorsArla.CLIENT_SEARCH_CATEGORY_INPUT, "");
        page.click(SelectorsArla.CLIENT_CATEGORY_CHECKBOX);
        page.click(SelectorsArla.CLIENT_SEND_INVITE_BUTTON);
        querie.saveClient(companyEmail,false);
    }
    public void waitForToast(String expectedMessage) {
        Locator toast = page.locator(SelectorsArla.APP_TOASTERS);
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            assertThat(()->Assertions.assertEquals(expectedMessage, actualText), "El mensaje de confirmación no coincide."+expectedMessage);
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
        Locator locator = page.locator(selector);
        final int TIMEOUT_VISIBILIDAD = 5000;
        try {
            locator.waitFor(new Locator.WaitForOptions().setTimeout(TIMEOUT_VISIBILIDAD));
            assertThat(() -> {
                PlaywrightAssertions.assertThat(locator).isVisible();
            }, "Verificación de visibilidad fallida para el selector: \"" + selector + "\".");
            String actualText = locator.innerText().trim();
            System.out.println("Mensaje de error encontrado:" + actualText);
            assertThat(() -> {
                Assertions.assertEquals(expectedMessage, actualText,
                        "\nEl mensaje de error no coincide con el esperado." +
                                "\n -> Esperado: \"" + expectedMessage + "\"" +
                                "\n -> Encontrado: \"" + actualText + "\"");
            }, "Verificación de contenido fallida para el selector: \"" + selector + "\".");

        } catch (TimeoutError e) {
            String errorMsg = "❌ ¡Error de Timeout! El componente no apareció en el DOM en " + TIMEOUT_VISIBILIDAD + "ms.\n" +
                    " -> Selector fallido: \"" + selector + "\"" +
                    " -> Mensaje esperado: \"" + expectedMessage + "\"";
            System.out.println(errorMsg);
            errores.add(errorMsg);
        }
    }

    public void waitForPopUp(String expectedMessage) {
        Locator toast = page.locator(SelectorsArla.APP_POPUPS);
        try {
            toast.waitFor();
            String actualText = toast.innerText().trim();
            System.out.println(actualText);
            Assertions.assertEquals(expectedMessage, actualText, "El mensaje de confirmación no coincide.");
        } catch (TimeoutError e) {
            throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);
        }
    }
}
