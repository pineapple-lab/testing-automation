package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA08validacionProspectExcepcion extends robotBaseSpaceLogik {
    @Test
    public void CA081validacionCompanyNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA081 se va a execute"+execute+"veces");
        for (counter=1;counter<=execute;counter++) {
            login();
            excepcionProspectCompanyNamevacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Prospect name is required"));
            System.out.println("El caso CA081 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA082validacionEmailVacioExepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA082 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".36-validacionEmailVacioExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectEmailVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact email is required"));
            System.out.println("El caso CA082 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA083validacionEmailFormatoIncorrectoExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        emailProspect="pruebaExcepcion";
        System.out.println("El caso CA083 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".37-validacionFormatoIncorrectoExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectFormatoEmailIncorrecto();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid email address"));
            System.out.println("El caso CA083 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA084validacionFirstNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA084 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".38-validacionFirstnameVacioExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectFirstNameVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact first name is required"));
            System.out.println("El caso CA084 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA085validacionLastNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA085 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".39-validacionLastNameVacioExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectLastNameVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Contact last name is required"));
            System.out.println("El caso CA085 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA086validacionCityVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA086 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".40-validacionCityVacioExcpecion.executionDetails:"+counter;
            login();
            excepcionProspectCityVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid city"));
            System.out.println("El caso CA086 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA087validacionZipCodeVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA087 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".41-validacionZipCodeVacioExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectZipCodeVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
            System.out.println("El caso CA087 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA088validacionIndustryVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA088 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".42-validacionIndustryVacioExcepcion.executionDetails:"+counter;
            login();
            excepcionProspectIndustryVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Industry not exists"));
            System.out.println("El caso CA088 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA089validacionCompetitiveSetBuildingVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        System.out.println("El caso CA089 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".43-validacionCompetitiveSetBuildingVacioExcepcion.executionDetails:"+counter;
            notesCompetitiveSetProspect=nameCase;
            login();
            crearProspect();
            excepcionProspectCompetitiveSetBuildingVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Building can't be empty"));
            System.out.println("El caso CA089 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0810validacionTrackingSubjectVacio(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        System.out.println("El caso CA0810 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".44-validacionTrackingSubjectVacio.executionDetails:"+counter;
            login();
            crearProspect();
            excepcionProspectTrackingSubjectVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Tracking subject is required"));
            System.out.println("El caso CA0810 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0811validacionTrackingDateSubjectVacio(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesTrackingFeliz();
        nameCompanyProspect="pruebAutomatizada";
        subjectTrackingProspect="pruebAutomatizada45-validacionTrackingDateSubjectVacio";
        System.out.println("El caso CA0811 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".45-validacionTrackingDateSubjectVacio.executionDetails:"+counter;
            subjectTrackingProspect=nameCase;
            login();
            crearProspect();
            excepcionProspectDateSubjectVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Tracking date is required"));
            System.out.println("El caso CA0811 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0812validacionEditBrokerFirstNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0812 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".46-validacionEditBrokerFirstNameVacioExcepcion.executionDetails:"+counter;
            login();
            crearProspect();
            excepcionProspectFirstNameVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=First name is required"));
            System.out.println("El caso CA0812 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0813validacionEditBrokerLastNameVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0813 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".47-validacionEditBrokerLastNameVacioExcepcion.executionDetails:"+counter;
            firstNameEditBrokerManual=nameCase;
            login();
            crearProspect();
            excepcionProspectLastNameVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Last name is required"));
            System.out.println("El caso CA0813 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0814validacionEditBrokerEmailVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0814 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".48-validacionEditBrokerLastNameVacioExcepcion.executionDetails:"+counter;
            firstNameEditBrokerManual=nameCase;
            login();
            crearProspect();
            excepcionProspectEmailVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Email is required"));
            System.out.println("El caso CA0814 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0815validacionEditBrokerEmailFormatoIncorrectoExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0815 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".49-validacionEditBrokerEmailFormatoIncorrectoExcepcion.executionDetails:"+counter;
            firstNameEditBrokerManual=nameCase;
            login();
            crearProspect();
            emailEditBrokerManual="emailconformatoincorrecto";
            excepcionProspectEmailFormatoIncorrectoEditBrokerInfo();
             page.focus("#root");
             Assertions.assertTrue(page.isVisible("text=Invalid email address"));
            System.out.println("El caso CA0815 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0816validacionEditBrokerCityVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0816 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".50-validacionEditBrokerCityVacioExcepcion.executionDetails:"+counter;
            firstNameEditBrokerManual=nameCase;
            login();
            crearProspect();
            excepcionProspectCityVacionEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid city"));
            System.out.println("El caso CA0816 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0817validacionEditBrokerZipCodeVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        iniciarVariablesEditManualBrokerFeliz();
        System.out.println("El caso CA0817 se va a execute "+execute+" veces");
        for (counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".51-validacionEditBrokerZipCodeVacioExcepcion.executionDetails:"+counter;
            firstNameEditBrokerManual=nameCase;
            login();
            crearProspect();
            excepcionProspectZipCodeVacioEditBrokerInfo();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Invalid zipcode"));
            System.out.println("El caso CA0817 se ejecuto "+counter+" veces");
        }
    }
}
