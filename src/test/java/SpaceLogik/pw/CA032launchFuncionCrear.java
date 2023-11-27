package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA032launchFuncionCrear extends robotBaseSpaceLogik {

    @Test
     public void CA0321validacionCrearLaunch(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesLaunchFeliz();
        System.out.println("El caso CA0321 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            login();
            crearLaunch();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaCrearLaunch();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0321 se ejecuto "+counter+" veces");
        }
    }
}
