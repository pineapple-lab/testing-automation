package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.casosDePruebaArticulos;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionArticleManagment extends casosDePruebaArticulos {

    @Test
    public void validacionCrearArticle() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearArticulo();
    }
}
