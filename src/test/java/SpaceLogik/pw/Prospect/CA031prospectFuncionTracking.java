package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA031prospectFuncionTracking extends robotBaseSpaceLogik {
    @Test
    public void CA0311validacionCrearTracking(){
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
