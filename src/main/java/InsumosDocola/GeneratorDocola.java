package InsumosDocola;
import java.time.Instant;
import java.util.Random;
public class GeneratorDocola extends ContextBaseDocola{
    public int generateExecutions(){
        return Integer.parseInt(ejecuciones);
    }
    public EmailInfo generateEmail(){
        generateFirstName();
        generateLastName();
        long timeStamp = Instant.now().toEpochMilli();
        //if(configurationAdvancedRegistration==false) {
        email = firstName+lastName+timeStamp+"@gmail.com";
        return new EmailInfo(email, firstName, lastName);
    }
    public String generateFirstName(){
        String[] listNames = {"Juan", "Maria", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofia", "Diego", "Valentina",
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
        int index1 = rand.nextInt(listNames.length);
        firstName = listNames[index1];
        return firstName;
    }
    public String generateLastName(){
        String[] listSurnames = {
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
        int index2 = random.nextInt(listSurnames.length);
        lastName= listSurnames[index2];
        return lastName;
    }
    public int generateRol(){
        if (joinRol == null) {
            joinRol="Clinician";
        }switch (joinRol) {
                case "Patient":
                    rol = 1;
                    break;
                case "Clinician":
                    rol = 2;
                    break;
                case "Content provider":
                    rol = 3;
                    break;
        }
        return rol;
    }
    public int generateTypeContent(){
        if (typeContent == null) {
            typeContent="Upload file";
        }switch (typeContent) {
            case "Upload file":
                typeContentPosition= 1;
                break;
            case "Capture video":
                typeContentPosition = 2;
                break;
            case "Web content":
                typeContentPosition = 3;
                break;
            case "Quiz":
                typeContentPosition = 4;
                break;
            case "Survey":
                typeContentPosition = 5;
                break;
            case "VR":
                typeContentPosition = 6;
                break;
        }
        return typeContentPosition;
    }
    public String generateCompanyName(){
        String[] companyList = {"Industrias Sol", "MegaCorp", "InnovaTech", "Global Enterprises", "Emprendedores Unidos",
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
        int index1 = rand.nextInt(companyList.length);
        companyName = companyList[index1];
        return companyName;
    }
    public String generateUploadFileName(){
        String [] nameUploadFileList = {
                "Anatomy And Physiology", "Medical Terminology", "Biochemistry", "Pathophysiology", "Pharmacology",
                "Medical Microbiology", "Clinical Medicine", "Medical Genetics", "Histology", "Immunology",
                "Epidemiology", "Public Health", "Clinical Research", "Medical Ethics", "Medical Law",
                "Neuroscience", "Cardiology", "Endocrinology", "Gastroenterology", "Hematology",
                "Oncology", "Pulmonology", "Nephrology", "Dermatology", "Rheumatology", "Orthopedics",
                "Obstetrics And Gynecology", "Pediatrics", "Geriatrics", "Urology", "Ophthalmology",
                "Otolaryngology", "Neurosurgery", "Plastic Surgery", "Cardiothoracic Surgery", "Orthopedic Surgery",
                "Anesthesiology", "Emergency Medicine", "Family Medicine", "Internal Medicine", "Psychiatry",
                "Radiology", "Sports Medicine", "Dentistry", "Nursing", "Paramedicine", "Physiotherapy",
                "Occupational Therapy", "Speech Therapy", "Pharmacy", "Nutrition", "Biomedical Engineering",
                "Health Informatics", "Health Administration", "Health Economics", "Medical Education",
                "Medical Illustration", "Medical Journalism", "Medical Physics", "Medical Sociology",
                "Medical Anthropology", "Medical History", "Global Health", "Telemedicine", "Molecular Biology",
                "Medical Imaging", "Medical Biotechnology", "Regenerative Medicine", "Stem Cell Biology",
                "Cancer Biology", "Virology", "Bacteriology", "Parasitology", "Mycology", "Immunotherapy",
                "Gene Therapy", "Precision Medicine", "Complementary Medicine", "Integrative Medicine",
                "Reproductive Medicine", "Fertility Medicine", "Transplant Surgery", "Clinical Psychology",
                "Medical Social Work", "Patient Counseling", "Health Promotion", "Health Education",
                "Disaster Medicine", "Tropical Medicine", "Travel Medicine", "Palliative Care", "Hospice Care",
                "Medical Simulation", "Medical Robotics", "Medical Devices", "Medical Informatics", "Medical Coding",
                "Medical Billing", "Medical Transcription", "Medical Scribing", "Medical Interpreting",
                "Medical Tourism"
        };
        Random rand = new Random();
        int index1 = rand.nextInt(nameUploadFileList.length);
        uploadFileName = nameUploadFileList[index1];
        return uploadFileName;
    }
    class EmailInfo {
        private String email;
        private String firstName;
        private String lastName;
        public EmailInfo(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getEmail() {
            return email;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
    }

}
