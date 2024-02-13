package Docola;

import InsumosDocola.creationMethodsDocola;
import InsumosDocola.methodsDocola;
import org.junit.jupiter.api.Test;

public class functionJoin extends creationMethodsDocola {
    methodsDocola methods = new methodsDocola();
    public void startContextAndNavigation(){
        methods.startContext();
        methods.startNavigation();
    }
    @Test
    public void validationRegister(){
        startContextAndNavigation();
        joinNow();
    }
}
