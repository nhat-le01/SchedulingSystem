import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Welcome extends JFrame {
	private Button login;
	private Button signUp;
	private static JFrame frame;
	
	public Welcome() {
		frame = new JFrame("Scheduling system");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		login = new Button("Log In");
		signUp = new Button("Sign Up");
		login.setPreferredSize(new Dimension(60, 40));
		signUp.setPreferredSize(new Dimension(60, 40));
		
		
		frame.getContentPane().add(login);
		frame.getContentPane().add(signUp);
		login.addActionListener(new LogIn());
		signUp.addActionListener(new SignUp());
		
		frame.pack();
		frame.setSize(500,  300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void cancelFrame() {
		frame.dispose();
	}
	public static void main(String[] args) {
		Welcome wel = new Welcome();
	}
	
}
