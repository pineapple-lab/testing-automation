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
            case "letrasynumeros" -> gen.generateCompanyName() + " " + gen.generateNumber();
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
    private final Map<String, Integer> industryMap = Map.of(
            "Accounting", 2,
            "Accounting_clone", 3,
            "Accounting_clone_clone", 4,
            "Consulting", 5,
            "Insurance", 6,
            "Legal", 7,
            "Marketing", 8,
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
    private final Map<String, Integer> quantity = Map.of(
            "1_49", 4,
            "50_100", 4
    );
    public Map<String, Integer> getIndustryMap() {return industryMap;}
    public Map<String, Integer> getLevelConstruction() {return levelConstruction;}
    public Map<String, Integer> getLevelFurniture() {return levelFurniture;}
    public Map<String, Integer> getWidthPrimaryPreference() {return widthPrimaryPreference;}
    public Map<String, Integer> getWidthSecondaryPreference() {return widthSecondaryPreference;}
    public Map<String, Integer> getRoomTypePreference() {return roomType;}
    public Map<String, Integer> getLightPreference() {return lightPreference;}
    public Map<String, Integer> getSalutationPreference() {return salutationMap;}
    public int getIndustryPosition(String valorExcel) {
        return industryMap.getOrDefault(valorExcel, 1);
    }
}