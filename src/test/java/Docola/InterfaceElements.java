package Docola;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class InterfaceElements extends Application {
    String seleccion;
    ArrayList<BotDocola.ExecMethod> waitingList = new ArrayList<>();
    GridPane gridCreator = new GridPane();
    GridPane gridValidationsRegister = new GridPane();
    GridPane gridValidationsLogin = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();
    TabPane tabPane = new TabPane();
    Tab tbcreator = new Tab("Creador");
    Tab tbValidationsLogin = new Tab ("Validaciones login");
    Tab tbValidationsRegister = new Tab("Validaciones registro");
    SplitPane splitPane = new SplitPane();
    StackPane rootConfigAvanzada = new StackPane();
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);
    //Header
    Button stopTestCase = new Button("Detener");
    Button execute = new Button("Ejecutar");
    TextField tfExecute = new TextField();
    Button removeQueue = new Button("Remover de la cola");
    //create buttons
    Button createUser = new Button("Crear usuario");
    Button newContent = new Button("New content");
    //validation LOGIN buttons
    Button validationsLoginEmailIncorrect = new Button("Email incorrecto");
    Button validationsLoginPasswordIncorrect = new Button("Password incorrecto");
    Button validationsLoginEmailEmpty = new Button("Email vacio");
    Button validationsLoginPasswordEmpty = new Button("Password vacia");
    //validation REGISTER buttons
    Button validationsFirstNameRegister = new Button("First name");
    Button validationsLastNameRegister = new Button("Last name");
    Button validationsEmailRegister = new Button("Email");
    Button validationsPasswordRegister = new Button("Password");
    Button validationsConfirmPasswordRegister = new Button("Confirm password");
    Button validationsConditionsPasswordRegister = new Button("Conditions password");
    Button validationsTermsAndConditionsRegister = new Button("Terms and conditions");
    Button validationsCaptchaRegister = new Button("Captcha");
    public void start(Stage stage) throws Exception {}
}
