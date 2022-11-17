package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import com.microsoft.playwright.Keyboard;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TweakFuncionCrear extends robotBaseSpaceLogik {
    @Test
    public void validacionCrearTweak(){
        iniciarVariablesTweakFeliz();
        iniciarVariablesAutoProgramFeliz();
        nameProgram="pruebAutomatizada37-validacionCrearTweak";
        selectProgramTweak="pruebAutomatizada30-validacionEditarAlacarteOptions";
        programNameTweak="pruebAutomatizada37-validacionCrearTweak";
        login();
        crearPrograma();
        crearTweak();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
