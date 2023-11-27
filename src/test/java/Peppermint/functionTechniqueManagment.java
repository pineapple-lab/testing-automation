package Peppermint;
import insumosPeppermint.testCasesTechnique;
import org.junit.jupiter.api.Test;
public class functionTechniqueManagment extends testCasesTechnique {
    @Test
    public void validationCreateTechnique() {
        startContext();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionTechnique();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateTechnique();
    }
}