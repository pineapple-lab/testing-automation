package Peppermint;
import insumosPeppermint.casosDePruebaArticulos;
import org.junit.jupiter.api.Test;
public class funcionArticleManagment extends casosDePruebaArticulos {
    @Test
    public void validacionCrearArticle() {
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearArticulo();
    }
}
