package insumosPeppermint;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class casosDePruebaInviteGuest extends robotBasePeppermint {
    public void validarEnviarInviteGuest(){
        for (contador = 1; contador <= ejecutar; contador++) {
            if (!shouldStopTest) {
              enviarInviteGuest();
            } else {
                closeContext();
            }
        }
        for (contadorRegistro = 1; contadorRegistro <= ejecutar;) {
            if (!shouldStopTest) {
                page.waitForTimeout(2000);
                traerEmail();
                page.waitForTimeout(1000);
                registrarInviteGuest();
                System.out.println("El invite guest "+emailGuest+" se ha enviado y creado con exito\n");
                imprimirCantidadDeCasosEjecutadosRegistroInviteguest();
                 contadorRegistro++;
            } else {
                closeContext();
            }
        }
        closeContext();
    }
}
