package insumosPeppermint;
public class casosDePruebaClubManagment extends robotBasePeppermint{
    public void validarCrearClub(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearClub();
                System.out.println("\nSe creara el club: " + titleClub + "\n");
                printStream.println("\nSe creara el club: " + titleClub + "\n");
                crearClub();
                assertions = "text=The club was created successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                searchingElement = titleClub;
                assertions = "text=" + titleClub;
                System.out.println("El club se ha creado con exito\n");
                printStream.println("El club se ha creado con exito\n");
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarJoinClub(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVaraiblesJoinUserClub();
                login();
                System.out.println("\nEnrolando usuario\n");
                printStream.println("\nEnrolando usuario\n");
                joinClub();
                System.out.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
                printStream.println("El usuario "+emailLogin+" ha sido enrolado con exito \n");
                imprimirCantidadDeCasosEjecutados();
                logout();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validarPostClub(){

        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                crearPostClub();
                System.out.println("Post realizado con exito\n");
                printStream.println("Post realizado con exito\n");
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    public void validacionUnirseMuchosClubs(){
        if (!shouldStopTest) {
            if(ejecutar==1) {
                System.out.println("\nEL usuario se va ha unir a" + ejecutar + " club\n");
                printStream.println("\nEl usuario se va ha unir a " + ejecutar + " club\n");
            }else{
                System.out.println("\nEL usuario se va ha unir a " + ejecutar + " clubs\n");
                printStream.println("\nEL usuario se va ha unir a " + ejecutar + " clubs\n");
            }
            unirUsuarioMuchosClub();
            System.out.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printStream.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            imprimirCantidadDeCasosEjecutados();
        } else {
            closeContext();
        }
        closeContext();
    }
}
