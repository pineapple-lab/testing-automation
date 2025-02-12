package InsumosArla;

import InsumosDocola.GeneratorDocola;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

public class TestCaseArla extends ContextArla{
    private final GeneratorDocola generate = new GeneratorDocola();
    MethodsArla methods = new MethodsArla();
    ToastMessages toast = new ToastMessages();
    public void happyPathLogin(){
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
          methods.login();
        }
        cleanupContext();
    }
    public void happyPathUploadVideos(){
        System.out.println("Se van a subir "+generate.generateExecutions()+" videos\n");
        methods.login();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.uploadVideo();
            methods.waitForToast(toast.VIDEO_UPLOAD_SUCCESS);

        }
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
        cleanupContext();
    }
}
