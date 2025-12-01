package InsumosArla;

import InsumosArla.GeneratorArla;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

public class TestCaseArla extends ContextArla{
    private final GeneratorArla  generate = new GeneratorArla();
    MethodsArla methods = new MethodsArla();
    ToastMessages toast = new ToastMessages();
    ErrorMessages message = new ErrorMessages();
    public void happyPathLogin(){
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
          methods.login();
        }
        cleanupContext();
    }
    public void happyPathRegister(){
        System.out.println("Se van a registrar "+generate.generateExecutions()+" usuarios\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.register();
            page.waitForTimeout(1000);
            methods.waitForComponent(SelectorsArla.ASSERTION_MENU_USER);
        }
        methods.printErrores();
        methods.reset();
        cleanupContext();
    }
    public void happyPathUploadVideos(){
        System.out.println("Se van a subir "+generate.generateExecutions()+" videos\n");
        methods.login();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.uploadVideo();
            methods.waitForToast(toast.VIDEO_UPLOAD_SUCCESS);
        }
        methods.printErrores();
        methods.reset();
        cleanupContext();
    }
    public void happyPathCreateCourse(){
        System.out.println("Se van a crear "+generate.generateExecutions()+" cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.createCourse();
            methods.waitForToast(toast.COURSE_CREATE_SUCESS);
            methods.F5();
        }
        methods.printErrores();
        methods.reset();
        cleanupContext();
    }
    public void happyPathCreateCategory(){
        System.out.println("Se van a crear "+generate.generateExecutions()+" category\n");
        methods.login();
        methods.goToFormCreateCategory();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.createCategory();
            methods.waitForToast(toast.CATEGORY_CREATE_SUCESS);
        }
        methods.printErrores();
        methods.reset();
        cleanupContext();
    }
    public void happyPathInviteClient(){
        System.out.println("Se van a crear "+generate.generateExecutions()+" category\n");
        methods.login();
        methods.goToFormManageClient();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.inviteClient();
            page.waitForTimeout(2000);
            Assertions.assertTrue(page.isVisible("text="+toast.INVITE_CLIENT_SENT_SUCESS));
        }
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep1(){
        System.out.println("Testeando mensajes de campos vacios del paso 1 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_NAME_EMPTY,message.MESSAGE_COURSENAME_EMPTY);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_DESCRIBE_EMPTY,message.MESSAGE_COURSEDESCRIBE_EMPTY);
            page.fill(SelectorsArla.COURSE_NAME_INPUT, generate.generateContentTitle());
            page.fill(SelectorsArla.COURSE_DESCRIBE_INPUT, generate.generateContentDescription());
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_LENGUAGE_EMPTY,message.MESSAGE_COURSELENGUAGE_EMPTY);
        }
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep2(){
        System.out.println("Testeando mensajes de campos vacios del paso 2 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_IMAGE_EMPTY,message.MESSAGE_COURSEIMAGE_EMPTY);
        }
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep3(){
        System.out.println("Testeando mensajes de campos vacios del paso 3 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_CHAPTER_EMPTY,message.MESSAGE_COURSECHAPTER_EMPTY);
        }
        cleanupContext();
    }
    public void testEmptyListQuizCourseForm(){
        System.out.println("Testeando mensajes de campos vacios del modal crear cuestionario de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_LISTQUESTIONS_EMPTY,message.MESSAGE_COURSEQUIZLIST_EMPTY);
            methods.addQuestion();
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_APPROVALPERCENTAGE_EMPTY,message.MESSAGE_COURSEPERCENTAGEAPPROVE_EMPTY);
        }
        cleanupContext();
    }
    public void testEmptyAddQuestionCourseForm(){
        System.out.println("Testeando mensajes de campos vacios del modal agregar pregunta de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_ADDQUESTION_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION_EMPTY, message.MESSAGE_COURSEQUIZQUESTION_EMPTY);
            page.fill(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_INPUT, generate.generateQuestion());
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION_EMPTY, message.MESSAGE_COURSECORRECTANSWER_EMPTY);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_CORRECT_ANSWER_CHECKBOX);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION_EMPTY, message.MESSAGE_COURSEANSWER_EMPTY);
        }
        cleanupContext();
    }
}
