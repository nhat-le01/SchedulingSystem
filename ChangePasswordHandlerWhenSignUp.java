import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangePasswordHandlerWhenSignUp extends JFrame implements ActionListener {
	// private Button submit;
	private Button submit;
	private static JPasswordField newPassword;

	public ChangePasswordHandlerWhenSignUp() {

	}

	public static String getNewPassword() {
		return newPassword.getText();
	}

	public void actionPerformed(ActionEvent e) {
		getContentPane().removeAll();
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("New password"));
		newPassword = new JPasswordField(20);
		cp.add(newPassword);
		submit = new Button("Submit");
		submit.addActionListener(new ChangePasswordSignUp());
		cp.add(submit);
		setVisible(true);
	}
}
