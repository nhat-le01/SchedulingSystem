import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangePasswordHandler extends JFrame implements ActionListener {
	// private Button submit;
	private Button submit;
	private static JPasswordField newPassword;

	public ChangePasswordHandler() {
		setSize(new Dimension(500, 300));
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
		submit.addActionListener(new ChangePassword());
		cp.add(submit);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
