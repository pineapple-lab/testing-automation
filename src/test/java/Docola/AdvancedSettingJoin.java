package Docola;
import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.resourceType;
import static InsumosDocola.VariablesDocola.userEmail;

public class AdvancedSettingJoin extends InterfaceElements {
    private volatile boolean isRunning = true;
    Label labelRol = new Label ("Rol");
    TextField tfRol = new TextField();
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbjoinRol = new Tab();
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    public AdvancedSettingJoin(String executionDetailsAvanzadas , String seleccionAvanzada){

        this.vDocola.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuraciones registro");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        gridPaneJoin.add(labelRol,2,1);
        gridPaneJoin.add(tfRol,2,2);
        gridPaneJoin.add(settingAdvancedExecute,5,5);
        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        tfRol.setPromptText("Introducir rol");
        tbjoinRol.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbjoinRol);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageJoin.setScene(sceneConfigAvanzada);
        settingAdvancedExecute.setOnAction(e->{
            Thread execute=  new Thread (()->{
              VariablesDocola.userRole = tfRol.getText();
              iActions.actionJoin();
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

}
