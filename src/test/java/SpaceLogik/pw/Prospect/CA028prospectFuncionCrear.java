package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA028prospectFuncionCrear extends robotBaseSpaceLogik {

    @Test
    public void CA0281validacionCreacionProspect(){
        nameCompanyProspect ="pruebAutomatizada10-validacionCreacionProspect";
        assertions = "text=pruebAutomatizada10-validacionCreacionProspect";
        login();
        iniciarVariablesProspectFeliz();
        crearProspect();
        sqlGuardarCasoSiFallaCrearProspect();
        page.focus(".prospect-list-landlord-table");
        sqlGuardarCasoSiFallaCrearProspect();
        Assertions.assertTrue(page.isVisible(assertions));
    }

}
