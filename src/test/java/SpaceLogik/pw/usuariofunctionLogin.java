package SpaceLogik.pw;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class usuariofunctionLogin extends robotBaseSpaceLogik {
    @Test
    public void loginValidation(){
        int executeCounter = 100;
        for(int executionDetails=0; executionDetails <= executeCounter; executionDetails++){
            login();
            logout();
            System.out.println(executionDetails+"/"+executeCounter);
        }
    }
}
