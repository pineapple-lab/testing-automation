package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionLoginSpacelogik extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceLogin(){
        methods.startContextAndNavigation();
        happyPathLogin();
        teardownPlaywright();
    }
}
