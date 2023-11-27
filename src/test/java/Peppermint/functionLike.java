package Peppermint;

import insumosPeppermint.testCasesLike;

public class functionLike extends testCasesLike {
    public void validationLikePost(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionClub();
        printNumberExecutions();

        startNavigation();
        validateLike();
    }
}
