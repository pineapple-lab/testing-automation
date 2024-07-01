package InsumosDocola;

import java.nio.file.Path;
import java.nio.file.Paths;
public class PathUtils {
    private static final String ROOT ="C";
    public static final String BASE_PATH = ROOT+":\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\assets\\automationAssets\\";
    public static final String RELATIVE_IMAGE_PATH = makeRelative(BASE_PATH, "Contenidos\\imagen");
    public static final String RELATIVE_PICTURE_PROFILE_PATH = makeRelative(BASE_PATH, "Picture profile\\profile");
    public static final String RELATIVE_VIDEO_PATH = makeRelative(BASE_PATH, "Videos\\video");

    // Método para convertir una ruta completa a relativa
    private static String makeRelative(String basePath, String fullPath) {
        Path base = Paths.get(basePath);
        Path full = Paths.get(basePath, fullPath);
        return base.relativize(full).toString();
    }
}
