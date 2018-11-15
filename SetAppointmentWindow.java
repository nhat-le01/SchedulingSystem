import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SetAppointmentWindow extends JFrame implements ActionListener{
	private Button submit;
	private JLabel label;
	private static int chosenDate;
	private static int chosenMonth;
	private static int chosenYear;
	private static String description;
	private static JComboBox dayList;
	private static JComboBox monthList;
	private static JComboBox yearList;
	public static void main(String[] args) {
		SetAppointmentWindow app = new SetAppointmentWindow();
		app.showWindow();
	}
	
	public static String getDescription() {
		return description;
	}
	public static int getDate() {
		return (int)dayList.getSelectedItem();
	}
	
	public static String getMonth() {
		return (String)monthList.getSelectedItem();
	}
	
	public static int getYear() {
		return (int)yearList.getSelectedItem();
	}
	public SetAppointmentWindow() {

	}
	
	
	
	public void showWindow() {
		String[] days = { "Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] months = { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] years = { "Year", "2018", "2019", "2020", "2021", "2022" };
		
		
		dayList = new JComboBox(days);
		monthList = new JComboBox(months);
		yearList = new JComboBox(years);
		dayList.setSelectedIndex(0);
		monthList.setSelectedIndex(0);
		yearList.setSelectedIndex(0);
		setLayout(new FlowLayout());
		setSize(400, 300);
		setTitle("Set Appointment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(dayList);
		add(monthList);
		add(yearList);
		submit = new Button("Submit");
		add(submit);
		setVisible(true);
		setLocationRelativeTo(null);
		submit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//Figure out what the user chose
		//if ()
		//JComboBox msg = (JComboBox)e.getSource();
		//switch
		
	}
}
