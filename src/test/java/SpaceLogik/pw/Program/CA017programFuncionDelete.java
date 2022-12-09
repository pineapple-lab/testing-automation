package SpaceLogik.pw.Program;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA017programFuncionDelete extends robotBaseSpaceLogik {

    @Test
    public void CA0171validacionDeleteProgram(){
        Keyboard kb = page.keyboard();
        nameProgram = "pruebAutomatizada23-validacionDeleteProgram";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada23-validacionDeleteProgram");
        archivarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
        borrarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
    }
}
