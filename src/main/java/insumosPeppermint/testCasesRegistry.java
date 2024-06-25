package insumosPeppermint;

public class testCasesRegistry extends methodsPeppermint{
    public void validateRegistry(){
            for (counter = 1; counter <= execute; counter++) {
                if (!stopTest) {
                    if(navigationLink=="http://localhost:4200/"){
                        navigationLink="http://localhost:4200/auth/register?planId=prod_LiHZubb4rv5TeR&coupon=Minter100";
                    }else if(navigationLink=="https://peppermint-qa.web.app/"){
                        navigationLink = "https://peppermint-qa.web.app/auth/register?planId=prod_LiHZubb4rv5TeR&coupon=Minter100";
                    }
                    startNavigation();
                    registerUser();
                    logout();
                    System.out.println("El usuario se ha creado con exito\n");
                    outputStream.println("El usuario se ha creado con exito\n");
                    printNumberCasesExecuted();
                } else {
                    closeContext();
                }
            }
            closeContext();
        }
}
