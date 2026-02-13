package InsumosSpacelogik;

import java.io.PrintStream;

public class VariablesSpacelogik extends PathUtilsSpacelogik {
    public static volatile PrintStream outputStream;
    public static volatile boolean stopTest;
    public static String executionDetails;
    public boolean allStepsPassed = true;
    boolean allPassed = true;
    public int executeCounter;
    //Variables de configuracion del bot
    public static double setSlowMotion= 0.1;
    public static boolean setHeadless = false;
    public static String setChannel = "chrome";
    public static int setSizeWidth = 1820;
    public static int setSizeHeight = 980;
    //Variables navigation
    public static String navigationLink;
    //Variables login
    public static String userEmail;
    public static String userPassword;
    public String guruEmail;
    public String reCompanieEmail;
    public String emailDomain = "pineapple-lab";
}
