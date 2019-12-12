package roomschedulerrrk5140;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Rian Khan
 */
public class WaitlistQueries {
    private static Connection connection;
    private static PreparedStatement addWaitlist;
    private static ResultSet resultSetWaitlist;
    private static PreparedStatement getWaitlist;
    private static ResultSet resultSet;
    
    public static void addWaitlist(Object faculty, Object date, int seats){
    connection = DBConnection.getConnection();
    try{
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        addWaitlist = connection.prepareStatement("insert into waitlist (faculty, date, seats, timestamp) values (?,?,?,?)");
        addWaitlist.setString(1, faculty.toString());
        addWaitlist.setString(2, date.toString());
        addWaitlist.setInt(3, seats);
        addWaitlist.setTimestamp(4, currentTimestamp);
        addWaitlist.executeUpdate();
    }
    catch(SQLException sqlException){
        sqlException.printStackTrace();
    }
    }
    
    public static ArrayList<String> getWaitlist(){
        connection = DBConnection.getConnection();
        ArrayList<String> waitlist = new ArrayList<String>();
        try{
            getWaitlist = connection.prepareStatement("select * from waitlist order by timestamp");
            resultSet = getWaitlist.executeQuery();
            
            while(resultSet.next()){
                waitlist.add(resultSet.getString(1)  + " " + resultSet.getString(2) + " " + resultSet.getString(3));
                
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return waitlist;
         
    } 
}
