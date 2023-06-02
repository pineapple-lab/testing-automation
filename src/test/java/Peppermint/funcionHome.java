package Peppermint;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class funcionHome extends robotBasePeppermint {
    @Test
    public void validacionPaginHome(){
        iniciarNavegacion();
        page.focus(".bg-primary-contrast");
        Assertions.assertTrue(page.isVisible("text=Welcome to Peppermint"));
        Assertions.assertTrue(page.isVisible("text=Login"));
        Assertions.assertTrue(page.isVisible("text=Join Now"));
        Assertions.assertTrue(page.isVisible("text=Categories"));
    }
}
