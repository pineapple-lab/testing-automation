package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionLocations extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewLocation(){
        methods.startContextAndNavigation();
        happyPathLocationCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceNewLocationSweetExecute(){
        methods.startContextAndNavigation();
        executeSweetCaseNewLocation();
        teardownPlaywright();
    }
    @Test
    public void serviceActivateLocationMultipleGuru(){
        methods.startContextAndNavigation();
        happyPathAcivateLocationMultipleGuru();
        teardownPlaywright();
    }
}
