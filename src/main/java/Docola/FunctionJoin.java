package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionJoin extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    @Test
    public void serviceValidationRegister(){
        methods.startContextAndNavigation();
        newJoinNow();
        teardownPlaywright();
    }
}
