package insumosPeppermint;
public class testCasesSegment extends methodsPeppermint{
    public void validateCreateSegment(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                startVariablesCreateSegments();
                System.out.print("\nSe creara el segments: " + titleSegments + "\n");
                outputStream.print("\nSe creara el segments: " + titleSegments + "\n");
                createSegment();
                assertions = "text=The segment was created successfully";
                page.waitForSelector("text=The segment was created successfully");
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleSegments;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                assertions = "text=" + titleSegments;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El segment se ha creado con exito\n");
                outputStream.println("El segment se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
