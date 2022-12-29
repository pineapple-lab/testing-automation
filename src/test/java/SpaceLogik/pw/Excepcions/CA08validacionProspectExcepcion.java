package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA08validacionProspectExcepcion extends robotBaseSpaceLogik {
    @Test
    public void CA081validacionCompanyNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA081 se va a ejecutar"+ejecutar+"veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectCompanyNamevacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Prospect name is required"));
            System.out.println("El caso CA081 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA082validacionEmailVacioExepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="PruebAutomatizada36-validacionEmailVacioExcepcion";
        System.out.println("El caso CA082 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectEmailVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact email is required"));
            System.out.println("El caso CA082 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA083validacionEmailFormatoIncorrectoExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="PruebAutomatizada37-validacionFormatoIncorrectoExcepcion";
        emailProspect="pruebaExcepcion";
        System.out.println("El caso CA083 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectFormatoEmailIncorrecto();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid email address"));
            System.out.println("El caso CA083 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA084validacionFirstNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada38-validacionFirstnameVacioExcepcion";
        System.out.println("El caso CA084 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectFirstNameVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact first name is required"));
            System.out.println("El caso CA084 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA085validacionLastNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada39-validacionLastNameVacioExcepcion";
        System.out.println("El caso CA085 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectLastNameVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact last name is required"));
            System.out.println("El caso CA085 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA086validacionCityVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada40-validacionCityVacioExcpecion";
        System.out.println("El caso CA086 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectCityVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid city"));
            System.out.println("El caso CA086 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA087validacionZipCodeVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada41-validacionZipCodeVacioExcepcion";
        System.out.println("El caso CA087 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectZipCodeVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
            System.out.println("El caso CA087 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA088validacionIndustryVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        nameCompanyProspect="pruebAutomatizada42-validacionIndustryVacioExcepcion";
        System.out.println("El caso CA088 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            excepcionProspectIndustryVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Industry not exists"));
            System.out.println("El caso CA088 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA089validacionCompetitiveSetBuildingVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        nameCompanyProspect="pruebAutomatizada43-validacionCompetitiveSetBuildingVacioExcepcion";
        notesCompetitiveSetProspect="pruebAutomatizada43-validacionCompetitiveSetBuildingVacioExcepcion";
        System.out.println("El caso CA089 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectCompetitiveSetBuildingVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Building can't be empty"));
            System.out.println("El caso CA089 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0810validacionTrackingSubjectVacio(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        nameCompanyProspect="pruebAutomatizad44-validacionTrackingSubjectVacio";
        System.out.println("El caso CA0810 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectTrackingSubjectVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Tracking subject is required"));
            System.out.println("El caso CA0810 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0811validacionTrackingDateSubjectVacio(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        nameCompanyProspect="pruebAutomatizada45-validacionTrackingDateSubjectVacio";
        subjectTrackingProspect="pruebAutomatizada45-validacionTrackingDateSubjectVacio";
        System.out.println("El caso CA0811 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectDateSubjectVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Tracking date is required"));
            System.out.println("El caso CA0811 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0812validacionEditBrokerFirstNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada46-validacionEditBrokerFirstNameVacioExcepcion";
        System.out.println("El caso CA0812 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectFirstNameVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=First name is required"));
            System.out.println("El caso CA0812 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0813validacionEditBrokerLastNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada47-validacionEditBrokerLastNameVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada47-validacionEditBrokerLastNameVacioExcepcion";
        System.out.println("El caso CA0813 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectLastNameVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Last name is required"));
            System.out.println("El caso CA0813 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0814validacionEditBrokerEmailVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada48-validacionEditBrokerLastNameVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada48-validacionEditBrokerLastNameVacioExcepcion";
        System.out.println("El caso CA0814 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectEmailVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Email is required"));
            System.out.println("El caso CA0814 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0815validacionEditBrokerEmailFormatoIncorrectoExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada49-validacionEditBrokerEmailFormatoIncorrectoExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada49-validacionEditBrokerEmailFormatoIncorrectoExcepcion";
        emailEditBrokerManual="pruebExcepcion";
        System.out.println("El caso CA0815 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectEmailFormatoIncorrectoEditBrokerInfo();
             page.focus("#root");
             Assertions.assertTrue(page.isVisible("text=Invalid email address"));
            System.out.println("El caso CA0815 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0816validacionEditBrokerCityVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada50-validacionEditBrokerCityVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada50-validacionEditBrokerCityVacioExcepcion";
        System.out.println("El caso CA0816 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectCityVacionEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid city"));
            System.out.println("El caso CA0816 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0817validacionEditBrokerZipCodeVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        nameCompanyProspect="pruebAutomatizada51-validacionEditBrokerZipCodeVacioExcepcion";
        firstNameEditBrokerManual="pruebAutomatizada51-validacionEditBrokerZipCodeVacioExcepcion";
        System.out.println("El caso CA0817 se va a ejecutar "+ejecutar+" veces");
        for (contador=1;contador<=ejecutar;contador++) {
            login();
            crearProspect();
            excepcionProspectZipCodeVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
            System.out.println("El caso CA0817 se ejecuto "+contador+" veces");
        }
    }
}
