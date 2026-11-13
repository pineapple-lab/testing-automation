package com.pap.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final ConfigReader DEFAULT = new ConfigReader("config.properties");

    private final Properties properties = new Properties();
    private final String fileName;

    public ConfigReader(String fileName) {
        this.fileName = fileName;
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("No se encontró " + fileName + " en resources");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar " + fileName, e);
        }
    }

    public String get(String key) {
        String value = System.getProperty(key);
        if (value == null) value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Falta la propiedad '" + key + "' en " + fileName);
        }
        return value.trim();
    }

    public static String getProperty(String key) {
        return DEFAULT.get(key);
    }
}