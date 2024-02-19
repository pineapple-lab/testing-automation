package Docola;
import InsumosDocola.VariablesDocola;
import InsumosDocola.MethodsDocola;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;
import static InsumosDocola.VariablesDocola.*;
import static insumosPeppermint.variablesPeppermint.printStream;
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
        Thread interfaceThread = new Thread(() -> {
            printStream = new PrintStream(new PrintStream(new OutputStream() {
                @Override
                public void write(int b){
                    appendText(String.valueOf((char)b));
                }
                public void write (byte[] b, int off, int len){
                    appendText(new String (b,off,len));
                }
            }));
            printStream.println("Bienvenido, selecciona un ambiente y el numero de ejecuciones para empezar.\n\n");
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
                    ejecuciones=Integer.parseInt(tfExecute.getText());
                    AdvancedSettingJoin configAvanzada = new AdvancedSettingJoin(String.valueOf(ejecuciones),seleccion);
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            newContent.setOnAction(e->{
                waitingList.add(ExecMethod.NEW_CONTENT);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("NEW_CONTENT");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            newContent.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    ejecuciones=Integer.parseInt(tfExecute.getText());
                    AdvancedSettingContentCreator configAvanzada = new AdvancedSettingContentCreator(String.valueOf(ejecuciones),seleccion);
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
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
            //HEADER
            comboBox.setOnAction(e -> {
                seleccion = comboBox.getValue();
                if (seleccion.equals("Local")) {
                    VariablesDocola.linkNavigation = "http://localhost:4200/";
                }
            });
            stopTestCase.setOnAction(event ->{
                methods.stopTest();
                System.out.println("La ejecucion se detendra al final de la actual iteracion");
                printStream.println("La ejecucion se detendra al final de la actual iteracion");
            });
            removeQueue.setOnAction(event ->{
                actionEliminarDeLaCola();
            });
        }, "interfaceThread");
        if(interfaceThread.isAlive()) {
            interfaceThread.stop();
        }else {
            interfaceThread.start();
        }
        execute.setOnAction(e -> {
            System.out.println(linkNavigation);
            Thread execute = new Thread(() -> {
                ejecuciones =  Integer.parseInt(tfExecute.getText());
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
    public void accion () {
        for (int i = 0; i < waitingList.size(); i++) {
            InterfaceActions.ExecMethod var = waitingList.get(i);
            switch (var) {
                //CASE CREATION
                case CREATE_USER:
                    actionJoin();
                    break;
                case NEW_CONTENT:
                    actionNewContent();
                    break;
                case VALIDATION_EMAIL_INCORRECT_LOGIN:
                    actionValidationEmailIncorrectLogin();
                    break;
                    //CASE VALIDATIONS
                //CASE VALIDATIONS LOGIN
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
            }
        }
    }
}