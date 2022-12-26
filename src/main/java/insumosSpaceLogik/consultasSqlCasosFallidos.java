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
                        +","+stateProspect+","+cityProspect+","+zipcodeProspect+","+"'"+emailProspect+"'"+","+"'"+phoneProspect+"'"+","+"'"+industryProspect+"'"+","+"'"+approxRsfProspect+"'"+","
                        +"'"+ocupancyDateProspect+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaEditarGeneralInfoProspect(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datosCasosFallidosEditarGeneralInfoProspect (`salutation`,`firstName`,`lastName`,`title`,`adress1`,`adress2`" +
                        ",`state`,`city`,`zipCode`,`email`,`industry`,`approxRSF`,`phone`,`mobile`,`fechaDePrueba`) " +
                        "VALUES("+"'"+salutationEditProspectGeneralInfo+"'"+","+"'"+firstNameEditProspectGeneralInfo+"'"+","+"'"+lastNameEditProspectGeneralInfo+"'"+","+"'"+titleEditProspectGeneralInfo+"'"+","+"'"+address1EditProspectGeneralInfo+"'"+","+
                        "'"+address2EditProspectGeneralInfo+"'"+","+stateEditProspectGeneralInfo+","+cityEditProspectGeneralInfo+","+zipcodeEditProspectGeneralInfo+","+"'"+emailEditProspectGeneralInfo+"'"+","+"'"+industryEditProspectGeneralInfo+"'"+","+
                        "'"+approxRsfEditProspectGeneralInfo+"'"+","+"'"+phoneEditProspectGeneralInfo+"'"+","+"'"+mobileEditGProspecteneralInfo+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaEditarBrokerManual(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datoscasosfallidoseditarmanualmentebroker (`salutation`,`firstName`,`lastName`,`title`,`adress1`,`adress2`" +
                        ",`state`,`city`,`zipCode`,`email`,`phone`,`mobile`,`fechaDePrueba`) " +
                        "VALUES("+"'"+salutationEditBrokerManual+"'"+","+"'"+firstNameEditBrokerManual+"'"+","+"'"+lastNameEditBrokerManual+"'"+","+"'"+titleEditBrokerManual+"'"+","+"'"+address1EditBrokerManual+"'"+","+
                        "'"+address2EditBrokerManual+"'"+","+stateEditBrokerManual+","+cityEditBrokerManual+","+zipcodeEditBrokerManual+","+"'"+emailEditBrokerManual+"'"+","+"'"+phoneEditBrokerManual+"'"+","+"'"+mobileEditBrokerManual+"'"+","+"NOW())";
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
    public void sqlGuardarCasoSiFallaEditarRoomProgram(){
        if( (page.isVisible(assertions))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO testbdspacelogik.datoscasosfallidoseditarroomoptions(`sequenceRoomOptions`,`employeAreaTypes`,`roomSize`,`quantity`,`fechaDePrueba`) " +
                        "VALUES("+"'"+sequenceRoomOptionsProgram+"'"+","+"'"+employeAreaTypesProgram+"'"+","+"'"+roomSizeProgram+"'"+","+"'"+quantityRoomOptionsProgram+"'"+","+"NOW())";
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
    public void sqlGuardarCasoSiFallaPaymentCancelationPequeño(){
        if( (page.isVisible(assertionPenaltyAmount))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datosCasosFallidosPaymentCancelationPequeño (`term`,`startingRate`,`annualIncreases`,`rentAbatement`,`construction`," +
                        "`baseBuilding`,`monthPaymentCancelation`,`cost`,`interestRate`,`dateOffered`,`penaltyAmount`,`building`,`prospect`,`program`,`fechaDePrueba`) " +
                        "VALUES("+"'"+term+"'"+","+"'"+startingRate+"'"+","+"'"+annualIncreases+"'"+","+"'"+rentAbatement+"'"+","+"'"+construction+"'"+","+"'"+baseBuilding+"'"+","+"'"
                        +month+"'"+","+"'"+cost+"'"+","+"'"+interestRate+"'"+","+"'"+dateOffered+"'"+","+"'"+assertionPenaltyAmount+"'"+","+"'"+building+"'"+","+"'"+prospect+"'"+","+"'"+program+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaPaymentCancelationMediano(){
        if( (page.isVisible(assertionPenaltyAmount))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datosCasosFallidosPaymentCancelationMediano (`term`,`startingRate`,`annualIncreases`,`rentAbatement`,`construction`," +
                        "`baseBuilding`,`monthPaymentCancelation`,`cost`,`interestRate`,`dateOffered`,`penaltyAmount`,`building`,`prospect`,`program`,`fechaDePrueba`) " +
                        "VALUES("+"'"+term+"'"+","+"'"+startingRate+"'"+","+"'"+annualIncreases+"'"+","+"'"+rentAbatement+"'"+","+"'"+construction+"'"+","+"'"+baseBuilding+"'"+","+"'"
                        +month+"'"+","+"'"+cost+"'"+","+"'"+interestRate+"'"+","+"'"+dateOffered+"'"+","+"'"+assertionPenaltyAmount+"'"+","+"'"+building+"'"+","+"'"+prospect+"'"+","+"'"+program+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaPaymentCancelationGrande(){
        if( (page.isVisible(assertionPenaltyAmount))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datosCasosFallidosPaymentCancelationGrande (`term`,`startingRate`,`annualIncreases`,`rentAbatement`,`construction`," +
                        "`baseBuilding`,`monthPaymentCancelation`,`cost`,`interestRate`,`dateOffered`,`penaltyAmount`,`building`,`prospect`,`program`,`fechaDePrueba`) " +
                        "VALUES("+"'"+term+"'"+","+"'"+startingRate+"'"+","+"'"+annualIncreases+"'"+","+"'"+rentAbatement+"'"+","+"'"+construction+"'"+","+"'"+baseBuilding+"'"+","+"'"
                        +month+"'"+","+"'"+cost+"'"+","+"'"+interestRate+"'"+","+"'"+dateOffered+"'"+","+"'"+assertionPenaltyAmount+"'"+","+"'"+building+"'"+","+"'"+prospect+"'"+","+"'"+program+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
    public void sqlGuardarCasoSiFallaPaymentCancelationMuyGrande(){
        if( (page.isVisible(assertionPenaltyAmount))==false){
            sqlconectar();
            try {
                Statement st = CN.createStatement();
                String query = "INSERT INTO datosCasosFallidosPaymentCancelationMuyGrande (`term`,`startingRate`,`annualIncreases`,`rentAbatement`,`construction`," +
                        "`baseBuilding`,`monthPaymentCancelation`,`cost`,`interestRate`,`dateOffered`,`penaltyAmount`,`building`,`prospect`,`program`,`fechaDePrueba`) " +
                        "VALUES("+"'"+term+"'"+","+"'"+startingRate+"'"+","+"'"+annualIncreases+"'"+","+"'"+rentAbatement+"'"+","+"'"+construction+"'"+","+"'"+baseBuilding+"'"+","+"'"
                        +month+"'"+","+"'"+cost+"'"+","+"'"+interestRate+"'"+","+"'"+dateOffered+"'"+","+"'"+assertionPenaltyAmount+"'"+","+"'"+building+"'"+","+"'"+prospect+"'"+","+"'"+program+"'"+","+"NOW())";
                st.executeUpdate(query);
                System.out.println("Los datos de la prueba fallida se guardaron correctamente");
            }catch (Exception e){e.printStackTrace();}
            sqlclose();
        }
    }
}


