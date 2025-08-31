package roomscheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationEntry {
    private static Connection connection;
    private static ArrayList<String> reservations = new ArrayList<String>();
    private static PreparedStatement addReservation;
    private static PreparedStatement getReservationList;
    private static ResultSet resultSet;
    
    public static void addReservation(Object faculty, Object date, int seats)
    {
        connection = DBConnection.getConnection();
        try
        {
            if(seats <= 20){
                ArrayList<String> getDates = (ArrayList<String>) connection.prepareStatement("select date, seats from reservations");
                if(getDates.contains(date) && getDates.contains(seats)){
                //send to WaitlistEntry
                }
                int room = 201;
            }
            else if(seats > 20 && seats <= 40){
                ArrayList<Object> getDates = (ArrayList<Object>) connection.prepareStatement("select date from reservations");
                ArrayList<Object> getSeats = (ArrayList<Object>) connection.prepareStatement("select seats from reservations");
                if(getDates.contains(date) && getSeats.contains(seats)){
                    
                }
                int room = 102;
            }
            else{
                ArrayList<String> getDates = (ArrayList<String>) connection.prepareStatement("select date, seats from reservations");
                if(getDates.contains(date) && getDates.contains(seats)){
                    
                }
                int room = 101;                
            }
            reservations = (ArrayList<String>) connection.prepareStatement("insert into reservations (faculty,room,date,seats,timestamp) values ('"+faculty+"', room, '"+date+"', '"+seats+"', current_timestamp)");
            addReservation.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getReservationList()
    {
        connection = DBConnection.getConnection();
        ArrayList<String> reservations = new ArrayList<String>();
        try
        {
            getReservationList = connection.prepareStatement("select (faculty,room,date,seats,timestamp) from reservations");
            resultSet = getReservationList.executeQuery();
            
            while(resultSet.next())
            {
                reservations.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return reservations;
        
    }
    
    
}