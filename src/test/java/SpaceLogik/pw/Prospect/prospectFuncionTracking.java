package SpaceLogik.pw.Prospect;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionTracking extends robotBaseSpaceLogik {
    @Test
    public void validacionCrearTracking(){
        iniciarVariablesTrackingFeliz();
        iniciarVariablesProspectFeliz();
        subjectTrackingProspect = "pruebAutomatizada18-validacionCrearTracking";
        nameCompanyProspect = "pruebAutomatizada18-validacionCrearTracking";
        login();
        crearProspect();
        crearTrackingProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada18-validacionCrearTracking"));
    }
}
