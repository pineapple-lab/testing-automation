package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.resourceType;
import static InsumosDocola.VariablesDocola.userEmail;

public class BotConfigs extends InterfaceElements {
    private volatile boolean isRunning = true;
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    ComboBox<String> comboBox = new ComboBox<>();
    Button settingSave = new Button("Guardar");

    public void start (Stage botSettings){
        GridPane gridBotSettings = new GridPane();
        gridBotSettings.setVgap(10);
        gridBotSettings.setHgap(10);
        gridBotSettings.add(settingSave,5,2);
        gridBotSettings.getChildren().add(comboBox);
        comboBox.setOnAction(e -> handleComboBoxAction());
        comboBox.getItems().add("chrome");
        comboBox.getItems().add("chromium");
        //comboBox.getItems().add("firefox");
        comboBox.setValue("Elegir browser");
        settingSave.setStyle("-fx-background-color:#298dcc;");
        settingSave.setOnMouseEntered(e -> settingSave.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        settingSave.setOnMouseExited(e -> settingSave.setStyle("-fx-background-color: #298dcc;"));
        rootConfigAvanzada.getChildren().add(gridBotSettings);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,199,170);
        botSettings.setScene(sceneConfigAvanzada);
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                handleComboBoxAction();
                cleanWaitingList();
            }, "execute");
            if(isRunning) {
                mDocola.startTest();
                execute.start();
            }
        });
    }
    private void cleanWaitingList(){
        waitingList.clear();
        userEmail = null;
        resourceType = "";
    }
    private void handleComboBoxAction() {
        seleccion = comboBox.getValue();
        if ("chrome".equals(seleccion)) {
            VariablesDocola.setChannel = "chrome";
        }
        if ("chromium".equals(seleccion)) {
            VariablesDocola.setChannel = "chromium";
        }
        //if ("firefox".equals(seleccion)) {
          //  VariablesDocola.setChannel = "firefox";
        //}
    }
}
