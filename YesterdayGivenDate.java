import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YesterdayGivenDate {

	public static void main(String[] args) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		Date date = formatter.parse("03 June 2018");
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);

		System.out.println(formatter.format(cal.getTime()));
	}

}
