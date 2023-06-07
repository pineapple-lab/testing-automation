package Peppermint;
import insumosPeppermint.casosDePruebaClubManagment;
import org.junit.jupiter.api.Test;
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
    public void validacionJoinClub(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionClub();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validarJoinClub();
    }
    public void validacionPostClub(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionClub();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validarPostClub();
    }
}