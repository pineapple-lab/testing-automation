package SpaceLogik.pw.Program;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA017programFuncionDelete extends robotBaseSpaceLogik {

    @Test
    public void CA0171validacionDeleteProgram(){
        iniciarVariablesAutoProgramFeliz();
        Keyboard kb = page.keyboard();
        nameCase = nameRoomAutoProgram+"23-validacionDeleteProgram";
        assertions="text="+nameCase;
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible(assertions));
        page.focus(".my-programs-header input");
        kb.insertText(nameCase);
        archivarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible(assertions));
        borrarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible(assertions));
    }
}
