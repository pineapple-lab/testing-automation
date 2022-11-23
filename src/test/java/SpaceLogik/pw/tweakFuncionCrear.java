package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class tweakFuncionCrear extends robotBaseSpaceLogik {
    @Test
    public void validacionCrearTweak(){
        iniciarVariablesTweakFeliz();
        iniciarVariablesAutoProgramFeliz();
        iniciarVariablesEditRoom();
        nameProgram="pruebAutomatizada37-validacionCrearTweak";
        selectProgramTweak="pruebAutomatizada37-validacionCrearTweak";
        programNameTweak="pruebAutomatizada37-validacionCrearTweak";
        login();
        crearPrograma();
        crearRoom();
        editarRoomOptions();
        crearTweak();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
