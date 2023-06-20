package insumosPeppermint;

public class casosDePruebaRecommendation extends robotBasePeppermint {
    public void validarRecomendaciones() {
        if (!shouldStopTest) {
            if (ejecutar == 1) {
                System.out.println("\nSe enviara: " + ejecutar + " recomendacion de cada contenido\n");
                printStream.println("\nSe enviara: " + ejecutar + " recomendacion de cada contenido\n");
            } else {
                System.out.println("\nSe enviaran: " + ejecutar + " recomendaciones de cada contenido\n");
                printStream.println("\nSe enviaran: " + ejecutar + " recomendaciones de cada contenido\n");
            }
            enviarRecomendacion();
            System.out.println("Las recomenaciones se han enviado con exito al usuario\n" + emailuserSendRecomendation);
            printStream.println("Las recoemndaciones se han enviado con exito\n" + emailuserSendRecomendation);
            imprimirCantidadDeCasosEjecutados();
        } else {
            closeContext();
        }
        closeContext();
    }
    public void validarEnviarRecomendacionDeUsuario() {
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                recomendarUsuarios();
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}

