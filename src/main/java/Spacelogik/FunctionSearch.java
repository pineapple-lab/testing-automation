package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionSearch extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceBuildingsInfoValidations(){
        methods.startContextAndNavigation();
        happyPathSearchBuilding();
        teardownPlaywright();
    }
}
