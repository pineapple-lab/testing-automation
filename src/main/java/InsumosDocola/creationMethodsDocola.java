package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
public class creationMethodsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
    waitingsDocola waitings = new waitingsDocola();
    generatorDocola trigger = new generatorDocola();
    queriesDocola queries = new queriesDocola();
    public void joinNow(){
        for (contador = 1; contador <= ejecuciones; contador++) {
        if (!shouldStopTest) {
        emailRegister = trigger.generateEmail();
        rol = trigger.generateRol();
        System.out.println("Se creara el usuario:"+emailRegister);
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
        page.waitForTimeout(1000);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill(selector.firstNameRegister, trigger.generateFirstName());
        page.fill(selector.lastNameRegister, trigger.generateLastName());
        page.fill(selector.emailRegister, trigger.emailRegister);
        page.click(selector.rolRegister(rol));
        page.click(selector.nextButtonRegisterStep1);
        waitings.waitingJoinSelectorStep2();
        page.fill(selector.passwordRegister,password);
        page.fill(selector.passwordConfirmationRegister,password);
        page.click(selector.nextButtonRegisterStep2);
        waitings.waitingJoinSelectorStep3();
        page.click(selector.termsAndConditionsRegister);
        page.click(selector.captchaRegister);
        page.click(selector.nextButtonRegisterStep3);
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
     page.fill(selector.companyNameClinicianOnboarding,trigger.generateCompanyName());
     page.fill(selector.webSiteClinicianOnboarding,webSite);
     page.click(selector.nextButtonClinicianOnboardingStep1);
     waitings.waitingOnboardingSelectorContentProviderStep2();
     page.click(selector.skipForNowVerifyPhone);
    }
}
