package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class proposalFuncionEliminar extends robotBaseSpaceLogik {
   @Test
    public void validacionProposalDelete001(){
        nameProposal = "pruebAutomatizada11-validacionProposalDelete";
        login();
        iniciarVariablesProposalXYZ77M();
        crearProposal();
        archivarProposal();
        page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
        page.focus(".proposal-list-table");
        Assertions.assertTrue(page.isVisible( "text=pruebAutomatizada11-validacionProposalDelete"));
        eliminarProposal();
        page.focus(".proposal-list-table-container");
        Assertions.assertFalse(page.isVisible( "text=pruebAutomatizada11-validacionProposalDelete"));
    }
}
