package Arla;
import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class TestErrorMessageValidations extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceValidationCourseNameMessaegeErrorStep1(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep1();
        teardownPlaywright();
    }
    public void serviceValidationCourseNameMessaegeErrorStep2(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep2();
        teardownPlaywright();
    }
    public void serviceValidationCourseNameMessaegeErrorStep3(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep3();
        teardownPlaywright();
    }
}
