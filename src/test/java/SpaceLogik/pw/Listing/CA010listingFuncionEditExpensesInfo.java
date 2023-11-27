package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA010listingFuncionEditExpensesInfo extends robotBaseSpaceLogik {
    @Test
    public void CA0101alidacionEditListingExpensesPassedThrough(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarExpensesPassedThrough();
        System.out.println("El caso CA0101 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            login();
            navegarListingExpenses();
            editarListingExpensesPassedThrough();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarExpensesThrough();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0101 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0102validacionEditAdditionalTenantExpenses(){
        login();
        navegarListingExpenses();
        editarListingAdditionalTenantExpenses();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0103vaidacionEditListingElectricalExpensesInPremises(){
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
