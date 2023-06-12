package insumosPeppermint;
public class casosDePruebaEnrollWorkshop extends robotBasePeppermint {
    public void validarEnrollWorkshop(){
        for(contador=1;contador<=ejecutar;contador++) {
            if (!shouldStopTest) {
            iniciarVariablesLogin();
            login();
            enrollWorkshop();
            page.waitForTimeout(4000);
            logout();
            imprimirCantidadDeCasosEjecutados();
            }else {
            closeContext();
            }
        }establecerUsuariosEnEstadoCero();
        closeContext();
    }
    public void validacionUnirseMuchosWorkshops(){
        if (!shouldStopTest) {
            if(ejecutar==1) {
                System.out.println("\nEL usuario se va ha unir a" + ejecutar + " workshop\n");
                printStream.println("\nEl usuario se va ha unir a " + ejecutar + " workshop\n");
            }else{
                System.out.println("\nEL usuario se va ha unir a " + ejecutar + " workshops\n");
                printStream.println("\nEL usuario se va ha unir a " + ejecutar + " workshops\n");
            }
            unirUsuarioMuchosWorkshop();
            System.out.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            printStream.println("El usuario se ha unido correctamente\n"+emailuserSendRecomendation);
            imprimirCantidadDeCasosEjecutados();
        } else {
            closeContext();
        }
        closeContext();
    }
}
