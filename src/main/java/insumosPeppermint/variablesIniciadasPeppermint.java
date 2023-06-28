package insumosPeppermint;
import java.sql.ResultSet;
import java.sql.Statement;
public class variablesIniciadasPeppermint extends variablesPeppermint{
    public void iniciarEjecucionesLogin(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesLogin(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.usuariosautomaticos WHERE EnUso = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                emailLogin =rs.getString(rs.findColumn("emailRegistro"));
                passwordLogin = "123123aA";
            }
            String query1 = "UPDATE testbdpeppermint.usuariosautomaticos SET EnUso = 1 WHERE emailRegistro="+"'"+emailLogin+"'";
            stm.executeUpdate(query1);
            /*String query2 = "UPDATE testbdpeppermint.datoslogin SET estado = 0 WHERE userName!="+"'"+emailLogin+"'";
            stm.executeUpdate(query2);*/
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionTechnique(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearTechnique(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartechnique WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                pathVideo = rs.getString(rs.findColumn("pathVideo"));
                titleTechnique = rs.getString(rs.findColumn("titleTechnique"));
                descriptionTechnique = rs.getString(rs.findColumn("descriptionTechnique"));
                creatorTechnique = rs.getString(rs.findColumn("creatorTechnique"));
                tagTechnique = rs.getString(rs.findColumn("tagTechnique"));
                categoryTechnique = rs.getString(rs.findColumn("categoryTechnique"));
                topicTechnique = rs.getString(rs.findColumn("topicTechnique"));
                subTopicTechnique = rs.getString(rs.findColumn("subTopicTechnique"));

            }
            String query1 = "UPDATE testbdpeppermint.datoscreartechnique SET estado = 1 WHERE titleTechnique="+"'"+titleTechnique+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscreartechnique SET estado = 0 WHERE titleTechnique!="+"'"+titleTechnique+"'";
            stm.executeUpdate(query2);
            sqlclose();
        }catch(Exception e){}
    }
    public void iniciarEjecucionSegments(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearSegments(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearsegment WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                pathVideo =rs.getString(rs.findColumn("pathVideo"));
                titleSegments = rs.getString(rs.findColumn("titleSegments"));
                descriptionSegments = rs.getString(rs.findColumn("descriptionSegments"));
                creatorSegments = rs.getString(rs.findColumn("creatorSegments"));
                tagSegments = rs.getString(rs.findColumn("tagSegments"));
                transcriptSegments = rs.getString(rs.findColumn("transcriptSegments"));
                categorySegments = rs.getString(rs.findColumn("categorySegments"));
                topicSegments = rs.getString(rs.findColumn("topicSegments"));
                subTopicSegments = rs.getString(rs.findColumn("subtopicSegments"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearsegment SET estado = 1 WHERE titleSegments="+"'"+titleSegments+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearsegment SET estado = 0 WHERE titleSegments!="+"'"+titleSegments+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionLesson(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearLesson(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearlesson WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                titleLesson = rs.getString(rs.findColumn("titleLesson"));
                descriptionLesson = rs.getString(rs.findColumn("descriptionLesson"));
                creatorLesson = rs.getString(rs.findColumn("creatorLesson"));
                tagLesson = rs.getString(rs.findColumn("tagLesson"));
                categoryLesson = rs.getString(rs.findColumn("categoryLesson"));
                topicLesson = rs.getString(rs.findColumn("topicLesson"));
                subtopicLesson = rs.getString(rs.findColumn("subtopicLesson"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearlesson SET estado = 1 WHERE titleLesson="+"'"+titleLesson+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearlesson SET estado = 0 WHERE titleLesson!="+"'"+titleLesson+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionWorkshop(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearWorkshop(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearworkshopcompleto WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                if(configuracionavanzadaTitleWorkshop == true){

                }else {
                    titleWorkshop = rs.getString(rs.findColumn("titleWorkshop"));
                }
                if(configuracionAvanzadaOptimalGroupWithInstructor == true){

                }else {
                    optimalBuddyGroupGroupWithInstructor = rs.getString(rs.findColumn("optimaBuddyGroupGroupWithInstructor"));
                }
                if(configuracionAvanzadaMaxGroupWithInstructor == true){

                }else {
                    maxStudentsGroupWithInstructor = rs.getString(rs.findColumn("maxStudentsGroupWithInstructor"));
                }
                if(configuracionAvanzadaOptimalStudenGroup == true){

                }else {
                    optimalBuddyGroup = rs.getString(rs.findColumn("optimalBuddyGroupGroup"));
                }
                if(configuracionAvanzadaMaxStudenGroup == true){

                }else {
                    maxStudentsGroup = rs.getString(rs.findColumn("maxStudentsGroup"));
                }
                pathImage =rs.getString(rs.findColumn("pathImage"));
                pathVideo =rs.getString(rs.findColumn("pathVideo"));
                descriptionWorkshop = rs.getString(rs.findColumn("descriptionWorkshop"));
                creatorWorkshop = rs.getString(rs.findColumn("creatorWorkshop"));
                tagWorkshop = rs.getString(rs.findColumn("tagWorkshop"));
                categoryWorkshop = rs.getString(rs.findColumn("categoryWorkshop"));
                skillsWorkshop = rs.getString(rs.findColumn("skillsWorkshop"));
                topicWorkshop = rs.getString(rs.findColumn("topicWorkshop"));
                subTopicWorkshop = rs.getString(rs.findColumn("subTopicWorkshop"));
                targetAudienceWorkshop = rs.getString(rs.findColumn("targetAudienceWorkshop"));
                learningObjectiveWorkshop = rs.getString(rs.findColumn("learningObjectivesWorkshop"));
                whatDoYouNeed = rs.getString(rs.findColumn("whatDoYouNeed"));
                howItWorks = rs.getString(rs.findColumn("howItWorks"));
                purposeWorkshop = rs.getString(rs.findColumn("purposeWorkshop"));
                physicalActvityWorkshop = rs.getString(rs.findColumn("pysicalActivityWorkshop"));
                questionWorkshop = rs.getString(rs.findColumn("questionWorkshop"));
                answerWorkshop = rs.getString(rs.findColumn("answerWorkshop"));
                reviewerWorkshop = rs.getString(rs.findColumn("reviewerWorkshop"));
                reviewWorkshop = rs.getString(rs.findColumn("reviewWorkshop"));
                studentWorkshop = rs.getString(rs.findColumn("studentWorkshop"));
                descriptionProjectWorkshop = rs.getString(rs.findColumn("descriptionProjectWorkshop"));
                addLinksWorkshop = rs.getString(rs.findColumn("addLinksWorkshop"));
                titleZoomWorkshop = rs.getString(rs.findColumn("titleZoomWorkshop"));
                deadlineWorkshop = rs.getString(rs.findColumn("deadlineWorkshop"));
                descriptionZoomWorkshop = rs.getString(rs.findColumn("descriptionZoomWorkshop"));
                zoomUrlWorkshop = rs.getString(rs.findColumn("zoomUrlWorkshop"));
                activitiesTitleWorkshop = rs.getString(rs.findColumn("activitiesTItleWorkshop"));
                activitiesDescriptionWorkshop = rs.getString(rs.findColumn("activitieDescriptionWorkshop"));
                syncUpTitleWorkshop = rs.getString(rs.findColumn("syncUpTitleWorkshop"));
                syncUpDescriptionWorkshop = rs.getString(rs.findColumn("syncUpDescriptionWorkshop"));
                instructorSoloWithInstructor = rs.getString(rs.findColumn("instructorSoloWithInstructor"));
                instructorGroupWithInstructor = rs.getString(rs.findColumn("instructorGroupWithInstructor"));
            }
            ResultSet rs1 = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearworkshopcompleto WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs1.next()){
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearworkshopcompleto SET estado = 1 WHERE titleWorkshop="+"'"+titleWorkshop+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearworkshopcompleto SET estado = 0 WHERE titleWorkshop!="+"'"+titleWorkshop+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        System.out.println("Variables iniciadas");
        sqlclose();
    }
    public void establecerUsuariosEnEstadoCero(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.datoslogin SET estado = 0";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionArticle(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearArticle(){
        System.out.println("Iniciando variables article...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearArticle WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                pathVideo =rs.getString(rs.findColumn("pathVideo"));
                titleArticle = rs.getString(rs.findColumn("titleArticle"));
                descriptionArticle = rs.getString(rs.findColumn("descriptionArticle"));
                creatorArticle = rs.getString(rs.findColumn("creatorArticle"));
                tagArticle = rs.getString(rs.findColumn("tagArticle"));
                estimatedReadTime = rs.getString(rs.findColumn("estimatedReadTime"));
                categoryArticle = rs.getString(rs.findColumn("categoryArticle"));
                topicArticle = rs.getString(rs.findColumn("topicArticle"));
                subTopicArticle = rs.getString(rs.findColumn("subTopicArticle"));
                contentTitle = rs.getString(rs.findColumn("contentTitle"));
                textContent = rs.getString(rs.findColumn("textContent"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearArticle SET estado = 1 WHERE titleArticle="+"'"+titleArticle+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearArticle SET estado = 0 WHERE titleArticle!="+"'"+titleArticle+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionEvent(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesEvent() {
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclubevent WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            System.out.println(rs);
            while (rs.next()) {
                titleEvent = rs.getString(rs.findColumn("titleEvent"));
                urlZoomEvent = rs.getString(rs.findColumn("ZoomUrlEvent"));
                descriptionEvent=rs.getString(rs.findColumn("descriptionEvent"));
                clubEvent=rs.getString(rs.findColumn("clubsEvent"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearclubevent SET estado = 1 WHERE titleEvent="+"'"+titleEvent+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearclubevent SET estado = 0 WHERE titleEvent!="+"'"+titleEvent+"'";
            stm.executeUpdate(query2);
        }catch (Exception e) {}
        sqlclose();
    }
    public void iniciarEjecucionTaxonomy(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesTaxonomy() {
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartaxonomy WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while (rs.next()) {
                titleCategory = rs.getString(rs.findColumn("titleCategory"));
                titleTopic = rs.getString(rs.findColumn("titleTopic"));
                titleSubTopic = rs.getString(rs.findColumn("titleSubTopic"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscreartaxonomy SET estado = 1 WHERE titleCategory="+"'"+titleCategory+"'";
            stm.executeUpdate(query1);
            /*String query2 = "UPDATE testbdpeppermint.datoscreartaxonomy SET estado = 0 WHERE titleCategory!="+"'"+titleCategory+"'";
            stm.executeUpdate(query2);*/
        }catch (Exception e) {}
        sqlclose();
    }
    public void iniciarEjecucionTag(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesTag() {
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartag WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while (rs.next()) {
                idcontent =rs.getInt(rs.findColumn("id"));
                titleTag = rs.getString(rs.findColumn("titleTag"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscreartag SET estado = 1 WHERE id="+"'"+idcontent+"'";
            stm.executeUpdate(query1);
            /*String query2 = "UPDATE testbdpeppermint.datoscreartag SET estado = 0 WHERE titleTag!="+"'"+titleTag+"'";
            stm.executeUpdate(query2);*/
        }catch (Exception e) {}
        sqlclose();
    }
    public void iniciarEjecucionClub(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.configuracion");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearClub(){
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclub WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                titleClub = rs.getString(rs.findColumn("titleClub"));
                descriptionClub = rs.getString(rs.findColumn("descriptionClub"));
                creatorClub = rs.getString(rs.findColumn("creatorClub"));
                tagClub = rs.getString(rs.findColumn("tagClub"));
                categoryClub = rs.getString(rs.findColumn("categoryClub"));
                topicClub = rs.getString(rs.findColumn("topicClub"));
                subtopicClub = rs.getString(rs.findColumn("subtopicClub"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearclub SET estado = 1 WHERE titleClub="+"'"+titleClub+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearclub SET estado = 0 WHERE titleClub!="+"'"+titleClub+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVaraiblesJoinUserClub() {
        System.out.println("Iniciando variables...");
        printStream.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.usuariosautomaticos WHERE ¿JoinClub = 0 AND ambiente = 'http://localhost:4200/user/plans' ORDER BY RAND() LIMIT 1");
            while (rs.next()) {
                emailLogin = rs.getString(rs.findColumn("emailRegistro"));
            }
            String query1 = "UPDATE testbdpeppermint.usuariosautomaticos SET ¿JoinClub = 1 WHERE emailRegistro=" + "'" + emailLogin + "'";
            stm.executeUpdate(query1);
        } catch (Exception e) {}
        sqlclose();
    }
}