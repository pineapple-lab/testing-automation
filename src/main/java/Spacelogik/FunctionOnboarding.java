package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionOnboarding  extends TestCaseSpacelogik{

        MethodsSpacelogik methods = new MethodsSpacelogik();
        @Test
        public void serviceCompleteOnboarding(){
            methods.startContextAndNavigation();
            happyPathConfigOnboarding();
            teardownPlaywright();

    }
}
