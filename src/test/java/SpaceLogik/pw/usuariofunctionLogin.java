package SpaceLogik.pw;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class usuariofunctionLogin extends robotBaseSpaceLogik {
    @Test
    public void loginValidation(){
        int contador = 2;
        for(int ejecuciones=0; ejecuciones <= contador; ejecuciones++){
            login();
            logout();
        }
    }
}
