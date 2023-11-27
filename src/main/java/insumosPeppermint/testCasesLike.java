package insumosPeppermint;

public class testCasesLike extends methodsPeppermint{
     public void validateLike(){
         for (counter = 1; counter <= execute; counter++) {
             if (!shouldStopTest) {
                 startVaraiblesJoinUserClub();
                 login();
                 like();
                 System.out.println("El usuario "+emailLogin+" dio like con exito \n");
                 printStream.println("El usuario "+emailLogin+" dio like con exito \n");
                 printNumberCasesExecuted();
                 logout();
             } else {
                 closeContext();
             }
         }
         closeContext();
     }
}
