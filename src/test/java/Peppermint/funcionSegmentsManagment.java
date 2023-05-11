package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import insumosPeppermint.casosDePruebaSegment;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionSegmentsManagment extends casosDePruebaSegment {

    @Test
    public void vaidacionCreacionSegment() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionSegments();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearSegment();
    }
}