import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class ChangePasswordSignUp implements ActionListener {
	public ChangePasswordSignUp() {

	}

	public void actionPerformed(ActionEvent e) {
		// find the table with that username, and then change the password field where
		// description is 1
		int id = CreatenewUser.getId();
		String newPassword = ChangePasswordHandlerWhenSignUp.getNewPassword();
		databaseAction.changePassword(id, newPassword);
		JOptionPane.showMessageDialog(null, "Password changed");
		/**
		 * String currentUser; if (ChangeUsernameSignUp.isUsernameChanged()) {
		 * currentUser = ChangeUsernameSignUp.newUsername(); } else { currentUser =
		 * SignUp.getUsername(); }
		 * 
		 * // String currentUser = LogIn.getUsername(); String newPassword =
		 * ChangePasswordHandlerWhenSignUp.getNewPassword(); Connection conn =
		 * myConnection.getConnection(); try (Statement stmt = conn.createStatement();)
		 * { String update = "update " + currentUser + " set password = '" + newPassword
		 * + "' where description = '1'"; int rset = stmt.executeUpdate(update);
		 * System.out.println("record affected " + rset); } catch (SQLException ex) {
		 * ex.printStackTrace(); }
		 **/

	}
}
