package roomscheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class ReservationQueries {
    private static Connection connection;
    private static PreparedStatement addReservation;
    private static PreparedStatement getRoomListByDate;
    private static PreparedStatement getReservationListByDate;
    private static ResultSet resultSet;
    
    
    public static void addReservation(Object faculty, Object date, int seats, String room){
        connection = DBConnection.getConnection();
        try
        {
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
           
            addReservation = connection.prepareStatement("insert into reservations (faculty,room,date,seats,timestamp) values (?, ?, ?, ?, ?)");
            addReservation.setString(1, faculty.toString());
            addReservation.setString(2, room);
            addReservation.setString(3, date.toString());
            addReservation.setInt(4, seats);
            addReservation.setTimestamp(5, currentTimestamp);
            addReservation.executeUpdate();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<String> getRoomsReservedByDate(Object date){
        connection = DBConnection.getConnection();
        ArrayList<String> reservedRooms = new ArrayList<String>();
        try{
            getRoomListByDate = connection.prepareStatement("select room from reservations where date = (?)");
            getRoomListByDate.setString(1, date.toString());
            resultSet = getRoomListByDate.executeQuery();
            
            while(resultSet.next()){
                reservedRooms.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return reservedRooms;
    }
    public static ArrayList<String> getReservationsByDate(Object date){
        connection = DBConnection.getConnection();
        ArrayList<String> roomReservations = new ArrayList<String>();
        try{
            getReservationListByDate = connection.prepareStatement("select * from reservations where date = (?)");
            getReservationListByDate.setString(1, date.toString());
            resultSet = getReservationListByDate.executeQuery();
            
            while(resultSet.next()){
                roomReservations.add(resultSet.getString(1) + " reserved " + resultSet.getString(2));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return roomReservations;
    }
    
}