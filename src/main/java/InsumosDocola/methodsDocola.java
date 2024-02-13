package InsumosDocola;

public class methodsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
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
    public void goToRegisterForm(){
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
    }
    public void completeFirstNameRegister(String firstName){
        page.fill(selector.firstNameRegister,firstName);

    }
    public void completeLastNameARegister(String lastName){
        page.fill(selector.lastNameRegister,lastName);
    }
    public void completeEmailRegister(String emailRegister){
        page.fill(selector.emailRegister, emailRegister);
    }
    public void completeFirstStepRegister(String firstName, String lastName, String emailRegister){
        page.fill(selector.firstNameRegister,firstName);
        page.fill(selector.lastNameRegister,lastName);
        page.fill(selector.emailRegister,emailRegister);
    }
    public void completeSecondStepRegister(){
        page.fill(selector.passwordRegister,password);
        page.fill(selector.passwordConfirmationRegister,password);
    }
}
