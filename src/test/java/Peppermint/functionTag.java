package Peppermint;
import insumosPeppermint.testCasesTag;
import org.junit.jupiter.api.Test;
public class functionTag extends testCasesTag {
    @Test
    public void validationCreateTag() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionTag();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateTag();
    }
}
