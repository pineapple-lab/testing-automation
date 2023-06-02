package Peppermint;
import insumosPeppermint.casosDePruebaEvent;;
import org.junit.jupiter.api.Test;
public class funcionEventManagment extends casosDePruebaEvent {
    @Test
    public void validacionCreateEvent() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        printStream.println("iniciando caso de prueba...");
        iniciarEjecucionEvent();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearEvent();
    }
        /*@Test
        public void validacionDeleteEvent() {
            Keyboard kb = page.keyboard();
            iniciarNavegacion();
            iniciarVariablesEvent();
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