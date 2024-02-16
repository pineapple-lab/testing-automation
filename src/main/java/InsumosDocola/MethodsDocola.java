package InsumosDocola;
import com.microsoft.playwright.ElementHandle;
public class MethodsDocola extends ContextBaseDocola{
    SelectorsDocola selector = new SelectorsDocola();
    QueriesDocola queries = new QueriesDocola();
    public void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*printStream.println("\n-----------------------------------------------------------");
        printStream.println("Iniciando ejecucion....");
        printStream.println("-----------------------------------------------------------");*/
        launchBrowser();
        createContextAndPage();
    }
    public void startNavigation(){
        page.navigate(linkNavigation);
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    public void startTest(){
        shouldStopTest = false;
    }
    public void stopTest(){
        shouldStopTest = true;
    }

    public void goToLogin(){
        page.click("text=Login");
    }
    public void login(String email){
        goToLogin();
        System.out.println(email);
        page.fill(selector.loginEmail,email);
        page.fill(selector.loginPassword,password);
        page.click(selector.loginButton);
    }
    public void signOut(){
        ElementHandle targetElement = page.querySelector(selector.menuProfile);
        targetElement.hover();
        page.click(selector.signOut);
    }
    public void goToRegisterForm(){
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
    }
    public void completeloginEmail(){
        page.fill(selector.loginEmail,queries.getEmailUser(joinRol));
    }
    public void completeloginPassword(){
        page.fill(selector.loginPassword, password);
    }
    public void completeregisterFirstName(String firstName){
        page.fill(selector.registerFirstName,firstName);
    }
    public void completeLastNameARegister(String lastName){
        page.fill(selector.registerLastName,lastName);
    }
    public void completeemail(String email){
        page.fill(selector.email, email);
    }
    public void completeFirstStepRegister(String firstName, String lastName, String email){
        page.fill(selector.registerFirstName,firstName);
        page.fill(selector.registerLastName,lastName);
        page.fill(selector.email,email);
    }
    public void completeSecondStepRegister(){
        page.fill(selector.registerPassword,password);
        page.fill(selector.registerPasswordConfirmation,password);
    }
}
