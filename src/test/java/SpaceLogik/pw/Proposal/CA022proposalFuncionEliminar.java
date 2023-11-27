package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA022proposalFuncionEliminar extends robotBaseSpaceLogik {
   @Test
    public void CA0221validacionProposalDelete001(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA0221 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=nameProposal+".11-validacionProposalDelete.Ejecuciones:"+counter;
            assertions="text="+nameCase;
            login();
            crearProposal();
            archivarProposal();
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.focus(".proposal-list-table");
            Assertions.assertTrue(page.isVisible(assertions));
            eliminarProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertFalse(page.isVisible(assertions));
            System.out.println("El caso CA0221 se ejecuto "+counter+" veces");
        }
    }
}
