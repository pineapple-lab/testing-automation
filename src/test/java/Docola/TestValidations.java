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
    @BeforeEach
    public void setUp(){
        methods.startContextAndNavigation();
    }
    @AfterEach
    public void tearDown(){
        cleanupContext();
        teardownPlaywright();
    }
    //SERVICE VALIDATION LOGIN
    @Test
    public void serviceValidationPasswordIncorrectLogin(){
        validations.validationLoginPasswordIncorrect();
    }
    @Test
    public void serviceValidationEmailIncorrectLogin(){
        validations.validationLoginEmailIncorrect();
    }
    @Test
    public void serviceValidationEmailEmptyLogin(){
        validations.validationLoginEmailEmpty();
    }
    @Test
    public void serviceValidationPasswordEmptyLogin(){
        validations.validationLoginPasswordEmpty();
    }
    //SERVICE VALIDATION REGISTER
    @Test
    public void serviceValidationFirstNameRegister(){
        validations.validationRegisterFirstName();
    }
    @Test
    public void serviceValidationLastNameRegister(){
        validations.validationRegisterLastName();
    }
    @Test
    public void serviceValidationEmailRegister(){
        validations.validationRegisterEmail();
    }
    @Test
    public void serviceValidationPasswordRegister(){
        validations.validationRegisterPassword();
    }
    @Test
    public void serviceValidationConfirmPasswordRegister(){
        validations.validationRegisterConfirmPassword();
    }
    @Test
    public void serviceValidationConditionsPassword(){
        validations.validationRegisterPasswordConditions();
    }
    @Test
    public void serviceValidationTermsAndConditions(){
        validations.validationTermsAndConditions();
    }
    @Test
    public void serviceValidationCaptcha(){
        validations.validationCaptcha();
    }
    @Test
    public void serviceValidationRequireTitleResource(){
        validations.validationTitleResource();
    }
    @Test
    public void serviceValidationRequireDescriptionResource(){
        validations.validationDescriptionResource();
    }
}
