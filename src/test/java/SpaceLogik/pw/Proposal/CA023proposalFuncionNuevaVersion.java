package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA023proposalFuncionNuevaVersion extends robotBaseSpaceLogik {

    @Test
    public void CA0231validacionCrearNuevaVersion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA0231 se va a ejecutar "+ejecutar+" veces");
        for(contador=1; contador <= ejecutar ;contador++) {
            nameCase=nameProposal+".8-validacionNuevaVersion.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            obtenerFecha();
            login();
            crearProposal();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada8-validacionNuevaVersion"));
            crearNuevaVersion();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            page.click("text=BUILDINGS");
            page.click("text=Proposals");
            page.focus("#root");
            Assertions.assertTrue(page.isVisible(assertions+"(" + formattedDate + " - Revision 1)"));
            System.out.println("El caso CA0231 se ejecuto"+contador+" veces");
        }
    }
    @Test
    public void CA0232validacionPaymentNuevaVersion(){
        System.out.println("Iniciando caso de pruebaa...");
        iniciarVariablesCreacionProposal();
        iniciarVariablesPropposalValoresMedianos();
        System.out.println("El caso CA0232 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameProposal+"9-validacionPaymentNuevaVersion"+contador;
            login();
            crearProposal();
            llenarProposal();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            page.focus(".proposal-calculation-container h3:nth-of-type(2)");
            Assertions.assertTrue(page.isVisible("text=$952,578"));
            page.click("text=BUILDINGS");
            page.click("text=Proposals");
            crearNuevaVersion();
            page.focus("body");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            page.click("text=BUILDINGS");
            page.click("text=Proposals");
            page.click("tr:last-child .proposal-list-name-column ~ td:last-child div > button:first-child");
            page.focus(".proposal-calculation-container h3:nth-of-type(2)");
            Assertions.assertTrue(page.isVisible("text=$952,578"));
            System.out.println("El caso CA0232 se ejecuto"+contador+" veces");
        }

    }
}
