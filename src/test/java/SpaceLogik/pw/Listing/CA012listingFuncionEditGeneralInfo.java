package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA012listingFuncionEditGeneralInfo extends robotBaseSpaceLogik {

     @Test
    public void CA0121validacionEditGeneralLocationInformation(){
         iniciarVariablesEditarListingLocationInformation();
         login();
         editarListiningGeneralLocationInformation();
         page.focus("#root");
         assertions = "text=Changes saved successfully";
         sqlGuardarCasoSiFallaEditarListingLocationInformation();
         Assertions.assertTrue(page.isVisible(assertions));
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
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada94";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingPrimaryLeasingContact();
        assertions="text=asdfasfasdfdasf";//Changes saved successfully
        sqlGuardarCasoSiFallaEditarBuildingContacts();
        Assertions.assertTrue(page.isVisible(assertions));
    }
    @Test
    public void CA0125validacionEditListingSecondaryLeasingContact(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada95";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingSecondaryLeasingContact();
        page.focus("#root");
        assertions="text=Changes saved successfully";
        sqlGuardarCasoSiFallaEditarBuildingContacts();
        Assertions.assertTrue(page.isVisible(assertions));
    }
    @Test
    public void CA0126validacionEditBuildingOwner(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada96";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingBuildingOwner();
        page.focus("#root");
        assertions="text=Changes saved successfully";
        sqlGuardarCasoSiFallaEditarBuildingContacts();
        Assertions.assertTrue(page.isVisible(assertions));
    }
    @Test
    public void CA0127validacionEditAdditionalLeasingContact(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada97";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingAdditionalLeasingContact();
        assertions="text=Changes saved successfully";
        sqlGuardarCasoSiFallaEditarBuildingContacts();
        Assertions.assertTrue(page.isVisible(assertions));
    }


}
