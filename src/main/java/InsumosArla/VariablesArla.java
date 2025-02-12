package InsumosArla;

import java.io.PrintStream;

public class VariablesArla extends PathUtilsArla{
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
    //Variables utiles
    public int executeCounter;
    public String username = "franclient";
    public String password = "123123aA.";
    public int counter = 0;
}
