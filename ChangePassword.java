import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangePassword implements ActionListener {
	public ChangePassword() {

	}

	public void actionPerformed(ActionEvent e) {
		// find the table with that username, and then change the password field where
		// description is 1
		// String currentUser = LogIn.getUsername();
		int id = LoginHandler.getId();
		// String currentUser = LogIn.getUsername();
		String newPassword = ChangePasswordHandler.getNewPassword();
		databaseAction.changePassword(id, newPassword);
		JOptionPane.showMessageDialog(null, "Password changed");

	}
}
