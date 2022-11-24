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
        iniciarVariablesCrearSuiteListingBuild();
        login();
        crearListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite created successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEliminarSingleSuiteSpace(){
        iniciarVariablesCrearSuiteListingBuild();
        login();
        crearListingSingleSuiteSpace();
        eliminarSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite 4 deleted"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditSingleSuiteSpace(){
        suiteDescriptionListingSingleSuite="pruebAutomatizada97";
        iniciarVariablesCrearSuiteListingBuild();
        iniciarVariablesEditarSingleSuite();
        login();
        crearListingSingleSuiteSpace();
        editarListingSingleSuiteSpace();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Suite edited successfully"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    public void editarListingSingleSuiteSpace(){
        Keyboard kb = page.keyboard();
        page.click(".floor-styled-table tr:last-child > td:last-child button");
        page.click(".suite-edit-status-butttons label:nth-of-type(1) button");
        page.focus(".suite-edit-inline-inputs-labels > div:first-child input");
        kb.type(dateAvailableListingSingleSuite);
        page.focus(".suite-edit-inline-inputs-labels > div:last-child input");
        kb.type(dateAvailableEndListingSingleSuite);
        page.click(".suite-edit-status-butttons:nth-of-type(1) label:nth-of-type(1) button");
        page.fill(".divisible-container > div:last-child input",divisibleToListingSingleSuite);
        page.click(".floor-allocation-number-display button");
        page.fill(".suite-description-label textarea",suiteDescriptionListingSingleSuite);
        page.click(".suite-description-container .building-info-header button");
    }
}
