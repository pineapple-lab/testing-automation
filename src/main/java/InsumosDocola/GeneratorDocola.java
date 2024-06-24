package InsumosDocola;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import Configurations.*;
import com.microsoft.playwright.ElementHandle;

public class GeneratorDocola extends ContextBaseDocola{
    String firstName;
    String lastName;
    WaitingsDocola waiting = new WaitingsDocola();
    public int generateExecutions(){
        return Integer.parseInt(ejecuciones);
    }
    public String generateImage(){
        String[] imageList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                            };
        Random rand = new Random();
        int index1 = rand.nextInt(imageList.length);
        image = pathImage+imageList[index1]+".jpg";
        return image;
    }
    public String generateVideo(){
        String[] videoList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        };
        Random rand = new Random();
        int index1 = rand.nextInt(videoList.length);
        video = pathVideo+videoList[index1]+".mp4";
        return video;
    }
    public EmailInfo generateEmail(){
        generateFirstName();
        generateLastName();
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
        email = firstName+lastName+timeStamp+"@"+emailProvider+".com";
        return new EmailInfo(email, firstName, lastName);
    }
    public String generateFirstName(){
        String [] listFirstNames = FirstNames.firstNames;
        Random rand = new Random();
        int index1 = rand.nextInt(listFirstNames.length);
        firstName = listFirstNames[index1];
        return firstName;
    }
    public String generateLastName(){
        String[] listLastNames = LastNames.lastNames;
        Random random = new Random();
        int index2 = random.nextInt(listLastNames.length);
        lastName= listLastNames[index2];
        return lastName;
    }
    public int generateRol(){
        if (joinRol == null) {
            joinRol="Clinician";
        }switch (joinRol) {
                case "Patient":
                    rol = 1;
                    break;
                case "Clinician":
                    rol = 2;
                    break;
                case "Content provider":
                    rol = 3;
                    break;
        }
        return rol;
    }
    public int generateTypeContent(){
        if (typeResource == null) {
            typeResource="Upload file";
        }switch (typeResource) {
            case "Upload file":
                return 1;
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
        }
        return 1;
    }
    public String generateCompanyName(){
        String[] companyList = CompanyNames.companyNames;
        Random rand = new Random();
        int index1 = rand.nextInt(companyList.length);
        String companyName = companyList[index1];
        return companyName;
    }
    public String generateContentTitle(){
        String [] nameContentList = ContentTitle.contentTitle;
        Random rand = new Random();
        int index1 = rand.nextInt(nameContentList.length);
        String contentName = nameContentList[index1];
        return contentName;
    }
    public String generateContentDescription(){
        String [] contentDescriptiontList = ContentDescriptions.contentDescritpion;
        Random rand = new Random();
        int index1 = rand.nextInt(contentDescriptiontList.length);
        String contentDescription = contentDescriptiontList[index1];
        return contentDescription;
    }
    public String generateQuestion(){
        String [] questionList = ContentQuestions.contentQuestions;
        Random rand = new Random();
        int index1 = rand.nextInt(questionList.length);
        String question = questionList[index1];
        return question;
    }
    public String generateAnswer(){
        String[] answerList = ContentAnswers.contentAnswers;
        Random rand = new Random();
        int index1 = rand.nextInt(answerList.length);
        String answer = answerList[index1];
        return answer;
    }
    public int generateThumbnailCategory(){
        waiting.waitingMatDialogContainer();
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(2) > div > div > button");
        Random random = new Random();
        int thumbnailCategory = random.nextInt(1,elements.size()+1);
        return thumbnailCategory;
    }
    public int generateThumbnailSplash(){
        waiting.waitingMatDialogContainer();
        page.waitForSelector(".grid-container");
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(3) > img");
        Random random = new Random();
        int thumbnail = random.nextInt(1,elements.size());
        return thumbnail;
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
