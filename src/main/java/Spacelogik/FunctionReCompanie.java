package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionReCompanie extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();
    @Test
    public void serviceNewReCompanieHappyPath(){
        methods.startContextAndNavigation();
        happyPathReCompanieCreate();
        teardownPlaywright();
    }
    @Test
    public void serviceAssertReCompanieFormMessageEmptyInputs(){
        methods.startContextAndNavigation();
        assertReCompanieFormEmptyInputs();
        teardownPlaywright();
    }
    @Test
    public void serviceReCompanieSweetExecute(){
        methods.startContextAndNavigation();
        executeSweetCaseNewReCompanie();
        teardownPlaywright();
    }
}
