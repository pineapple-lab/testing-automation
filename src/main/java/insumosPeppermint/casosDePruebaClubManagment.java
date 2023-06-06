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
                //page.waitForSelector("text=The club was created successfully");
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleClub;
                //page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                //sqlGuardarCasoSiFallaCrearClub();
                //Assertions.assertTrue(page.isVisible(assertions));
                assertions = "text=" + titleClub;
                //page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                //sqlGuardarCasoSiFallaCrearClub();
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
}
