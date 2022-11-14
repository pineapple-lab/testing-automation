package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void validacionActivarProspect(){
        nameCompanyProspect = "pruebAutomatizada16-validacionActivarProspect";
        iniciarVariablesProspectFeliz();
        login();
        crearProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
        archivarProspect();
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
        page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
        activarProspect();
        page.click(".prospect-list-landlord-button-container button:nth-of-type(1)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
    }

}
