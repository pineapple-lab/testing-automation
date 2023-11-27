package insumosPeppermint;
public class testCasesEnrollWorkshop extends methodsPeppermint {
    public void validarEnrollWorkshop(){
        for(counter=1;counter<=execute;counter++) {
            if (!shouldStopTest) {
            startVariablesLogin();
            login();
            enrollWorkshop();
            page.waitForTimeout(4000);
            logout();
            printNumberCasesExecuted();
            }else {
            closeContext();
            }
        }setUsersToStateZero();
        closeContext();
    }
    public void validacionUnirseMuchosWorkshops(){
        if (!shouldStopTest) {
            if(execute==1) {
                System.out.println("\nEL usuario se va ha unir a" + execute + " workshop\n");
                printStream.println("\nEl usuario se va ha unir a " + execute + " workshop\n");
            }else{
                System.out.println("\nEL usuario se va ha unir a " + execute + " workshops\n");
                printStream.println("\nEL usuario se va ha unir a " + execute + " workshops\n");
            }
            joinUserManyWorkshop();
            System.out.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printStream.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
        closeContext();
    }
    public void validarEnviarActivity(){
        uploadImageVideo=true;
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVariablesSubmitActivity();
                login();
                completeAssignmentActivity();
                logout();
                System.out.println("El workshop se ha creado con exito\n");
                printStream.println("El workshop se ha creado con exito\n");
                printNumberCasesExecuted();
            }else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarResponderActivity(){
        uploadImageVideo=true;
            if (!shouldStopTest) {
                startVariablesSubmitActivity();
                login();
                replyAssignmentActivity();
                logout();
                printNumberCasesExecuted();
            }else {
                closeContext();
            }
        closeContext();
    }
}
