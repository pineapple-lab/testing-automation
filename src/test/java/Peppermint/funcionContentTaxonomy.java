package Peppermint;
import insumosPeppermint.casosDePruebaTaxonomy;
import org.junit.jupiter.api.Test;
public class funcionContentTaxonomy extends casosDePruebaTaxonomy {
    @Test
    public void validacionCrearTaxonomy() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionTaxonomy();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        loginAdmin();
        validarCrearTaxonomy();
    }
}