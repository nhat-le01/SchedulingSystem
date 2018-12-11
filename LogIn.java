import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {
	private static TextField Username = null;
	private static JPasswordField Password;
	private Label userNameLabel;
	private Label passwordLabel;
	private Button submit;
	private static JFrame frame;

	public LogIn() {

	}

	public boolean checkPassword(String userName) {
		// Check to see if a user name exists in SQL tables
		// If it does exist, check the password, otherwise invalid username
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useSSL=false",
						"nhatle", "xxxx");
				// MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Step 2: Allocate a 'Statement' object in the Connection
				Statement stmt = conn.createStatement();) {

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return true;
	}

	public static String getPasswordPutIn() {
		return Password.getText();
	}

	public static String getUsername() {
		return Username.getText();
	}
	
	public static void cancelFrame() {
		frame.dispose();
	}

	public void actionPerformed(ActionEvent evt) {
		Welcome.cancelFrame();
		//Container c = frame.getContentPane();
		frame = new JFrame("Log In");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		getContentPane().removeAll();
		Container c = frame.getContentPane();
		setLayout(new FlowLayout());
		userNameLabel = new Label("User Name");
		passwordLabel = new Label("Password");
		Username = new TextField(10);
		Password = new JPasswordField(10);
		submit = new Button("Submit");
		submit.addActionListener(new LoginHandler());
		c.add(userNameLabel);
		c.add(Username);
		c.add(passwordLabel);
		c.add(Password);
		c.add(submit);
		frame.setSize(350, 120);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		System.out.println("Click on login ");

	}
}
