import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Month {

	private ArrayList<LocalDate> days;

	// Gets week variables from any date (can be within week)
	public Month(LocalDate date) {
		days = new ArrayList<>();
		LocalDate monday = getStartOfWeek(date);
		days.add(monday);
		for (int i = 1; i < 27; i++) {
			days.add(monday.plusDays(i));
		}
	}

	public static LocalDate getStartOfWeek(LocalDate date) {
		LocalDate day = date;
		while (day.getDayOfWeek() != DayOfWeek.MONDAY) {
			day = day.minusDays(1);
		}
		return day;
	}

	public LocalDate getDay(DayOfWeek dayOfWeek) {
		// DayOfWeek enum starts with monday == 1
		return days.get(dayOfWeek.getValue() - 1);
	}

	public Month nextWeek() {
		final LocalDate friday = getDay(DayOfWeek.SUNDAY);
		return new Month(friday.plusDays(3));
	}

	public Month prevWeek() {
		final LocalDate monday = getDay(DayOfWeek.MONDAY);
		return new Month(monday.minusDays(3));
	}

	public String toString() {
		return "Week of the " + getDay(DayOfWeek.MONDAY);
	}

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		Month currentWeek = new Month(now);
		System.out.println(currentWeek);
		System.out.println(currentWeek.prevWeek());
		System.out.println(currentWeek.nextWeek());
	}

}
