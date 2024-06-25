package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import insumosPeppermint.variablesPeppermint;
public class configuracionAvanzadaEnviarInviteGuest extends interfaceActions {
    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaEnviarInviteGuest(String executionDetailsAvanzadas, String seleccionAvanzada) {
        this.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    public void start(Stage stageConfigAvanzadaSendGuest) {
        stageConfigAvanzadaSendGuest.setTitle("Configuracion avanzada Invite guest");
        GridPane gridPaneEnviarInviteGuest = new GridPane();
        gridPaneEnviarInviteGuest.setHgap(3);
        gridPaneEnviarInviteGuest.setVgap(10);
        gridPaneEnviarInviteGuest.add(labelEnviarInviteGuest, 1, 2);
        gridPaneEnviarInviteGuest.add(textFieldEmailInviteGuestAvanzado, 2, 2);
        gridPaneEnviarInviteGuest.add(executeInviteGuestAvanzado, 5, 5);
        executeInviteGuestAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabConfiguracionAvanzadaInviteGuest.setContent(gridPaneEnviarInviteGuest);
        tabPane.getTabs().addAll(tabConfiguracionAvanzadaInviteGuest);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada, 310, 150);
        stageConfigAvanzadaSendGuest.setScene(configAvanzadaScene);
        executeInviteGuestAvanzado.setOnAction(e -> {
            Thread execute = new Thread(() -> {
                variablesPeppermint.userEmailLoginInviteGuest = textFieldEmailInviteGuestAvanzado.getText();
                actionInviteGuest();
            }, "execute");
            if (execute.isAlive()) {
                execute.stop();
            } else {
                metodosPeppermint.iniciarTest();
                execute.start();
            }
        });
    }
}
