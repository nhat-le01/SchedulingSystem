import java.awt.event.*;

import javax.swing.JOptionPane;

public class ChangeEmailLogin implements ActionListener {
	public ChangeEmailLogin() {

	}

	public void actionPerformed(ActionEvent e) {
		// int id = CreatenewUser.getId();
		int id = CreatenewUser.getId();
		String newEmail = ChangeEmailHandlerWhenLogIn.getNewEmail();
		databaseAction.changeEmail(id, newEmail);
		JOptionPane.showMessageDialog(null, "Email changed");
	}

}
