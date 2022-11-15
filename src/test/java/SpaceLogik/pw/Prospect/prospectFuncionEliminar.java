package SpaceLogik.pw.Prospect;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionEliminar extends robotBaseSpaceLogik {

    @Test
    public void validacionEliminarProspect(){
        nameCompanyProspect = "pruebAutomatizada15-validacionEliminarProspect";
        iniciarVariablesProspectFeliz();
        login();
        crearProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada15-validacionEliminarProspect"));
        eliminarProspect();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada15-validacionEliminarProspect"));
    }

}
