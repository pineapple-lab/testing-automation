package InsumosArla;

public class SelectorsArla {
    VariablesArla variable = new VariablesArla();
    public static final String APP_TOASTERS = "app-toasters";
    public static final String APP_POPUPS = "app-invite-client-dialog h4";
    public static final String USERNAME_INPUT = "form > mat-form-field:nth-of-type(1) input";
    public static final String PASSWORD_INPUT = "form > mat-form-field:nth-of-type(2) input";
    public static final String LOGIN_BUTTON = "form > button";

    //ASSERTIONS SELECTORS
    public static final String ASSERTION_MENU_USER = "app-header > header .mat-mdc-menu-trigger";
    public static final String ASSERTION_FORMCOURSE_NAME_EMPTY = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(1) mat-error span";
    public static final String ASSERTION_FORMCOURSE_DESCRIBE_EMPTY = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(2) mat-error span";
    public static final String ASSERTION_FORMCOURSE_LENGUAGE_EMPTY = "app-language-selector mat-error span";
    public static final String ASSERTION_FORMCOURSE_IMAGE_EMPTY = "app-upload-image .container-error span";
    public static final String ASSERTION_FORMCOURSE_CHAPTER_EMPTY = "app-course-creation .warning-container span";
    public static final String ASSERTION_FORMCOURSE_LISTQUESTIONS_EMPTY = "app-quiz .container-error span";
    public static final String ASSERTION_FORMCOURSE_APPROVALPERCENTAGE_EMPTY = "app-quiz .container-error-percentage span";
    public static final String ASSERTION_FORMCOURSE_QUESTION_EMPTY = "app-quiz .text-warn";

    //REGISTER
    public static final String REGISTER_NAVIGATION_FORM_BUTTON = "header > div > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String REGISTER_FIRSTNAME_INPUT = "form > div > div:nth-of-type(1) > mat-form-field input";
    public static final String REGISTER_LASTNAME_INPUT = "form > div > div:nth-of-type(2) > mat-form-field input";
    public static final String REGISTER_EMAIL_INPUT = "form > mat-form-field:nth-of-type(1) input";
    public static final String REGISTER_PASSWORD_INPUT  = "form > mat-form-field:nth-of-type(2) input";
    public static final String REGISTER_CONFIRMPASWORD_INPUT = "form > mat-form-field:nth-of-type(3) input";
    public static final String REGISTER_TERMSANDCONDITION_CHECKBOX = "form mat-checkbox input";
    public static final String REGISTER_BUTTON = "form button";

    //MEDIA LIBRARY
    public static final String MEDIA_LIBRARY_MENU = "mat-list > mat-list-item:nth-of-type(3)";
    public static final String MEDIA_LIBRARY_UPLOAD_BUTTON = "app-my-media-library > div > div > button";
    public static final String UPLOAD_VIDEO_INPUT = "app-upload-video > div > div input:nth-of-type(2)";
    public static final String UPLOAD_VIDEO_ADD_LENGUAGE = "app-upload-video app-table tbody td:nth-of-type(3) mat-chip";
    public static final String UPLOAD_VIDEO_SELECT_LENGUAGE = "app-overlay > div > div > mat-option:nth-of-type(1)";
    public static final String UPLOAD_VIDEO_SAVE_BUTTON = "app-upload-video > div:nth-of-type(2) div:nth-of-type(2) > button:nth-of-type(2)";

    //COURSE
    public static final String COURSE_MENU_BUTTON = "mat-list > mat-list-item:nth-of-type(2)";
    public static final String COURSE_CREATE_BUTTON = "app-courses > div > div:nth-of-type(1) button";
    public static final String COURSE_NAME_INPUT = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(1) input";
    public static final String COURSE_DESCRIBE_INPUT = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(2) textarea";
    public static final String COURSE_ISSUE_INPUT = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1)  ngx-editor p";
    public static final String COURSE_KEYWORD_INPUT = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) input";
    public static final String COURSE_LENGUAGE_SELECTOR = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-language-selector";
    public static final String COURSE_LENGUAGE_LIST = ".cdk-overlay-container > div:nth-of-type(2) > div > div > mat-option:nth-of-type(1)";
    public static final String COURSE_CONTINUE_BUTTON = "app-course-creation > div > div:nth-of-type(2) > div > button:nth-of-type(2)";
    public static final String COURSE_UPLOAD_IMAGE = "app-upload-image input";
    public static final String COURSE_UPLOAD_IMAGE_SAVE_BUTTON = ".btn-modal-container > button:nth-of-type(2)";
    public static final String COURSE_CHAPTER_ADD_BUTTON = "app-course-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > button";
    public static final String COURSE_CHAPTER_TITLE_INPUT = "app-new-chapter-modal > div > mat-form-field input";
    public static final String COURSE_CHAPTER_ADD_VIDEO = "app-new-chapter-modal > div:nth-of-type(1) > div > div:nth-of-type(1) > button";
    public static final String COURSE_CHAPTER_UPLOAD_VIDEO_BUTTON = "app-media-library > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) button";
    public static final String COURSE_CHAPTER_UPLOAD_VIDEO = "app-upload-video > div > div > input:nth-of-type(2)";
    public static final String COURSE_CHAPTER_UPLOAD_VIDEO_SAVE_BUTTON = "app-upload-video > div:nth-of-type(2) > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String COURSE_CHAPTER_SELECT_VIDEO_LIST = "app-media-library > div > app-table > table > tbody > tr:nth-of-type(1)";
    public static final String COURSE_CHAPTER_CREATE_QUIZ_BUTTON = "app-new-chapter-modal > div:nth-of-type(1) > div > div:nth-of-type(2) > button";
    public static final String COURSE_CHAPTER_APPROVAL_PERCENTAGE_INPUT = "app-quiz > div:nth-of-type(1) > div:nth-of-type(1) > div > mat-form-field input";
    public static final String COURSE_CHAPTER_QUIZ_ADDQUESTION_BUTTON = "app-quiz > div:nth-of-type(1) > div:nth-of-type(3) button";
    public static final String COURSE_CHAPTER_QUIZ_QUESTION_INPUT = "app-quiz > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > mat-form-field input";
    public String courseChapterQuizAnswerInput(int counter){
        return "app-quiz > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type("+counter+") > div > div:nth-of-type(1) input";
    }
    public static final String COURSE_CHAPTER_QUIZ_TIME_TOGGLE = "app-quiz > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) mat-slide-toggle button";
    public static final String COURSE_CHAPTER_QUIZ_TIME_INPUT = "app-quiz > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) input";
    public static final String COURSE_CHAPTER_QUIZ_CORRECT_ANSWER_CHECKBOX = "app-quiz > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(1) mat-checkbox";
    public static final String COURSE_CHAPTER_QUIZ_QUESTION_SAVE_BUTTON = "app-quiz > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String COURSE_CHAPTER_SAVE_BUTTON = "app-new-chapter-modal > div:nth-of-type(2) > button:nth-of-type(2)";

    //CATEGORY
    public static final String CATEGORY_MENU_BUTTON = "mat-list > mat-list-item:nth-of-type(1)";
    public static final String CATEGORY_CREATE_BUTTON = "app-category-list > div > div:nth-of-type(1) button";
    public static final String CATEGORY_NAME_INPUT = "app-category-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(1) input";
    public static final String CATEGORY_DESCRIPTION_INPUT = "app-category-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > app-mat-form-field:nth-of-type(2) textarea";
    public static final String CATEGORY_CLIENTS_SELECT = "app-category-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > mat-form-field mat-select";
    public static final String CATEGORY_CLIENTS_SEARCH_SELECT = ".cdk-overlay-pane mat-form-field input";
    public static final String CATEGORY_CLIENTS_CHECKBOX = ".cdk-overlay-pane mat-option > mat-pseudo-checkbox";
    public static final String CATEGORY_KEYWORD_INPUT = "app-category-creation > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) mat-form-field input";
    public static final String CATEGORY_LENGUAGE_SELECTOR = "app-language-selector > mat-form-field";
    public static final String CATEGORY_LENGUAGE_LIST = ".cdk-overlay-container > div:nth-of-type(2) > div > div > mat-option:nth-of-type(1)";
    public static final String CATEGORY_PRICE_INPUT = "app-price-input > form > div > div > mat-form-field:nth-of-type(2) input";
    public static final String CATEGORY_DISCOUNT_INPUT = "app-price-input > form > div > div:nth-of-type(2) input";
    public static final String CATEGORY_OPENLISTVIDEO_BUTTON = "app-content-video-upload button";
    public static final String CATEGORY_OPENUPLOADVIDEO_MODAL = "app-media-library .row-upload button";
    public static final String CATEGORY_SAVEVIDEO_BUTTON = "app-upload-video .footer > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String CATEGORY_VIDEO_UPLOAD = "app-upload-video .overflow input:nth-of-type(2)";
    public static final String CATEGORY_VIDEO_LIST = "app-table > table tbody tr:nth-of-type(1)";
    public static final String CATEGORY_SELECT_COURSE_BUTTON = "app-category-creation > div > div:nth-of-type(1) button:nth-of-type(2)";
    public static final String CATEGORY_LIST_CHECKBOX = "mat-dialog-content app-table table tbody tr:nth-of-type(1) mat-checkbox";
    public static final String CATEGORY_COURSE_SAVE_BUTTON = "app-select-courses-dialog > mat-dialog-actions button:nth-of-type(2)";
    public static final String CATEGORY_CONTINUE_BUTTON = "app-category-creation > div > div:nth-of-type(2) > div > button:nth-of-type(2)";

    //MANAGE CLIENT
    public static final String CLIENT_MENU_BUTTON = "mat-list > mat-list-item:nth-of-type(4)";
    public static final String CLIENT_NEW_INVITE_BUTTON = "app-manage-clients > div > div:nth-of-type(1) button";
    public static final String CLIENT_COMPANY_NAME_INPUT = "app-invite-client-details > form > div:nth-of-type(1) input";
    public static final String CLIENT_USERNAME_INPUT = "app-invite-client-details > form > div:nth-of-type(2) input";
    public static final String CLIENT_EMAIL_INPUT = "app-invite-client-details > form > div:nth-of-type(3) input";
    public static final String CLIENT_FORMLINK_INPUT = "app-invite-client-details > form > div:nth-of-type(4) input";
    public static final String CLIENT_CONTINUE_BUTTON_STEP1 = "app-invite-client-details > form > div:nth-of-type(5) > button:nth-of-type(2)";
    public static final String CLIENT_CONTINUE_BUTTON_STEP2 = "app-invite-client-dialog mat-tab-group > div > mat-tab-body:nth-of-type(2) > div > div > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String CLIENT_SEARCH_CATEGORY_INPUT = "app-invite-client-categories app-search-bar input";
    public static final String CLIENT_CATEGORY_CHECKBOX = "cdk-virtual-scroll-viewport > div:nth-of-type(1) > div:nth-of-type(1) mat-checkbox input";
    public static final String CLIENT_SEND_INVITE_BUTTON = "app-invite-client-categories > div > div:nth-of-type(2) > button:nth-of-type(2)";
    public static final String PLAY_VIDEO_BUTTON = "app-video-player > vg-player > vg-overlay-play > div";

}
