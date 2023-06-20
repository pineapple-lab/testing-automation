package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import insumosPeppermint.variablesPeppermint;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaSendRecomendaciones extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaSendRecomendaciones(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    public void start(Stage configAvanzadaSendFriendsStage){
        configAvanzadaSendFriendsStage.setTitle("Configuracion avanzada send recommendations");
        GridPane gridPaneEnviarRecomendaciones = new GridPane();
        gridPaneEnviarRecomendaciones.setHgap(3);
        gridPaneEnviarRecomendaciones.setVgap(10);
        gridPaneEnviarRecomendaciones.add(labelEnviarRecomendaciones,1,1);
        gridPaneEnviarRecomendaciones.add(introducirUsuarioRecomend,3,1);
        gridPaneEnviarRecomendaciones.add(checkBoxEditarEmisor, 1,2);
        gridPaneEnviarRecomendaciones.add(introducirEmisorRecomendaciones,3,2);
        gridPaneEnviarRecomendaciones.add(ejecutarSendRecomendations,8,5);
        tabSendRecommendationConfigAvanzada.setContent(gridPaneEnviarRecomendaciones);
        tabPane.getTabs().addAll(tabSendRecommendationConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,400,300);
        configAvanzadaSendFriendsStage.setScene(configAvanzadaScene);
        introducirEmisorRecomendaciones.setVisible(false);
        checkBoxEditarEmisor.setOnAction(actionEvent -> {
            if (checkBoxEditarEmisor.isSelected()){
                introducirEmisorRecomendaciones.setVisible(true);
            }else {
                introducirEmisorRecomendaciones.setVisible(false);
            }
        });
        ejecutarSendRecomendations.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                if (checkBoxEditarEmisor.isSelected()){
                    emailRecomendationSending = introducirEmisorRecomendaciones.getText();
                    emailuserSendRecomendation = emailRecomendationSending;
                }else {
                    emailRecomendationSending = "pineappleuser1684524360203@mailinator.com";
                }
                userSendRecomendation = introducirUsuarioRecomend.getText();
                actionSendRecomendation();
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

