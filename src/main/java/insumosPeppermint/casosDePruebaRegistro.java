package insumosPeppermint;
import java.time.Instant;
public class casosDePruebaRegistro extends robotBasePeppermint{
    public void validarRegistro(){
            for (contador = 1; contador <= ejecutar; contador++) {
                if (!shouldStopTest) {
                    if(linkDeNavegacion=="http://localhost:4200/"){
                        linkDeNavegacion="http://localhost:4200/user/plans";
                    }else if(linkDeNavegacion=="https://peppermint-qa.web.app/"){
                        linkDeNavegacion = "https://peppermint-qa.web.app/user/plans";
                    }
                    iniciarNavegacion();
                    registrarUsuario();
                    guardarUsuario();
                    logout();
                    System.out.println("El usuario se ha creado con exito\n");
                    printStream.println("El usuario se ha creado con exito\n");
                    imprimirCantidadDeCasosEjecutados();
                } else {
                    closeContext();
                }
            }
            closeContext();
        }
}
