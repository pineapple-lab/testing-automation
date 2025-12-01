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
    GridPane gridCreator = new GridPane();
    GridPane gridCourseFormValidations = new GridPane();
    GridPane gridValidationsRegister = new GridPane();
    GridPane gridValidationsLogin = new GridPane();
    GridPane gridValidationsResources = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();

    //TABS
    TabPane tabPane = new TabPane();
    Tab tbHappyPath = new Tab("Happy path");
    Tab tbCourseMessageValidations = new Tab ("Course message validations");

    //TEST CASE HAPPY PATH BUTTONS
    Button hpRegisterButton = new Button ("Hp register");
    Button hpLoginButton = new Button("Hp Login");
    Button hpUploadVideos = new Button ("Hp upload video");
    Button hpCreateCourses = new Button ("Hp create course");
    Button hpCreateCategory = new Button ("Hp create category");

    //TEST CASE VALIDATION ERRORS BUTTONS
    Button testCourseInputEmptyStep1= new Button ("empty inputs step 1");
    Button testCourseInputEmptyStep2= new Button ("empty inputs step 2");
    Button testCourseInputEmptyStep3= new Button ("empty inputs step 3");
    Button testCourseListQuizEmpty = new Button("empty list quiz");
    Button testCourseAddQuestionEmpty = new Button("empty add question");

    public abstract void start(Stage stage);
}
//Button hpInviteClient = new Button ("Hp invite client");