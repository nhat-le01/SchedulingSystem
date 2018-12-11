import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class monthlyCalendarHandlerSignUp implements ActionListener {
	public monthlyCalendarHandlerSignUp() {

	}

	public void actionPerformed(ActionEvent eve) {

		JFrame frm = new JFrame();

		ArrayList<CalendarEvent> events = new ArrayList<>();
		// Get list of appointments given user id, and then show them on the calendar
		int id = CreatenewUser.getId();
		System.out.println(id);
		events = databaseAction.getAllAppointments(id);

		MonthCalendar cal = new MonthCalendar(events);
		MonthCalendar cal2 = new MonthCalendar(events);
		cal2.nextWeek();
		MonthCalendar cal3 = new MonthCalendar(events);
		for (int count = 0; count < 2; count++) {
			cal3.nextWeek();
		}
		MonthCalendar cal4 = new MonthCalendar(events);
		for (int count = 0; count < 3; count++) {
			cal4.nextWeek();
		}
		MonthCalendar cal5 = new MonthCalendar(events);
		for (int count = 0; count < 4; count++) {
			cal5.nextWeek();
		}
		MonthCalendar cal6 = new MonthCalendar(events);
		for (int count = 0; count < 5; count++) {
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

		// frm.add(cal, BorderLayout.CENTER);

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
		frm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

	}
}
