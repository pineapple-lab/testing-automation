package Peppermint;
import insumosPeppermint.testCasesArticles;
import org.junit.jupiter.api.Test;
public class functionArticleManagment extends testCasesArticles {
    @Test
    public void validationCreateArticle() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateArticle();
    }
}
