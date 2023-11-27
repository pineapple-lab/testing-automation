package Peppermint;
import insumosPeppermint.testCasesLesson;
import org.junit.jupiter.api.Test;
public class functionLessonManagment extends testCasesLesson {
    @Test
    public void validationCreateLesson() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionLesson();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validateCreateLesson();
    }
}