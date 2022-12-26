package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CA015programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void CA0151validacionCrearAutoProgram(){
        nameAutoProgram="pruebAutomatizada32-validacionCrearAutoProgr";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        assertions = "text=Changes saved successfully";
        sqlGuardarCasoSiFallaCrearAutoProgram();
        assertTrue(page.isVisible(assertions));
        page.focus("#root");
        assertions = "text=PruebAutomatizada32-validacionCrearAutoProgr";
        sqlGuardarCasoSiFallaCrearAutoProgram();
        assertTrue(page.isVisible(assertions));
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.focus("#root");
        sqlGuardarCasoSiFallaCrearAutoProgram();
        assertTrue(page.isVisible(assertions));
    }
}
