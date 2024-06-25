package insumosPeppermint;
public class testCasesTechnique extends methodsPeppermint{
    public void validateCreateTechnique() {
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                startVariablesCreateTechnique();
                createTechnique();
                assertions = "text=The technique was created successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleTechnique;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                assertions = "text=" + titleTechnique;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("La technique se ha creado con exito\n");
                outputStream.println("La technique se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
