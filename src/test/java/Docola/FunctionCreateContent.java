package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionCreateContent extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    MethodsCreationDocola create = new MethodsCreationDocola();
    @Test
    public void serviceNewResource(){
        methods.startContextAndNavigation();
        create.newResource();
        closeContext();
        closeBrowser();
    }
    @Test
    public void serviceNewCourse(){
        methods.startContextAndNavigation();
        create.newCourse();
    }
    @Test
    public void serviceNewCourseCollection(){
        methods.startContextAndNavigation();
        create.newCourseCollection();
    }
}
