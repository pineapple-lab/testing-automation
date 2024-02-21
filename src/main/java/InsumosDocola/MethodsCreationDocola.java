package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class MethodsCreationDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    WaitingsDocola waitings = new WaitingsDocola();
    QueriesDocola queries = new QueriesDocola();
    GeneratorDocola generate = new GeneratorDocola();
    GeneratorDocola.EmailInfo emailInfo = generate.generateEmail();
    MethodsDocola methods = new MethodsDocola();
    public void joinNow(){
        for (contador = 1; contador <= ejecuciones; contador++) {
        if (!shouldStopTest) {
        rol = generate.generateRol();
        email=emailInfo.getEmail();
        System.out.println("Se creara el usuario:"+email);
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
        page.waitForTimeout(1000);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill(selector.registerFirstName, emailInfo.getFirstName());
        page.fill(selector.registerLastName, emailInfo.getLastName());
        page.fill(selector.email, generate.email);
        page.click(selector.rolRegister(rol));
        page.click(selector.registerNextButtonStep1);
        waitings.waitingJoinSelectorStep2();
        page.fill(selector.registerPassword,password);
        page.fill(selector.registerPasswordConfirmation,password);
        page.click(selector.registerNextButtonStep2);
        waitings.waitingJoinSelectorStep3();
        page.click(selector.registerTermsAndConditions);
        page.click(selector.registerCaptchat);
        page.click(selector.registerNextButtonStep3);
        while (true) {
            try {
                page.waitForSelector("text=Login successful");
                Assertions.assertTrue(page.isVisible("text=Login successful"));
                queries.saveUser(email);
                break;
            } catch (PlaywrightException e) {}
        }

            System.out.println(joinRol);
            if(joinRol.equals("Content provider")){
                onboardingContentProvider();
            }
            methods.signOut();
        } else {
            closeContext();
            }
        }
        closeContext();
    }
    public void onboardingContentProvider(){
     webSite=companyName+".com";
     waitings.waitingOnboardingSelectorContentProviderStep1();
     page.fill(selector.onboardingClinicianCompanyName,generate.generateCompanyName());
     page.fill(selector.clinicianOnboardingWebSite,webSite);
     page.click(selector.onboardingClinicianNextButtonStep1);
     waitings.waitingOnboardingSelectorContentProviderStep2();
     page.click(selector.VerifyPhoneSkipForNow);
    }
    public void newContent(){
        joinRol = "Content provider";
        methods.login(queries.getEmailUser(joinRol));
        methods.goToContentCreateForm();

        if (typeContent == null) {
            typeContent="Upload file";
        }switch (typeContent) {
            case "Upload file":
                waitings.waitingCreateUploadFileSelectorsStep1();
                newContentUploadFile();
                break;
            case "Capture video":
                typeContentPosition = 2;
                break;
            case "Import web content":
                typeContentPosition = 3;
                break;
            case "Create a quiz":
                typeContentPosition = 4;
                break;
            case "Create a survey":
                typeContentPosition = 5;
                break;
            case "VR":
                typeContentPosition = 6;
                break;
        }
    }
    public void newContentUploadFile(){
        page.fill(selector.contentTitle, "test");
        page.fill(selector.contentDescription, "test");
        page.locator(selector.contentUploadFile).setInputFiles(Paths.get(pathImage));
        page.click(selector.contentButtonContinue);
    }
}
