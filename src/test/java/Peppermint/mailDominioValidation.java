package Peppermint;

import insumosPeppermint.casosDePruebaValidarDominios;
import org.junit.jupiter.api.Test;

public class mailDominioValidation extends casosDePruebaValidarDominios {
    @Test
    public void validacionDominios(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionTag();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validarDominio();
    }
}
