package insumosPeppermint;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class variablesIniciadasPeppermint extends variablesPeppermint{

    public void iniciarVariablesEvent() {
        String formattedDate;
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        formattedDate = dtf.format(dateObj);
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
                weekEventClub = rs.getString(rs.findColumn("weekEventClub"));
                dayEventClub = rs.getString(rs.findColumn("dayEventClub"));
                startTimeEventClub = rs.getString(rs.findColumn("startTimeEventClub"));
                endTimeEventClub = rs.getString(rs.findColumn("endTimeEventClub"));
                fechaGuardada = rs.getString(rs.findColumn("fechaGuardada"));
            }
            LocalDate dateFechaGuardada = LocalDate.parse(fechaGuardada);
            LocalDate dateFormattedDate = LocalDate.parse(formattedDate);
            if (dateFechaGuardada.isBefore(dateFormattedDate)) {
                System.out.println("Actualizando fecha...");
                int intDayEventClub = Integer.parseInt(dayEventClub);
                intDayEventClub++;
                String dayEventClub = String.valueOf(intDayEventClub);
                try {
                    System.out.println("entre al segundo try");
                    Statement st = CN.createStatement();
                    String query = "UPDATE datoscrearclubevent SET dayEventClub="+"'"+dayEventClub+"'"+",fechaGuardada="+"'"+formattedDate+"'"+"";
                    st.executeUpdate(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                sqlconectar();
                Statement stm1 = CN.createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT * FROM testbdpeppermint.datoscrearclubevent");
                while (rs1.next()) {
                    dayEventClub = rs1.getString(rs.findColumn("dayEventClub"));
                    System.out.println("Fecha actualizada...");
                }
            }catch (Exception e) {}
        }catch (Exception e) {}
        sqlclose();
    }
}
