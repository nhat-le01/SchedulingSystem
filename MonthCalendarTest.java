import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
import CalendarPackage.Calendar;
import CalendarPackage.CalendarEvent;
import CalendarPackage.WeekCalendar;
*/

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MonthCalendarTest {
    public static void main(String[] args) {
        JFrame frm = new JFrame();

        ArrayList<CalendarEvent> events = new ArrayList<>();
        /*
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 11), LocalTime.of(14, 0), LocalTime.of(14, 20), "Test 11/11 14:00-14:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 14), LocalTime.of(9, 0), LocalTime.of(9, 20), "Test 14/11 9:00-9:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 15), LocalTime.of(12, 0), LocalTime.of(13, 20), "Test 15/11 12:00-13:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 16), LocalTime.of(9, 0), LocalTime.of(9, 20), "Test 16/11 9:00-9:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 17), LocalTime.of(12, 15), LocalTime.of(14, 20), "Test 17/11 12:15-14:20"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(9, 30), LocalTime.of(10, 00), "Test 18/11 9:30-10:00"));
        events.add(new CalendarEvent(LocalDate.of(2016, 11, 18), LocalTime.of(16, 00), LocalTime.of(16, 45), "Test 18/11 16:00-16:45"));
        */
        events.add(new CalendarEvent(LocalDate.of(2018, 10, 22), LocalTime.of(16, 00), LocalTime.of(16, 45), "Test 18/11 16:00-16:45", Color.CYAN));

        events.add(new CalendarEvent(LocalDate.of(2018, 10, 22), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.PINK));
        
        events.add(new CalendarEvent(LocalDate.of(2018, 10, 23), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
        
        events.add(new CalendarEvent(LocalDate.of(2018, 12, 8), LocalTime.of(14, 00), LocalTime.of(14, 45), "Test 18/11 16:00-16:45", Color.GREEN));
        
        MonthCalendar cal = new MonthCalendar(events);
        MonthCalendar cal2 = new MonthCalendar(events);
        cal2.nextWeek();
        MonthCalendar cal3 = new MonthCalendar(events);
        for (int count = 0; count < 2; count++)
        {
        	cal3.nextWeek();
        }
        MonthCalendar cal4 = new MonthCalendar(events);
        for (int count = 0; count < 3; count++)
        {
        	cal4.nextWeek();
        }
        MonthCalendar cal5 = new MonthCalendar(events);
        for (int count = 0; count < 4; count++)
        {
        	cal5.nextWeek();
        }
        MonthCalendar cal6 = new MonthCalendar(events);
        for (int count = 0; count < 5; count++)
        {
        	cal6.nextWeek();
        }

        cal.addCalendarEventClickListener(e -> System.out.println(e.getCalendarEvent()));
        cal.addCalendarEmptyClickListener(e -> {
            System.out.println(e.getDateTime());
            System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
        });

        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());

        JButton nextMonthBtn = new JButton(">>");
        nextMonthBtn.addActionListener(e -> cal.nextMonth());

        JButton prevMonthBtn = new JButton("<<");
        prevMonthBtn.addActionListener(e -> cal.prevMonth());

        JPanel weekControls = new JPanel();
        weekControls.add(prevMonthBtn);
        weekControls.add(goToTodayBtn);
        weekControls.add(nextMonthBtn);

        frm.add(weekControls, BorderLayout.NORTH);

        //frm.add(cal, BorderLayout.CENTER);
        
        JPanel Grid = new JPanel();
		frm.add(Grid, BorderLayout.CENTER);
		Grid.setLayout(new GridLayout(6, 1, 3, 3));
        
		Grid.add(cal);
		Grid.add(cal2);
		Grid.add(cal3);
		Grid.add(cal4);
		Grid.add(cal5);
		Grid.add(cal6);
		
        frm.setSize(1000, 900);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
