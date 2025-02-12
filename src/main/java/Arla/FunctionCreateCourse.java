package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionCreateCourse extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceCreateCourse(){
        methods.startContextAndNavigation();
        happyPathCreateCourse();
        teardownPlaywright();
    }
}
