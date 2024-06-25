package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import insumosPeppermint.variablesPeppermint;
public class configuracionAvanzadaEnrollClub extends interfaceActions{
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaEnrollClub(String executionDetailsAvanzadas , String seleccionAvanzada){
        this.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageConfiguracionAvanzadaEnrollMultiClub) {
        GridPane gridPaneConfigAvanzadaEnrollMultiClub = new GridPane();
        gridPaneConfigAvanzadaEnrollMultiClub.setHgap(10);
        gridPaneConfigAvanzadaEnrollMultiClub.setVgap(10);
        gridPaneConfigAvanzadaEnrollMultiClub.add(labelEmailEnrollMultiClubAvanzado,2,1);
        gridPaneConfigAvanzadaEnrollMultiClub.add(textFieldEmailEnrollMultiClubAvanzado,2,2);
        gridPaneConfigAvanzadaEnrollMultiClub.add(buttonexecuteEnrollMultiClubAvanzado,5,5);
        buttonexecuteEnrollMultiClubAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabEnrollMultiClubAvanzado.setContent(gridPaneConfigAvanzadaEnrollMultiClub);
        tabPane.getTabs().addAll(tabEnrollMultiClubAvanzado);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,270,160);
        stageConfiguracionAvanzadaEnrollMultiClub.setScene(sceneConfigAvanzada);
        buttonexecuteEnrollMultiClubAvanzado.setOnAction(e->{
            Thread execute=  new Thread (()->{
                variablesPeppermint.emailUserUnirMultiplesClub=textFieldEmailEnrollMultiClubAvanzado.getText();
                actionJoinMultiplesClubs();
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
