import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class cancelWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelWindow window = new cancelWindow();
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
	public cancelWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			/* These are dummy values, this needs to be changed to our List, we can use a for loop to add it into an arrayList and set that as the arrayList to be shown on 
			 * the list
			 */
			String[] values = new String[] {"1", "23", "4", "23", "4", "234", "235", "", "235", "23", "34", "23", "4", "23", "42", "34", "", "1", "42"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listPanel.add(list, BorderLayout.CENTER);
		
		JPanel cancelButtonPanel = new JPanel();
		body.add(cancelButtonPanel);
		cancelButtonPanel.setLayout(new GridLayout(3, 3, 140, 80));
		
		JPanel emptyPanel1 = new JPanel();
		cancelButtonPanel.add(emptyPanel1);
		
		JPanel emptyPanel2 = new JPanel();
		cancelButtonPanel.add(emptyPanel2);
		
		JPanel emptyPanel3 = new JPanel();
		cancelButtonPanel.add(emptyPanel3);
		
		JPanel emptyPanel4 = new JPanel();
		cancelButtonPanel.add(emptyPanel4);
		/*
		 * We need to add an action listener that removes the index we select using the button
		 */
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cancelButtonPanel.add(cancelButton);
		
		JPanel emptyPanel5 = new JPanel();
		cancelButtonPanel.add(emptyPanel5);
		
		JPanel emptyPanel6 = new JPanel();
		cancelButtonPanel.add(emptyPanel6);
		
		JPanel emptyPanel7 = new JPanel();
		cancelButtonPanel.add(emptyPanel7);
		
		JPanel emptyPanel8 = new JPanel();
		cancelButtonPanel.add(emptyPanel8);
	}

}
