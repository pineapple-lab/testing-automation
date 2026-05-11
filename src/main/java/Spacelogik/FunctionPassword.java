package Spacelogik;

import InsumosSpacelogik.TestCaseSpacelogik;
import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionPassword extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceSetPassword(){
        methods.startContextAndNavigation();
        happyPathConfigPassword();
        teardownPlaywright();
    }
}
