package insumosPeppermint;

public class testCasesFriendRequest extends methodsPeppermint {
    public void validateSendFriendRequest() {
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                if(navigationLink=="http://localhost:4200/"){
                    navigationLink="http://localhost:4200/user/plans";
                }else if(navigationLink=="https://peppermint-qa.web.app/"){
                    navigationLink = "https://peppermint-qa.web.app/user/plans";
                }
                startNavigation();
                sendFriendshipRequest();
                saveUser();
                System.out.println("Se enviaron: "+counter+ " de " +execute+ " solicitudes de amistad");
                outputStream.println("Se enviaron: "+counter+ " de " +execute+ " solicitudes de amistad");
            } else {
                closeContext();
            }
        }
        System.out.println("\nSe aceptaran: "+execute+ " solicitudes de amistad\n");
        outputStream.println("\nSe aceptaran: "+execute+ " solicitudes de amistad\n");
        acceptFriendshipRequest();
        System.out.println("Se aceptaron: "+counterAcceptFriendship+ " de " +execute+ " solicitudes de amistad\n");
        outputStream.println("Se aceptaron: "+counterAcceptFriendship+ " de " +execute+ " solicitudes de amistad\n");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Fin de la ejecucion");
        outputStream.println("-----------------------------------------------------------");
        outputStream.println("Fin de la ejecucion");
        System.out.println("-----------------------------------------------------------\n");
        outputStream.println("-----------------------------------------------------------\n");
        closeContext();
    }
}




