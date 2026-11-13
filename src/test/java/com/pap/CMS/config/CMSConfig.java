package com.pap.CMS.config;

import com.pap.core.config.ConfigReader;

public final class CMSConfig {

    private static final ConfigReader CONFIG = new ConfigReader("cms.properties");

    private CMSConfig() {}

    public static String getUrl() {
        return CONFIG.get("cms.base.url");
    }
}