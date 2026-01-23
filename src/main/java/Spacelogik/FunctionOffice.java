package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionOffice extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();

    @Test
    public void serviceNewOffice() {
        methods.startContextAndNavigation();
        happyPathOfficeCreate();
        teardownPlaywright();
    }
}
