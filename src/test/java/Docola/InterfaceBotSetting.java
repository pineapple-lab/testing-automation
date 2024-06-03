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

public class InterfaceBotSetting extends InterfaceElements {
    Label labelEmail = new Label ("Userdefined");
    TextField tfEmail = new TextField();
    Button settingSave = new Button("Guardar");
    Tab tbUndefinedEmail = new Tab();
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    public InterfaceBotSetting(String environment){
        this.seleccion = environment;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Bot configuration");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        gridPaneJoin.add(labelEmail,2,1);
        gridPaneJoin.add(tfEmail,2,2);
        gridPaneJoin.add(settingSave,5,5);
        settingSave.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingSave.setOnMouseEntered(e -> settingSave.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingSave.setOnMouseExited(e -> settingSave.setStyle("-fx-background-color: #5bb346;"));
        tfEmail.setPromptText("Userdefined");
        tbUndefinedEmail.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbUndefinedEmail);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageJoin.setScene(sceneConfigAvanzada);
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.joinRol = "Content provider";
                VariablesDocola.email = tfEmail.getText();
                System.out.println(VariablesDocola.email);
                iActions.actionUpdateUndefinedUser(VariablesDocola.email);
            }, "execute");
            if(execute.isAlive()) {
                execute.stop();
            }else {
                mDocola.startTest();
                execute.start();
            }
        });
    }
}
