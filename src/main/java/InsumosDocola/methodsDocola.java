package InsumosDocola;

public class methodsDocola extends contextBaseDocola{
    selectorsDocola selector = new selectorsDocola();
    queriesDocola queries = new queriesDocola();
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
    public void startTest(){
        shouldStopTest = false;
    }
    public void stopTest(){
        shouldStopTest = true;
    }
    public void startNavigation(){
        page.navigate(linkNavigation);
    }
    public void goToLogin(){
        page.click("text=Login");
    }
    public void goToRegisterForm(){
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
    }
    public void completeloginEmail(){
        page.fill(selector.loginEmail,queries.getEmailUser());
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
