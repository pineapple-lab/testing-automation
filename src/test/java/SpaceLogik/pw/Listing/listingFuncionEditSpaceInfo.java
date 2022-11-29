package SpaceLogik.pw.Listing;

import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class listingFuncionEditSpaceInfo extends robotBaseSpaceLogik {
    @Test
    public void validacionEditarListingBuildingRsf(){
        iniciarVariablesEditarBuildingRsf();
        login();
        editarListingBuildingRsf();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionCrearSingleSuiteListingSpace(){
        suiteNumberListingSpaceBuildin="4";
        login();
        crearListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite created successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEliminarSingleSuiteSpace(){
        suiteNumberListingSpaceBuildin="5";
        login();
        crearListingSingleSuiteSpace();
        eliminarSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite 5 deleted"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditSingleSuiteSpace(){
        suiteDescriptionListingSingleSuite="pruebAutomatizada97";
        suiteNumberListingSpaceBuildin="9";
        iniciarVariablesEditarSingleSuite();
        login();
        crearListingSingleSuiteSpace();
        editarListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite edited successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }

}
