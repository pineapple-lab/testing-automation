package Peppermint;

import insumosPeppermint.casosDePruebaBookmark;

public class funcionBookmark extends casosDePruebaBookmark {

    public void validarGuardarBookmark(){
        iniciarContexto();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        iniciarEjecucionArticle();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        validacionGuardarBookmark();
    }
}
