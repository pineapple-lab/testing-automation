package insumosPeppermint;
import java.time.Instant;
public class casosDePruebaFriendRequest extends robotBasePeppermint {
    public void validarEnviarFriendRequst() {
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                long timeStamp = Instant.now().toEpochMilli();
                emailRegistro = "pineappleuser"+timeStamp+"@mailinator.com";;
                System.out.println("\nSe creara el usuario: " +emailRegistro+ "\n");
                printStream.println("\nSe creara el usuario: " +emailRegistro+ "\n");
                if(linkDeNavegacion=="http://localhost:4200/"){
                    linkDeNavegacion="http://localhost:4200/user/plans";
                }else if(linkDeNavegacion=="https://peppermint-qa.web.app/"){
                    linkDeNavegacion = "https://peppermint-qa.web.app/user/plans";
                }
                iniciarNavegacion();
                hacerSolicitudDeAmistad();
                guardarUsuario();
                System.out.println("Se enviaron: "+contador+ " de " +ejecutar+ " solicitudes de amistad");
                printStream.println("Se enviaron: "+contador+ " de " +ejecutar+ " solicitudes de amistad");
            } else {
                closeContext();
            }
        }
        System.out.println("\nSe aceptaran: "+ejecutar+ " solicitudes de amistad\n");
        printStream.println("\nSe aceptaran: "+ejecutar+ " solicitudes de amistad\n");
        aceptarsolicitudeDeAmistad();
        System.out.println("Se aceptaron: "+contadorAceptarAmistad+ " de " +ejecutar+ " solicitudes de amistad\n");
        printStream.println("Se aceptaron: "+contadorAceptarAmistad+ " de " +ejecutar+ " solicitudes de amistad\n");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Fin de la ejecucion");
        printStream.println("-----------------------------------------------------------");
        printStream.println("Fin de la ejecucion");
        System.out.println("-----------------------------------------------------------\n");
        printStream.println("-----------------------------------------------------------\n");
        closeContext();
    }
}




