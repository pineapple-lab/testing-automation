package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionLogin extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceLogin(){
        methods.startContextAndNavigation();
        happyPathLogin();
        teardownPlaywright();
    }
}
