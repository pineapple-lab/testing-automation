package Peppermint;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
import insumosPeppermint.casosDePruebaTechnique;
import insumosPeppermint.robotBasePeppermint;
import kotlin.annotation.Target;
import org.apache.bcel.generic.FLOAD;
import org.apache.tools.ant.taskdefs.LoadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.function.Consumer;


public class funcionTechniqueManagment extends casosDePruebaTechnique {
    @Test
    public void validacionCreateTechnique() {
        iniciarContexto();
        serverStatus();
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionTechnique();
        imprimirCantidadDeEjecuciones();
        iniciarNavegacion();
        login();
        validarCrearTechnique();
    }
}