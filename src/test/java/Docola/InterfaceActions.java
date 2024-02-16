package Docola;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
public class InterfaceActions extends InterfacePositions{
    enum ExecMethod {
        //CREATE
        CreateUser,
        NEW_CONTENT,
        //Validations LOGIN
        validationEmailIncorrectLogin,
        validationPasswordIncorrectLogin,
        validationEmailEmptyLogin,
        validationPasswordEmptyLogin,
        //Validations REGISTER
        validationFirstNameRegister,
        validationLastNameRegister,
        validationEmailRegister,
        validationPasswordRegister,
        validationConfirmPasswordRegister,
        validationConditionsPasswordRegister,
        validationTermsAndConditionsRegister,
        validationCaptchaRegister
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
        test.validationRegister();
    }
    public void actionNewContent() {
        FunctionCreateContent test = new FunctionCreateContent();
        test.serviceNewContent();
    }
    ////validation login actions
    public void actionValidationEmailIncorrectLogin() {
        TestValidations test = new TestValidations();
        test.validationEmailIncorrectLogin();
    }
    public void actionValidationPasswordIncorrectLogin() {
        TestValidations test = new TestValidations();
        test.validationPasswordIncorrectLogin();
    }
    public void actionValidationEmailEmptyLogin() {
        TestValidations test = new TestValidations();
        test.validationEmailEmptyLogin();
    }
    public void actionValidationPasswordEmptyLogin() {
        TestValidations test = new TestValidations();
        test.validationPasswordEmptyLogin();
    }
    //validation register actions
    public void actionValidationFirstNameRegister() {
        TestValidations test = new TestValidations();
        test.validationFirstNameRegister();
    }
    public void actionValidationLastNameRegister() {
        TestValidations test = new TestValidations();
        test.validationLastNameRegister();
    }
    public void actionValidationEmailRegister() {
        TestValidations test = new TestValidations();
        test.validationEmailRegister();
    }
    public void actionValidationPasswordRegister() {
        TestValidations test = new TestValidations();
        test.validationPasswordRegister();
    }
    public void actionValidationConfirmPasswordRegister() {
        TestValidations test = new TestValidations();
        test.validationConfirmPasswordRegister();
    }
    public void actionValidationConditionsPasswordRegister() {
        TestValidations test = new TestValidations();
        test.validationConditionsPassword();
    }
    public void actionValidationTermsAndConditionsRegister() {
        TestValidations test = new TestValidations();
        test.validationTermsAndConditions();
    }
    public void actionValidationCaptchaRegister() {
        TestValidations test = new TestValidations();
        test.validationCaptcha();
    }
}
