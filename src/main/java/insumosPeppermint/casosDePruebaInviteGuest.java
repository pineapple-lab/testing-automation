package insumosPeppermint;
public class casosDePruebaInviteGuest extends robotBasePeppermint {
    public void validarEnviarInviteGuest(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
              enviarInviteGuest();
            } else {
                closeContext();
            }
        }
        for (contadorRegistro = 1; contadorRegistro <= ejecutar;) {
            if (!shouldStopTest) {
                page.waitForTimeout(500);
                traerEmail();
                page.waitForTimeout(900);
                registrarInviteGuest();
                System.out.println("El invite guest "+emailGuest+" se ha enviado y creado con exito\n");
                imprimirCantidadDeCasosEjecutadosRegistroInviteguest();
                 contadorRegistro++;
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
