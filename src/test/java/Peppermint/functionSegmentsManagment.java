package Peppermint;
import insumosPeppermint.testCasesSegment;
import org.junit.jupiter.api.Test;
public class functionSegmentsManagment extends testCasesSegment {
    @Test
    public void validationCreateSegment() {
        startContext();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        outputStream.println("iniciando caso de prueba...");
        startExecutionSegments();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateSegment();
    }
}