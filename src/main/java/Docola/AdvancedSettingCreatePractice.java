package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.resourceType;
import static InsumosDocola.VariablesDocola.userEmail;
import static java.lang.Integer.parseInt;

public class AdvancedSettingCreatePractice extends InterfaceElements{
    private volatile boolean isRunning = true;
    RadioButton addMembers = new RadioButton("Add members");
    ComboBox<String> comboBox = new ComboBox<>();
    TextField tfMembersAmount = new TextField();
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbjoinRol = new Tab();
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    public AdvancedSettingCreatePractice(String executionDetailsAvanzadas , String seleccionAvanzada){

        this.vDocola.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuraciones practice");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        comboBox.getItems().add("Admin");
        comboBox.getItems().add("Content creator");
        comboBox.getItems().add("Staff");
        comboBox.setValue("Choose role");
        gridPaneJoin.add(addMembers,2,1);
        gridPaneJoin.add(comboBox,3,1);
        gridPaneJoin.add(tfMembersAmount,2,3);
        GridPane.setColumnSpan(tfMembersAmount, 3);
        gridPaneJoin.add(settingAdvancedExecute,2,6);
        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        tfMembersAmount.setPromptText("Amount members");
        tbjoinRol.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbjoinRol);
        rootConfigAvanzada.getChildren().add(tabPane);
        comboBox.setOnAction(e -> handleComboBoxAction());
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,295,220);
        stageJoin.setScene(sceneConfigAvanzada);
        addMembers.setOnAction(e->{
            if(addMembers.isSelected()){
                vDocola.addMembers =true;
            }else if(addMembers.isDisabled()){
                vDocola.addMembers =false;
            }
        });
        settingAdvancedExecute.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.membersAmount = parseInt(tfMembersAmount.getText());
                iActions.actionNewPractice();
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
        if ("Admin".equals(seleccion)) {
            VariablesDocola.practiceRol = 1;
        }
        if ("Content creator".equals(seleccion)) {
            VariablesDocola.practiceRol = 2;
        }
        if ("Staff".equals(seleccion)) {
            VariablesDocola.practiceRol = 3;
        }
    }

}
