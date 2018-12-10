import java.awt.Color;
import java.awt.event.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class SetAppointmentHandler implements ActionListener {
	public SetAppointmentHandler() {

	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(SetAppointmentWindow.getMonthStart());
		// System.out.println(SetAppointmentWindow.getMonthEnd());
		// System.out.println(S)
		// Now we push the information into the database

		int monthStart = SetAppointmentWindow.getMonthStart();
		int dayStart = SetAppointmentWindow.getDateStart();
		int yearStart = SetAppointmentWindow.getYearStart();
		int hourStart = SetAppointmentWindow.getHourStart();
		int minuteStart = SetAppointmentWindow.getMinuteStart();

		int monthEnd = SetAppointmentWindow.getMonthEnd();
		int dayEnd = SetAppointmentWindow.getDateEnd();
		int yearEnd = SetAppointmentWindow.getYearEnd();
		int hourEnd = SetAppointmentWindow.getHourEnd();
		int minuteEnd = SetAppointmentWindow.getMinuteEnd();
		String description = SetAppointmentWindow.getDescription();
		// Check for conflict

		// Check for the authenticity of the appoinment too, like did end time is before
		// start time
		// Push into database
		Calendar cale = new GregorianCalendar();
		cale.set(Calendar.YEAR, yearStart);
		cale.set(Calendar.MONTH, monthStart - 1);
		cale.set(Calendar.DATE, dayStart);
		cale.set(Calendar.HOUR_OF_DAY, hourStart);
		cale.set(Calendar.MINUTE, minuteStart);

		Timestamp start = new Timestamp(cale.getTimeInMillis());

		cale.set(Calendar.YEAR, yearEnd);
		cale.set(Calendar.MONTH, monthEnd - 1);
		cale.set(Calendar.DATE, dayEnd);
		cale.set(Calendar.HOUR_OF_DAY, hourEnd);
		cale.set(Calendar.MINUTE, minuteEnd);
		Timestamp end = new Timestamp(cale.getTimeInMillis());
		// LocalDate.of(year, month + 1, day), LocalTime.of(startHour, startMinute),
		// LocalTime.of(endHour, endMinute), description, Color.PINK
		CalendarEvent newEvent = new CalendarEvent(LocalDate.of(yearEnd, monthEnd, dayEnd),
				LocalTime.of(hourStart, minuteStart), LocalTime.of(hourEnd, minuteEnd), description);
		if (databaseAction.isConflict(LoginHandler.getId(), newEvent)) {
			JOptionPane.showMessageDialog(null, "Conflicted appointment");
		} else {
			databaseAction.addAppointment(LoginHandler.getId(), start, end, description);
			JOptionPane.showMessageDialog(null, "Appointment added");
		}

	}
}
