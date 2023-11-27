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
        System.out.println("El caso CA0291 se va a execute: "+execute+" veces");
        for (counter=1; counter <= execute; counter++){
            nameCase=nameCompanyProspect+".20-validacionEditProspectGeneralInfo.Ejecuciones:"+counter;
            nameCompanyEditProspectGeneralInfo=nameCase+"edit";
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
            System.out.println("El caso CA0291 se ejecuto: "+counter+" veces");
        }
    }
    @Test
    public void CA0292validacionEdicionManualInfoBrokerage(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0292 se va a execute: "+execute+" veces");
        for (counter=1; counter <= execute; counter++){
            nameCase=nameCompanyProspect+".19-validacionEdicionManualInfoBrokerage.Ejecuciones:"+counter;
            firstNameEditBrokerManual=nameCase+"edit";
            assertions="text="+firstNameEditBrokerManual;
            login();
            crearProspect();
            editarManualmenteInfoBrokerage();
            page.focus("#root");
            sqlGuardarCasoSiFallaEditarBrokerManual();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0292 se ejecuto: "+counter+" veces");
        }
    }
    @Test
    public void CA0293validacionEdicionCompleta(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditGeneralInfoProspect();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0293 se va a execute: "+execute+" veces");
        for (counter=1; counter <= execute; counter++){
            nameCase=nameCompanyProspect+".21-validacionEdicionManualInfoBrokerage.Ejecuciones:"+counter;
            firstNameEditBrokerManual=nameCase+".firstnameedit";
            nameCompanyEditProspectGeneralInfo=nameCase+".namecompanyEdit";
            firstNameEditProspectGeneralInfo=nameCase+".firstNameGeneralInfoEdit";
            login();
            crearProspect();
            page.focus("#root");
            assertions="text="+nameCase;
            Assertions.assertTrue(page.isVisible(assertions));
            editarPorspectGeneralInfo();
            page.click("text=MY LOGIK");
            page.click("text=Prospects");
            editarManualmenteInfoBrokerage();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible(assertions));
            assertions="text="+nameCompanyEditProspectGeneralInfo;
            Assertions.assertTrue(page.isVisible(assertions));
            assertions="text="+firstNameEditProspectGeneralInfo;
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0293 se ejecuto: "+counter+" veces");
        }
    }
}
