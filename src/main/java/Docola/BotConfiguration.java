package Docola;
import InsumosDocola.MethodsCreationDocola;
import InsumosDocola.QueriesDocola;
import InsumosDocola.VariablesDocola;
public class BotConfiguration extends MethodsCreationDocola {
    QueriesDocola queries = new QueriesDocola();
    public void serviceUpdateUndefinedUser(String email){
        queries.updateUndefinedUser(email);
    }
}
