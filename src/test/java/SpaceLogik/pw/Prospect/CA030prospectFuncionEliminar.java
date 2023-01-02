package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA030prospectFuncionEliminar extends robotBaseSpaceLogik {

    @Test
    public void CA0301validacionEliminarProspect(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0301 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            nameCase=nameCompanyProspect+".15-validacionEliminarProspect.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            login();
            crearProspect();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible(assertions));
            eliminarProspect();
            page.focus("#root");
            Assertions.assertFalse(page.isVisible(assertions));
            System.out.println("El caso CA0301 se ejecuto: "+contador+" veces");
        }
    }

}
