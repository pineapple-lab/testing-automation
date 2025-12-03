package InsumosArla;

import InsumosArla.GeneratorArla;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

public class TestCaseArla extends ContextArla{
    private final GeneratorArla  generate = new GeneratorArla();
    MethodsArla methods = new MethodsArla();
    ToastMessages toast = new ToastMessages();
    ErrorMessages message = new ErrorMessages();

    //TEST CASE HAPPY PATH
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

    //TEST CASE MESSAGE ERRORS EMPTY INPUTS
    public void testEmptyRegisterInputs() {
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el formulario de registro\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.goRegisterForm();
            page.click(SelectorsArla.REGISTER_FIRSTNAME_INPUT);
            page.click(SelectorsArla.REGISTER_LASTNAME_INPUT);
            page.click(SelectorsArla.REGISTER_EMAIL_INPUT);
            page.click(SelectorsArla.REGISTER_PASSWORD_INPUT);
            page.click(SelectorsArla.REGISTER_CONFIRMPASWORD_INPUT);
            page.click(SelectorsArla.REGISTER_TERMSANDCONDITION_CHECKBOX);
            allStepsPassed &= methods.verifyAssertions(
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMREGISTER_NAME,message.MESSAGE_REGISTERNAME_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMREGISTER_LASTNAME,message.MESSAGE_REGISTERLASTNAME_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMREGISTER_EMAIL,message.MESSAGE_REGISTEREMAIL_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMREGISTER_PASSWORD,message.MESSAGE_REGISTERPASSWORD_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMREGISTER_CONFIRMPASSWORD,message.MESSAGE_REGISTERCONFIRMPASSWORD_EMPTY)
                    );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyLoginInputs() {
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el login\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.goToLogin();
            page.click(SelectorsArla.LOGIN_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMLOGIN_EMAIL,message.MESSAGE_LOGINEMAIL_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMLOGIN_PASSWORD,message.MESSAGE_LOGINPASS_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep1(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 1 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_NAME,message.MESSAGE_CONTENTNAME_EMPTY),
                    ()->  methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_DESCRIBE,message.MESSAGE_COURSEDESCRIBE_EMPTY)
            );
            page.fill(SelectorsArla.COURSE_NAME_INPUT, generate.generateContentTitle());
            page.fill(SelectorsArla.COURSE_DESCRIBE_INPUT, generate.generateContentDescription());
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_LENGUAGE,message.MESSAGE_CONTENTLANGUAGE_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep2(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 2 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_CONTENT_IMAGE,message.MESSAGE_CONTENTNAME_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCourseFormStep3(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 3 de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_CHAPTER,message.MESSAGE_COURSECHAPTER_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyListQuizCourseForm(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el modal crear cuestionario de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_LISTQUESTIONS,message.MESSAGE_COURSEQUIZLIST_EMPTY)
            );
            methods.addQuestion();
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_APPROVALPERCENTAGE,message.MESSAGE_COURSEPERCENTAGEAPPROVE_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyAddQuestionCourseForm(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el modal agregar pregunta de la creacion de cursos\n");
        methods.login();
        methods.goToFormCreateCourse();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {

            methods.courseFormCompleteStep1();
            methods.courseFormCompleteStep2();
            page.click(SelectorsArla.COURSE_CHAPTER_ADD_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_CREATE_QUIZ_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_ADDQUESTION_BUTTON);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION, message.MESSAGE_COURSEQUIZQUESTION_EMPTY)
            );
            page.fill(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_INPUT, generate.generateQuestion());
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION, message.MESSAGE_COURSECORRECTANSWER_EMPTY)
            );
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_CORRECT_ANSWER_CHECKBOX);
            page.click(SelectorsArla.COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCOURSE_QUESTION, message.MESSAGE_COURSEANSWER_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCategoryFormStep1(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 1 de la creacion de categorys\n");
        methods.login();
        methods.goToFormCreateCategory();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    () -> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCATEGORY_NAME, message.MESSAGE_CONTENTNAME_EMPTY),
                    () -> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCATEGORY_LANGUAGE, message.MESSAGE_CONTENTLANGUAGE_EMPTY),
                    () -> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCATEGORY_LANGUAGE, message.MESSAGE_CONTENTLANGUAGE_EMPTY),
                    () -> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCATEGORY_PRICE, message.MESSAGE_CATEGORYPRICE_EMPTY)
            );

        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCategoryFormStep2(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 2 de la creacion de categorys\n");
        methods.login();
        methods.goToFormCreateCategory();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.categoryFormCompleteStep1();
            methods.uploadImage();
            page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_CONTENT_VIDEO, message.MESSAGE_CONTENTVIDEO_EMPTY)
            );
            page.click(SelectorsArla.MEDIA_REMOVE_FORM_IMAGE_BUTTON);
            methods.uploadVideo();
            page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_CONTENT_IMAGE, message.MESSAGE_CONTENTIMAGE_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
    public void testEmptyInputsCategoryFormStep3(){
        boolean allStepsPassed = true;
        System.out.println("Testeando mensajes de error al dejar campos vacios en el paso 3 de la creacion de categorys\n");
        methods.login();
        methods.goToFormCreateCategory();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.categoryFormCompleteStep1();
            methods.categoryFormCompleteStep2();
            page.click(SelectorsArla.CATEGORY_CONTINUE_BUTTON);
            allStepsPassed &= methods.verifyAssertions(
                    ()-> methods.waitForInputErrorMessage(SelectorsArla.ASSERTION_FORMCATEGORY_COURSE, message.MESSAGE_CATEGORYCOURSE_EMPTY)
            );
        }
        methods.printFinalTestResult(allStepsPassed);
        cleanupContext();
    }
}
