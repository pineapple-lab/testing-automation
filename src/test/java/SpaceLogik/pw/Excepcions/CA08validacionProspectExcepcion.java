package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA08validacionProspectExcepcion extends robotBaseSpaceLogik {
    @Test
    public void CA081validacionCompanyNameVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        login();
        excepcionProspectCompanyNamevacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Prospect name is required"));
    }
    @Test
    public void CA082validacionEmailVacioExepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="PruebAutomatizada36-validacionEmailVacioExcepcion";
        login();
        excepcionProspectEmailVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Contact email is required"));
    }
    @Test
    public void CA083validacionEmailFormatoIncorrectoExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="PruebAutomatizada37-validacionFormatoIncorrectoExcepcion";
        emailProspect="pruebaExcepcion";
        login();
        excepcionProspectFormatoEmailIncorrecto();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Invalid email address"));
    }
    @Test
    public void CA084validacionFirstNameVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada38-validacionFirstnameVacioExcepcion";
        login();
        excepcionProspectFirstNameVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Contact first name is required"));
    }
    @Test
    public void CA085validacionLastNameVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada39-validacionLastNameVacioExcepcion";
        login();
        excepcionProspectLastNameVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Contact last name is required"));
    }
    @Test
    public void CA086validacionCityVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada40-validacionCityVacioExcpecion";
        login();
        excepcionProspectCityVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Invalid city"));
    }
    @Test
    public void CA087validacionZipCodeVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada41-validacionZipCodeVacioExcepcion";
        login();
        excepcionProspectZipCodeVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
    }
    @Test
    public void CA088validacionIndustryVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada42-validacionIndustryVacioExcepcion";
        login();
        excepcionProspectIndustryVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Industry not exists"));
    }
    @Test
    public void CA089validacionCompetitiveSetBuildingVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        nameCompanyProspect="pruebAutomatizada43-validacionCompetitiveSetBuildingVacioExcepcion";
        notesCompetitiveSetProspect="pruebAutomatizada43-validacionCompetitiveSetBuildingVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectCompetitiveSetBuildingVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Building can't be empty"));
    }
    @Test
    public void CA0810validacionTrackingSubjectVacio(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        nameCompanyProspect="pruebAutomatizad44-validacionTrackingSubjectVacio";
        login();
        crearProspect();
        excepcionProspectTrackingSubjectVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Tracking subject is required"));
    }
    @Test
    public void CA0811validacionTrackingDateSubjectVacio(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        nameCompanyProspect="pruebAutomatizada45-validacionTrackingDateSubjectVacio";
        subjectTrackingProspect="pruebAutomatizada45-validacionTrackingDateSubjectVacio";
        login();
        crearProspect();
        excepcionProspectDateSubjectVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Tracking date is required"));
    }
    @Test
    public void CA0812validacionEditBrokerFirstNameVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada46-validacionEditBrokerFirstNameVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectFirstNameVacioEditBrokerInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=First name is required"));
    }
    @Test
    public void CA0813validacionEditBrokerLastNameVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada47-validacionEditBrokerLastNameVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada47-validacionEditBrokerLastNameVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectLastNameVacioEditBrokerInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Last name is required"));
    }
    @Test
    public void CA0814validacionEditBrokerEmailVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada48-validacionEditBrokerLastNameVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada48-validacionEditBrokerLastNameVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectEmailVacioEditBrokerInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Email is required"));
    }
    @Test
    public void CA0815validacionEditBrokerEmailFormatoIncorrectoExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada49-validacionEditBrokerEmailFormatoIncorrectoExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada49-validacionEditBrokerEmailFormatoIncorrectoExcepcion";
        emailEditBrokerManual="pruebExcepcion";
        login();
        crearProspect();
        excepcionProspectEmailFormatoIncorrectoEditBrokerInfo();
         page.focus("#root");
         Assertions.assertTrue(page.isVisible("text=Invalid email address"));
    }
    @Test
    public void CA0816validacionEditBrokerCityVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada50-validacionEditBrokerCityVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada50-validacionEditBrokerCityVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectCityVacionEditBrokerInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Invalid city"));
    }
    @Test
    public void CA0817validacionEditBrokerZipCodeVacioExcepcion(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada51-validacionEditBrokerZipCodeVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada51-validacionEditBrokerZipCodeVacioExcepcion";
        login();
        crearProspect();
        excepcionProspectZipCodeVacioEditBrokerInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
    }
}
