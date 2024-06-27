package Docola;
import InsumosDocola.VariablesDocola;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
public class InterfaceActions extends InterfaceProperties{
    VariablesDocola variables = new VariablesDocola();
    enum ExecMethod {
        //CREATE
        CREATE_USER,
        NEW_RESOURCE,
        NEW_COURSE,
        NEW_COURSE_COLLECTION,
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
        VALIDATION_CAPTCHA_REGISTER,
        VALIDATION_TITLE_RESOURCE_REQUIRED,
        VALIDATION_DESCRIPTION_RESOURCE_REQUIRED,
        VALIDATION_FILE_RESOURCE_REQUIRED,
        VALIDATION_TAGS_RESOURCE_REQUIRED,
        VALIDATION_TWO_TAGS_RESOURCE_REQUIRED,
        VALIDATION_ICD10_TAGS_RESOURCE_REQUIRED,
        VALIDATION_MONTHLY_PRICE_RESOURCE_REQUIRED
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
        executeService(new FunctionJoin(), FunctionJoin::serviceValidationRegister);
    }
    public void actionNewResource() {
        executeService(new FunctionCreateContent(), FunctionCreateContent::serviceNewResource);
    }
    public void actionNewCourse() {
        executeService(new FunctionCreateContent(), FunctionCreateContent::serviceNewCourse);
    }
    public void actionNewCourseCollection() {
        executeService(new FunctionCreateContent(), FunctionCreateContent::serviceNewCourseCollection);
    }
    ////validation login actions
    public void actionValidationEmailIncorrectLogin() {
        executeService(new TestValidations(), TestValidations::serviceValidationEmailIncorrectLogin);
    }
    public void actionValidationPasswordIncorrectLogin() {
        executeService(new TestValidations(), TestValidations::serviceValidationPasswordIncorrectLogin);
    }
    public void actionValidationEmailEmptyLogin() {
        executeService(new TestValidations(), TestValidations::serviceValidationEmailEmptyLogin);
    }
    public void actionValidationPasswordEmptyLogin() {
        executeService(new TestValidations(), TestValidations::serviceValidationPasswordEmptyLogin);
    }
    //validation register actions
    public void actionValidationFirstNameRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationFirstNameRegister);
    }
    public void actionValidationLastNameRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationLastNameRegister);
    }
    public void actionValidationEmailRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationEmailRegister);
    }
    public void actionValidationPasswordRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationPasswordRegister);
    }
    public void actionValidationConfirmPasswordRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationConfirmPasswordRegister);
    }
    public void actionValidationConditionsPasswordRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationConditionsPassword);
    }
    public void actionValidationTermsAndConditionsRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationTermsAndConditions);
    }
    public void actionValidationCaptchaRegister() {
        executeService(new TestValidations(), TestValidations::serviceValidationCaptcha);
    }
    //validations RESOURCE actions
    public void actionValidationRequiredTitleResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireTitleResource);
    }
    public void actionValidationRequiredDescriptionResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireDescriptionResource);
    }
    public void actionValidationRequiredFileResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireFileResource);
    }
    public void actionValidationRequiredTagsResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireTagsResource);
    }
    public void actionValidationRequiredTwoTagsResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireTwoTagsResource);
    }
    public void actionValidationRequiredICD10TagsResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireICD10TagsResource);
    }
    public void actionValidationRequiredIMonthlyPriceResource() {
        executeService(new TestValidations(), TestValidations::serviceValidationRequireMonthlyPriceResource);
    }
    //Querys
    public void actionUpdateUndefinedUser(String email) {
        executeService(new BotConfiguration(), config -> config.serviceUpdateUndefinedUser(email));
    }
    // Manejo básico de excepciones
    private <T> void executeService(T serviceInstance, CheckedConsumer<T> action) {
        try {
            action.accept(serviceInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Interfaz funcional para consumidores con excepción
    @FunctionalInterface
    private interface CheckedConsumer<T> {
        void accept(T t) throws Exception;
    }
}
