package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validacionProposalExcepcion extends robotBaseSpaceLogik {

    @Test
    public void validacionNombreVacioExcepcion(){
        login();
        excepcionProposalNombreVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Proposal name cannot be empty"));
    }
    @Test
    public void validacionMensajePropposalDuplicado(){
        nameProposal = "pruebAutomatizada7-validacionExcepcionPropposalduplicado";
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        crearProposal();
        page.focus("body > div:nth-child(4) > div");
        Assertions.assertTrue(page.isVisible( "text=Proposal name exists already for this prospect"));
    }
    @Test
    public void validacionMensajePropposalDuplicadoArchivado(){
        nameProposal = "pruebAutomatizada34-validacionExcepcionPropposalDuplicadoArchivado";
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        archivarProposal();
        crearProposal();
        page.focus("body > div:nth-child(4) > div");
        Assertions.assertTrue(page.isVisible( "text=Proposal name exists already for this prospect"));
    }
}
