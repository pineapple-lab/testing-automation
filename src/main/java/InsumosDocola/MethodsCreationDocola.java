package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
public class MethodsCreationDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    WaitingsDocola waitings = new WaitingsDocola();
    QueriesDocola queries = new QueriesDocola();
    GeneratorDocola trigger = new GeneratorDocola();
    GeneratorDocola.EmailInfo emailInfo = trigger.generateEmail();
    MethodsDocola methods = new MethodsDocola();
    public void joinNow(){
        for (contador = 1; contador <= ejecuciones; contador++) {
        if (!shouldStopTest) {
        rol = trigger.generateRol();
        email=emailInfo.getEmail();
        System.out.println("Se creara el usuario:"+email);
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
        page.waitForTimeout(1000);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill(selector.registerFirstName, emailInfo.getFirstName());
        page.fill(selector.registerLastName, emailInfo.getLastName());
        page.fill(selector.email, trigger.email);
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
     page.fill(selector.onboardingClinicianCompanyName,trigger.generateCompanyName());
     page.fill(selector.clinicianOnboardingWebSite,webSite);
     page.click(selector.onboardingClinicianNextButtonStep1);
     waitings.waitingOnboardingSelectorContentProviderStep2();
     page.click(selector.VerifyPhoneSkipForNow);
    }
    public void newContent(){
        joinRol = "Content provider";
        methods.login(queries.getEmailUser(joinRol));
        page.waitForTimeout(60000);
    }
    
}
