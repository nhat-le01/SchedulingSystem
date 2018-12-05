import javax.swing.JOptionPane;

public class ImportTester {

	public static void main(String[] args) throws Exception {
		try 
		{
			String gui = JOptionPane.showInputDialog("Please enter your directory (example: D:/CSULB/someFile.txt) : ");
			ImportText test = new ImportText(gui);
			System.out.println("Spliced ArrayList: ");
			test.printList();
			System.out.println("Description ArrayList: ");
			test.printDescription();
			System.out.println("Timestamp ArrayList (Start is Even index, End is odd index): ");
			test.printTimestamp();
		}
		catch (Exception e)
		{
			
		}
	}
}

