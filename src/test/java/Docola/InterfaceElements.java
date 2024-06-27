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
    GridPane gridValidationsResources = new GridPane();
    GridPane gridHeader = new GridPane();
    GridPane gridCola = new GridPane();
    SplitPane splitMain = new SplitPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();
    TabPane tabPane = new TabPane();
    Button botConfigurations = new Button("⚙");
    Tab tbcreator = new Tab("Creador");
    Tab tbValidationsLogin = new Tab ("Validaciones login");
    Tab tbValidationsRegister = new Tab("Validaciones registro");
    Tab tbValidationsResources = new Tab ("Validaciones recursos");
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
    Button newResource = new Button("New Resource");
    Button newCourse = new Button ("New course");
    Button newCourseCollection = new Button ("New course collection");
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
    //Validations RESOURCES buttons
    Button validationTitleResource = new Button("Title required");
    Button validationDescriptionResource = new Button("Description required");
    Button validationFileResource = new Button("File required");
    Button validationTagsResource = new Button("Tags required");
    Button validationTwoTagsResource = new Button("Two tags required");
    Button validationICD10TagsResource = new Button("ICD10 tags required");
    Button validationMonthlyPriceResource = new Button("Monthly price required");
    public void start(Stage stage) throws Exception {}
}
