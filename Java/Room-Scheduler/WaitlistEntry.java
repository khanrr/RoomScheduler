package roomschedulerrrk5140;

import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Rian Khan
 */
public class WaitlistEntry {
    String Faculty;
    Date Date;
    int Seats;
    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
}
