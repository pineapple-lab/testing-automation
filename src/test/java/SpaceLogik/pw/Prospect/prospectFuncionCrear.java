package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionCrear extends robotBaseSpaceLogik {

    @Test
    public void validacionCreacionProspect(){
        nameCompanyProspect ="pruebAutomatizada10-validacionCreacionProspect";
        login();
        iniciarVariablesProspectFeliz();
        crearProspect();
        page.focus(".prospect-list-landlord-table");
        Assertions.assertTrue(page.isVisible( "text=pruebAutomatizada10-validacionCreacionProspect"));
    }

}
