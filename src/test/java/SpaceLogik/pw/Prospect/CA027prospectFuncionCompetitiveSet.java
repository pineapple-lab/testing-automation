package SpaceLogik.pw.Prospect;



import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CA027prospectFuncionCompetitiveSet extends robotBaseSpaceLogik {
   @Test
    public void CA0271validacionCrearCompetitiveSet(){
        notesCompetitiveSetProspect = "pruebAutomatizada17-validacionCrearCompetitiveSet";
        nameCompanyProspect = "pruebAutomatizada17-validacionCrearCompetitiveSet";
        login();
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        crearProspect();
        crearCompetitiveSetProspect();
        page.focus("#root");
        assertions ="text=dsfdsfdsfdsf";//nameCompanyProspect
        sqlGuardarCasoSiFallaCrearCompetitiveSet();
        Assertions.assertTrue(page.isVisible(assertions));

    }


}
