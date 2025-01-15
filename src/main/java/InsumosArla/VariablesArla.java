package InsumosArla;

import java.io.PrintStream;

public class VariablesArla {
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
}
