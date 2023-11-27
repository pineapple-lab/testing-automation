package Peppermint;
import insumosPeppermint.methodsPeppermint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class functionHome extends methodsPeppermint {
    @Test
    public void validationPaginHome(){
        startNavigation();
        page.focus(".bg-primary-contrast");
        Assertions.assertTrue(page.isVisible("text=Welcome to Peppermint"));
        Assertions.assertTrue(page.isVisible("text=Login"));
        Assertions.assertTrue(page.isVisible("text=Join Now"));
        Assertions.assertTrue(page.isVisible("text=Categories"));
    }
}
