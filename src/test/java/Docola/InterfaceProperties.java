package Docola;
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
        tabPane.getTabs().addAll(tbcreator,tbValidationsLogin,tbValidationsRegister,tbValidationsResources);
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
        gridValidationsResources.setHgap(3);
        gridValidationsResources.setVgap(10);
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
        addElementsGridValidationsResource();
        addGridToTabs();
        setColors();
        setHover();
        setPlaceHolder();
        setupScrollAndConsole();
    }
    public void addGridToTabs(){
        tbcreator.setContent(gridCreator);
        tbValidationsLogin.setContent(gridValidationsLogin);
        tbValidationsRegister.setContent(gridValidationsRegister);
        tbValidationsResources.setContent(gridValidationsResources);
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
        //Validation resource tab positions
        GridPane.setConstraints(validationTitleResource, 2, 3);
        GridPane.setConstraints(validationDescriptionResource, 2, 4);
        GridPane.setConstraints(validationFileResource, 2, 5);
        GridPane.setConstraints(validationTagsResource, 2, 6);
        GridPane.setConstraints(validationTwoTagsResource, 2, 7);
        GridPane.setConstraints(validationICD10TagsResource, 2, 8);
        GridPane.setConstraints(validationMonthlyPriceResource, 2, 9);
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
    private void addElementsGridValidationsResource(){
        gridValidationsResources.getChildren().add(validationTitleResource);
        gridValidationsResources.getChildren().add(validationDescriptionResource);
        gridValidationsResources.getChildren().add(validationFileResource);
        gridValidationsResources.getChildren().add(validationTagsResource);
        gridValidationsResources.getChildren().add(validationTwoTagsResource);
        gridValidationsResources.getChildren().add(validationICD10TagsResource);
        gridValidationsResources.getChildren().add(validationMonthlyPriceResource);
    }
    private void setColors(){
        //HEADER buttons
        setButtonStyle(execute);
        setButtonStyle(stopTestCase);
        setButtonStyle(removeQueue);
        setButtonStyle(botConfigurations);
        //Create buttons
        setButtonStyle(createUser);
        setButtonStyle(newResource);
        setButtonStyle(newCourse);
        setButtonStyle(newCourseCollection);
        //validation LOGIN buttons
        setButtonStyle(validationsLoginEmailIncorrect);
        setButtonStyle(validationsLoginPasswordIncorrect);
        setButtonStyle(validationsLoginEmailEmpty);
        setButtonStyle(validationsLoginPasswordEmpty);
        //validation REGISTER buttons
        setButtonStyle(validationsFirstNameRegister);
        setButtonStyle(validationsLastNameRegister);
        setButtonStyle(validationsEmailRegister);
        setButtonStyle(validationsPasswordRegister);
        setButtonStyle(validationsConfirmPasswordRegister);
        setButtonStyle(validationsConditionsPasswordRegister);
        setButtonStyle(validationsTermsAndConditionsRegister);
        setButtonStyle(validationsCaptchaRegister);
        //Validation RESOURCE buttons
        setButtonStyle(validationTitleResource);
        setButtonStyle(validationDescriptionResource);
        setButtonStyle(validationFileResource);
        setButtonStyle(validationTagsResource);
        setButtonStyle(validationTwoTagsResource);
        setButtonStyle(validationICD10TagsResource);
        setButtonStyle(validationMonthlyPriceResource);
    }
    private void setButtonStyle(Button button) {
        button.setStyle("-fx-background-color: #298dcc;");
    }
    public void setHover(){
        //HEADER buttons
        setupHoverEffect(execute);
        setupHoverEffect(stopTestCase);
        setupHoverEffect(removeQueue);
        setupHoverEffect(botConfigurations);
        //Create buttons
        setupHoverEffect(createUser);
        setupHoverEffect(newResource);
        setupHoverEffect(newCourse);
        setupHoverEffect(newCourseCollection);
        //validation LOGIN buttons
        setupHoverEffect(validationsLoginEmailIncorrect);
        setupHoverEffect(validationsLoginPasswordIncorrect);
        setupHoverEffect(validationsLoginEmailEmpty);
        setupHoverEffect(validationsLoginPasswordEmpty);
        //validation REGISTER buttons
        setupHoverEffect(validationsFirstNameRegister);
        setupHoverEffect(validationsLastNameRegister);
        setupHoverEffect(validationsEmailRegister);
        setupHoverEffect(validationsPasswordRegister);
        setupHoverEffect(validationsConfirmPasswordRegister);
        setupHoverEffect(validationsConditionsPasswordRegister);
        setupHoverEffect(validationsTermsAndConditionsRegister);
        setupHoverEffect(validationsCaptchaRegister);
        //Validation RESOURCE buttons
        setupHoverEffect(validationTitleResource);
        setupHoverEffect(validationDescriptionResource);
        setupHoverEffect(validationFileResource);
        setupHoverEffect(validationTagsResource);
        setupHoverEffect(validationTwoTagsResource);
        setupHoverEffect(validationTwoTagsResource);
        setupHoverEffect(validationICD10TagsResource);
        setupHoverEffect(validationMonthlyPriceResource);
    }
    private void setupHoverEffect(Button button) {
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #298dcc;"));
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
