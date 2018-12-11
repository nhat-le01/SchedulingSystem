import java.sql.Timestamp;
import java.text.*;
import java.util.*;
import java.util.Calendar;
public class TimestampDemo {
	public static void main(String[] args) throws Exception{
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateformat.parse("12/11/2018");
		long time = date.getTime();
		Timestamp t = new Timestamp(time);
		//System.out.println(t.getDate());
		//System.out.println(t.getYear());
		//System.out.println(t.getMonth());
		
		
		
		
		
		Calendar cale = new GregorianCalendar();
	    cale.set(Calendar.YEAR, 2020);
	    cale.set(Calendar.MONTH, 4);
	    cale.set(Calendar.DATE, 23);
	    cale.set(Calendar.HOUR_OF_DAY, 8);
	    cale.set(Calendar.MINUTE, 15);
	    //cale.set(Calendar.SECOND, second);
	    //cale.set(Calendar.MILLISECOND, millisecond);

	    // now convert GregorianCalendar object to Timestamp object
	    Timestamp t1 = new Timestamp(cale.getTimeInMillis());
	    
	    
	    Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(t1.getTime()));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		
	    
	}
}
