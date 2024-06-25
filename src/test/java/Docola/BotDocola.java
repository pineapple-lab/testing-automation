package Docola;
import InsumosDocola.VariablesDocola;
import InsumosDocola.MethodsDocola;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;
import static InsumosDocola.VariablesDocola.*;
import static insumosPeppermint.variablesPeppermint.outputStream;
public class BotDocola extends Docola.InterfaceActions {
    MethodsDocola methods= new MethodsDocola();
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
            createUser.setOnAction(e->{
                waitingList.add(ExecMethod.CREATE_USER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("CREATE_USER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            createUser.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    executionDetails=tfExecute.getText();
                    AdvancedSettingJoin configAvanzada = new AdvancedSettingJoin(executionDetails,seleccion);
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            newResource.setOnAction(e->{
                waitingList.add(ExecMethod.NEW_RESOURCE);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("NEW_RESOURCE");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            newResource.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    executionDetails=tfExecute.getText();
                    AdvancedSettingContentCreator configAvanzada = new AdvancedSettingContentCreator(executionDetails,seleccion);
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            newCourse.setOnAction(e->{
                waitingList.add(ExecMethod.NEW_COURSE);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("NEW_COURSE");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            newCourseCollection.setOnAction(e->{
                waitingList.add(ExecMethod.NEW_COURSE_COLLECTION);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("NEW_COURSE_COLLECTION");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            //validation LOGIN buttons
            validationsLoginEmailIncorrect.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_EMAIL_INCORRECT_LOGIN);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_EMAIL_INCORRECT_LOGIN");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginPasswordIncorrect.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_PASSWORD_INCORRECT_LOGIN);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_PASSWORD_INCORRECT_LOGIN");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginEmailEmpty.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_EMAIL_EMPTY_LOGIN);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_EMAIL_EMPTY_LOGIN");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginPasswordEmpty.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_PASSWORD_EMPTY_LOGIN);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_PASSWORD_EMPTY_LOGIN");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            //validation REGISTER buttons
            validationsFirstNameRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_FIRST_NAME_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_FIRST_NAME_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLastNameRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_LAST_NAME_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_LAST_NAME_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsEmailRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_EMAIL_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_EMAIL_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_PASSWORD_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_PASSWORD_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsConfirmPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_CONFIRM_PASSWORD_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_CONFIRM_PASSWORD_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsConditionsPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_CONDITIONS_PASSWORD_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_CONDITIONS_PASSWORD_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsTermsAndConditionsRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_TERMS_AND_CONDITIONS_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_TERMS_AND_CONDITIONS_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsCaptchaRegister.setOnAction(e->{
                waitingList.add(ExecMethod.VALIDATION_CAPTCHA_REGISTER);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_CAPTCHA_REGISTER");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            //validation RESOURCE buttons
            validationTitleResource.setOnAction(e->{
                resourceType ="Upload file";
                waitingList.add(ExecMethod.VALIDATION_TITLE_RESOURCE_REQUIRED);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_TITLE_RESOURCE_REQUIRED");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationTitleResource.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    executionDetails=tfExecute.getText();
                    final ExecMethod selectedMethod = ExecMethod.VALIDATION_TITLE_RESOURCE_REQUIRED;
                    AdvancedSettingValidationResources  configAvanzada = new AdvancedSettingValidationResources (executionDetails,seleccion, (value)->{
                        VariablesDocola.resourceType = value;
                        waitingList.add(selectedMethod);
                        Platform.runLater(this::accion);
                    });
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            validationDescriptionResource.setOnAction(e->{
                resourceType ="Upload file";
                waitingList.add(ExecMethod.VALIDATION_DESCRIPTION_RESOURCE_REQUIRED);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("VALIDATION_DESCRIPTION_RESOURCE_REQUIRED");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationDescriptionResource.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    executionDetails=tfExecute.getText();
                    final ExecMethod selectedMethod = ExecMethod.VALIDATION_DESCRIPTION_RESOURCE_REQUIRED;
                    AdvancedSettingValidationResources  configAvanzada = new AdvancedSettingValidationResources (executionDetails,seleccion, (value)->{
                        VariablesDocola.resourceType = value;
                        waitingList.add(selectedMethod);
                        Platform.runLater(this::accion);
                    });
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            //HEADER
            comboBox.setOnAction(e -> {
                seleccion = comboBox.getValue();
                if (seleccion.equals("Local")) {
                    VariablesDocola.navigationLink = "http://localhost:4200/";
                }
                if (seleccion.equals("DEV")) {
                    VariablesDocola.navigationLink = "https://docolasandbox.web.app/";
                }
            });
            stopTestCase.setOnAction(event ->{
                methods.stopTest();
                System.out.println("La ejecucion se detendra al final de la actual iteracion");
                outputStream.println("La ejecucion se detendra al final de la actual iteracion");
            });
            removeQueue.setOnAction(event ->{
                actionEliminarDeLaCola();
            });
            botConfigurations.setOnAction( event -> {
                    //executionDetails=tfExecute.getText();
                    BotSettings configAvanzada = new BotSettings(seleccion);
                    Stage botSettingsStage = new Stage();
                    configAvanzada.start(botSettingsStage);
                    botSettingsStage.show();
            });
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
            }
        }
        cleanWaitingList();
    }
}