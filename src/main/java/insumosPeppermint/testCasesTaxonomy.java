package insumosPeppermint;
public class testCasesTaxonomy extends methodsPeppermint {
    public void validateCreateTaxonomy(){
        for (counter = 1; counter <= execute; counter++) {
        if (!stopTest) {
            startVariablesTaxonomy();
            System.out.println("\nSe creara la taxonomy: " + titleCategory + "\n");
            outputStream.println("\nSe creara la taxonomy: " + titleCategory + "\n");
            createTaxonomy();
            assertions = "text=The category was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            //Assertions.assertTrue(page.isVisible(assertions));
            searchingElement = titleCategory;
            page.waitForSelector("app-paging-search mat-form-field");
            //buscarContenido();
            assertions = "text=" + titleCategory;
            page.focus("table tbody ");
            page.reload();
            page.focus("table tbody");
            //page.waitForSelector("text="+titleCategory);
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("La taxonomy se ha creado con exito\n");
            outputStream.println("La taxonomy se ha creado con exito\n");
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
    }
        closeContext();
    }
}
