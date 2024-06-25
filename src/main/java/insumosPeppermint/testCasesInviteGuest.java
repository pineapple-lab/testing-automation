package insumosPeppermint;
public class testCasesInviteGuest extends methodsPeppermint {
    public void validateSendInviteGuest(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
              sendInviteGuest();
            } else {
                closeContext();
            }
        }
        for (counterRegister = 1; counterRegister <= execute;) {
            if (!stopTest) {
                page.waitForTimeout(500);
                getEmail();
                page.waitForTimeout(900);
                registerInviteGuest();
                System.out.println("El invite guest "+emailGuest+" se ha enviado y creado con exito\n");
                imprimirCantidadDeCasosEjecutadosRegistroInviteguest();
                 counterRegister++;
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
