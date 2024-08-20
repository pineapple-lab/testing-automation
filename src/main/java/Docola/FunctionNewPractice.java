package Docola;

import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.MethodsDocola;
import org.junit.jupiter.api.Test;

public class FunctionNewPractice extends MethodsCreationDocola {
    MethodsDocola methods = new MethodsDocola();
    @Test
    public void serviceNewPractice(){
        methods.startContextAndNavigation();
        newPractice();
        teardownPlaywright();
    }
    @Test
    public void servicePracticeInvitationRegister(){
        methods.startContextAndNavigation();
        newInvitationRegister();
        teardownPlaywright();
    }
}
