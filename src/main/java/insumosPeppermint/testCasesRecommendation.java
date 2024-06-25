package insumosPeppermint;

public class testCasesRecommendation extends methodsPeppermint {
    public void validateRecommendation() {
        if (!stopTest) {
            if (execute == 1) {
                System.out.println("\nSe enviara: " + execute + " recomendacion de cada contenido\n");
                outputStream.println("\nSe enviara: " + execute + " recomendacion de cada contenido\n");
            } else {
                System.out.println("\nSe enviaran: " + execute + " recomendaciones de cada contenido\n");
                outputStream.println("\nSe enviaran: " + execute + " recomendaciones de cada contenido\n");
            }
            sendRecommendation();
            System.out.println("Las recomenaciones se han enviado con exito al usuario\n" + emailuserSendRecomendation);
            outputStream.println("Las recoemndaciones se han enviado con exito\n" + emailuserSendRecomendation);
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
        closeContext();
    }
    public void validateSendUserRecommendation() {
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                recommendUsers();
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}

