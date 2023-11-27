package InsumosDocola;

import com.microsoft.playwright.Keyboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Instant;
import java.util.Random;

public class methodsDocola extends contextBaseDocola{

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
        //if(configurationAdvancedRegistration==false) {
            emailRegister = "frantestdocola+"+timeStamp+"@gmail.com";
        //}
        saveUser();
        System.out.println("Se creara el usuario:"+emailRegister);
        page.click("text=SIGN UP");
        page.click("#register-box > div > section > a");
        page.waitForSelector("#contentMain > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(2)");
        page.dblclick("#contentMain > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(2)");
        page.waitForTimeout(2000);
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(1) > div:nth-of-type(1) input",firstName);
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(1) > div:nth-of-type(2) input", lastName);
        page.click(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(2) > div:nth-of-type(1) select");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.waitForSelector(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(2) > div:nth-of-type(2) select");
        page.click(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(2) > div:nth-of-type(2) select");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(2) > div:nth-of-type(4) input","4242424242424242");
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > div:nth-of-type(1) input",emailRegister);
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(1) input","123123aA");
        page.fill(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(2) input","123123aA");
        page.click(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(4) > div > div > div:nth-of-type(1) > div");
        page.click(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(5) .form-group > div > div > div > iframe");
        page.waitForTimeout(2000);
        page.click(".md-margin-top > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(7)");
        page.waitForTimeout(10000);
    }
}
