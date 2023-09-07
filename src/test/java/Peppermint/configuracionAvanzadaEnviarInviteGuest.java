package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import insumosPeppermint.variablesPeppermint;
public class configuracionAvanzadaEnviarInviteGuest extends interfaceActions {
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaEnviarInviteGuest(String ejecucionesAvanzadas, String seleccionAvanzada) {
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    public void start(Stage stageConfigAvanzadaSendGuest) {
        stageConfigAvanzadaSendGuest.setTitle("Configuracion avanzada Invite guest");
        GridPane gridPaneEnviarInviteGuest = new GridPane();
        gridPaneEnviarInviteGuest.setHgap(3);
        gridPaneEnviarInviteGuest.setVgap(10);
        gridPaneEnviarInviteGuest.add(labelEnviarInviteGuest, 1, 2);
        gridPaneEnviarInviteGuest.add(textFieldEmailInviteGuestAvanzado, 2, 2);
        gridPaneEnviarInviteGuest.add(ejecutarInviteGuestAvanzado, 5, 5);
        ejecutarInviteGuestAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabConfiguracionAvanzadaInviteGuest.setContent(gridPaneEnviarInviteGuest);
        tabPane.getTabs().addAll(tabConfiguracionAvanzadaInviteGuest);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada, 310, 150);
        stageConfigAvanzadaSendGuest.setScene(configAvanzadaScene);
        ejecutarInviteGuestAvanzado.setOnAction(e -> {
            Thread ejecutar = new Thread(() -> {
                variablesPeppermint.userEmailLoginInviteGuest = textFieldEmailInviteGuestAvanzado.getText();
                actionInviteGuest();
            }, "ejecutar");
            if (ejecutar.isAlive()) {
                ejecutar.stop();
            } else {
                metodosPeppermint.iniciarTest();
                ejecutar.start();
            }
        });
    }
}
