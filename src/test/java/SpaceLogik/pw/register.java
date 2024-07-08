package SpaceLogik.pw;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class register extends robotBaseSpaceLogik {
    @Test
    public void registerValidation(){
        int executeCounter = 1;
    for(int executionDetails=1; executionDetails <= executeCounter; executionDetails++){
            registrarse();
        System.out.println(executionDetails+"/"+executeCounter);
        }
    }
}