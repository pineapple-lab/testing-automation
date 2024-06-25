package Peppermint;
import insumosPeppermint.testCasesTaxonomy;
import org.junit.jupiter.api.Test;
public class functionContentTaxonomy extends testCasesTaxonomy {
    @Test
    public void validationCreateTaxonomy() {
        startContext();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        outputStream.println("iniciando caso de prueba...");
        startExecutionTaxonomy();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateTaxonomy();
    }
}