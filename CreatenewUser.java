import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CreatenewUser extends JFrame implements ActionListener {
	private static int id;
	public CreatenewUser() {
		setSize(new Dimension(1000, 500));
	}
	public static int getId() {
		
		return id;
	}
	public void actionPerformed(ActionEvent eve) {
		String username = SignUp.getUsername();
		String password = SignUp.getPassword();
		String confirm = SignUp.getConfirmPassword();
		String email = SignUp.getEmail();
		String phonenumber = SignUp.getPhoneNumber();
		boolean usernameExisted = databaseAction.isUsernameExisted(username);
		if (password.equals(confirm) && !usernameExisted) {
			//id = databaseAction.getIdGivenUsername(username);
			databaseAction.createNewUser(username, password, email, phonenumber);
			id = databaseAction.getIdGivenUsername(username);
			System.out.println("user name is " + username);
			System.out.println("password pushed in is " + password);
			// invoke the main menu for the user
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container cp = getContentPane();
			cp.setLayout(new FlowLayout());
			JMenuBar mb = new JMenuBar();
			setJMenuBar(mb);
			JMenuItem createAccount, changeUsername, changePassword, modifyAccount, weeklyCalendar, dailyCalendar,
					monthlyCalendar;
			createAccount = new JMenuItem("Create Account");
			changeUsername = new JMenuItem("Change user name");
			changePassword = new JMenuItem("Change password");
			modifyAccount = new JMenuItem("Modify account");
			weeklyCalendar = new JMenuItem("Weekly Calendar");
			dailyCalendar = new JMenuItem("Daily Calendar");
			monthlyCalendar = new JMenuItem("Monthly Calendar");
			JMenuItem changeEmailAddress = new JMenuItem("Change email address");
			JMenuItem changePhoneNumber = new JMenuItem("Change phone number");

			changeUsername.addActionListener(new ChangeUsernameHandlerWhenSignUp());
			changePassword.addActionListener(new ChangePasswordHandlerWhenSignUp());
			changeEmailAddress.addActionListener(new ChangeEmailWhenSignUpHandler());
			changePhoneNumber.addActionListener(new ChangePhoneNumberHandlerWhenSignUp());
			JMenu accountMenuBar = new JMenu("Account");
			JMenu appointmentMenuBar = new JMenu("Appointment");
			JMenu settingMenuBar = new JMenu("Setting");
			JMenu helpMenuBar = new JMenu("Help");
			JMenu calendarMenuBar = new JMenu("Calendar");
			accountMenuBar.add(createAccount);
			accountMenuBar.add(changeUsername);
			accountMenuBar.add(changePassword);
			//accountMenuBar.add(modifyAccount);
			modifyAccount.add(changeEmailAddress);
			modifyAccount.add(changePhoneNumber);
			accountMenuBar.add(modifyAccount);
			calendarMenuBar.add(dailyCalendar);
			calendarMenuBar.add(weeklyCalendar);
			calendarMenuBar.add(monthlyCalendar);
			dailyCalendar.addActionListener(new dailyCalendarHandler());
			weeklyCalendar.addActionListener(new weeklyCalendarHandler());
			// monthlyCalendar.addActionListener(new monthlyCalendarHandler());

			appointmentMenuBar.add(new JMenuItem("Make appointment"));
			appointmentMenuBar.add(new JMenuItem("Cancel appointment"));
			appointmentMenuBar.add(new JMenuItem("Change appointment"));

			mb.add(accountMenuBar);
			mb.add(appointmentMenuBar);
			mb.add(settingMenuBar);
			mb.add(helpMenuBar);
			mb.add(calendarMenuBar);
			setVisible(true);
			// System.out.println("MATCH");
		} else if (!password.equals(confirm)) {
			JOptionPane.showMessageDialog(null, "Mismatched password");
		} else {
			JOptionPane.showMessageDialog(null, "User name already exists");
		}
	}

}
