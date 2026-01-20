package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionReCompanie extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceCreateReCompanieHappyPath(){
        methods.startContextAndNavigation();
        happyPathReCompanieCreate();
        teardownPlaywright();
    }
}
