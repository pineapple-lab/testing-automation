package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA013listingFuncionEditSpaceInfo extends robotBaseSpaceLogik {
    @Test
    public void CA0131validacionEditarListingBuildingRsf(){
        iniciarVariablesEditarBuildingRsf();
        login();
        editarListingBuildingRsf();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0132validacionCrearSingleSuiteListingSpace(){
        suiteNumberListingSpaceBuildin="4";
        login();
        crearListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite created successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0133validacionEliminarSingleSuiteSpace(){
        suiteNumberListingSpaceBuildin="5";
        login();
        crearListingSingleSuiteSpace();
        eliminarSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite 5 deleted"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0134validacionEditSingleSuiteSpace(){
        suiteDescriptionListingSingleSuite="pruebAutomatizada97";
        suiteNumberListingSpaceBuildin="3";
        iniciarVariablesEditarSingleSuite();
        login();
        crearListingSingleSuiteSpace();
        editarListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite edited successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }

}
