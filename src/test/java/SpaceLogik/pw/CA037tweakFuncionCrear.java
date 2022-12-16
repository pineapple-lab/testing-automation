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
        iniciarVariablesAutoProgramFeliz();
        iniciarVariablesEditRoom();
        nameProgram="pruebAutomatizada37-validacionCrearTweak";
        selectProgramTweak="pruebAutomatizada37-validacionCrearTweak";
        programNameTweak="pruebAutomatizada37-validacionCrearTweak";
        login();
        crearPrograma();
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada37-validacionCrearTweak");
        crearRoom();
        editarRoomOptions();
        crearTweak();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
