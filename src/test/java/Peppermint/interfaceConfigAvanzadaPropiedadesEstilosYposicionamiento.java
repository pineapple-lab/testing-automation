package Peppermint;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.userSendRecomendation;

public class interfaceConfigAvanzadaPropiedadesEstilosYposicionamiento extends interfaceActions{
    public interfaceConfigAvanzadaPropiedadesEstilosYposicionamiento(String ejecuciones, String seleccion){
        this.ejecuciones=ejecuciones;
        this.seleccion=seleccion;
    }
    public void start(Stage configAvanzadaStage){
        configAvanzadaStage.setTitle("Configuracion avanzada");

        GridPane gridPaneEnviarAmigos = new GridPane();
        gridPaneEnviarAmigos.setHgap(3);
        gridPaneEnviarAmigos.setVgap(10);
        gridPaneEnviarAmigos.add(labelEnviarAmigos,1,1);
        gridPaneEnviarAmigos.add(introducirUsuarioFriends,3,1);
        gridPaneEnviarAmigos.add(ejecutarSendFriends,10,5);
        tabSendFriendsConfigAvanzada.setContent(gridPaneEnviarAmigos);

        GridPane gridPaneEnviarRecomendaciones = new GridPane();
        gridPaneEnviarRecomendaciones.setHgap(3);
        gridPaneEnviarRecomendaciones.setVgap(10);
        gridPaneEnviarRecomendaciones.add(labelEnviarRecomendaciones,1,1);
        gridPaneEnviarRecomendaciones.add(introducirUsuarioRecomend,3,1);
        gridPaneEnviarRecomendaciones.add(ejecutarSendRecomendations,8,5);
        tabSendRecommendationConfigAvanzada.setContent(gridPaneEnviarRecomendaciones);

        tabPane.getTabs().addAll(tabSendFriendsConfigAvanzada, tabSendRecommendationConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,400,300);
        configAvanzadaStage.setScene(configAvanzadaScene);
        ejecutarSendRecomendations.setOnAction(e->{
            System.out.print(ejecuciones);
            userSendRecomendation = introducirUsuarioRecomend.getText();
            actionSendRecomendation();
        });
    }
}
