import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public class LoginHandler extends JFrame implements ActionListener {
	private static int id;

	public LoginHandler() {

	}

	public static int getId() {
		return id;
	}

	public void actionPerformed(ActionEvent event) {
		String username = LogIn.getUsername();
		String password = LogIn.getPasswordPutIn();

		if (!databaseAction.isUsernameExisted(username)) {
			JOptionPane.showMessageDialog(null, "User name does not exist");
		} else {
			if (databaseAction.isPasswordMatched(username, password)) {
				LogIn.cancelFrame();
				id = databaseAction.getIdGivenUsername(username);
				// Show user the main screen
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container cp = getContentPane();
				cp.setLayout(new FlowLayout());
				JMenuBar mb = new JMenuBar();
				setJMenuBar(mb);
				JMenuItem createAccount, changeUsername, changePassword, modifyAccount, weeklyCalendar, dailyCalendar,
						monthlyCalendar, changePhoneNumber, changeEmailAddress, exportToAFile, importSchedule;
				createAccount = new JMenuItem("Create Account");
				changeUsername = new JMenuItem("Change user name");
				changePassword = new JMenuItem("Change password");
				modifyAccount = new JMenuItem("Modify account");
				weeklyCalendar = new JMenuItem("Weekly Calendar");
				weeklyCalendar.addActionListener(new weeklyCalendarHandler());
				dailyCalendar = new JMenuItem("Daily Calendar");
				dailyCalendar.addActionListener(new dailyCalendarHandler());
				monthlyCalendar = new JMenuItem("Monthly Calendar");
				changeEmailAddress = new JMenuItem("Change email address");
				changePhoneNumber = new JMenuItem("Change phone number");
				exportToAFile = new JMenuItem("Export to a file");
				importSchedule = new JMenuItem("Import to a file");

				changeUsername.addActionListener(new ChangeUsernameHandler());
				changePassword.addActionListener(new ChangePasswordHandler());
				changePhoneNumber.addActionListener(new ChangePhoneNumberHandlerWhenLogIn());
				changeEmailAddress.addActionListener(new ChangeEmailHandlerWhenLogIn());
				exportToAFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String filename = "C:/myWebProject/currentUser.txt";
						try {
							FileWriter fw = new FileWriter(filename);
							Connection conn = myConnection.getConnection();
							PreparedStatement prep = conn.prepareStatement("select * from clients where id = ?");

							prep.setInt(1, id);
							ResultSet rs = prep.executeQuery();
							fw.append("Id");
							fw.append('\t');
							fw.append("Username");
							fw.append('\t');
							fw.append("Password");
							fw.append('\t');
							fw.append("Email");
							fw.append('\t');
							fw.append("Phone number");
							fw.append("\r\n");

							while (rs.next()) {
								fw.append(rs.getString(1));
								fw.append('\t');
								fw.append(rs.getString(2));
								fw.append('\t');
								fw.append(rs.getString(3));
								fw.append('\t');
								fw.append(rs.getString(4));
								fw.append('\t');
								fw.append(rs.getString(5));
								fw.append("\r\n");
							}

							PreparedStatement prepApp = conn
									.prepareStatement("select begin, end, description from appointments where id = ?");
							prepApp.setInt(1, id);
							ResultSet app = prepApp.executeQuery();

							while (app.next()) {
								fw.append(app.getString(1));
								fw.append('\t');
								fw.append(app.getString(2));
								fw.append('\t');
								fw.append(app.getString(3));
								fw.append('\t');
								fw.append("\r\n");
							}
							fw.flush();
							fw.close();
							conn.close();
							//System.out.println("CSV File is created successfully.");
							JOptionPane.showMessageDialog(null, "Exported Successfully");
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				importSchedule.addActionListener(new ImportScheduleWindow());

				JMenu accountMenuBar = new JMenu("Account");
				JMenu appointmentMenuBar = new JMenu("Appointment");
				JMenu settingMenuBar = new JMenu("Setting");
				JMenu helpMenuBar = new JMenu("Help");
				JMenu calendarMenuBar = new JMenu("Calendar");
				accountMenuBar.add(createAccount);
				accountMenuBar.add(changeUsername);
				accountMenuBar.add(changePassword);
				accountMenuBar.add(modifyAccount);
				accountMenuBar.add(changeEmailAddress);
				accountMenuBar.add(changePhoneNumber);

				calendarMenuBar.add(dailyCalendar);
				calendarMenuBar.add(weeklyCalendar);
				calendarMenuBar.add(monthlyCalendar);
				calendarMenuBar.add(exportToAFile);
				calendarMenuBar.add(importSchedule);
				//dailyCalendar.addActionListener(new dailyCalendarHandler());
				//weeklyCalendar.addActionListener(new weeklyCalendarHandler());

				JMenuItem makeAppointment = new JMenuItem("Make appointment");
				makeAppointment.addActionListener(new SetAppointmentWindow());
				appointmentMenuBar.add(makeAppointment);
				JMenuItem cancelAppointment = new JMenuItem("Cancel appointment");
				cancelAppointment.addActionListener(new cancelAppointmentWindow());
				appointmentMenuBar.add(cancelAppointment);
				JMenuItem changeAppointment = new JMenuItem("Change appointment");
				changeAppointment.addActionListener(new editAppointmentWindow());
				appointmentMenuBar.add(changeAppointment);

				mb.add(accountMenuBar);
				mb.add(appointmentMenuBar);
				mb.add(settingMenuBar);
				mb.add(helpMenuBar);
				mb.add(calendarMenuBar);
				setLocationRelativeTo(null);
				setSize(500, 500);
				setVisible(true);

				System.out.println("MATCH");
			} else {
				// show the error message
				JOptionPane.showMessageDialog(null, "Wrong password");
			}

		}
	}
}
