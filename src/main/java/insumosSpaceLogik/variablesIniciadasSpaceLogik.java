package insumosSpaceLogik;

import insumosSpaceLogik.variablesSpaceLogik;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class variablesIniciadasSpaceLogik extends conexionsql {
    public void iniciarVariablesPropposalValoresPequeños(){
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationpequeño WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationmediano WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationgrande WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearpaymentcancelationmuygrande WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
                System.out.println("Iniciando variables...");
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
                building = rs.getString(rs.findColumn("building"));
                prospect = rs.getString(rs.findColumn("prospect"));
                program = rs.getString(rs.findColumn("program"));
            }
            String query1 = "UPDATE testbdspacelogik.datoscrearproposal SET estado = 1 WHERE program="+"'"+program+"'";
            stm.executeUpdate(query1);
            String query2 = "UPDATE testbdspacelogik.datoscrearproposal SET estado = 0 WHERE program!="+"'"+program+"'";//
            stm.executeUpdate(query2);
        }catch(Exception e){}
        sqlclose();
    }
    public void iniciarVariablesProspectFeliz(){
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearprospect WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearcompetitiveset WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmanualmentebroker WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditargeneralinfoprospect WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarroomoptions WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearautoprogram WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscrearlaunch WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoscreartweak WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmydealleasetypelocation WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarmydealofficesize WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
               rsfMyDealOfficeSize = rs.getString(rs.findColumn("rsfOficeSize"));
           }
           String query1 = "UPDATE testbdspacelogik.datoseditarmydealofficesize SET estado = 1 WHERE rsfOficeSize="+"'"+rsfMyDealOfficeSize+"'";
           stm.executeUpdate(query1);
           String query2 = "UPDATE testbdspacelogik.datoseditarmydealofficesize SET estado = 0 WHERE rsfOficeSize!="+"'"+rsfMyDealOfficeSize+"'";
           stm.executeUpdate(query2);
       }catch(Exception e){}
       sqlclose();
   }
   public void iniciarVariablesEditarListingLocationInformation(){
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarlistinglocationinformation WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarbuildingcontacts WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarbuildingrsf WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
       System.out.println("Iniciando variables...");
       try {
           sqlconectar();
           Statement stm = CN.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarsinglesuite WHERE estado = 0 ORDER BY RAND() LIMIT 1");
           while(rs.next()){
               ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
        System.out.println("Iniciando variables...");
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdspacelogik.datoseditarexpensespassedthrough WHERE estado = 0 ORDER BY RAND() LIMIT 1");
            while(rs.next()){
                ejecutar =rs.getInt(rs.findColumn("ejecutar"));
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
