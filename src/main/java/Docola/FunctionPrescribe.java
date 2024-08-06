package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionPrescribe extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    @Test
    public void servicePrescribe(){
        navigationLink = "https://docolasandbox.web.app/";
        executionDetails = "40";
        contentAmount=1;
        methods.startContextAndNavigation();
        prescribe();
        //methods.signOut();
        teardownPlaywright();
    }
}
