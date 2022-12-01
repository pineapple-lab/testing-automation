package testEnConstruccionSpaceLogik;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class programFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void validacionProgramFuncionActivar(){
        nameProgram="pruebAutomatizada105-validacionProgramFuncionActivar";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada105-validacionProgramFuncionActivar"));
        archivarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada105-validacionProgramFuncionActivar"));
        page.click(".my-programs-header button:nth-of-type(2)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada105-validacionProgramFuncionActivar"));
        activarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada105-validacionProgramFuncionActivar"));
        page.click(".my-programs-header div:nth-of-type(1) button:nth-of-type(1)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada105-validacionProgramFuncionActivar"));
    }

    public void activarPrograma(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(5)");
        page.click("text=Programs");
        page.click(".my-programs-header button:nth-of-type(2)");
        page.click(".program-list-table-container tbody tr:last-child div:last-child button:nth-of-type(1)");
    }
}
