
package SpaceLogik.pw.Proposal;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA021proposalFuncionCrear extends robotBaseSpaceLogik {
        @Test
        public void CA0211ProposalCreatorFeliz001() {
            System.out.println("Iniciando caso de prueba...");
            iniciarVariablesCreacionProposal();
            System.out.println("valores:"+building+","+prospect+","+program);
            System.out.println("El caso CA0211 se va a ejecutar: "+ejecutar+" veces");
            for (contador=1; contador <= ejecutar; contador++){
                nameCase = nameProposal+".1validacioncrearProposal.Ejecuciones:"+contador;
                login();
                crearProposal();
                buscadorContenido();
                page.focus(".proposal-list-table-container");
                assertions = "text="+nameCase;
                sqlGuardarCasoSiFallaCrearProposal();
                System.out.println("El caso CA0211 se ejecuto: "+contador+" veces");
                Assertions.assertTrue(page.isVisible(assertions));
            }
        }

        public void buscadorContenido(){
            Keyboard kb = page.keyboard();
            page.click(".input-sm ");
            kb.insertText(nameCase);
        }
}