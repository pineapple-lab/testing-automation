package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionLogin extends TestCaseArla {
    @Test
    public void serviceLogin(){
        happyPathLogin();
        teardownPlaywright();
    }
}
