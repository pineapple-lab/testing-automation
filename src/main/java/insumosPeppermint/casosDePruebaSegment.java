package insumosPeppermint;
public class casosDePruebaSegment extends robotBasePeppermint{
    public void validarCrearSegment(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearSegments();
                System.out.print("\nSe creara el segments: " + titleSegments + "\n");
                printStream.print("\nSe creara el segments: " + titleSegments + "\n");
                crearSegment();
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
                printStream.println("El segment se ha creado con exito\n");
                imprimirCantidadDeCasosEjecutados();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
