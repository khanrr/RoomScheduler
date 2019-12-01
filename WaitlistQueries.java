package roomschedulerrrk5140;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
/**
 *
 * @author Rian Khan
 */
public class WaitlistQueries {
    private static Connection connection;
    private static PreparedStatement addWaitlist;
    private static ResultSet resultSetWaitlist;
    
    public static void addWaitlist(String name, String date, Integer seats){
    connection = DBConnection.getConnection();
    try{
        addWaitlist = connection.prepareStatement("insert into waitlist (faculty, date, seats, timestamp) values ('"+name+"', '"+date+"', '"+seats+"', current_timestamp)");
        addWaitlist.executeUpdate();
    }
    catch(SQLException sqlException){
        sqlException.printStackTrace();
    }
    }
    
    public static String getWaitlist(){
        String x = null;
        return x; 
    } 
}
    