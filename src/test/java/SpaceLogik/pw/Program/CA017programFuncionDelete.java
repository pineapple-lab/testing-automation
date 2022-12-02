package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA017programFuncionDelete extends robotBaseSpaceLogik {

    @Test
    public void CA0171validacionDeleteProgram(){
        nameProgram = "pruebAutomatizada23-validacionDeleteProgram";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
        archivarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
        borrarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
    }
}
