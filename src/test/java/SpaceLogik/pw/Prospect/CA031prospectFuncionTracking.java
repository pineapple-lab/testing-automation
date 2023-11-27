package SpaceLogik.pw.Prospect;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA031prospectFuncionTracking extends robotBaseSpaceLogik {
    @Test
    public void CA0311validacionCrearTracking(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesTrackingFeliz();
        iniciarVariablesProspectFeliz();
        System.out.println("El caso CA0311 se va a execute: "+execute+" veces");
        for (counter=1; counter <= execute; counter++){
            nameCase=nameCompanyProspect+".18-validacionCrearTracking.Ejecuciones:"+counter;
            subjectTrackingProspect=nameCase;
            assertions="text="+subjectTrackingProspect;
            login();
            System.out.println("nombre prospect: "+nameCompanyProspect+" "+"ocupancy date: "+ocupancyDateProspect);
            crearProspect();
            crearTrackingProspect();
            page.waitForSelector("tbody tr:first-child");
            page.focus("#root");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0311 se ejecuto: "+counter+" veces");
        }
    }
}
