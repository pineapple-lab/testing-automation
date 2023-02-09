package Peppermint;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class funcionSegmentsManagment extends robotBasePeppermint {

    @Test
    public void vaidacionCreacionSegment(){
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionSegments();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesCrearSegments();
            System.out.print("title segments: "+titleSegments);
            crearSegment();
            page.focus("app-mat-table");
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }
}
