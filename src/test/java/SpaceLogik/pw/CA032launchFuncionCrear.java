package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA032launchFuncionCrear extends robotBaseSpaceLogik {

    @Test
     public void CA0321validacionCrearLaunch(){
        iniciarVariablesLaunchFeliz();
        login();
        crearLaunch();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
