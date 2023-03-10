package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA025prospectFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void CA0251validacionActivarProspect(){
        System.out.print("Iniciando caso de prueba...");
        nameCompanyProspect = "pruebAutomatizada";
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0251 se va a ejecutar "+ejecutar+" veces");
        for(contador=1; contador<=ejecutar; contador++) {
            nameCase=nameCompanyProspect+".16-validacionActivarProspect.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            login();
            crearProspect();
            page.focus("tbody td:first-child");
            page.pause();
            Assertions.assertTrue(page.isVisible(assertions));
            archivarProspect();
            page.waitForSelector(".Toastify__toast-body");
            page.reload();
            page.focus("tbody td:first-child");
            Assertions.assertFalse(page.isVisible(assertions));
            page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
            page.focus("tbody td:first-child");
            Assertions.assertTrue(page.isVisible(assertions));
            activarProspect();
            page.waitForSelector(".Toastify__toast-body");
            page.click(".prospect-list-landlord-button-container button:nth-of-type(1)");
            page.focus("tbody td:first-child");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0251 se ejecuto "+contador+" veces");
        }
    }
}
