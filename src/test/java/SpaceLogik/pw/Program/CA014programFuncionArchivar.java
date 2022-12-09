package SpaceLogik.pw.Program;

import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA014programFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0141validacionArchivarProgram(){
        Keyboard kb = page.keyboard();
        nameProgram="pruebAutomatizada104-validacionArchivarProgram";
        login();
        crearPrograma();
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada104-validacionArchivarProgram");
        archivarPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada104-validacionArchivarProgram"));
        page.click(".my-programs-header button:nth-of-type(2)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada104-validacionArchivarProgram"));
    }
}
