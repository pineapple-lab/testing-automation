package com.papa.SPACELOGIK.config;

import com.papa.core.config.ConfigReader;

public class SPACELOGIKConfig {

    private static final ConfigReader CONFIG = new ConfigReader("spacelogik.properties");

    private SPACELOGIKConfig() {}

    public static String getUrl() {
        return CONFIG.get("spacelogik.base.url.dev");
    }
}
