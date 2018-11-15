import java.awt.*;
import java.awt.event.*;
import java.sql.*;
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
						monthlyCalendar, changePhoneNumber, changeEmailAddress;
				createAccount = new JMenuItem("Create Account");
				changeUsername = new JMenuItem("Change user name");
				changePassword = new JMenuItem("Change password");
				modifyAccount = new JMenuItem("Modify account");
				weeklyCalendar = new JMenuItem("Weekly Calendar");
				dailyCalendar = new JMenuItem("Daily Calendar");
				monthlyCalendar = new JMenuItem("Monthly Calendar");
				changeEmailAddress = new JMenuItem("Change email address");
				changePhoneNumber = new JMenuItem("Change phone number");

				changeUsername.addActionListener(new ChangeUsernameHandler());
				changePassword.addActionListener(new ChangePasswordHandler());
				changePhoneNumber.addActionListener(new ChangePhoneNumberHandlerWhenLogIn());
				changeEmailAddress.addActionListener(new ChangeEmailHandlerWhenLogIn());
				
				
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
				dailyCalendar.addActionListener(new dailyCalendarHandler());
				weeklyCalendar.addActionListener(new weeklyCalendarHandler());
				

				appointmentMenuBar.add(new JMenuItem("Make appointment"));
				appointmentMenuBar.add(new JMenuItem("Cancel appointment"));
				appointmentMenuBar.add(new JMenuItem("Change appointment"));

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
