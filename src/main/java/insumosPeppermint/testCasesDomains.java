package insumosPeppermint;

public class testCasesDomains extends methodsPeppermint {
    public void validateDomains(){
        for (counter = 1; counter <= execute; counter++) {
            if (!stopTest) {
                checkDomains();
                printNumberCasesExecuted();
            } else {
                closeContext();
            }
        }
        closeContext();
    }
    }
