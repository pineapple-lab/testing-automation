package insumosSpaceLogik;

import insumosSpaceLogik.variablesSpaceLogik;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class variablesIniciadasSpaceLogik extends conexionsql {
    public void iniciarVariablesPropposalValoresPequeños(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationpequeño WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                term = rs.getString(rs.findColumn("term"));
                startingRate = rs.getString(rs.findColumn("startingRate"));
                annualIncreases = rs.getString(rs.findColumn("annualIncreases"));
                rentAbatement = rs.getString(rs.findColumn("rentAbatement"));
                construction = rs.getString(rs.findColumn("construction"));
                baseBuilding = rs.getString(rs.findColumn("baseBuilding"));
                month = rs.getString(rs.findColumn("monthPaymentCancelation"));
                cost = rs.getString(rs.findColumn("cost"));
                interestRate = rs.getString(rs.findColumn("interestRate"));
                assertionPenaltyAmount = rs.getString(rs.findColumn("assertionsPenaltyAmount"));
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationpequeño SET estado = 1 WHERE startingRate="+"'"+term+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationpequeño SET estado = 0 WHERE startingRate!="+"'"+term+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesPropposalValoresMedianos(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationmediano WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                term = rs.getString(rs.findColumn("term"));
                startingRate = rs.getString(rs.findColumn("startingRate"));
                annualIncreases = rs.getString(rs.findColumn("annualIncreases"));
                rentAbatement = rs.getString(rs.findColumn("rentAbatement"));
                construction = rs.getString(rs.findColumn("construction"));
                baseBuilding = rs.getString(rs.findColumn("baseBuilding"));
                month = rs.getString(rs.findColumn("monthPaymentCancelation"));
                cost = rs.getString(rs.findColumn("cost"));
                interestRate = rs.getString(rs.findColumn("interestRate"));
                assertionPenaltyAmount = rs.getString(rs.findColumn("assertionsPenaltyAmount"));
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationmediano SET estado = 1 WHERE startingRate="+"'"+term+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationmediano SET estado = 0 WHERE startingRate!="+"'"+term+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesPropposalValoresGrandes(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationgrande WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                term = rs.getString(rs.findColumn("term"));
                startingRate = rs.getString(rs.findColumn("startingRate"));
                annualIncreases = rs.getString(rs.findColumn("annualIncreases"));
                rentAbatement = rs.getString(rs.findColumn("rentAbatement"));
                construction = rs.getString(rs.findColumn("construction"));
                baseBuilding = rs.getString(rs.findColumn("baseBuilding"));
                month = rs.getString(rs.findColumn("monthPaymentCancelation"));
                cost = rs.getString(rs.findColumn("cost"));
                interestRate = rs.getString(rs.findColumn("interestRate"));
                assertionPenaltyAmount = rs.getString(rs.findColumn("assertionsPenaltyAmount"));
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationgrande SET estado = 1 WHERE startingRate="+"'"+term+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationgrande SET estado = 0 WHERE startingRate!="+"'"+term+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesPropposalValoresMuyGrandes(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationmuygrande WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                term = rs.getString(rs.findColumn("term"));
                startingRate = rs.getString(rs.findColumn("startingRate"));
                annualIncreases = rs.getString(rs.findColumn("annualIncreases"));
                rentAbatement = rs.getString(rs.findColumn("rentAbatement"));
                construction = rs.getString(rs.findColumn("construction"));
                baseBuilding = rs.getString(rs.findColumn("baseBuilding"));
                month = rs.getString(rs.findColumn("monthPaymentCancelation"));
                cost = rs.getString(rs.findColumn("cost"));
                interestRate = rs.getString(rs.findColumn("interestRate"));
                assertionPenaltyAmount = rs.getString(rs.findColumn("assertionsPenaltyAmount"));
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationmuygrande SET estado = 1 WHERE startingRate="+"'"+term+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearpaymentcancelationmuygrande SET estado = 0 WHERE startingRate!="+"'"+term+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesCreacionProposal(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearproposal WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearproposal SET estado = 1 WHERE building="+"'"+building+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearproposal SET estado = 0 WHERE building!="+"'"+program+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesProspectFeliz(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearprospect WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                salutationProspect = rs.getString(rs.findColumn("salutation"));
                firstNameProspect = rs.getString(rs.findColumn("firstName"));
                lastNameProspect = rs.getString(rs.findColumn("lastName"));
                titleProspect = rs.getString(rs.findColumn("titleProspect"));
                adress1Prospect = rs.getString(rs.findColumn("adress1"));
                adress2Prospect = rs.getString(rs.findColumn("adress2"));
                stateProspect = rs.getString(rs.findColumn("state"));
                cityProspect = rs.getString(rs.findColumn("city"));
                zipcodeProspect = rs.getString(rs.findColumn("zipCode"));
                emailProspect = rs.getString(rs.findColumn("email"));
                phoneProspect = rs.getString(rs.findColumn("phone"));
                industryProspect = rs.getString(rs.findColumn("industry"));
                approxRsfProspect = rs.getString(rs.findColumn("approxRsf"));
                ocupancyDateProspect = rs.getString(rs.findColumn("ocupancyDate"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearprospect SET estado = 1 WHERE state="+"'"+stateProspect+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearprospect SET estado = 0 WHERE state!="+"'"+stateProspect+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesRegistroFeliz(){

        lastNameRegistro = "pruebAutomatizada13";
        companyRegistro = "pruebaAutomatizada13";
        titleRegistro = "pruebAutomatizada13";
        mailRegistro = "pruebAutomatizada13@gmail.com";
        passwordRegistro = "pruebAutomatizada13*";
        verifyPasswordRegistro = "pruebAutomatizada13*";
   }
   public void iniciarVariablesCompetitiveSetFeliz(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearcompetitiveset WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               buildingCompetitiveSetProspect = rs.getString(rs.findColumn("building"));
           }
           String query1 = "UPDATE testbdspacelogik.datoscrearcompetitiveset SET estado = 1 WHERE building="+"'"+buildingCompetitiveSetProspect+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoscrearcompetitiveset SET estado = 0 WHERE building!="+"'"+buildingCompetitiveSetProspect+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesTrackingFeliz(){
        commentsTrackingProspect = "pruebAutomatizada";
   }
   public void iniciarVariablesEditManualBrokerFeliz(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmanualmentebroker WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               salutationEditBrokerManual = rs.getString(rs.findColumn("salutation"));
               lastNameEditBrokerManual = rs.getString(rs.findColumn("lastName"));
               address1EditBrokerManual = rs.getString(rs.findColumn("adress1"));
               address2EditBrokerManual = rs.getString(rs.findColumn("adress2"));
               titleEditBrokerManual = rs.getString(rs.findColumn("title"));
               stateEditBrokerManual = rs.getString(rs.findColumn("state"));
               cityEditBrokerManual = rs.getString(rs.findColumn("city"));
               zipcodeEditBrokerManual = rs.getString(rs.findColumn("zipCode"));
               emailEditBrokerManual = rs.getString(rs.findColumn("email"));
               phoneEditBrokerManual = rs.getString(rs.findColumn("phone"));
               mobileEditBrokerManual = rs.getString(rs.findColumn("mobile"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarmanualmentebroker SET estado = 1 WHERE state="+"'"+stateEditBrokerManual+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarmanualmentebroker SET estado = 0 WHERE state!="+"'"+stateEditBrokerManual+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditGeneralInfoProspect(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditargeneralinfoprospect WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                salutationEditProspectGeneralInfo = rs.getString(rs.findColumn("salutation"));
                firstNameEditProspectGeneralInfo = rs.getString(rs.findColumn("firstName"));
                lastNameEditProspectGeneralInfo = rs.getString(rs.findColumn("lastName"));
                titleEditProspectGeneralInfo = rs.getString(rs.findColumn("title"));
                address1EditProspectGeneralInfo = rs.getString(rs.findColumn("adress1"));
                address2EditProspectGeneralInfo = rs.getString(rs.findColumn("adress2"));
                stateEditProspectGeneralInfo = rs.getString(rs.findColumn("state"));
                cityEditProspectGeneralInfo = rs.getString(rs.findColumn("city"));
                zipcodeEditProspectGeneralInfo = rs.getString(rs.findColumn("zipCode"));
                emailEditProspectGeneralInfo = rs.getString(rs.findColumn("email"));
                industryEditProspectGeneralInfo = rs.getString(rs.findColumn("industry"));
                approxRsfEditProspectGeneralInfo = rs.getString(rs.findColumn("approxRSF"));
                phoneEditProspectGeneralInfo = rs.getString(rs.findColumn("phone"));
                mobileEditGProspecteneralInfo = rs.getString(rs.findColumn("mobile"));
            }
            String query1 = "UPDATE testbdspacelogik.datoseditargeneralinfoprospect SET estado = 1 WHERE state="+"'"+stateEditProspectGeneralInfo+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoseditargeneralinfoprospect SET estado = 0 WHERE state!="+"'"+stateEditProspectGeneralInfo+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
   public void iniciarVariablesEditRoom(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarroomoptions WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                sequenceRoomOptionsProgram = rs.getString(rs.findColumn("sequenceRoomOptions"));
                employeAreaTypesProgram = rs.getString(rs.findColumn("employeAreaTypes"));
                roomSizeProgram = rs.getString(rs.findColumn("roomSize"));
                quantityRoomOptionsProgram = rs.getString(rs.findColumn("quantity"));
            }
            String query1 = "UPDATE testbdspacelogik.datoseditarroomoptions SET estado = 1 WHERE sequenceRoomOptions="+"'"+sequenceRoomOptionsProgram+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoseditarroomoptions SET estado = 0 WHERE sequenceRoomOptions!="+"'"+sequenceRoomOptionsProgram+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
   }
   public void iniciarVariablesAutoProgramFeliz(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearautoprogram WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                nameRoomAutoProgram = rs.getString(rs.findColumn("nameRoomAutoProgram"));
                industryAutoProgram = rs.getString(rs.findColumn("industry"));
                quantityAutoProgram = rs.getString(rs.findColumn("quantity"));
            }
            String query1 = "UPDATE testbdspacelogik.datosCrearAutoProgram SET estado = 1 WHERE industry="+"'"+industryAutoProgram+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datosCrearAutoProgram SET estado = 0 WHERE industry!="+"'"+industryAutoProgram+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
   }
   public void iniciarVariablesLaunchFeliz(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearlaunch WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                legalFormationLaunch = rs.getString(rs.findColumn("legalFormationLaunch"));
                bussinesSinceLaunch = rs.getString(rs.findColumn("bussinesSinceLaunch"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearlaunch SET estado = 1 WHERE legalFormationLaunch="+"'"+legalFormationLaunch+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearlaunch SET estado = 0 WHERE legalFormationLaunch!="+"'"+legalFormationLaunch+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
   }
   public void iniciarVariablesTweakFeliz(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscreartweak WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               sizeTweak = rs.getString(rs.findColumn("size"));
               qtyTweak = rs.getString(rs.findColumn("quantity"));
           }
           String query1 = "UPDATE testbdspacelogik.datoscreartweak SET estado = 1 WHERE size="+"'"+sizeTweak+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoscreartweak SET estado = 0 WHERE size!="+"'"+sizeTweak+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditMyDealLeaseTypeLocation(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmydealleasetypelocation WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ubicacionMyDealLeaseTypeLocation = rs.getString(rs.findColumn("ubication"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarmydealleasetypelocation SET estado = 1 WHERE ubication="+"'"+ubicacionMyDealLeaseTypeLocation+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarmydealleasetypelocation SET estado = 0 WHERE ubication!="+"'"+ubicacionMyDealLeaseTypeLocation+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditMyDealOfficeSize(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmydealofficesize WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               rsfMyDealOfficeSize = rs.getString(rs.findColumn("rsfOficeSize"));
               specificHeadCountMyDealOfficeSize = rs.getString(rs.findColumn("specificHeadCounty"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarmydealofficesize SET estado = 1 WHERE rsfOficeSize="+"'"+rsfMyDealOfficeSize+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarmydealofficesize SET estado = 0 WHERE rsfOficeSize!="+"'"+specificHeadCountMyDealOfficeSize+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditarListingLocationInformation(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarlistinglocationinformation WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               yearBuiltListingLocationInformation = rs.getString(rs.findColumn("yearBuilt"));
               totalBuildingRsfListingLocationInformation = rs.getString(rs.findColumn("totalBuildingRsf"));
               numberOfStoriesListingLocationInformation = rs.getString(rs.findColumn("numberOfStories"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarlistinglocationinformation SET estado = 1 WHERE yearBuilt="+"'"+yearBuiltListingLocationInformation+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarlistinglocationinformation SET estado = 0 WHERE yearBuilt!="+"'"+yearBuiltListingLocationInformation+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditarBuildingDescrption(){descriptionBuildingListing = "pruebAutomatizada";}
   public void iniciarVariablesEditarBuildingContacts(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarbuildingcontacts WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               saludoListingPrimaryLeasingContact = rs.getString(rs.findColumn("salutation"));
               lastNameListingPrimaryLeasingContcts = rs.getString(rs.findColumn("lastName"));
               companyListingPrimaryLeasingContacts = rs.getString(rs.findColumn("company"));
               address1ListingPrimaryLeasingContacts = rs.getString(rs.findColumn("address1"));
               address2ListingPrimaryLeasingContacts = rs.getString(rs.findColumn("address2"));
               stateListingPrimaryLeasingContacts = rs.getString(rs.findColumn("state"));
               cityListingPrimaryLeasingContacts = rs.getString(rs.findColumn("city"));
               zipCodeListingPrimaryLeasingContacts = rs.getString(rs.findColumn("zipCode"));
               phoneListingPrimaryLeasingContacts = rs.getString(rs.findColumn("phone"));
               emailListingPrimaryLeasingContacts = rs.getString(rs.findColumn("email"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarbuildingcontacts SET estado = 1 WHERE state="+"'"+stateListingPrimaryLeasingContacts+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarbuildingcontacts SET estado = 0 WHERE state!="+"'"+stateListingPrimaryLeasingContacts+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditarBuildingRsf(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarbuildingrsf WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               rsfFloorListingSpaceBuilding = rs.getString(rs.findColumn("rsfFloor"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarbuildingrsf SET estado = 1 WHERE rsfFloor="+"'"+rsfFloorListingSpaceBuilding+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarbuildingrsf SET estado = 0 WHERE rsfFloor!="+"'"+rsfFloorListingSpaceBuilding+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
    }
   public void iniciarVariablesEditarSingleSuite(){
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarsinglesuite WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               dateAvailableListingSingleSuite = rs.getString(rs.findColumn("dateAvailable"));
               dateAvailableEndListingSingleSuite = rs.getString(rs.findColumn("dateAvailableEnd"));
               divisibleToListingSingleSuite = rs.getString(rs.findColumn("divisibleTo"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarsinglesuite SET estado = 1 WHERE dateAvailable="+"'"+dateAvailableListingSingleSuite+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarsinglesuite SET estado = 0 WHERE dateAvailable!="+"'"+dateAvailableListingSingleSuite+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
    public void iniciarVariablesEditarExpensesPassedThrough(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarexpensespassedthrough WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                taxesListingExpenses = rs.getString(rs.findColumn("taxes"));
                expensesListingExpenses = rs.getString(rs.findColumn("expenses"));
            }
            String query1 = "UPDATE testbdspacelogik.datoseditarexpensespassedthrough SET estado = 1 WHERE taxes="+"'"+taxesListingExpenses+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoseditarexpensespassedthrough SET estado = 0 WHERE taxes!="+"'"+taxesListingExpenses+"'";
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
   }
}
