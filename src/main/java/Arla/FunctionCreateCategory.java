package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionCreateCategory extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceCreateCategory(){
        methods.startContextAndNavigation();
        happyPathCreateCategory();
        teardownPlaywright();
    }
}
