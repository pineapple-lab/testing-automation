package SpaceLogik.pw.Program;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA014programFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0141validacionArchivarProgram(){
        nameProgram="pruebAutomatizada104-validacionArchivarProgram";
        login();
        crearPrograma();
        archivarPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada104-validacionArchivarProgram"));
        page.click(".my-programs-header button:nth-of-type(2)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada104-validacionArchivarProgram"));
    }
}
