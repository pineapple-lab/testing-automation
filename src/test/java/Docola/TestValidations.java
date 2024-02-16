package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import InsumosDocola.ValidationsDocola;
import org.junit.jupiter.api.Test;
public class TestValidations extends MethodsCreationDocola {
    ValidationsDocola validations = new ValidationsDocola();
    MethodsDocola methods = new MethodsDocola();
    //SERVICE VALIDATION LOGIN
    @Test
    public void serviceValidationPasswordIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordIncorrect();
    }
    @Test
    public void serviceValidationEmailIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailIncorrect();
    }
    @Test
    public void serviceValidationEmailEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailEmpty();
    }
    @Test
    public void serviceValidationPasswordEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordEmpty();
    }
    //SERVICE VALIDATION REGISTER
    @Test
    public void serviceValidationFirstNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterFirstName();
    }
    @Test
    public void serviceValidationLastNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterLastName();
    }
    @Test
    public void serviceValidationEmailRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterEmail();
    }
    @Test
    public void serviceValidationPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterPassword();
    }
    @Test
    public void serviceValidationConfirmPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterConfirmPassword();
    }
    @Test
    public void serviceValidationConditionsPassword(){
        methods.startContextAndNavigation();
        validations.validationRegisterPasswordConditions();
    }
    @Test
    public void serviceValidationTermsAndConditions(){
        methods.startContextAndNavigation();
        validations.validationTermsAndConditions();
    }
    @Test
    public void serviceValidationCaptcha(){
        methods.startContextAndNavigation();
        validations.validationCaptcha();
    }
}
