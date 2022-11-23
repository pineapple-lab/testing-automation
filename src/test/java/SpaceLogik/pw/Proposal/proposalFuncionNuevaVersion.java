package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class proposalFuncionNuevaVersion extends robotBaseSpaceLogik {

    @Test
    public void validacionCrearNuevaVersion(){
        nameProposal = "pruebaAutomatizada8-validacionNuevaVersion";
        obtenerFecha();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=pruebaAutomatizada8-validacionNuevaVersion"));
        crearNuevaVersion();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.click("text=BUILDINGS");
        page.click("text=Proposals");
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=pruebaAutomatizada8-validacionNuevaVersion ("+formattedDate+" - Revision 1)"));
    }
    @Test
    public void validacionPaymentNuevaVersion(){
        iniciarVariablesProposalXYZ77M();
        iniciarVariablesPropposalValoresMedianos();
        nameProposal = "pruebAutomatizada9-validacionPaymentNuevaVersion";
        login();
        crearProposal();
        llenarProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$952,578"));
        page.click("text=BUILDINGS");
        page.click("text=Proposals");
        crearNuevaVersion();
        page.focus("body");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.click("text=BUILDINGS");
        page.click("text=Proposals");
        page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:first-child");
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$952,578"));

    }
}
