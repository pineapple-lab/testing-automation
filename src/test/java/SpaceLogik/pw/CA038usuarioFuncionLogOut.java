package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA038usuarioFuncionLogOut  extends robotBaseSpaceLogik {

    @Test
    public void CA0381validacionLogut() {
        login();
        logout();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Login"));
        Assertions.assertTrue(page.isVisible("text=LOG IN"));
        Assertions.assertTrue(page.isVisible("text=REGISTER NOW"));
    }


}
