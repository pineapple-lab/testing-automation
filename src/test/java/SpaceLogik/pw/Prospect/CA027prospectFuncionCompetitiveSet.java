package SpaceLogik.pw.Prospect;



import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CA027prospectFuncionCompetitiveSet extends robotBaseSpaceLogik {
   @Test
    public void CA0271validacionCrearCompetitiveSet(){
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
       System.out.println("El caso CA0271 se va a ejecutar: "+ejecutar+" veces");
       for (contador=1; contador <= ejecutar; contador++){
            nameCase=nameCompanyProspect+".17-validacionCrearCompetitiveSet.Ejecuciones:"+contador;
            notesCompetitiveSetProspect=nameCase;
            login();
            crearProspect();
            crearCompetitiveSetProspect();
            page.focus("#root");
            assertions ="text="+nameCase;
            sqlGuardarCasoSiFallaCrearCompetitiveSet();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0271 se ejecuto: "+contador+" veces");
        }

    }
}
