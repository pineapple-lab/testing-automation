package insumosPeppermint;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class variablesIniciadasPeppermint extends variablesPeppermint{

    public void iniciarEjecucionesLogin(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoslogin WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesLogin(){

        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoslogin WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
                emailLogin =rs.getString(rs.findColumn("userName"));
                passwordLogin = rs.getString(rs.findColumn("userPassword"));
            }
            String query1 = "UPDATE testbdpeppermint.datoslogin SET estado = 1 WHERE userName="+"'"+emailLogin+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoslogin SET estado = 0 WHERE userName!="+"'"+emailLogin+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionTechnique(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartechnique WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearTechnique(){
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartechnique"); /*WHERE estado = 0 ORDER BY RAND() LIMIT 1");*/
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
            /*String query1 = "UPDATE testbdspacelogik.datoseditarroomoptions SET estado = 1 WHERE sequenceRoomOptions="+"'"+sequenceRoomOptionsProgram+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoseditarroomoptions SET estado = 0 WHERE sequenceRoomOptions!="+"'"+sequenceRoomOptionsProgram+"'";
            stm.executeUpdate(query2);*/
            sqlclose();
        }catch(Exception e){}
    }
    public void iniciarEjecucionSegments(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearsegment WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearSegments(){
        System.out.println("Iniciando variables...");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearlesson WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearLesson(){
        System.out.println("Iniciando variables...");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearWorkshopCompleto WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearWorkshop(){
        System.out.println("Iniciando variables article...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearWorkshopCompleto WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                pathImage =rs.getString(rs.findColumn("pathImage"));
                pathVideo =rs.getString(rs.findColumn("pathVideo"));
                titleWorkshop = rs.getString(rs.findColumn("titleWorkshop"));
                descriptionWorkshop = rs.getString(rs.findColumn("descriptionWorkshop"));
                creatorWorkshop = rs.getString(rs.findColumn("creatorWorkshop"));
                tagWorkshop = rs.getString(rs.findColumn("tagWorkshop"));
                categoryWorkshop = rs.getString(rs.findColumn("categoryWorkshop"));
                topicWorkshop = rs.getString(rs.findColumn("topicWorkshop"));
                subTopicWorkshop = rs.getString(rs.findColumn("subTopicWorkshop"));
                targetAudienceWorkshop =rs.getString(rs.findColumn("targetAudienceWorkshop"));
                learningObjectiveWorkshop =rs.getString(rs.findColumn("learningObjectivesWorkshop"));
                whatDoYouNeed = rs.getString(rs.findColumn("whatDoYouNeed"));
                purposeWorkshop = rs.getString(rs.findColumn("purposeWorkshop"));
                skillsWorkshop = rs.getString(rs.findColumn("skillsWorkshop"));
                physicalActvityWorkshop = rs.getString(rs.findColumn("pysicalActivityWorkshop"));
                questionWorkshop = rs.getString(rs.findColumn("questionWorkshop"));
                answerWorkshop = rs.getString(rs.findColumn("answerWorkshop"));
                reviewerWorkshop = rs.getString(rs.findColumn("reviewerWorkshop"));
                reviewWorkshop = rs.getString(rs.findColumn("reviewWorkshop"));
                studentWorkshop = rs.getString(rs.findColumn("studentWorkshop"));
                descriptionProjectWorkshop = rs.getString(rs.findColumn("descritpionProjectWorkshop"));
                addLinksWorkshop = rs.getString(rs.findColumn("addLinksWorkshop"));
                titleZoomWorkshop = rs.getString(rs.findColumn("titleZoomWorkshop"));
                deadlineWorkshop = rs.getString(rs.findColumn("deadlineWorkshop"));
                descriptionZoomWorkshop = rs.getString(rs.findColumn("descriptionZoomWorkshop"));
                zoomUrlWorkshop =rs.getString(rs.findColumn("zoomUrlWorkshop"));
                activitiesTitleWorkshop =rs.getString(rs.findColumn("activitiesTItleWorkshop"));
                activitiesDescriptionWorkshop = rs.getString(rs.findColumn("activitieDescriptionWorkshop"));
                syncUpTitleWorkshop = rs.getString(rs.findColumn("syncUpTitleWorkshop"));
                syncUpDescriptionWorkshop = rs.getString(rs.findColumn("syncUpDescriptionWorkshop"));
                instructorSoloWithInstructor = rs.getString(rs.findColumn("instructorSoloWithInstructor"));
                instructorGroupWithInstructor = rs.getString(rs.findColumn("instructorGroupWithInstructor"));
                maxStudentsGroupWithInstructor = rs.getString(rs.findColumn("maxStudentsGroupWithInstructor"));
                optimaBuddyGroupGroupWithInstructor = rs.getString(rs.findColumn("optimaBuddyGroupGroupWithInstructor"));
                maxStudentsGroup = rs.getString(rs.findColumn("maxStudentsGroup"));
                optimalBuddyGroup = rs.getString(rs.findColumn("optimalBuddyGroupGroup"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscrearWorkshopCompleto SET estado = 1 WHERE titleWorkshop="+"'"+titleWorkshop+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscrearWorkshopCompleto SET estado = 0 WHERE titleWorkshop!="+"'"+titleWorkshop+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarEjecucionArticle(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearArticle WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearArticle(){
        System.out.println("Iniciando variables article...");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclubevent WHERE estado = 0 ORDER BY RAND() LIMIT 1");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclubevent");
            System.out.println(rs);
            while (rs.next()) {
                titleEvent = rs.getString(rs.findColumn("titleEvent"));
                urlZoomEvent = rs.getString(rs.findColumn("ZoomUrlEvent"));
                descriptionEvent=rs.getString(rs.findColumn("descriptionEvent"));
                clubEvent=rs.getString(rs.findColumn("clubEvent"));
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartaxonomy WHERE estado = 0 ORDER BY RAND() LIMIT 1");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartaxonomy");
            while (rs.next()) {
                titleCategory = rs.getString(rs.findColumn("titleCategory"));
                titleTopic = rs.getString(rs.findColumn("titleTopic"));
                titleSubTopic = rs.getString(rs.findColumn("titleSubTopic"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscreartaxonomy SET estado = 1 WHERE titleCategory="+"'"+titleCategory+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscreartaxonomy SET estado = 0 WHERE titleCategory!="+"'"+titleCategory+"'";
            stm.executeUpdate(query2);
        }catch (Exception e) {}
        sqlclose();
    }
    public void iniciarEjecucionTag(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartag WHERE estado = 0 ORDER BY RAND() LIMIT 1");
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
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscreartag");
            while (rs.next()) {
                titleTag = rs.getString(rs.findColumn("titleTag"));
            }
            String query1 = "UPDATE testbdpeppermint.datoscreartag SET estado = 1 WHERE titleTag="+"'"+titleTag+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdpeppermint.datoscreartag SET estado = 0 WHERE titleTag!="+"'"+titleTag+"'";
            stm.executeUpdate(query2);
        }catch (Exception e) {}
        sqlclose();
    }
    public void iniciarEjecucionClub(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclub WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCrearClub(){
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclub WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar = rs.getInt(rs.findColumn("ejecuciones"));
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
}