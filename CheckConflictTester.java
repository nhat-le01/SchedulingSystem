import java.awt.Color;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CheckConflictTester {

	public static void main(String[] args) {
		ArrayList<CalendarEventClone> appointmentsList;
		appointmentsList = new ArrayList<>();

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long i = 123L;
		Timestamp timestamp2 = new Timestamp(i);
		String test = "hi";
		Color color = Color.BLUE;
		Color color2 = Color.RED;
		// ConflictChecker
		CalendarEventClone testSingle = new CalendarEventClone(timestamp, timestamp, test, color2);
		CalendarEventClone testSingle2 = new CalendarEventClone(timestamp, timestamp2, test, color2);
		ConflictChecker singleTest = new ConflictChecker(testSingle, testSingle);
		System.out.println(singleTest.check());
		ConflictChecker singleTest2 = new ConflictChecker(testSingle, testSingle2);
		System.out.println(singleTest2.check());

		// Add stuff to list
		appointmentsList.add(new CalendarEventClone(timestamp, timestamp, test, color));
		appointmentsList.add(new CalendarEventClone(timestamp, timestamp, test, color));
		appointmentsList.add(new CalendarEventClone(timestamp, timestamp, test, color2));
		appointmentsList.add(new CalendarEventClone(timestamp, timestamp, test, color));

		// Instantiate a CalendarEventClone
		CalendarEventClone testEvent = new CalendarEventClone(timestamp, timestamp, test, color2);
		CalendarEventClone testEvent2 = new CalendarEventClone(timestamp, timestamp2, test, color2);

		ListChecker listCheckTest = new ListChecker(appointmentsList, testEvent);
		System.out.println(listCheckTest.checkAvailable());
		System.out.println(listCheckTest.checkPostion());
		ListChecker listCheckTest2 = new ListChecker(appointmentsList, testEvent2);
		System.out.println(listCheckTest2.checkAvailable());
		System.out.println(listCheckTest2.checkPostion());
		/*
		 * ArrayList<Appointments> appointmentsList; appointmentsList = new
		 * ArrayList<Appointments>();
		 * 
		 * // Janauray 1st 2018 12:20 Appointments x = new Appointments(1, 1, 2018, 12,
		 * 20);
		 * 
		 * // February 3rd 2018 3:20 Appointments y = new Appointments(2, 3, 2018, 3,
		 * 20);
		 * 
		 * // Janauray 1st 2018 12:20 Appointments z = new Appointments(1, 1, 2018, 12,
		 * 20);
		 * 
		 * appointmentsList.add(x); appointmentsList.add(y);
		 * 
		 * // Testing if the ConflictChecker function works ConflictChecker c = new
		 * ConflictChecker(x, y); System.out.println(c.check()); c = new
		 * ConflictChecker(x, z); System.out.println(c.check());
		 * 
		 * // Testing if the ListCheckerWorks ListChecker l = new
		 * ListChecker(appointmentsList, y); System.out.println(l.checkPostion());
		 * System.out.println(l.checkAvailable());
		 */
	}

}
