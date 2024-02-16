package Docola;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
public class InterfaceActions extends InterfacePositions{
    enum ExecMethod {
        //CREATE
        CREATE_USER,
        NEW_CONTENT,
        //Validations LOGIN
        VALIDATION_EMAIL_INCORRECT_LOGIN,
        VALIDATION_PASSWORD_INCORRECT_LOGIN,
        VALIDATION_EMAIL_EMPTY_LOGIN,
        VALIDATION_PASSWORD_EMPTY_LOGIN,
        //Validations REGISTER
        VALIDATION_FIRST_NAME_REGISTER,
        VALIDATION_LAST_NAME_REGISTER,
        VALIDATION_EMAIL_REGISTER,
        VALIDATION_PASSWORD_REGISTER,
        VALIDATION_CONFIRM_PASSWORD_REGISTER,
        VALIDATION_CONDITIONS_PASSWORD_REGISTER,
        VALIDATION_TERMS_AND_CONDITIONS_REGISTER,
        VALIDATION_CAPTCHA_REGISTER
    }
    public void actionEliminarDeLaCola() {
        List<CheckBox> checkBoxesSeleccionados = new ArrayList<>();
        for (CheckBox checkBox : checkBoxesMap.keySet()) {
            if (checkBox.isSelected()) {
                checkBoxesSeleccionados.add(checkBox);
            }
        }
        for (CheckBox checkBox : checkBoxesSeleccionados) {
            Enum elemento = checkBoxesMap.get(checkBox);
            waitingList.remove(elemento);
            checkBoxesMap.remove(checkBox);
            gridCola.getChildren().remove(checkBox);
        }
    }
   //create actions
    public void actionJoin() {
        FunctionJoin test = new FunctionJoin();
        test.serviceValidationRegister();
    }
    public void actionNewContent() {
        FunctionCreateContent test = new FunctionCreateContent();
        test.serviceNewContent();
    }
    ////validation login actions
    public void actionValidationEmailIncorrectLogin() {
        TestValidations test = new TestValidations();
        test.serviceValidationEmailIncorrectLogin();
    }
    public void actionValidationPasswordIncorrectLogin() {
        TestValidations test = new TestValidations();
        test.serviceValidationPasswordIncorrectLogin();
    }
    public void actionValidationEmailEmptyLogin() {
        TestValidations test = new TestValidations();
        test.serviceValidationEmailEmptyLogin();
    }
    public void actionValidationPasswordEmptyLogin() {
        TestValidations test = new TestValidations();
        test.serviceValidationPasswordEmptyLogin();
    }
    //validation register actions
    public void actionValidationFirstNameRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationFirstNameRegister();
    }
    public void actionValidationLastNameRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationLastNameRegister();
    }
    public void actionValidationEmailRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationEmailRegister();
    }
    public void actionValidationPasswordRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationPasswordRegister();
    }
    public void actionValidationConfirmPasswordRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationConfirmPasswordRegister();
    }
    public void actionValidationConditionsPasswordRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationConditionsPassword();
    }
    public void actionValidationTermsAndConditionsRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationTermsAndConditions();
    }
    public void actionValidationCaptchaRegister() {
        TestValidations test = new TestValidations();
        test.serviceValidationCaptcha();
    }
}
