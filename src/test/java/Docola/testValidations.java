package Docola;

import InsumosDocola.methodsDocola;
import InsumosDocola.validationsDocola;
import org.junit.jupiter.api.Test;
public class testValidations extends methodsDocola {
    validationsDocola validations = new validationsDocola();
    @Test
    public void validationFirstNameRegister(){
        startContext();
        startNavigation();
        validations.validationsLoginFirstName();
    }
    @Test
    public void validationLastNameRegister(){
        startContext();
        startNavigation();
        validations.validationsLoginLastName();
    }
}
