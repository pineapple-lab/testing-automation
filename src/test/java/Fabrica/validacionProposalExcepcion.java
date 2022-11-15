package Fabrica;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validacionProposalExcepcion extends robotBaseSpaceLogik {

    @Test
    public void validacionNombreVacioExcepcion(){
        login();
        nombreVacioProposalExcepcion();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Proposal name cannot be empty"));
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
