package insumosPeppermint;

public class testCasesFriendRequest extends methodsPeppermint {
    public void validateSendFriendRequest() {
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                if(linkNavigation=="http://localhost:4200/"){
                    linkNavigation="http://localhost:4200/user/plans";
                }else if(linkNavigation=="https://peppermint-qa.web.app/"){
                    linkNavigation = "https://peppermint-qa.web.app/user/plans";
                }
                startNavigation();
                sendFriendshipRequest();
                saveUser();
                System.out.println("Se enviaron: "+counter+ " de " +execute+ " solicitudes de amistad");
                printStream.println("Se enviaron: "+counter+ " de " +execute+ " solicitudes de amistad");
            } else {
                closeContext();
            }
        }
        System.out.println("\nSe aceptaran: "+execute+ " solicitudes de amistad\n");
        printStream.println("\nSe aceptaran: "+execute+ " solicitudes de amistad\n");
        acceptFriendshipRequest();
        System.out.println("Se aceptaron: "+counterAcceptFriendship+ " de " +execute+ " solicitudes de amistad\n");
        printStream.println("Se aceptaron: "+counterAcceptFriendship+ " de " +execute+ " solicitudes de amistad\n");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Fin de la ejecucion");
        printStream.println("-----------------------------------------------------------");
        printStream.println("Fin de la ejecucion");
        System.out.println("-----------------------------------------------------------\n");
        printStream.println("-----------------------------------------------------------\n");
        closeContext();
    }
}




