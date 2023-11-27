package insumosPeppermint;
import org.junit.jupiter.api.Assertions;
public class casosDePruebaEvent extends methodsPeppermint{
    public void validarCrearEvent(){
        for (counter = 1; counter <= execute; counter++) {
        if (!shouldStopTest) {
            startVariablesEvent();
            System.out.println("\nSe creara el event: " + titleEvent + "\n");
            printStream.println("\nSe creara el event: " + titleEvent + "\n");
            createEvent();
            assertions = "text=The event was created successfully";
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            Assertions.assertTrue(page.isVisible(assertions));
            searchingElement = titleEvent;
            page.waitForSelector("app-paging-search mat-form-field");
            //buscarContenido();
            assertions = "text=" + titleEvent;
            page.focus("table tbody");
            //Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El event se ha creado con exito\n");
            printStream.println("El event se ha creado con exito\n");
            printNumberCasesExecuted();
        } else {
            closeContext();
        }
    }
        closeContext();
    }
}
