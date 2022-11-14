
package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
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
        @Test
        public void validacionMensajePropposalDuplicado(){
            nameProposal = "pruebAutomatizada7-validacionMensajepropposalduplicado";
            iniciarVariablesProposalXYZ77M();
            login();
            crearProposal();
            crearProposal();
            page.focus("body > div:nth-child(4) > div");
            Assertions.assertTrue(page.isVisible( "text=Proposal name exists already for this prospect"));
        }
    }