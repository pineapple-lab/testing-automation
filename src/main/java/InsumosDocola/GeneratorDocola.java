package InsumosDocola;
import java.time.Instant;
import java.util.Random;
import Configurations.*;
public class GeneratorDocola extends ContextBaseDocola{
    public int generateExecutions(){
        return Integer.parseInt(ejecuciones);
    }
    public String generateImage(){
        String[] companyList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                            };
        Random rand = new Random();
        int index1 = rand.nextInt(companyList.length);
        image = pathImage+companyList[index1]+".jpg";
        return image;
    }
    public String generateVideo(){
        String[] companyList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        };
        Random rand = new Random();
        int index1 = rand.nextInt(companyList.length);
        video = pathVideo+companyList[index1]+".mp4";
        return video;
    }
    public EmailInfo generateEmail(){
        generateFirstName();
        generateLastName();
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
        email = firstName+lastName+timeStamp+"@gmail.com";
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
                typeContentPosition= 1;
                break;
            case "Capture video":
                typeContentPosition = 2;
                break;
            case "Web content":
                typeContentPosition = 3;
                break;
            case "Quiz":
                typeContentPosition = 4;
                break;
            case "Survey":
                typeContentPosition = 5;
                break;
            case "VR":
                typeContentPosition = 6;
                break;
        }
        return typeContentPosition;
    }
    public String generateCompanyName(){
        String[] companyList = CompanyNames.companyNames;
        Random rand = new Random();
        int index1 = rand.nextInt(companyList.length);
        companyName = companyList[index1];
        return companyName;
    }
    public String generateContentName(){
        String [] nameContentList = ContentNames.contentNames;
        Random rand = new Random();
        int index1 = rand.nextInt(nameContentList.length);
        contentName = nameContentList[index1];
        return contentName;
    }
    public String generateContentDescription(){
        String [] contentDescriptiontList = ContentDescriptions.contentDescritpion;
        Random rand = new Random();
        int index1 = rand.nextInt(contentDescriptiontList.length);
        contentDescription = contentDescriptiontList[index1];
        return contentDescription;
    }
    public String generateQuestion(){
        String [] questionList = ContentQuestions.contentQuestions;
        Random rand = new Random();
        int index1 = rand.nextInt(questionList.length);
        question = questionList[index1];
        return question;
    }
    public String generateAnswer(){
        String[] answerList = ContentAnswers.contentAnswers;
        Random rand = new Random();
        int index1 = rand.nextInt(answerList.length);
        answer = answerList[index1];
        return answer;
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
