package Arla;
import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class TestErrorMessageValidations extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceValidationCourseFormMessageErrorStep1(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep1();
        teardownPlaywright();
    }
    public void serviceValidationCourseFormMessageErrorStep2(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep2();
        teardownPlaywright();
    }
    public void serviceValidationCourseFormMessaegeErrorStep3(){
        methods.startContextAndNavigation();
        testEmptyInputsCourseFormStep3();
        teardownPlaywright();
    }
    public void serviceValidationCourseListQuizMessageError(){
        methods.startContextAndNavigation();
        testEmptyListQuizCourseForm();
        teardownPlaywright();
    }
    public void serviceValidationCourseAddQuestionMessageError(){
        methods.startContextAndNavigation();
        testEmptyAddQuestionCourseForm();
        teardownPlaywright();
    }
}
