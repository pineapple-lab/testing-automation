package Docola;
import InsumosDocola.VariablesDocola;
import InsumosDocola.MethodsDocola;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.tools.ant.taskdefs.Exec;

import javax.security.auth.callback.Callback;
import java.io.OutputStream;
import java.io.PrintStream;
import static InsumosDocola.VariablesDocola.*;
import static insumosPeppermint.variablesPeppermint.outputStream;
public class BotDocola extends Docola.InterfaceActions {
    private MethodsDocola methods= new MethodsDocola();
    public static void main(String[] args) {
        launch(BotDocola.class, args);
    }

    private void appendText(String text) {
        Platform.runLater(() -> consoleTextArea.appendText(text));
    }
    @Override
    public void start(Stage stage1) {
        super.start(stage1);
        stage1.setTitle("Docola bot");
        Thread interfaceThread = new Thread(() -> {
            outputStream = new PrintStream(new PrintStream(new OutputStream() {
                @Override
                public void write(int b){
                    appendText(String.valueOf((char)b));
                }
                public void write (byte[] b, int off, int len){
                    appendText(new String (b,off,len));
                }
            }));
            outputStream.println("Bienvenido, selecciona un ambiente y el numero de executionDetails para empezar.\n\n");
            //CREATOR buttons
            createUser.setOnAction(e -> handleAction(ExecMethod.CREATE_USER,"CREATE_USER"));
            createUser.setOnMousePressed( event -> handleSecondaryClick(event, AdvancedSettingJoin.class));

            newResource.setOnAction(e -> handleAction(ExecMethod.NEW_RESOURCE,"NEW_RESOURCE"));
            newResource.setOnMousePressed( event -> handleSecondaryClick(event, AdvancedSettingContentCreator.class));

            newCourse.setOnAction(e -> handleAction(ExecMethod.NEW_COURSE,"NEW_COURSE"));
            newCourseCollection.setOnAction(e -> handleAction(ExecMethod.NEW_COURSE_COLLECTION,"NEW_COURSE_COLLECTION"));
            //validation LOGIN buttons
            validationsLoginEmailIncorrect.setOnAction(e -> handleAction(ExecMethod.VALIDATION_EMAIL_EMPTY_LOGIN,"VALIDATION_EMAIL_EMPTY_LOGIN"));
            validationsLoginPasswordIncorrect.setOnAction(e -> handleAction(ExecMethod.VALIDATION_PASSWORD_INCORRECT_LOGIN,"VALIDATION_PASSWORD_INCORRECT_LOGIN"));
            validationsLoginEmailEmpty.setOnAction(e -> handleAction(ExecMethod.VALIDATION_EMAIL_EMPTY_LOGIN,"VALIDATION_PASSWORD_EMPTY_LOGIN"));
            validationsLoginPasswordEmpty.setOnAction(e -> handleAction(ExecMethod.VALIDATION_PASSWORD_EMPTY_LOGIN,"VALIDATION_PASSWORD_EMPTY_LOGIN"));
            //validation REGISTER buttons
            validationsFirstNameRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_FIRST_NAME_REGISTER,"VALIDATION_FIRST_NAME_REGISTER"));
            validationsLastNameRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_LAST_NAME_REGISTER,"VALIDATION_LAST_NAME_REGISTER"));
            validationsEmailRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_EMAIL_REGISTER,"VALIDATION_EMAIL_REGISTER"));
            validationsPasswordRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_PASSWORD_REGISTER,"VALIDATION_PASSWORD_REGISTER"));
            validationsConfirmPasswordRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_CONFIRM_PASSWORD_REGISTER,"VALIDATION_CONFIRM_PASSWORD_REGISTER"));
            validationsConditionsPasswordRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_CONDITIONS_PASSWORD_REGISTER,"VALIDATION_CONDITIONS_PASSWORD_REGISTER"));
            validationsTermsAndConditionsRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_TERMS_AND_CONDITIONS_REGISTER,"VALIDATION_TERMS_AND_CONDITIONS_REGISTER"));
            validationsCaptchaRegister.setOnAction(e -> handleAction(ExecMethod.VALIDATION_CAPTCHA_REGISTER,"VALIDATION_CAPTCHA_REGISTER"));
            //validation RESOURCE buttons
            validationTitleResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_TITLE_RESOURCE_REQUIRED,"VALIDATION_TITLE_RESOURCE_REQUIRED"));
            validationTitleResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_TITLE_RESOURCE_REQUIRED));
            validationDescriptionResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_DESCRIPTION_RESOURCE_REQUIRED, "VALIDATION_DESCRIPTION_RESOURCE_REQUIRED"));
            validationDescriptionResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_DESCRIPTION_RESOURCE_REQUIRED));
            validationFileResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_FILE_RESOURCE_REQUIRED, "VALIDATION_FILE_RESOURCE_REQUIRED"));
            validationFileResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_FILE_RESOURCE_REQUIRED));
            validationTagsResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_TAGS_RESOURCE_REQUIRED, "VALIDATION_TAGS_RESOURCE_REQUIRED"));
            validationTagsResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_TAGS_RESOURCE_REQUIRED));
            validationTwoTagsResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_TWO_TAGS_RESOURCE_REQUIRED, "VALIDATION_TWO_TAGS_RESOURCE_REQUIRED"));
            validationTwoTagsResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_TWO_TAGS_RESOURCE_REQUIRED));
            validationICD10TagsResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_ICD10_TAGS_RESOURCE_REQUIRED, "VALIDATION_ICD10_TAGS_RESOURCE_REQUIRED"));
            validationICD10TagsResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_ICD10_TAGS_RESOURCE_REQUIRED));
            validationMonthlyPriceResource.setOnAction(e -> handleResourceAction(ExecMethod.VALIDATION_MONTHLY_PRICE_RESOURCE_REQUIRED, "VALIDATION_MONTHLY_PRICE_RESOURCE_REQUIRED"));
            validationMonthlyPriceResource.setOnMousePressed( event -> handleResourceSecondaryClick(event, ExecMethod.VALIDATION_MONTHLY_PRICE_RESOURCE_REQUIRED));
            //HEADER
            comboBox.setOnAction(e -> handleComboBoxAction());
            stopTestCase.setOnAction(event -> handleStopTestCase());
            removeQueue.setOnAction(event -> actionEliminarDeLaCola());
            botConfigurations.setOnAction( event -> handleBotConfigurations());
        }, "interfaceThread");
        if(interfaceThread.isAlive()) {
            interfaceThread.stop();
        }else {
            interfaceThread.start();
        }
        execute.setOnAction(e -> {
            Thread execute = new Thread(() -> {
                executionDetails = tfExecute.getText();
                accion();
                }, "execute");
            if (execute.isAlive()) {
                execute.stop();
            } else {
                methods.startTest();
                execute.start();
            }
        });
    }
    private void handleAction(ExecMethod method, String checkBoxText) {
        waitingList.add(method);
        Enum elemento = waitingList.get(waitingList.size() - 1);
        CheckBox checkBox = new CheckBox(checkBoxText);
        checkBoxesMap.put(checkBox, elemento);
        gridCola.add(checkBox, 0, waitingList.size() - 1);
    }
    private <T> void handleSecondaryClick(MouseEvent event, Class<T> advancedSettingClass) {
        if (event.isSecondaryButtonDown()) {
            executionDetails = tfExecute.getText();
            try {
                T configAvanzada = advancedSettingClass.getDeclaredConstructor(String.class, String.class)
                        .newInstance(executionDetails, seleccion);
                Stage configAvanzadaStage = new Stage();
                if (configAvanzada instanceof AdvancedSettingJoin) {
                    ((AdvancedSettingJoin) configAvanzada).start(configAvanzadaStage);
                } else if (configAvanzada instanceof AdvancedSettingContentCreator) {
                    ((AdvancedSettingContentCreator) configAvanzada).start(configAvanzadaStage);
                }
                configAvanzadaStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void handleResourceAction(ExecMethod method, String checkBoxText) {
        resourceType = "Upload file";
        handleAction(method, checkBoxText);
    }
    private void handleResourceSecondaryClick(MouseEvent event, ExecMethod method) {
        if (event.isSecondaryButtonDown()) {
            executionDetails = tfExecute.getText();
            try {
                AdvancedSettingValidationResources configAvanzada = new AdvancedSettingValidationResources(
                        executionDetails, seleccion, value -> {
                    VariablesDocola.resourceType = value;
                    waitingList.add(method);
                    Platform.runLater(this::accion);
                });
                Stage configAvanzadaStage = new Stage();
                configAvanzada.start(configAvanzadaStage);
                configAvanzadaStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void handleComboBoxAction() {
        seleccion = comboBox.getValue();
        if ("Local".equals(seleccion)) {
            VariablesDocola.navigationLink = "http://localhost:4200/";
        }
        if ("DEV".equals(seleccion)) {
            VariablesDocola.navigationLink = "https://docolasandbox.web.app/";
        }
    }
    private void handleStopTestCase() {
        methods.stopTest();
        System.out.println("La ejecucion se detendra al final de la actual iteracion");
        outputStream.println("La ejecucion se detendra al final de la actual iteracion");
    }
    private void handleBotConfigurations() {
        try {
            BotSettings configAvanzada = new BotSettings(seleccion);
            Stage botSettingsStage = new Stage();
            configAvanzada.start(botSettingsStage);
            botSettingsStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cleanWaitingList(){
        waitingList.clear();
    }
    public void accion () {
        for (int i = 0; i < waitingList.size(); i++) {
            InterfaceActions.ExecMethod var = waitingList.get(i);
            switch (var) {
                //CASE CREATION
                case CREATE_USER:
                    actionJoin();
                    break;
                case NEW_RESOURCE:
                    actionNewResource();
                    break;
                case NEW_COURSE:
                    actionNewCourse();
                    break;
                case NEW_COURSE_COLLECTION:
                    actionNewCourseCollection();
                    break;
                 //CASE VALIDATIONS
                    //CASE VALIDATIONS LOGIN
                case VALIDATION_EMAIL_INCORRECT_LOGIN:
                    actionValidationEmailIncorrectLogin();
                    break;
                case VALIDATION_PASSWORD_INCORRECT_LOGIN:
                    actionValidationPasswordIncorrectLogin();
                    break;
                case VALIDATION_EMAIL_EMPTY_LOGIN:
                    actionValidationEmailEmptyLogin();
                    break;
                case VALIDATION_PASSWORD_EMPTY_LOGIN:
                    actionValidationPasswordEmptyLogin();
                    break;
                    //CASE VALIDATIONS REGISTER
                case VALIDATION_FIRST_NAME_REGISTER:
                    actionValidationFirstNameRegister();
                    break;
                case VALIDATION_LAST_NAME_REGISTER:
                    actionValidationLastNameRegister();
                    break;
                case VALIDATION_EMAIL_REGISTER:
                    actionValidationEmailRegister();
                    break;
                case VALIDATION_PASSWORD_REGISTER:
                    actionValidationPasswordRegister();
                    break;
                case VALIDATION_CONFIRM_PASSWORD_REGISTER:
                    actionValidationConfirmPasswordRegister();
                    break;
                case VALIDATION_CONDITIONS_PASSWORD_REGISTER:
                    actionValidationConditionsPasswordRegister();
                    break;
                case VALIDATION_TERMS_AND_CONDITIONS_REGISTER:
                    actionValidationTermsAndConditionsRegister();
                    break;
                case VALIDATION_CAPTCHA_REGISTER:
                    actionValidationCaptchaRegister();
                    break;
                case VALIDATION_TITLE_RESOURCE_REQUIRED:
                    actionValidationRequiredTitleResource();

                    break;
                case VALIDATION_DESCRIPTION_RESOURCE_REQUIRED:
                    actionValidationRequiredDescriptionResource();
                    break;
                case VALIDATION_FILE_RESOURCE_REQUIRED:
                    actionValidationRequiredFileResource();
                    break;
                case VALIDATION_TAGS_RESOURCE_REQUIRED:
                    actionValidationRequiredTagsResource();
                    break;
                case VALIDATION_TWO_TAGS_RESOURCE_REQUIRED:
                    actionValidationRequiredTwoTagsResource();
                    break;
                case VALIDATION_ICD10_TAGS_RESOURCE_REQUIRED:
                    actionValidationRequiredICD10TagsResource();
                    break;
                case VALIDATION_MONTHLY_PRICE_RESOURCE_REQUIRED:
                    actionValidationRequiredIMonthlyPriceResource();
                    break;
            }
        }
        cleanWaitingList();
    }
}