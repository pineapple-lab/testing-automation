package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionPeople extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewGuru(){
        methods.startContextAndNavigation();
        happyPathGuruCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceNewGuruSweetExecute(){
        methods.startContextAndNavigation();
        executeSweetCaseNewGuru();
        teardownPlaywright();
    }
}
