package com.papa.SPACELOGIK.client.data;

import com.papa.SPACELOGIK.base.SpacelogikDataGenerator;
import com.papa.SPACELOGIK.guru.data.CreateGuruData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)

public class ClientData {
    public static String[] industryCollection = {"Accounting","Consulting/Professional Services","Insurance","Legal"
    ,"Marketing & Advertising","Medical","Sales Offices","Technology"};

    public static String[] salutationCollection = {"Mr.","Mrs.","Ms.","Miss"
            ,"Dr."};
    private static SpacelogikDataGenerator data = new SpacelogikDataGenerator();
    public static final String DEFAULT_NAME = data.firstName();
    public static final String DEFAULT_LAST_NAME = data.lastName();
    public static final String DEFAULT_DOMAIN = "pineapple-lab";
    public static final String DEFAULT_TLD = ".com";
    private String companyName;
    private String name;
    private String lastName;
    private String email;
    private String image;
    private String title;
    private String mobile;
    private String phone;
    private String description;
    private String industry;
    private String salutation;

    public String getImage(){
        return data.image();
    }
    public static ClientDataBuilder random(SpacelogikDataGenerator data) {
        String name = data.firstName();
        String lastName = data.lastName();
        return ClientData.builder()
                .companyName(data.companyName())
                .salutation(data.salutation())
                .industry(data.industry())
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
