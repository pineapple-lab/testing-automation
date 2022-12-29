package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA020proposalFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0201validacionProposalArchive001(){
        System.out.println("Iniciando caso de prueba...");
        nameProposal ="pruebAutomatizada11-validacionArchivarProposal";
        iniciarVariablesCreacionProposal();
        System.out.println("El caso de prueba CA0201 se va a ejecutar "+ejecutar+"veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            crearProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada11-validacionArchivarProposal"));
            archivarProposal();
            page.focus(".proposal-list-table-container");
            Assertions.assertFalse(page.isVisible("text=pruebAutomatizada11-validacionArchivarProposal"));
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.focus(".proposal-list-table-container");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada11-validacionArchivarProposal"));
            System.out.println("El caso de prueba CA0201 se ejecuto "+contador+"veces");
        }
    }
}
