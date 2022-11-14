package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class programFuncionDelete extends robotBaseSpaceLogik {

    @Test
    public void validacionDeleteProgram(){
        nameProgram = "pruebAutomatizada23-validacionDeleteProgram";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));
        borrarPrograma();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada23-validacionDeleteProgram"));

    }
}
