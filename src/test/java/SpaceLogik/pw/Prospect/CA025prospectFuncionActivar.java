package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA025prospectFuncionActivar extends robotBaseSpaceLogik {
    @Test
    public void CA0251validacionActivarProspect(){
        System.out.print("Iniciando caso de prueba...");
        nameCompanyProspect = "pruebAutomatizada16-validacionActivarProspect";
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0251 se va a ejecutar "+ejecutar+" veces");
        for(contador=1; contador<=ejecutar; contador++) {
            login();
            crearProspect();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
            archivarProspect();
            page.focus("#root");
            Assertions.assertFalse(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
            page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
            activarProspect();
            page.click(".prospect-list-landlord-button-container button:nth-of-type(1)");
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada16-validacionActivarProspect"));
            System.out.println("El caso CA0251 se ejecuto "+contador+" veces");
        }
    }
}
