package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
/**
 * Clase que contiene métodos para la creación de recursos y cursos en la plataforma Docola.
 * Extiende ContextBaseDocola para aprovechar la configuración del contexto del navegador.
 */
public class MethodsCreationDocola extends ContextBaseDocola{
    private final SelectorsDocola selector = new SelectorsDocola();
    private final WaitingsDocola waitings = new WaitingsDocola();
    private final QueriesDocola queries = new QueriesDocola();
    private final GeneratorDocola generate = new GeneratorDocola();
    private final MethodsDocola methods = new MethodsDocola();
    GeneratorDocola.EmailInfo emailInfo;
    /**
     * Método para registrar usuarios en Docola y realizar su onboarding.
     */
    public void joinNow(){
        emailInfo= generate.generateEmail();
        for (executeCounter = 1; executeCounter <= Integer.parseInt(executionDetails); executeCounter++) {
        if (!stopTest) {
        roleID = generate.generateRol();
        userEmail =emailInfo.getEmail();
        System.out.println("Se creara el usuario:"+ userEmail);
        methods.completeRegisterUser(emailInfo);
        methods.verifyLoginAndOnboarding();
        methods.uploadProfilePicture();
        methods.signOut();
        } else {
            cleanupContext();
            break;
            }
        }
        cleanupContext();
    }
    /**
     * Método para crear nuevos recursos en Docola.
     */
    public void newResource(){
        userRole = "Content provider";
        contentType =1;
        methods.login();
        for(executeCounter= 1;executeCounter<=generate.generateExecutions();executeCounter++ ) {
            methods.completeResourceForm();
            methods.completeResourceStep();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para crear nuevos cursos en Docola.
     */
    public void newCourse() {
        methods.login();
        contentType =2;
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCourseForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para crear nuevas colecciones de cursos en Docola.
     */
    public void newCourseCollection() {
        methods.login();
        contentType =3;
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCollectionForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
}
