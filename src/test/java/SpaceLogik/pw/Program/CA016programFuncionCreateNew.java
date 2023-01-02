package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA016programFuncionCreateNew extends robotBaseSpaceLogik {
    @Test
    public void CA0161validacionCreateNewProgram(){
     nameProgram=nameRoomAutoProgram+"22-validacionCreateNewProgram";
     login();
     crearPrograma();
     page.focus("#root");
     Assertions.assertTrue(page.isVisible("text=pruebAutomatizada22-validacionCreateNewProgram"));
    }
}
