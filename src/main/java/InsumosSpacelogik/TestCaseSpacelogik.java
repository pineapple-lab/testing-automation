package InsumosSpacelogik;

public class TestCaseSpacelogik extends ContextBaseSpacelogik{
    private final GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    MethodsSpacelogik methods = new MethodsSpacelogik();
    ToastMessageSpacelogik toast = new ToastMessageSpacelogik();

    public void happyPathLogin(){
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.login();
        }
        cleanupContext();
    }
    public void happyPathReCompanieCreate(){
        System.out.println("Se van a crear "+generate.generateExecutions()+" ReCompanie\n");
        methods.login();
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
        try{
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
           methods.createRecCompanie();
            methods.waitForToast(toast.RECOMPANIE_SUCCESS);
        }
            methods.printErrores();
            methods.reset();
    }finally{
            cleanupContext();
        }
    }
    public void happyPathNationalAccountCreate(){
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        methods.login();
        methods.goToNationalAccountPage();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                methods.createNationalAccount();
                methods.waitForToast(toast.NATIONALACCOUNT_SUCCESS);
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
}
