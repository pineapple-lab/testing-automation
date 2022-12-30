
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

            System.out.println("El caso CA0211 se va a ejecutar: "+ejecutar+" veces");
            for (contador=1; contador <= ejecutar; contador++){
                nameCase = nameProposal+".1validacioncrearProposal."+contador;
                assertions = "text="+nameProposal+".1validacioncrearProposal."+contador;
                login();
                crearProposal();
                page.focus(".proposal-list-table-container");
                sqlGuardarCasoSiFallaCrearProposal();
                System.out.println("El caso CA0211 se ejecuto: "+contador+" veces");
                Assertions.assertTrue(page.isVisible(assertions));
            }
        }
}