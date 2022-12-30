package SpaceLogik.pw;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA037tweakFuncionCrear extends robotBaseSpaceLogik {
    @Test
    public void CA0371validacionCrearTweak(){
        System.out.println("Iniciando caso de prueba...");
        Keyboard kb = page.keyboard();
        iniciarVariablesTweakFeliz();
        iniciarVariablesEditRoom();
        nameProgram="pruebAutomatizada37-validacionCrearTw";
        selectProgramTweak="pruebAutomatizada37-validacionCrearTw";
        programNameTweak="pruebAutomatizada37-validacionCrearTw";
        System.out.println("El caso CA0371 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            crearPrograma();
            page.focus(".my-programs-header input");
            kb.insertText(programNameTweak);
            crearRoom();
            editarRoomOptions();
            crearTweak();
            page.focus("#root");
            assertions = "text=Changes saved successfully";//
            sqlGuardarCasoSiFallaCrearTweak();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0371 se ejecuto "+contador+" veces");
        }
    }
}
