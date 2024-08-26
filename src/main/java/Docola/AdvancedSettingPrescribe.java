package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.resourceType;
import static InsumosDocola.VariablesDocola.userEmail;
import static java.lang.Integer.parseInt;

public class AdvancedSettingPrescribe extends InterfaceElements{
    private volatile boolean isRunning = true;
    Label labelAmountContent = new Label ("Amount content");
    Label labelAmountInvite = new Label ("Amount invite");
    TextField tfAmountContent = new TextField();
    TextField tfAmountInvite = new TextField();
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbjoinRol = new Tab();
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    BotDocola accion = new BotDocola();
    public AdvancedSettingPrescribe(String executionDetailsAvanzadas , String seleccionAvanzada){

        this.vDocola.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Prescribe configuration");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        gridPaneJoin.add(labelAmountContent,2,1);
        gridPaneJoin.add(tfAmountContent,2,2);
        gridPaneJoin.add(labelAmountInvite,2,3);
        gridPaneJoin.add(tfAmountInvite,2,4);
        gridPaneJoin.add(settingAdvancedExecute,5,5);
        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        tfAmountContent.setPromptText("Enter amount of content");
        tfAmountInvite.setPromptText("Enter amount of invite");
        tbjoinRol.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbjoinRol);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageJoin.setScene(sceneConfigAvanzada);
        settingAdvancedExecute.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.contentAmount = parseInt(tfAmountContent.getText());
                VariablesDocola.inviteAmount = parseInt(tfAmountInvite.getText());
                iActions.actionNewPrescribe();
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
