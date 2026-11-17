package com.pap.SPACELOGIK.createGuru.data;
import com.pap.SPACELOGIK.base.SpacelogikDataGenerator;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder(toBuilder = true)

public class CreateGuruData {
    private static SpacelogikDataGenerator data = new SpacelogikDataGenerator();
    public static final String skillTransaction = "Transaction";
    public static final String skillConstruction = "Construction";
    public static final String skillWorkplace = "Workplace";
    public static final String skillAssistant = "Assistant";
    public static final String TEXT_SUCCESS_MODAL = "The Guru has been created successfully\n" +
            "The Guru will receive an email at null to set their password and begin using SpaceLogik.\n" +
            "Assign to a location\n" +
            "Ok";
    public static final String BODY_SUCCESS_MODAL = "The Guru will receive an email at null to set their password and begin using SpaceLogik.";
    public static final String DEFAULT_NAME = data.firstName();
    public static final String DEFAULT_LAST_NAME = data.lastName();
    public static final String DEFAULT_DOMAIN = "pineapple-lab";
    public static final String DEFAULT_TLD = ".com";
    @Builder.Default private String title = "Senior QA";
    @Builder.Default private String salutation = "Ms.";
    @Builder.Default private String mobile = "0991234563";
    @Builder.Default private String phone = "2400123432";
    @Builder.Default private int office = 2;
    @Builder.Default private String skill = "Transaction guru";
    @Builder.Default private String description = "Guru creado por automatización";
    private String name;
    private String lastName;
    private String email;
    private String image;
    /*private String title;
    private String Salutation;
    private String mobile;
    private String phone;
    private int office;
    private String skill;
    private String description;*/

    public String getImage(){
        return data.image();
    }
    public static CreateGuruDataBuilder random(SpacelogikDataGenerator data) {
        String name = data.firstName();
        String lastName = data.lastName();
        return CreateGuruData.builder()
                .name(name)
                .lastName(lastName)
                .email(data.email(name, lastName, DEFAULT_DOMAIN, DEFAULT_TLD))
                .image(data.image());
    }
}
