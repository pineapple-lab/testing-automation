package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import InsumosDocola.ValidationsDocola;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestValidations extends MethodsCreationDocola {
    ValidationsDocola validations = new ValidationsDocola();
    MethodsDocola methods = new MethodsDocola();
    //SERVICE VALIDATION LOGIN
    @Test
    public void serviceValidationPasswordIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordIncorrect();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationEmailIncorrectLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailIncorrect();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationEmailEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginEmailEmpty();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationPasswordEmptyLogin(){
        methods.startContextAndNavigation();
        validations.validationLoginPasswordEmpty();
        teardownPlaywright();
    }
    //SERVICE VALIDATION REGISTER
    @Test
    public void serviceValidationFirstNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterFirstName();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationLastNameRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterLastName();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationEmailRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterEmail();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterPassword();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationConfirmPasswordRegister(){
        methods.startContextAndNavigation();
        validations.validationRegisterConfirmPassword();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationConditionsPassword(){
        methods.startContextAndNavigation();
        validations.validationRegisterPasswordConditions();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationTermsAndConditions(){
        methods.startContextAndNavigation();
        validations.validationTermsAndConditions();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationCaptcha(){
        methods.startContextAndNavigation();
        validations.validationCaptcha();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationRequireTitleResource(){
        methods.startContextAndNavigation();
        validations.validationTitleResource();
        teardownPlaywright();
    }
    @Test
    public void serviceValidationRequireDescriptionResource(){
        methods.startContextAndNavigation();
        validations.validationDescriptionResource();
        teardownPlaywright();
    }
}
