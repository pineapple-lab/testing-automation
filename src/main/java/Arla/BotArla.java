package Arla;
import Docola.BotModalConfigs;
import InsumosArla.MethodsArla;
import InsumosArla.VariablesArla;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.OutputStream;
import java.io.PrintStream;

import static InsumosDocola.VariablesDocola.*;
import static InsumosDocola.VariablesDocola.resourceType;
import static insumosPeppermint.variablesPeppermint.outputStream;
import static javafx.application.Application.launch;

public class BotArla extends Arla.InterfaceActions {
    private volatile boolean isRunning = true;
    private MethodsArla methods= new MethodsArla();
    public static void main(String[] args) {
        //String path = BotDocola.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //System.out.println(path);
        launch(BotArla.class, args);
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
            hpLoginButton.setOnAction(e -> handleAction(ExecMethod.HP_LOGIN_USER,"HP_LOGIN_USER"));
            hpUploadVideos.setOnAction(e -> handleAction(ExecMethod.HP_UPLOAD_VIDEO,"HP_UPLOAD_VIDEO"));

            //HEADER
            comboBox.setOnAction(e -> handleComboBoxAction());
            stopTestCase.setOnAction(event -> handleStopTestCase());
            removeQueue.setOnAction(event -> actionEliminarDeLaCola());
            botConfigurations.setOnAction( event -> handleBotConfigurations(event));
        }, "interfaceThread");
        if(isRunning) {
            methods.startTest();
            methods.startContextAndNavigation();
            interfaceThread.start();
        }
        execute.setOnAction(e -> {
            Thread execute = new Thread(() -> {
                executionDetails = tfExecute.getText();
                accion();
            }, "execute");
            if (isRunning) {
                //methods.startTest();
                execute.start();
            }
        });
    }
    private void stopExecuteThread() {
        isRunning = false; // Establecer la bandera para detener el hilo
        // Lógica adicional para finalizar cualquier tarea o limpieza necesaria
    }
    private void cleanWaitingList(){
        waitingList.clear();
        userEmail = null;
        resourceType = "";
    }
    public void accion () {
        for (int i = 0; i < waitingList.size(); i++) {
            Arla.InterfaceActions.ExecMethod var = waitingList.get(i);
            switch (var) {
                //CASE CREATION
                case HP_LOGIN_USER:
                    actionHpLogin();
                    break;
                case HP_UPLOAD_VIDEO:
                    actionHpUploadVideo();
                    break;
            }
            if (!isRunning) {
                cleanWaitingList();
                return;
            }
        }
        cleanWaitingList();
    }
    //HANDLERS
    private void handleAction(Arla.InterfaceActions.ExecMethod methods, String checkBoxText) {
        waitingList.add(methods);
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
                Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                double x = ownerStage.getX();
                double y = ownerStage.getY();
                // Posicionar la ventana B relativa a la ventana A
                configAvanzadaStage.setX(x + 50);
                configAvanzadaStage.setY(y + 50);
                configAvanzadaStage.setOnHiding(e->{
                    cleanWaitingList();
                });
                configAvanzadaStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void handleResourceAction(Arla.InterfaceActions.ExecMethod methods, String checkBoxText) {
        resourceType = "Upload file";
        handleAction(methods, checkBoxText);
    }
    /*private void handleResourceSecondaryClick(MouseEvent event, Arla.InterfaceActions.ExecMethod methods) {
        if (event.isSecondaryButtonDown()) {
            executionDetails = tfExecute.getText();
            try {
                AdvancedSettingValidationResources configAvanzada = new AdvancedSettingValidationResources(
                        executionDetails, seleccion, value -> {
                    VariablesDocola.resourceType = value;
                    waitingList.add(methods);
                    Platform.runLater(this::accion);
                });
                Stage configAvanzadaStage = new Stage();
                configAvanzada.start(configAvanzadaStage);
                Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                double x = ownerStage.getX();
                double y = ownerStage.getY();
                // Posicionar la ventana B relativa a la ventana A
                configAvanzadaStage.setX(x + 50);
                configAvanzadaStage.setY(y + 50);
                configAvanzadaStage.setOnHiding(e->{
                    cleanWaitingList();
                });
                configAvanzadaStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
    private void handleComboBoxAction() {
        seleccion = comboBox.getValue();
        /*if ("Local".equals(seleccion)) {
            VariablesArla.navigationLink = "http://localhost:4200/";
        }
        if ("QA".equals(seleccion)) {
            VariablesArla.navigationLink = "https://docola-qa.web.app/";
        }*/
        if ("DEV".equals(seleccion)) {
            VariablesArla.navigationLink = "https://arla-cms-dev.web.app/login";
        }
    }
    private void handleStopTestCase() {
        methods.stopTest();
        System.out.println("La ejecucion se detendra al final de la actual iteracion");
        outputStream.println("La ejecucion se detendra al final de la actual iteracion");
        stopExecuteThread();
    }
    private void handleBotConfigurations(ActionEvent event) {
        try {
            BotModalConfigs configAvanzada = new BotModalConfigs(seleccion);
            Stage botSettingsStage = new Stage();
            configAvanzada.start(botSettingsStage);
            Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double x = ownerStage.getX();
            double y = ownerStage.getY();
            // Posicionar la ventana B relativa a la ventana A
            botSettingsStage.setX(x + 50);
            botSettingsStage.setY(y + 50);
            botSettingsStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
