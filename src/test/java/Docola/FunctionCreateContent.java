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
        teardownPlaywright();
    }
    @Test
    public void serviceNewCourse(){
        methods.startContextAndNavigation();
        create.newCourse();
        teardownPlaywright();
    }
    @Test
    public void serviceNewCourseCollection(){
        methods.startContextAndNavigation();
        create.newCourseCollection();
        teardownPlaywright();
    }
    @Test
    public void serviceNewResourceInPractice(){
        methods.startContextAndNavigation();
        create.newResourceInPractice();
        teardownPlaywright();
    }
    @Test
    public void serviceNewCourseInPractice(){
        methods.startContextAndNavigation();
        create.newCourseInPractice();
        teardownPlaywright();
    }
    @Test
    public void serviceNewCourseCollectionInPractice(){
        methods.startContextAndNavigation();
        create.newCourseCollectionInPractice();
        teardownPlaywright();
    }
}
