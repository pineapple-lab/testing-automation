package Peppermint;
import insumosPeppermint.casosDePruebaTag;
import org.junit.jupiter.api.Test;
public class funcionTag extends casosDePruebaTag {
    @Test
    public void validacionCrearTag() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionTag();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearTag();
    }
}
