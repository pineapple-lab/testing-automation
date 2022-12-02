package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class CA039usuarioFuncionRegistro extends robotBaseSpaceLogik {

    @Test
    public void CA0391validacionRegistro(){
        firstNameRegistro= "pruebAutomatizada13-validacionRegistro";
        iniciarVariablesRegistroFeliz();
        registrarse();
    }
}
