package SpaceLogik.pw.Prospect;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionTracking extends robotBaseSpaceLogik {
    @Test
    public void validacionCrearTracking(){
        iniciarVariablesTrackingFeliz();
        iniciarVariablesProspectFeliz();
        subjectTrackingProspect = "pruebaaAutomatizada18-validacionCrearTracking";
        nameCompanyProspect = "pruebaaAutomatizada18-validacionCrearTracking";
        login();
        crearProspect();
        crearTrackingProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebaaAutomatizada18-validacionCrearTracking"));
    }
}
