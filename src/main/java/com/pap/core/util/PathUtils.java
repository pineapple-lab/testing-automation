package com.pap.core.util;

import com.pap.core.config.ConfigReader;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
    private static String BASE_PATH = null;

    // Rutas relativas organizadas para tus recursos
    public static final String RELATIVE_IMAGE_PATH = makeRelative("Contenidos" + File.separator + "imagen");
    public static final String RELATIVE_PICTURE_PROFILE_PATH = makeRelative("Picture profile" + File.separator + "profile");
    public static final String RELATIVE_VIDEO_PATH = makeRelative("Videos" + File.separator + "video");

    public static String getBasePath() {
        if (BASE_PATH == null) {
            initializeBasePath();
        }
        return BASE_PATH;
    }

    /**
     * Obtiene la ruta absoluta combinando la base y una ruta relativa,
     * ideal para pasárselo directamente a Playwright.
     */
    public static String getAbsolutePath(String relativePath) {
        return Paths.get(getBasePath(), relativePath).toString();
    }
    private static String makeRelative(String relativePath) {
        if (BASE_PATH == null) {
            initializeBasePath();
        }
        Path basePathPath = Paths.get(BASE_PATH).normalize();
        Path fullPath = basePathPath.resolve(relativePath).normalize();
        return basePathPath.relativize(fullPath).toString();
    }
    private static void initializeBasePath() {
        String configuredPath = ConfigReader.getProperty("assets.path");

        if (configuredPath == null || configuredPath.isEmpty()) {
            configuredPath = "src/automationAssets";
        }
        Path assetPath = Paths.get(System.getProperty("user.dir"), configuredPath);

        if (Files.exists(assetPath) && Files.isDirectory(assetPath)) {
            BASE_PATH = assetPath.toAbsolutePath().toString();
        } else {
            throw new IllegalStateException("No se pudo encontrar el directorio de assets en: " + assetPath.toAbsolutePath());
        }
    }
}
