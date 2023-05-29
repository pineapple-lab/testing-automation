package insumosPeppermint;

public class casosDePruebaTechnique extends robotBasePeppermint{
    public void validarCrearTechnique() {
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearTechnique();
                System.out.println("\nSe creara la technqiue: " + titleTechnique + "\n");
                printStream.println("La taxonomy se ha creado con exito\n");
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
                printStream.println("La technique se ha creado con exito\n");
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
