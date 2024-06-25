package Peppermint;

import insumosPeppermint.testCasesDomains;
import org.junit.jupiter.api.Test;

public class mailDomainValidation extends testCasesDomains {
    @Test
    public void validationDomains(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("Iniciando caso de prueba...");
        startExecutionTag();
        printNumberExecutions();
        startNavigation();
        validateDomains();
    }
}
