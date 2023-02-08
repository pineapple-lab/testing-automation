package Peppermint;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
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


public class funcionTechniqueManagment extends robotBasePeppermint {
    @Test
    public void validacionCreateTechnique(){
        System.out.println("iniciando caso de prueba...");
        iniciarEjecucionTechnique();
        System.out.println("El caso se va a ejecutar "+ejecutar+" veces");
        iniciarNavegacion();
        login();
        for(contador=1;contador<=ejecutar;contador++) {
        iniciarVariablesCrearTechnique();
        createTechnique();
        page.focus("app-mat-table");
        assertions="text="+titleTechnique;
        //Assertions.assertTrue(page.isVisible(assertions));
        System.out.println("El caso CA0321 se ejecuto "+contador+" veces");
        }
    }
}
