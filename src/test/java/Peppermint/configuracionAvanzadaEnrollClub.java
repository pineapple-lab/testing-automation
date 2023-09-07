package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import insumosPeppermint.variablesPeppermint;
public class configuracionAvanzadaEnrollClub extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaEnrollClub(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageConfiguracionAvanzadaEnrollMultiClub) {
        GridPane gridPaneConfigAvanzadaEnrollMultiClub = new GridPane();
        gridPaneConfigAvanzadaEnrollMultiClub.setHgap(10);
        gridPaneConfigAvanzadaEnrollMultiClub.setVgap(10);
        gridPaneConfigAvanzadaEnrollMultiClub.add(labelEmailEnrollMultiClubAvanzado,2,1);
        gridPaneConfigAvanzadaEnrollMultiClub.add(textFieldEmailEnrollMultiClubAvanzado,2,2);
        gridPaneConfigAvanzadaEnrollMultiClub.add(buttonEjecutarEnrollMultiClubAvanzado,5,5);
        buttonEjecutarEnrollMultiClubAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabEnrollMultiClubAvanzado.setContent(gridPaneConfigAvanzadaEnrollMultiClub);
        tabPane.getTabs().addAll(tabEnrollMultiClubAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,160);
        stageConfiguracionAvanzadaEnrollMultiClub.setScene(sceneConfigAvanzada);
        buttonEjecutarEnrollMultiClubAvanzado.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                variablesPeppermint.emailUserUnirMultiplesClub=textFieldEmailEnrollMultiClubAvanzado.getText();
                actionJoinMultiplesClubs();
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
