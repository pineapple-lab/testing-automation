package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA07validacionProposalExcepcion extends robotBaseSpaceLogik {

    @Test
    public void CA071validacionNombreVacioExcepcion(){
        login();
        excepcionProposalNombreVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Proposal name cannot be empty"));
    }
    @Test
    public void CA072validacionMensajePropposalDuplicado(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA072 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameProposal+".7-validacionExcepcionPropposalduplicado.Ejecuciones:"+contador;
            login();
            crearProposal();
            crearProposal();
            page.focus("body > div:nth-child(4) > div");
            Assertions.assertTrue(page.isVisible("text=Proposal name exists already for this prospect"));
            System.out.println("El caso CA072 se ejecuto"+contador+"veces");
        }
    }
    @Test
    public void CA073validacionMensajePropposalDuplicadoArchivado(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesCreacionProposal();
        System.out.println("El caso CA073 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameProposal+".34-validacionExcepcionPropposalDuplicadoArchivado.Ejecuciones:"+contador;
            login();
            crearProposal();
            archivarProposal();
            crearProposal();
            page.focus("body > div:nth-child(4) > div");
            Assertions.assertTrue(page.isVisible( "text=Proposal name exists already for this prospect"));
            Assertions.assertTrue(page.isVisible("text=Proposal name exists already for this prospect"));
            System.out.println("El caso CA073 se ejecuto "+contador+" veces");
        }
    }
}
