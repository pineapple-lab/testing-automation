package insumosPeppermint;
public class casosDePruebaArticulos extends robotBasePeppermint{
    public void validarCrearArticulo(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearArticle();
                System.out.println("\nSe creara el article: " + titleArticle + "\n");
                printStream.println("\nSe creara el article: " + titleArticle + "\n");
                crearArticulo();
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
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
