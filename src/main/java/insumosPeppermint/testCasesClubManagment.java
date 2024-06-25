package insumosPeppermint;
public class testCasesClubManagment extends methodsPeppermint{
    public void validarCrearClub(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                startVariablesCreateClub();
                createClub();
                assertions = "text=The club was created successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                searchingElement = titleClub;
                assertions = "text=" + titleClub;
                System.out.println("El club se ha creado con exito\n");
                outputStream.println("El club se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarJoinClub(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                startVaraiblesJoinUserClub();
                login();
                System.out.println("\nEnrolando usuario\n");
                outputStream.println("\nEnrolando usuario\n");
                joinClub();
                System.out.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
                outputStream.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
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
            if (!stopTest) {
                createPostClub();
                System.out.println("Post realizado con exito\n");
                outputStream.println("Post realizado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validacionUnirseMuchosClubs(){
        if (!stopTest) {
            if(execute==1) {
                System.out.println("\nEL usuario se va ha unir a" + execute + " club\n");
                outputStream.println("\nEl usuario se va ha unir a " + execute + " club\n");
            }else{
                System.out.println("\nEL usuario se va ha unir a " + execute + " clubs\n");
                outputStream.println("\nEL usuario se va ha unir a " + execute + " clubs\n");
            }
            joinUserManyClub();
            System.out.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            outputStream.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
        closeContext();
    }
}
