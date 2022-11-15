package SpaceLogik.pw.Excepcions;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validacionLoginExcepcion extends robotBaseSpaceLogik {
    @Test
    public void validacionLoginExcepcion(){
        excepcionLogin();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Please check all the information"));
    }
}
