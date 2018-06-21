import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PrintDay {
	
	public static String getDay(String day, String month, String year){
	    String date = day + "/" + month + "/" + year;
	    SimpleDateFormat fomatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date1 = null;
		try {
			date1 = fomatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date1);
	    return new SimpleDateFormat("EEEE").format(cal.getTime()).toUpperCase();
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
        
        in.close();
    }
}
