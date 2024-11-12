package InsumosDocola;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import Configurations.*;
import com.microsoft.playwright.ElementHandle;
public class GeneratorDocola extends ContextBaseDocola{
    String firstName;
    String lastName;
    WaitingsDocola waiting = new WaitingsDocola();
    public int generateExecutions(){
        return Integer.parseInt(executionDetails);
    }
    public String generateImage(){
        String[] imageList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                            };
        return generateRandomFileName(imageList, Paths.get(getBasePath())+"\\"+RELATIVE_IMAGE_PATH,".jpg");
    }
    public String generateVideo(){
        String[] videoList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        };
        return generateRandomFileName(videoList,Paths.get(getBasePath())+"\\"+RELATIVE_VIDEO_PATH,".mp4");
    }
    public String generatePictureProfile(){
        String[] imageList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21","22","23","24","25","26"
        };
        String basePath = Paths.get(PathUtils.getBasePath(),PathUtils.RELATIVE_PICTURE_PROFILE_PATH).toString();
        return generateRandomFileName(imageList,basePath,".jpg");
    }
    public EmailInfo generateEmail(){
        generateFirstName();
        generateLastName();
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
        firstName=generateFirstName();
        lastName=generateLastName();
        userEmail = firstName+lastName+timeStamp+"@"+ emailDomain +".com";
        return new EmailInfo(userEmail, firstName, lastName);
    }
    public String generateFirstName(){
        String [] listFirstNames = FirstNames.firstNames;
        return getRandomString(listFirstNames);
    }
    public String generateLastName(){
        String[] listLastNames = LastNames.lastNames;
        return getRandomString(listLastNames);
    }
    public int generateRol(){
        if (userRole == null) {
            return 2;
        }
        switch (userRole) {
            case "Patient":
                return 1;
            case "Content provider":
                return 3;
            default:
                return 2;
        }
    }
    public int generateTypeContent(){
        if (resourceType == null) {
            return 1;
        }switch (resourceType) {
            case "Capture video":
                return 2;
            case "Web content":
                return 3;
            case "Quiz":
               return 4;
            case "Survey":
                return 5;
            case "VR":
                return 6;
                //break;
            default:
                return 1;
        }
    }
    public String generateCompanyName(){
        String[] companyList = CompanyNames.companyNames;
        return getRandomString(companyList);
    }
    public String generateContentTitle(){
        String [] nameContentList = ContentTitle.contentTitle;
        return getRandomString(nameContentList);
    }
    public String generateContentDescription(){
        String [] contentDescriptiontList = ContentDescriptions.contentDescritpion;
        return getRandomString(contentDescriptiontList);
    }
    public int generateTagType(){
        List<ElementHandle> elements = page.querySelectorAll("app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > app-tag-type-button");
        return getRandomIndex(elements.size()-1)+1;
    }
    public int generateTag(){
        waiting.waitingTagsSearchoverlay();
        List<ElementHandle> elements = page.querySelectorAll("app-tags-search-overlay > div > cdk-virtual-scroll-viewport > div > button");
        return getRandomIndex(elements.size()-1)+1;
    }
    private List<Integer> availableIndices = new ArrayList<>();
    public int generateSetContentStep(){
        page.waitForSelector("app-crud");
        List<ElementHandle> elements = page.querySelectorAll("app-crud app-cards-container > div > app-card");
        if (availableIndices.isEmpty()) {
            for (int i = 1; i < elements.size(); i++) {
                availableIndices.add(i);
            }
            Collections.shuffle(availableIndices);
        }
        return availableIndices.remove(0)+1;
    }
    public String generateQuestion(){
        String [] questionList = ContentQuestions.contentQuestions;
        return getRandomString(questionList);
    }
    public String generateAnswer(){
        String[] answerList = ContentAnswers.contentAnswers;
        return getRandomString(answerList);
    }
    public int generateThumbnailCategory(){
        waiting.waitingMatDialogContainer();
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(2) > div > div > button");
        return getRandomIndex(elements.size()-1)+ 1;
    }
    public int generateThumbnailSplash(){
        waiting.waitingMatDialogContainer();
        waiting.waitingUnplashFirstImage();
        page.waitForSelector(".grid-container");
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(3) > img");
        return getRandomIndex(elements.size()-1)+1;
    }
    public int generateInviteRol(){
        page.waitForSelector(".cdk-overlay-pane");
        List<ElementHandle> elements = page.querySelectorAll(".cdk-overlay-pane > div > mat-option");
        return getRandomIndex(elements.size())+1;
    }
    private String generateRandomFileName(String[] fileList, String basePath, String extension){
        Random rand = new Random();
        int index = rand.nextInt(fileList.length);
        return basePath + fileList[index] + extension;

    }
    private String getRandomString(String[] array){
        Random rand = new Random();
        int index = rand.nextInt(array.length);
        return array[index];
    }
    private int getRandomIndex(int size){
        Random random = new Random();
        return random.nextInt(size);
    }
    class EmailInfo {
        private String email;
        private String firstName;
        private String lastName;
        public EmailInfo(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getEmail() {
            return email;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
    }
}
