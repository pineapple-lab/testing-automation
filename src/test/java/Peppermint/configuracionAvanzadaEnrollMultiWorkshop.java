package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaEnrollMultiWorkshop extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaEnrollMultiWorkshop(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageEnrollMultiWorkshopAvanzado) {
        stageEnrollMultiWorkshopAvanzado.setTitle("Configuracion avanzada enroll workshop");
        GridPane gridPaneEnrolLMultiWorkshopAvanzado = new GridPane();
        gridPaneEnrolLMultiWorkshopAvanzado.setVgap(10);
        gridPaneEnrolLMultiWorkshopAvanzado.setHgap(10);
        gridPaneEnrolLMultiWorkshopAvanzado.add(labelEmailEnrollMultiWorkshopAvanzado,2,1);
        gridPaneEnrolLMultiWorkshopAvanzado.add(textFieldEmailEnrollMultiWorkshopAvanzado,2,2);
        gridPaneEnrolLMultiWorkshopAvanzado.add(buttonEjecutarEnrollMultiWorkshopAvanzado,5,5);
        tabEnrollMultiWorkshopAvanzado.setContent(gridPaneEnrolLMultiWorkshopAvanzado);
        tabPane.getTabs().addAll(tabEnrollMultiWorkshopAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,450,350);
        stageEnrollMultiWorkshopAvanzado.setScene(sceneConfigAvanzada);
        buttonEjecutarEnrollMultiWorkshopAvanzado.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                emailUserEnrollMultiplesWorkshops=textFieldEmailEnrollMultiWorkshopAvanzado.getText();
                actionEnrollMultiplesWorkshops();
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
