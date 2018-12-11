import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener {
	private JMenuItem createAccount, changeUsername, changePassord, modifyAccount;

	// createAccount
	public MainScreen() {

	}

	public void actionPerformed(ActionEvent e) {
		// Check to see
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);

		JMenu accountMenuBar = new JMenu("Account");
		JMenu appointmentMenuBar = new JMenu("Appointment");
		JMenu settingMenuBar = new JMenu("Setting");
		JMenu helpMenuBar = new JMenu("Help");
		accountMenuBar.add(new JMenuItem("Create account"));
		accountMenuBar.add(new JMenuItem("Change user name"));
		accountMenuBar.add(new JMenuItem("Change Password"));
		accountMenuBar.add(new JMenuItem("Modify account"));

		appointmentMenuBar.add(new JMenuItem("Make appointment"));
		appointmentMenuBar.add(new JMenuItem("Cancel appointment"));
		appointmentMenuBar.add(new JMenuItem("Change appointment"));

		mb.add(accountMenuBar);
		mb.add(appointmentMenuBar);
		mb.add(settingMenuBar);
		mb.add(helpMenuBar);

		setVisible(true);

		return;
	}
}
