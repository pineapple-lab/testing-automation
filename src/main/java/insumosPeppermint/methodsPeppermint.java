package insumosPeppermint;
import com.microsoft.playwright.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class methodsPeppermint extends assertions {
    public void iniciarTest(){
        shouldStopTest = false;
    }
    public void detenerTest(){
    shouldStopTest = true;
}
    public void serverStatus(){
        APIResponse response = page.request().post("https://peppermint-development.firebaseapp.com/");
        int statusCode = response.status();
        assert(response).ok();
        System.out.println("Server status: "+statusCode);
        System.out.println("-----------------------------------------------------------");
        printStream.println("Server status: "+statusCode);
        printStream.println("-----------------------------------------------------------");
    }
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
    public void startNavigation(){
        //printStream.println("\nAmbiente: "+linkNavigation+"\n");
        System.out.println("\nAmbiente: "+linkNavigation+"\n");
        Keyboard kb = page.keyboard();
        kb.press("Control+KeyN");
        page.navigate(linkNavigation);
    }
    public void printNumberExecutions(){
        if(execute>1) {
            System.out.println("El caso se va a ejecutar " + execute + " veces");
            printStream.println("El caso se va a ejecutar " + execute + " veces");
        }else {
            System.out.println("El caso se va a ejecutar " + execute + " vez");
            printStream.println("El caso se va a ejecutar " + execute + " vez");
        }
    }
    public void printNumberCasesExecuted (){
        if(counter>1) {
            System.out.println("El caso se ejecuto " + counter + " veces");
            printStream.println("El caso se ejecuto " + counter + " veces");
        }else {
            System.out.println("El caso se ejecuto " + counter + " vez");
            printStream.println("El caso se ejecuto " + counter + " vez");
        }
        int ejecucionesRestantes = execute - counter;
        System.out.println("Ejecuciones restantes: "+ejecucionesRestantes);
        printStream.println("Ejecuciones restantes: "+ejecucionesRestantes);
        if(ejecucionesRestantes==0){
            System.out.println("-----------------------------------------------------------");
            System.out.println("Fin de la ejecucion");
            printStream.println("-----------------------------------------------------------");
            printStream.println("Fin de la ejecucion");
        }
        System.out.println("-----------------------------------------------------------\n");
        printStream.println("-----------------------------------------------------------\n");
    }
    public void imprimirCantidadDeCasosEjecutadosRegistroInviteguest (){
        if(counterRegister>1) {
            System.out.println("El caso se ejecuto " + counterRegister + " veces\n");
            printStream.println("El caso se ejecuto " + counterRegister + " veces\n");
        }else {
            System.out.println("El caso se ejecuto " + counterRegister + " vez\n");
            printStream.println("El caso se ejecuto " + counterRegister + " vez\n");
        }
        int ejecucionesRestantes = execute - counterRegister;
        System.out.println("Ejecuciones restantes: "+ejecucionesRestantes);
        printStream.println("Ejecuciones restantes: "+ejecucionesRestantes);
    }
    public void buscarContenido(){
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search mat-form-field input");
        kb.insertText(searchingElement);
        kb.press("Enter");
        page.waitForSelector("tbody tr:first-child td:last-child button:last-child");
    }
    public void checkDomains(){
            String[] listasubDomains = {"gmail", "yahoo", "outlook"
            };
            Random rand = new Random();
            int index1 = rand.nextInt(listasubDomains.length);
            subDomain = listasubDomains[index1];
            String[] listadomainTopLevel = {
                    "com", "net", "org", "gov", "edu", "mil", "int", "eu", "biz", "info",
                    "coop", "aero", "museum", "name", "pro", "tel", "mobi", "asia", "cat", "jobs",
                    "post", "travel", "xxx", "moe", "io", "cc", "tv", "fm", "am", "me", "bz", "la",
                    "sh", "cx", "gs", "ms", "nu", "tk", "to", "ws", "nf", "pw", "hm", "ac", "ag", "ai",
                    "as", "bb", "bm", "bs", "ca", "co", "dm", "do", "gd", "gl", "gp", "gt", "hn", "ht",
                    "jm", "kn", "ky", "lc", "mq", "ms", "ni", "pa", "pr", "pm", "sx", "sv", "tc", "tt",
                    "us", "vc", "vg", "vi", "ai", "au", "ck", "fj", "fm", "gu", "ki", "mh", "mp", "nc",
                    "nf", "nr", "nu", "nz", "pf", "pg", "pn", "pw", "sb", "tk", "tl", "to", "tv", "vu",
                    "wf", "ws", "af", "bd", "bt", "in", "lk", "np", "pk", "ir", "iq", "jo", "kw", "lb",
                    "om", "ps", "qa", "sa", "sy", "tr", "ae", "ye", "cn", "hk", "jp", "kp", "kr", "mn",
                    "tw", "vn", "as", "ck", "nu", "tk", "ws", "fm", "mh", "pw", "to", "tv", "wf", "ws",
                    "au", "fj", "nc", "nz", "sb", "vu", "wf", "ws", "cy", "ge", "am", "az", "bh", "cy",
                    "ge", "iq", "ir", "il", "jo", "kw", "lb", "om", "ps", "qa", "sa", "sy", "tr", "ae",
                    "ye", "at", "be", "bg", "ch", "cz", "de", "dk", "ee", "es", "fi", "fr", "gr", "hr",
                    "hu", "ie", "is", "it", "li", "lt", "lu", "lv", "mc", "md", "me", "mk", "mt", "nl",
                    "no", "pl", "pt", "ro", "rs", "ru", "se", "si", "sk", "ua", "uk"
            };
            Random random = new Random();
            int index2 = random.nextInt(listadomainTopLevel.length);
            domainTopLevel = listadomainTopLevel[index2];
            emailRegister = "testDominios@" + subDomain + "." + domainTopLevel;
            page.click("text=Join Now");
            page.click("text=Begin your Membership");
            page.waitForSelector("text=More");
            page.fill("mat-card-content > app-mat-form-field:nth-of-type(1) input", emailRegister);
            if (page.isVisible("text=Invalid email.")) {
                System.out.println("no se acepto el dominio:" + emailRegister);
                System.exit(0);
            }
        }
    public void registerUser(){
        Keyboard kb = page.keyboard();
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
        if(configurationAdvancedRegistration==false) {
            emailRegister = firstName+lastName+timeStamp+"@mailinator.com";
        }
        saveUser();
        System.out.println("\nSe creara el usuario: " +emailRegister+ "\n");
        printStream.println("\nSe creara el usuario: " +emailRegister+ "\n");
        page.click("text=Join Now");
        //page.click("text=Begin your Membership");
        page.waitForSelector("text=Sign up with email");
        page.focus("mat-card-content > div > div:nth-of-type(1) app-mat-form-field input");
        kb.type(firstName);
        page.focus("mat-card-content > div > div:nth-of-type(2) app-mat-form-field input");
        kb.type(lastName);
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(1) input",emailRegister);
        page.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        page.waitForSelector("mat-calendar mat-calendar-header > div > div > button:nth-of-type(1)");
        page.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(1)");
        page.waitForSelector("mat-calendar mat-calendar-header > div > div > button:nth-of-type(2)");
        page.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(2)");
        page.waitForTimeout(900);
        page.waitForSelector("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        page.click("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        page.waitForSelector("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        page.click("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        page.waitForSelector("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        page.click("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input",passwordRegister);
        page.click("text=Sign up with email");
        if(linkNavigation== "https://peppermint-development.web.app/auth/login" || linkNavigation =="https://peppermint-qa.web.app/auth/login") {
            page.fill("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > app-mat-form-field input", cardholderName);
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) input");
            page.waitForTimeout(1000);
            page.focus("-paymentapp > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > input");
            page.waitForTimeout(1000);
            kb.insertText(cardNumber);
            page.focus("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForTimeout(1000);
            kb.insertText(monthExpired);
            page.focus("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) input");
            page.waitForTimeout(2000);
            kb.insertText(cvv);
            page.click("text=Start my Peppermint membership");
        }
        if(linkNavigation=="http://localhost:4200/auth/login") {
            page.fill("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(1) app-mat-form-field input", cardholderName);
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
            page.waitForTimeout(1000);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
            page.waitForTimeout(1000);
            kb.insertText(cardNumber);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForTimeout(1000);
            kb.insertText(monthExpired);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
            page.waitForTimeout(2000);
            kb.insertText(cvv);
            page.click("text=Pay $15.00");
        }
        page.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        page.click("text=Continue");
        page.click("mat-chip-list mat-chip:nth-of-type(1)");
        page.click("mat-chip-list mat-chip:nth-of-type(2)");
        page.click("mat-chip-list mat-chip:nth-of-type(3)");
        page.waitForTimeout(3000);
        page.click(".mat-horizontal-content-container button:nth-of-type(2)");
    }
    public void postDashboard(){
        Keyboard kb = page.keyboard();
        String[] listaParrafos = { "La inteligencia artificial está revolucionando diversas industrias, como la atención médica y la automoción.",
                "El cambio climático es una amenaza global que requiere una acción colectiva para mitigar sus efectos.",
                "La educación en línea ha experimentado un crecimiento significativo debido a la pandemia de COVID-19.",
                "La exploración espacial nos ha permitido comprender mejor el universo y nuestra posición en él.",
                "La biodiversidad es esencial para mantener el equilibrio de los ecosistemas y garantizar la supervivencia de las especies.",
                "La igualdad de género es un objetivo importante para lograr una sociedad justa y equitativa.",
                "La música desempeña un papel fundamental en la cultura y la expresión humana a lo largo de la historia.",
                "La ética en la inteligencia artificial es un tema crítico para garantizar decisiones justas y éticas en sistemas automatizados.",
                "La medicina moderna ha avanzado significativamente, mejorando la calidad de vida y prolongando la esperanza de vida.",
                "La diversidad cultural enriquece nuestras comunidades al celebrar las diferencias y promover la tolerancia.",
                "La sostenibilidad ambiental es esencial para proteger nuestro planeta y las generaciones futuras.",
                "La literatura clásica sigue siendo relevante y apreciada por su contribución a la cultura global.",
                "La globalización ha transformado la forma en que las empresas operan y las personas se conectan en todo el mundo.",
                "La inteligencia emocional es una habilidad valiosa para comprender y gestionar nuestras emociones en la vida cotidiana.",
                "La energía renovable desempeña un papel fundamental en la transición hacia fuentes de energía más limpias.",
                "La política y la gobernanza son temas cruciales para la toma de decisiones y la dirección de una nación.",
                "La ciberseguridad se ha vuelto esencial en un mundo digital, protegiendo la privacidad y los datos en línea.",
                "La robótica está impulsando avances en la automatización de tareas y la industria manufacturera.",
                "La historia antigua nos ofrece una visión única de las civilizaciones y eventos que moldearon el mundo.",
                "La tecnología blockchain está cambiando la forma en que realizamos transacciones y gestionamos datos.",
                "La nutrición y la salud están estrechamente relacionadas, influyendo en nuestra calidad de vida y bienestar.",
                "La filosofía explora cuestiones fundamentales sobre la existencia y el significado de la vida.",
                "La psicología estudia el comportamiento humano y cómo nuestras mentes funcionan en diversas situaciones.",
                "La nanotecnología tiene el potencial de revolucionar la medicina y la electrónica a escalas microscópicas.",
                "La arquitectura y el diseño influyen en la forma en que experimentamos el entorno construido.",
                "La sociología analiza las interacciones sociales y los patrones en la sociedad humana.",
                "La economía global afecta a las naciones y las empresas, influyendo en el comercio y la inversión.",
                "La astronomía nos permite explorar el universo y descubrir planetas, estrellas y galaxias distantes.",
                "La geología estudia la Tierra y sus procesos, incluyendo terremotos, volcanes y la formación de montañas.",
                "La química es fundamental para comprender la composición y las reacciones de la materia en el mundo natural.",
                "La biología es la ciencia de la vida, examinando desde las células hasta los ecosistemas y la evolución.",
                "La historia del arte rastrea la evolución de la expresión artística a lo largo de las épocas y culturas.",
                "La política ambiental busca abordar los desafíos ecológicos y conservar los recursos naturales.",
                "La música clásica es apreciada por su belleza y complejidad, interpretada por orquestas en todo el mundo.",
                "La física estudia las leyes fundamentales del universo, desde partículas subatómicas hasta la cosmología.",
                "La sociología del género explora las dinámicas de género y las cuestiones relacionadas con la igualdad.",
                "La neurociencia investiga el cerebro y el sistema nervioso, desentrañando los misterios de la mente humana.",
                "La inteligencia colectiva se refiere a la capacidad de grupos para resolver problemas y tomar decisiones.",
                "La inteligencia artificial en la atención médica está mejorando los diagnósticos y los tratamientos.",
                "La física cuántica desafía nuestra comprensión de la realidad en el nivel más fundamental.",
                "La literatura de ciencia ficción nos lleva a mundos imaginarios y plantea preguntas sobre el futuro.",
                "La psicología deportiva se centra en el rendimiento y la mentalidad de los atletas en competición.",
                "La ingeniería genética abre nuevas posibilidades para modificar el ADN y tratar enfermedades genéticas.",
                "La ética en la investigación científica es esencial para garantizar la integridad y la responsabilidad.",
                "La inteligencia artificial en el arte crea obras generadas por computadora y desafía las nociones de creatividad.",
                "La física de partículas explora las partículas subatómicas y sus interacciones en aceleradores de partículas.",
                "La sociología de la religión examina la influencia de la religión en la sociedad y la cultura.",
                "La medicina regenerativa busca reparar y reemplazar tejidos dañados o enfermos mediante la terapia celular.",
                "La neurociencia cognitiva investiga cómo procesamos la información y tomamos decisiones en el cerebro.",
                "La inteligencia artificial en los vehículos autónomos promete revolucionar la industria del transporte.",
                "La ingeniería ambiental se centra en resolver problemas relacionados con la contaminación y la sostenibilidad.",
                "La nanotecnología en la medicina tiene el potencial de ofrecer tratamientos personalizados y precisos.",
                "La física nuclear estudia las propiedades de los núcleos atómicos y las reacciones nucleares en el cosmos.",
                };
        Random rand = new Random();
        int index1 = rand.nextInt(listaParrafos.length);
        String parrafo = listaParrafos[index1];
        assertionsDashboard();
        page.click("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) quill-editor");
        kb.type(parrafo);
        page.click("app-user-dashboards > div > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) > div > div > app-activity-card:first-child > mat-card > div > div:nth-of-type(4) > div > div:nth-of-type(2) > div > button:nth-of-type(2)");
    }
    public void saveUser(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "INSERT INTO usuariosautomaticos (`emailRegistro`,`ambiente`) " +
                    "VALUES('"+emailRegister+"','"+linkNavigation+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void saveEmailLoop(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.inviteguest SET email = "+"'"+inviteGuestEmailLoop+"'"+" WHERE ID="+"'"+position+"'";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void saveEmail(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.inviteguest SET email = "+"'"+inviteGuestEmail+"'"+" WHERE ID="+"'"+counter+"'";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void getEmail(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.inviteguest WHERE ID = "+counterRegister+"");
            while(rs.next()){
                emailGuest =rs.getString(rs.findColumn("email"));
            }
        }catch(Exception e){
        }
        sqlclose();
    }
    public boolean login() {
        System.out.println("Iniciando login...");
        //printStream.println("Iniciando login...");
        Keyboard kb = page.keyboard();
        kb.press("F12");
        if (page.isVisible(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input") == false) {
            page.click("text=Sign in");
        }
        page.waitForSelector("text=Login with Google");
        page.waitForSelector("text=Login with Facebook");
        page.waitForSelector("text=Login with Email");
        Assertions.assertTrue(page.isVisible("text=Login with Google"));
        Assertions.assertTrue(page.isVisible("text=Login with Facebook"));
        Assertions.assertTrue(page.isVisible("text=Login with Email"));
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(1) input");
        kb.insertText(emailLogin);
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input");
        kb.insertText(passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
        page.waitForTimeout(1000);
        if(page.isVisible("text=Invalid username/email or password")){
            try {
                sqlconectar();
                Statement stm = CN.createStatement();
                stm.executeUpdate("DELETE FROM testbdpeppermint.usuariosautomaticos WHERE id= '"+idUsuario+"'");
                System.out.println("Usuario borrado:");
                System.out.println("id: "+idUsuario);
                System.out.println("Email: "+emailLogin);
                userDeleted++;
            } catch (Exception e) {
                sqlclose();
            }
            System.out.println("Cantidad borrados: "+userDeleted+"\n");
            return true;
        }
        while (true) {
            try {
                page.waitForSelector("text=Login Successfull!");
                Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        System.out.println("El login del usuario " + emailLogin + " se realizo con exito \n");
        return false;
        //printStream.println("El login del usuario "+emailLogin+" se realizo con exito \n");
    }

    public void loginAdmin(){
        System.out.println("Iniciando login...");
        //printStream.println("Iniciando login...");
        Keyboard kb = page.keyboard();
        kb.press("F12");
        page.waitForTimeout(500);
        if(page.isVisible(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input")==false) {
            page.click("text=Sign in");
        }
        page.waitForSelector("text=Login with Google");
        page.waitForSelector("text=Login with Facebook");
        page.waitForSelector("text=Login with Email");
        Assertions.assertTrue(page.isVisible("text=Login with Google"));
        Assertions.assertTrue(page.isVisible("text=Login with Facebook"));
        Assertions.assertTrue(page.isVisible("text=Login with Email"));
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(1) input");
        if(linkNavigation=="https://peppermint-development.web.app/auth/login"|| linkNavigation =="http://localhost:4200/auth/login" ) {
            kb.insertText(emailUserAdmin);
        }
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            kb.insertText(emailUserAdminQA);
        }
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input");
        kb.insertText(passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
        page.waitForSelector("text=Login Successfull!");
        Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
        System.out.println("El login del usuario "+emailUserAdmin+" se realizo con exito \n");
        //printStream.println("El login del usuario "+emailLogin+" se realizo con exito \n");
    }
    public void logout(){
        page.click("text=My Stuff");
        page.click("text=Sign out");
        page.waitForTimeout(3000);
    }
    public void sendFriendshipRequest(){
        Keyboard kb = page.keyboard();
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
        if(configurationAdvancedRegistration==false) {
            emailRegister = firstName+lastName+timeStamp+"@mailinator.com";
        }
        System.out.println("\nSe creara el usuario: " +emailRegister+ "\n");
        printStream.println("\nSe creara el usuario: " +emailRegister+ "\n");
        page.waitForSelector("text=Join Now");
        page.click("text=Join Now");
        page.fill("mat-card-content > div > div:nth-of-type(1) app-mat-form-field input",firstName);
        page.fill("mat-card-content > div > div:nth-of-type(2) app-mat-form-field input",lastName);
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(1) input",emailRegister);
        page.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        page.waitForSelector("mat-calendar mat-calendar-header > div > div > button:nth-of-type(1)");
        page.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(1)");
        page.waitForSelector("mat-calendar mat-calendar-header > div > div > button:nth-of-type(2)");
        page.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(2)");
        page.waitForTimeout(900);
        page.waitForSelector("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        page.click("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        page.waitForSelector("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        page.click("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        page.waitForSelector("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        page.click("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input",passwordRegister);
        page.click("text=Sign up with email");
        if(linkNavigation== "https://peppermint-development.web.app/auth/login" || linkNavigation =="https://peppermint-qa.web.app/auth/login") {
            page.fill("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > app-mat-form-field input", cardholderName);
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) input");
            page.waitForTimeout(1000);
            page.focus("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > input");
            page.waitForTimeout(1000);
            kb.insertText(cardNumber);
            page.focus("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForTimeout(1000);
            kb.insertText(monthExpired);
            page.focus("app-payment > div > div > mat-card .wrapper > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) input");
            page.waitForTimeout(2000);
            kb.insertText(cvv);
            page.click("text=Start my Peppermint membership");
        }
        if(linkNavigation=="http://localhost:4200/auth/login") {
            page.fill("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(1) app-mat-form-field input", cardholderName);
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
            page.waitForTimeout(1000);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
            page.waitForTimeout(1000);
            kb.insertText(cardNumber);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
            page.waitForTimeout(1000);
            kb.insertText(monthExpired);
            page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
            page.waitForTimeout(2000);
            kb.insertText(cvv);
            page.click("text=Pay $15.00");
        }
        page.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        page.waitForSelector("text=Continue");
        page.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        page.click("text=Continue");
        page.click("mat-chip-list mat-chip:nth-of-type(1)");
        page.click("mat-chip-list mat-chip:nth-of-type(2)");
        page.click("mat-chip-list mat-chip:nth-of-type(3)");
        page.waitForTimeout(3000);
        page.click(".mat-horizontal-content-container button:nth-of-type(2)");
        page.click("app-header > mat-toolbar>div:nth-of-type(3) > div > span > button:nth-of-type(1)");
        page.click("app-header > mat-toolbar>div:nth-of-type(2) > mat-card-content > mat-form-field > div > div:nth-of-type(1) > div:nth-of-type(4)");
        kb.type(userSendFriends);
        kb.press("Enter");
        System.out.println("Enviando solicitud de amistad");
        printStream.println("Enviando solicitud de amistad");
        page.click("app-search-results > div > main > div > mat-tab-group > div app-friends-card button");
        page.waitForTimeout(2000);
        logout();
        printStream.println("Solicitud de amistad enviada");
    }
    public void acceptFriendshipRequest(){
        emailLogin=emailAcceptFriendRequests;
        login();
        page.click("app-header > mat-toolbar>div:nth-of-type(3) > div > span > button:nth-of-type(3)");
        System.out.println("Aceptando solicitudes de amistad");
        printStream.println("Aceptando solicitudes de amistad");
        for(counterAcceptFriendship=0; counterAcceptFriendship<execute;counterAcceptFriendship++) {
            int counterInterno= counterAcceptFriendship+1;
            page.waitForTimeout(15000);
            page.click("app-notification > div > div > div:nth-of-type(2) > div:nth-of-type("+counterInterno+") button:nth-of-type(1)");
            page.waitForTimeout(15000);
        }
    }
    public void saveBookmark(){
        Keyboard kb = page.keyboard();
        if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
            emailLogin=emailUserBookmark;
        }
        if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            emailLogin=emailUserBookmarkQA;
        }
        int counterScroll = 10;
        login();
        page.waitForSelector("text=My workshops");
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/workshops");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/workshops");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/workshops");
        }
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
        assertionsAllWorkshop();
        page.focus("app-all-cards .container > div:nth-of-type(2)");
        page.dblclick("app-all-cards .container > div:nth-of-type(1) app-three-dots");
        for (counter=0; counter<execute;counter++){
            int counterInterno = counter+1;
            while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterScroll+") app-bookmark-icon > div > mat-icon")==true){
                page.focus("app-all-cards .container > div:nth-of-type(2)");
                kb.press("Control+End");
                counterScroll = counterScroll+10;
                page.waitForTimeout(3000);
            }
            do{
                page.focus("app-all-cards .container > div:nth-of-type("+counterInterno+")");
                counterInterno++;
            }while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon")==true);
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.focus("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.waitForSelector(".mat-menu-panel button:nth-of-type(1)");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon"));
        }
        counterScroll=7;
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/articles");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/articles");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/articles");
        }
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
        assertionAllArticle();
        page.focus("app-all-cards .container > div:nth-of-type(2)");
        page.dblclick("app-all-cards .container > div:nth-of-type(1) app-three-dots");
        for (counter=0; counter<execute;counter++){
            int counterInterno = counter+1;
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterScroll+") app-bookmark-icon > div > mat-icon")==true){
                page.focus("app-all-cards .container > div:nth-of-type(2)");
                kb.press("Control+End");
                counterScroll=counterScroll+7;
                page.waitForTimeout(3000);
            }
            do{
                page.focus("app-all-cards .container > div:nth-of-type("+counterInterno+")");
                counterInterno++;
            }while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon")==true);
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.waitForSelector(".mat-menu-panel button:nth-of-type(1)");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon"));
        }
        counterScroll=12;
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/videos");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/videos");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/videos");
        }
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
        assertionAllTechnique();
        page.focus("app-all-cards .container > div:nth-of-type(2)");
        page.dblclick("app-all-cards .container > div:nth-of-type(1) app-three-dots");
        for (counter=0;counter<execute;counter++){
            int counterInterno = counter+1;
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterScroll+") app-bookmark-icon > div > mat-icon")==true){
                page.focus("app-all-cards .container > div:nth-of-type(2)");
                kb.press("Control+End");
                counterScroll=counterScroll+10;
                page.waitForTimeout(3000);
            }
            do{
                page.focus("app-all-cards .container > div:nth-of-type("+counterInterno+")");
                counterInterno++;
            }while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon")==true);
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.waitForSelector(".mat-menu-panel button:nth-of-type(1)");
            page.click(".mat-menu-panel  button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon"));
        }
        counterScroll=10;
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/clubs");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/clubs");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/clubs");
        }
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
        assertionAlLClub();
        page.focus("app-all-cards .container > div:nth-of-type(2)");
        page.dblclick("app-all-cards .container > div:nth-of-type(1) app-three-dots");
        for (counter=0; counter <execute;counter++){
            int counterInterno = counter+1;
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterScroll+") app-bookmark-icon > div > mat-icon")==true){
                page.focus("app-all-cards .container > div:nth-of-type(2)");
                kb.press("Control+End");
                counterScroll=counterScroll+10;
                page.waitForTimeout(3000);
            }
            do{
                page.focus("app-all-cards .container > div:nth-of-type("+counterInterno+")");
                counterInterno++;
            }while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon")==true);
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.waitForSelector(".mat-menu-panel button:nth-of-type(1)");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-bookmark-icon > div > mat-icon"));
        }
        logout();
    }
    public void recommendUsers(){
        Keyboard kb = page.keyboard();
        if(page.isVisible("app-profile-description")==false){
            page.waitForSelector("text=My workshops");
        }
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/user/friends");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/user/friends");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/user/friends");
        }
        page.waitForSelector(".main-container > div > div:nth-of-type(3) > div > div:nth-of-type("+counter+") mat-card");
        page.click(".main-container > div > div:nth-of-type(3) > div > div:nth-of-type("+counter+") mat-card");
        page.waitForSelector("app-profile-description > div:nth-of-type(1) app-three-dots");
        page.click("app-profile-description > div:nth-of-type(1) app-three-dots");
        page.waitForSelector(".mat-menu-panel > div > button:nth-of-type(1)");
        page.waitForSelector(".mat-menu-panel > div > button:nth-of-type(2)");
        page.click(".mat-menu-panel > div > button:nth-of-type(1)");
        page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
        userSendRecomendation ="AAAAAAusuariorecomendacionpineapple";
        userSendRecomendationQA ="Paula Gomez";
        if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
            kb.insertText(userSendRecomendation);
        }
        if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            kb.insertText(userSendRecomendationQA);
        }
        page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips mat-chip-list mat-chip");
        page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
        if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
            page.waitForSelector("text=Your recommendation has been successfully sent");
        }
        if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            page.waitForSelector("text=Your recommendation was shared successfully!");
        }

    }
    public void sendRecommendation(){
        Keyboard kb = page.keyboard();

        page.waitForSelector("text=My workshops");
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/workshops");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/workshops");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/workshops");
        }
        for (counter=0; counter<execute;counter++){
           int counterInterno = counter+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            System.out.println(userSendRecomendation);
            if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                kb.insertText(userSendRecomendation);
            }
           if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
               kb.insertText(userSendRecomendationQA);
           }
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            if(linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.waitForSelector("text=Your recommendation has been successfully sent");
                Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.waitForSelector("text=Your recommendation was shared successfully!");
                Assertions.assertTrue(page.isVisible("text=Your recommendation was shared successfully!"));
            }
            System.out.println("\nRecomendaciones de workshops enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
            printStream.println("\nRecomendaciones de workshops enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
        }
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/articles");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/articles");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/articles");
        }
        for (counter=0; counter<execute;counter++){
            int counterInterno = counter+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                kb.insertText(userSendRecomendation);
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                kb.insertText(userSendRecomendationQA);
            }
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            if(linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.waitForSelector("text=Your recommendation has been successfully sent");
                Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.waitForSelector("text=Your recommendation was shared successfully!");
                Assertions.assertTrue(page.isVisible("text=Your recommendation was shared successfully!"));
            }
            System.out.println("\nRecomendaciones de articles enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
            printStream.println("\nRecomendaciones de articles enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
        }
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/videos");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/videos");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/videos");
        }
        for (counter=0; counter <execute;counter++){
            int counterInterno = counter+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                kb.insertText(userSendRecomendation);
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                kb.insertText(userSendRecomendationQA);
            }
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            if(linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.waitForSelector("text=Your recommendation has been successfully sent");
                Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.waitForSelector("text=Your recommendation was shared successfully!");
                Assertions.assertTrue(page.isVisible("text=Your recommendation was shared successfully!"));
            }
            System.out.println("\nRecomendaciones de techniques enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
            printStream.println("\nRecomendaciones de techniques enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
        }
        if(linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/clubs");
        }else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/videos");
        }else if (linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/videos");
        }
        for (counter=0; counter <execute;counter++){
            int counterInterno = counter+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                kb.insertText(userSendRecomendation);
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                kb.insertText(userSendRecomendationQA);
            }
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            if(linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.waitForSelector("text=Your recommendation has been successfully sent");
                Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            }
            if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.waitForSelector("text=Your recommendation was shared successfully!");
                Assertions.assertTrue(page.isVisible("text=Your recommendation was shared successfully!"));
            }
            System.out.println("\nRecomendaciones de clubs enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
            printStream.println("\nRecomendaciones de clubs enviadas: "+counterInterno+" Recomendaciones faltantes: "+execute);
        }
        logout();
    }
    public void sendInviteGuest(){
        Keyboard kb = page.keyboard();
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
                "Rocha", "Del Valle", "Salazar", "Esquivel", "Rubio", "Calderon", "Rosales", "Urbina", "Luna", "Escobar",
                "Vera", "Orozco", "Villalobos", "Duarte", "Ochoa", "Zuniga", "Rangel", "Aranda", "Vidal", "Barajas",
                "Saucedo", "Becerra", "Cervantes", "Velazquez", "Landa", "Gallardo", "Carranza", "Carrillo", "Lara", "DelRio"
        };
        Random random = new Random();
        int index2 = random.nextInt(listaApellidos.length);
        lastName= listaApellidos[index2];
        long timeStamp = Instant.now().toEpochMilli();
        if(configurationAdvancedRegistration==false) {
            inviteGuestEmail  = firstName+lastName+"_inviteGuest"+counter+"_"+timeStamp+"@mailinator.com";
        }

        page.click("text=My Stuff");
        page.click("text=Account Settings");
        page.click("text=Membership");
        page.click("text=Invite guests");
        System.out.println("Enviando invite guest...");
        printStream.println("Enviando invite guest...");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(2) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2) input");
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(2) input");
        kb.insertText("inviteGuest");
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
        kb.insertText(firstName);
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
        kb.type(lastName);
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2) input");
        kb.insertText(inviteGuestEmail);
        kb.press("Tab");
        saveEmail();
        if(execute>1){
            for(counter =1;counter<execute;counter++) {
                String[] listaNombresLoop = {"Juan", "Maria", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofia", "Diego", "Valentina",
                        "Jose", "Camila", "Miguel", "Isabella", "Fernando", "Lucia", "Alejandro", "Julia", "Ricardo", "Emma",
                        "Andrés", "Paula", "Esteban", "Martina", "Felipe", "Valeria", "Jorge", "Gabriela", "Gustavo", "Mariana",
                        "Raul", "Renata", "Sergio", "Jimena", "Ignacio", "Natalia", "Hugo", "Adriana", "Pablo", "Daniela",
                        "Angel", "Patricia", "Emilio", "Carmen", "Roberto", "Rosa", "Alberto", "Clara", "Benjamin", "Elena",
                        "Guillermo", "Mercedes", "Rafael", "Beatriz", "Samuel", "Silvia", "Victor", "Julieta", "Javier", "Carolina",
                        "Manuel", "Marina", "Rogelio", "Juana", "Enrique", "Vanesa", "Federico", "Francisca", "Mario", "Ines",
                        "Simon", "Constanza", "Cesar", "Lorena", "Oscar", "Alicia", "Bruno", "Gabriela", "Eduardo", "Catalina",
                        "Nicolas", "Agustina", "Hector", "Antonella", "Tomas", "Clarisa", "Alvaro", "Diana", "Francisco", "Anais",
                        "Sebastian", "Bianca", "Daniel", "Florencia", "Maximiliano", "Pamela", "Marcos", "Luciana"};
                Random randLoop = new Random();
                int index1Loop = randLoop.nextInt(listaNombresLoop.length);
                firstName = listaNombres[index1Loop];
                String[] listaApellidosLoop = {
                        "Gonzalez", "Rodríguez", "Gomez", "Fernandez", "Lopez", "Martinez", "Perez", "García", "Sanchez", "Romero",
                        "Torres", "Ramirez", "Hernandez", "Ruiz", "Jimenez", "Diaz", "Moreno", "Alvarez", "Munioz", "Gutierrez",
                        "Vargas", "Castanio", "Ortega", "Silva", "Nuniez", "Molina", "Castro", "Rojas", "Medina", "Cruz",
                        "Navarro", "Cabrera", "Vargas", "Mendoza", "Soto", "Guerrero", "Ortiz", "Delgado", "Rios", "Chavez",
                        "Mejia", "Vega", "Avila", "Acosta", "Miranda", "Fuentes", "Campos", "Correa", "Estrada", "Gallardo",
                        "Velasco", "Montoya", "Penia", "Rivas", "Quintero", "Barrera", "Penia", "Cortés", "Aguirre", "Blanco",
                        "Padilla", "Arroyo", "Ramos", "Salas", "Santos", "Arias", "Zamora", "Valencia", "Soler", "Peralta",
                        "Rocha", "Del Valle", "Salazar", "Esquivel", "Rubio", "Calderón", "Rosales", "Urbina", "Luna", "Escobar",
                        "Vera", "Orozco", "Villalobos", "Duarte", "Ochoa", "Zuniga", "Rangel", "Aranda", "Vidal", "Barajas",
                        "Saucedo", "Becerra", "Cervantes", "Velazquez", "Landa", "Gallardo", "Carranza", "Carrillo", "Lara", "Del Rio"
                };
                Random randomLoop = new Random();
                int index2Loop = randomLoop.nextInt(listaApellidosLoop.length);
                lastName= listaApellidos[index2Loop];
                long timeStampLoop = Instant.now().toEpochMilli();
                if(configurationAdvancedRegistration==false) {
                    inviteGuestEmailLoop  = firstName+lastName+"_inviteGuest"+counter+"_"+timeStampLoop+"@mailinator.com";
                }
                position=counter+1;
                page.click("text=Add another");
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+position+")>div:nth-of-type(1)>div:nth-of-type(2) input");
                kb.insertText("inviteguest");
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+position+")>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
                kb.insertText(firstName);
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+position+")>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
                kb.insertText(lastName);
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+position+")>div:nth-of-type(2)>div:nth-of-type(2) input");
                kb.insertText(inviteGuestEmailLoop);
                kb.press("Tab");
                saveEmailLoop();
            }
        }
        page.waitForTimeout(9000);
        if(counter==execute){
            page.click("text=Send invites");
        }
        page.waitForSelector("text=Guest pass has been sent successfully");
        page.waitForTimeout(40000);
    }
    public void registerInviteGuest(){
        Keyboard kb = page.keyboard();

        inviteGuest = "invite guest";
        page.navigate("https://www.mailinator.com/v4/public/inboxes.jsp");
        page.waitForSelector("#inbox_field");
        page.waitForTimeout(700);
        page.fill("#inbox_field",emailGuest);
        page.waitForTimeout(700);
        page.click("#inbox_pane > div:nth-of-type(1)>div:nth-of-type(5) button");
        //page.waitForTimeout(1000);
        page.waitForSelector(".os-padding table tr:nth-of-type(1) td:has-text('invites')");
        page.click(".os-padding table tr");
        page.waitForSelector(".wrapper-message-tabs ul li:nth-of-type(5) a");
        page.click(".wrapper-message-tabs ul li:nth-of-type(5) a");
        page.waitForSelector("#pills-links-content table td:has-text('register') a");
        page.click("#pills-links-content table td:has-text('register') a");
        page.waitForTimeout(900);
        List<Page> pages = context.pages();
        Page nuevaPestana = pages.get(pages.size() - 1);
        nuevaPestana.bringToFront();
        System.out.println("Registrando invite guest...");
        printStream.println("Registrando invite guest...");
        nuevaPestana.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        nuevaPestana.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(1)");
        nuevaPestana.click("mat-calendar mat-calendar-header > div > div > button:nth-of-type(2)");
        nuevaPestana.waitForSelector("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        nuevaPestana.click("mat-calendar tbody > tr:last-child > td:nth-of-type(2)");
        nuevaPestana.waitForSelector("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        nuevaPestana.click("mat-calendar tbody > tr:nth-of-type(2) > td:first-child");
        nuevaPestana.waitForSelector("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        nuevaPestana.click("mat-calendar tbody > tr:first-child > td:nth-of-type(4)");
        nuevaPestana.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input","123123aA");
        nuevaPestana.waitForTimeout(999);
        nuevaPestana.click("text=Sign up with email");
        nuevaPestana.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        nuevaPestana.click("text=Continue");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(1)");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(2)");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(3)");
        nuevaPestana.waitForTimeout(900);
        nuevaPestana.click(".mat-horizontal-content-container button:nth-of-type(2)");
        nuevaPestana.click("text=My stuff");
        nuevaPestana.click("text=Sign out");
        page.waitForTimeout(1000);
        nuevaPestana.close();
        kb.press("Alt+F4");
    }
    public void createTechnique(){
        String[] listaNombres = {  "Cómo la inteligencia artificial está transformando la medicina",
                "Impacto del cambio climático en la biodiversidad marina",
                "Los desafíos de la educación en línea durante la pandemia",
                "Descubrimiento de agua en la Luna: implicaciones para la exploración espacial",
                "Crisis económica global: lecciones de la recesión de 2008",
                "El auge de las criptomonedas y su impacto en las finanzas",
                "La importancia de la ciberseguridad en la era digital",
                "Avances en la lucha contra enfermedades infecciosas",
                "El futuro del trabajo: tendencias en teletrabajo y automatización",
                "Cómo las redes sociales influyen en la opinión pública",
                "Tecnologías emergentes que revolucionarán la industria automotriz",
                "La carrera por desarrollar una vacuna contra el VIH",
                "El renacimiento de la exploración espacial: Mars Rover y más",
                "La crisis de refugiados y los desafíos humanitarios",
                "Efectos del envejecimiento de la población en la atención médica",
                "Los avances en la energía renovable y la sostenibilidad",
                "La revolución de la inteligencia artificial en la atención médica",
                "Las implicaciones éticas de la edición de genes CRISPR",
                "El auge de la comida vegana y su impacto ambiental",
                "La ciberseguridad en tiempos de ataques de ransomware",
                "El papel de las redes sociales en la política contemporánea",
                "Desarrollo de vehículos autónomos: avances y desafíos",
                "Innovaciones en la robótica para asistencia médica",
                "Los desafíos de la conservación de la selva amazónica",
                "Cómo la inteligencia artificial está revolucionando la educación",
                "Nuevas terapias génicas para tratar enfermedades hereditarias",
                "La importancia de la privacidad de datos en línea",
                "Impacto de la pandemia en la industria del turismo",
                "La promesa y los peligros de la inteligencia artificial en la justicia",
                "Avances en la exploración del espacio profundo",
                "El futuro de la movilidad urbana: vehículos eléctricos y más",
                "Cómo la crisis climática está afectando a las megaciudades",
                "El papel de las tecnologías de la información en la telemedicina",
                "La revolución de las baterías: almacenamiento de energía",
                "La influencia de las redes sociales en la salud mental",
                "El impacto económico de la inteligencia artificial",
                "La lucha contra la desinformación en línea",
                "Avances en la investigación de células madre",
                "Las perspectivas de la inteligencia artificial en la música",
                "El desafío de la seguridad cibernética en las empresas",
                "La evolución de la realidad virtual y aumentada",
                "El futuro de la impresión 3D en la manufactura",
                "Desarrollo de terapias génicas para el cáncer",
                "Cómo la inteligencia artificial está transformando la agricultura",
                "La exploración de exoplanetas y la búsqueda de vida en el espacio",
                "El potencial de la fusión nuclear como fuente de energía",
                "Los avances en la tecnología de vehículos eléctricos",
                "El auge de las criptomonedas y su regulación",
                "La ética de la inteligencia artificial en la toma de decisiones",
                "Las implicaciones legales de la conducción autónoma",
                "El futuro de la realidad aumentada en la industria del entretenimiento",
                "Los desafíos de la seguridad en la Internet de las cosas (IoT)",
                "La importancia de la diversidad en la industria tecnológica",
                "Tendencias en la investigación del cáncer y la inmunoterapia",
                "Cómo la inteligencia artificial está revolucionando la atención al cliente",
                "El impacto de la inteligencia artificial en la creatividad artística",
                "El futuro de la educación superior en línea",
                "Nuevas estrategias para combatir las enfermedades infecciosas",
                "La evolución de la impresión 3D en la medicina",
                "El papel de las redes sociales en la democracia",
                "Las perspectivas de la inteligencia artificial en la traducción de idiomas",
                "Avances en la realidad virtual para la terapia médica",
                "Desarrollo de tecnologías de energía limpia",
                "La ética de la inteligencia artificial en la atención médica",
                "Cómo la inteligencia artificial está revolucionando el sector financiero",
                "El futuro de la privacidad en la era de la recopilación de datos",
                "Los desafíos de la seguridad cibernética en la atención médica",
                "Las implicaciones sociales de la realidad virtual",
                "El impacto de la inteligencia artificial en la industria manufacturera",
                "Tendencias en la investigación del Alzheimer y la demencia",
                "La evolución de la inteligencia artificial en los videojuegos",
                "El futuro de la movilidad aérea urbana: taxis voladores",
                "Nuevas terapias génicas para tratar enfermedades neurológicas",
                "La influencia de las redes sociales en la moda",
                "Cómo la inteligencia artificial está transformando la logística",
                "El potencial de la energía geotérmica como fuente de energía renovable",
                "El papel de la inteligencia artificial en la seguridad nacional",
                "Avances en la biotecnología agrícola",
                "La ética de la inteligencia artificial en la toma de decisiones médicas",
                "Los desafíos de la ciberseguridad en la infraestructura crítica",
                "El impacto de la inteligencia artificial en la educación musical",
                "El futuro de la impresión 4D en la construcción",
                "Nuevos enfoques para el tratamiento de enfermedades cardiovasculares",
                "La evolución de la realidad aumentada en el diseño de productos",
                "Tendencias en la investigación de energía nuclear",
                "Cómo la inteligencia artificial está revolucionando la atención al cliente",
                "El impacto de las redes sociales en la salud emocional",
                "Desarrollo de tecnologías de almacenamiento de energía avanzadas",
                "La ética de la inteligencia artificial en la toma de decisiones gubernamentales",
                "El futuro de la movilidad autónoma en el transporte público",
                "El auge de la biología sintética y sus aplicaciones",
                "El papel de la inteligencia artificial en la gestión de desastres naturales",
                "Avances en la robótica de asistencia personal",
                "Los desafíos de la seguridad cibernética en la industria del entretenimiento",
                "El impacto de la inteligencia artificial en la atención al cliente en línea",
                "Tendencias en la investigación de enfermedades autoinmunes",
                "La evolución de la realidad virtual en la terapia psicológica",
                "El futuro de la impresión 3D en la fabricación de alimentos",
                "Cómo la inteligencia artificial está transformando la publicidad en línea",
                "El potencial de la energía eólica offshore como fuente de energía",
                "Nuevas estrategias para la conservación de la vida marina",
                "La ética de la inteligencia artificial en la toma de decisiones empresariales",
                "Desarrollo de tecnologías de energía solar más eficientes",
                "El papel de la inteligencia artificial en la traducción automática",
                "El impacto de las redes sociales en la política global",
                "El futuro de la impresión 3D en la moda",
                "Avances en la tecnología de vehículos autónomos",
                "Los desafíos de la ciberseguridad en la era del Internet de las cosas",
                "Cómo la inteligencia artificial está revolucionando la atención médica pediátrica",
                "La evolución de la realidad aumentada en la educación",
                "Tendencias en la investigación de enfermedades raras",
                "El potencial de la energía mareomotriz como fuente de energía renovable",
                "Nuevos avances en la neurociencia cognitiva",
                "La ética de la inteligencia artificial en la toma de decisiones militares",
                "El futuro de la movilidad eléctrica en las ciudades",
                "El impacto de la inteligencia artificial en la agricultura de precisión",
                "Desarrollo de tecnologías de almacenamiento de datos a largo plazo",
                "El papel de la inteligencia artificial en la predicción del clima",
                "Avances en la biotecnología médica",
                "Los desafíos de la ciberseguridad en la industria aeroespacial",
                "Cómo la inteligencia artificial está transformando la atención médica mental",
                "Tendencias en la investigación de enfermedades inmunológicas",
                "La evolución de la realidad virtual en la terapia física",
                "El futuro de la impresión 3D en la construcción de viviendas",
                "Nuevas estrategias para el tratamiento de enfermedades genéticas",
                "La ética de la inteligencia artificial en la toma de decisiones judiciales",
                "El impacto de las redes sociales en la salud pública",
                "El potencial de la energía de fusión nuclear como fuente de energía",
                "Desarrollo de tecnologías de reciclaje más eficientes",
                "El papel de la inteligencia artificial en la seguridad de vehículos autónomos",
                "Avances en la biotecnología agrícola",
                "Los desafíos de la ciberseguridad en la atención médica remota",
                "Cómo la inteligencia artificial está revolucionando la detección de fraudes",
                "El futuro de la movilidad sostenible en áreas urbanas",
                "Tendencias en la investigación de enfermedades neurodegenerativas",
                "La evolución de la realidad aumentada en el turismo",
                "El impacto de la inteligencia artificial en la gestión de recursos hídricos",
                "Nuevos enfoques para el tratamiento del autismo",
                "La ética de la inteligencia artificial en la toma de decisiones financieras",
                "El futuro de la impresión 3D en la fabricación de medicamentos",
                "El papel de la inteligencia artificial en la detección de enfermedades infecciosas",
                "Avances en la robótica médica",
                "Los desafíos de la ciberseguridad en la infraestructura energética",
                "Cómo la inteligencia artificial está transformando la atención médica veterinaria"};
        Random rand = new Random();
        int index1 = rand.nextInt(listaNombres.length);
        titleTechnique = listaNombres[index1];
        System.out.println("Creando technique...");
        printStream.println("Creando technique...");
        System.out.println("\nSe creara la technqiue: " + titleTechnique + "\n");
        printStream.println("\nSe creara la technqiue: " + titleTechnique + "\n");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(2)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));

        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1) app-upload-media").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleTechnique);
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");
        kb.insertText(descriptionTechnique);
        page.click(".container > div:nth-of-type(2) app-generic-selects");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorTechnique+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagTechnique+")");
        //page.click(".margin-box  app-generic-selects > div > div > p");
        page.waitForSelector(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryTechnique+")");
       // page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryTechnique+")");
        page.waitForSelector(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
       //page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");
        page.waitForTimeout(1000);
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The technique was created successfully");
        Assertions.assertTrue(page.isVisible("text=The technique was created successfully"));
    }
    public void createSegment(){
        System.out.println("Creando Segment...");
        printStream.println("Creando Segment...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(3)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1) app-upload-media").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("form>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleSegments);
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        kb.insertText(descriptionSegments);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorSegments+")");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips");
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagSegments+")");
        page.click("app-text-box quill-editor > div:nth-of-type(2)");
        kb.insertText(transcriptSegments);
        //page.click("text=+ Add category");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categorySegments+")");
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categorySegments+")");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicSegments+")");
        page.click("form > div > div > div:nth-of-type(5) > div > button:nth-of-type(1)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div:nth-of-type(1) > button:nth-of-type(1)");
        page.waitForSelector("text=Techniques added successfully");
        Assertions.assertTrue(page.isVisible("text=Techniques added successfully"));
        page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
        page.click("text=Publish");
        page.click(".mat-dialog-container div:nth-of-type(2) button");
        page.waitForSelector("text=The segment was created successfully");
        Assertions.assertTrue(page.isVisible("text=The segment was created successfully"));
    }
    public void createLesson(){
        System.out.println("Creando Lesson...");
        printStream.println("Creando Lesson...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(4)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.click(".container > div:nth-of-type(4) button");
        page.click("tbody tr:first-child td:first-child label");
        page.click("app-mat-table > div:nth-of-type(1) > button");
        page.waitForSelector("text=Segments added successfully");
        Assertions.assertTrue(page.isVisible("text=Segments added successfully"));
        page.locator("app-upload-media input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleLesson);
        page.click(".container > div:nth-of-type(2) app-select-creator input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionLesson);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagLesson+")");
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryLesson+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicLesson+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicLesson+")");*/
        page.click("text=Publish");
        page.click(".mat-dialog-container div:nth-of-type(2) button");
        page.waitForSelector("text=The lesson was created successfully");
        Assertions.assertTrue(page.isVisible("text=The lesson was created successfully"));
    }
    public void createWorkshop() {
        System.out.println("Creando Workshop...");
        printStream.println("Creando Workshop...");
        String[] listaNombres = {"Curso de Programación Java", "Curso de Desarrollo Web", "Curso de Inteligencia Artificial", "Curso de Ciencia de Datos", "Curso de Diseño Gráfico",
                "Curso de Inglés Avanzado", "Curso de Marketing Digital", "Curso de Fotografía", "Curso de Música", "Curso de Cocina Internacional",
                "Curso de Yoga", "Curso de Psicología", "Curso de Matemáticas Avanzadas", "Curso de Historia del Arte", "Curso de Robótica", "Curso de Finanzas Personales",
                "Curso de Meditación", "Curso de Ciencias Sociales", "Curso de Astronomía", "Curso de Ecología", "Curso de Nutrición",
                "Curso de Agricultura Sostenible", "Curso de Jardinería", "Curso de Fitness y Entrenamiento", "Curso de Redes y Seguridad Informática", "Curso de Psicología Positiva",
                "Curso de Periodismo", "Curso de Escritura Creativa", "Curso de Cine y Producción Audiovisual", "Curso de Teatro", "Curso de Arquitectura",
                "Curso de Electricidad y Electrónica", "Curso de Historia Mundial", "Curso de Filosofía", "Curso de Economía", "Curso de Derecho",
                "Curso de Geografía", "Curso de Idiomas Extranjeros", "Curso de Contabilidad", "Curso de Recursos Humanos", "Curso de Biología",
                "Curso de Química", "Curso de Física", "Curso de Geología", "Curso de Paleontología", "Curso de Zoología",
                "Curso de Botánica", "Curso de Astronomía", "Curso de Ciencia de Datos", "Curso de Estadísticas", "Curso de Medicina",
                "Curso de Enfermería", "Curso de Odontología", "Curso de Veterinaria", "Curso de Farmacia", "Curso de Terapia Física",
                "Curso de Psicología Clínica", "Curso de Psiquiatría", "Curso de Trabajo Social", "Curso de Servicio Social", "Curso de Educación Especial",
                "Curso de Educación Física", "Curso de Educación Infantil", "Curso de Educación Primaria", "Curso de Educación Secundaria", "Curso de Educación Superior",
                "Curso de Arte y Diseño", "Curso de Arquitectura de Interiores", "Curso de Diseño de Moda", "Curso de Escultura", "Curso de Pintura",
                "Curso de Danza", "Curso de Teatro Musical", "Curso de Cerámica", "Curso de Joyería", "Curso de Artes Culinarias",
                "Curso de Repostería", "Curso de Panadería", "Curso de Pastelería", "Curso de Coctelería", "Curso de Vinos y Sommelier",
                "Curso de Gestión Empresarial", "Curso de Administración", "Curso de Marketing", "Curso de Ventas", "Curso de Emprendimiento",
                "Curso de Gestión de Proyectos", "Curso de Recursos Humanos", "Curso de Finanzas", "Curso de Contabilidad", "Curso de Economía",
                "Curso de Derecho Empresarial", "Curso de Comunicación", "Curso de Relaciones Públicas", "Curso de Publicidad", "Curso de Periodismo Digital",
                "Curso de Redacción de Contenidos", "Curso de SEO y Marketing Online", "Curso de Fotografía Digital", "Curso de Diseño Gráfico",
                "Curso de Animación 3D", "Curso de Videojuegos", "Curso de Desarrollo Web", "Curso de Programación", "Curso de Seguridad Informática",
                "Curso de Big Data y Analytics", "Curso de Cloud Computing", "Curso de Internet de las Cosas (IoT)", "Curso de Blockchain",
                "Curso de Realidad Virtual y Aumentada", "Curso de Robótica", "Curso de Automatización Industrial"};
        Random rand = new Random();
        int index1 = rand.nextInt(listaNombres.length);
        titleWorkshop = listaNombres[index1];
        Keyboard kb = page.keyboard();
        System.out.println("\nSe creara el workshop: " + titleWorkshop + "\n");
        printStream.println("\nSe creara el workshop: " + titleWorkshop + "\n");
        if ((page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)")) == false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(5)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        while (true) {
            try {
                page.waitForSelector(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
                Assertions.assertTrue(page.isVisible(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.focus(".ng-star-inserted > app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-mat-form-field input");
        kb.insertText(titleWorkshop);
        page.click(".ng-star-inserted app-select-creator");
        while (true) {
            try {
                page.waitForSelector(".cdk-overlay-pane mat-option:nth-of-type(" + creatorWorkshop + ")");
                Assertions.assertTrue(page.isVisible(".cdk-overlay-pane mat-option:nth-of-type(" + creatorWorkshop + ")"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.click(".cdk-overlay-pane mat-option:nth-of-type(" + creatorWorkshop + ")");
        page.click(".ng-star-inserted > app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-text-box quill-editor  > div:nth-of-type(2)");
        kb.insertText(descriptionWorkshop);
        page.click(".ng-star-inserted .mat-chip-list-wrapper");
        page.click(".cdk-overlay-pane mat-option:nth-of-type(" + tagWorkshop + ")");
        //page.click(".ng-star-inserted app-generic-selects > div > div > p");
        page.waitForTimeout(900);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.waitForTimeout(900);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(" + categoryWorkshop + ")");
        //page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        //page.waitForTimeout(100);
        kb.press("Tab");
        while (true) {
            try {
                page.waitForSelector(".cdk-overlay-container > div > div");
                Assertions.assertTrue(page.isVisible(".cdk-overlay-container > div > div"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.waitForTimeout(900);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(" + topicWorkshop + ")");
        page.waitForTimeout(1000);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) quill-editor > div:nth-of-type(2)");
        kb.insertText(targetAudienceWorkshop);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) quill-editor > div:nth-of-type(2)");
        kb.insertText(learningObjectiveWorkshop);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(3) quill-editor > div:nth-of-type(2)");
        kb.insertText(whatDoYouNeed);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(4) quill-editor > div:nth-of-type(2)");
        kb.insertText(howItWorks);
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(1)");
        page.click(".cdk-overlay-container mat-option:nth-of-type(" + purposeWorkshop + ")");
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(2)");
        page.click(".cdk-overlay-container mat-option:nth-of-type(" + skillsWorkshop + ")");
        page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(3)");
        page.click(".cdk-overlay-container mat-option:nth-of-type(" + physicalActvityWorkshop + ")");
        page.waitForTimeout(18000);
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.waitForSelector("app-breadcrumb > ul > li:nth-of-type(3)");
        page.click("form > div:nth-of-type(1) > div:nth-of-type(1) button");
        page.click("form > div:nth-of-type(1) > div:nth-of-type(2) button");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) button");
        page.click("form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
        kb.insertText(questionWorkshop);
        page.click("form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
        kb.insertText(answerWorkshop);
        page.click("form > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
        page.click(".cdk-overlay-container mat-option:nth-of-type(" + reviewerWorkshop + ")");
        page.click("form > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
        kb.insertText(reviewWorkshop);
        page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2) app-generic-selects > div input");
        page.click(".cdk-overlay-container mat-option:nth-of-type(" + studentWorkshop + ")");
        page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2) textarea");
        kb.insertText(descriptionWorkshop);
        page.click("form > div:nth-of-type(2) > div:nth-of-type(2) button:nth-of-type(1)");
        page.fill("mat-dialog-container input", addLinksWorkshop);
        page.click("mat-dialog-container div:nth-of-type(2) .material-popup button");
        page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("app-course-outlet-form app-course-lesson-form > button");
        page.click("app-course-outlet-form app-course-lesson-form > div:nth-of-type(2) button");
        page.click("mat-dialog-container tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div:nth-of-type(1) > button");
        page.waitForSelector("text=Lessons added successfully");
        Assertions.assertTrue(page.isVisible("text=Lessons added successfully"));
        //page.click("app-drag-drop-sorting div:nth-of-type(2) mat-expansion-panel-header");
        page.click("text=+ Add activities");
        page.click(".cdk-overlay-container button:nth-of-type(1)");
        page.click("text=+ Add activities");
        page.click(".cdk-overlay-container button:nth-of-type(2)");
        page.click("app-course-lesson-form > div:nth-of-type(1)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(1)");
        page.click("app-course-lesson-form > div:nth-of-type(1)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(2)");
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(1) mat-form-field input");
        kb.insertText(titleZoomWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) mat-form-field input");
        kb.insertText(deadlineWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) mat-form-field input");
        page.click(".clock-face__container > div:last-child button");
        page.click(".clock-face__container > div:last-child button");
        page.click(".mat-dialog-actions div:nth-of-type(2) button");
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(3) mat-form-field input");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(4) mat-form-field input");
        kb.insertText("1");
        page.fill("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(3) textarea", descriptionZoomWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(4) input");
        kb.insertText(zoomUrlWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(3) input");
        kb.insertText("2");
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
        kb.insertText(activitiesTitleWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
        kb.insertText(activitiesDescriptionWorkshop);
        page.locator("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div input[type=file]").setInputFiles(Paths.get(pathVideo));
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
        kb.insertText(syncUpTitleWorkshop);
        page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
        kb.insertText(syncUpDescriptionWorkshop);
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(1)");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(2)");
        page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(3)");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        if (page.isEnabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar tbody tr:last-child td:last-child");
        } else if (page.isDisabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar > mat-calendar-header > div > div > button:nth-of-type(3)");
            page.click("mat-calendar tbody tr:last-child td:last-child");
        }
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-pane mat-option:nth-of-type(" + instructorSoloWithInstructor + ")");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) .mat-checkbox-layout ");
        page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        if (page.isEnabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar tbody tr:last-child td:last-child");
        } else if (page.isDisabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar > mat-calendar-header > div > div > button:nth-of-type(3)");
            page.click("mat-calendar tbody tr:last-child td:last-child");
        }
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-pane mat-option:nth-of-type(" + instructorGroupWithInstructor + ")");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) .mat-checkbox-layout");
        page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(1) mat-form-field input");
        kb.insertText(maxStudentsGroupWithInstructor);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(2) mat-form-field input");
        kb.insertText(optimalBuddyGroupGroupWithInstructor);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
        if (page.isEnabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar tbody tr:last-child td:last-child");
        } else if (page.isDisabled("mat-calendar tbody tr:last-child td:nth-last-child(2)")) {
            page.click("mat-calendar > mat-calendar-header > div > div > button:nth-of-type(3)");
            page.click("mat-calendar tbody tr:last-child td:last-child");
        }
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(2) input");
        kb.insertText(maxStudentsGroup);
        page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(2)  input");
        kb.insertText(optimalBuddyGroup);
        page.click("text=Publish");//app-admin-top-bar > div button:nth-of-type(3)
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        while (true) {
            try {
                page.waitForSelector("text=The workshop was created successfully");
                Assertions.assertTrue(page.isVisible("text=The workshop was created successfully"));
                break;
            } catch (PlaywrightException e) {
            }
        }
    }

    public void enrollWorkshop(){
        Elements elements1;
        Elements elements2;
        String idRadiowithgroup="";
        String idRadiogroup="";
        String idRadiosolo ="";
        enum expected{
            solo,
            groupwithinstructor,
            group
        }
        expected var = expected.valueOf(enrollModality);
        page.waitForSelector("text=My workshops");
        assertionsHeader();
        assertionsDashboard();
        assertionsPopupsDashboard();
        if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/workshops");
        } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            page.navigate("https://peppermint-qa.web.app/content/workshops");
        } else if(linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/workshops");

        }
        assertionsAllWorkshop();
        page.click("app-all-cards .container > div:nth-of-type(2)");
        System.out.println("Enrolando usuario");
        printStream.println("Enrolando usuario");
        assertionsInsideWorkshop();
        page.click("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(1) > div > mat-card > div > button");
        page.waitForSelector("mat-card > div:nth-of-type(2) > .div-ledby");
        assertionsPopUpModalitysPaso1();
        String innerHTML= page.innerHTML(".mat-horizontal-content-container");
        page.waitForTimeout(500);
        Document doc = Jsoup.parse(innerHTML);
        String matradiogroup="mat-radio-group > mat-card";
        Elements elementsCard  = doc.select(matradiogroup);
        Node GroupWithInstructor;
        Node Solo;
        Node Group;
        for (Element element : elementsCard) {
            boolean led = element.childNode(1).childNodes().size() == 2;
            boolean left = element.childNode(2).childNodes().size() == 5;
            if(led && left) {
                GroupWithInstructor = element.childNode(2).childNode(3);
                Element group = (Element) GroupWithInstructor;
                Elements radioButtons = group.select(".mat-radio-button");
                idRadiowithgroup = radioButtons.attr("id");
            }
            if(led && !left){
                Solo = element.childNode(2).childNode(2);
                Element group = (Element) Solo;
                Elements radioButtons = group.select(".mat-radio-button");
                idRadiosolo= radioButtons.attr("id");
            }
            if(!led && left){
                Group = element.childNode(2).childNode(3);
                Element group = (Element) Group;
                Elements radioButtons = group.select(".mat-radio-button");
                idRadiogroup= radioButtons.attr("id");
            }
        }
        switch (var){
            case solo://
                page.click("#"+idRadiosolo);
                break;
            case groupwithinstructor:
                        page.click("#"+idRadiowithgroup);
                break;
            case group:
                page.click("#"+idRadiogroup);
                break;
        }
        page.click("mat-stepper > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(3)> button:nth-of-type(2)");
        assertionsPopUpModalitysPaso2();
        page.click("app-guest-invite > div > div:nth-of-type(2) p");
        System.out.println("Enroll realizado con exito\n");
        printStream.println("Enroll realizado con exito\n");
        position=counter;
        saveEmailEnrollWorkshop();
    }
    public void saveEmailEnrollWorkshop(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.datoslogin SET userName = "+"'"+emailLogin+"'"+" WHERE id="+"'"+position+"'";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void completeAssignmentActivity(){
        page.waitForSelector("text=My workshops");
        if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/workshops");
        } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            page.navigate("https://peppermint-qa.web.app/content/workshops");
        } else if(linkNavigation=="http://localhost:4200/auth/login"){
            page.navigate("http://localhost:4200/content/workshops");

        }
        assertionsAllWorkshop();
        page.click("app-all-cards > div:first-child > div > div:nth-of-type(2)");
        page.click("app-progress-tab > div > app-timeline > div > div > div:nth-of-type(2)");
        while (true) {
            try {
                page.waitForSelector("mat-tab-header");
                Assertions.assertTrue(page.isVisible("mat-tab-header"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        while (true) {
            try {
                page.waitForSelector("app-schedule > mat-card > div:nth-of-type(2) > div > div:nth-of-type(2)");
                Assertions.assertTrue(page.isVisible("app-schedule > mat-card > div:nth-of-type(2) > div > div:nth-of-type(2)"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.click("app-schedule > mat-card > div:nth-of-type(2) > div > div:nth-of-type(2)");
        if(!uploadImageVideo) {
            page.locator("app-submit-popup > mat-card>div:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathVideo));
            page.click("app-submit-popup > mat-card > div:nth-of-type(2)");
        }else {
            page.locator("app-submit-popup > mat-card>div:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
            page.click("app-submit-popup > mat-card > div:nth-of-type(2)");
        }
        uploadImageVideo= !uploadImageVideo;
        page.click("app-schedule > mat-card > div:nth-of-type(3) > div > div:nth-of-type(2)");
        page.click("app-class-page > div > div > div:nth-of-type(1) button");
    }
    public void replyAssignmentActivity(){
        if ((page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)")) == false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(10)");
        page.waitForTimeout(7000);
        page.waitForSelector("table > tbody > tr:first-child > td:last-child button");
        page.click("thead > tr > th:nth-of-type(2) span");
        page.click("table > tbody > tr:first-child > td:last-child button");
        page.click("text=Start");
        page.waitForSelector("text=Retake");
        for(counter=1;counter<=execute;counter++) {
            page.waitForTimeout(2000);
            page.click("app-annotation-view > div > div:nth-of-type("+counter+")");
        }
        page.click("app-annotation  mat-card mat-card-content > div > div > button:nth-of-type(1)");
        page.click("text=Send");
        page.waitForSelector("text=Video Sent Successfully!");
    }
    public void joinUserManyWorkshop(){
        Keyboard kb = page.keyboard();
        emailLogin=emailUserEnrollMultiplesWorkshops;
        login();
        if(linkNavigation=="http://localhost:4200/user/plans"){
            page.navigate("http://localhost:4200/content/workshops");
        } else if (linkNavigation=="https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/workshops");
        } else if (linkNavigation=="https://peppermint-qa.web.app/auth/login") {
            page.navigate("https://peppermint-qa.web.app/content/workshops");
        }
        for (counter=0; counter <execute;counter++){
            int counterInterno = counter+2;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+")")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+")");
            page.waitForSelector("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(1) > div > mat-card > div > button");
            page.click("app-overview-tab-view > div > div:nth-of-type(2) > div:nth-of-type(1) > div > mat-card > div > button");
            page.waitForSelector(".mat-horizontal-content-container mat-radio-group:nth-of-type(1) mat-radio-button");
            if(page.isVisible(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button")==true){
                page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button");
            }else {
                page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(1) mat-radio-button");
            }
            page.click(".mat-horizontal-content-container > div:nth-of-type(1) > div:nth-of-type(3) > button:nth-of-type(2)");
            page.click("app-guest-invite > div > div:nth-of-type(2) p");
            page.click("app-breadcrumb ul li:nth-of-type(1) a");
        }
    }
    public void createArticle(){
        String[] listaNombres = {  "Cómo la inteligencia artificial está transformando la medicina",
                "Impacto del cambio climático en la biodiversidad marina",
                "Los desafíos de la educación en línea durante la pandemia",
                "Descubrimiento de agua en la Luna: implicaciones para la exploración espacial",
                "Crisis económica global: lecciones de la recesión de 2008",
                "El auge de las criptomonedas y su impacto en las finanzas",
                "La importancia de la ciberseguridad en la era digital",
                "Avances en la lucha contra enfermedades infecciosas",
                "El futuro del trabajo: tendencias en teletrabajo y automatización",
                "Cómo las redes sociales influyen en la opinión pública",
                "Tecnologías emergentes que revolucionarán la industria automotriz",
                "La carrera por desarrollar una vacuna contra el VIH",
                "El renacimiento de la exploración espacial: Mars Rover y más",
                "La crisis de refugiados y los desafíos humanitarios",
                "Efectos del envejecimiento de la población en la atención médica",
                "Los avances en la energía renovable y la sostenibilidad",
                "La revolución de la inteligencia artificial en la atención médica",
                "Las implicaciones éticas de la edición de genes CRISPR",
                "El auge de la comida vegana y su impacto ambiental",
                "La ciberseguridad en tiempos de ataques de ransomware",
                "El papel de las redes sociales en la política contemporánea",
                "Desarrollo de vehículos autónomos: avances y desafíos",
                "Innovaciones en la robótica para asistencia médica",
                "Los desafíos de la conservación de la selva amazónica",
                "Cómo la inteligencia artificial está revolucionando la educación",
                "Nuevas terapias génicas para tratar enfermedades hereditarias",
                "La importancia de la privacidad de datos en línea",
                "Impacto de la pandemia en la industria del turismo",
                "La promesa y los peligros de la inteligencia artificial en la justicia",
                "Avances en la exploración del espacio profundo",
                "El futuro de la movilidad urbana: vehículos eléctricos y más",
                "Cómo la crisis climática está afectando a las megaciudades",
                "El papel de las tecnologías de la información en la telemedicina",
                "La revolución de las baterías: almacenamiento de energía",
                "La influencia de las redes sociales en la salud mental",
                "El impacto económico de la inteligencia artificial",
                "La lucha contra la desinformación en línea",
                "Avances en la investigación de células madre",
                "Las perspectivas de la inteligencia artificial en la música",
                "El desafío de la seguridad cibernética en las empresas",
                "La evolución de la realidad virtual y aumentada",
                "El futuro de la impresión 3D en la manufactura",
                "Desarrollo de terapias génicas para el cáncer",
                "Cómo la inteligencia artificial está transformando la agricultura",
                "La exploración de exoplanetas y la búsqueda de vida en el espacio",
                "El potencial de la fusión nuclear como fuente de energía",
                "Los avances en la tecnología de vehículos eléctricos",
                "El auge de las criptomonedas y su regulación",
                "La ética de la inteligencia artificial en la toma de decisiones",
                "Las implicaciones legales de la conducción autónoma",
                "El futuro de la realidad aumentada en la industria del entretenimiento",
                "Los desafíos de la seguridad en la Internet de las cosas (IoT)",
                "La importancia de la diversidad en la industria tecnológica",
                "Tendencias en la investigación del cáncer y la inmunoterapia",
                "Cómo la inteligencia artificial está revolucionando la atención al cliente",
                "El impacto de la inteligencia artificial en la creatividad artística",
                "El futuro de la educación superior en línea",
                "Nuevas estrategias para combatir las enfermedades infecciosas",
                "La evolución de la impresión 3D en la medicina",
                "El papel de las redes sociales en la democracia",
                "Las perspectivas de la inteligencia artificial en la traducción de idiomas",
                "Avances en la realidad virtual para la terapia médica",
                "Desarrollo de tecnologías de energía limpia",
                "La ética de la inteligencia artificial en la atención médica",
                "Cómo la inteligencia artificial está revolucionando el sector financiero",
                "El futuro de la privacidad en la era de la recopilación de datos",
                "Los desafíos de la seguridad cibernética en la atención médica",
                "Las implicaciones sociales de la realidad virtual",
                "El impacto de la inteligencia artificial en la industria manufacturera",
                "Tendencias en la investigación del Alzheimer y la demencia",
                "La evolución de la inteligencia artificial en los videojuegos",
                "El futuro de la movilidad aérea urbana: taxis voladores",
                "Nuevas terapias génicas para tratar enfermedades neurológicas",
                "La influencia de las redes sociales en la moda",
                "Cómo la inteligencia artificial está transformando la logística",
                "El potencial de la energía geotérmica como fuente de energía renovable",
                "El papel de la inteligencia artificial en la seguridad nacional",
                "Avances en la biotecnología agrícola",
                "La ética de la inteligencia artificial en la toma de decisiones médicas",
                "Los desafíos de la ciberseguridad en la infraestructura crítica",
                "El impacto de la inteligencia artificial en la educación musical",
                "El futuro de la impresión 4D en la construcción",
                "Nuevos enfoques para el tratamiento de enfermedades cardiovasculares",
                "La evolución de la realidad aumentada en el diseño de productos",
                "Tendencias en la investigación de energía nuclear",
                "Cómo la inteligencia artificial está revolucionando la atención al cliente",
                "El impacto de las redes sociales en la salud emocional",
                "Desarrollo de tecnologías de almacenamiento de energía avanzadas",
                "La ética de la inteligencia artificial en la toma de decisiones gubernamentales",
                "El futuro de la movilidad autónoma en el transporte público",
                "El auge de la biología sintética y sus aplicaciones",
                "El papel de la inteligencia artificial en la gestión de desastres naturales",
                "Avances en la robótica de asistencia personal",
                "Los desafíos de la seguridad cibernética en la industria del entretenimiento",
                "El impacto de la inteligencia artificial en la atención al cliente en línea",
                "Tendencias en la investigación de enfermedades autoinmunes",
                "La evolución de la realidad virtual en la terapia psicológica",
                "El futuro de la impresión 3D en la fabricación de alimentos",
                "Cómo la inteligencia artificial está transformando la publicidad en línea",
                "El potencial de la energía eólica offshore como fuente de energía",
                "Nuevas estrategias para la conservación de la vida marina",
                "La ética de la inteligencia artificial en la toma de decisiones empresariales",
                "Desarrollo de tecnologías de energía solar más eficientes",
                "El papel de la inteligencia artificial en la traducción automática",
                "El impacto de las redes sociales en la política global",
                "El futuro de la impresión 3D en la moda",
                "Avances en la tecnología de vehículos autónomos",
                "Los desafíos de la ciberseguridad en la era del Internet de las cosas",
                "Cómo la inteligencia artificial está revolucionando la atención médica pediátrica",
                "La evolución de la realidad aumentada en la educación",
                "Tendencias en la investigación de enfermedades raras",
                "El potencial de la energía mareomotriz como fuente de energía renovable",
                "Nuevos avances en la neurociencia cognitiva",
                "La ética de la inteligencia artificial en la toma de decisiones militares",
                "El futuro de la movilidad eléctrica en las ciudades",
                "El impacto de la inteligencia artificial en la agricultura de precisión",
                "Desarrollo de tecnologías de almacenamiento de datos a largo plazo",
                "El papel de la inteligencia artificial en la predicción del clima",
                "Avances en la biotecnología médica",
                "Los desafíos de la ciberseguridad en la industria aeroespacial",
                "Cómo la inteligencia artificial está transformando la atención médica mental",
                "Tendencias en la investigación de enfermedades inmunológicas",
                "La evolución de la realidad virtual en la terapia física",
                "El futuro de la impresión 3D en la construcción de viviendas",
                "Nuevas estrategias para el tratamiento de enfermedades genéticas",
                "La ética de la inteligencia artificial en la toma de decisiones judiciales",
                "El impacto de las redes sociales en la salud pública",
                "El potencial de la energía de fusión nuclear como fuente de energía",
                "Desarrollo de tecnologías de reciclaje más eficientes",
                "El papel de la inteligencia artificial en la seguridad de vehículos autónomos",
                "Avances en la biotecnología agrícola",
                "Los desafíos de la ciberseguridad en la atención médica remota",
                "Cómo la inteligencia artificial está revolucionando la detección de fraudes",
                "El futuro de la movilidad sostenible en áreas urbanas",
                "Tendencias en la investigación de enfermedades neurodegenerativas",
                "La evolución de la realidad aumentada en el turismo",
                "El impacto de la inteligencia artificial en la gestión de recursos hídricos",
                "Nuevos enfoques para el tratamiento del autismo",
                "La ética de la inteligencia artificial en la toma de decisiones financieras",
                "El futuro de la impresión 3D en la fabricación de medicamentos",
                "El papel de la inteligencia artificial en la detección de enfermedades infecciosas",
                "Avances en la robótica médica",
                "Los desafíos de la ciberseguridad en la infraestructura energética",
                "Cómo la inteligencia artificial está transformando la atención médica veterinaria"
        };
        Random rand = new Random();
        int index1 = rand.nextInt(listaNombres.length);
        titleArticle = listaNombres[index1];
        System.out.println("Creando Articulo...");
        printStream.println("Creando Articulo...");
        System.out.println("\nSe creara el article: " + titleArticle + "\n");
        printStream.println("\nSe creara el article: " + titleArticle + "\n");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(6)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field input");
        kb.insertText(titleArticle);
        page.click(".container > div:nth-of-type(1) app-generic-selects");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorArticle+")");
        page.focus(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        kb.insertText(descriptionArticle);
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1)  > div > app-mat-form-field:nth-of-type(1)");
        kb.insertText(estimatedReadTime);
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(1)");
        //kb.press("Enter");
        //page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        while (true) {
            try {
                page.waitForSelector(".cdk-overlay-container > div > div");
                Assertions.assertTrue(page.isVisible(".cdk-overlay-container > div > div"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicArticle+")");
        page.waitForTimeout(500);
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("text=Add text");
        page.click("text=Add title");
        page.click("text=Add image");
        page.click("text=Add video");
        page.waitForSelector("mat-list > div:nth-of-type(1)");
        page.waitForSelector("mat-list > div:nth-of-type(2)");
        page.waitForSelector("mat-list > div:nth-of-type(3)");
        page.waitForSelector("mat-list > div:nth-of-type(4)");
        page.click("app-drag-drop-sorting mat-list > div:nth-of-type(1) quill-editor > div:nth-of-type(2)");
        page.waitForTimeout(500);
        kb.insertText(textContent);
        kb.press("Control+Shift+ArrowLeft");
        page.click("quill-editor > div:nth-of-type(1) button:nth-of-type(7)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div > button");
        page.waitForTimeout(900);
        page.focus("app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div > div  mat-form-field input");
        page.waitForTimeout(900);
        kb.type(contentTitle);
        //kb.press("Tab");
        page.locator("app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The article was created successfully");
        Assertions.assertTrue(page.isVisible("text=The article was created successfully"));
    }
    public void createEvent(){
        System.out.println("Creando Evento...");
        printStream.println("Creando Evento...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(7)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.waitForTimeout(900);
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(titleEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2) textarea");
        kb.insertText(descriptionEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(2)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(urlZoomEvent);
        page.click("app-events-form > div > div > div:nth-of-type(2) mat-chip-list input");
        while (true) {
            try {
                page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div");
                Assertions.assertTrue(page.isVisible(".cdk-overlay-connected-position-bounding-box > div"));
                break;
            } catch (PlaywrightException e) {
            }
        }
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+clubEvent+")");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) button");
        if(page.isEnabled(".mat-calendar-content tbody > tr:last-child > td:nth-last-child(2)")){
            page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
            page.click("ngx-mat-timepicker tbody tr:nth-of-type(3) td:first-child button");
            page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        }else if(page.isDisabled(".mat-calendar-content tbody > tr:last-child > td:nth-last-child(2)")){
            page.click("ngx-mat-calendar > ngx-mat-calendar-header > div > div > button:nth-of-type(3)");
            page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
            page.click("ngx-mat-timepicker tbody tr:nth-of-type(3) td:first-child button");
            page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        }
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) button");
        if(page.isEnabled(".mat-calendar-content tbody > tr:last-child > td:nth-last-child(2)")){
            page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
            page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        }else if(page.isDisabled(".mat-calendar-content tbody > tr:last-child > td:nth-last-child(2)")){
            page.click("ngx-mat-calendar > ngx-mat-calendar-header > div > div > button:nth-of-type(3)");
            page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
            page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        }
        page.click("app-events-form > div > div > .btn-radius-secondary > div:nth-of-type(2) > div:nth-of-type(3) > mat-form-field");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("mat-dialog-container div:nth-of-type(2) button:nth-of-type(1)");
        page.waitForSelector("text=The event was created successfully");
        Assertions.assertTrue(page.isVisible("text=The event was created successfully"));
    }
    public void deleteEvent(){
        System.out.println("Eliminando evento...");
        printStream.println("Eliminando evento...");
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search input");
        kb.insertText(titleEvent);
        page.click("tbody tr:first-child td:last-child button:last-child");
        page.click("app-alert div > div:nth-of-type(3) button:nth-of-type(2)");
    }
    public void createTaxonomy(){
        System.out.println("Creando Taxonomy...");
        printStream.println("Creando Taxonomy...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content taxonomy");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleCategory); //hardcode falta conexion con bd
        page.click("form mat-dialog-content .mat-button-wrapper");
        page.focus("form mat-dialog-content  .ng-star-inserted mat-form-field input");
        kb.insertText(titleTopic); //hardcode falta conexion con bd
        page.click("text=+ Add subtopic");
        page.click("mat-dialog-content > div:nth-of-type(2) .subTopic mat-form-field");
        kb.insertText(titleSubTopic);
        page.click("text=Save");
        page.waitForSelector("text=The category was created successfully");
        Assertions.assertTrue(page.isVisible("text=The category was created successfully"));
    }
    public void createTag(){
        System.out.println("Creando Tag...");
        printStream.println("Creando Tag...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content tags");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleTag);
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.waitForSelector("mat-chip");
        page.click("mat-dialog-actions button:nth-of-type(2)");
        page.waitForSelector("text=The tag was created successfully");
        Assertions.assertTrue(page.isVisible("text=The tag was created successfully"));
    }
    public void joinClub(){
        page.waitForTimeout(3000);
        if(page.isVisible("text=My workshops")) {
            assertionsDashboard();
        }
            if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.navigate("https://peppermint-development.web.app/content/clubs");
            } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.navigate("https://peppermint-qa.web.app/content/clubs");
            } else if(linkNavigation=="http://localhost:4200/auth/login"){
                page.navigate("http://localhost:4200/content/clubs");
            }
            page.waitForSelector("app-all-cards .container > div:nth-of-type(1)");
            page.click("app-all-cards .container > div:nth-of-type(1)");
        page.waitForSelector("app-club-details > div > div > div:nth-of-type(1) > div > div > div");
        if(page.isVisible("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(2) > button")==true){
            page.click("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(2) > button");
        }
        if(page.isVisible("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(3) > button")==true){
            page.click("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(3) > button");
        }
        page.waitForSelector("text=The club was joined successfully");
        Assertions.assertTrue(page.isVisible("text=The club was joined successfully"));
    }
    public void joinUserManyClub(){
        Keyboard kb = page.keyboard();
        emailLogin=emailUserUnirMultiplesClub;
        login();
        page.waitForSelector("text=My workshops");
        assertionsDashboard();
        if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
            page.navigate("https://peppermint-development.web.app/content/clubs");
        } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            page.navigate("https://peppermint-qa.web.app/content/clubs");
        } else if(linkNavigation=="http://localhost:4200/user/plans/"){
            page.navigate("http://localhost:4200/content/clubs");
        }
        for (counter=0; counter <execute;counter++){
            int counterInterno = counter+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while(page.isVisible("app-all-cards .container > div:nth-of-type("+counterInterno+")")==false) {
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+counterInterno+")");
            page.click("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(2) > button");
            page.waitForSelector("text=The club was joined successfully");
            Assertions.assertTrue(page.isVisible("text=The club was joined successfully"));
            page.click("app-breadcrumb ul li:nth-of-type(1) a");
            System.out.print("el usuario se ha unido a "+ counterInterno+" de "+execute+" clubs\n");
            printStream.println("el usuario se ha unido a "+ counterInterno+" de "+execute+" clubs\n");
        }
    }
    public void createPostClub(){
        Keyboard kb = page.keyboard();
        String[] listaParrafos = { "La inteligencia artificial está revolucionando diversas industrias, como la atención médica y la automoción.",
                "El cambio climático es una amenaza global que requiere una acción colectiva para mitigar sus efectos.",
                "La educación en línea ha experimentado un crecimiento significativo debido a la pandemia de COVID-19.",
                "La exploración espacial nos ha permitido comprender mejor el universo y nuestra posición en él.",
                "La biodiversidad es esencial para mantener el equilibrio de los ecosistemas y garantizar la supervivencia de las especies.",
                "La igualdad de género es un objetivo importante para lograr una sociedad justa y equitativa.",
                "La música desempeña un papel fundamental en la cultura y la expresión humana a lo largo de la historia.",
                "La ética en la inteligencia artificial es un tema crítico para garantizar decisiones justas y éticas en sistemas automatizados.",
                "La medicina moderna ha avanzado significativamente, mejorando la calidad de vida y prolongando la esperanza de vida.",
                "La diversidad cultural enriquece nuestras comunidades al celebrar las diferencias y promover la tolerancia.",
                "La sostenibilidad ambiental es esencial para proteger nuestro planeta y las generaciones futuras.",
                "La literatura clásica sigue siendo relevante y apreciada por su contribución a la cultura global.",
                "La globalización ha transformado la forma en que las empresas operan y las personas se conectan en todo el mundo.",
                "La inteligencia emocional es una habilidad valiosa para comprender y gestionar nuestras emociones en la vida cotidiana.",
                "La energía renovable desempeña un papel fundamental en la transición hacia fuentes de energía más limpias.",
                "La política y la gobernanza son temas cruciales para la toma de decisiones y la dirección de una nación.",
                "La ciberseguridad se ha vuelto esencial en un mundo digital, protegiendo la privacidad y los datos en línea.",
                "La robótica está impulsando avances en la automatización de tareas y la industria manufacturera.",
                "La historia antigua nos ofrece una visión única de las civilizaciones y eventos que moldearon el mundo.",
                "La tecnología blockchain está cambiando la forma en que realizamos transacciones y gestionamos datos.",
                "La nutrición y la salud están estrechamente relacionadas, influyendo en nuestra calidad de vida y bienestar.",
                "La filosofía explora cuestiones fundamentales sobre la existencia y el significado de la vida.",
                "La psicología estudia el comportamiento humano y cómo nuestras mentes funcionan en diversas situaciones.",
                "La nanotecnología tiene el potencial de revolucionar la medicina y la electrónica a escalas microscópicas.",
                "La arquitectura y el diseño influyen en la forma en que experimentamos el entorno construido.",
                "La sociología analiza las interacciones sociales y los patrones en la sociedad humana.",
                "La economía global afecta a las naciones y las empresas, influyendo en el comercio y la inversión.",
                "La astronomía nos permite explorar el universo y descubrir planetas, estrellas y galaxias distantes.",
                "La geología estudia la Tierra y sus procesos, incluyendo terremotos, volcanes y la formación de montañas.",
                "La química es fundamental para comprender la composición y las reacciones de la materia en el mundo natural.",
                "La biología es la ciencia de la vida, examinando desde las células hasta los ecosistemas y la evolución.",
                "La historia del arte rastrea la evolución de la expresión artística a lo largo de las épocas y culturas.",
                "La política ambiental busca abordar los desafíos ecológicos y conservar los recursos naturales.",
                "La música clásica es apreciada por su belleza y complejidad, interpretada por orquestas en todo el mundo.",
                "La física estudia las leyes fundamentales del universo, desde partículas subatómicas hasta la cosmología.",
                "La sociología del género explora las dinámicas de género y las cuestiones relacionadas con la igualdad.",
                "La neurociencia investiga el cerebro y el sistema nervioso, desentrañando los misterios de la mente humana.",
                "La inteligencia colectiva se refiere a la capacidad de grupos para resolver problemas y tomar decisiones.",
                "La inteligencia artificial en la atención médica está mejorando los diagnósticos y los tratamientos.",
                "La física cuántica desafía nuestra comprensión de la realidad en el nivel más fundamental.",
                "La literatura de ciencia ficción nos lleva a mundos imaginarios y plantea preguntas sobre el futuro.",
                "La psicología deportiva se centra en el rendimiento y la mentalidad de los atletas en competición.",
                "La ingeniería genética abre nuevas posibilidades para modificar el ADN y tratar enfermedades genéticas.",
                "La ética en la investigación científica es esencial para garantizar la integridad y la responsabilidad.",
                "La inteligencia artificial en el arte crea obras generadas por computadora y desafía las nociones de creatividad.",
                "La física de partículas explora las partículas subatómicas y sus interacciones en aceleradores de partículas.",
                "La sociología de la religión examina la influencia de la religión en la sociedad y la cultura.",
                "La medicina regenerativa busca reparar y reemplazar tejidos dañados o enfermos mediante la terapia celular.",
                "La neurociencia cognitiva investiga cómo procesamos la información y tomamos decisiones en el cerebro.",
                "La inteligencia artificial en los vehículos autónomos promete revolucionar la industria del transporte.",
                "La ingeniería ambiental se centra en resolver problemas relacionados con la contaminación y la sostenibilidad.",
                "La nanotecnología en la medicina tiene el potencial de ofrecer tratamientos personalizados y precisos.",
                "La física nuclear estudia las propiedades de los núcleos atómicos y las reacciones nucleares en el cosmos.",
        };
        Random rand = new Random();
        int index1 = rand.nextInt(listaParrafos.length);
        String parrafo = listaParrafos[index1];
        long timeStamp = Instant.now().toEpochMilli();
        page.waitForTimeout(6000);
        if(page.isVisible("text=My workshops")==true) {
            assertionsDashboard();
            if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.navigate("https://peppermint-development.web.app/content/clubs");
            } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.navigate("https://peppermint-qa.web.app/content/clubs");
            } else if(linkNavigation=="http://localhost:4200/auth/login"){
                page.navigate("http://localhost:4200/content/clubs");
            }
            page.waitForSelector("app-all-cards .container > div:nth-of-type(1)");
            page.click("app-all-cards .container > div:nth-of-type(1)");
        }
        page.waitForSelector("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(1)");
        if(page.isVisible("app-text-editor")==false){
            joinClub();
        }
        System.out.println("\nCreando post\n");
        printStream.println("\nCreando post\n");
        page.waitForTimeout(900);
        page.click("app-text-editor quill-editor");
        page.waitForTimeout(900);
        kb.insertText(parrafo);
        page.waitForSelector("app-text-editor > div > div > div:nth-of-type(2) > div > button");
        page.click("app-text-editor > div > div > div:nth-of-type(2) > div > button");
        page.waitForTimeout(5000);
    }
    public void like(){
        page.waitForTimeout(6000);
        if(page.isVisible("text=My workshops")==true) {
            //assertionsDashboard();
            if(linkNavigation == "https://peppermint-development.web.app/auth/login") {
                page.navigate("https://peppermint-development.web.app/content/clubs");
            } else if(linkNavigation=="https://peppermint-qa.web.app/auth/login"){
                page.navigate("https://peppermint-qa.web.app/content/clubs");
            } else if(linkNavigation=="http://localhost:4200/user/plans/"){
                page.navigate("http://localhost:4200/content/clubs");
            }
            page.waitForSelector("app-all-cards .container > div:nth-of-type(1)");
            page.click("app-all-cards .container > div:nth-of-type(1)");
        }
        page.waitForSelector("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(1)");
        if(page.isVisible("app-text-editor")==false){
            joinClub();
        }
        page.click("app-club-details > div > div > div:nth-of-type(4) > div:nth-of-type(1) > div > div > app-activity-card:first-child > mat-card > div > div:nth-of-type(4) > div > div:nth-of-type(1) > app-like-icon > div > div:nth-of-type(1) > mat-icon");
    }
    public void createClub(){
        String[] listaNombres = {"Club de Lectura", "Club de Ajedrez", "Club de Fotografía", "Club de Música",
                "Club de Debate", "Club de Jardinería", "Club de Cocina Gourmet", "Club de Astronomía",
                "Club de Teatro", "Club de Historia", "Club de Filosofía", "Club de Escritura Creativa",
                "Club de Viajes", "Club de Pintura", "Club de Yoga", "Club de Idiomas",
                "Club de Cine", "Club de Ciencias Sociales", "Club de Ecología", "Club de Voluntariado",
                "Club de Tecnología", "Club de Artes Marciales", "Club de Danza", "Club de Moda",
                "Club de Patrimonio Cultural", "Club de Emprendedores", "Club de Cocina Vegetariana", "Club de Ciencias Políticas",
                "Club de Meditación", "Club de Arte Contemporáneo", "Club de Fotoperiodismo", "Club de Literatura",
                "Club de Medio Ambiente", "Club de Psicología", "Club de Economía", "Club de Diseño Gráfico",
                "Club de Nutrición", "Club de Humanidades", "Club de Viajes Espaciales", "Club de Ciencia de Datos",
                "Club de Educación", "Club de Arquitectura", "Club de Ingeniería", "Club de Fotografía de Naturaleza",
                "Club de Astronomía Amateur", "Club de Ciencia Ficción", "Club de Historia del Arte", "Club de Ecoturismo",
                "Club de Fotografía de Aventuras", "Club de Ajedrez Estratégico", "Club de Robótica", "Club de Animación",
                "Club de Ciencia y Tecnología", "Club de Filatelia", "Club de Radioaficionados", "Club de Ciencia Espacial",
                "Club de Meditación Zen", "Club de Ciencias de la Tierra", "Club de Escritores de Ciencia Ficción", "Club de Artes Visuales",
                "Club de Cocina Internacional", "Club de Viajeros Solitarios", "Club de Coleccionistas de Arte", "Club de Psicología Positiva",
                "Club de Juegos de Mesa", "Club de Arte Abstracto", "Club de Fotografía de Arquitectura", "Club de Astronomía Observacional",
                "Club de Filatelia Histórica", "Club de Ciencias del Comportamiento", "Club de Danza Contemporánea", "Club de Diseño de Moda Sostenible",
                "Club de Música Clásica", "Club de Historia Medieval", "Club de Buceo", "Club de Cocina Étnica",
                "Club de Amantes de los Gatos", "Club de Teatro Experimental", "Club de Fotografía Subacuática", "Club de Astronomía Planetaria",
                "Club de Lectura de Ciencia Ficción", "Club de Filatelia Filosófica", "Club de Ciencias Ambientales", "Club de Escritura de Poesía",
                "Club de Arte Digital", "Club de Cocina Molecular", "Club de Viajes en Bicicleta", "Club de Meditación Mindfulness",
                "Club de Ciencia de la Alimentación", "Club de Escultura", "Club de Fotografía de Viajes", "Club de Astronomía Espacial",
                "Club de Historia del Cine", "Club de Modelismo", "Club de Ciencias del Sueño", "Club de Danza del Vientre",
                "Club de Diseño de Interiores", "Club de Música Indie", "Club de Historia del Jazz", "Club de Cocina de Fusión",
                "Club de Escritura de Ciencia Ficción", "Club de Ciencias Marinas", "Club de Astronomía Galáctica", "Club de Fotografía de la Naturaleza",
                "Club de Teatro Clásico", "Club de Arte Moderno", "Club de Cocina Orgánica", "Club de Meditación Transcendental",
                "Club de Ciencias del Deporte", "Club de Diseño de Joyas", "Club de Fotografía de Aves", "Club de Astronomía Planetaria",
                "Club de Historia de la Música", "Club de Origami", "Club de Ciencias Forenses", "Club de Danza Hip-Hop",
                "Club de Diseño Gráfico Creativo", "Club de Música Electrónica", "Club de Historia del Rock", "Club de Cocina Regional",
                "Club de Escritura de Fantasía"};
        Random rand = new Random();
        int index1 = rand.nextInt(listaNombres.length);
        titleClub = listaNombres[index1];
        System.out.println("Creando club...");
        printStream.println("Creando club...");
        System.out.println("\nSe creara el club: " + titleClub + "\n");
        printStream.println("\nSe creara el club: " + titleClub + "\n");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Club management");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".image-container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleClub);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorClub+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionClub);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagClub+")");
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryClub+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForTimeout(500);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForTimeout(500);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The club was created successfully");
        Assertions.assertTrue(page.isVisible("text=The club was created successfully"));
    }
}
