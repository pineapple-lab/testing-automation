package Peppermint;
import insumosPeppermint.casosDePruebaSegment;
import org.junit.jupiter.api.Test;
public class funcionSegmentsManagment extends casosDePruebaSegment {
    @Test
    public void vaidacionCreacionSegment() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionSegments();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearSegment();
    }
}