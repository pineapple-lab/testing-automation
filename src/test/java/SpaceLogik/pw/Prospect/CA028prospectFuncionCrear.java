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
        System.out.println("El caso CA0281 se  va e execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=nameCompanyProspect+".10-validacionCreacionProspect.executionDetails:"+counter;
            assertions="text="+nameCase;
            login();
            crearProspect();
            page.focus(".prospect-list-landlord-table");
            sqlGuardarCasoSiFallaCrearProspect();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0281 se ejecuto "+counter+" veces");
        }
    }

}
