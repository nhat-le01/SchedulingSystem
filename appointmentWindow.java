import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class appointmentWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentWindow window = new appointmentWindow();
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
	public appointmentWindow() {
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

		JPanel Header = new JPanel();
		Header.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(Header, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Make Appointment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Header.add(lblNewLabel);

		JPanel Body = new JPanel();
		Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(Body, BorderLayout.CENTER);
		Body.setLayout(new GridLayout(1, 1, 3, 3));

		JPanel Grid = new JPanel();
		Grid.setBorder(new EmptyBorder(0, 5, 0, 0));
		Body.add(Grid);
		Grid.setLayout(new GridLayout(3, 1, 3, 3));

		JPanel Row1 = new JPanel();
		Grid.add(Row1);
		Row1.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_3 = new JPanel();
		Row1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblStart, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row1.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Month");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		panel_4.add(comboBox);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row1.add(panel_5);
		panel_5.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("Day");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_4);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		panel_5.add(comboBox_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row1.add(panel_6);
		panel_6.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_5);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
				"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
				"2022", "2023", "2024", "2025" }));
		panel_6.add(comboBox_2);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row1.add(panel_7);
		panel_7.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_8 = new JLabel("Hour");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_8);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
		panel_7.add(comboBox_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row1.add(panel_8);
		panel_8.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_9 = new JLabel("Minute");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_9);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(new Color(255, 255, 255));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
				"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));
		panel_8.add(comboBox_4);

		JPanel Row2 = new JPanel();
		Grid.add(Row2);
		Row2.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_9 = new JPanel();
		Row2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblEnd, BorderLayout.NORTH);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row2.add(panel_10);
		panel_10.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_12 = new JLabel("Month");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_12);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBackground(new Color(255, 255, 255));
		comboBox_5.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		panel_10.add(comboBox_5);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row2.add(panel_11);
		panel_11.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_14 = new JLabel("Day");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_14);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBackground(new Color(255, 255, 255));
		comboBox_6.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		panel_11.add(comboBox_6);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row2.add(panel_12);
		panel_12.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_16 = new JLabel("Year");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_12.add(lblNewLabel_16);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBackground(new Color(255, 255, 255));
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] { "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
				"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
				"2022", "2023", "2024", "2025" }));
		panel_12.add(comboBox_7);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row2.add(panel_13);
		panel_13.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_17 = new JLabel("Hour");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_17);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBackground(new Color(255, 255, 255));
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
		panel_13.add(comboBox_8);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new EmptyBorder(0, 4, 0, 4));
		Row2.add(panel_14);
		panel_14.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_20 = new JLabel("Minute");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_14.add(lblNewLabel_20);

		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBackground(new Color(255, 255, 255));
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
				"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));
		panel_14.add(comboBox_9);

		JPanel Row3 = new JPanel();
		Grid.add(Row3);
		Row3.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 8, 10, 8));
		Row3.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblNewLabel_1, BorderLayout.NORTH);

		textField = new JTextField();
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		Row3.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 3, 3));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_15 = new JPanel();
		panel_1.add(panel_15);

		JPanel panel_16 = new JPanel();
		panel_1.add(panel_16);

		JPanel panel_17 = new JPanel();
		panel_1.add(panel_17);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(btnNewButton);

		JPanel panel_18 = new JPanel();
		panel_1.add(panel_18);

		JPanel panel_19 = new JPanel();
		panel_1.add(panel_19);

		JPanel panel_20 = new JPanel();
		panel_1.add(panel_20);

		JPanel panel_21 = new JPanel();
		panel_1.add(panel_21);
	}

}
