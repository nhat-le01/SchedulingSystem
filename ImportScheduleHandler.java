import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.*;

public class ImportScheduleHandler implements ActionListener {
	public ImportScheduleHandler() {

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION");
		int id = LoginHandler.getId();
		String filePath = ImportScheduleWindow.getFilePath();
		try {
			ImportText test = new ImportText(filePath);
			ArrayList<String> des = test.getDescription();
			ArrayList<Timestamp> t = test.getTimestamp();
			//
			databaseAction.pushInDatabase(id, des, t);
			System.out.println("Pushing data finished");
			JOptionPane.showMessageDialog(null, "Schedule imported");
		} catch (Exception exp) {
			System.out.println("CATCHING");
		}

	}
}
