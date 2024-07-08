package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import clojure.lang.IFn;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

import static InsumosDocola.VariablesDocola.*;

public class BotConfigs extends InterfaceElements {
    private volatile boolean isRunning = true;
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    ComboBox<String> comboBox = new ComboBox<>();
    Button settingSave = new Button("Guardar");
    Label labelSetBrowser = new Label("Set browser");
    Label labelWindowsSize = new Label ("Windows size");
    TextField textFieldWidth = new TextField();
    TextField textFieldHeight = new TextField();
    Label labelHeadless = new Label("Set headless");
    RadioButton radioButtonFalseHeadless = new RadioButton("False");
    RadioButton radioButtonTrueHeadless = new RadioButton("True");
    Label labeSetSlowMotion = new Label("Set slowmotion");
    TextField textFieldSlowMotion = new TextField("");
    public void start (Stage botSettings){
        GridPane gridBotSettings = new GridPane();
        gridBotSettings.setVgap(10);
        gridBotSettings.setHgap(10);
        gridBotSettings.getChildren().add(comboBox);
        gridBotSettings.add(labelSetBrowser,2,2);
        GridPane.setColumnIndex(comboBox, 2);
        GridPane.setRowIndex(comboBox, 3);
        gridBotSettings.add(labelWindowsSize,2,5);
        gridBotSettings.add(textFieldWidth,2,6);
        gridBotSettings.add(textFieldHeight,2,7);
        gridBotSettings.add(labelHeadless,6,2);
        gridBotSettings.add(radioButtonFalseHeadless,6,3);
        gridBotSettings.add(radioButtonTrueHeadless,6,4);
        gridBotSettings.add(labeSetSlowMotion,6,5);
        gridBotSettings.add(textFieldSlowMotion,6,6);
        gridBotSettings.add(settingSave,6,8);
        comboBox.setOnAction(e -> handleComboBoxAction());
        comboBox.getItems().add("chrome");
        comboBox.getItems().add("chromium");
        //comboBox.getItems().add("firefox");
        comboBox.setValue("Elegir browser");
        settingSave.setStyle("-fx-background-color:#298dcc;");
        settingSave.setOnMouseEntered(e -> settingSave.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        settingSave.setOnMouseExited(e -> settingSave.setStyle("-fx-background-color: #298dcc;"));
        textFieldWidth.setPromptText("Width");
        textFieldHeight.setPromptText("Height");
        textFieldSlowMotion.setPromptText("Slowmotion");
        textFieldWidth.setText(String.valueOf(setSizeWidth));
        textFieldHeight.setText(String.valueOf(setSizeHeight));
        textFieldSlowMotion.setText(String.format("%.1f", setSlowMotion));
        radioButtonFalseHeadless.setSelected(true);
        rootConfigAvanzada.getChildren().add(gridBotSettings);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,400,300);
        botSettings.setScene(sceneConfigAvanzada);
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                handleComboBoxAction();
                handleTextField();
                handleRadioButtons();
                cleanWaitingList();
            }, "execute");
            if(isRunning) {
                mDocola.startTest();
                execute.start();
            }
            initializeComboBoxListener();
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
    private void handleTextField(){
        if(textFieldWidth.getText()!= null){
            setSizeWidth=Integer.parseInt(textFieldWidth.getText());
        }
        if(textFieldHeight.getText()!= null){
            setSizeHeight=Integer.parseInt(textFieldHeight.getText());
        }
        if(textFieldSlowMotion.getText()!= null){
            setSlowMotion=Double.parseDouble(textFieldSlowMotion.getText());
            String a = "UNPAPAQUE";
        }
    }
    private void handleRadioButtons(){
            if(radioButtonFalseHeadless.isSelected()){
                setHeadless =false;
            }
            if(radioButtonTrueHeadless.isSelected()){
                setHeadless =true;
            }
    }
    private String lastSelection = null;
    private void initializeComboBoxListener() {
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!Objects.equals(newValue, lastSelection)) {
                lastSelection = newValue;
                handleComboBoxAction();
            }
        });
    }

}
