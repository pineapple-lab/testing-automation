package Arla;

import Docola.BotDocola;
import Docola.InterfaceActions;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class InterfaceElements extends Application {
    //HEADER
    String seleccion;
    Button botConfigurations = new Button("⚙");
    Button stopTestCase = new Button("Stop");
    Button execute = new Button("Execute");
    TextField tfExecute = new TextField();
    Button removeQueue = new Button("List remove");

    //FOOTER
    SplitPane splitPane = new SplitPane();
    StackPane rootConfigAvanzada = new StackPane();
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);

    //WAITING LIST
    ArrayList<BotArla.ExecMethod> waitingList = new ArrayList<>();

    //GRIDS
    GridPane gridCreator = new GridPane();
    GridPane gridRegisterFormValidations = new GridPane();
    GridPane gridLoginFormValidations = new GridPane();
    GridPane gridCourseFormValidations = new GridPane();
    GridPane gridCategoryFormValidations = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();

    //TABS
    TabPane tabPane = new TabPane();
    Tab tbHappyPath = new Tab("Happy path");
    Tab tbRegister = new Tab ("Register");
    Tab tbLogin = new Tab ("Login");
    Tab tbCourse = new Tab ("Course");
    Tab tbCategory = new Tab ("Category");


    //TEST CASE HAPPY PATH BUTTONS
    Button hpRegisterButton = new Button ("Hp register");
    Button hpLoginButton = new Button("Hp Login");
    Button hpUploadVideos = new Button ("Hp upload video");
    Button hpCreateCourses = new Button ("Hp create course");
    Button hpCreateCategory = new Button ("Hp create category");
    //REGISTER TEST CASE VALIDATION ERRORS BUTTONS
    Button testRegisterInputEmpty= new Button ("message error inputs");
    //LOGIN TEST CASE VALIDATION ERRORS BUTTONS
    Button testLoginInputEmpty= new Button ("message error inputs");

    //COURSE TEST CASE VALIDATION ERRORS BUTTONS
    Button testCourseInputEmptyStep1= new Button ("empty inputs step 1");
    Button testCourseInputEmptyStep2= new Button ("empty inputs step 2");
    Button testCourseInputEmptyStep3= new Button ("empty inputs step 3");
    Button testCourseListQuizEmpty = new Button("empty list quiz");
    Button testCourseAddQuestionEmpty = new Button("empty add question");

    //CATEGORY TEST CASE VALIDATION ERRORS BUTTONS
    Button testCategoryInputEmptyStep1= new Button ("empty inputs step 1");
    Button testCategoryInputEmptyStep2= new Button ("empty inputs step 2");
    Button testCategoryInputEmptyStep3= new Button ("empty inputs step 3");

    public abstract void start(Stage stage);
}
//Button hpInviteClient = new Button ("Hp invite client");