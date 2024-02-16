package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
public class creationMethodsDocola extends contextBaseDocola{
    selectorsDocola selector = new selectorsDocola();
    waitingsDocola waitings = new waitingsDocola();
    queriesDocola queries = new queriesDocola();
    generatorDocola trigger = new generatorDocola();
    public void joinNow(){
        for (contador = 1; contador <= ejecuciones; contador++) {
        if (!shouldStopTest) {
        email = trigger.generateEmail();
        rol = trigger.generateRol();
        System.out.println("Se creara el usuario:"+email);
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
        page.waitForTimeout(1000);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill(selector.registerFirstName, trigger.generateFirstName());
        page.fill(selector.registerLastName, trigger.generateLastName());
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
                break;
            } catch (PlaywrightException e) {}
        }
            } else {
                closeContext();
            }
            System.out.println(joinRol);
            if(joinRol.equals("Content provider")){
                onboardingContentProvider();
            }
        }
        queries.saveUser();
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
}
