package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class usuarioFuncionRegistro extends robotBaseSpaceLogik {

    @Test
    public void validacionRegistro(){
        firstNameRegistro= "pruebAutomatizada13-validacionRegistro";
        iniciarVariablesRegistroFeliz();
        registrarse();
    }
}
