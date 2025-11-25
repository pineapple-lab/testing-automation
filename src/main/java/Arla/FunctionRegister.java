package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;


public class FunctionRegister extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceRegister(){
        System.out.println("register1");
        methods.startContextAndNavigation();
        happyPathRegister();
        teardownPlaywright();
    }
}

