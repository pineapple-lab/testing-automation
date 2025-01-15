package InsumosArla;

public class MethodsArla extends ContextArla{

    public void startContextAndNavigation(){
        startContext();
        startNavigation();
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
    private void startNavigation(){
        page.navigate(navigationLink);
        System.out.println("Ambiente: "+navigationLink+"\n");
    }
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
    }
}
