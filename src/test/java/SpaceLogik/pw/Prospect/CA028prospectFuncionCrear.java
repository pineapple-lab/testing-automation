package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA028prospectFuncionCrear extends robotBaseSpaceLogik {

    @Test
    public void CA0281validacionCreacionProspect(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0281 se  va e ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameCompanyProspect+".10-validacionCreacionProspect.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            login();
            crearProspect();
            page.focus(".prospect-list-landlord-table");
            sqlGuardarCasoSiFallaCrearProspect();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0281 se ejecuto "+contador+" veces");
        }
    }

}
