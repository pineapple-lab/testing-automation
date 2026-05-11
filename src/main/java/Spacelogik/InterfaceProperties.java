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
            tabPane.getTabs().addAll(tbHappyPath, tbRecompanie, tbNationalAccount, tbSearch, tbSweetCase);
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
            gridHappyPath.setHgap(3);
            gridHappyPath.setVgap(10);
            gridHeader.setHgap(3);
            gridHeader.setVgap(10);
            gridValidationsReCompanie.setHgap(3);
            gridValidationsReCompanie.setVgap(10);
            gridValidationsNationalAccount.setHgap(3);
            gridValidationsNationalAccount.setVgap(10);
            gridValidationsSearch.setHgap(3);
            gridValidationsSearch.setVgap(10);
            gridSweetCase.setHgap(3);
            gridSweetCase.setVgap(10);
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
            addElementsGridHappyPath();
            addElementsGridReCompanieValidations();
            addElementsGridNationalAccountValidations();
            addElementsGridSearchValidations();
            addElementsGridSweetCase();
            addGridToTabs();
            setColors();
            setHover();
            setPlaceHolder();
            setupScrollAndConsole();
        }
        public void addGridToTabs(){
            tbHappyPath.setContent(gridHappyPath);
            tbRecompanie.setContent(gridValidationsReCompanie);
            tbNationalAccount.setContent(gridValidationsNationalAccount);
            tbSearch.setContent(gridValidationsSearch);
            tbSweetCase.setContent(gridSweetCase);
        }
        private void setupGridConstraints(){
            //HEADER BUTTONS
            GridPane.setConstraints(execute, 3, 1);
            GridPane.setConstraints(tfExecute,2,2);
            GridPane.setConstraints(stopTestCase,4,1);
            GridPane.setConstraints(removeQueue, 5, 1);
            GridPane.setConstraints(comboBox,2,1);
            GridPane.setConstraints(botConfigurations, 7, 1);

            //HAPPY PATH BUTTONS
            GridPane.setConstraints(loginHappyPath, 2, 3);
            GridPane.setConstraints(createReCompanieHapyPath, 2, 4);
            GridPane.setConstraints(createNationalAccountHapyPath, 2, 5);
            GridPane.setConstraints(createOfficeHapyPath, 2, 6);
            GridPane.setConstraints(createGuruHapyPath, 2, 7);
            GridPane.setConstraints(createClientHapyPath, 2, 8);
            GridPane.setConstraints(createLocationHapyPath, 2, 9);
            GridPane.setConstraints(createProgramHapyPath, 3, 3);
            GridPane.setConstraints(configPasswordHapyPath, 3, 4);
            GridPane.setConstraints(completeOnboardingHapyPath, 3, 5);
            GridPane.setConstraints(completeBuyCreditsHapyPath, 3, 6);
            GridPane.setConstraints(createCliendAndLocationMultipleGuru, 3, 7);
            GridPane.setConstraints(activateLocationMultipleGuru, 3, 8);
            GridPane.setConstraints(createProgramMultipleGuru, 3, 9);

            //TEST CASE RECOMPANIE VALIDATION ERRORS
            GridPane.setConstraints(reCompanieAssertFormMessageEmptyInputs,2,3);

            //TEST CASE NATIONAL ACCOUNT VALIDATION ERRORS
            GridPane.setConstraints(nationalAccountAssertFormMessageEmptyInputs,2,3);

            //TEST CASE SEARCH VALIDATIONS
            GridPane.setConstraints(searchAssertion,2,3);

            //SWEET CASES
            GridPane.setConstraints(sweetCaseNewAutoProgram, 2, 3);;
            GridPane.setConstraints(sweetCaseNewReCompanie, 2, 4);;
            GridPane.setConstraints(sweetCaseNewGuru, 2, 5);;
            GridPane.setConstraints(sweetCaseNewClient, 2, 6);;
            GridPane.setConstraints(sweetCaseNewLocation, 2, 7);
            GridPane.setConstraints(sweetCaseNewStandardProgram, 2, 7);;
            //ENVIRONMENTS OPTIONS
            comboBox.getItems().add("Local");
            comboBox.getItems().add("DEV");
            comboBox.getItems().add("PROD");
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
        private void addElementsGridHappyPath(){
            gridHappyPath.getChildren().add(loginHappyPath);
            gridHappyPath.getChildren().add(createReCompanieHapyPath);
            gridHappyPath.getChildren().add(createNationalAccountHapyPath);
            gridHappyPath.getChildren().add(createGuruHapyPath);
            gridHappyPath.getChildren().add(createClientHapyPath);
            gridHappyPath.getChildren().add(createOfficeHapyPath);
            gridHappyPath.getChildren().add(createLocationHapyPath);
            gridHappyPath.getChildren().add(createProgramHapyPath);
            gridHappyPath.getChildren().add(configPasswordHapyPath);
            gridHappyPath.getChildren().add(completeOnboardingHapyPath);
            gridHappyPath.getChildren().add(completeBuyCreditsHapyPath);
            gridHappyPath.getChildren().add(createCliendAndLocationMultipleGuru);
            gridHappyPath.getChildren().add(activateLocationMultipleGuru);
            gridHappyPath.getChildren().add(createProgramMultipleGuru);
        }
        private void addElementsGridReCompanieValidations() {
            gridValidationsReCompanie.getChildren().add(reCompanieAssertFormMessageEmptyInputs);
        }
        private void addElementsGridNationalAccountValidations() {
            gridValidationsNationalAccount.getChildren().add(nationalAccountAssertFormMessageEmptyInputs);
        }
        private void addElementsGridSearchValidations() {
            gridValidationsSearch.getChildren().add(searchAssertion);
        }
        private void addElementsGridSweetCase() {
            gridSweetCase.getChildren().add(sweetCaseNewAutoProgram);
            gridSweetCase.getChildren().add(sweetCaseNewReCompanie);
            gridSweetCase.getChildren().add(sweetCaseNewGuru);
            gridSweetCase.getChildren().add(sweetCaseNewClient);
            gridSweetCase.getChildren().add(sweetCaseNewLocation);
            gridSweetCase.getChildren().add(sweetCaseNewStandardProgram);
        }
        private void setColors(){
            //HEADER
            setButtonStyle(execute);
            setButtonStyle(stopTestCase);
            setButtonStyle(removeQueue);
            setButtonStyle(botConfigurations);

            //HAPPY PATH BUTTONS
            setButtonStyle(loginHappyPath);
            setButtonStyle(createReCompanieHapyPath);
            setButtonStyle(createNationalAccountHapyPath);
            setButtonStyle(createGuruHapyPath);
            setButtonStyle(createClientHapyPath);
            setButtonStyle(createOfficeHapyPath);
            setButtonStyle(createLocationHapyPath);
            setButtonStyle(createProgramHapyPath);
            setButtonStyle(configPasswordHapyPath);
            setButtonStyle(completeOnboardingHapyPath);
            setButtonStyle(completeBuyCreditsHapyPath);
            setButtonStyle(createCliendAndLocationMultipleGuru);
            setButtonStyle(activateLocationMultipleGuru);
            setButtonStyle(createProgramMultipleGuru);

            //RECOMPANIE TEST CASE VALIDATION MESSAGE ERROR
            setButtonStyle(reCompanieAssertFormMessageEmptyInputs);
            setButtonStyle(nationalAccountAssertFormMessageEmptyInputs);
            setButtonStyle(searchAssertion);

            //SWEET CASES
            setButtonStyle(sweetCaseNewAutoProgram);
            setButtonStyle(sweetCaseNewReCompanie);
            setButtonStyle(sweetCaseNewGuru);
            setButtonStyle(sweetCaseNewClient);
            setButtonStyle(sweetCaseNewLocation);
            setButtonStyle(sweetCaseNewStandardProgram);
        }
        private void setButtonStyle(Button button) {
            button.setStyle("-fx-background-color: #fb9957;");
        }
        public void setHover(){
            //HEADER
            setupHoverEffect(execute);
            setupHoverEffect(stopTestCase);
            setupHoverEffect(removeQueue);
            setupHoverEffect(botConfigurations);

            //HAPPY PATH BUTTONS
            setupHoverEffect(loginHappyPath);
            setupHoverEffect(createReCompanieHapyPath);
            setupHoverEffect(createNationalAccountHapyPath);
            setupHoverEffect(createGuruHapyPath);
            setupHoverEffect(createClientHapyPath);
            setupHoverEffect(createOfficeHapyPath);
            setupHoverEffect(createLocationHapyPath);
            setupHoverEffect(createProgramHapyPath);
            setupHoverEffect(configPasswordHapyPath);
            setupHoverEffect(completeOnboardingHapyPath);
            setupHoverEffect(completeBuyCreditsHapyPath);
            setupHoverEffect(createCliendAndLocationMultipleGuru);
            setupHoverEffect(activateLocationMultipleGuru);
            setupHoverEffect(createProgramMultipleGuru);

            //RECOMPANIE TEST CASE VALIDATION MESSAGE ERROR
            setupHoverEffect(reCompanieAssertFormMessageEmptyInputs);
            setupHoverEffect(nationalAccountAssertFormMessageEmptyInputs);
            setupHoverEffect(searchAssertion);

            //SWEET CASES
            setupHoverEffect(sweetCaseNewAutoProgram);
            setupHoverEffect(sweetCaseNewReCompanie);
            setupHoverEffect(sweetCaseNewGuru);
            setupHoverEffect(sweetCaseNewClient);
            setupHoverEffect(sweetCaseNewLocation);
            setupHoverEffect(sweetCaseNewStandardProgram);
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
