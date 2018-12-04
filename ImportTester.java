
public class ImportTester {

	public static void main(String[] args) throws Exception {
		ImportText test = new ImportText("D:/CSULB/ThirdYearFirstSemester/CECS 343/currentUser.txt");
		System.out.println("Spliced ArrayList: ");
		test.printList();
		System.out.println("Description ArrayList: ");
		test.printDescription();
		System.out.println("Timestamp ArrayList (Start is Even index, End is odd index): ");
		test.printTimestamp();
	}
}
