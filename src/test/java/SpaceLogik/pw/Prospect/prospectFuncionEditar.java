package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prospectFuncionEditar extends robotBaseSpaceLogik {
    @Test
    public void validacionEditProspectGeneralInfo(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        nameCompanyProspect="pruebAutomatizada20-validacionEditProspectGeneralInfo";
        nameCompanyEditProspectGeneralInfo="editcompany-pruebAutomatizada20-validacionEditProspectGeneralInfo";
        firstNameEditProspectGeneralInfo = "editfirstName-pruebAutomatizada20-validacionEditProspectGeneralInfo";
        login();
        crearProspect();
        editarPorspectGeneralInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=editcompany-pruebAutomatizada20-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=editfirstName-pruebAutomatizada20-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=Public"));
    }
    @Test
    public void validacionEdicionManualInfoBrokerage(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "prueabAutomatizada19-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebAutomatizada19-validacionEdicionManualInfoBrokerage";
        login();
        crearProspect();
        editarManualmenteInfoBrokerage();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada19-validacionEdicionManualInfoBrokerage"));
    }
    @Test
    public void validacionEdicionCompleta(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "pruebAutomatizada21-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebAutomatizada21-validacionEdicionManualInfoBrokerage";
        nameCompanyEditProspectGeneralInfo="editcompany-pruebAutomatizada21-validacionEditProspectGeneralInfo";
        firstNameEditProspectGeneralInfo = "editfirstName-pruebAutomatizada21-validacionEditProspectGeneralInfo";
        login();
        crearProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada21-validacionEdicionManualInfoBrokerage"));
        editarPorspectGeneralInfo();
        page.click("text=MY LOGIK");
        page.click("text=Prospects");
        editarManualmenteInfoBrokerage();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada21-validacionEdicionManualInfoBrokerage"));
        Assertions.assertTrue(page.isVisible("text=editcompany-pruebAutomatizada21-validacionEditProspectGeneralInfo"));
        Assertions.assertTrue(page.isVisible("text=editfirstName-pruebAutomatizada21-validacionEditProspectGeneralInfo"));
    }
}
