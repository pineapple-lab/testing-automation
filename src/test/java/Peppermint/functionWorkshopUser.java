package Peppermint;
import insumosPeppermint.testCasesEnrollWorkshop;
import org.junit.jupiter.api.Test;
public class functionWorkshopUser extends testCasesEnrollWorkshop {
    @Test
    public void validateWorkshopEnrollmente(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionWorkshop();
        printNumberExecutions();
        startNavigation();
        validarEnrollWorkshop();
    }
    public void validateMultipleWorkshopEnrollment(){
            startContext();
            serverStatus();
            System.out.println("Iniciando caso de prueba...");
            printStream.println("Iniciando caso de prueba...");
            startExecutionArticle();
            printNumberExecutions();
            startNavigation();
            validacionUnirseMuchosWorkshops();
    }
    public void validateSendActivity(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        validarEnviarActivity();
    }
    public void validationReplyActivity(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        validarResponderActivity();
    }
}
