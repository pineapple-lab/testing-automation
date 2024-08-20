package InsumosDocola;
import java.io.PrintStream;
public class VariablesDocola extends PathUtils{
   //Variables de salida y control
   public static volatile PrintStream outputStream;
   public static volatile boolean stopTest;
   public static volatile String navigationLink;
   public static String executionDetails;
   //Variables de configuracion del bot
   public static double setSlowMotion= 0.1;
   public static boolean setHeadless = false;
   public static String setChannel = "chrome";
   public static int setSizeWidth = 1820;
   public static int setSizeHeight = 980;
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
   public String userInvitation = null;
   public static String invitationFirstName;
   public static String invitationLastName;
   public static int contentAmount = 1;
   public static int executeMembersAmount;
   public static int membersAmount = 1;
   public String practiceName;
   public static int practiceRol = 0;
   public static boolean addMembers;
}
