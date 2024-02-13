package Docola;

import InsumosDocola.creationMethodsDocola;
import InsumosDocola.methodsDocola;
import InsumosDocola.validationsDocola;
import org.junit.jupiter.api.Test;
public class testValidations extends creationMethodsDocola {
    validationsDocola validations = new validationsDocola();
    methodsDocola methods = new methodsDocola();
    public void startContextAndNavigation(){
        methods.startContext();
        methods.startNavigation();
    }
    @Test
    public void validationFirstNameRegister(){
        startContextAndNavigation();
        validations.validationsRegisterFirstName();
    }
    @Test
    public void validationLastNameRegister(){
        startContextAndNavigation();
        validations.validationsRegisterLastName();
    }
    @Test
    public void validationEmailRegister(){
        startContextAndNavigation();
        validations.validationsRegisterEmail();
    }
    @Test
    public void validationPasswordRegister(){
        startContextAndNavigation();
        validations.validationsRegisterPassword();
    }
    public void validationConfirmPasswordRegister(){
        startContextAndNavigation();
        validations.validationsRegisterConfirmPassword();
    }
    public void validationConditionsPassword(){
        startContextAndNavigation();
        validations.validationsRegisterPasswordConditions();
    }
    public void validationTermsAndConditions(){
        startContextAndNavigation();
        validations.validationTermsAndConditions();
    }
    public void validationCaptcha(){
        startContextAndNavigation();
        validations.validationCaptcha();
    }
}
