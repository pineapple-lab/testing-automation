package InsumosSpacelogik;

public class SelectorsSpacelogik extends VariablesSpacelogik {
    //SELETORS CLASS AND COMPONENTS
    public static final String MAIN_CONTAINER_LOGIN = ".main-container-login ";
    //SELECTORS LOGIN
    public static final String LOGIN_EMAIL = MAIN_CONTAINER_LOGIN + "> form > div:nth-of-type(1) > div:nth-of-type(1) input";
    public static final String LOGIN_PASSWORD = MAIN_CONTAINER_LOGIN + "> form > div:nth-of-type(1) > div:nth-of-type(2) input";
    public static final String LOGIN_BUTTON = MAIN_CONTAINER_LOGIN + "> form > input";
}
