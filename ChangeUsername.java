import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangeUsername extends JFrame implements ActionListener {
	public ChangeUsername() {

	}

	public void actionPerformed(ActionEvent e) {
		// We should keep track of users in term of id instead of user name because
		// username can be changed
		String currentUsername = LogIn.getUsername();
		String newUsername = ChangeUsernameHandler.getNewUsername();
		int id = LoginHandler.getId();
		// boolean usernameExisted = false;

		// Connection conn = myConnection.getConnection();
		// try {
		// if (SignUp.isUserNameExisted(newUsername, conn)) {
		// usernameExisted = true;
		// }
		// } catch (SQLException ex) {
		// ex.printStackTrace();
		// }
		// Check if username exists
		if (databaseAction.isUsernameExisted(newUsername)) {
			JOptionPane.showMessageDialog(null, "User name exists");
		} else {
			// Change the username, then show user the message
			databaseAction.changeUsername(id, newUsername);
			JOptionPane.showMessageDialog(null, "User name changed");
			/**
			 * try (Statement stmt = conn.createStatement();) { String strSelect = "alter
			 * table " + currentUsername + " rename to " + newUsername;
			 * stmt.executeUpdate(strSelect); } catch (SQLException ex) {
			 * ex.printStackTrace(); } JOptionPane.showMessageDialog(null, "User name
			 * changed");
			 **/
		}
	}
}
