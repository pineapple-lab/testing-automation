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
        if (typeResource == null) {
            typeResource="Upload file";
        }switch (typeResource) {
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
    public String generateContentName(){
        String [] nameContentList = {
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
        int index1 = rand.nextInt(nameContentList.length);
        contentName = nameContentList[index1];
        return contentName;
    }
    public String generateContentDescription(){
        String [] nameDescriptionContentList = {
                "The circulatory system is responsible for transporting oxygen, nutrients, and hormones to cells throughout the body, while also removing waste products. It consists of the heart, blood vessels, and blood.",
        "Infectious diseases are caused by pathogenic microorganisms such as bacteria, viruses, parasites, or fungi. They can spread directly or indirectly from person to person.",
                "Neurology is the branch of medicine that deals with disorders of the nervous system, including the brain, spinal cord, and nerves. Conditions such as Alzheimer's disease, stroke, and epilepsy fall under this category.",
                "Orthopedics focuses on the musculoskeletal system, treating conditions related to bones, joints, ligaments, tendons, and muscles. It includes procedures like joint replacement surgery and fracture repair.",
                "Endocrinology is the study of hormones and their impact on bodily functions. Disorders such as diabetes, thyroid dysfunction, and adrenal insufficiency are within its scope.",
                "Oncology is the branch of medicine that deals with the prevention, diagnosis, and treatment of cancer. It involves various modalities such as chemotherapy, radiation therapy, and surgery.",
                "Pediatrics is the branch of medicine that focuses on the health and medical care of infants, children, and adolescents. Pediatricians address issues ranging from growth and development to childhood illnesses.",
                "Gastroenterology specializes in the digestive system and its disorders, including the stomach, intestines, liver, and pancreas. Conditions like irritable bowel syndrome and gastroesophageal reflux disease fall under this field.",
                "Cardiology is the branch of medicine that deals with disorders of the heart and blood vessels. Cardiologists diagnose and treat conditions such as heart disease, hypertension, and heart failure.",
                "Dermatology focuses on the skin, hair, nails, and related conditions. Dermatologists diagnose and treat disorders such as acne, eczema, psoriasis, and skin cancer.",
                "Pulmonology is the study of the respiratory system and diseases affecting the lungs and airways. Conditions like asthma, chronic obstructive pulmonary disease (COPD), and pneumonia are within its purview.",
                "Rheumatology deals with disorders affecting the joints, muscles, and connective tissues. Rheumatologists diagnose and treat conditions such as rheumatoid arthritis, lupus, and gout.",
                "Ophthalmology specializes in the diagnosis and treatment of eye disorders and diseases. Ophthalmologists address conditions like cataracts, glaucoma, and macular degeneration.",
                "Urology focuses on the urinary tract system in both males and females, as well as the male reproductive system. Urologists treat conditions such as kidney stones, urinary incontinence, and prostate cancer.",
                "Hematology involves the study of blood and blood-forming tissues. Hematologists diagnose and treat disorders such as anemia, hemophilia, and leukemia.",
                "Nephrology deals with the study and treatment of kidney-related conditions. Nephrologists address issues like kidney stones, chronic kidney disease, and renal failure.",
                "Allergy and immunology focus on the body's immune system and its response to allergens and other foreign substances. Specialists in this field diagnose and treat conditions such as allergic rhinitis, asthma, and autoimmune diseases.",
                "Emergency medicine is concerned with the initial assessment, stabilization, and treatment of patients in acute medical crises. Emergency physicians work in hospital emergency departments and trauma centers.",
                "Geriatrics is the branch of medicine that focuses on the health and care of elderly people. Geriatricians address issues such as age-related diseases, cognitive decline, and end-of-life care.",
                "Psychiatry is the branch of medicine that deals with mental disorders, including their diagnosis, treatment, and prevention. Psychiatrists may use therapy, medication, or other interventions to manage conditions such as depression, anxiety, and schizophrenia.",
                "Radiology involves the use of medical imaging technologies such as X-rays, CT scans, MRI, and ultrasound to diagnose and treat diseases. Radiologists interpret imaging studies and may perform minimally invasive procedures.",
                "Anesthesiology is the practice of administering anesthesia and managing pain during surgical procedures. Anesthesiologists also provide care for patients in critical care units and pain clinics.",
                "Obstetrics and gynecology (OB/GYN) deals with the female reproductive system, pregnancy, childbirth, and related disorders. OB/GYNs provide prenatal care, perform deliveries, and treat conditions such as infertility and menstrual disorders.",
                "Medical genetics involves the study of genetic factors that contribute to human health and disease. Genetic counselors provide information and support to individuals and families at risk for inherited conditions.",
                "Infectious disease specialists focus on the diagnosis and treatment of infectious diseases caused by bacteria, viruses, fungi, and parasites. They may work in hospitals, public health agencies, or research institutions.",
                "Neonatology is a subspecialty of pediatrics that focuses on the care of newborn infants, particularly those who are premature or critically ill. Neonatologists provide specialized medical care in neonatal intensive care units (NICUs).",
                "Pain medicine specializes in the management of acute and chronic pain. Pain specialists use a variety of techniques, including medication, physical therapy, and interventional procedures, to alleviate pain and improve quality of life.",
                "Sleep medicine focuses on the diagnosis and treatment of sleep disorders such as insomnia, sleep apnea, and narcolepsy. Sleep specialists may conduct sleep studies and prescribe therapies to improve sleep quality.",
                "Sports medicine deals with the prevention, diagnosis, and treatment of injuries related to sports and exercise. Sports medicine physicians work with athletes to optimize performance and minimize the risk of injury.",
                "Medical oncology is a subspecialty of oncology that focuses on the medical treatment of cancer using chemotherapy, targeted therapy, immunotherapy, and other systemic treatments. Medical oncologists work closely with surgical and radiation oncologists to provide comprehensive cancer care.",
                "Palliative care focuses on relieving the symptoms and stress of serious illness, with the goal of improving quality of life for patients and their families. Palliative care teams may include physicians, nurses, social workers, and other healthcare professionals.",
                "Reproductive medicine encompasses the diagnosis and treatment of fertility issues and reproductive disorders. Reproductive endocrinologists specialize in helping individuals and couples achieve pregnancy through assisted reproductive technologies such as in vitro fertilization (IVF).",
                "Toxicology involves the study of the adverse effects of chemicals, drugs, and other substances on living organisms. Toxicologists assess the risks associated with exposure to toxins and develop strategies for prevention and treatment.",
                "Nuclear medicine utilizes radioactive substances to diagnose and treat various medical conditions. Nuclear medicine technologists administer radiopharmaceuticals and operate imaging equipment to produce detailed images of the body's organs and tissues.",
                "Telemedicine involves the use of telecommunications technology to provide remote healthcare services. Telemedicine enables patients to consult with healthcare providers, receive diagnoses, and access treatment without the need for in-person visits.",
                "Integrative medicine combines conventional medical treatments with complementary and alternative therapies to address the physical, emotional, and spiritual aspects of health and wellness. Practitioners may incorporate techniques such as acupuncture, massage therapy, and herbal medicine into treatment plans.",
                "Clinical pharmacology focuses on the study of drugs and their effects on humans. Clinical pharmacologists conduct research to evaluate the safety, efficacy, and optimal use of medications in clinical practice.",
                "Inflammatory bowel disease (IBD) is a group of chronic inflammatory conditions of the gastrointestinal tract, including Crohn's disease and ulcerative colitis. Symptoms may include abdominal pain, diarrhea, and rectal bleeding.",
                "Cystic fibrosis is a genetic disorder that affects the lungs, pancreas, and other organs, leading to respiratory and digestive problems. Treatment may include medications, chest physiotherapy, and nutritional support.",
                "Osteoporosis is a condition characterized by weakened bones, increasing the risk of fractures. Prevention and treatment strategies include calcium and vitamin D supplementation, weight-bearing exercise, and medications to improve bone density.",
                "Autism spectrum disorder (ASD) is a developmental disorder that affects communication, behavior, and social interaction. Early intervention and behavioral therapies can help children with ASD reach their full potential.",
                "Multiple sclerosis (MS) is a chronic autoimmune disease that affects the central nervous system, leading to symptoms such as fatigue, weakness, and difficulty with coordination and balance. Treatment may include medications to manage symptoms and slow disease progression.",
                "Chronic obstructive pulmonary disease (COPD) is a progressive lung disease characterized by airflow obstruction and breathing difficulties. Smoking cessation, bronchodilators, and pulmonary rehabilitation are key components of management.",
                "Hypertension, or high blood pressure, is a common condition that increases the risk of heart disease, stroke, and other complications. Lifestyle modifications and medications can help control blood pressure and reduce cardiovascular risk.",
                "Atrial fibrillation is a common type of irregular heart rhythm that can increase the risk of stroke and heart failure. Treatment may include medications to control heart rate and rhythm, as well as blood thinners to prevent clot formation.",
                "Type 2 diabetes is a chronic condition characterized by high blood sugar levels due to insulin resistance or insufficient insulin production. Management involves lifestyle modifications, oral medications, and/or insulin therapy.",
                "Alzheimer's disease is a progressive neurodegenerative disorder that affects memory, cognition, and behavior. There is currently no cure, but medications and supportive therapies can help manage symptoms and improve quality of life.",
                "Schizophrenia is a chronic mental disorder characterized by disturbances in thinking, perception, emotions, and behavior. Treatment typically involves antipsychotic medications, psychotherapy, and support services.",
                "Depression is a mood disorder that causes persistent feelings of sadness, hopelessness, and loss of interest in activities. Treatment may include psychotherapy, medication, and lifestyle changes.",
                "Anxiety disorders are characterized by excessive worry, fear, or nervousness that can interfere with daily functioning. Treatment may include therapy, medication, and relaxation techniques.",
                "Epilepsy is a neurological disorder characterized by recurrent seizures. Treatment typically involves antiepileptic medications, but in some cases, surgery or other interventions may be necessary.",
                "Rheumatoid arthritis is an autoimmune disease that causes chronic inflammation of the joints, resulting in pain, stiffness, and swelling. Treatment may include medications to reduce inflammation and slow joint damage, as well as physical therapy and lifestyle modifications.",
                "Inflammatory arthritis encompasses a group of autoimmune diseases that cause inflammation of the joints, such as rheumatoid arthritis, psoriatic arthritis, and ankylosing spondylitis. Treatment aims to reduce inflammation and relieve symptoms.",
                "Chronic kidney disease is a progressive condition characterized by the gradual loss of kidney function over time. Treatment focuses on managing symptoms, slowing disease progression, and preventing complications such as cardiovascular disease.",
                "Celiac disease is an autoimmune disorder characterized by an abnormal immune response to gluten, a protein found in wheat, barley, and rye. The only treatment is a strict gluten-free diet.",
                "Ovarian cancer is a type of cancer that begins in the ovaries, often presenting with nonspecific symptoms such as abdominal bloating, pelvic pain, and changes in bowel habits. Treatment may include surgery, chemotherapy, and targeted therapy.",
                "Prostate cancer is a type of cancer that develops in the prostate gland, typically affecting older men. Treatment options include surgery, radiation therapy, hormone therapy, chemotherapy, and immunotherapy.",
                "Breast cancer is a type of cancer that develops in the breast tissue, most commonly in women but also affecting men. Treatment may include surgery, radiation therapy, chemotherapy, hormonal therapy, and targeted therapy.",
                "Colon cancer is a type of cancer that begins in the colon or rectum, often presenting with symptoms such as changes in bowel habits, blood in the stool, and abdominal discomfort. Treatment options include surgery, chemotherapy, and radiation therapy.",
                "Pancreatic cancer is a type of cancer that begins in the pancreas, often presenting with symptoms such as abdominal pain, jaundice, and unintended weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Melanoma is a type of skin cancer that develops from melanocytes, the cells that produce pigment in the skin. Treatment may include surgery, immunotherapy, targeted therapy, chemotherapy, and radiation therapy.",
                "Lung cancer is a type of cancer that begins in the lungs, typically in the cells lining the air passages. Treatment options include surgery, radiation therapy, chemotherapy, targeted therapy, and immunotherapy.",
                "Leukemia is a type of cancer that affects the blood and bone marrow, resulting in the overproduction of abnormal white blood cells. Treatment may include chemotherapy, radiation therapy, targeted therapy, and bone marrow transplantation.",
                "HIV/AIDS is a viral infection that attacks the immune system, leading to a progressive weakening of the body's ability to fight off infections and diseases. Treatment involves antiretroviral therapy to suppress the virus and prevent disease progression.",
                "Parkinson's disease is a progressive neurological disorder that affects movement, balance, and coordination. Treatment may include medications, physical therapy, and deep brain stimulation.",
                "Osteoarthritis is a degenerative joint disease characterized by the breakdown of cartilage and bone within the joints. Treatment may include medications, physical therapy, and lifestyle modifications.",
                "Crohn's disease is a chronic inflammatory bowel disease that causes inflammation of the digestive tract, leading to abdominal pain, diarrhea, and other symptoms. Treatment aims to reduce inflammation and relieve symptoms, often with medication and dietary changes.",
                "Ulcerative colitis is a chronic inflammatory bowel disease that causes inflammation and ulcers in the lining of the colon and rectum, leading to abdominal pain, diarrhea, and rectal bleeding. Treatment may include medications and surgery to remove the colon in severe cases.",
                "Fibromyalgia is a chronic condition characterized by widespread musculoskeletal pain, fatigue, and sleep disturbances. Treatment may include medications, physical therapy, and lifestyle changes to manage symptoms and improve quality of life.",
                "Systemic lupus erythematosus (SLE) is an autoimmune disease that can affect multiple organs and systems in the body, leading to symptoms such as joint pain, skin rashes, and fatigue. Treatment aims to control inflammation and prevent organ damage.",
                "Gastric cancer is a type of cancer that begins in the stomach lining, often presenting with symptoms such as abdominal pain, nausea, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Liver cancer is a type of cancer that begins in the cells of the liver, often presenting with symptoms such as abdominal pain, jaundice, and unexplained weight loss. Treatment options may include surgery, ablation therapy, chemotherapy, and targeted therapy.",
                "Hepatitis is inflammation of the liver, most commonly caused by viral infections but also by alcohol abuse, certain medications, and autoimmune diseases. Treatment varies depending on the cause and severity of the condition.",
                "Bladder cancer is a type of cancer that begins in the cells lining the bladder, often presenting with symptoms such as blood in the urine, frequent urination, and pelvic pain. Treatment options may include surgery, chemotherapy, and immunotherapy.",
                "Kidney cancer is a type of cancer that begins in the kidneys, often presenting with symptoms such as blood in the urine, abdominal pain, and a palpable mass in the abdomen. Treatment options may include surgery, targeted therapy, and immunotherapy.",
                "Thyroid cancer is a type of cancer that begins in the thyroid gland, often presenting with symptoms such as a lump in the neck, hoarseness, and difficulty swallowing. Treatment options may include surgery, radioactive iodine therapy, and thyroid hormone therapy.",
                "Esophageal cancer is a type of cancer that begins in the cells lining the esophagus, often presenting with symptoms such as difficulty swallowing, chest pain, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Glioblastoma is a type of brain cancer that develops from glial cells, often presenting with symptoms such as headaches, seizures, and cognitive changes. Treatment options may include surgery, radiation therapy, chemotherapy, and targeted therapy.",
                "Migraine is a neurological disorder characterized by recurrent headaches that can be severe and debilitating. Treatment may include medications to prevent or alleviate symptoms, as well as lifestyle modifications.",
                "Interstitial lung disease is a group of disorders that cause scarring of the lungs, leading to difficulty breathing, cough, and fatigue. Treatment may include medications to reduce inflammation and fibrosis, as well as oxygen therapy and pulmonary rehabilitation.",
                "Chronic kidney disease (CKD) is a progressive condition characterized by the gradual loss of kidney function over time. Treatment focuses on managing symptoms, slowing disease progression, and preventing complications such as cardiovascular disease.",
                "Gastroesophageal reflux disease (GERD) is a chronic digestive disorder characterized by the backward flow of stomach acid into the esophagus, leading to symptoms such as heartburn, regurgitation, and chest pain. Treatment may include lifestyle changes, medication, and, in severe cases, surgery.",
                "Deep vein thrombosis (DVT) is a blood clot that forms in a deep vein, usually in the legs. If not treated promptly, DVT can lead to serious complications such as pulmonary embolism. Treatment typically involves blood thinners to prevent clot formation and reduce the risk of complications.",
                "Pulmonary embolism (PE) occurs when a blood clot travels to the lungs and blocks a pulmonary artery, leading to symptoms such as shortness of breath, chest pain, and cough. Treatment may include blood thinners, oxygen therapy, and, in severe cases, clot-dissolving medications or surgery.",
                "Coronary artery disease (CAD) is a condition in which plaque buildup narrows the coronary arteries, reducing blood flow to the heart muscle and increasing the risk of heart attack and stroke. Treatment may include lifestyle changes, medications, and, in some cases, procedures such as angioplasty or bypass surgery.",
                "Myocardial infarction, commonly known as a heart attack, occurs when blood flow to a part of the heart is blocked for a prolonged period, leading to damage or death of the heart muscle. Treatment involves restoring blood flow to the affected area as quickly as possible, typically through medications, angioplasty, or bypass surgery.",
                "Asthma is a chronic respiratory condition characterized by inflammation and narrowing of the airways, leading to symptoms such as wheezing, coughing, and shortness of breath. Treatment may include inhalers, oral medications, and lifestyle modifications to control symptoms and prevent exacerbations.",
                "Chronic obstructive pulmonary disease (COPD) is a progressive lung disease characterized by airflow obstruction and breathing difficulties. Smoking cessation, bronchodilators, and pulmonary rehabilitation are key components of management.",
                "Cystic fibrosis is a genetic disorder that affects the lungs, pancreas, and other organs, leading to respiratory and digestive problems. Treatment may include medications, chest physiotherapy, and nutritional support.",
                "Hypertension, or high blood pressure, is a common condition that increases the risk of heart disease, stroke, and other complications. Lifestyle modifications and medications can help control blood pressure and reduce cardiovascular risk.",
                "Diabetes mellitus is a chronic metabolic disorder characterized by high blood sugar levels, either due to insufficient insulin production or insulin resistance. Management involves lifestyle modifications, medications, and/or insulin therapy to control blood sugar levels and prevent complications.",
                "Obstructive sleep apnea is a sleep disorder characterized by repetitive episodes of complete or partial upper airway obstruction during sleep, leading to pauses in breathing and disrupted sleep patterns. Treatment may include continuous positive airway pressure (CPAP) therapy, oral appliances, or surgery to alleviate symptoms and improve sleep quality.",
                "Inflammatory bowel disease (IBD) is a group of chronic inflammatory conditions of the gastrointestinal tract, including Crohn's disease and ulcerative colitis. Symptoms may include abdominal pain, diarrhea, and rectal bleeding.",
                "Celiac disease is an autoimmune disorder characterized by an abnormal immune response to gluten, a protein found in wheat, barley, and rye. The only treatment is a strict gluten-free diet.",
                "Irritable bowel syndrome (IBS) is a common digestive disorder characterized by abdominal pain, bloating, and changes in bowel habits, without any identifiable structural or biochemical abnormalities. Treatment may include dietary modifications, medications, and stress management techniques to alleviate symptoms and improve quality of life.",
                "Gastroesophageal reflux disease (GERD) is a chronic digestive disorder characterized by the backward flow of stomach acid into the esophagus, leading to symptoms such as heartburn, regurgitation, and chest pain. Treatment may include lifestyle changes, medication, and, in severe cases, surgery.",
                "Peptic ulcer disease is a condition characterized by the presence of open sores (ulcers) in the lining of the stomach, small intestine, or esophagus, often caused by infection with Helicobacter pylori bacteria or long-term use of nonsteroidal anti-inflammatory drugs (NSAIDs). Treatment may include antibiotics, acid-suppressing medications, and lifestyle modifications to promote healing and prevent recurrence.",
                "Liver cirrhosis is a progressive condition characterized by the replacement of healthy liver tissue with scar tissue, leading to impaired liver function. Treatment aims to manage complications, alleviate symptoms, and prevent disease progression, often through lifestyle changes, medications, and, in some cases, liver transplantation.",
                "Gallstones are solid particles that form in the gallbladder, often causing pain and other symptoms when they block the flow of bile. Treatment may include medications to dissolve stones, minimally invasive procedures to remove stones, or surgery to remove the gallbladder.",
                "Pancreatitis is inflammation of the pancreas, often resulting from gallstones, alcohol abuse, or other factors. Treatment involves supportive care to relieve symptoms, as well as addressing underlying causes such as gallstone removal or alcohol cessation.",
                "Hepatitis is inflammation of the liver, most commonly caused by viral infections but also by alcohol abuse, certain medications, and autoimmune diseases. Treatment varies depending on the cause and severity of the condition.",
                "Diverticulitis is inflammation or infection of small pouches (diverticula) that form in the walls of the colon, often causing abdominal pain, fever, and changes in bowel habits. Treatment may include antibiotics, dietary modifications, and, in severe cases, surgery to remove affected portions of the colon.",
                "Crohn's disease is a chronic inflammatory bowel disease that causes inflammation of the digestive tract, leading to abdominal pain, diarrhea, and other symptoms. Treatment aims to reduce inflammation and relieve symptoms, often with medication and dietary changes.",
                "Ulcerative colitis is a chronic inflammatory bowel disease that causes inflammation and ulcers in the lining of the colon and rectum, leading to abdominal pain, diarrhea, and rectal bleeding. Treatment may include medications and surgery to remove the colon in severe cases.",
                "Hemorrhoids are swollen veins in the rectum or anus, often causing pain, itching, and bleeding. Treatment may include lifestyle changes, topical medications, and procedures such as rubber band ligation or surgical removal.",
                "Pancreatic cancer is a type of cancer that begins in the pancreas, often presenting with symptoms such as abdominal pain, jaundice, and unintended weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Liver cancer is a type of cancer that begins in the cells of the liver, often presenting with symptoms such as abdominal pain, jaundice, and unexplained weight loss. Treatment options may include surgery, ablation therapy, chemotherapy, and targeted therapy.",
                "Gastric cancer is a type of cancer that begins in the stomach lining, often presenting with symptoms such as abdominal pain, nausea, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Esophageal cancer is a type of cancer that begins in the cells lining the esophagus, often presenting with symptoms such as difficulty swallowing, chest pain, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Colorectal cancer is a type of cancer that begins in the colon or rectum, often presenting with symptoms such as changes in bowel habits, blood in the stool, and abdominal discomfort. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Breast cancer is a type of cancer that develops in the breast tissue, most commonly in women but also affecting men. Treatment may include surgery, radiation therapy, chemotherapy, hormonal therapy, and targeted therapy.",
                "Prostate cancer is a type of cancer that develops in the prostate gland, typically affecting older men. Treatment options include surgery, radiation therapy, hormone therapy, chemotherapy, and immunotherapy.",
                "Lung cancer is a type of cancer that begins in the lungs, typically in the cells lining the air passages. Treatment options include surgery, radiation therapy, chemotherapy, targeted therapy, and immunotherapy.",
                "Skin cancer is the abnormal growth of skin cells, often caused by exposure to ultraviolet radiation from the sun or tanning beds. Treatment depends on the type and stage of cancer but may include surgery, radiation therapy, chemotherapy, and immunotherapy.",
                "Leukemia is a type of cancer that affects the blood and bone marrow, resulting in the overproduction of abnormal white blood cells. Treatment may include chemotherapy, radiation therapy, targeted therapy, and bone marrow transplantation.",
                "Hodgkin lymphoma is a type of cancer that affects the lymphatic system, particularly the lymph nodes. Treatment may include chemotherapy, radiation therapy, targeted therapy, and stem cell transplantation.",
                "Non-Hodgkin lymphoma is a type of cancer that affects the lymphatic system, particularly the lymphocytes (a type of white blood cell). Treatment may include chemotherapy, immunotherapy, radiation therapy, and stem cell transplantation.",
                "Multiple myeloma is a type of cancer that affects plasma cells, a type of white blood cell found in the bone marrow. Treatment may include chemotherapy, immunotherapy, targeted therapy, and stem cell transplantation.",
                "Melanoma is a type of skin cancer that develops from melanocytes, the cells that produce pigment in the skin. Treatment may include surgery, immunotherapy, targeted therapy, chemotherapy, and radiation therapy.",
                "Pancreatic cancer is a type of cancer that begins in the pancreas, often presenting with symptoms such as abdominal pain, jaundice, and unintended weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Liver cancer is a type of cancer that begins in the cells of the liver, often presenting with symptoms such as abdominal pain, jaundice, and unexplained weight loss. Treatment options may include surgery, ablation therapy, chemotherapy, and targeted therapy.",
                "Gastric cancer is a type of cancer that begins in the stomach lining, often presenting with symptoms such as abdominal pain, nausea, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Esophageal cancer is a type of cancer that begins in the cells lining the esophagus, often presenting with symptoms such as difficulty swallowing, chest pain, and unintentional weight loss. Treatment options may include surgery, chemotherapy, and radiation therapy.",
                "Colorectal cancer is a type of cancer that begins in the colon or rectum, often presenting with symptoms such as changes in bowel habits, blood in the stool, and abdominal discomfort. Treatment options may include surgery, chemotherapy, and radiation therapy."
        };
        Random rand = new Random();
        int index1 = rand.nextInt(nameDescriptionContentList.length);
        contentDescription = nameDescriptionContentList[index1];
        return contentDescription;
    }
    public String generateQuestion(){
        String [] questionList = {
                "What is the role of the hypothalamus in the endocrine system?",
                "How does insulin regulate blood sugar levels?",
                "What are the stages of mitosis?",
                "Explain the mechanism of action of antibiotics.",
                "What is the difference between arteries and veins?",
                "How does the immune system respond to a viral infection?",
                "What are the symptoms of Parkinson's disease?",
                "Describe the structure of a neuron.",
                "What are the risk factors for developing cardiovascular disease?",
                "How do antiviral drugs work?",
                "What are the functions of the liver?",
                "What are the different types of anesthesia?",
                "Explain the process of DNA replication.",
                "What is the function of the respiratory system?",
                "How does the menstrual cycle work?",
                "What are the causes of asthma?",
                "Describe the process of blood clotting.",
                "What are the stages of embryonic development?",
                "How does chemotherapy work to treat cancer?",
                "What is the function of the kidneys?",
                "How do vaccines work to prevent disease?",
                "What are the symptoms of diabetes?",
                "Explain the process of protein synthesis.",
                "What is the difference between a virus and a bacterium?",
                "How does the brain interpret sensory information?",
                "What are the effects of smoking on the respiratory system?",
                "Describe the structure of the heart.",
                "What are the causes of obesity?",
                "How do anticoagulant drugs work?",
                "What is the role of the pancreas in digestion?",
                "What are the symptoms of depression?",
                "Explain the process of meiosis.",
                "What are the risk factors for developing cancer?",
                "How does the circulatory system maintain homeostasis?",
                "What is the function of the endocrine system?",
                "What are the different types of white blood cells?",
                "Describe the process of muscle contraction.",
                "What are the symptoms of Alzheimer's disease?",
                "How does the body regulate body temperature?",
                "What are the effects of alcohol on the liver?",
                "Explain the process of photosynthesis.",
                "What are the stages of sleep?",
                "What are the symptoms of schizophrenia?",
                "How does the nervous system control movement?",
                "What is the difference between a bacterial and a viral infection?",
                "What are the risk factors for developing osteoporosis?",
                "Describe the process of fertilization.",
                "What are the functions of the digestive system?",
                "How do painkillers work to relieve pain?",
                "What are the symptoms of anxiety?",
                "Explain the process of evolution by natural selection.",
                "What is the difference between type 1 and type 2 diabetes?",
                "How does the body respond to stress?",
                "What are the effects of high blood pressure on the body?",
                "What are the stages of the cell cycle?",
                "Describe the structure of a DNA molecule.",
                "What are the symptoms of bipolar disorder?",
                "Explain the process of gene expression.",
                "What are the functions of the skeletal system?",
                "How do antibiotics differ from antiviral drugs?",
                "What are the causes of high cholesterol?",
                "What are the effects of malnutrition on the body?",
                "Describe the process of synaptic transmission.",
                "What are the symptoms of epilepsy?",
                "How does the body respond to infection?",
                "What are the risk factors for developing heart disease?",
                "Explain the process of osmosis.",
                "What are the functions of the integumentary system?",
                "What are the effects of air pollution on the respiratory system?",
                "What are the symptoms of multiple sclerosis?",
                "How does the body produce energy?",
                "What are the stages of embryonic development?",
                "Explain the process of blood pressure regulation.",
                "What are the causes of kidney disease?",
                "What are the effects of radiation on the body?",
                "Describe the structure of a virus.",
                "What are the symptoms of stroke?",
                "How does the body maintain fluid balance?",
                "What are the risk factors for developing type 2 diabetes?",
                "Explain the process of DNA transcription.",
                "What are the functions of the lymphatic system?",
                "What are the effects of diabetes on the body?",
                "Describe the process of action potential propagation.",
                "What are the symptoms of liver disease?",
                "How does the body regulate blood pH?",
                "What are the causes of autoimmune diseases?",
                "What are the effects of exercise on the cardiovascular system?",
                "Explain the process of protein folding.",
                "What are the functions of the endocrine glands?",
                "What are the symptoms of thyroid disorders?",
                "How does the body regulate blood pressure?",
                "What are the risk factors for developing lung cancer?",
                "Describe the process of neurotransmitter release.",
                "What are the effects of sleep deprivation on the body?",
                "What are the symptoms of rheumatoid arthritis?",
                "Explain the process of digestion.",
                "What are the functions of the reproductive system?",
                "What are the effects of obesity on health?",
                "How does the body respond to a bacterial infection?",
                "What are the risk factors for developing asthma?",
                "Describe the process of DNA repair.",
                "What are the symptoms of heart failure?",
                "How does the body regulate blood sugar levels?",
                "What are the causes of heart attacks?",
                "Explain the process of cell signaling.",
                "What are the functions of the respiratory system?",
                "What are the effects of stress on health?",
                "Describe the process of muscle contraction.",
                "What are the symptoms of chronic obstructive pulmonary disease?",
                "How does the body regulate body temperature?"
        };
        Random rand = new Random();
        int index1 = rand.nextInt(questionList.length);
        question = questionList[index1];
        return question;
    }
    public String generateAnswer(){
        String[] answerList = {"Regulates hormone production", "Controls body temperature", "Regulates hunger and thirst", "Controls sleep patterns",
                "By increasing insulin resistance", "By decreasing blood sugar levels", "By increasing glycogen synthesis", "By inhibiting glucagon secretion",
                "Interphase, Prophase, Metaphase, Anaphase, Telophase", "G1, S, G2, M", "Prophase, Metaphase, Anaphase, Telophase, Cytokinesis", "Anaphase, Telophase, Prophase, Metaphase, Cytokinesis",
                "They block bacterial cell wall synthesis", "They inhibit viral DNA replication", "They interfere with bacterial protein synthesis", "They disrupt bacterial cell membrane function",
                "Arteries carry deoxygenated blood, while veins carry oxygenated blood", "Arteries carry blood away from the heart, while veins carry blood to the heart", "Arteries have thinner walls than veins", "Veins have valves to prevent backflow of blood, while arteries do not",
                "It produces antibodies that neutralize viruses", "It attacks virus-infected cells directly", "It activates T-cells to destroy viruses", "It produces interferons that inhibit viral replication",
                "Tremors and muscle rigidity", "Memory loss and confusion", "Visual disturbances and hallucinations", "Loss of balance and coordination",
                "Cell body, Axon, Myelin sheath, Dendrites", "Soma, Nucleus, Axon, Synapse", "Soma, Axon, Myelin sheath, Dendrites", "Cell body, Nucleus, Axon, Synapse",
                "High blood pressure, Smoking, Diabetes", "Obesity, Lack of physical activity, High cholesterol", "Age, Gender, Family history", "Stress, Alcohol consumption, Poor diet",
                "They interfere with viral entry into host cells", "They prevent viral replication within host cells", "They stimulate the immune system to attack viruses", "They disrupt viral protein synthesis",
                "Detoxification, Protein synthesis, Bile production", "Blood filtration, Hormone production, Blood sugar regulation", "Glycogen storage, Vitamin storage, Iron metabolism", "Calcium regulation, Acid-base balance, Blood clotting",
                "General anesthesia, Local anesthesia, Regional anesthesia", "Inhaled anesthesia, Topical anesthesia, Subcutaneous anesthesia", "General anesthesia, Topical anesthesia, Spinal anesthesia", "Conscious sedation, Epidural anesthesia, Intravenous anesthesia",
                "Initiation, Elongation, Termination", "Replication, Transcription, Translation", "Initiation, Replication, Termination", "Transcription, Elongation, Termination",
                "It helps in breathing and gas exchange", "It regulates blood sugar levels", "It produces hormones that control growth and development", "It removes waste products from the body",
                "Follicular phase, Ovulation, Luteal phase", "Menstrual phase, Proliferative phase, Secretory phase", "Follicular phase, Proliferative phase, Luteal phase", "Menstrual phase, Ovulation, Secretory phase",
                "Allergies, Air pollution, Respiratory infections", "Genetic predisposition, Air pollution, Stress", "Genetic predisposition, Obesity, Exposure to allergens", "Genetic predisposition, Smoking, Air pollution",
                "Platelet adhesion, Platelet aggregation, Coagulation", "Vasoconstriction, Platelet aggregation, Fibrinolysis", "Vasoconstriction, Platelet adhesion, Fibrinolysis", "Vasoconstriction, Platelet adhesion, Platelet aggregation",
                "Cleavage, Gastrulation, Neurulation", "Blastulation, Gastrulation, Organogenesis", "Fertilization, Cleavage, Implantation", "Gastrulation, Neurulation, Organogenesis",
                "They interfere with cell division", "They inhibit DNA synthesis", "They induce cell death", "They prevent angiogenesis",
                "Filtration, Reabsorption, Secretion", "Filtration, Secretion, Excretion", "Filtration, Absorption, Excretion", "Reabsorption, Secretion, Excretion",
                "Regulating growth and metabolism", "Producing hormones that control blood sugar levels", "Maintaining fluid and electrolyte balance", "Producing hormones that regulate calcium levels",
                "Neutrophils, Eosinophils, Basophils, Lymphocytes, Monocytes", "Granulocytes, Agranulocytes, Erythrocytes, Platelets", "Neutrophils, Lymphocytes, Monocytes, Eosinophils, Basophils", "Red blood cells, White blood cells, Platelets, Plasma",
                "Synaptic transmission, Neural integration, Sensory reception, Motor output", "Resting potential, Action potential, Synaptic transmission, Neurotransmitter release", "Neurotransmitter synthesis, Neurotransmitter release, Neurotransmitter binding, Postsynaptic potential", "Neurotransmitter binding, Neurotransmitter release, Neurotransmitter reuptake, Postsynaptic potential",
                "Surgery, Radiation therapy, Chemotherapy, Immunotherapy", "Surgery, Radiation therapy, Immunotherapy, Targeted therapy", "Surgery, Chemotherapy, Hormone therapy, Targeted therapy", "Radiation therapy, Chemotherapy, Hormone therapy, Immunotherapy",
                "Gas exchange, Hormone production, Blood filtration, Immune response", "Oxygen transport, Carbon dioxide transport, Acid-base balance, Blood clotting", "Oxygen transport, Carbon dioxide transport, Blood clotting, Hormone production", "Gas exchange, Hormone production, Blood clotting, Immune response",
                "Ventricular systole, Ventricular diastole, Atrial systole, Atrial diastole", "Ventricular systole, Atrial systole, Ventricular diastole, Atrial diastole", "Atrial systole, Ventricular systole, Atrial diastole, Ventricular diastole", "Atrial systole, Ventricular diastole, Atrial diastole, Ventricular systole",
                "Innate immunity, Acquired immunity, Active immunity, Passive immunity", "Innate immunity, Adaptive immunity, Active immunity, Passive immunity", "Cell-mediated immunity, Humoral immunity, Passive immunity, Active immunity", "Antibody-mediated immunity, Cell-mediated immunity, Passive immunity, Active immunity",
                "Chemical digestion, Mechanical digestion, Nutrient absorption, Waste elimination", "Oral cavity, Pharynx, Esophagus, Stomach", "Stomach, Small intestine, Large intestine, Rectum", "Duodenum, Jejunum, Ileum, Colon"};
        Random rand = new Random();
        int index1 = rand.nextInt(answerList.length);
        answer = answerList[index1];
        return answer;
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
