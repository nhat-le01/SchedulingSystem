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

public class emailWindow implements ActionListener{

	private JFrame frame;
	private ArrayList<String> updatedArrayList = new ArrayList<String>();

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

		JLabel headerTitle = new JLabel("Cancel Appointment");
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
		body.add(cancelButtonPanel);
		cancelButtonPanel.setLayout(new GridLayout(3, 3, 120, 80));

		JPanel emptyPanel1 = new JPanel();
		cancelButtonPanel.add(emptyPanel1);

		JPanel emptyPanel2 = new JPanel();
		cancelButtonPanel.add(emptyPanel2);
		emptyPanel2.setLayout(new GridLayout(1, 3, 1, 1));

		JPanel emptyPanel3 = new JPanel();
		cancelButtonPanel.add(emptyPanel3);

		JPanel emptyPanel4 = new JPanel();
		cancelButtonPanel.add(emptyPanel4);

		// ArrayList<String> updatedArrayList = new ArrayList<String>();
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatedArrayList.clear();
				int pos = list.getSelectedIndex();
				String des = arraySchedule.get(pos);
				obj.removeElementAt(list.getSelectedIndex());
				// Remove it in database
				databaseAction.cancelAppointmentAtIndex(LoginHandler.getId(), des);
				ArrayList<String> store = test(obj);
				for (int count = 0; count < store.size(); count++) {
					updatedArrayList.add(store.get(count));
				}
				printArrayList(updatedArrayList);
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cancelButtonPanel.add(cancelButton);

		JPanel emptyPanel5 = new JPanel();
		cancelButtonPanel.add(emptyPanel5);

		JPanel emptyPanel6 = new JPanel();
		cancelButtonPanel.add(emptyPanel6);

		JPanel emptyPanel7 = new JPanel();
		cancelButtonPanel.add(emptyPanel7);
		
		JButton button = new JButton("Cancel");
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emptyPanel7.add(button);

		JPanel emptyPanel8 = new JPanel();
		cancelButtonPanel.add(emptyPanel8);
	}

}