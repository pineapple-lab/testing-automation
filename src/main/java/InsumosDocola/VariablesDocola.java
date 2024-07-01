package InsumosDocola;
import java.io.PrintStream;
public class VariablesDocola extends PathUtils{
   //Variables de salida y control
   public static volatile PrintStream outputStream;
   public static volatile boolean stopTest;
   public static volatile String navigationLink;
   public static String executionDetails;
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
