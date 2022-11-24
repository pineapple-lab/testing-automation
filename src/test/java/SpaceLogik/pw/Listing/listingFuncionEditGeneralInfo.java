package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class listingFuncionEditGeneralInfo extends robotBaseSpaceLogik {

     @Test
    public void validacionEditGeneralLocationInformation(){
         iniciarVariablesEditarListingLocationInformation();
         login();
         editarListiningGeneralLocationInformation();
         page.focus("#root");
         Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditBuildingCertifications(){
        login();
        editarListingBuildingCertifications();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditBuildingDescription(){
        locationBuildingListing="pruebAutomatizada93";
        iniciarVariablesEditarBuildingDescrption();
        login();
        editarListingBuildingDescription();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditPrimaryLeasingContact(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada94";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingPrimaryLeasingContact();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditListingSecondaryLeasingContact(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada95";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingSecondaryLeasingContact();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditBuildingOwner(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada96";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingBuildingOwner();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditAdditionalLeasingContact(){
        firstNameListingPrimaryLeasingContacts="pruebAutomatizada97";
        iniciarVariablesEditarBuildingContacts();
        login();
        editarListingAdditionalLeasingContact();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }


}
