package insumosPeppermint;
import java.sql.Statement;
public class queriesSQLcasesFailed extends contextBasePeppermint{
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
                String query = "INSERT INTO datoscrearclubcasosfallidos (`imagePath`,`titleClub`,`descriptionClub`,`fechaDePrueba`) " +
                        "VALUES('"+imagePath+"','"+titleClub+"','"+descriptionClub+"',NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaCrearLesson(){

        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscrearlessoncasosfallidos (`imagePath`,`titleLesson`,`descriptionLesson`,`creatorLesson`,`tagLesson`,`categoryLesson`,`topicLesson`,`subTopicLesson`,`fechaDePrueba`) " +
                        "VALUES('"+imagePath+"','"+titleLesson+"','"+descriptionLesson+"','"+creatorLesson+"','"+tagLesson+"','"+categoryLesson+"','"+topicLesson+"','"+subtopicLesson+"',NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
}
