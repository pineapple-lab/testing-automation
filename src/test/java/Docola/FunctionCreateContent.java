package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionCreateContent extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    MethodsCreationDocola create = new MethodsCreationDocola();
    @Test
    public void serviceNewContent(){
        methods.startContextAndNavigation();
        create.newContent();
        closeContext();
        closeBrowser();
    }
}
