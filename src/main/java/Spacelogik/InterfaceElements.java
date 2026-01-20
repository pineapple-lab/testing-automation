package Spacelogik;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class InterfaceElements extends Application {
    String seleccion;
    ArrayList<BotSpacelogik.ExecMethod> waitingList = new ArrayList<>();

    //GRIDS
    GridPane gridCreator = new GridPane();
    GridPane gridValidationsRegister = new GridPane();
    GridPane gridHappyPath = new GridPane();
    GridPane gridValidationsResources = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();

    //EXECUTE LIST
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();

    //TABS
    TabPane tabPane = new TabPane();
    Tab tbHappyPath = new Tab ("Happy path");
    SplitPane splitPane = new SplitPane();
    Tab tbcreator = new Tab("Creador");

    //HEADER
    Button botConfigurations = new Button("⚙");
    Button stopTestCase = new Button("Stop");
    Button execute = new Button("Execute");
    TextField tfExecute = new TextField();
    Button removeQueue = new Button("List remove");

    //FOOTER
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);

    //HAPPY PATH BUTTONS
    Button loginHappyPath = new Button("Login");
    Button createReCompanieHapyPath = new Button("Create RE Companie");

    public abstract void start(Stage stage);
}
