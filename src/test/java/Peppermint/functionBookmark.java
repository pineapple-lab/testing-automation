package Peppermint;

import insumosPeppermint.testCasesBookmark;

public class functionBookmark extends testCasesBookmark {

    public void validationSaveBookmark(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        validationHappyCaseSaveBookmark();
    }
}
