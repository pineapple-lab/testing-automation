package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class proposalFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void validacionProposalArchive001(){
        nameProposal ="pruebAutomatizada11-validacionArchivarProposal";
        login();
        iniciarVariablesProposalXYZ77M();
        crearProposal();
        page.focus(".proposal-list-table-container");
        Assertions.assertTrue(page.isVisible( "text=pruebAutomatizada11-validacionArchivarProposal"));
        archivarProposal();
        page.focus(".proposal-list-table-container");
        Assertions.assertFalse(page.isVisible( "text=pruebAutomatizada11-validacionArchivarProposal"));
        page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
        page.focus(".proposal-list-table-container");
        Assertions.assertTrue(page.isVisible( "text=pruebAutomatizada11-validacionArchivarProposal"));
    }
}
