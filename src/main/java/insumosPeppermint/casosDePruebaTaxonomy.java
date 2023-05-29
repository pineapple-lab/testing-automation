package insumosPeppermint;

public class casosDePruebaTaxonomy extends robotBasePeppermint {
    public void validarCrearTaxonomy(){for (contador = 1; contador <= ejecutar; contador++) {
        if (!shouldStopTest) {
            iniciarVariablesTaxonomy();
            System.out.println("\nSe creara la taxonomy: " + titleCategory + "\n");
            printStream.println("\nSe creara la taxonomy: " + titleCategory + "\n");
            crearTaxonomy();
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
            printStream.println("La taxonomy se ha creado con exito\n");
            imprimirCantidadDeCasosEjecutados();
        } else {
            closeContext();
        }
    }
        closeContext();}

}
