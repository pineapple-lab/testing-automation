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
        validations.validationsRegisterFirstName();
    }
    @Test
    public void validationLastNameRegister(){
        startContext();
        startNavigation();
        validations.validationsRegisterLastName();
    }
    @Test
    public void validationEmailRegister(){
        startContext();
        startNavigation();
        validations.validationsRegisterEmail();
    }
    @Test
    public void validationPasswordRegister(){
        startContext();
        startNavigation();
        validations.validationsRegisterPassword();
    }
    public void validationConfirmPasswordRegister(){
        startContext();
        startNavigation();
        validations.validationsRegisterConfirmPassword();
    }
    public void validationConditionsPassword(){
        startContext();
        startNavigation();
        validations.validationsRegisterPasswordConditions();
    }
    public void validationTermsAndConditions(){
        startContext();
        startNavigation();
        validations.validationTermsAndConditions();
    }
    public void validationCaptcha(){
        startContext();
        startNavigation();
        validations.validationCaptcha();
    }
}
