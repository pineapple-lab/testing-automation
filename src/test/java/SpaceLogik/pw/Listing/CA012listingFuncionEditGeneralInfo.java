package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA012listingFuncionEditGeneralInfo extends robotBaseSpaceLogik {

     @Test
    public void CA0121validacionEditGeneralLocationInformation(){
         System.out.println("Iniciando caso de prueba...");
         iniciarVariablesEditarListingLocationInformation();
         System.out.println("El caso CA0121 se va execute "+execute+" veces");
         for(counter=1;counter<=execute;counter++) {
             login();
             editarListiningGeneralLocationInformation();
             page.focus("#root");
             assertions = "text=Changes saved successfully";
             sqlGuardarCasoSiFallaEditarListingLocationInformation();
             Assertions.assertTrue(page.isVisible(assertions));
             System.out.println("El caso CA0121 se ejecuto "+counter+" veces");
         }
    }
    @Test
    public void CA0122validacionEditBuildingCertifications(){
        login();
        editarListingBuildingCertifications();
        page.focus(".Toastify__toast-body");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0123validacionEditBuildingDescription(){
        locationBuildingListing="pruebAutomatizada93";
        iniciarVariablesEditarBuildingDescrption();
        login();
        editarListingBuildingDescription();
        page.focus(".Toastify__toast-body");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    /*@Test
    public void CA0124validacionEditPrimaryLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0124 se va execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=firstNameListingPrimaryLeasingContacts+".94validacionEditPrimaryLeasingContact.Ejecuciones:"+counter;
            login();
            editarListingPrimaryLeasingContact();
            assertions="text=Changes saved successfully";//
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0124 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0125validacionEditListingSecondaryLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0125 se va execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=firstNameListingPrimaryLeasingContacts+".95validacionEditListingSecondaryLeasingContact.Ejecuciones:"+counter;
            login();
            editarListingSecondaryLeasingContact();
            page.focus("#root");
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0125 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0126validacionEditBuildingOwner(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0126 se va execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=firstNameListingPrimaryLeasingContacts+".96validacionEditBuildingOwner.Ejecuciones:"+counter;
            login();
            editarListingBuildingOwner();
            page.focus("#root");
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0126 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0127validacionEditAdditionalLeasingContact(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingContacts();
        System.out.println("El caso CA0127 se va execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=firstNameListingPrimaryLeasingContacts+".97validacionEditAdditionalLeasingContact.Ejecuciones:"+counter;
            login();
            editarListingAdditionalLeasingContact();
            assertions="text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingContacts();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0127 se ejecuto "+counter+" veces");
        }
    }*/
}
