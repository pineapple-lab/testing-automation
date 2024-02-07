package InsumosDocola;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Assertions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Instant;
import java.util.Random;
public class methodsDocola extends contextBaseDocola{
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
        System.out.println("Se creara el usuario:"+emailRegister);
        page.click("text=Sign up free");
        page.click(".border-primary > div > button:nth-of-type(3)");
        page.waitForTimeout(1000);
        page.fill("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) mat-form-field input", firstName);
        waitings.waitingJoinsSelectorStep1(rol);
        page.fill("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) mat-form-field input", lastName);
        page.fill("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-form-block-input mat-form-field input", emailRegister);
        page.click("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > mat-card:nth-of-type("+rol+")");
        page.click("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > button");
        waitings.waitingJoinSelectorStep2();
        page.fill("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) input","123123aA-");
        page.fill("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) input","123123aA-");
        page.click("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > button");
        waitings.waitingJoinSelectorStep3();
        page.click("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-checkbox input");
        page.click("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) re-captcha > div > div > iframe");
        page.click("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div > button");
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
                System.out.println("entre");
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
     page.fill(".registration-type-padding app-form-block-input:nth-of-type(1) input",nombreEmpresa);
     page.fill(".registration-type-padding app-form-block-input:nth-of-type(2) input",webSite);
     page.click(".registration-type-padding button");
     waitings.waitingOnboardingSelectorContentProviderStep2();
     page.click(".registration-type-padding > div > div:nth-of-type(2) > div:nth-of-type(2) > span");
    }
}
