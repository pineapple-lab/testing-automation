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
    public void validacionEnviarRecomendacionDeUsuario(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        emailLogin="pineappleuser1684762180394@mailinator.com";
        login();
        validarEnviarRecomendacionDeUsuario();
    }
}
