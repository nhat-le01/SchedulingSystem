import java.awt.event.*;

import javax.swing.JOptionPane;

public class ChangeEmailWhenSignUp implements ActionListener {
	public ChangeEmailWhenSignUp() {

	}

	public void actionPerformed(ActionEvent e) {
		// int id = CreatenewUser.getId();
		int id = CreatenewUser.getId();
		String newEmail = ChangeEmailWhenSignUpHandler.getNewEmail();
		databaseAction.changeEmail(id, newEmail);
		JOptionPane.showMessageDialog(null, "Email changed");
	}

}
