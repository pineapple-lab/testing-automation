package Docola;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
public class interfaceActions extends interfacePositions{
    enum ExecMethod {
        CreateUser,
        validationEmailIncorrectLogin,
        validationPasswordIncorrectLogin,
        validationEmailEmptyLogin,
        validationPasswordEmptyLogin,
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
        functionJoin test = new functionJoin();
        test.validationRegister();
    }
    ////validation login actions
    public void actionValidationEmailIncorrectLogin() {
        testValidations test = new testValidations();
        test.validationEmailIncorrectLogin();
    }
    public void actionValidationPasswordIncorrectLogin() {
        testValidations test = new testValidations();
        test.validationPasswordIncorrectLogin();
    }
    public void actionValidationEmailEmptyLogin() {
        testValidations test = new testValidations();
        test.validationEmailEmptyLogin();
    }
    public void actionValidationPasswordEmptyLogin() {
        testValidations test = new testValidations();
        test.validationPasswordEmptyLogin();
    }
    //validation register actions
    public void actionValidationFirstNameRegister() {
        testValidations test = new testValidations();
        test.validationFirstNameRegister();
    }
    public void actionValidationLastNameRegister() {
        testValidations test = new testValidations();
        test.validationLastNameRegister();
    }
    public void actionValidationEmailRegister() {
        testValidations test = new testValidations();
        test.validationEmailRegister();
    }
    public void actionValidationPasswordRegister() {
        testValidations test = new testValidations();
        test.validationPasswordRegister();
    }
    public void actionValidationConfirmPasswordRegister() {
        testValidations test = new testValidations();
        test.validationConfirmPasswordRegister();
    }
    public void actionValidationConditionsPasswordRegister() {
        testValidations test = new testValidations();
        test.validationConditionsPassword();
    }
    public void actionValidationTermsAndConditionsRegister() {
        testValidations test = new testValidations();
        test.validationTermsAndConditions();
    }
    public void actionValidationCaptchaRegister() {
        testValidations test = new testValidations();
        test.validationCaptcha();
    }
}
