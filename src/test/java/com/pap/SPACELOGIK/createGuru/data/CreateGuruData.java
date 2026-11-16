package com.pap.SPACELOGIK.createGuru.data;
import com.pap.SPACELOGIK.base.GeneratorData;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder(toBuilder = true)

public class CreateGuruData {
    private static GeneratorData generator = new GeneratorData();
    public static final String TITLE_SUCCESS_MODAL = "The Guru has been created successfully";
    public static final String BODY_SUCCESS_MODAL = "The Guru will receive an email at null to set their password and begin using SpaceLogik.";
    public static final String DEFAULT_NAME = "Ana";
    public static final String DEFAULT_LAST_NAME = "Perez";

    @Builder.Default private String title = "Senior QA";
    @Builder.Default private String name = DEFAULT_NAME;
    @Builder.Default private String salutation = "Ms.";
    @Builder.Default private String lastName = DEFAULT_LAST_NAME;
    @Builder.Default private String email = generator.generateEmail(DEFAULT_NAME, DEFAULT_LAST_NAME,"gmail",".com");
    @Builder.Default private String mobile = "099123456";
    @Builder.Default private String phone = "24001234";
    @Builder.Default private int office = 1;
    @Builder.Default private String skill = "Transaction";
    @Builder.Default private String description = "Guru creado por automatización";
    //@Builder.Default private String pathAsset = "Guru creado por automatización";

    public String getImage(){
        return generator.generateImage();
    }
}
