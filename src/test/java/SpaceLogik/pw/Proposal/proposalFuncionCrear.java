
package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class proposalFuncionCrear extends robotBaseSpaceLogik {
        @Test
        public void ProposalCreatorFeliz001() {
            nameProposal = "pruebAutomatizada1-vaidacioncreararchivareliminar";
            login();
            iniciarVariablesProposalXYZ77M();
            crearProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertTrue(page.isVisible( "text=pruebAutomatizada1-vaidacioncreararchivareliminar"));
        }

    }