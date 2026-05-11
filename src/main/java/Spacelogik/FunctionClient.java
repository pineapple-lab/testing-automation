package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionClient extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewClient(){
        methods.startContextAndNavigation();
        happyPathClientCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceNewClientSweetExecute(){
        methods.startContextAndNavigation();
        executeSweetCaseNewClient();
        teardownPlaywright();
    }
    @Test
    public void serviceNewClientAndLocation(){
        methods.startContextAndNavigation();
        happyPathCreateClientAndLocationMultipleGuru();
        teardownPlaywright();
    }
}
