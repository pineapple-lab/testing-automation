package Arla;

import InsumosArla.ContextArla;

public class GeneratorArla extends ContextArla {
    public int generateExecutions(){
        return Integer.parseInt(executionDetails);
    }
}
