package SpaceLogik.pw;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class register extends robotBaseSpaceLogik {
    @Test
    public void registerValidation(){
        int contador = 50;
    for(int ejecuciones=0; ejecuciones <= contador; ejecuciones++){
            registrarse();
        System.out.println(ejecuciones+"/"+contador);
        }
    }
}