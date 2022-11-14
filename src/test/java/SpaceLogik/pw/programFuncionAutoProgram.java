package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void validacionCrearAutoProgram(){
        nameAutoProgram="PruebAutomatizada32-validacionCrearAutoProgram";
        iniciarVariablesAutoProgramFeliz();
        login();
        crearAutoProgram();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        assertThat(page.locator(".plan-info-option-component-wrapper div:nth-of-type(2) [value=\"Shared Office\"]")).isEnabled();
    }
}
