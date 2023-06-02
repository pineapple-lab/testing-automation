package Peppermint;
import insumosPeppermint.casosDePruebaLesson;
import org.junit.jupiter.api.Test;
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