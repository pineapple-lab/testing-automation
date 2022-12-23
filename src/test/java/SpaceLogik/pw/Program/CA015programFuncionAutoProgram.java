package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CA015programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void CA0151validacionCrearAutoProgram(){
        nameAutoProgram="pruebAutomatizada32-validacionCrearAutoProgr";
        assertions1 = "text=Changes saved successfully";
        assertions = "text=PruebAutomatizada32-validacionCrearAutoProgr";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        sqlGuardarCasoSiFallaCartelDeCrearAutoProgram();
        assertTrue(page.isVisible(assertions1));
        page.focus("#root");
        sqlGuardarCasoSiFallaCrearAutoProgram();
        assertTrue(page.isVisible(assertions));
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.focus("#root");
        sqlGuardarCasoSiFallaCrearAutoProgram();
        assertTrue(page.isVisible(assertions));
    }
}
