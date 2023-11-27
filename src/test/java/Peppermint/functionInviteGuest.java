package Peppermint;
import insumosPeppermint.testCasesInviteGuest;
import org.junit.jupiter.api.Test;
public class functionInviteGuest extends testCasesInviteGuest {
    @Test
    public void validationCreateInviteGuest() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        startVariablesLogin();
        login();
        validateSendInviteGuest();
    }
}
