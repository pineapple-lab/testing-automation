package InsumosDocola;
import java.io.PrintStream;
public class VariablesDocola {
   //Variables de salida y control
   public static volatile PrintStream outputStream;
   public static volatile boolean stopTest;
   public static volatile String navigationLink;
   public static String executionDetails;
   //Variables de rutas y archivos
   private static final String ROOT ="D";
   public String imagePath = ROOT+":\\Escritorio\\insumos para pruebas\\Imagenes\\Bot docola\\Contenidos\\imagen";
   public String pictureProfilePath = ROOT+":\\Escritorio\\insumos para pruebas\\Imagenes\\Bot docola\\Picture profile\\profile";
   public String videoPath = ROOT+":\\Escritorio\\insumos para pruebas\\Videos\\Bot docola\\video";
   public String imageFileName;
   public String videoFileName;
   public int executeCounter;
   //Variables de registro
   public static String userEmail;
   public String emailDomain = "mailinator";
   public static String userRole;
   public int roleID;
   public String userPassword = "123123aA-";
   //Variables de contenido
   public static String resourceType;
   public static int contentType;
   public static int contentAmount = 1;
}
