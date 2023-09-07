package insumosPeppermint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class casosDePruebaValidarDominios extends robotBasePeppermint {
    public void validarDominio(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                validarDominios();
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    }
