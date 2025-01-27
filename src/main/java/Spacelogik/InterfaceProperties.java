package Spacelogik;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceProperties extends InterfaceElements{

        @Override
        public void start(Stage stage){
            setupUIElements();
            tabPane.getTabs().addAll(tbValidationsLogin);
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
            gridValidationsLogin.setHgap(3);
            gridValidationsLogin.setVgap(10);
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
            addElementsGridValidationsLogin();
            addGridToTabs();
            setColors();
            setHover();
            setPlaceHolder();
            setupScrollAndConsole();
        }
        public void addGridToTabs(){
            tbcreator.setContent(gridCreator);
            tbValidationsLogin.setContent(gridValidationsLogin);
        }
        private void setupGridConstraints(){
            GridPane.setConstraints(execute, 3, 1);
            GridPane.setConstraints(tfExecute,2,2);
            GridPane.setConstraints(stopTestCase,4,1);
            GridPane.setConstraints(removeQueue, 5, 1);
            GridPane.setConstraints(comboBox,2,1);
            GridPane.setConstraints(botConfigurations, 7, 1);
            //Create buttons
            GridPane.setConstraints(login, 2, 3);
            comboBox.getItems().add("DEV");
            comboBox.getItems().add("QA");
            comboBox.getItems().add("Local");
            comboBox.setValue("Elegir ambiente");
        }
        private void addElementsGridHeader(){
            gridHeader.getChildren().add(execute);
            gridHeader.getChildren().add(tfExecute);
            gridHeader.getChildren().add(stopTestCase);
            gridHeader.getChildren().add(removeQueue);
            gridHeader.getChildren().add(comboBox);
            gridHeader.getChildren().add(botConfigurations);
        }
        private void addElementsGridValidationsLogin(){
            gridValidationsLogin.getChildren().add(login);
        }
        private void setColors(){
            //HEADER buttons
            setButtonStyle(execute);
            setButtonStyle(stopTestCase);
            setButtonStyle(removeQueue);
            setButtonStyle(botConfigurations);
            //Create buttons
            setButtonStyle(login);

        }
        private void setButtonStyle(Button button) {
            button.setStyle("-fx-background-color: #fb9957;");
        }
        public void setHover(){
            //HEADER buttons
            setupHoverEffect(execute);
            setupHoverEffect(stopTestCase);
            setupHoverEffect(removeQueue);
            setupHoverEffect(botConfigurations);
            //Create buttons
            setupHoverEffect(login);
        }
        private void setupHoverEffect(Button button) {
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #d89743; -fx-text-fill: white;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #fb9957;"));
        }
        public void setPlaceHolder(){
            tfExecute.setPromptText("Cantidad de ejecuciones");
        }
        private void setupScrollAndConsole() {
            consoleTextArea.setEditable(false);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scrollPane.setStyle("-fx-control-inner-background:#000000;");
        }
    }
