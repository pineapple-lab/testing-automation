
package SpaceLogik.pw.Proposal;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Statement;

public class CA021proposalFuncionCrear extends robotBaseSpaceLogik {
        @Test
        public void CA0211ProposalCreatorFeliz001() {

            nameProposal = "asdfasdfdasfsdaf";
            login();
            iniciarVariablesProposalXYZ77M();
            crearProposal();
            page.focus(".proposal-list-table-container");
            sqlGuardarCasoSiFalla();
            Assertions.assertTrue(page.isVisible("text=pruebAutomatizada1-validacioncrear"));
                }
        public void sqlGuardarCasoSiFalla(){
            if( (page.isVisible("text=pruebAutomatizada1-validacioncrear"))==false){
                String estadoDeLaPrueba = "fallido";
                sqlconectar();
                try {
                    Statement st = CN.createStatement();
                    String query = "INSERT INTO datosdpruebaproposalcreator (`building`,`prospect`,`program`,`estadodelaprueba`,`fechaDePrueba`) " +
                            "VALUES("+building+","+prospect+","+program+","+"'"+estadoDeLaPrueba+"'"+",NOW())";
                    st.executeUpdate(query);
                    System.out.println("Los datos de la prueba fallida se guardaron correctamente");
                }catch (Exception e){e.printStackTrace();}
                sqlclose();
              }
            }
        }