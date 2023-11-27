package SpaceLogik.pw.Excepcions;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA05validationLoginExcepcion extends robotBaseSpaceLogik {
    @Test
    public void CA051validationLoginExcepcion(){
        excepcionLogin();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Please check all the information"));
    }
}
