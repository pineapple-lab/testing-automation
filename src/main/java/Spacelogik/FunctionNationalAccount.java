package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionNationalAccount extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewNationalAccount(){
        methods.startContextAndNavigation();
        happyPathNationalAccountCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceAssertNationalAccountFormMessageEmptyInputs(){
        methods.startContextAndNavigation();
        assertNationalAccountFormEmptyInputs();
        teardownPlaywright();
    }
}
