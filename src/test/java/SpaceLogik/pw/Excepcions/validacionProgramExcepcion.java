package SpaceLogik.pw.Excepcions;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validacionProgramExcepcion extends robotBaseSpaceLogik {

    @Test
    public void validacionNombreVacioProgramExcepcion(){
        login();
        excepcionProgramNombreVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program name can't be empty"));
    }
    @Test
    public void validacionNombreVacioAutoProgramExcepcion(){
        iniciarVariablesAutoProgramFeliz();
        nameRoomAutoProgram="pruebAutomatizada34-validacionNombreVacioAutoProgramExcepcion";
        login();
        excepcionAutoProgramNombreVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program name is required"));
    }
    @Test
    public void validacionLevelVacioExcepcion(){
        iniciarVariablesAutoProgramFeliz();
        nameAutoProgram = "pruebAutomatizada35-validacionLevelVacioExcepcion";
        nameRoomAutoProgram = "pruebAutomatizada35-validacionLevelVacioExcepcion";
        login();
        excepcionProgramLevelVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Construction and furniture levels are required"));
    }
    @Test
    public void validacionRoomNameVacionExcepcion(){
        iniciarVariablesAutoProgramFeliz();
        nameAutoProgram = "pruebAutomatizada36-validacionRoomNameVacionExcepcion";
        login();
        excepcionProgramRoomNameVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Please select a name for the room"));
    }
    @Test
    public void validacionAreaListVacioExcepcion(){
        iniciarVariablesAutoProgramFeliz();
        nameAutoProgram="pruebAutomatizada37-validacionAreaListVacioExcepcion";
        nameRoomAutoProgram="pruebAutomatizada37-validacionAreaListVacioExcepcion";
        login();
        excepcionProgramAreaListVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Add at least one employee area"));
    }
}
