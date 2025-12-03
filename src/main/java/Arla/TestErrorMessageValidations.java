package Arla;
import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class TestErrorMessageValidations extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test

    //SERVICE COURSE ERROR MESSAGE VALIDATIONS
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

    //SERVICE CATEGORY ERROR MESSAGE VALIDATIONS
    public void serviceValidationRegisterFormMessageError(){
        methods.startContextAndNavigation();
        testEmptyRegisterInputs();
        teardownPlaywright();
    }
    public void serviceValidationLoginFormMessageError(){
        methods.startContextAndNavigation();
        testEmptyLoginInputs();
        teardownPlaywright();
    }
    public void serviceValidationCategoryFormMessageErrorStep1(){
        methods.startContextAndNavigation();
        testEmptyInputsCategoryFormStep1();
        teardownPlaywright();
    }
    public void serviceValidationCategoryFormMessageErrorStep2(){
        methods.startContextAndNavigation();
        testEmptyInputsCategoryFormStep2();
        teardownPlaywright();
    }
    public void serviceValidationCategoryFormMessageErrorStep3(){
        methods.startContextAndNavigation();
        testEmptyInputsCategoryFormStep3();
        teardownPlaywright();
    }
}
