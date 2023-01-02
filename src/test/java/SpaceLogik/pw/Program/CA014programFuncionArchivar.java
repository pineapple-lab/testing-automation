package SpaceLogik.pw.Program;

import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA014programFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0141validacionArchivarProgram(){
        iniciarVariablesAutoProgramFeliz();
        Keyboard kb = page.keyboard();
        nameCase=nameRoomAutoProgram+"104-validacionArchivarProgram";
        assertions="text="+nameCase;
        login();
        crearPrograma();
        page.focus(".my-programs-header input");
        kb.insertText(assertions);
        archivarPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertFalse(page.isVisible(assertions));
        page.click(".my-programs-header button:nth-of-type(2)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible(assertions));
    }
}
