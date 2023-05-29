package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.casosDePruebaTaxonomy;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
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
        login();
        validarCrearTaxonomy();
    }
}