package InsumosSpacelogik;

import org.junit.jupiter.api.Test;

public class MethodsSpacelogik extends ContextBaseSpacelogik {
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
    }
    public void startNavigation(){
        page.navigate(navigationLink);
    }
    private void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*outputStream.println("\n-----------------------------------------------------------");
        outputStream.println("Iniciando ejecucion....");
        outputStream.println("-----------------------------------------------------------");*/
        initializePlaywright();
        setupContextAndPage();
    }
    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }
    @Test
    public void login(){
        startContextAndNavigation();
        page.fill(LOGIN_EMAIL,userEmail);
        page.fill(LOGIN_PASSWORD,userPassword);
        page.click(LOGIN_BUTTON);
        page.waitForTimeout(2000000);
    }


}
