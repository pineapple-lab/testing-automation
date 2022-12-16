package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CA015programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void CA0151validacionCrearAutoProgram(){
        nameAutoProgram="pruebAutomatizada32-validacionCrearAutoProgram";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        assertTrue(page.isVisible("text=Changes saved successfully"));
        page.focus("#root");
        assertTrue(page.isVisible("text=PruebAutomatizada32-validacionCrearAutoProgram"));
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
        page.click("text=Programs");
        page.focus("#root");
        assertTrue(page.isVisible("text=pruebAutomatizada32-validacionCrearAutoProgram"));
    }
}
