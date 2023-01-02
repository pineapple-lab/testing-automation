package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA026prospectFuncionArchivar extends robotBaseSpaceLogik {
    @Test
    public void CA0261validacionArchivarProspect(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0261 se va a ejecutar: "+ejecutar+" veces");
        for (contador=1; contador <= ejecutar; contador++){
            nameCase=nameCompanyProspect+".14-validacionArchivarProspect.Ejecuciones:"+contador;
            assertions="text="+nameCase;
            login();
            crearProspect();
            archivarProspect();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            page.click(".prospect-list-landlord-button-container button:nth-of-type(2)");
            page.focus(".prospect-list-landlord-table");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0261 se ejecuto: "+contador+" veces");
        }
    }
}
