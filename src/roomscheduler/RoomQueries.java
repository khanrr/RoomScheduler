package roomscheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomQueries {
    private static Connection connection;
    private static PreparedStatement addRoom;
    private static PreparedStatement getRoomList;
    private static ArrayList<String> rooms = new ArrayList<String>();
    private static ResultSet resultSet;
    
    public static ArrayList<String> getRoomList(){
        connection = DBConnection.getConnection();
        try{
            getRoomList = connection.prepareStatement("select * from rooms");
            resultSet = getRoomList.executeQuery();
            
            while(resultSet.next())
            {
                rooms.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rooms;
    }
    public static void addRoom(String name, int seats)
    {
        connection = DBConnection.getConnection();
        try
        {
            addRoom = connection.prepareStatement("insert into rooms (name, seats) values (?)");
            addRoom.setString(1, name);
            addRoom.setInt(2, seats);
            addRoom.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<String> getRoomListBySeats(int seats){
        connection = DBConnection.getConnection();
        try{
            getRoomList = connection.prepareStatement("select name from rooms where seats >= (?) order by seats");
            getRoomList.setInt(1,seats);
            resultSet = getRoomList.executeQuery();
            
            while(resultSet.next())
            {
                rooms.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rooms;
    }
}