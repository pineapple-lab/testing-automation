package SpaceLogik.pw;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class register extends robotBaseSpaceLogik {
    @Test
    public void registerValidation(){
        int executeCounter = 50;
    for(int executionDetails=0; executionDetails <= executeCounter; executionDetails++){
            registrarse();
        System.out.println(executionDetails+"/"+executeCounter);
        }
    }
}