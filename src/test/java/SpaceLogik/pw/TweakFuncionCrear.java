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
        selectProgramTweak="pruebAutomatizada30-validacionEditarAlacarteOptions";
        programNameTweak="pruebAutomatizada31-validacionCrearTweak";
        login();
        crearTweak();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
