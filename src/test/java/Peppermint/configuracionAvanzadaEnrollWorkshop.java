package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaEnrollWorkshop extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaEnrollWorkshop(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageEnrollWorkshopAvanzado) {
        stageEnrollWorkshopAvanzado.setTitle("Configuracion avanzada enroll workshop");
        GridPane gridPaneEnrolLWorkshopAvanzado = new GridPane();
        gridPaneEnrolLWorkshopAvanzado.setVgap(10);
        gridPaneEnrolLWorkshopAvanzado.setHgap(10);
        gridPaneEnrolLWorkshopAvanzado.add(labelModalityEnrollWorkshopAvanzado,2,1);
        gridPaneEnrolLWorkshopAvanzado.add(textFieldModalityEnrollWorkshopAvanzado,2,2);
        gridPaneEnrolLWorkshopAvanzado.add(buttonEjecutarEnrollWorkshopAvanzado,5,5);
        tabEnrollWorkshopAvanzado.setContent(gridPaneEnrolLWorkshopAvanzado);
        tabPane.getTabs().addAll(tabEnrollWorkshopAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,450,350);
        stageEnrollWorkshopAvanzado.setScene(sceneConfigAvanzada);
        buttonEjecutarEnrollWorkshopAvanzado.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                enrollModality=textFieldModalityEnrollWorkshopAvanzado.getText();
                actionEnrollWorkshop();
                enrollModality="groupwithinstructor";
            }, "ejecutar");
            if(ejecutar.isAlive()) {
                ejecutar.stop();
            }else {
                metodosPeppermint.iniciarTest();
                ejecutar.start();
            }
        });
    }
}

