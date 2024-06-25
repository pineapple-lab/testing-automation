package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaEnrollMultiWorkshop extends interfaceActions{
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaEnrollMultiWorkshop(String executionDetailsAvanzadas , String seleccionAvanzada){
        this.executionDetails = executionDetailsAvanzadas;
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
        gridPaneEnrolLMultiWorkshopAvanzado.add(buttonexecuteEnrollMultiWorkshopAvanzado,5,5);
        buttonexecuteEnrollMultiWorkshopAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabEnrollMultiWorkshopAvanzado.setContent(gridPaneEnrolLMultiWorkshopAvanzado);
        tabPane.getTabs().addAll(tabEnrollMultiWorkshopAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,170);
        stageEnrollMultiWorkshopAvanzado.setScene(sceneConfigAvanzada);
        buttonexecuteEnrollMultiWorkshopAvanzado.setOnAction(e->{
            Thread execute=  new Thread (()->{
                emailUserEnrollMultiplesWorkshops=textFieldEmailEnrollMultiWorkshopAvanzado.getText();
                actionEnrollMultiplesWorkshops();
            }, "execute");
            if(execute.isAlive()) {
                execute.stop();
            }else {
                metodosPeppermint.iniciarTest();
                execute.start();
            }
        });
    }
}
