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

import static InsumosDocola.VariablesDocola.ejecuciones;

public class AdvancedSettingContentCreator extends InterfaceElements {
    Label labelTypeContent = new Label ("Tipo de contenido");
    TextField tfTypeContent = new TextField();
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbjoinRol = new Tab();
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    public AdvancedSettingContentCreator(String ejecucionesAvanzadas , String seleccionAvanzada){

        this.vDocola.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuracion avanzada enroll workshop");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        gridPaneJoin.add(labelTypeContent,2,1);
        gridPaneJoin.add(tfTypeContent,2,2);
        gridPaneJoin.add(settingAdvancedExecute,5,5);
        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        tfTypeContent.setPromptText("Introducir contenido");
        tbjoinRol.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbjoinRol);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageJoin.setScene(sceneConfigAvanzada);
        settingAdvancedExecute.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.typeContent = tfTypeContent.getText();
                iActions.actionNewContent();
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
