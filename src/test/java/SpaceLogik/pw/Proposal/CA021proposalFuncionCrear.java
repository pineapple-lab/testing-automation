
package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA021proposalFuncionCrear extends robotBaseSpaceLogik {
        @Test
        public void CA0211ProposalCreatorFeliz001() {
            nameProposal = "pruebAutomatizada1-validacioncre";
            assertions = "text=pruebAutomatizada1-validacioncrear";
            login();
            iniciarVariablesCreacionProposal();
            crearProposal();
            page.focus(".proposal-list-table-container");
            sqlGuardarCasoSiFallaCrearProposal();
            Assertions.assertTrue(page.isVisible(assertions));
                }
        }