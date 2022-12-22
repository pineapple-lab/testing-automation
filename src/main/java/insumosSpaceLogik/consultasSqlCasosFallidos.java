package insumosSpaceLogik;

import java.sql.Statement;

public class consultasSqlCasosFallidos extends contextoBaseSpaceLogik{
    public void sqlGuardarCasoSiFallaCrearProspect(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscasosfallidoscrearprospect (`salutation`,`firstName`,`lastName`,`titleProspect`,`adress1`,`adress2`" +
                        ",`state`,`city`,`zipCode`,`email`,`phone`,`industry`,`approxRsf`,`ocupancyDate`,`fechaDePrueba`) " +
                        "VALUES("+"'"+salutationProspect+"'"+","+"'"+firstNameProspect+"'"+","+"'"+lastNameProspect+"'"+","+"'"+titleProspect+"'"+","+"'"+adress1Prospect+"'"+","+"'"+adress2Prospect+"'"
                        +","+stateProspect+"," +cityProspect+","+zipcodeProspect+","+"'"+emailProspect+"'"+","+"'"+phoneProspect+"'"+","+"'"+industryProspect+"'"+","+"'"+approxRsfProspect+"'"+","
                        +"'"+ocupancyDateProspect+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaCrearProposal(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscasosfallidoscrearproposal (`building`,`prospect`,`program`,`fechaDePrueba`) " +
                        "VALUES("+building+","+prospect+","+program+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaCrearAutoProgram(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscasosfallidoscrearautoprogram (`nameRoomAutoProgram`,`industry`,`quantity`,`fechaDePrueba`) " +
                        "VALUES("+"'"+nameRoomAutoProgram+"'"+","+"'"+industryAutoProgram+"'"+","+"'"+quantityAutoProgram+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaCartelDeCrearAutoProgram() {
        if ((page.isVisible(assertions1)) == false) {
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscasosfallidoscrearautoprogram (`nameRoomAutoProgram`,`industry`,`quantity`,`fechaDePrueba`) " +
                        "VALUES(" + "'" + nameRoomAutoProgram + "'" + "," + "'" + industryAutoProgram + "'" + "," + "'" + quantityAutoProgram + "'" + "," + "NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            } catch (Exception e) {
                e.printStackTrace();
            }
            sqlclose();
        }
    }
}


