
package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA021proposalFuncionCrear extends robotBaseSpaceLogik {
        @Test
        public void CA0211ProposalCreatorFeliz001() {
            System.out.println("Iniciando caso de prueba...");
            iniciarVariablesCreacionProposal();
            System.out.println("El caso se va a ejecutar: "+ejecutar+" veces");
            for (contador=1; contador <= ejecutar; contador++){
                nameProposal = "pruebAutomatizada1-validacioncrearProposal";
                assertions = "text=pruebAutomatizada1-validacioncrearProposal";
                login();
                crearProposal();
                page.focus(".proposal-list-table-container");
                sqlGuardarCasoSiFallaCrearProposal();
                Assertions.assertTrue(page.isVisible(assertions));
                System.out.println("El caso se ejecuto: "+contador+" veces");
            }
        }
}