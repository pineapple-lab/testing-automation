package Arla;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceProperties extends InterfaceElements{
    @Override
    public void start(Stage stage) {
        setupUIElements();
        tabPane.getTabs().addAll(tbHappyPath,tbRegisterMessageValidations,tbLoginMessageValidations, tbCourseMessageValidations, tbCategoryMessageValidations);
        splitPane.getItems().addAll(gridHeader, tabPane, scrollPane);
        splitMain.getItems().addAll(gridCola, splitPane);
        Scene scene = new Scene(splitMain, 550, 670);
        stage.setScene(scene);
        stage.show();
    }
    private void setupUIElements(){
        consoleTextArea.setEditable(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        gridCreator.setHgap(3);
        gridCreator.setVgap(10);
        gridRegisterFormValidations.setHgap(3);
        gridRegisterFormValidations.setVgap(10);
        gridLoginFormValidations.setHgap(3);
        gridLoginFormValidations.setVgap(10);
        gridCourseFormValidations.setHgap(3);
        gridCourseFormValidations.setVgap(10);
        gridCategoryFormValidations.setHgap(3);
        gridCategoryFormValidations.setVgap(10);
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
        addElementsGridRegisterValidations();
        addElementsGridLoginValidations();
        addElementsGridCourseValidations();
        addElementsGridCategoryValidations();
        addGridToTabs();
        setColors();
        setHover();
        setPlaceHolder();
        setupScrollAndConsole();
    }
    public void addGridToTabs(){
        tbHappyPath.setContent(gridCreator);
        tbRegisterMessageValidations.setContent(gridRegisterFormValidations);
        tbLoginMessageValidations.setContent(gridLoginFormValidations);
        tbCourseMessageValidations.setContent(gridCourseFormValidations);
        tbCategoryMessageValidations.setContent(gridCategoryFormValidations);
    }
    private void setupGridConstraints(){
        GridPane.setConstraints(execute, 3, 1);
        GridPane.setConstraints(tfExecute,2,2);
        GridPane.setConstraints(stopTestCase,4,1);
        GridPane.setConstraints(removeQueue, 5, 1);
        GridPane.setConstraints(comboBox,2,1);
        GridPane.setConstraints(botConfigurations, 7, 1);

        //TEST CASE HAPPY PATH BUTTONS
        GridPane.setConstraints(hpRegisterButton, 2, 3);
        GridPane.setConstraints(hpLoginButton, 2, 4);
        GridPane.setConstraints(hpUploadVideos, 2, 5);
        GridPane.setConstraints(hpCreateCourses, 2, 6);
        GridPane.setConstraints(hpCreateCategory, 2, 7);

        //REGISTER TEST CASE VALIDATION ERRORS MESSAGE BUTTONS
        GridPane.setConstraints(testRegisterInputEmpty,2, 3);

        //LOGIN TEST CASE VALIDATION ERRORS MESSAGE BUTTONS
        GridPane.setConstraints(testLoginInputEmpty,2, 3);

        //COURSE TEST CASE VALIDATION ERRORS MESSAGE BUTTONS
        GridPane.setConstraints(testCourseInputEmptyStep1,2, 3);
        GridPane.setConstraints(testCourseInputEmptyStep2,2, 4);
        GridPane.setConstraints(testCourseInputEmptyStep3,2,5);
        GridPane.setConstraints(testCourseListQuizEmpty,2,6);
        GridPane.setConstraints(testCourseAddQuestionEmpty,2,7);

        //CATEGORY TEST CASE VALIDATION ERROR MESSAGE BUTTONS
        GridPane.setConstraints(testCategoryInputEmptyStep1,2,3);
        GridPane.setConstraints(testCategoryInputEmptyStep2,2,4);
        GridPane.setConstraints(testCategoryInputEmptyStep3,2,5);
        //GridPane.setConstraints(hpInviteClient, 2, 7);
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
        gridCreator.getChildren().add(hpRegisterButton);
        gridCreator.getChildren().add(hpLoginButton);
        gridCreator.getChildren().add(hpUploadVideos);
        gridCreator.getChildren().add(hpCreateCourses);
        gridCreator.getChildren().add(hpCreateCategory);
    }
    private void addElementsGridRegisterValidations() {
        gridRegisterFormValidations.getChildren().add(testRegisterInputEmpty);
    }
    private void addElementsGridLoginValidations(){
        gridLoginFormValidations.getChildren().add(testLoginInputEmpty);
    }
    private void addElementsGridCourseValidations(){
        gridCourseFormValidations.getChildren().add(testCourseInputEmptyStep1);
        gridCourseFormValidations.getChildren().add(testCourseInputEmptyStep2);
        gridCourseFormValidations.getChildren().add(testCourseInputEmptyStep3);
        gridCourseFormValidations.getChildren().add(testCourseListQuizEmpty);
        gridCourseFormValidations.getChildren().add(testCourseAddQuestionEmpty);
    }
    private void addElementsGridCategoryValidations(){
        gridCategoryFormValidations.getChildren().add(testCategoryInputEmptyStep1);
        gridCategoryFormValidations.getChildren().add(testCategoryInputEmptyStep2);
        gridCategoryFormValidations.getChildren().add(testCategoryInputEmptyStep3);
    }
    private void setColors(){
        //HEADER BUTTONS
        setButtonStyle(execute);
        setButtonStyle(stopTestCase);
        setButtonStyle(removeQueue);
        setButtonStyle(botConfigurations);
        //HAPPY PATH TEST CASE BUTTONS
        setButtonStyle(hpRegisterButton);
        setButtonStyle(hpLoginButton);
        setButtonStyle(hpUploadVideos);
        setButtonStyle(hpCreateCourses);
        setButtonStyle(hpCreateCategory);
        //REGISTER TEST CASE VALIDATION MESSAGE ERROR BUTTONS
        setButtonStyle(testRegisterInputEmpty);
        //LOGIN TEST CASE VALIDATION MESSAGE ERROR BUTTONS
        setButtonStyle(testLoginInputEmpty);
        //COURSE TEST CASE VALIDATION MESSAGE ERROR BUTTONS
        setButtonStyle(testCourseInputEmptyStep1);
        setButtonStyle(testCourseInputEmptyStep2);
        setButtonStyle(testCourseInputEmptyStep3);
        setButtonStyle(testCourseListQuizEmpty);
        setButtonStyle(testCourseAddQuestionEmpty);
        //CATEGORY TEST CASE VALIDATION MESSAGE ERROR BUTTONS
        setButtonStyle(testCategoryInputEmptyStep1);
        setButtonStyle(testCategoryInputEmptyStep2);
        setButtonStyle(testCategoryInputEmptyStep3);
    }
    private void setButtonStyle(Button button) {
        button.setStyle("-fx-background-color: #cb4b81;");
    }
    public void setHover(){
        //HEADER BUTTONS
        setupHoverEffect(execute);
        setupHoverEffect(stopTestCase);
        setupHoverEffect(removeQueue);
        setupHoverEffect(botConfigurations);
        //HAPPY PATH TEST CASE BUTTONS
        setupHoverEffect(hpRegisterButton);
        setupHoverEffect(hpLoginButton);
        setupHoverEffect(hpUploadVideos);
        setupHoverEffect(hpCreateCourses);
        setupHoverEffect(hpCreateCategory);
        //REGISTER TEST CASE VALIDATION MESSAGE ERROR
        setupHoverEffect(testRegisterInputEmpty);
        //LOGIN TEST CASE VALIDATION MESSAGE ERROR
        setupHoverEffect(testLoginInputEmpty);
        //COURSE TEST CASE VALIDATION MESSAGE ERROR
        setupHoverEffect(testCourseInputEmptyStep1);
        setupHoverEffect(testCourseInputEmptyStep2);
        setupHoverEffect(testCourseInputEmptyStep3);
        setupHoverEffect(testCourseListQuizEmpty);
        setupHoverEffect(testCourseAddQuestionEmpty);
        //CATEGORY TEST CASE VALIDATION MESSAGE ERROR
        setupHoverEffect(testCategoryInputEmptyStep1);
        setupHoverEffect(testCategoryInputEmptyStep2);
        setupHoverEffect(testCategoryInputEmptyStep3);
    }
    private void setupHoverEffect(Button button) {
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #e27da1; -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #cb4b81;"));
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
