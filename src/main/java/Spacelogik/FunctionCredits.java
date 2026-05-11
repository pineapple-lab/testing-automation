package Spacelogik;

import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.TestCaseSpacelogik;
import org.junit.jupiter.api.Test;

public class FunctionCredits extends TestCaseSpacelogik {
    MethodsSpacelogik methods = new MethodsSpacelogik();

    @Test
    public void serviceBuyCredits() {
        methods.startContextAndNavigation();
        happyPathBuyCredits();
        teardownPlaywright();
    }
}
