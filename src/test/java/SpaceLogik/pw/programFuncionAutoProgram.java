package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void validacionCrearAutoProgram(){
        nameAutoProgram="PruebAutomatizada32-validacionCrearAutoProgram";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        assertTrue(page.isVisible("text=Changes saved successfully"));
        assertTrue(page.getByLabel("Shared Office").isChecked());
        assertTrue(page.getByLabel("Locate on interior").isChecked());
        assertTrue(page.getByLabel("10*15").isChecked());
    }
}
