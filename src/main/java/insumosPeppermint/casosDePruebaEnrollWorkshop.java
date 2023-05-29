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
}
