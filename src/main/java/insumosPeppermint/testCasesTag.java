package insumosPeppermint;
public class testCasesTag extends methodsPeppermint{
    public void validateCreateTag(){
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVariablesTag();
                System.out.println("\nSe creara el tag: " + titleTag + "\n");
                printStream.println("\nSe creara el tag: " + titleTag + "\n");
                createTag();
                assertions = "text=The tag was created successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleTag;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                assertions = "text=" + titleTag;
                page.focus("table tbody ");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("La tag se ha creado con exito\n");
                printStream.println("La tag se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
