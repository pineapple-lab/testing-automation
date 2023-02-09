package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

public class funcionTag extends robotBasePeppermint {

    @Test
    public void validacionCrearTag(){
        System.out.println("Iniciando caso de prueba...");
        iniciarEjecucionTag();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
            iniciarVariablesTag();
            System.out.println("Title tag: "+titleTag);
            crearTag();
            System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }


}
