package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.casosDePruebaTag;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
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
