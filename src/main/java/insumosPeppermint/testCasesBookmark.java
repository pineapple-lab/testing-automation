package insumosPeppermint;

public class testCasesBookmark extends methodsPeppermint{
    public void validationHappyCaseSaveBookmark(){
        if (!shouldStopTest) {
            if(execute==1) {
                System.out.println("\nSe va a guardar " + execute + " bookmark\n");
                printStream.println("\nSe va a guardar " + execute + " bookmark\n");
            }else{
                System.out.println("\nSe van a guardar " + execute + " bookmarks\n");
                printStream.println("\nSe van a guardar " + execute + " bookmarks\n");
            }
            saveBookmark();
            System.out.println("Los bookmark se guardaron correctamente\n"+emailuserSendRecomendation);
            printStream.println("Los bookmark se guardaron correctamente\n"+emailuserSendRecomendation);
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
        closeContext();
    }
}
