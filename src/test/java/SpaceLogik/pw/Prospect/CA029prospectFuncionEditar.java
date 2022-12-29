package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA029prospectFuncionEditar extends robotBaseSpaceLogik {
    @Test
    public void CA0291validacionEditProspectGeneralInfo(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        nameCompanyProspect="pruebAutomatizada20-validacionEditProspectGeneralInfo";
        nameCompanyEditProspectGeneralInfo="editcompany-pruebAutomatizada20-validacionEditProspectGeneralInfo";
        System.out.println("El caso CA0291 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            login();
            crearProspect();
            editarPorspectGeneralInfo();
            page.focus("#root");
            assertions="text="+nameCompanyEditProspectGeneralInfo;
            sqlGuardarCasoSiFallaEditarGeneralInfoProspect();
            Assertions.assertTrue(page.isVisible(assertions));
            assertions="text="+firstNameEditProspectGeneralInfo;
            sqlGuardarCasoSiFallaEditarGeneralInfoProspect();
            Assertions.assertTrue(page.isVisible(assertions));
            Assertions.assertTrue(page.isVisible("text=Public"));
            System.out.println("El caso CA0291 se ejecuto: "+contador+" veces");
        }
    }
    @Test
    public void CA0292validacionEdicionManualInfoBrokerage(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "prueabAutomatizada19-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebAutomatizada19-validacionEdicionManualInfoBrokerage";
        assertions = "text=pruebAutomatizada19-validacionEdicionManualInfoBrokerage";
        System.out.println("El caso CA0292 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            login();
            crearProspect();
            editarManualmenteInfoBrokerage();
            page.focus("#root");
            sqlGuardarCasoSiFallaEditarBrokerManual();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0292 se ejecuto: "+contador+" veces");
        }
    }
    @Test
    public void CA0293validacionEdicionCompleta(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect = "pruebAutomatizada21-validacionEdicionManualInfoBrokerage";
        firstNameEditBrokerManual = "pruebAutomatizada21-validacionEdicionManualInfoBrokerage";
        nameCompanyEditProspectGeneralInfo="editcompany-pruebAutomatizada21-validacionEditProspectGeneralInfo";
        firstNameEditProspectGeneralInfo = "editfirstName-pruebAutomatizada21-validacionEditProspectGeneralInfo";
        System.out.println("El caso CA0293 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
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
            System.out.println("El caso CA0293 se ejecuto: "+contador+" veces");
        }
    }
}
