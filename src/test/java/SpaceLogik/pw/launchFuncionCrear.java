package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import com.microsoft.playwright.Keyboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class launchFuncionCrear extends robotBaseSpaceLogik {

    @Test
    public void validacionCrearLaunch(){
        iniciarVariablesLaunchFeliz();
        login();
        crearLaunch();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
