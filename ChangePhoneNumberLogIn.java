import java.awt.event.*;

import javax.swing.JOptionPane;

public class ChangePhoneNumberLogIn implements ActionListener {
	public ChangePhoneNumberLogIn() {

	}

	public void actionPerformed(ActionEvent e) {
		// int id = CreatenewUser.getId();
		int id = CreatenewUser.getId();
		String newPhoneNumber = ChangePhoneNumberHandlerWhenLogIn.getNewPhoneNumber();
		databaseAction.changePhoneNumber(id, newPhoneNumber);
		JOptionPane.showMessageDialog(null, "Phone number changed");
	}

}
