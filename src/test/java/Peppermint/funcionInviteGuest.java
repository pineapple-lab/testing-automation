package Peppermint;

import insumosPeppermint.casosDePruebaInviteGuest;
import org.junit.jupiter.api.Test;

public class funcionInviteGuest extends casosDePruebaInviteGuest {
    @Test
    public void validacionCrearInviteGuest() {
        iniciarContexto();
        linkDeNavegacion="http://localhost:4200/";
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        emailLogin="pineAppleUser1683812188407@mailinator.com";
        login();
        validarEnviarInviteGuest();
    }
}
