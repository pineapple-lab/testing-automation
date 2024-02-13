package Docola;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class interfaceElements extends Application {
    String seleccion;
    ArrayList<botCreator.ExecMethod> listaDeEspera = new ArrayList<>();
    GridPane gridCreator = new GridPane();
    GridPane gridValidations = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();
    TabPane tabPane = new TabPane();
    SplitPane splitPane = new SplitPane();
    StackPane rootConfigAvanzada = new StackPane();
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);
    Button deneterCasoDePrueba = new Button("Detener");
    Button execute = new Button("Ejecutar");
    TextField tfExecute = new TextField();
    Button removerDeLaCola = new Button("Remover de la cola");
    Button createUser = new Button("Crear usuario");
    Button validationsFirstNameRegister = new Button("First name");
    Button validationsLastNameRegister = new Button("Last name");
    public void start(Stage stage) throws Exception {}
}
