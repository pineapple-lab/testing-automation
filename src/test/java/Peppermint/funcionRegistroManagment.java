package Peppermint;

import insumosPeppermint.casosDePruebaRegistro;
import org.junit.jupiter.api.Test;

public class funcionRegistroManagment extends casosDePruebaRegistro {
    @Test
    public void validacionCrearUsuario(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        validarRegistro();
    }
}
