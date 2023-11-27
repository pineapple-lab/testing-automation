package insumosPeppermint;
public class testCasesClubManagment extends methodsPeppermint{
    public void validarCrearClub(){
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVariablesCreateClub();
                createClub();
                assertions = "text=The club was created successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                searchingElement = titleClub;
                assertions = "text=" + titleClub;
                System.out.println("El club se ha creado con exito\n");
                printStream.println("El club se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarJoinClub(){
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVaraiblesJoinUserClub();
                login();
                System.out.println("\nEnrolando usuario\n");
                printStream.println("\nEnrolando usuario\n");
                joinClub();
                System.out.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
                printStream.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
                printNumberCasesExecuted();
                logout();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarPostClub(){

        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                createPostClub();
                System.out.println("Post realizado con exito\n");
                printStream.println("Post realizado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validacionUnirseMuchosClubs(){
        if (!shouldStopTest) {
            if(execute==1) {
                System.out.println("\nEL usuario se va ha unir a" + execute + " club\n");
                printStream.println("\nEl usuario se va ha unir a " + execute + " club\n");
            }else{
                System.out.println("\nEL usuario se va ha unir a " + execute + " clubs\n");
                printStream.println("\nEL usuario se va ha unir a " + execute + " clubs\n");
            }
            joinUserManyClub();
            System.out.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printStream.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
        closeContext();
    }
}
