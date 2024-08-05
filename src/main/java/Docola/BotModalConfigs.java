package Docola;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class BotModalConfigs extends InterfaceElements{
    Button undefinedUser = new Button("Undefineduser");
    Button botConfig = new Button ("Configuracion");
    public BotModalConfigs(String environment){
        this.seleccion = environment;
    }
    public void start (Stage botSettings){
        GridPane gridBotSettings = new GridPane();
        gridBotSettings.setVgap(10);
        gridBotSettings.setHgap(10);
        gridBotSettings.add(undefinedUser,5,2);
        gridBotSettings.add(botConfig,5,3);
        undefinedUser.setStyle("-fx-background-color:#298dcc;");
        undefinedUser.setOnMouseEntered(e -> undefinedUser.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        undefinedUser.setOnMouseExited(e -> undefinedUser.setStyle("-fx-background-color: #298dcc;"));
        botConfig.setStyle("-fx-background-color:#298dcc;");
        botConfig.setOnMouseEntered(e -> botConfig.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        botConfig.setOnMouseExited(e -> botConfig.setStyle("-fx-background-color: #298dcc;"));
        rootConfigAvanzada.getChildren().add(gridBotSettings);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,199,170);
        botSettings.setScene(sceneConfigAvanzada);
        undefinedUser.setOnAction( event -> {
            BotSettingDefaultUser configAvanzada = new BotSettingDefaultUser(seleccion);
            Stage botSettingsStage = new Stage();
            configAvanzada.start(botSettingsStage);
            Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double x = ownerStage.getX();
            double y = ownerStage.getY();
            botSettingsStage.setX(x + 50);
            botSettingsStage.setY(y + 50);
            botSettingsStage.show();
        });
        botConfig.setOnAction( event -> {
            BotConfigs configAvanzada = new BotConfigs();
            Stage botSettingsStage = new Stage();
            configAvanzada.start(botSettingsStage);
            Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double x = ownerStage.getX();
            double y = ownerStage.getY();
            botSettingsStage.setX(x + 50);
            botSettingsStage.setY(y + 50);
            botSettingsStage.show();
        });
    }
}
