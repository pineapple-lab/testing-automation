package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA030prospectFuncionEliminar extends robotBaseSpaceLogik {

    @Test
    public void CA0301validacionEliminarProspect(){
        System.out.println("Iniciando caso de prueba...");
        nameCompanyProspect = "pruebAutomatizada15-validacionEliminarProspect";
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0301 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            login();
            crearProspect();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada15-validacionEliminarProspect"));
            eliminarProspect();
            page.focus("#root");
            Assertions.assertFalse(page.isVisible("text=pruebAutomatizada15-validacionEliminarProspect"));
            System.out.println("El caso CA0301 se ejecuto: "+contador+" veces");
        }
    }

}
