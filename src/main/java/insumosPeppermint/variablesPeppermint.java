package insumosPeppermint;
import java.io.PrintStream;
public class variablesPeppermint extends connectionSQLpeppermint{
    //UTILIDAD
    public String assertions;
    public static String linkNavigation;
    public static volatile PrintStream printStream;
    public static volatile boolean shouldStopTest;

    public boolean uploadImageVideo;
    public String textoParaPublicaciones = "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque taciti faucibus facilisis ac, vestibulum viverra venenatis gravida magnis varius fames tortor imperdiet id facilisi phasellus, mollis mi at urna aliquet donec pellentesque est quam volutpat lacinia. Fames leo egestas feugiat nunc lobortis facilisi vehicula cursus mattis, nullam viverra commodo habitasse litora luctus id massa ut hendrerit, quis etiam mus varius a libero velit enim. Urna ullamcorper nulla dui etiam luctus nascetur tincidunt risus aenean himenaeos, egestas vel volutpat leo torquent venenatis et convallis porta varius, pulvinar vestibulum turpis dis montes elementum vitae arcu mauris. Taciti mi erat molestie ridiculus malesuada eu leo habitasse nostra, est sagittis tellus vivamus scelerisque mus integer vel porttitor sed, suscipit donec urna fames ornare phasellus eros interdum. Ac a donec taciti leo senectus rhoncus venenatis";
    public static  String userSendRecomendation;
    public static  String userSendRecomendationQA;
    public static  String userSendFriends = "Friendtest";
    public static  String emailuserSendRecomendation = "pineappleuser1685719252540@mailinator.com";//variable para mensajes
    public static String emailRecomendationSending;
    public static String emailRecomendationSendingQA;
    public static String emailUserBookmark;
    public static String emailUserBookmarkQA;
    public static volatile String emailAcceptFriendRequests = "pineappleuser1684762180394@mailinator.com";
    //SEARCH
    public String searchingElement;
    public static volatile boolean advancedConfigurationTitleWorkshop = false;
    public static volatile boolean advancedConfigurationMaxGroupWithInstructor = false;
    public static volatile boolean advancedConfigurationOptimalGroupWithInstructor = false;
    public static volatile boolean advancedConfigurationMaxStudenGroup = false;
    public static volatile boolean advancedConfigurationOptimalStudenGroup = false;
    //CONTROLADORES
    public int counter;
    public int execute;
    public int position;
    public int counterRegister;
    public int counterAcceptFriendship;
    public int userDeleted= 0;
    //VALIDARDOMINIOS
    public String subDomain;
    public String domainTopLevel;
    //REGISTRO
    public static boolean configurationAdvancedRegistration = false;
    public static String firstName;
    public static String lastName;
    public static String emailRegister;
    public static String passwordRegister = "123123aA";
    public String cardholderName = "Test";
    public String cardNumber = "4242 4242 4242 4242";
    public String monthExpired = "424";
    public String cvv = "424";
    //INVITE GUEST
    public static String userEmailLoginInviteGuest;
    public String emailGuest;
    public String inviteGuest;
    public String inviteGuestEmail;
    public String inviteGuestEmailLoop;
    public int idcontent;
    //RUTAS
    public String pathImage;
    public String pathVideo;
    //LOGIN
    public static String emailUserAdmin= "admin@oluko.com";
    public static String emailUserAdminQA= "danielmendoza001@mailinator.com";
    public static volatile String emailLogin;//= "JulietaSanchez1692213580092@mailinator.com"
    public String passwordLogin= "123123aA";
    public String idUsuario;
    //CREAR TECHNIQUE
    public String titleTechnique;
    public String descriptionTechnique;
    public String creatorTechnique;
    public String tagTechnique;
    public String categoryTechnique;
    public String topicTechnique;
    public String subTopicTechnique;
    //CREAR SEGMENTS
    public String titleSegments;
    public String descriptionSegments;
    public String creatorSegments;
    public String tagSegments;
    public String transcriptSegments;
    public String categorySegments;
    public String topicSegments;
    public String subTopicSegments;
    //CREAR LESSON
    public String titleLesson;
    public String descriptionLesson;
    public String categoryLesson;
    public String topicLesson;
    public String subtopicLesson;
    public String creatorLesson;
    public String tagLesson;
    //CREAR WORKSHOP
    public static String titleWorkshop;
    public String descriptionWorkshop;
    public String creatorWorkshop;
    public String tagWorkshop;
    public String categoryWorkshop;
    public String topicWorkshop;
    public String subTopicWorkshop;
    public String targetAudienceWorkshop;
    public String learningObjectiveWorkshop;
    public String whatDoYouNeed;
    public String howItWorks;
    public String purposeWorkshop;
    public String skillsWorkshop;
    public String physicalActvityWorkshop;
    public String questionWorkshop;
    public String answerWorkshop;
    public String reviewerWorkshop;
    public String reviewWorkshop;
    public String studentWorkshop;
    public String descriptionProjectWorkshop;
    public String addLinksWorkshop;
    public String titleZoomWorkshop;
    public String deadlineWorkshop;
    public String descriptionZoomWorkshop;
    public String zoomUrlWorkshop;
    public String activitiesTitleWorkshop;
    public String activitiesDescriptionWorkshop;
    public String syncUpTitleWorkshop;
    public String syncUpDescriptionWorkshop;
    public String instructorSoloWithInstructor;
    public String instructorGroupWithInstructor;
    public static String maxStudentsGroupWithInstructor;
    public static String optimalBuddyGroupGroupWithInstructor;
    public static String maxStudentsGroup;
    public static String optimalBuddyGroup;
    public String startDateWorkshop;
    public static String emailUserEnrollMultiplesWorkshops;
    public static String enrollModality ="groupwithinstructor";
    //CREAR ARTICULO
    public String titleArticle;
    public String descriptionArticle;
    public String creatorArticle;
    public String tagArticle;
    public String estimatedReadTime;
    public String categoryArticle;
    public String topicArticle;
    public String subTopicArticle;
    public String contentTitle;
    public String textContent;

    //CREAR EVENTO
    public String titleEvent;
    public String urlZoomEvent;
    public String descriptionEvent;
    public String clubEvent;
    //CREAR TAXONOMY
    public String titleCategory;
    public String titleTopic;
    public String titleSubTopic;
    //CREAR TAG
    public String titleTag;
    //CREAR CLUB
    public String titleClub;
    public String descriptionClub;
    public String categoryClub;
    public String topicClub;
    public String subtopicClub;
    public String creatorClub;
    public String tagClub;
    public static String emailUserUnirMultiplesClub;
}
