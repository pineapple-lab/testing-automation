package InsumosSpacelogik;

import Configurations.*;
import InsumosSpacelogik.PathUtilsSpacelogik;

import com.microsoft.playwright.ElementHandle;

import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneratorSpaceLogik extends ContextBaseSpacelogik{
    String firstName;
    String lastName;
    private int currentIndex = 0;

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
        String basePath = Paths.get(InsumosDocola.PathUtils.getBasePath(), PathUtilsSpacelogik.RELATIVE_PICTURE_PROFILE_PATH).toString();
        return generateRandomFileName(imageList,basePath,".jpg");
    }
    public GeneratorSpaceLogik.EmailInfo generateEmail(){
        generateFirstName();
        generateLastName();
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
        firstName=generateFirstName();
        lastName=generateLastName();
        userEmail = firstName+lastName+timeStamp+"@"+ emailDomain +".com";
        return new GeneratorSpaceLogik.EmailInfo(userEmail, firstName, lastName);
    }
    public int generateSalutation(){
        page.waitForSelector(".MuiPaper-root > ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPaper-root > ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateIndustry(){
        page.waitForSelector(".MuiPopover-root > .MuiPaper-root > ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPopover-root > .MuiPaper-root > ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateState(){
        page.waitForSelector(".MuiPopover-root ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPopover-root ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateCity(){
        page.waitForSelector(".MuiPopover-root ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPopover-root ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateZipCode(){
        page.waitForSelector(".MuiPopover-root ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPopover-root ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public String generateFirstName(){
        String [] listFirstNames = FirstNames.firstNames;
        return getRandomString(listFirstNames);
    }
    public String generateLastName(){
        String[] listLastNames = LastNames.lastNames;
        return getRandomString(listLastNames);
    }
    public String generateLocationName(){
        String[] locationsNamesList = LocationNames.locationNames;
        return getRandomString(locationsNamesList);
    }
    public String generatePhone(){
        String [] phonesList = Phones.phoneNumbers;
        return getRandomString(phonesList);
    }
    public String generateMobile(){
        String [] mobileList = Mobile.mobileNumbers;
        return getRandomString(mobileList);
    }
    public String generateAdress(){
        String [] adressList = Adress.addresses;
        return getRandomString(adressList);
    }
    public String buildingName() {
        String[] listBuildingNames = BuildingNames.buildingNames;
        String buildingName = listBuildingNames[currentIndex % listBuildingNames.length];
        currentIndex++;

        return buildingName;
    }
    public String generateCompanyName(){
        String[] companyList = CompanyNames.companyNames;
        return getRandomString(companyList);
    }
    public int generateOffice(){
        page.waitForSelector(".MuiPaper-root > ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPaper-root > ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateDistanceOption(){
        page.waitForSelector(".MuiPaper-root > ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPaper-root > ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public int generateFromOption(){
        page.waitForSelector(".MuiPaper-root > ul > li:nth-of-type(2)");
        List<ElementHandle> elements = page.querySelectorAll(".MuiPaper-root > ul > li");
        int n = elements.size();
        return getRandomIndex(n - 1) + 2;
    }
    public String generateContentTitle(){
        String [] nameContentList = ContentTitle.contentTitle;
        return getRandomString(nameContentList);
    }
    public String generateContentDescription(){
        String [] contentDescriptiontList = ContentDescriptions.contentDescritpion;
        return getRandomString(contentDescriptiontList);
    }
    public String generateProfesionalTitle(){
        String [] profesionalTitleList = ProfesionalTitles.professionalTitles;
        return getRandomString(profesionalTitleList);
    }
    public String generateProfileDescription(){
        String [] profileDescriptiontList = ProfileDescriptions.profileDescriptions;
        return getRandomString(profileDescriptiontList);
    }
    public String generateRsf(){
        String [] rsfList = Rsf.rsfsValues;
        return getRandomString(rsfList);
    }
    public String generateCompanyDescription(){
        String [] companyDescriptiontList = CompanyDescriptions.companyDescriptions;
        return getRandomString(companyDescriptiontList);
    }
    public String generatekeywords(){
        String [] keywordstList = Keywords.keywords;
        return getRandomString(keywordstList);
    }
    public int generateTagType(){
        List<ElementHandle> elements = page.querySelectorAll("app-tags > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > app-tag-type-button");
        return getRandomIndex(elements.size()-1)+1;
    }
    public int generateTag(){
        List<ElementHandle> elements = page.querySelectorAll("app-tags-search-overlay > div > cdk-virtual-scroll-viewport > div > button");
        return getRandomIndex(elements.size()-1)+1;
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
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(2) > div > div > button");
        return getRandomIndex(elements.size()-1)+ 1;
    }
    public int generateThumbnailSplash(){
        page.waitForSelector(".grid-container");
        List<ElementHandle> elements = page.querySelectorAll("mat-dialog-container > div > div > app-unsplash > form > div:nth-of-type(3) > img");
        return getRandomIndex(elements.size()-1)+1;
    }
    public int generateResponseCount(){
        page.waitForSelector("app-quiz");
        List<ElementHandle> elements = page.querySelectorAll("app-quiz > div:nth-of-type(1) > div:nth-of-type(3) > div");
        return elements.size();
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
