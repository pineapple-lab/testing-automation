package insumosPeppermint;

import java.sql.Statement;

public class consultasSQLCasosFallidos extends contextoBasePeppermint{

    public void sqlGuardarCasoSiFallaLogin(){

        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoslogincasosfallidos (`userName`,`userPassword`,`fechaDePrueba`) " +
                        "VALUES('"+emailLogin+"','"+passwordLogin+"',"+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaCrearClub(){

        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscrearclubcasosfallidos (`pathImage`,`titleClub`,`descriptionClub`,`fechaDePrueba`) " +
                        "VALUES('"+pathImage+"','"+titleClub+"','"+descriptionClub+"',NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
}
