package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionUploadVideo extends TestCaseArla {
    MethodsArla methods = new MethodsArla();
    @Test
    public void serviceUploadVideos(){
        methods.startContextAndNavigation();
        happyPathUploadVideos();
        teardownPlaywright();
    }
}
