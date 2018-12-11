/**
 * import javax.swing.*;
 * 
 * 
 * import CalendarPackage.Calendar; import CalendarPackage.CalendarEvent; import
 * CalendarPackage.WeekCalendar;
 * 
 * 
 * import java.awt.*; import java.sql.Timestamp; import java.time.LocalDate;
 * import java.time.LocalTime; import java.util.ArrayList; import
 * java.util.Calendar; import java.util.GregorianCalendar;
 * 
 * public class WeekCalendarTest { public static void main(String[] args) {
 * JFrame frm = new JFrame();
 * 
 * ArrayList<CalendarEvent> events = new ArrayList<>(); Calendar cale = new
 * GregorianCalendar(); cale.set(Calendar.YEAR, 2018); cale.set(Calendar.MONTH,
 * 11); cale.set(Calendar.DATE, 22); cale.set(Calendar.HOUR_OF_DAY, 11);
 * cale.set(Calendar.MINUTE, 12); Timestamp start = new
 * Timestamp(cale.getTimeInMillis());
 * 
 * cale.set(Calendar.YEAR, 2018); cale.set(Calendar.MONTH, 11);
 * cale.set(Calendar.DATE, 22); cale.set(Calendar.HOUR_OF_DAY, 13);
 * cale.set(Calendar.MINUTE, 10); Timestamp end = new
 * Timestamp(cale.getTimeInMillis()); CalendarEventClone c = new
 * CalendarEventClone(start, end, "demo appointment", Color.PINK); int year =
 * end.getYear(); int month = end.getMonth(); System.out.println(month); int
 * date = end.getDate(); int h = end.getHours(); int m = end.getMinutes(); int
 * sh = start.getHours(); System.out.println(sh); int sm = start.getMinutes();
 * 
 * //events.add(new CalendarEvent(LocalDate.of(2016, 11, 11), LocalTime.of(14,
 * 0), LocalTime.of(14, 20), "Test 11/11 14:00-14:20", Color.PINK));
 * //events.add(new CalendarEvent(LocalDate.of(2016, 11, 14), LocalTime.of(9,
 * 0), LocalTime.of(9, 20), "Test 14/11 9:00-9:20")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 15), LocalTime.of(12, 0),
 * LocalTime.of(13, 20), "Test 15/11 12:00-13:20")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 16), LocalTime.of(9, 0), LocalTime.of(9,
 * 20), "Test 16/11 9:00-9:20")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 17), LocalTime.of(12, 15),
 * LocalTime.of(14, 20), "Test 17/11 12:15-14:20")); //events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(9, 30),
 * LocalTime.of(10, 00), "Test 18/11 9:30-10:00")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(16, 00),
 * LocalTime.of(16, 45), "Test 18/11 16:00-16:45"));
 * 
 * //events.add(c);
 * 
 * events.add(new CalendarEvent(LocalDate.of(year, month, date),
 * LocalTime.of(sh, sm), LocalTime.of(h, m), "Test 18/11 16:00-16:45",
 * Color.PINK));
 * 
 * //events.add(new CalendarEvent(LocalDate.of(2018, 11, 23), LocalTime.of(14,
 * 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
 * 
 * //events.add(new CalendarEvent(LocalDate.of(2018, 11, 27), LocalTime.of(14,
 * 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
 * 
 * WeekCalendar cal = new WeekCalendar(events);
 * 
 * cal.addCalendarEventClickListener(e ->
 * System.out.println(e.getCalendarEvent()));
 * cal.addCalendarEmptyClickListener(e -> { System.out.println(e.getDateTime());
 * System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
 * });
 * 
 * 
 * JButton goToTodayBtn = new JButton("Today"); goToTodayBtn.addActionListener(e
 * -> cal.goToToday());
 * 
 * JButton nextWeekBtn = new JButton(">"); nextWeekBtn.addActionListener(e ->
 * cal.nextWeek());
 * 
 * JButton prevWeekBtn = new JButton("<"); prevWeekBtn.addActionListener(e ->
 * cal.prevWeek());
 * 
 * JButton nextMonthBtn = new JButton(">>"); nextMonthBtn.addActionListener(e ->
 * cal.nextMonth());
 * 
 * JButton prevMonthBtn = new JButton("<<"); prevMonthBtn.addActionListener(e ->
 * cal.prevMonth());
 * 
 * JPanel weekControls = new JPanel(); weekControls.add(prevMonthBtn);
 * weekControls.add(prevWeekBtn); weekControls.add(goToTodayBtn);
 * weekControls.add(nextWeekBtn); weekControls.add(nextMonthBtn);
 * 
 * frm.add(weekControls, BorderLayout.NORTH);
 * 
 * frm.add(cal, BorderLayout.CENTER); frm.setSize(1000, 900);
 * frm.setVisible(true);
 * frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); } }
 **/
/**
 * import javax.swing.*;
 * 
 * /* import CalendarPackage.Calendar; import CalendarPackage.CalendarEvent;
 * import CalendarPackage.WeekCalendar;
 */

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Timestamp;
/**
 * public class WeekCalendarTest { public static void main(String[] args) {
 * JFrame frm = new JFrame();
 * 
 * ArrayList<CalendarEvent> events = new ArrayList<>();
 * 
 * Calendar cale = new GregorianCalendar(); cale.set(Calendar.YEAR, 2018);
 * cale.set(Calendar.MONTH, 11); cale.set(Calendar.DATE, 22);
 * cale.set(Calendar.HOUR_OF_DAY, 14); cale.set(Calendar.MINUTE, 10); Timestamp
 * start = new Timestamp(cale.getTimeInMillis()); Calendar cal1 =
 * Calendar.getInstance(); cal1.setTime(start); int year =
 * cal1.get(Calendar.YEAR); int month = cal1.get(Calendar.MONTH); int date =
 * cal1.get(Calendar.DATE); int sh = cal1.get(Calendar.HOUR_OF_DAY); int sm =
 * cal1.get(Calendar.MINUTE);
 * 
 * 
 * cale.set(Calendar.YEAR, 2018); cale.set(Calendar.MONTH, 11);
 * cale.set(Calendar.DATE, 22); cale.set(Calendar.HOUR_OF_DAY, 14);
 * cale.set(Calendar.MINUTE, 45); Timestamp end = new
 * Timestamp(cale.getTimeInMillis()); cal1.setTime(end); int h =
 * cal1.get(Calendar.HOUR_OF_DAY); int m = cal1.get(Calendar.MINUTE);
 * //CalendarEventClone c = new CalendarEventClone(start, end, "demo
 * appointment", Color.PINK);
 * 
 * 
 * 
 * 
 * events.add(new CalendarEvent(LocalDate.of(year, month, date),
 * LocalTime.of(sh, sm), LocalTime.of(h,m), "demo appointment"));
 * //events.add(new CalendarEvent(LocalDate.of(2016, 11, 11), LocalTime.of(14,
 * 0), LocalTime.of(14, 20), "Test 11/11 14:00-14:20", Color.PINK)); //
 * events.add(new CalendarEvent(LocalDate.of(2016, 11, 14), LocalTime.of(9, 0),
 * LocalTime.of(9, 20), "Test 14/11 9:00-9:20")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 15), LocalTime.of(12, 0),
 * LocalTime.of(13, 20), "Test 15/11 12:00-13:20")); //events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 16), LocalTime.of(9, 0), LocalTime.of(9,
 * 20), "Test 16/11 9:00-9:20")); //events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 17), LocalTime.of(12, 15),
 * LocalTime.of(14, 20), "Test 17/11 12:15-14:20")); // events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(9, 30),
 * LocalTime.of(10, 00), "Test 18/11 9:30-10:00")); //events.add(new
 * CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(16, 00),
 * LocalTime.of(16, 45), "Test 18/11 16:00-16:45"));
 * 
 * // events.add(new CalendarEvent(LocalDate.of(2018, 11, 22), LocalTime.of(16,
 * 00), LocalTime.of(16, 45), "Test 18/11 16:00-16:45", Color.CYAN));
 * 
 * //events.add(new CalendarEvent(LocalDate.of(2018, 11, 22), LocalTime.of(14,
 * 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.PINK));
 * 
 * //events.add(new CalendarEvent(LocalDate.of(2018, 10, 23), LocalTime.of(14,
 * 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
 * 
 * // events.add(new CalendarEvent(LocalDate.of(2018, 10, 27), LocalTime.of(14,
 * 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
 * 
 * WeekCalendar cal = new WeekCalendar(events);
 * 
 * cal.addCalendarEventClickListener(e ->
 * System.out.println(e.getCalendarEvent()));
 * cal.addCalendarEmptyClickListener(e -> { System.out.println(e.getDateTime());
 * System.out.println(roundTime(e.getDateTime().toLocalTime(), 30)); });
 * 
 * JButton goToTodayBtn = new JButton("Today"); goToTodayBtn.addActionListener(e
 * -> cal.goToToday());
 * 
 * JButton nextWeekBtn = new JButton(">"); nextWeekBtn.addActionListener(e ->
 * cal.nextWeek());
 * 
 * JButton prevWeekBtn = new JButton("<"); prevWeekBtn.addActionListener(e ->
 * cal.prevWeek());
 * 
 * JButton nextMonthBtn = new JButton(">>"); nextMonthBtn.addActionListener(e ->
 * cal.nextMonth());
 * 
 * JButton prevMonthBtn = new JButton("<<"); prevMonthBtn.addActionListener(e ->
 * cal.prevMonth());
 * 
 * JPanel weekControls = new JPanel(); weekControls.add(prevMonthBtn);
 * weekControls.add(prevWeekBtn); weekControls.add(goToTodayBtn);
 * weekControls.add(nextWeekBtn); weekControls.add(nextMonthBtn);
 * 
 * frm.add(weekControls, BorderLayout.NORTH);
 * 
 * frm.add(cal, BorderLayout.CENTER); frm.setSize(1000, 900);
 * frm.setVisible(true);
 * frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); }
 * 
 * public static LocalTime roundTime(LocalTime time, int minutes) { LocalTime t
 * = time;
 * 
 * if (t.getMinute() % minutes > minutes / 2) { t = t.plusMinutes(minutes -
 * (t.getMinute() % minutes)); } else if (t.getMinute() % minutes < minutes / 2)
 * { t = t.minusMinutes(t.getMinute() % minutes); }
 * 
 * return t; } }
 **/
