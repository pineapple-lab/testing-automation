package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaEnrollWorkshop extends interfaceActions{
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaEnrollWorkshop(String executionDetailsAvanzadas , String seleccionAvanzada){
        this.executionDetails = executionDetailsAvanzadas;
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
        gridPaneEnrolLWorkshopAvanzado.add(buttonexecuteEnrollWorkshopAvanzado,2,5);
        gridPaneEnrolLWorkshopAvanzado.add(ayuda,5,5);
        cuadroDeAyudas.setEditable(false);
        cuadroDeAyudas.setText("PARA ELEGIR UNA MODALITY ESPECIFICA PARA QUE SE ENROLEN LOS O EL USUARIO \n 1-Introducir en 'modality' una de las tres siguientes opciones: 'solo', 'groupwithinstructor' o 'group' \n 2-Luego de introducir solo una de estas opciones presionar 'execute'");
        ayuda.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        buttonexecuteEnrollWorkshopAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabEnrollWorkshopAvanzado.setContent(gridPaneEnrolLWorkshopAvanzado);
        tabPane.getTabs().addAll(tabEnrollWorkshopAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        dialog.getDialogPane().setContent(cuadroDeAyudas);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,247,205);
        stageEnrollWorkshopAvanzado.setScene(sceneConfigAvanzada);
        ayuda.setOnAction(e->{
            dialog.show();
        });
        buttonexecuteEnrollWorkshopAvanzado.setOnAction(e->{
            Thread execute=  new Thread (()->{
                enrollModality=textFieldModalityEnrollWorkshopAvanzado.getText();
                actionEnrollWorkshop();
                enrollModality="groupwithinstructor";
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

