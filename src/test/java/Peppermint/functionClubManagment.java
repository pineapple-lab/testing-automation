package Peppermint;
import insumosPeppermint.testCasesClubManagment;
import org.junit.jupiter.api.Test;
public class functionClubManagment extends testCasesClubManagment {
    @Test
    public void validationCreateClub() {
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionClub();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validarCrearClub();
    }
    public void validationJoinClub(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionClub();
        printNumberExecutions();
        startNavigation();
        validarJoinClub();
    }
    public void validationPostClub(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionClub();
        printNumberExecutions();
        startNavigation();
        startVariablesLogin();
        login();
        validarPostClub();
    }
        public void validationMultipleClubJoin(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        validacionUnirseMuchosClubs();
    }
}