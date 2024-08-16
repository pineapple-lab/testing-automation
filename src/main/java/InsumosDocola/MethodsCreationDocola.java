package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
/**
 * Clase que contiene métodos para la creación de recursos y cursos en la plataforma Docola.
 * Extiende ContextBaseDocola para aprovechar la configuración del contexto del navegador.
 */
public class MethodsCreationDocola extends ContextBaseDocola{
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
        userEmail = "";
        roleID = generate.generateRol();
        userEmail =emailInfo.getEmail();
        System.out.println("Creando usuario: "+ userEmail);
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
        contentType = 1;
        methods.login();
        System.out.println("Se crearan "+generate.generateExecutions()+" "+resourceType+"\n");
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
        contentType = 2;
        System.out.println("Se crearan "+generate.generateExecutions()+" cursos\n");
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
        contentType = 3;
        System.out.println("Se crearan "+generate.generateExecutions()+" curriculum\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCollectionForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    public void newResourceInPractice(){
        userRole = "Clinician";
        contentType = 1;
        methods.login();
        System.out.println("Se crearan "+generate.generateExecutions()+" "+resourceType+"\n");
        methods.goToMyPractice();
        for(executeCounter= 1;executeCounter<=generate.generateExecutions();executeCounter++ ) {
            methods.completeResourceForm();
            methods.completeThumbnailStep();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    public void newCourseInPractice() {
        userRole = "Clinician";
        methods.login();
        contentType = 2;
        System.out.println("Se crearan "+generate.generateExecutions()+" cursos en la practica\n");
        methods.goToMyPractice();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCourseInPracticeForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para crear nuevas colecciones de cursos en Docola.
     */
    public void newCourseCollectionInPractice() {
        userRole = "Clinician";
        methods.login();
        contentType = 3;
        System.out.println("Se crearan "+generate.generateExecutions()+" curriculum en la practica\n");
        methods.goToMyPractice();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCollectionInPracticeForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para crear nuevas colecciones de cursos en Docola.
     */
    public void newPractice(){
        userRole = "Clinician";
        methods.login();
        contentType =3;
        System.out.println("Se crearan "+generate.generateExecutions()+" practices\n");
        page.waitForTimeout(1000);
        page.click(SelectorsDocola.CONTENT_GO_TO_MY_PRACTICES);
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            page.click(SelectorsDocola.PRACTICE_CREATE_BUTTON);
            methods.completePracticeForm();

            /**
             * Método para crear prescribe en Docola.
             */
        }
        cleanupContext();
    }
    public void prescribe(){
        userRole = "Clinician";
        methods.login();
        System.out.println("Se crearan "+generate.generateExecutions()+" prescribe\n");
        methods.goToMyPractice();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.prescribeViaEmail();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
}