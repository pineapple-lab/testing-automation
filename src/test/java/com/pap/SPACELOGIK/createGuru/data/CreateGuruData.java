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
    @Builder.Default private String name = DEFAULT_NAME;
    @Builder.Default private String salutation = "Ms.";
    @Builder.Default private String lastName = DEFAULT_LAST_NAME;
    @Builder.Default private String email = data.email(DEFAULT_NAME, DEFAULT_LAST_NAME,DEFAULT_DOMAIN,DEFAULT_TLD);
    @Builder.Default private String mobile = "0991234563";
    @Builder.Default private String phone = "2400123432";
    @Builder.Default private int office = 2;
    @Builder.Default private String skill = "Transaction guru";
    @Builder.Default private String description = "Guru creado por automatización";
    //@Builder.Default private String pathAsset = "Guru creado por automatización";

    public String getImage(){
        return data.image();
    }
}
