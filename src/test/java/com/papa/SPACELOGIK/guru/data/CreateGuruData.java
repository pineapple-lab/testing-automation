package com.papa.SPACELOGIK.guru.data;
import com.papa.SPACELOGIK.base.SpacelogikDataGenerator;
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
    public static final String DEFAULT_NAME = data.firstName();
    public static final String DEFAULT_LAST_NAME = data.lastName();
    public static final String DEFAULT_DOMAIN = "pineapple-lab";
    public static final String DEFAULT_TLD = ".com";
    @Builder.Default private String salutation = "Ms.";
    @Builder.Default private int office = 2;
    @Builder.Default private String skill = "Transaction guru";
    private String name;
    private String lastName;
    private String email;
    private String image;
    private String title;
    private String mobile;
    private String phone;
    private String description;

    /*private String Salutation;
    private int office;
    */

    public String getImage(){
        return data.image();
    }
    public static CreateGuruDataBuilder random(SpacelogikDataGenerator data) {
        String name = data.firstName();
        String lastName = data.lastName();
        return CreateGuruData.builder()
                .name(name)
                .lastName(lastName)
                .title(data.title())
                .mobile(data.mobile())
                .phone(data.phone())
                .description(data.description())
                .email(data.email(name, lastName, DEFAULT_DOMAIN, DEFAULT_TLD))
                .image(data.image());
    }
}
