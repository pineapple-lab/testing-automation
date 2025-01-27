package Arla;

import InsumosArla.MethodsArla;
import InsumosArla.TestCaseArla;
import org.junit.jupiter.api.Test;

public class FunctionUploadVideo extends TestCaseArla {
    @Test
    public void serviceUploadVideos(){
        happyPathUploadVideos();
        teardownPlaywright();
    }
}
