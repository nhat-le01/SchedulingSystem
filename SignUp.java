import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	private String username, password, confirmedPassword;
	private JLabel userNameLabel, passwordLabel, confirmPasswordLabel, emailLabel, phoneNumberLabel;
	private static JTextField Username, email, phoneNumber;
	private static JPasswordField Password, confirmPassword;
	private Button Submit;

	public SignUp() {

	}

	public static String getUsername() {
		return Username.getText();
	}

	public static String getPassword() {
		return Password.getText();
	}

	public static String getEmail() {
		return email.getText();
	}

	public static String getPhoneNumber() {
		return phoneNumber.getText();
	}

	public static String getConfirmPassword() {
		return confirmPassword.getText();
	}

	public static boolean isUserNameExisted(String username, Connection c) throws SQLException {
		DatabaseMetaData dbm = c.getMetaData();
		ResultSet rs = dbm.getTables(null, null, username, null);
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean confirmPassword() {
		return Password.getText() == confirmPassword.getText();
	}

	public void actionPerformed(ActionEvent evt) {
		Welcome.cancelFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setTitle("Sign Up");
		getContentPane().setLayout(null);

		userNameLabel = new JLabel("Username :");
		userNameLabel.setBounds(78, 52, 89, 14);
		getContentPane().add(userNameLabel);

		passwordLabel = new JLabel("Password :");

		passwordLabel.setBounds(78, 84, 89, 14);

		getContentPane().add(passwordLabel);

		confirmPasswordLabel = new JLabel("Confirm Password :");

		confirmPasswordLabel.setBounds(77, 113, 130, 14);

		getContentPane().add(confirmPasswordLabel);

		emailLabel = new JLabel("Email ");
		emailLabel.setBounds(78, 142, 89, 14);
		getContentPane().add(emailLabel);

		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(78, 172, 130, 14);
		getContentPane().add(phoneNumberLabel);

		Username = new JTextField("");

		Username.setBounds(217, 47, 99, 20);

		getContentPane().add(Username);

		// Password

		Password = new JPasswordField();

		Password.setBounds(217, 77, 102, 20);

		getContentPane().add(Password);

		// Confirm Password

		confirmPassword = new JPasswordField();

		confirmPassword.setBounds(217, 112, 102, 20);

		getContentPane().add(confirmPassword);

		email = new JTextField();
		email.setBounds(217, 142, 200, 20);
		getContentPane().add(email);

		phoneNumber = new JTextField();
		phoneNumber.setBounds(217, 172, 102, 20);
		getContentPane().add(phoneNumber);

		Submit = new Button("Submit");
		Submit.setBounds(161, 200, 89, 23);
		getContentPane().add(Submit);
		/**
		 * setLayout(new FlowLayout()); userNameLabel = new Label("User Name");
		 * passwordLabel = new Label("Password"); confirmPasswordLabel = new
		 * Label("Confirm Password"); confirmPassword = new JPasswordField(15); Username
		 * = new TextField(10); Password = new JPasswordField(15); Submit = new
		 * Button("Submit"); add(userNameLabel); add(Username); add(passwordLabel);
		 * add(Password); add(confirmPasswordLabel); add(confirmPassword); add(Submit);
		 * setSize(350, 200);
		 **/
		setLocationRelativeTo(null);
		setVisible(true);

		System.out.println("DFKLJDF");
		// get the connection and begin to check the database
		Connection conn = myConnection.getConnection();
		System.out.println("WORK");
		// Connection conn = myConnection.getConnection();
		boolean usernameExisted = false;
		try {
			if (isUserNameExisted(Username.getText(), conn)) {
				usernameExisted = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Here");
		Submit.addActionListener(new CreatenewUser());
		System.out.println("Click on Signup ");
	}
}
