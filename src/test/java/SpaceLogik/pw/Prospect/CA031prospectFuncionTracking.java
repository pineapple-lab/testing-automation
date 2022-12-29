package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA031prospectFuncionTracking extends robotBaseSpaceLogik {
    @Test
    public void CA0311validacionCrearTracking(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesTrackingFeliz();
        iniciarVariablesProspectFeliz();
        subjectTrackingProspect = "pruebAutomatizada18-validacionCrearTracking";
        nameCompanyProspect = "pruebAutomatizada18-validacionCrearTracking";
        System.out.println("El caso CA0311 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            login();
            crearProspect();
            crearTrackingProspect();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada18-validacionCrearTracking"));
            System.out.println("El caso CA0311 se ejecuto: "+contador+" veces");
        }
    }
}
