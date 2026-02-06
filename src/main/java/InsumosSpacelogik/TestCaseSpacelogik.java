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
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
        cleanupContext();
    }

    public void happyPathReCompanieCreate(){
        userEmail="admin";
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" ReCompanie\n");
        methods.login(userEmail, userPassword);
        methods.goToReCompaniePage();
        methods.goToRecompanieForm();
        try{
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
           methods.createRecCompanie();
            methods.waitForToast(toast.RECOMPANIE_SUCCESS);
            System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
            System.out.println("----------------------------------------------------\n");
        }
            methods.printErrores();
            methods.reset();
    }finally{
            cleanupContext();
        }
    }
    public void happyPathNationalAccountCreate(){
        userEmail="admin";
        userPassword="Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" National Account\n");
        methods.login(userEmail, userPassword);
        methods.goToNationalAccountPage();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNationalAccountForm();
                methods.createNationalAccount();
                methods.waitForToast(toast.NATIONALACCOUNT_SUCCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathOfficeCreate(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                reCompanieEmail = "valentingarrido1769193783329@pineapple-lab.com";
                break;
            case "https://space-logic.web.app/":
                reCompanieEmail = "ZulemaHernandez1769798909068@pineapple-lab.com";
                break;
        }
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" offices\n");
        methods.login(reCompanieEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewOfficesForm();
                methods.createOffice();
                methods.waitForToast(toast.OFFICES_SUCESS);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathGuruCreate(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                reCompanieEmail = "valentingarrido1769193783329@pineapple-lab.com";
                break;
            case "https://space-logic.web.app/":
                reCompanieEmail = "ZulemaHernandez1769798909068@pineapple-lab.com";
                break;
        }
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" Guru\n");
        methods.login(reCompanieEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewGuruForm();
                methods.createNewGuru(reCompanieEmail);
                methods.waitForComponent(SelectorsSpacelogik.PEOPLE_FORM_POPUP_SUCCESSFULLY);
                methods.waitForToast(toast.GURU_SUCCESS);
                page.click(SelectorsSpacelogik.PEOPLE_FORM_POPUP_OK_BUTTON);
                methods.waitForComponent(SelectorsSpacelogik.WAIT_RECOMPANIE_TABLE_FIRSTROW);
                System.out.println("\nse compeleto "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathClientCreate(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                userEmail = "deliarico1769455006783@pineapple-lab.com";
                break;
            case "https://space-logic.web.app/":
                userEmail= "ninfajimenez1769799535493@pineapple-lab.com";
                break;
        }
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" Clients\n");
        methods.login(userEmail, userPassword);
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewClientForm();
                methods.createFullClient();
                methods.waitForComponent(SelectorsSpacelogik.CLIENT_POPUP_SUCCESS);
                methods.waitForModalMessage(modal.CLIENT_HEADER_SUCCESSFULLY);
                methods.waitForModalMessage(modal.CLIENT_BODY1_SUCCESSFULLY);
                methods.waitForModalMessage(modal.CLIENT_BODY2_SUCCESSFULLY);
                page.click(SelectorsSpacelogik.CLIENT_RETURNTOMYCLIENT_BUTTON);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
    public void happyPathLocationCreate(){
        switch (navigationLink){
            case "https://spacelogic-development.web.app/":
                userEmail = "deliarico1769455006783@pineapple-lab.com";
                break;
            case "https://space-logic.web.app/":
                userEmail= "ninfajimenez1769799535493@pineapple-lab.com";
                break;
        }
        userPassword = "Pickle30";
        System.out.println("Se van a crear "+generate.generateExecutions()+" locations\n");
        methods.login(userEmail, userPassword);
        page.waitForTimeout(3000);
        methods.waitForComponent(SelectorsSpacelogik.CLIENT_CARD);
        methods.goToLocationView();
        try{
            for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
                methods.goToNewLocationForm();
                methods.createLocation();
                page.waitForTimeout(3000);
                System.out.println("\nse compeletaron "+executeCounter+" ejecuciones");
                System.out.println("----------------------------------------------------\n");
            }
            methods.printErrores();
            methods.reset();
        }finally{
            cleanupContext();
        }
    }
}
