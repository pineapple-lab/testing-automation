package SpaceLogik.pw.Program;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.Key;

public class programFuncionCreateNew extends robotBaseSpaceLogik {
    @Test
    public void validacionCreateNewProgram(){
     nameProgram="pruebAutomatizada22-validacionCreateNewProgram";
     login();
     crearPrograma();
     page.focus("#root");
     Assertions.assertTrue(page.isVisible("text=pruebAutomatizada22-validacionCreateNewProgram"));
    }
}
