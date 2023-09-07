package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import insumosPeppermint.variablesPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class configuracionAvanzadaSendFriends extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaSendFriends(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    public void start(Stage configAvanzadaSendFriendsStage){
        configAvanzadaSendFriendsStage.setTitle("Configuracion avanzada send friends");
        GridPane gridPaneEnviarAmigos = new GridPane();
        gridPaneEnviarAmigos.setHgap(3);
        gridPaneEnviarAmigos.setVgap(10);
        gridPaneEnviarAmigos.add(labelUserSendFriends,1,1);
        gridPaneEnviarAmigos.add(userSendFriends,3,1);
        gridPaneEnviarAmigos.add(labelEmailAceptarAmigos,1,2);
        gridPaneEnviarAmigos.add(emailAceptarFriends,3,2);
        gridPaneEnviarAmigos.add(ejecutarSendFriends,10,5);
        ejecutarSendFriends.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabSendFriendsConfigAvanzada.setContent(gridPaneEnviarAmigos);
        tabPane.getTabs().addAll(tabSendFriendsConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,330,180);
        configAvanzadaSendFriendsStage.setScene(configAvanzadaScene);
        ejecutarSendFriends.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                variablesPeppermint.emailAceptarSolicitudesDeAmistad = emailAceptarFriends.getText();
                variablesPeppermint.userSendFriends=userSendFriends.getText();
                actionSendFriendRequest();
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
