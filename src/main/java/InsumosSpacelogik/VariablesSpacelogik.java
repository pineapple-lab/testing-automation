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
    public static double setSlowMotion= 30;
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
    //HEADERS
    public static final String HEADER_PRIMARY_PREFERENCE = "PrimaryPref";
    public static final String HEADER_SECONDARY_PREFERENCE = "SecondaryPref";
    public static final String HEADER_INDUSTRY = "Industry";
    public static final String HEADER_FURNITURE = "Furniture";
    public static final String HEADER_CONSTRUCTION = "Construction";
    public static final String HEADER_PROGRAM_NAME = "ProgramName";
    public static final String HEADER_ROOM_NAME = "RoomName";
    public static final String HEADER_ROOM_TYPE = "RoomType";
    public static final String HEADER_ROOM_SIZE = "RoomSize";
    public static final String HEADER_NATURAL_LIGHT_PREFERENCE = "LightPref";
    public static final String HEADER_QUANTITY = "Quantity";

}
