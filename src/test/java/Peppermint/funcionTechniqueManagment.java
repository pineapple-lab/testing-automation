package Peppermint;
import insumosPeppermint.casosDePruebaTechnique;
import org.junit.jupiter.api.Test;
public class funcionTechniqueManagment extends casosDePruebaTechnique {
    @Test
    public void validacionCreateTechnique() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionTechnique();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearTechnique();
    }
}