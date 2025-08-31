package roomscheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dates {
    private static Connection connection;
    private static PreparedStatement getDateList;
    private static ResultSet resultSet;
    
    public static ArrayList<String> getDateList(){
        connection = DBConnection.getConnection();
        ArrayList<String> dates = new ArrayList<String>();
        try
        {
            getDateList = connection.prepareStatement("select date from dates order by date");
            resultSet = getDateList.executeQuery();
            
            while(resultSet.next())
            {
                dates.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return dates;
        
    }
    public static void addDate(){
        
    }
}