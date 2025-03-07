package InsumosArla;

import InsumosDocola.SelectorsDocola;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import javaslang.match.generator.Generator;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class MethodsArla extends ContextArla{
    GeneratorArla generate = new GeneratorArla();
    SelectorsArla selector = new SelectorsArla();
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
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
    public void login(){
        page.navigate(navigationLink);
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
    public void createCourse(){
        Keyboard kb = page.keyboard();
        page.fill(SelectorsArla.COURSE_NAME_INPUT, generate.generateContentTitle());
        page.fill(SelectorsArla.COURSE_DESCRIBE_INPUT, generate.generateContentDescription());
        page.fill(SelectorsArla.COURSE_KEYWORD_INPUT, generate.generatekeywords());
        kb.press("Enter");
        page.click(SelectorsArla.COURSE_LENGUAGE_SELECTOR);
        page.click(SelectorsArla.COURSE_LENGUAGE_LIST);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
        page.locator(SelectorsArla.COURSE_UPLOAD_IMAGE).setInputFiles(Paths.get(generate.generateImage()));
        page.click(SelectorsArla.COURSE_UPLOAD_IMAGE_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
        page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
        page.fill(SelectorsArla.COURSE_CHAPTER_TITLE_INPUT, generate.generateContentTitle());
        page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);
        page.fill(SelectorsArla.COURSE_CHAPTER_APPROVAL_PERCENTAGE_INPUT, "50");
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_ADDQUESTION_BUTTON);
        page.fill(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_INPUT, generate.generateQuestion());
        for(counter = 1; counter <= generate.generateResponseCount(); counter++) {
            page.fill(selector.courseChapterQuizAnswerInput(counter), generate.generateAnswer());
        }
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_CORRECT_ANSWER_CHECKBOX);
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_TIME_TOGGLE);
        page.fill(SelectorsArla.COURSE_CHAPTER_QUIZ_TIME_INPUT, "60");
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CHAPTER_ADD_VIDEO);
        page.click(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO_BUTTON);
        page.locator(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO).setInputFiles(Paths.get(generate.generateVideo()));
        page.waitForTimeout(1000);
        page.click(SelectorsArla.COURSE_CHAPTER_UPLOAD_VIDEO_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CHAPTER_SELECT_VIDEO_LIST);
        page.click(SelectorsArla.COURSE_CHAPTER_SAVE_BUTTON);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
        page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
    }
    public void createCategory(){
        Keyboard kb = page.keyboard();
        page.fill(SelectorsArla.CATEGORY_NAME_INPUT, generate.generateContentTitle());
        page.fill(SelectorsArla.CATEGORY_DESCRIPTION_INPUT, generate.generateContentDescription());
        kb.press("Tab");
        kb.press("Enter");
        page.focus(SelectorsArla.CATEGORY_CLIENTS_SEARCH_SELECT);
        page.fill(SelectorsArla.CATEGORY_CLIENTS_SEARCH_SELECT, "franclient");
        page.click(SelectorsArla.CATEGORY_CLIENTS_CHECKBOX);
        kb.press("Escape");
        page.click(SelectorsArla.CATEGORY_LENGUAGE_SELECTOR);
        page.click(SelectorsArla.CATEGORY_LENGUAGE_LIST);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.locator(SelectorsArla.COURSE_UPLOAD_IMAGE).setInputFiles(Paths.get(generate.generateImage()));
        page.click(SelectorsArla.COURSE_UPLOAD_IMAGE_SAVE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_SELECT_COURSE_BUTTON);
        page.click(SelectorsArla.CATEGORY_LIST_CHECKBOX);
        page.click(SelectorsArla.CATEGORY_COURSE_SAVE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
        page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
    }
    public void waitForToast(String expectedMessage) {
        Locator toast = page.locator(SelectorsArla.APP_TOASTERS); // Ajusta el selector según el HTML real
        // Espera indefinidamente hasta que el toast aparezca
        try {
            toast.waitFor(); // Espera hasta que el toast esté presente
            String actualText = toast.innerText().trim(); // Obtiene el texto visible sin espacios extra
            System.out.println(actualText); // Depuración
            Assertions.assertEquals(expectedMessage, actualText, "El mensaje de confirmación no coincide.");
        } catch (TimeoutError e) {
            throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);
        }
    }
}
