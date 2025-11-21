package Arla;
import InsumosArla.MethodsArla;
import static InsumosArla.VariablesArla.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;
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
        stage1.setTitle("LMS bot");
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
            hpCreateCourses.setOnAction(e -> handleAction(ExecMethod.HP_CREATE_COURSE,"HP_CREATE_COURSE"));
            hpCreateCategory.setOnAction(e -> handleAction(ExecMethod.HP_CREATE_CATEGORY,"HP_CREATE_CATEGORY"));
            hpInviteClient.setOnAction(e -> handleAction(ExecMethod.HP_INVITE_CLIENT,"HP_INVITE_CLIENT"));
            //HEADER
            comboBox.setOnAction(e -> handleComboBoxAction());
            stopTestCase.setOnAction(event -> handleStopTestCase());
            removeQueue.setOnAction(event -> actionEliminarDeLaCola());
            botConfigurations.setOnAction( event -> handleBotConfigurations(event));
        }, "interfaceThread");
        if(isRunning) {
            methods.startTest();
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
            navigationLink = "https://thezone-dev.web.app/login";
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
            Arla.BotModalConfigs configAvanzada = new BotModalConfigs(seleccion);
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
                case HP_CREATE_COURSE:
                    actionHpCreateCourse();
                    break;
                case HP_CREATE_CATEGORY:
                    actionHpCreateCategory();
                    break;
                case HP_INVITE_CLIENT:
                    actionHpInviteClient();
                    break;
            }
            if (!isRunning) {
                cleanWaitingList();
                return;
            }
        }
        cleanWaitingList();
    }
}
