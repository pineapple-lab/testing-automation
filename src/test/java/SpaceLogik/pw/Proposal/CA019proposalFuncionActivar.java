package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CA019proposalFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void CA0191validacionActivarProposal(){
        System.out.println("Iniciando caso de prueba...");
        nameProposal= "pruebAutomatizada16-validacionActivarProposal";
        login();
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA0191 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            crearProposal();
            page.focus("#root");
            Assert.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProposal"));
            archivarProposal();
            page.focus("#root");
            Assert.assertFalse(page.isVisible("text=pruebAutomatizada16-validacionActivarProposal"));
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.focus("#root");
            Assert.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProposal"));
            activarProposal();
            page.focus("#root");
            Assert.assertFalse(page.isVisible("text=pruebAutomatizada16-validacionActivarProposal"));
            page.click(".proposal-list-landlord-button-container div > button:nth-of-type(1)");
            page.focus("#root");
            Assert.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProposal"));
            System.out.println("El caso CA0191 se ejecuto "+contador+" veces");
        }
    }
}
