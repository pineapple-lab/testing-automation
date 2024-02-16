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
                waitingList.add(ExecMethod.CreateUser);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("CreateUser");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            createUser.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    ejecuciones=Integer.parseInt(tfExecute.getText());
                    ConfiguracionAvanzadaJoin configAvanzada = new ConfiguracionAvanzadaJoin(String.valueOf(ejecuciones),seleccion);
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
            //validation LOGIN buttons
            validationsLoginEmailIncorrect.setOnAction(e->{
                waitingList.add(ExecMethod.validationEmailIncorrectLogin);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationEmailIncorrectLogin");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginPasswordIncorrect.setOnAction(e->{
                waitingList.add(ExecMethod.validationPasswordIncorrectLogin);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationPasswordIncorrectLogin");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginEmailEmpty.setOnAction(e->{
                waitingList.add(ExecMethod.validationEmailEmptyLogin);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationEmailEmptyLogin");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLoginPasswordEmpty.setOnAction(e->{
                waitingList.add(ExecMethod.validationPasswordEmptyLogin);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationPasswordEmptyLogin");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            //validation REGISTER buttons
            validationsFirstNameRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationFirstNameRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationFirstNameRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsLastNameRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationLastNameRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationLastNameRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsEmailRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationEmailRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationEmailRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationPasswordRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationPasswordRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsConfirmPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationConfirmPasswordRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationConfirmPasswordRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsConditionsPasswordRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationConditionsPasswordRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationConditionPasswordRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsTermsAndConditionsRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationTermsAndConditionsRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationTermsAndConditionsRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, waitingList.size()-1);
            });
            validationsCaptchaRegister.setOnAction(e->{
                waitingList.add(ExecMethod.validationCaptchaRegister);
                Enum elemento = waitingList.get(waitingList.size()-1);
                CheckBox checkBox = new CheckBox("validationCaptchaRegister");
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
                case CreateUser:
                    actionJoin();
                    break;
                case NEW_CONTENT:
                    actionNewContent();
                    break;
                case validationEmailIncorrectLogin:
                    actionValidationEmailIncorrectLogin();
                    break;
                    //CASE VALIDATIONS
                //CASE VALIDATIONS LOGIN
                case validationPasswordIncorrectLogin:
                    actionValidationPasswordIncorrectLogin();
                    break;
                case validationEmailEmptyLogin:
                    actionValidationEmailEmptyLogin();
                    break;
                case validationPasswordEmptyLogin:
                    actionValidationPasswordEmptyLogin();
                    break;
                    //CASE VALIDATIONS REGISTER
                case validationFirstNameRegister:
                    actionValidationFirstNameRegister();
                    break;
                case validationLastNameRegister:
                    actionValidationLastNameRegister();
                    break;
                case validationEmailRegister:
                    actionValidationEmailRegister();
                    break;
                case validationPasswordRegister:
                    actionValidationPasswordRegister();
                    break;
                case validationConfirmPasswordRegister:
                    actionValidationConfirmPasswordRegister();
                    break;
                case validationConditionsPasswordRegister:
                    actionValidationConditionsPasswordRegister();
                    break;
                case validationTermsAndConditionsRegister:
                    actionValidationTermsAndConditionsRegister();
                    break;
                case validationCaptchaRegister:
                    actionValidationCaptchaRegister();
                    break;
            }
        }
    }
}