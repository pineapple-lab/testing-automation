package Peppermint;
import insumosPeppermint.casosDePruebaEvent;;
import org.junit.jupiter.api.Test;
public class functionEventManagment extends casosDePruebaEvent {
    @Test
    public void validationCreateEvent() {
        startContext();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        startExecutionEvent();
        printNumberExecutions();
        startNavigation();
        loginAdmin();
        validarCrearEvent();
    }
        /*@Test
        public void validacionDeleteEvent() {
            Keyboard kb = page.keyboard();
            iniciarNavegacion();
            startVariablesEvent();
            System.out.println(titleEvent);
            login();
            createEvent();
            deleteEvent();
            page.focus(".cdk-overlay-container snack-bar-container app-informative-notification");
            assertions = "text=Item deleted successfully";
            //Assertions.assertTrue(page.isVisible(assertions));
            page.reload();
            page.focus("table");
            assertions = "text=" + titleEvent;
            Assertions.assertFalse(page.isVisible(assertions));
        }*/
}