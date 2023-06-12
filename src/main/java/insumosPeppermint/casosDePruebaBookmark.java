package insumosPeppermint;

public class casosDePruebaBookmark extends robotBasePeppermint{
    public void validacionGuardarBookmark(){
        if (!shouldStopTest) {
            if(ejecutar==1) {
                System.out.println("\nSe va a guardar " + ejecutar + " bookmark\n");
                printStream.println("\nSe va a guardar " + ejecutar + " bookmark\n");
            }else{
                System.out.println("\nSe van a guardar " + ejecutar + " bookmarks\n");
                printStream.println("\nSe van a guardar " + ejecutar + " bookmarks\n");
            }
            guardarBookmark();
            System.out.println("Los bookmark se guardaron correctamente\n"+emailuserSendRecomendation);
            printStream.println("Los bookmark se guardaron correctamente\n"+emailuserSendRecomendation);
            imprimirCantidadDeCasosEjecutados();
        } else {
            closeContext();
        }
        closeContext();
    }
}
