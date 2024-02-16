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
    //SERVICE VALIDATION LOGIN
    @Test
    public void validationPasswordIncorrectLogin(){
        startContextAndNavigation();
        validations.validationLoginPasswordIncorrect();
    }
    @Test
    public void validationEmailIncorrectLogin(){
        startContextAndNavigation();
        validations.validationLoginEmailIncorrect();
    }
    @Test
    public void validationEmailEmptyLogin(){
        startContextAndNavigation();
        validations.validationLoginEmailEmpty();
    }
    @Test
    public void validationPasswordEmptyLogin(){
        startContextAndNavigation();
        validations.validationLoginPasswordEmpty();
    }
    //SERVICE VALIDATION REGISTER
    @Test
    public void validationFirstNameRegister(){
        startContextAndNavigation();
        validations.validationRegisterFirstName();
    }
    @Test
    public void validationLastNameRegister(){
        startContextAndNavigation();
        validations.validationRegisterLastName();
    }
    @Test
    public void validationEmailRegister(){
        startContextAndNavigation();
        validations.validationRegisterEmail();
    }
    @Test
    public void validationPasswordRegister(){
        startContextAndNavigation();
        validations.validationRegisterPassword();
    }
    @Test
    public void validationConfirmPasswordRegister(){
        startContextAndNavigation();
        validations.validationRegisterConfirmPassword();
    }
    @Test
    public void validationConditionsPassword(){
        startContextAndNavigation();
        validations.validationRegisterPasswordConditions();
    }
    @Test
    public void validationTermsAndConditions(){
        startContextAndNavigation();
        validations.validationTermsAndConditions();
    }
    @Test
    public void validationCaptcha(){
        startContextAndNavigation();
        validations.validationCaptcha();
    }
}
