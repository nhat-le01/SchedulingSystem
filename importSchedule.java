
import java.util.Scanner;

public class importSchedule {
	public static void main(String[] args) throws Exception {
		// Create a File instance

		java.io.File file = new java.io.File("scores.txt");

		// Create a Scanner for the file
		Scanner input = new Scanner(file);

		// Read data from a file
		int i = 1;
		while (input.hasNext()) {
			// here is where the personal info at
			if (i == 2) {
				String id = input.next();
				String username = input.next();
				String password = input.next();
				String email = input.next();
				String phoneNumber = input.next();
			} else if (i >= 3) {

			} else {
				for (int j = 0; j < 5; j++) {
					input.next();
				}
			}
			i++;
			/**
			 * String firstName = input.next(); String mi = input.next(); String lastName =
			 * input.next(); int score = input.nextInt(); System.out.println(firstName + " "
			 * + mi + " " + lastName + " " + score);
			 **/

		}

		// Close the file
		input.close();
	}
}
