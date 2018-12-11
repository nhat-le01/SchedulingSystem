import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class emailWindow implements ActionListener{

	private JFrame frame;
	private ArrayList<String> updatedArrayList = new ArrayList<String>();
	private static JComboBox comboBox, comboBox_1, comboBox_2;
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emailWindow window = new emailWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// get the variables
	public static String getDescription() {
		return textField.getText();
	}
	
	public static int getHour() {
		return Integer.parseInt((String)comboBox.getSelectedItem());
	}
	
	public static int getMin() {
		return Integer.parseInt((String)comboBox_1.getSelectedItem());
	}
	
	public static int getSec() {
		return Integer.parseInt((String)comboBox_2.getSelectedItem());
	}

	/**
	 * Create the application.
	 */
	public emailWindow() {
		initialize();
	}

	// Convert DefaultListModel to ArrayList
	public ArrayList<String> test(DefaultListModel obj) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int count = 0; count < obj.getSize(); count++) {
			temp.add((String) obj.getElementAt(count));
		}
		/*
		 * for printing out the values for(int count = 0; count < temp.size(); count++)
		 * { System.out.println(temp.get(count)); }
		 */
		return temp;
	}

	// prints what's inside the ArrayList
	public void printArrayList(ArrayList<String> list) {
		// Printing out the value to see if it works
		for (int count = 0; count < list.size(); count++) {
			System.out.println(list.get(count));
		}
	}

	// returns the updated ArrayList
	public ArrayList<String> returnArrayList() {
		return updatedArrayList;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel header = new JPanel();
		header.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(header, BorderLayout.NORTH);

		JLabel headerTitle = new JLabel("Remind Appointment");
		headerTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		headerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(headerTitle);

		JPanel body = new JPanel();
		frame.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new GridLayout(2, 1, 3, 3));

		JPanel listAndScrollPanel = new JPanel();
		listAndScrollPanel.setBorder(new EmptyBorder(14, 14, 14, 14));
		body.add(listAndScrollPanel);
		listAndScrollPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		listAndScrollPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel scrollPanePanel = new JPanel();
		listAndScrollPanel.add(scrollPanePanel, BorderLayout.CENTER);
		scrollPanePanel.setLayout(new GridLayout(1, 1, 1, 1));

		JScrollPane scrollPane = new JScrollPane();
		scrollPanePanel.add(scrollPane);

		JPanel listPanel = new JPanel();
		scrollPane.setViewportView(listPanel);
		listPanel.setLayout(new BorderLayout(0, 0));

		// testing out stuff
		DefaultListModel obj = new DefaultListModel();
		int id = LoginHandler.getId();
		ArrayList<String> arraySchedule = databaseAction.showRepresentation(id);
		// String[] values = {"1", "23", "4", "23", "4", "234", "235", "", "235", "23",
		// "34", "23", "4", "23", "42", "34", "", "1", "42"};
		// add array elements to arrayList
		// for (int count = 0; count < values.length; count++)
		// {
		// arraySchedule.add(values[count]);
		// }
		// add arrayList to obj
		for (int count = 0; count < arraySchedule.size(); count++) {
			obj.addElement(arraySchedule.get(count));
		}

		JList list = new JList();
		list.setModel(obj);

		/*
		 * JList list = new JList(); list.setModel(new AbstractListModel() { String[]
		 * values = new String[] {"1", "23", "4", "23", "4", "234", "235", "", "235",
		 * "23", "34", "23", "4", "23", "42", "34", "", "1", "42"}; public int getSize()
		 * { return values.length; } public Object getElementAt(int index) { return
		 * values[index]; } });
		 */

		listPanel.add(list, BorderLayout.CENTER);

		JPanel cancelButtonPanel = new JPanel();
		cancelButtonPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		body.add(cancelButtonPanel);
		cancelButtonPanel.setLayout(new GridLayout(3, 3, 120, 80));

		JPanel emptyPanel1 = new JPanel();
		cancelButtonPanel.add(emptyPanel1);

		JPanel EmailPanel = new JPanel();
		cancelButtonPanel.add(EmailPanel);
		EmailPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		EmailPanel.add(lblEmail);
		
		textField = new JTextField();
		EmailPanel.add(textField);
		textField.setColumns(10);

		JPanel emptyPanel3 = new JPanel();
		cancelButtonPanel.add(emptyPanel3);

		JPanel ReminderPanel = new JPanel();
		cancelButtonPanel.add(ReminderPanel);
		
		JLabel lblReminderTime = new JLabel("Reminder Time:");
		lblReminderTime.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ReminderPanel.add(lblReminderTime);
		
		JPanel panelHourMinSec = new JPanel();
		cancelButtonPanel.add(panelHourMinSec);
		panelHourMinSec.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panelHourMinSec.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblHour);
		
		JLabel lblMin = new JLabel("Minute");
		lblMin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblMin);
		
		JLabel lblSec = new JLabel("Second");
		lblSec.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSec.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblSec);
		
		JPanel panel_3 = new JPanel();
		panelHourMinSec.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		panel_3.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBox_1.setSelectedIndex(30);
		panel_3.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		panel_3.add(comboBox_2);

		JPanel emptyPanel5 = new JPanel();
		cancelButtonPanel.add(emptyPanel5);

		JPanel emptyPanel6 = new JPanel();
		cancelButtonPanel.add(emptyPanel6);
		
		JButton sendEmail = new JButton("Send Email");
		sendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = list.getSelectedIndex();
				String des = arraySchedule.get(pos);
				String email = getDescription();
				int hour = getHour();
				int min = getMin();
				int sec = getSec();
				new EmailSend(des, email, hour, min, sec);
			}
		});
		sendEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cancelButtonPanel.add(sendEmail);

		JPanel emptyPanel8 = new JPanel();
		cancelButtonPanel.add(emptyPanel8);
	}

}