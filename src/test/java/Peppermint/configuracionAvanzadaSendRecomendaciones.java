package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaSendRecomendaciones extends interfaceActions{
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaSendRecomendaciones(String executionDetailsAvanzadas , String seleccionAvanzada){
        this.executionDetails = executionDetailsAvanzadas;
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
        gridPaneEnviarRecomendaciones.add(executeSendRecomendations,8,5);
        executeSendRecomendations.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabSendRecommendationConfigAvanzada.setContent(gridPaneEnviarRecomendaciones);
        tabPane.getTabs().addAll(tabSendRecommendationConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,370,170);
        configAvanzadaSendFriendsStage.setScene(configAvanzadaScene);
        introducirEmisorRecomendaciones.setVisible(false);
        checkBoxEditarEmisor.setOnAction(actionEvent -> {
            if (checkBoxEditarEmisor.isSelected()){
                introducirEmisorRecomendaciones.setVisible(true);
            }else {
                introducirEmisorRecomendaciones.setVisible(false);
            }
        });
        executeSendRecomendations.setOnAction(e->{
            Thread execute=  new Thread (()->{
                if (checkBoxEditarEmisor.isSelected()){
                    emailRecomendationSending = introducirEmisorRecomendaciones.getText();
                    emailuserSendRecomendation = emailRecomendationSending;
                }else {
                    emailRecomendationSending = "pineappleuser1684524360203@mailinator.com";
                }
                userSendRecomendation = introducirUsuarioRecomend.getText();
                actionSendRecomendation();
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

