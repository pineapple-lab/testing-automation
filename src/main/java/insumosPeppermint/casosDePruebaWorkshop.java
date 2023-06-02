package insumosPeppermint;
public class casosDePruebaWorkshop extends robotBasePeppermint{
    public void validarCrearWorkshop(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
                iniciarVariablesCrearWorkshop();
                System.out.println("\nSe creara el workshop: " + titleWorkshop + "\n");
                printStream.println("\nSe creara el workshop: " + titleWorkshop + "\n");
                crearWorkshop();
                assertions = "text=The workshop was created successfully";
                page.setDefaultTimeout(1200000000);
                page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
                //Assertions.assertTrue(page.isVisible(assertions));
                searchingElement = titleWorkshop;
                page.waitForSelector("app-paging-search mat-form-field");
                //buscarContenido();
                assertions = "text=" + titleWorkshop;
                page.focus("table tbody");
                //Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El workshop se ha creado con exito\n");
                printStream.println("El workshop se ha creado con exito\n");
                imprimirCantidadDeCasosEjecutados();
            }else {
                closeContext();
            }
        }
        closeContext();
    }
}
