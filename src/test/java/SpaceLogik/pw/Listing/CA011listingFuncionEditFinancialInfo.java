package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA011listingFuncionEditFinancialInfo extends robotBaseSpaceLogik {
    @Test
    public void CA0111validacionEditFinancialInfoRateUnaSuite(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoRateUnaSuite();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0112validacionEditFinancialInfoAbatementUnaSuite(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoAbatementUnaSuite();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0113validacionEditFinancialInfoComissionUnaSuite(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoCommissionUnaSuite();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0114validacionEditFinancialInfoConstructionUnaSuite(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoConstructionUnaSuite();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }

    @Test
    public void CA0115validacionEditMultipleSuites(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoRateUnaSuite();
        editarListingFinancialInfoAbatementUnaSuite();
        editarListingFinancialInfoCommissionUnaSuite();
        editarListingFinancialInfoConstructionUnaSuite();
        page.click(".building-info-header button:nth-of-type(2)");
        page.click(".suites-modal-table-container tbody tr:nth-of-type(1) input");
        page.click(".suites-modal-table-container tbody tr:nth-of-type(2) input");
        page.click(".suites-modal-table-container tbody tr:nth-of-type(3) input");
        page.click(".suites-modal-table-container tbody tr:nth-of-type(4) input");
        page.click(".modal-buttons button:nth-of-type(1)");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditFinancialInfoVariables(){
        login();
        navegarAListingFinancialInfo();
        editarListingFinancialInfoVariables();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    public void navegarAListingFinancialInfo(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".BuildingInfoHeaderDiv ul li:nth-of-type(3) input");
    }
}
