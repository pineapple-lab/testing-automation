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
    GridPane gridHappyPath = new GridPane();
    GridPane gridValidationsReCompanie = new GridPane();
    GridPane gridValidationsNationalAccount = new GridPane();
    GridPane gridValidationsSearch = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();

    //EXECUTE LIST
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();

    //TABS
    TabPane tabPane = new TabPane();
    Tab tbHappyPath = new Tab ("Happy path");
    Tab tbRecompanie = new Tab ("Re companie");
    Tab tbNationalAccount = new Tab ("National account");
    Tab tbSearch = new Tab("Search");
    SplitPane splitPane = new SplitPane();

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
    Button createNationalAccountHapyPath = new Button("Create National account");
    Button createOfficeHapyPath = new Button("Create Office");
    Button createGuruHapyPath = new Button("Create Guru");
    Button createClientHapyPath = new Button("Create Client");
    Button createLocationHapyPath = new Button("Create Location");
    Button createProgramHapyPath = new Button("Create Program");

    //ASSERTION BUTTONS
    Button reCompanieAssertFormMessageEmptyInputs = new Button("Test form empty inputs");
    Button nationalAccountAssertFormMessageEmptyInputs = new Button("Test form empty inputs");
    Button searchAssertion = new Button("Test search");

    public abstract void start(Stage stage);
}
