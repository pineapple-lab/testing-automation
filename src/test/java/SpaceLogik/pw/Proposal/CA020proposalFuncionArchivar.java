package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA020proposalFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0201validacionProposalArchive001(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesCreacionProposal();
        System.out.println("El caso de prueba CA0201 se va a execute "+execute+"veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=nameProposal+".11-validacionArchivarProposal.executionDetails:"+counter;
            assertions="text="+nameCase;
            login();
            crearProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertTrue(page.isVisible(assertions));
            archivarProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertFalse(page.isVisible(assertions));
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.focus(".proposal-list-table-container");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso de prueba CA0201 se ejecuto "+counter+"veces");
        }
    }
}
