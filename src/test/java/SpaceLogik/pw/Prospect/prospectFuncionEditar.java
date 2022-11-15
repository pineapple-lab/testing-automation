package SpaceLogik.pw.Prospect;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionEditar extends robotBaseSpaceLogik {
    @Test
    public void validacionEditProspectGeneralInfo(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        nameCompanyProspect="pruebAutomatizada20-validacionEditProspectGeneralInfo";
        nameCompanyEditProspectGeneralInfo="editcompany-PruebAutomatizada20-validacionEditProspectGeneralInfo";
        firstNameEditProspectGeneralInfo = "editfirstName-PruebAutomatizada20-validacionEditProspectGeneralInfo";
        login();
        crearProspect();
        editarPorspectGeneralInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=editcompany-PruebAutomatizada20-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=editfirstName-PruebAutomatizada20-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=Public"));
    }
    @Test
    public void validacionEdicionManualInfoBrokerage(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "prueabAutomatizada19-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebaAutomatizada19-validacionEdicionManualInfoBrokerage";
        login();
        crearProspect();
        editarManualmenteInfoBrokerage();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebaAutomatizada19-validacionEdicionManualInfoBrokerage"));
    }
    @Test
    public void validacionEdicionCompleta(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "pruebaAutomatizada21-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebaAutomatizada21-validacionEdicionManualInfoBrokerage";
        nameCompanyEditProspectGeneralInfo="editcompany-PruebaAutomatizada21-validacionEditProspectGeneralInfo";
        firstNameEditProspectGeneralInfo = "editfirstName-PruebaAutomatizada21-validacionEditProspectGeneralInfo";
        login();
        crearProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebaAutomatizada21-validacionEdicionManualInfoBrokerage"));
        editarPorspectGeneralInfo();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        editarManualmenteInfoBrokerage();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebaAutomatizada21-validacionEdicionManualInfoBrokerage"));
        Assertions.assertTrue(page.isVisible("text=editcompany-PruebaAutomatizada21-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=editfirstName-PruebaAutomatizada21-validacionEditProspectGeneralInfo"));
    }
}
