package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import insumosPeppermint.variablesPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class configuracionAvanzadaBookmark extends interfaceActions {
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaBookmark(String ejecucionesAvanzadas, String seleccionAvanzada) {
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }

    @Override
    public void start(Stage stageConfigurcionAvanzadaBookmark) {
        stageConfigurcionAvanzadaBookmark.setTitle("Configuracion avanzad Bookmark");
        GridPane gridPaneConfiguracionAvanzadaBookmark = new GridPane();
        gridPaneConfiguracionAvanzadaBookmark.setVgap(10);
        gridPaneConfiguracionAvanzadaBookmark.setHgap(10);
        gridPaneConfiguracionAvanzadaBookmark.add(labelMultiBookmark,2,1);
        gridPaneConfiguracionAvanzadaBookmark.add(textFieldEmailMultiBookmark,2,2);
        gridPaneConfiguracionAvanzadaBookmark.add(buttonEjecutarMultiBookmark,5,5);
        buttonEjecutarMultiBookmark.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabMultiBookmark.setContent(gridPaneConfiguracionAvanzadaBookmark);
        tabPane.getTabs().addAll(tabMultiBookmark);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configuracionAvanzada = new Scene(rootConfigAvanzada,265,170);
        stageConfigurcionAvanzadaBookmark.setScene(configuracionAvanzada);
        buttonEjecutarMultiBookmark.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                variablesPeppermint.emailUserBookmark=textFieldEmailMultiBookmark.getText();
                actionSaveBookmark();
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
