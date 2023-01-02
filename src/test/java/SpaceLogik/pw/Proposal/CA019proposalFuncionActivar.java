package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CA019proposalFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void CA0191validacionActivarProposal(){
        System.out.println("Iniciando caso de prueba...");
        login();
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA0191 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameProposal+".16-validacionActivarProposal.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            crearProposal();
            page.focus("#root");
            Assert.assertTrue(page.isVisible(assertions));
            archivarProposal();
            page.focus("#root");
            Assert.assertFalse(page.isVisible(assertions));
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.focus("#root");
            Assert.assertTrue(page.isVisible(assertions));
            activarProposal();
            page.focus("#root");
            Assert.assertFalse(page.isVisible(assertions));
            page.click(".proposal-list-landlord-button-container div > button:nth-of-type(1)");
            page.focus("#root");
            Assert.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0191 se ejecuto "+contador+" veces");
        }
    }
}
