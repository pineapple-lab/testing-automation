package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class listingFuncionEditExpensesInfo extends robotBaseSpaceLogik {

    @Test
    public void validacionEditListingExpensesPassedThrough(){
        iniciarVariablesEditarExpensesPassedThrough();
        login();
        navegarListingExpenses();
        editarListingExpensesPassedThrough();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditAdditionalTenantExpenses(){
        login();
        navegarListingExpenses();
        editarListingAdditionalTenantExpenses();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void vaidacionEditListingElectricalExpensesInPremises(){
        login();
        navegarListingExpenses();
        editarListingElectricalExpensesInPremises();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }

    public void navegarListingExpenses(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".BuildingInfoHeaderDiv ul li:nth-of-type(6) input");
    }
}
