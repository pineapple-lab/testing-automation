package Peppermint;
import insumosPeppermint.testCasesRegistry;
import org.junit.jupiter.api.Test;
public class functionRegistryManagment extends testCasesRegistry {
    @Test
    public void validationCreateUser(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        validateRegistry();
    }
}
