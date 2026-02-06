package Spacelogik;
import Docola.BotModalConfigs;
import InsumosDocola.VariablesDocola;
import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.VariablesSpacelogik;
import com.cedarsoft.unit.si.V;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import static InsumosSpacelogik.VariablesSpacelogik.*;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;

public class BotSpacelogik extends Spacelogik.InterfaceActions {
    private volatile boolean isRunning = true;
    private MethodsSpacelogik methods= new MethodsSpacelogik();

        public static void main(String[] args) {
            //String path = BotDocola.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            //System.out.println(path);
            launch(BotSpacelogik.class, args);
        }
        private void appendText(String text) {
            Platform.runLater(() -> consoleTextArea.appendText(text));
        }
        @Override
        public void start(Stage stage1) {
            super.start(stage1);
            stage1.setTitle("SpaceLogik bot");
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

                //HAPPY PATH BUTTONS
                loginHappyPath.setOnAction(e -> handleAction(ExecMethod.LOGIN_HP,"LOGIN_HP"));
                createReCompanieHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATERECOMPANIE_HP,"CREATERECOMPANIE_HP"));
                createNationalAccountHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATENATIONALACCOUNT_HP,"CREATENATIONALACCOUNT_HP"));
                createGuruHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATEGURU_HP,"CREATEGURU_HP"));
                createClientHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATECLIENT_HP,"CREATECLIENT_HP"));
                createOfficeHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATEOFFICE_HP,"CREATEOFFICE_HP"));
                createLocationHapyPath.setOnAction(e -> handleAction(ExecMethod.CREATELOCATION_HP,"CREATELOCATION_HP"));

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
    private void handleComboBoxAction() {
        seleccion = comboBox.getValue();
        if ("Local".equals(seleccion)) {
            VariablesSpacelogik.navigationLink = "http://localhost:4200/";
        }
        if ("DEV".equals(seleccion)) {
            VariablesSpacelogik.navigationLink = "https://spacelogic-development.web.app/";
        }
        if ("PROD".equals(seleccion)) {
            VariablesSpacelogik.navigationLink = "https://space-logic.web.app/";
        }
    }
        private void stopExecuteThread() {
            isRunning = false; // Establecer la bandera para detener el hilo

            // Lógica adicional para finalizar cualquier tarea o limpieza necesaria
        }
        private void handleAction(Spacelogik.InterfaceActions.ExecMethod method, String checkBoxText) {
            waitingList.add(method);
            Enum elemento = waitingList.get(waitingList.size() - 1);
            CheckBox checkBox = new CheckBox(checkBoxText);
            checkBoxesMap.put(checkBox, elemento);
            gridCola.add(checkBox, 0, waitingList.size() - 1);
        }
        private void handleResourceAction(Spacelogik.InterfaceActions.ExecMethod method, String checkBoxText) {
            handleAction(method, checkBoxText);
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
        private void cleanWaitingList(){
            waitingList.clear();
        }
        public void accion () {
            for (int i = 0; i < waitingList.size(); i++) {
                Spacelogik.InterfaceActions.ExecMethod var = waitingList.get(i);
                switch (var) {
                    //HAPPY PATH CASE
                    case LOGIN_HP:
                        actionHpLogin();
                        break;
                    case CREATERECOMPANIE_HP:
                        actionHpCreateReCompanie();
                        break;
                    case CREATENATIONALACCOUNT_HP:
                        actionHpCreateNationalAccount();
                        break;
                    case CREATEGURU_HP:
                        actionHpCreateGuru();
                        break;
                    case CREATECLIENT_HP:
                        actionHpCreateClient();
                        break;
                    case CREATEOFFICE_HP:
                        actionHpCreateOffice();
                    case CREATELOCATION_HP:
                        actionHpCreateLocation();
                }
                if (!isRunning) {
                    cleanWaitingList();
                    return;
                }
            }
            cleanWaitingList();
        }
    }

