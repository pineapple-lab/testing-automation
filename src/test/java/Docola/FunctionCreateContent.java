package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FunctionCreateContent extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    MethodsCreationDocola create = new MethodsCreationDocola();
    @Test
    public void serviceNewResource(){
        methods.startContextAndNavigation();
        create.newResource();
        cleanupContext();
        teardownPlaywright();
    }
    @Test
    public void serviceNewCourse(){
        create.newCourse();
    }
    @Test
    public void serviceNewCourseCollection(){
        create.newCourseCollection();
    }
}
