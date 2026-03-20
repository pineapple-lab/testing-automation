package InsumosSpacelogik;


import java.util.Map;

public class DataTestCaseSpacelogik {
    private GeneratorSpaceLogik gen;

    public DataTestCaseSpacelogik(GeneratorSpaceLogik gen) {
        this.gen = gen;
    }

    public String selectCase(String tipoDesdeExcel) {
        if (tipoDesdeExcel == null || tipoDesdeExcel.equalsIgnoreCase("N/A")) return "";
        return switch (tipoDesdeExcel.toLowerCase().trim()) {
            case "letras" -> gen.generateCompanyName() + gen.generateLocationName();
            case "numeros" -> gen.generateNumber();
            case "caracteres" -> gen.generateSpecialChars();
            case "letrasynumeros" -> gen.generateCompanyName() + gen.generateNumber();
            case "caracteresynumeros" -> gen.generateSpecialChars() + gen.generateNumber();
            case "caracteresyletras" -> gen.generateSpecialChars() + gen.generateCompanyName();
            case "caracteresletrasynumeros" -> gen.generateSpecialChars() + gen.generateNumber() + gen.generateCompanyName();
            default -> "";
        };
    }
    private final Map<String, Integer> salutationMap = Map.of(
            "Mr", 2,
            "Mrs", 3,
            "Ms", 4,
            "Miss", 5,
            "Dr", 6
    );
    private final Map<String, Integer> skillMap = Map.of(
            "TransactionGuru", 1,
            "ConstructionGuru", 2,
            "WorkplaceGuru", 3,
            "Assistant", 4
    );
    private final Map<String, Integer> industryMap = Map.of(
            "Accounting", 2,
            "Accounting_clone", 3,
            "Accounting_clone_clone", 4,
            "Consulting/ProfessionalServices", 5,
            "Insurance", 6,
            "Legal", 7,
            "Marketing&Advertising", 8,
            "SalesOffices",9,
            "Technology", 10,
            "Technology_clone", 11

    );
    private final Map<String, Integer> levelConstruction = Map.of(
            "Level1", 0,
            "Level2", 1,
            "Level3", 2,
            "Level4", 3
    );
    private final Map<String, Integer> levelFurniture = Map.of(
            "Level1", 0,
            "Level2", 1,
            "Level3", 2,
            "Level4", 3
    );
    private final Map<String, Integer> widthPrimaryPreference = Map.of(
            "Primary60", 1,
            "Primary72", 2,
            "Primary84", 3,
            "1_49", 4,
            "50_100", 4
    );
    private final Map<String, Integer> widthSecondaryPreference = Map.of(
            "Secondary42", 1,
            "Secondary48", 2,
            "Secondary54", 3,
            "1_49", 4,
            "50_100", 4
    );
    private final Map<String, Integer> roomType = Map.of(
            "PrivateOffice", 1,
            "Workstations", 2,
            "Sharedoffice", 3
    );
    private final Map<String, Integer> lightPreference = Map.of(
            "NoPreference", 1,
            "locateoninterior", 2,
            "Locateonwindowline", 3
    );
    private final Map<String, Integer> leaseTypeMap = Map.of(
            "Replace", 1,
            "New", 2
    );
    private final Map<String, Integer> quantity = Map.of(
            "1_49", 4,
            "50_100", 4
    );
    private final Map<String, Integer> centerMap = Map.of (
            "1mile", 2,
            "3miles", 3,
            "5miles", 4,
            "10miles", 5
    );
    private final Map<String, Integer> fromMap = Map.of (
            "CurrentLocation", 2,
            "AnotherAddress", 3
    );
    private final Map<String, Integer> standardProgramYearInputsMap = Map.of(
            "2027", 1,
            "2028", 2,
            "2031", 5,
            "2032", 6,
            "2035", 9,
            "2036", 10
            );
    private final Map <String, Integer> newLeaseTermMap = Map.ofEntries(
            Map.entry("1", 1),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("10", 10),
            Map.entry("11", 11)
    );
    public Map<String, Integer> getIndustryMap() {return industryMap;}
    public Map<String, Integer> getLevelConstruction() {return levelConstruction;}
    public Map<String, Integer> getLevelFurniture() {return levelFurniture;}
    public Map<String, Integer> getWidthPrimaryPreference() {return widthPrimaryPreference;}
    public Map<String, Integer> getWidthSecondaryPreference() {return widthSecondaryPreference;}
    public Map<String, Integer> getRoomTypePreference() {return roomType;}
    public Map<String, Integer> getLightPreference() {return lightPreference;}
    public Map<String, Integer> getSalutationPreference() {return salutationMap;}
    public Map<String, Integer> getSkillPreference() {return skillMap;}
    public Map <String, Integer> getLeaseTypePreference(){return leaseTypeMap;}
    public Map <String, Integer> getCenterMapPreference(){return centerMap;}
    public Map <String, Integer> getFromPreference (){return fromMap;}
    public Map <String, Integer> getStandardProgramYearPreference(){return  standardProgramYearInputsMap;}
    public Map <String, Integer> getNewLeaseTermPreference (){return newLeaseTermMap;}
    public int getIndustryPosition(String valorExcel) {
        return industryMap.getOrDefault(valorExcel, 1);
    }
}