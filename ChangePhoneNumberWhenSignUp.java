import java.awt.event.*;

import javax.swing.JOptionPane;

public class ChangePhoneNumberWhenSignUp implements ActionListener {
	public ChangePhoneNumberWhenSignUp() {

	}

	public void actionPerformed(ActionEvent e) {
		// int id = CreatenewUser.getId();
		int id = CreatenewUser.getId();
		String newPhoneNumber = ChangePhoneNumberHandlerWhenSignUp.getNewPhoneNumber();
		databaseAction.changePhoneNumber(id, newPhoneNumber);
		JOptionPane.showMessageDialog(null, "Phone number changed");
	}

}
