package SpaceLogik.pw.Prospect;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void validacionArchivarProspect(){
        nameCompanyProspect = "pruebAutomatizada14-validacionArchivarProspect";
        iniciarVariablesProspectFeliz();
        login();
        crearProspect();
        archivarProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
        page.focus(".prospect-list-landlord-table");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada14-validacionArchivarProspect"));
    }
}
