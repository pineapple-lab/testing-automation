package com.papa.SPACELOGIK.base;
import com.papa.SPACELOGIK.client.data.ClientData;
import com.papa.core.dataCollections.*;
import com.papa.core.util.GeneratorData;
import com.papa.core.util.PathUtils;

import java.util.List;

public class SpacelogikDataGenerator {
    private static final String[] MEDIA_IDS = {"1", "2", "3", "4"};

    private final GeneratorData gen;

    public SpacelogikDataGenerator() {
        this.gen = new GeneratorData();
    }

    public SpacelogikDataGenerator(GeneratorData gen) {   // útil para inyectar una con semilla
        this.gen = gen;
    }

    public String firstName() {
        return gen.randomFrom(FirstName.firstName);
    }
    public String lastName() {
        return gen.randomFrom(LastName.lastName);
    }
    public String title() {
        return gen.randomFrom(Titles.titles);
    }
    public String phone(){
        return gen.randomFrom(PhonesEEUU.phones);
    }
    public String mobile(){
        return gen.randomFrom(PhonesEEUU.phones);
    }
    public String description(){
        return gen.randomFrom(Description.description);
    }
    public String industry(){return gen.randomFrom(ClientData.industryCollection);}
    public String salutation(){return gen.randomFrom(ClientData.salutationCollection);}
    public String companyName(){return gen.randomFrom(CompanyName.companyName);}
    public String image() {
        return gen.randomFilePath(MEDIA_IDS,
                PathUtils.getAbsolutePath(PathUtils.RELATIVE_IMAGE_PATH), ".jpg");
    }
    public int randomIndex(int from, int size){
        return gen.randomIndexFrom(from, size);
    }
    public String video() {
        return gen.randomFilePath(MEDIA_IDS,
                PathUtils.getAbsolutePath(PathUtils.RELATIVE_VIDEO_PATH), ".mp4");
    }
    public <T> T randomFromArray(List<T> list){
        return gen.randomFrom(list);
    }
    public String email(String firstName, String lastName, String domain, String TLD) {
        return gen.uniqueEmail(firstName, lastName, domain, TLD);
    }

}

