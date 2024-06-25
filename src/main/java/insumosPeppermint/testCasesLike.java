package insumosPeppermint;

public class testCasesLike extends methodsPeppermint{
     public void validateLike(){
         for (counter = 1; counter <= execute; counter++) {
             if (!stopTest) {
                 startVaraiblesJoinUserClub();
                 login();
                 like();
                 System.out.println("El usuario "+emailLogin+" dio like con exito \n");
                 outputStream.println("El usuario "+emailLogin+" dio like con exito \n");
                 printNumberCasesExecuted();
                 logout();
             } else {
                 closeContext();
             }
         }
         closeContext();
     }
}
