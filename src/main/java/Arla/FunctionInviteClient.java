package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionInviteClient extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceInviteClients(){
        methods.startContextAndNavigation();
        happyPathInviteClient();
        teardownPlaywright();
    }
}
