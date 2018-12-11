import java.awt.event.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class SetAppointmentHandlerSignUp implements ActionListener {
	public SetAppointmentHandlerSignUp() {

	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(SetAppointmentWindow.getMonthStart());
		// System.out.println(SetAppointmentWindow.getMonthEnd());
		// System.out.println(S)
		// Now we push the information into the database

		int monthStart = SetAppointmentWindowSignUp.getMonthStart();
		int dayStart = SetAppointmentWindowSignUp.getDateStart();
		int yearStart = SetAppointmentWindowSignUp.getYearStart();
		int hourStart = SetAppointmentWindowSignUp.getHourStart();
		int minuteStart = SetAppointmentWindowSignUp.getMinuteStart();

		int monthEnd = SetAppointmentWindowSignUp.getMonthEnd();
		int dayEnd = SetAppointmentWindowSignUp.getDateEnd();
		int yearEnd = SetAppointmentWindowSignUp.getYearEnd();
		int hourEnd = SetAppointmentWindowSignUp.getHourEnd();
		int minuteEnd = SetAppointmentWindowSignUp.getMinuteEnd();
		String description = SetAppointmentWindowSignUp.getDescription();
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
		databaseAction.addAppointment(CreatenewUser.getId(), start, end, description);
		JOptionPane.showMessageDialog(null, "Appointment added");

	}
}
