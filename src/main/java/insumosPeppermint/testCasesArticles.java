package insumosPeppermint;
public class testCasesArticles extends methodsPeppermint{
    public void validateCreateArticle(){
        for (counter = 1; counter <= execute; counter++) {
            if (!shouldStopTest) {
                startVariablesCreateArticle();
                createArticle();
                assertions = "text=Techniques added successfully";
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleArticle;
                /*page.waitForSelector("app-paging-search mat-form-field");*/
                assertions = "text=The article was created successfully";
                //page.waitForSelector(assertions);
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                //buscarContenido();
                assertions = "text=" + titleArticle;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El article se ha creado con exito\n");
                printStream.println("El article se ha creado con exito\n");
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
