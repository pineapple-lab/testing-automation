package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionNewPrescribe extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    @Test
    public void serviceNewPrescribe(){
        methods.startContextAndNavigation();
        newPrescribe();
        //methods.signOut();
        teardownPlaywright();
    }
}
