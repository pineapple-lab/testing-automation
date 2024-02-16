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
    public void validationPasswordIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordIncorrect();
    }
    @Test
    public void validationEmailIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailIncorrect();
    }
    @Test
    public void validationEmailEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailEmpty();
    }
    @Test
    public void validationPasswordEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordEmpty();
    }
    //SERVICE VALIDATION REGISTER
    @Test
    public void validationFirstNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterFirstName();
    }
    @Test
    public void validationLastNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterLastName();
    }
    @Test
    public void validationEmailRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterEmail();
    }
    @Test
    public void validationPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterPassword();
    }
    @Test
    public void validationConfirmPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterConfirmPassword();
    }
    @Test
    public void validationConditionsPassword(){
        methods.startContextAndNavigation();
        validations.validationRegisterPasswordConditions();
    }
    @Test
    public void validationTermsAndConditions(){
        methods.startContextAndNavigation();
        validations.validationTermsAndConditions();
    }
    @Test
    public void validationCaptcha(){
        methods.startContextAndNavigation();
        validations.validationCaptcha();
    }
}
