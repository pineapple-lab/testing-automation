package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA012listingFuncionEditGeneralInfo extends robotBaseSpaceLogik {

     @Test
    public void CA0121validacionEditGeneralLocationInformation(){
         System.out.println("Iniciando caso de prueba...");
         iniciarVariablesEditarListingLocationInformation();
         System.out.println("El caso CA0121 se va ejecutar "+ejecutar+" veces");
         for(contador=1;contador<=ejecutar;contador++) {
             login();
             editarListiningGeneralLocationInformation();
             page.focus("#root");
             assertions = "text=Changes saved successfully";
             sqlGuardarCasoSiFallaEditarListingLocationInformation();
             Assertions.assertTrue(page.isVisible(assertions));
             System.out.println("El caso CA0121 se ejecuto "+contador+" veces");
         }
    }
    @Test
    public void CA0122validacionEditBuildingCertifications(){
        login();
        editarListingBuildingCertifications();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0123validacionEditBuildingDescription(){
        locationBuildingListing="pruebAutomatizada93";
        iniciarVariablesEditarBuildingDescrption();
        login();
        editarListingBuildingDescription();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0124validacionEditPrimaryLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada94";
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0124 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarListingPrimaryLeasingContact();
            assertions="text=asdfasfasdfdasf";//Changes saved successfully
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0124 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0125validacionEditListingSecondaryLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada95";
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0125 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarListingSecondaryLeasingContact();
            page.focus("#root");
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0125 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0126validacionEditBuildingOwner(){
        System.out.println("Iniciando caso de prueba...");
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada96";
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0126 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarListingBuildingOwner();
            page.focus("#root");
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0126 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0127validacionEditAdditionalLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada97";
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0127 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarListingAdditionalLeasingContact();
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0127 se ejecuto "+contador+" veces");
        }
    }


}
