package InsumosSpacelogik;

public class TestCaseSpacelogik extends ContextBaseSpacelogik{
    private final GeneratorSpaceLogik generate = new GeneratorSpaceLogik();
    MethodsSpacelogik methods = new MethodsSpacelogik();
    ToastMessageSpacelogik toast = new ToastMessageSpacelogik();
    ModalMessageSpaceLogik modal = new ModalMessageSpaceLogik();

    public void happyPathLogin(){
        userEmail="admin";
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            methods.login(userEmail, userPassword);
        }
        cleanupContext();
    }
    public void happyPathReCompanieCreate(){
        userEmail="admin";
        System.out.println("Se van a crear "+generate.generateExecutions()+" ReCompanie\n");
        methods.login(userEmail, userPassword);
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
        userEmail="admin";
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        methods.login(userEmail, userPassword);
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
    public void happyPathGuruCreate(){
        userEmail = "cristiancisneros1768937300181@pineapple-lab.com";
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" Guru\n");
        methods.login(userEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewGuruForm();
                methods.createNewGuru();
                methods.waitForComponent(SelectorsSpacelogik.PEOPLE_FORM_POPUP_SUCCESSFULLY);
                methods.waitForToast(toast.GURU_SUCCESS);
                page.click(SelectorsSpacelogik.PEOPLE_FORM_POPUP_OK_BUTTON);
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathClientCreate(){
        userEmail = "agustinesquivel1769017347711@pineapple-lab.com";
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" Clients\n");
        methods.login(userEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewClientForm();
                methods.createFullClient();
                methods.waitForComponent(SelectorsSpacelogik.CLIENT_POPUP_SUCCESS);
                methods.waitForModalMessage(modal.CLIENT_SUCCESSFULLY);
                page.click(SelectorsSpacelogik.CLIENT_RETURNTOMYCLIENT_BUTTON);
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
}
