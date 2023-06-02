package Peppermint;

import insumosPeppermint.casosDePruebaFriendRequest;
import org.junit.jupiter.api.Test;

public class funcionFriendRequest extends casosDePruebaFriendRequest {
    @Test
    public void validacionEnviarAceptarFriendRequest() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        validarEnviarFriendRequst();
    }

}
