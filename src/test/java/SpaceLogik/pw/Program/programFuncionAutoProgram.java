package SpaceLogik.pw.Program;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void validacionCrearAutoProgram(){
        nameAutoProgram="PruebAutomatizada32-validacionCrearAutoProgram";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        assertTrue(page.isVisible("text=Changes saved successfully"));
        page.focus("#root");
        assertTrue(page.isVisible("text=PruebAutomatizada32-validacionCrearAutoProgram"));
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(5)");
        page.click("text=Programs");
        page.focus("#root");
        assertTrue(page.isVisible("text=PruebAutomatizada32-validacionCrearAutoProgram"));
    }
}
