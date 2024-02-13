package Docola;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class interfacePositions extends interfaceElements{
    Tab tbcreator = new Tab("Creator");
    Tab tbvalidations = new Tab("Validations");
    @Override
    public void start(Stage stage){
        setupUIElements();
        tbcreator.setContent(gridCreator);
        tbvalidations.setContent(gridValidations);
        tabPane.getTabs().addAll(tbcreator,tbvalidations);
        splitPane.getItems().addAll(gridHeader, tabPane, scrollPane);
        splitMain.getItems().addAll(gridCola, splitPane);
        Scene scene = new Scene (splitMain,550, 670);
        stage.setScene(scene);
        stage.show();
    }
    private void setupUIElements(){
        consoleTextArea.setEditable(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        gridCreator.setHgap(3);
        gridCreator.setVgap(10);
        gridValidations.setHgap(3);
        gridValidations.setVgap(10);
        gridHeader.setHgap(3);
        gridHeader.setVgap(10);
        splitPane.setOrientation(Orientation.VERTICAL);
        gridHeader.setPrefHeight(300);
        tabPane.setPrefHeight(200);
        splitPane.setDividerPosition(0, 0.15);
        splitPane.setDividerPosition(1, 0.75);
        splitMain.setOrientation(Orientation.HORIZONTAL);
        gridCola.setPrefWidth(100);
        gridCola.setMaxWidth(100);
        addElementsGridHeader();
        setupGridConstraints();
        addElementsTabCreator();
        addElementsTabValidations();
        setColors();
        setHover();
        setPlaceHolder();
    }
    private void setupGridConstraints(){
        GridPane.setConstraints(execute, 3, 1);
        GridPane.setConstraints(tfExecute,2,2);
        GridPane.setConstraints(deneterCasoDePrueba,4,1);
        GridPane.setConstraints(removerDeLaCola, 5, 1);
        GridPane.setConstraints(comboBox,2,1);
        GridPane.setConstraints(createUser, 2, 3);
        GridPane.setConstraints(validationsFirstNameRegister, 2, 3);
        GridPane.setConstraints(validationsLastNameRegister, 2, 4);
        comboBox.getItems().add("DEV");
        comboBox.getItems().add("QA");
        comboBox.getItems().add("Local");
        comboBox.setValue("Elegir ambiente");
    }
    private void addElementsGridHeader(){
        gridHeader.getChildren().add(execute);
        gridHeader.getChildren().add(tfExecute);
        gridHeader.getChildren().add(deneterCasoDePrueba);
        gridHeader.getChildren().add(removerDeLaCola);
        gridHeader.getChildren().add(comboBox);
    }
    private void addElementsTabCreator(){
        gridCreator.getChildren().add(createUser);
    }
    private void addElementsTabValidations(){
        gridValidations.getChildren().add(validationsFirstNameRegister);
        gridValidations.getChildren().add(validationsLastNameRegister);
    }
    private void setColors(){
        execute.setStyle("-fx-background-color: #298dcc;");
        deneterCasoDePrueba.setStyle("-fx-background-color: #298dcc;");
        comboBox.setStyle("-fx-base: #298dcc");//;
        removerDeLaCola.setStyle("-fx-background-color:#298dcc;");
        scrollPane.setStyle("-fx-control-inner-background:#000000;");
        createUser.setStyle("-fx-background-color:#298dcc;");
        validationsFirstNameRegister.setStyle("-fx-background-color:#298dcc;");
        validationsLastNameRegister.setStyle("-fx-background-color:#298dcc;");
    }
    public void setHover(){
        //create buttons
        execute.setOnMouseEntered(e -> execute.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        execute.setOnMouseExited(e -> execute.setStyle("-fx-background-color: #298dcc;"));
        deneterCasoDePrueba.setOnMouseEntered(e -> deneterCasoDePrueba.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        deneterCasoDePrueba.setOnMouseExited(e -> deneterCasoDePrueba.setStyle("-fx-background-color: #298dcc;"));
        removerDeLaCola.setOnMouseEntered(e -> removerDeLaCola.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        removerDeLaCola.setOnMouseExited(e -> removerDeLaCola.setStyle("-fx-background-color: #298dcc;"));
        createUser.setOnMouseEntered(e -> createUser.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        createUser.setOnMouseExited(e -> createUser.setStyle("-fx-background-color: #298dcc;"));
        //validation buttons
        validationsFirstNameRegister.setOnMouseEntered(e -> validationsFirstNameRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsFirstNameRegister.setOnMouseExited(e -> validationsFirstNameRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsLastNameRegister.setOnMouseEntered(e -> validationsLastNameRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLastNameRegister.setOnMouseExited(e -> validationsLastNameRegister.setStyle("-fx-background-color: #298dcc;"));

    }
    public void setPlaceHolder(){
        tfExecute.setPromptText("Cantidad de ejecuciones");
    }
}
