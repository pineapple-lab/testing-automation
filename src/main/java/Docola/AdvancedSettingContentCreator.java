package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static InsumosDocola.VariablesDocola.*;

public class AdvancedSettingContentCreator extends InterfaceElements {
    private volatile boolean isRunning = true;
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbUploadFile = new Tab("Upload file");
    Label labelTest = new Label("test");
    Tab tbCaptureVideo = new Tab("Capture video");
    Tab tbQuiz = new Tab("Quiz");
    Tab tbSurvey = new Tab("Survey");
    Tab tbVR = new Tab("VR");
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    BotDocola accion = new BotDocola();
    private Map<Tab,List<TextField>> textFieldMap = new HashMap<>();
    public AdvancedSettingContentCreator(String executionDetailsAvanzadas , String seleccionAvanzada){

        this.vDocola.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuraciones creacion de contenido");
        TabPane tabPane = new TabPane();

        GridPane gridUploadFile = createTabContent(tbUploadFile);
        tbUploadFile.setContent(gridUploadFile);

        GridPane gridCaptureVideo = createTabContent(tbCaptureVideo);
        tbCaptureVideo.setContent(gridCaptureVideo);

        GridPane gridQuiz = createTabContent(tbQuiz);

        tbQuiz.setContent(gridQuiz);

        GridPane gridSurvey = createTabContent(tbSurvey);
        tbSurvey.setContent(gridSurvey);

        GridPane gridVR = createTabContent(tbVR);
        tbVR.setContent(gridVR);

        tabPane.getTabs().addAll(tbUploadFile,tbCaptureVideo,tbQuiz,tbSurvey,tbVR);

        Tab firstTab = tabPane.getTabs().get(0);
        VariablesDocola.resourceType = firstTab.getText();


        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                VariablesDocola.resourceType = newTab.getText();
            }
        });

        GridPane mainLayout = new GridPane();

        mainLayout.setVgap(10);
        mainLayout.setHgap(10);
        mainLayout.add(tabPane, 0, 0);
        HBox buttonContainer = new HBox();
        buttonContainer.getChildren().add(settingAdvancedExecute);

        mainLayout.add(buttonContainer, 40, 10);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabPane, mainLayout);

        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        configureTabSelection(tbUploadFile, "Upload file");
        configureTabSelection(tbCaptureVideo, "Capture video");
        configureTabSelection(tbQuiz, "Quiz");
        configureTabSelection(tbSurvey, "Survey");
        configureTabSelection(tbVR, "VR");
        Scene sceneConfigAvanzada = new Scene(vbox,500,250);
        stageJoin.setScene(sceneConfigAvanzada);
        settingAdvancedExecute.setOnAction(e->{
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            List<TextField> textFields = textFieldMap.get(selectedTab);
            if (textFields != null && !textFields.isEmpty()) {
                TextField selectedTextField = textFields.get(0);
                contentTitle = selectedTextField.getText();
                TextField descriptionTextField = textFields.size() > 1 ? textFields.get(1) : null;
                contentDescription = descriptionTextField != null ? descriptionTextField.getText() : "";
                Thread execute = new Thread(() -> {
                    iActions.actionNewResource();
                    cleanWaitingList();
                }, "execute");
                if (isRunning) {
                    mDocola.startTest();
                    execute.start();
                }
            }
        });
    }
    public GridPane createTabContent(Tab tab) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        HBox headerContainer = new HBox(10);
        headerContainer.setPadding(new Insets(10, 10, 10, 10));
        Label labelTitle = new Label("Title");
        TextField tfContentTitle = new TextField();
        tfContentTitle.setPromptText("Content title");
        Label labelDescription = new Label("Description");
        TextField tfContentDescription = new TextField();
        tfContentDescription.setPromptText("Content description");
        List<TextField> textFields = new ArrayList<>();
        textFields.add(tfContentTitle);
        textFields.add(tfContentDescription);
        textFieldMap.put(tab, textFields);
        headerContainer.getChildren().add(labelTitle);
        headerContainer.getChildren().add(tfContentTitle);
        headerContainer.getChildren().add(labelDescription);
        headerContainer.getChildren().add(tfContentDescription);
        gridPane.add(headerContainer, 2, 2);

        return gridPane;
    }
    private void configureTabSelection(Tab tab, String resourceType) {
        tab.setOnSelectionChanged(event -> {
            if (tab.isSelected()) {
                VariablesDocola.resourceType = resourceType;
            }
        });
    }
    private void cleanWaitingList(){
        waitingList.clear();
        userEmail = null;
        resourceType = "";
    }
}
