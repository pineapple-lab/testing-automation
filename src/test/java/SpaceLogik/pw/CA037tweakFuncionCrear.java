package SpaceLogik.pw;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA037tweakFuncionCrear extends robotBaseSpaceLogik {
    @Test
    public void CA0371validacionCrearTweak(){
        Keyboard kb = page.keyboard();
        iniciarVariablesTweakFeliz();
        iniciarVariablesEditRoom();
        nameProgram="pruebAutomatizada37-validacionCrearTw";
        selectProgramTweak="pruebAutomatizada37-validacionCrearTw";
        programNameTweak="pruebAutomatizada37-validacionCrearTw";
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
    }
}
