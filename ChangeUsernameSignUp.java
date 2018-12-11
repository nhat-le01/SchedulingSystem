import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangeUsernameSignUp implements ActionListener {
	private static boolean usernameChanged = false;
	private static String newUsername;

	public ChangeUsernameSignUp() {

	}

	public static boolean isUsernameChanged() {
		return usernameChanged;
	}

	public static String newUsername() {
		return newUsername;
	}

	public void actionPerformed(ActionEvent e) {
		// find the table with that username, and then change the password field where
		// String currentUsername = LogIn.getUsername();
		String newUsername = ChangeUsernameHandlerWhenSignUp.getNewUsername();
		int id = CreatenewUser.getId();

		if (databaseAction.isUsernameExisted(newUsername)) {
			JOptionPane.showMessageDialog(null, "User name exists");
		} else {
			// Change the username, then show user the message
			databaseAction.changeUsername(id, newUsername);
			JOptionPane.showMessageDialog(null, "User name changed");
		}
	}
}
