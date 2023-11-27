package Peppermint;
import insumosPeppermint.testCasesFriendRequest;
import org.junit.jupiter.api.Test;
public class functionFriendRequest extends testCasesFriendRequest {
    @Test
    public void validationSendAcceptFriendRequest() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        validateSendFriendRequest();
    }
}
