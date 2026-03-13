package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionPrograms extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewProgram(){
        methods.startContextAndNavigation();
        happyPathAutoofficeProgramCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceProgramSweetExecute(){
        methods.startContextAndNavigation();
        executeSweetCaseNewAutoofficeProgram();
        teardownPlaywright();
    }
}
