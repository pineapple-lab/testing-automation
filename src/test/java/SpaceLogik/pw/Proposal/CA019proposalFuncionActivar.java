package SpaceLogik.pw.Proposal;

import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA019proposalFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void CA0191validacionActivarProposal(){
        Keyboard kb = page.keyboard();
        System.out.println("Iniciando caso de prueba...");
        login();
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA0191 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameProposal+".16-validacionActivarProposal.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            crearProposal();
            page.waitForSelector(".MuiTableBody-root tr");
            page.focus(".MuiTableBody-root tr");
            Assertions.assertTrue(page.isVisible(assertions));
            archivarProposal();
            page.focus(".Toastify__toast-body");
            Assertions.assertTrue(page.isVisible("text=Proposal archived successfully"));
            page.reload();
            page.focus(".MuiTableBody-root tr");
            Assertions.assertFalse(page.isVisible(assertions));
            page.click(".proposal-list-landlord-button-container button:nth-of-type(2)");
            page.click(".proposal-filter-input");
            kb.insertText(nameCase);
            page.focus(".MuiTableBody-root");
            System.out.println(assertions);
            Assertions.assertTrue(page.isVisible(assertions));
            activarProposal();
            page.focus(".Toastify__toast-body");
            Assertions.assertTrue(page.isVisible("text=Proposal activated successfully"));
            page.focus(".proposal-list-table-container");
            page.waitForSelector(".proposal-messasge-not-found");
            Assertions.assertFalse(page.isVisible(assertions));
            page.click(".proposal-list-landlord-button-container div > button:nth-of-type(1)");
            page.focus(".MuiTableBody-root tr");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0191 se ejecuto "+contador+" veces");
        }
    }
}
