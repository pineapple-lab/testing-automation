package com.pap.CMS.config;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class CMSConfig {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = CMSConfig.class.getClassLoader().getResourceAsStream("cms.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró cms.properties en resources");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar cms.properties", e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("cms.base.url");
    }
}