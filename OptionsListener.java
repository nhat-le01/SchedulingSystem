import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionsListener implements ActionListener {
	public OptionsListener() {

	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String option = (String) cb.getSelectedItem();
		if (option.equals("Account")) {
			System.out.println("Selected account");
		} else if (option.equals("Appointment")) {
			System.out.println("Selected appointment");
		} else if (option.equals("Settings")) {
			System.out.println("Selected settings");
		} else {
			System.out.println("somehtinelse");
		}
	}
}
