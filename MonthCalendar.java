import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MonthCalendar extends Calendar {

	private Month week;

	public MonthCalendar(ArrayList<CalendarEvent> events) {
		super(events);
		week = new Month(LocalDate.now());
	}

	@Override
	protected boolean dateInRange(LocalDate date) {
		return Month.getStartOfWeek(date).equals(week.getDay(DayOfWeek.MONDAY));
	}

	@Override
	protected LocalDate getDateFromDay(DayOfWeek day) {
		return week.getDay(day);
	}

	protected int numDaysToShow() {
		return 7;
	}

	@Override
	protected DayOfWeek getStartDay() {
		return DayOfWeek.MONDAY;
	}

	@Override
	protected DayOfWeek getEndDay() {
		return DayOfWeek.SUNDAY;
	}

	@Override
	protected void setRangeToToday() {
		week = new Month(LocalDate.now());
	}

	@Override
	protected double dayToPixel(DayOfWeek dayOfWeek) {
		return TIME_COL_WIDTH + getDayWidth() * (dayOfWeek.getValue() - 1);
	}

	@Override
	public void drawTimes() {

	}

	@Override
	public void drawEvents() {
		double x;
		double y0;

		for (CalendarEvent event : events) {
			if (!dateInRange(event.getDate()))
				continue;

			x = dayToPixel(event.getDate().getDayOfWeek());
			y0 = timeToPixel(LocalTime.of(00, 00));

			Rectangle2D rect = new Rectangle2D.Double(x, y0, dayWidth,
					(timeToPixel(event.getEnd()) - timeToPixel(LocalTime.of(00, 00))));
			Color origColor = g2.getColor();
			g2.setColor(event.getColor());
			g2.fill(rect);
			g2.setColor(origColor);

			// Draw time header

			// Store the current font state
			Font origFont = g2.getFont();

			final float fontSize = origFont.getSize() - 1.6F;

			// Create a new font with same properties but bold
			Font newFont = origFont.deriveFont(Font.BOLD, fontSize);
			g2.setFont(newFont);

			g2.drawString(event.getStart() + " - " + event.getEnd(), (int) x + 5, (int) y0 + 11);

			// Unbolden
			g2.setFont(origFont.deriveFont(fontSize));

			// Draw the event's text
			g2.drawString(event.getText(), (int) x + 5, (int) y0 + 23);

			// Reset font
			g2.setFont(origFont);
		}
	}

	public void nextWeek() {
		week = week.nextWeek();
		repaint();
	}

	public void prevWeek() {
		week = week.prevWeek();
		repaint();
	}

	public void nextMonth() {
		week = new Month(week.getDay(DayOfWeek.MONDAY).plusWeeks(4));
		repaint();
	}

	public void prevMonth() {
		week = new Month(week.getDay(DayOfWeek.MONDAY).minusWeeks(4));
		repaint();
	}

}
