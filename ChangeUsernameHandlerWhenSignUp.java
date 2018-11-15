import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangeUsernameHandlerWhenSignUp extends JFrame implements ActionListener {
	// private Button submit;
	private Button submit;
	private static JTextField newUsername;

	public ChangeUsernameHandlerWhenSignUp() {

	}

	public static String getNewUsername() {
		return newUsername.getText();
	}

	public void actionPerformed(ActionEvent e) {
		getContentPane().removeAll();
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("New Username"));
		newUsername = new JTextField(20);
		cp.add(newUsername);
		submit = new Button("Submit");
		submit.addActionListener(new ChangeUsernameSignUp());
		cp.add(submit);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
