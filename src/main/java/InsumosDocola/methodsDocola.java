package InsumosDocola;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Instant;
import java.util.Random;
import InsumosDocola.componentsDocola;
public class methodsDocola extends contextBaseDocola{
    componentsDocola selector = new componentsDocola();
    waitingsDocola waitings = new waitingsDocola();
    public void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        printStream.println("\n-----------------------------------------------------------");
        printStream.println("Iniciando ejecucion....");
        printStream.println("-----------------------------------------------------------");
        launchBrowser();
        createContextAndPage();
    }
    public void iniciarTest(){
        shouldStopTest = false;
    }
    public void detenerTest(){
        shouldStopTest = true;
    }
    public void saveUser(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbddocola?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "INSERT INTO users (`emailUser`) " +
                    "VALUES('"+emailRegister+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void startNavigation(){
        page.navigate(linkNavigation);
    }
    public void joinNow(){
        for (contador = 1; contador <= ejecuciones; contador++) {
            if (!shouldStopTest) {
        if (joinRol == null) {
            joinRol="Clinician";
        }
        switch(joinRol){
            case "Patient":
                rol=1;
                break;
            case "Clinician":
                rol=2;
                break;
            case "Content provider":
                rol=3;
                break;
        }
        String[] listaNombres = {"Juan", "Maria", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofia", "Diego", "Valentina",
                "Jose", "Camila", "Miguel", "Isabella", "Fernando", "Lucia", "Alejandro", "Julia", "Ricardo", "Emma",
                "Andres", "Paula", "Esteban", "Martina", "Felipe", "Valeria", "Jorge", "Gabriela", "Gustavo", "Mariana",
                "Raul", "Renata", "Sergio", "Jimena", "Ignacio", "Natalia", "Hugo", "Adriana", "Pablo", "Daniela",
                "Angel", "Patricia", "Emilio", "Carmen", "Roberto", "Rosa", "Alberto", "Clara", "Benjamin", "Elena",
                "Guillermo", "Mercedes", "Rafael", "Beatriz", "Samuel", "Silvia", "Victor", "Julieta", "Javier", "Carolina",
                "Manuel", "Marina", "Rogelio", "Juana", "Enrique", "Vanesa", "Federico", "Francisca", "Mario", "Ines",
                "Simon", "Constanza", "Cesar", "Lorena", "Oscar", "Alicia", "Bruno", "Gabriela", "Eduardo", "Catalina",
                "Nicolas", "Agustina", "Hector", "Antonella", "Tomas", "Clarisa", "Alvaro", "Diana", "Francisco", "Anais",
                "Sebastian", "Bianca", "Daniel", "Florencia", "Maximiliano", "Pamela", "Marcos", "Luciana"};
        Random rand = new Random();
        int index1 = rand.nextInt(listaNombres.length);
        firstName = listaNombres[index1];
        String[] listaApellidos = {
                "Gonzalez", "Rodriguez", "Gomez", "Fernandez", "Lopez", "Martinez", "Perez", "Garcia", "Sanchez", "Romero",
                "Torres", "Ramirez", "Hernandez", "Ruiz", "Jimenez", "Diaz", "Moreno", "Alvarez", "Munioz", "Gutierrez",
                "Vargas", "Castanio", "Ortega", "Silva", "Nuniez", "Molina", "Castro", "Rojas", "Medina", "Cruz",
                "Navarro", "Cabrera", "Vargas", "Mendoza", "Soto", "Guerrero", "Ortiz", "Delgado", "Rios", "Chavez",
                "Mejia", "Vega", "Avila", "Acosta", "Miranda", "Fuentes", "Campos", "Correa", "Estrada", "Gallardo",
                "Velasco", "Montoya", "Penia", "Rivas", "Quintero", "Barrera", "Penia", "Cortes", "Aguirre", "Blanco",
                "Padilla", "Arroyo", "Ramos", "Salas", "Santos", "Arias", "Zamora", "Valencia", "Soler", "Peralta",
                "Rocha", "DelValle", "Salazar", "Esquivel", "Rubio", "Calderon", "Rosales", "Urbina", "Luna", "Escobar",
                "Vera", "Orozco", "Villalobos", "Duarte", "Ochoa", "Zuniga", "Rangel", "Aranda", "Vidal", "Barajas",
                "Saucedo", "Becerra", "Cervantes", "Velazquez", "Landa", "Gallardo", "Carranza", "Carrillo", "Lara", "DelRio"
        };
        Random random = new Random();
        int index2 = random.nextInt(listaApellidos.length);
        lastName= listaApellidos[index2];
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
            emailRegister = firstName+lastName+timeStamp+"@gmail.com";
        //}
                 Keyboard kb = page.keyboard();
        System.out.println("Se creara el usuario:"+emailRegister);
        page.click(selector.singUp);
        page.click(selector.continueWithEmail);
        page.waitForTimeout(1000);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill(selector.firstNameRegister,firstName);
        page.fill(selector.lastNameRegister, lastName);
        page.fill(selector.emailRegister, emailRegister);
        page.click(selector.rolRegister(rol));
        page.click(selector.nextButtonRegisterStep1);
        waitings.waitingJoinSelectorStep2();
        page.fill(selector.passwordRegister,"123123aA-");
        page.fill(selector.passwordConfirmationRegister,"123123aA-");
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
        saveUser();
        closeContext();
    }
    public void onboardingContentProvider(){
     String[] listaEmpresas = {"Industrias Sol", "MegaCorp", "InnovaTech", "Global Enterprises", "Emprendedores Unidos",
             "NexGen Solutions", "TechWorks", "Futura Innovación", "Excelencia Empresarial", "Alpha Enterprises",
             "Vanguardia Empresarial", "EcoSoluciones", "Visionary Group", "Sunrise Industries", "Pioneer Solutions",
             "NextLevel Ventures", "EcoTech Industries", "Infinite Innovations", "Starlight Corporation", "Omega Solutions",
             "Prime Enterprises", "Synergy Solutions", "Trinity Technologies", "Dynamic Innovations", "Horizon Enterprises",
             "Innovatech Systems", "Strategic Solutions", "Eagle Enterprises", "Summit Corporation", "Apex Solutions",
             "Quantum Innovations", "BlueSky Enterprises", "Phoenix Corporation", "Sunset Solutions", "FutureTech Ventures",
             "Optimal Solutions", "New Horizons Corporation", "Vertex Innovations", "Polaris Enterprises", "TechFusion",
             "InnoVest Corporation", "Elite Enterprises", "EcoTech Solutions", "Infinite Enterprises", "Visionary Ventures",
             "Synergy Innovations", "Innovatech Corporation", "Dynamic Enterprises", "NexGen Ventures", "Prime Innovations",
             "Trinity Enterprises", "Starlight Solutions", "Horizon Ventures", "Quantum Enterprises", "Eagle Innovations",
             "Apex Corporation", "Sunrise Ventures", "BlueSky Innovations", "FutureTech Solutions", "New Horizons Ventures",
             "Polaris Corporation", "TechFusion Innovations", "InnoVest Solutions", "Elite Corporation", "EcoTech Ventures",
             "Visionary Enterprises", "Synergy Corporation", "Dynamic Ventures", "NexGen Innovations", "Prime Enterprises",
             "Trinity Solutions", "Starlight Ventures", "Horizon Innovations", "Quantum Corporation", "Eagle Solutions",
             "Apex Ventures", "Sunrise Innovations", "BlueSky Enterprises", "FutureTech Corporation", "New Horizons Solutions",
             "Polaris Ventures", "TechFusion Innovations", "InnoVest Enterprises", "Elite Innovations", "EcoTech Corporation",
             "Visionary Solutions", "Synergy Ventures", "Dynamic Innovations", "NexGen Enterprises", "Prime Corporation",
             "Trinity Ventures", "Starlight Innovations", "Horizon Enterprises", "Quantum Ventures", "Eagle Corporation",
             "Apex Solutions", "Sunrise Innovations", "BlueSky Enterprises", "FutureTech Ventures", "New Horizons Solutions",
             "Polaris Corporation", "TechFusion Innovations", "InnoVest Solutions", "Elite Corporation", "EcoTech Ventures"};
     Random rand = new Random();
     int index1 = rand.nextInt(listaEmpresas.length);
     nombreEmpresa = listaEmpresas[index1];
     webSite=nombreEmpresa+".com";
     waitings.waitingOnboardingSelectorContentProviderStep1();
     page.fill(selector.companyNameClinicianOnboarding,nombreEmpresa);
     page.fill(selector.webSiteClinicianOnboarding,webSite);
     page.click(selector.nextButtonClinicianOnboardingStep1);
     waitings.waitingOnboardingSelectorContentProviderStep2();
     page.click(selector.skipForNowVerifyPhone);
    }
}
