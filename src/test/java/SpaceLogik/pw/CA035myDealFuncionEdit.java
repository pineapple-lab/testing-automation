package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA035myDealFuncionEdit extends robotBaseSpaceLogik {

    @Test
    public void CA0351validacionEditLeaseTypeLocation(){
        iniciarVariablesEditMyDealLeaseTypeLocation();
        login();
        editarMyDealLeaseTypeLocation();
        page.focus("#root");
        assertions="text=Changes saved successfully";
        sqlGuardarCasoSiFallaEditarMyDealLeaseTypeLocation();
        Assertions.assertTrue(page.isVisible(assertions));
        Assertions.assertTrue(page.getByLabel("NEW").isChecked());
        Assertions.assertTrue(page.getByLabel("Within 3 mile radius").isChecked());
        Assertions.assertTrue(page.getByLabel("Another address").isChecked());
    }
    @Test
    public void CA0352validacionEditOfficeSize(){
        iniciarVariablesEditMyDealOfficeSize();
        login();
        editarMyDealOfficeSize();
        page.focus("#root");
        assertions = "text=Changes saved successfully";
        sqlGuardarCasoSiFallaEditarMyDealOfficeSize();
        Assertions.assertTrue(page.isVisible(assertions));
        Assertions.assertTrue(page.getByLabel("REPLACE").isChecked());
    }
    @Test
    public void CA0353validacionEditOccupancyAndSchedule(){
        login();
        editarMyDealOccupancyAndSchedule();
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
