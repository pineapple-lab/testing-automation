package com.papa.CMS.config;

import com.papa.core.config.ConfigReader;

public final class CMSConfig {

    private static final ConfigReader CONFIG = new ConfigReader("cms.properties");

    private CMSConfig() {}

    public static String getUrl() {
        return CONFIG.get("cms.base.url");
    }
}