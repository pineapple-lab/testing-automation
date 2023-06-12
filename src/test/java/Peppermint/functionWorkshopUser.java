package Peppermint;
import insumosPeppermint.casosDePruebaEnrollWorkshop;
import org.junit.jupiter.api.Test;
public class functionWorkshopUser extends casosDePruebaEnrollWorkshop {
    @Test
    public void ValidarWorkshopEnrollmente(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionWorkshop();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validarEnrollWorkshop();
    }
    public void validarMultipleWorkshopEnrollment(){
            iniciarContexto();
            serverStatus();
            System.out.println("Iniciando caso de prueba...");
            printStream.println("Iniciando caso de prueba...");
            iniciarEjecucionArticle();
            imprimirCantidadDeEjecuciones();
            iniciarNavegacion();
            validacionUnirseMuchosWorkshops();
    }
}
