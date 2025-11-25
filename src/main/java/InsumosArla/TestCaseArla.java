package InsumosArla;

import InsumosArla.GeneratorArla;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

public class TestCaseArla extends ContextArla{
    private final GeneratorArla  generate = new GeneratorArla();
    MethodsArla methods = new MethodsArla();
    ToastMessages toast = new ToastMessages();
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
            System.out.println("register 2");
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
}
