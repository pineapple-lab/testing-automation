package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionArticleManagment extends robotBasePeppermint {

    @Test
    public void validacionCrearArticle(){
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarNavegacion();
            login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesCrearArticle();
            System.out.println("title article: "+titleArticle);
            crearArticulo();
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }
}
