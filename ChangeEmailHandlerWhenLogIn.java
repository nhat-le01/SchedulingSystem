import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangeEmailHandlerWhenLogIn extends JFrame implements ActionListener{
	private Button submit;
	private static JTextField newEmail;
	public ChangeEmailHandlerWhenLogIn() {
		
	}
	
	
	public static String getNewEmail() {
		return newEmail.getText();
	}
	public void actionPerformed(ActionEvent e) {
		getContentPane().removeAll();
		//String currentUsername = LogIn.getUsername();
		// Invoke the user to put in new username
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		// Create JLabel and JTextField
		cp.add(new JLabel("New email address"));
		newEmail = new JTextField(20);
		cp.add(newEmail);
		submit = new Button("Submit");
		submit.addActionListener(new ChangeEmailLogin());
		cp.add(submit);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
