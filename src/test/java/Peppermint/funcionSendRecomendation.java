package Peppermint;

import insumosPeppermint.casosDePruebaRecommendation;

public class funcionSendRecomendation extends casosDePruebaRecommendation {

    public void validacionSendRecomendation(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validarRecomendaciones();
    }
}
