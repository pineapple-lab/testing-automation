package SpaceLogik.pw;


import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class prospectFuncionCompetitiveSet extends robotBaseSpaceLogik {
   @Test
    public void validacionCrearCompetitiveSet(){
        notesCompetitiveSetProspect = "pruebaAutomatizada17-validacionCrearCompetitiveSet";
        nameCompanyProspect = "pruebaAutomatizada17-validacionCrearCompetitiveSet";
        login();
        iniciarVariablesProspectFeliz();
        iniciarVariablesCompetitiveSetFeliz();
        crearProspect();
        crearCompetitiveSetProspect();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebaAutomatizada17-validacionCrearCompetitiveSet"));

    }


}
