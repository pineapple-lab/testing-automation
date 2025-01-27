package InsumosArla;

import InsumosDocola.PathUtils;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtilsArla {
        private static final String ROOT ="C";
        //public static final String BASE_PATH = ROOT+":\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\assets\\automationAssets\\";
        //public static final String BASE_PATH = ROOT +":\\Users\\Fran\\Desktop\\dev\\TestingAutomation\\src\\assets\\automationAssets\\";
        private static String BASE_PATH = null;
        public static final String RELATIVE_IMAGE_PATH = makeRelative("Contenidos\\imagen");
        public static final String RELATIVE_PICTURE_PROFILE_PATH = makeRelative("Picture profile\\profile");
        public static final String RELATIVE_VIDEO_PATH = makeRelative("Videos\\video");
        // Método para convertir una ruta completa a relativa
        public static String getBasePath() {
            if (BASE_PATH == null) {
                throw new IllegalStateException("BASE_PATH no ha sido inicializado.");
            }
            return BASE_PATH;
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
            try {
                File currentDirectory = new File(InsumosDocola.PathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile();
                Path assetPath = Paths.get(currentDirectory.getAbsolutePath(), "src","assets", "automationAssets");

                if (Files.exists(assetPath) && Files.isDirectory(assetPath)) {
                    BASE_PATH = assetPath.toAbsolutePath().toString();
                } else {
                    throw new IllegalStateException("No se pudo encontrar el directorio assets/automationAssets.");
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
                throw new IllegalStateException("Error al obtener la ruta base.", e);
            }
        }
    }
