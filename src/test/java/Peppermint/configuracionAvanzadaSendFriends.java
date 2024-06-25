package Peppermint;

import insumosPeppermint.methodsPeppermint;
import insumosPeppermint.variablesPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class configuracionAvanzadaSendFriends extends interfaceActions{
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaSendFriends(String executionDetailsAvanzadas , String seleccionAvanzada){
        this.executionDetails = executionDetailsAvanzadas;
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
        gridPaneEnviarAmigos.add(executeSendFriends,10,5);
        executeSendFriends.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabSendFriendsConfigAvanzada.setContent(gridPaneEnviarAmigos);
        tabPane.getTabs().addAll(tabSendFriendsConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,330,180);
        configAvanzadaSendFriendsStage.setScene(configAvanzadaScene);
        executeSendFriends.setOnAction(e->{
            Thread execute=  new Thread (()->{
                variablesPeppermint.emailAcceptFriendRequests = emailAceptarFriends.getText();
                variablesPeppermint.userSendFriends=userSendFriends.getText();
                actionSendFriendRequest();
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
