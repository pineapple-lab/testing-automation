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
    GridPane gridCreator = new GridPane();
    GridPane gridValidationsRegister = new GridPane();
    GridPane gridValidationsLogin = new GridPane();
    GridPane gridValidationsResources = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();
    TabPane tabPane = new TabPane();
    Tab tbValidationsLogin = new Tab ("Login validation");
    Button botConfigurations = new Button("⚙");
    SplitPane splitPane = new SplitPane();
    Tab tbcreator = new Tab("Creador");
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);
    //Header
    Button stopTestCase = new Button("Stop");
    Button execute = new Button("Execute");
    TextField tfExecute = new TextField();
    Button removeQueue = new Button("List remove");
    Button login = new Button("Login");

    public abstract void start(Stage stage);
}
