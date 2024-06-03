package Docola;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class InterfaceProperties extends InterfaceElements{
    @Override
    public void start(Stage stage){
        setupUIElements();
        tabPane.getTabs().addAll(tbcreator,tbValidationsLogin,tbValidationsRegister);
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
        gridValidationsRegister.setHgap(3);
        gridValidationsRegister.setVgap(10);
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
        addElementsGridCreator();
        addElementsGridValidationsLogin();
        addElementsGridValidationsRegister();
        addGridToTabs();
        setColors();
        setHover();
        setPlaceHolder();
    }
    public void addGridToTabs(){
        tbcreator.setContent(gridCreator);
        tbValidationsLogin.setContent(gridValidationsLogin);
        tbValidationsRegister.setContent(gridValidationsRegister);
    }
    private void setupGridConstraints(){
        GridPane.setConstraints(execute, 3, 1);
        GridPane.setConstraints(tfExecute,2,2);
        GridPane.setConstraints(stopTestCase,4,1);
        GridPane.setConstraints(removeQueue, 5, 1);
        GridPane.setConstraints(comboBox,2,1);
        GridPane.setConstraints(botConfigurations, 7, 1);
        //Create buttons
        GridPane.setConstraints(createUser, 2, 3);
        GridPane.setConstraints(newResource, 2, 4);
        GridPane.setConstraints(newCourse, 2, 5);
        GridPane.setConstraints(newCourseCollection, 2, 6);
        //Validation login tab positions
        GridPane.setConstraints(validationsLoginEmailIncorrect, 2, 3);
        GridPane.setConstraints(validationsLoginPasswordIncorrect, 2, 4);
        GridPane.setConstraints(validationsLoginEmailEmpty, 2, 5);
        GridPane.setConstraints(validationsLoginPasswordEmpty, 2, 6);
        //Validation register tab position
        GridPane.setConstraints(validationsFirstNameRegister, 2, 3);
        GridPane.setConstraints(validationsLastNameRegister, 2, 4);
        GridPane.setConstraints(validationsEmailRegister, 2, 5);
        GridPane.setConstraints(validationsPasswordRegister, 2, 6);
        GridPane.setConstraints(validationsConfirmPasswordRegister, 2, 7);
        GridPane.setConstraints(validationsConditionsPasswordRegister, 2, 8);
        GridPane.setConstraints(validationsTermsAndConditionsRegister, 2, 9);
        GridPane.setConstraints(validationsCaptchaRegister, 2, 10);
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
    private void addElementsGridCreator(){
        gridCreator.getChildren().add(createUser);
        gridCreator.getChildren().add(newResource);
        gridCreator.getChildren().add(newCourse);
        gridCreator.getChildren().add(newCourseCollection);
    }
    private void addElementsGridValidationsLogin(){
        gridValidationsLogin.getChildren().add(validationsLoginEmailIncorrect);
        gridValidationsLogin.getChildren().add(validationsLoginPasswordIncorrect);
        gridValidationsLogin.getChildren().add(validationsLoginEmailEmpty);
        gridValidationsLogin.getChildren().add(validationsLoginPasswordEmpty);
    }
    private void addElementsGridValidationsRegister(){
        gridValidationsRegister.getChildren().add(validationsFirstNameRegister);
        gridValidationsRegister.getChildren().add(validationsLastNameRegister);
        gridValidationsRegister.getChildren().add(validationsEmailRegister);
        gridValidationsRegister.getChildren().add(validationsPasswordRegister);
        gridValidationsRegister.getChildren().add(validationsConfirmPasswordRegister);
        gridValidationsRegister.getChildren().add(validationsConditionsPasswordRegister);
        gridValidationsRegister.getChildren().add(validationsTermsAndConditionsRegister);
        gridValidationsRegister.getChildren().add(validationsCaptchaRegister);
    }
    private void setColors(){
        //HEADER buttons
        execute.setStyle("-fx-background-color: #298dcc;");
        stopTestCase.setStyle("-fx-background-color: #298dcc;");
        comboBox.setStyle("-fx-base: #298dcc");//;
        removeQueue.setStyle("-fx-background-color:#298dcc;");
        scrollPane.setStyle("-fx-control-inner-background:#000000;");
        //Create buttons
        createUser.setStyle("-fx-background-color:#298dcc;");
        newResource.setStyle("-fx-background-color:#298dcc;");
        newCourse.setStyle("-fx-background-color:#298dcc;");
        newCourseCollection.setStyle("-fx-background-color:#298dcc;");
        //Validations LOGIN buttons
        validationsLoginEmailIncorrect.setStyle("-fx-background-color:#298dcc;");
        validationsLoginPasswordIncorrect.setStyle("-fx-background-color:#298dcc;");
        validationsLoginEmailEmpty.setStyle("-fx-background-color:#298dcc;");
        validationsLoginPasswordEmpty.setStyle("-fx-background-color:#298dcc;");
        //Validations REGISTER buttons
        validationsFirstNameRegister.setStyle("-fx-background-color:#298dcc;");
        validationsLastNameRegister.setStyle("-fx-background-color:#298dcc;");
        validationsEmailRegister.setStyle("-fx-background-color:#298dcc;");
        validationsPasswordRegister.setStyle("-fx-background-color:#298dcc;");
        validationsConfirmPasswordRegister.setStyle("-fx-background-color:#298dcc;");
        validationsConditionsPasswordRegister.setStyle("-fx-background-color:#298dcc;");
        validationsTermsAndConditionsRegister.setStyle("-fx-background-color:#298dcc;");
        validationsCaptchaRegister.setStyle("-fx-background-color:#298dcc;");
        //BOT CONFIGURATION
        botConfigurations.setStyle("-fx-background-color:#298dcc;");
    }
    public void setHover(){
        //HEADER buttons
        execute.setOnMouseEntered(e -> execute.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        execute.setOnMouseExited(e -> execute.setStyle("-fx-background-color: #298dcc;"));
        stopTestCase.setOnMouseEntered(e -> stopTestCase.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        stopTestCase.setOnMouseExited(e -> stopTestCase.setStyle("-fx-background-color: #298dcc;"));
        removeQueue.setOnMouseEntered(e -> removeQueue.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        removeQueue.setOnMouseExited(e -> removeQueue.setStyle("-fx-background-color: #298dcc;"));
        //Create buttons
        createUser.setOnMouseEntered(e -> createUser.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        createUser.setOnMouseExited(e -> createUser.setStyle("-fx-background-color: #298dcc;"));
        newResource.setOnMouseEntered(e -> newResource.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        newResource.setOnMouseExited(e -> newResource.setStyle("-fx-background-color: #298dcc;"));
        newCourse.setOnMouseEntered(e -> newCourse.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        newCourse.setOnMouseExited(e -> newCourse.setStyle("-fx-background-color: #298dcc;"));
        newCourseCollection.setOnMouseEntered(e -> newCourseCollection.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        newCourseCollection.setOnMouseExited(e -> newCourseCollection.setStyle("-fx-background-color: #298dcc;"));
        //validation LOGIN buttons
        validationsLoginEmailIncorrect.setOnMouseEntered(e -> validationsLoginEmailIncorrect.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLoginEmailIncorrect.setOnMouseExited(e -> validationsLoginEmailIncorrect.setStyle("-fx-background-color: #298dcc;"));
        validationsLoginPasswordIncorrect.setOnMouseEntered(e -> validationsLoginPasswordIncorrect.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLoginPasswordIncorrect.setOnMouseExited(e -> validationsLoginPasswordIncorrect.setStyle("-fx-background-color: #298dcc;"));
        validationsLoginEmailEmpty.setOnMouseEntered(e -> validationsLoginEmailEmpty.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLoginEmailEmpty.setOnMouseExited(e -> validationsLoginEmailEmpty.setStyle("-fx-background-color: #298dcc;"));
        validationsLoginPasswordEmpty.setOnMouseEntered(e -> validationsLoginPasswordEmpty.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLoginPasswordEmpty.setOnMouseExited(e -> validationsLoginPasswordEmpty.setStyle("-fx-background-color: #298dcc;"));
        //validation REGISTER buttons
        validationsFirstNameRegister.setOnMouseEntered(e -> validationsFirstNameRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsFirstNameRegister.setOnMouseExited(e -> validationsFirstNameRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsLastNameRegister.setOnMouseEntered(e -> validationsLastNameRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsLastNameRegister.setOnMouseExited(e -> validationsLastNameRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsEmailRegister.setOnMouseEntered(e -> validationsEmailRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsEmailRegister.setOnMouseExited(e -> validationsEmailRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsPasswordRegister.setOnMouseEntered(e -> validationsPasswordRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsPasswordRegister.setOnMouseExited(e -> validationsPasswordRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsConfirmPasswordRegister.setOnMouseEntered(e -> validationsConfirmPasswordRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsConfirmPasswordRegister.setOnMouseExited(e -> validationsConfirmPasswordRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsConditionsPasswordRegister.setOnMouseEntered(e -> validationsConditionsPasswordRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsConditionsPasswordRegister.setOnMouseExited(e -> validationsConditionsPasswordRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsTermsAndConditionsRegister.setOnMouseEntered(e -> validationsTermsAndConditionsRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsTermsAndConditionsRegister.setOnMouseExited(e -> validationsTermsAndConditionsRegister.setStyle("-fx-background-color: #298dcc;"));
        validationsCaptchaRegister.setOnMouseEntered(e -> validationsCaptchaRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        validationsCaptchaRegister.setOnMouseExited(e -> validationsCaptchaRegister.setStyle("-fx-background-color: #298dcc;"));
        //BOT CONFIGURATIONS
        botConfigurations.setOnMouseEntered(e -> botConfigurations.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        botConfigurations.setOnMouseExited(e -> botConfigurations.setStyle("-fx-background-color: #298dcc;"));
    }
    public void setPlaceHolder(){
        tfExecute.setPromptText("Cantidad de ejecuciones");
    }
}
