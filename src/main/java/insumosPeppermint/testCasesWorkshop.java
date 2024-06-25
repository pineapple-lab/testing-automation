package insumosPeppermint;
public class testCasesWorkshop extends methodsPeppermint{
    public void validateCreateWorkshop(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                startVariablesCreateWorkshop();

                createWorkshop();
                assertions = "text=The workshop was created successfully";
                page.waitForSelector("table tbody");
                //page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleWorkshop;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                //assertions = "text=" + titleWorkshop;
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El workshop se ha creado con exito\n");
                outputStream.println("El workshop se ha creado con exito\n");
                printNumberCasesExecuted();
            }else {
                closeContext();
            }
        }
        closeContext();
    }
}
