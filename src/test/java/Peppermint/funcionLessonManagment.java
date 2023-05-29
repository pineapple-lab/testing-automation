package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.casosDePruebaLesson;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionLessonManagment extends casosDePruebaLesson {
    @Test
    public void vaidacionCrearLesson() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionLesson();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearLesson();
    }
}