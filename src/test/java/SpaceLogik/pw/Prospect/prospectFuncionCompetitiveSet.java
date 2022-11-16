package SpaceLogik.pw.Prospect;


import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class prospectFuncionCompetitiveSet extends robotBaseSpaceLogik {
   @Test
    public void validacionCrearCompetitiveSet(){
        notesCompetitiveSetProspect = "pruebAutomatizada17-validacionCrearCompetitiveSet";
        nameCompanyProspect = "pruebAutomatizada17-validacionCrearCompetitiveSet";
        login();
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        crearProspect();
        crearCompetitiveSetProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada17-validacionCrearCompetitiveSet"));

    }


}
