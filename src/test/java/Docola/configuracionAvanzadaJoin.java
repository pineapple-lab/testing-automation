package Docola;
import InsumosDocola.methodsDocola;
import InsumosDocola.variablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Docola.interfaceActions;
public class configuracionAvanzadaJoin extends interfaceElements {
    Label labelRol = new Label ("rol");
    TextField tfRol = new TextField("introducir rol");
    Button btnRol = new Button("Ejecutar");
    Tab tbjoinRol = new Tab();
    methodsDocola mDocola = new methodsDocola();
    variablesDocola vDocola = new variablesDocola();
    interfaceActions iActions = new interfaceActions();
    public configuracionAvanzadaJoin(String ejecucionesAvanzadas , String seleccionAvanzada){

        this.vDocola.ejecuciones = Integer.parseInt(ejecucionesAvanzadas);
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuracion avanzada enroll workshop");
        GridPane gridPaneJoin = new GridPane();
        gridPaneJoin.setVgap(10);
        gridPaneJoin.setHgap(10);
        gridPaneJoin.add(labelRol,2,1);
        gridPaneJoin.add(tfRol,2,2);
        gridPaneJoin.add(btnRol,5,5);
        btnRol.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        tbjoinRol.setContent(gridPaneJoin);
        tabPane.getTabs().addAll(tbjoinRol);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageJoin.setScene(sceneConfigAvanzada);
        btnRol.setOnAction(e->{
            Thread execute=  new Thread (()->{
              variablesDocola.joinRol = tfRol.getText();
              System.out.println(vDocola.joinRol);
              iActions.actionJoin();
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
