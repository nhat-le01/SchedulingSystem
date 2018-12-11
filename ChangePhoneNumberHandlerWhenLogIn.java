import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangePhoneNumberHandlerWhenLogIn extends JFrame implements ActionListener {
	private Button submit;
	private static JTextField newPhoneNumber;

	public ChangePhoneNumberHandlerWhenLogIn() {
		setSize(new Dimension(500, 300));
	}

	public static String getNewPhoneNumber() {
		return newPhoneNumber.getText();

	}

	public void actionPerformed(ActionEvent e) {
		getContentPane().removeAll();
		// String currentUsername = LogIn.getUsername();
		// Invoke the user to put in new username
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Create JLabel and JTextField
		cp.add(new JLabel("New phone number"));
		newPhoneNumber = new JTextField(20);
		cp.add(newPhoneNumber);
		submit = new Button("Submit");
		submit.addActionListener(new ChangePhoneNumberLogIn());
		cp.add(submit);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
