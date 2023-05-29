package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import insumosPeppermint.casosDePruebaClubManagment;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionClubManagment extends casosDePruebaClubManagment {
    @Test
    public void vaidacionCrearClub() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionClub();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearClub();
    }
}