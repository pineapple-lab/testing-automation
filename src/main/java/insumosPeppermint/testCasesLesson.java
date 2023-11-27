package insumosPeppermint;
public class testCasesLesson extends methodsPeppermint{
    public void validateCreateLesson(){
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVariablesCreateLesson();
                System.out.println("\nSe creara el lesson: " + titleLesson + "\n");
                printStream.println("\nSe creara el lesson: " + titleLesson + "\n");
                createLesson();
                assertions = "text=The lesson was created successfully";
                page.waitForSelector("text=The lesson was created successfully");
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleLesson;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                assertions = "text=" + titleLesson;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El lesson se ha creado con exito\n");
                printStream.println("El lesson se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
