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
    private final QueriesDocola querie = new QueriesDocola();
    GeneratorDocola.EmailInfo emailInfo;
    /**
     * Método para registrar usuarios en Docola y realizar su onboarding.
     */
    public void newJoinNow(){
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
        //TO DO
        //Hacer una pestaña para cada tipo de contenido
        //Agregar en cada pestaña los input necesarios para setear de forma especifica cada contenido
        //Dar prioridad a survey y quiz, tengo que poder configurar de forma especifica que tipo de pregunta agregar y cuantas
        
        userRole = "Content provider";
        contentType = 1;
        methods.login();
        methods.goToMyLibrary();
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
        methods.goToMyLibrary();
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
        methods.goToMyLibrary();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.completeCollectionForm();
            methods.publishContent();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para crear recursos adentro de una practica en Docola.
     */
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
    /**
     * Método para crear cursos adentro de una practica en Docola.
     */
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
     * Método para crear nuevas colecciones de cursos adentro de una practica en Docola.
     */
    public void newCourseCollectionInPractice() {
        //Agregar logica para setear actions
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
        page.waitForTimeout(2000);
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
    /**
     * Método para crear nuevos prescribe en Docola.
     */
    public void newPrescribe(){
        userRole = "Clinician";
        methods.login();
        System.out.println("Se crearan "+generate.generateExecutions()+" prescribe\n");
        methods.goToMyPractice();
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.prescribeViaEmail();
            page.waitForTimeout(2000);
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
    /**
     * Método para registrar patients invitados a una practice en Docola.
     */
    public void newInvitationRegister(){
        userRole = "Clinican";
        System.out.println("Se crearan "+generate.generateExecutions()+" register invitations\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            userInvitation= querie.getInvitationEmail(practiceId);
            methods.mailinatorOpenLink(userInvitation);
            methods.completeInvitationForm();
            methods.completeOnboardingInstructor();
            querie.updateRegisterInvitation(userInvitation);
            methods.uploadProfilePicture();
            System.out.println(executeCounter+"/"+generate.generateExecutions());
        }
        cleanupContext();
    }
}