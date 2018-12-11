import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangeUsernameHandler extends JFrame implements ActionListener {
	private Button submit;
	private static JTextField newUsername;
	private JFrame frame;

	public ChangeUsernameHandler() {
		setSize(new Dimension(500, 300));
	}

	public static String getNewUsername() {
		return newUsername.getText();
	}

	public void actionPerformed(ActionEvent e) {
		getContentPane().removeAll();
		// String currentUsername = LogIn.getUsername();
		// Invoke the user to put in new username
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Create JLabel and JTextField
		cp.add(new JLabel("New user name"));
		newUsername = new JTextField(20);
		cp.add(newUsername);
		submit = new Button("Submit");
		submit.addActionListener(new ChangeUsername());
		cp.add(submit);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
