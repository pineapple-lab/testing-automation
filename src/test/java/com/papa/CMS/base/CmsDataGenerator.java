package com.papa.CMS.base;

import com.papa.core.dataCollections.Description;
import com.papa.core.dataCollections.TaskName;
import com.papa.core.util.GeneratorData;
import com.papa.core.util.PathUtils;

public class CmsDataGenerator {
    private static final String[] MEDIA_IDS = {"1", "2", "3", "4"};

    private final GeneratorData gen;

    public CmsDataGenerator() {
        this.gen = new GeneratorData();
    }

    public CmsDataGenerator(GeneratorData gen) {   // útil para inyectar una con semilla
        this.gen = gen;
    }

    public String taskName() {
        return gen.randomFrom(TaskName.taskName);
    }

    public String taskDescription() {
        return gen.randomFrom(Description.description);
    }

    public String image() {
        return gen.randomFilePath(MEDIA_IDS,
                PathUtils.getAbsolutePath(PathUtils.RELATIVE_IMAGE_PATH), ".jpg");
    }

    public String video() {
        return gen.randomFilePath(MEDIA_IDS,
                PathUtils.getAbsolutePath(PathUtils.RELATIVE_VIDEO_PATH), ".mp4");
    }

    public String email(String firstName, String lastName) {
        return gen.uniqueEmail(firstName, lastName, "mailinator", ".com");
    }
}
