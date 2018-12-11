import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ImportTester {
	public static void main(String[] args) throws Exception {
		ImportText test = new ImportText("C:/myWebProject/currentUser.txt");
		System.out.println("Spliced ArrayList: ");
		test.printList();
		System.out.println("Description ArrayList: ");
		test.printDescription();
		System.out.println("Timestamp ArrayList (Start is Even index, End is odd index): ");
		test.printTimestamp();

		ArrayList<String> des = test.getDescription();
		ArrayList<Timestamp> t = test.getTimestamp();

	}

	public void pushInDatabase(int id, ArrayList<String> descriptions, ArrayList<Timestamp> t) {
		// wait but first we have delete all the previous appointments???
		Connection conn = myConnection.getConnection();
		int i = 0;
		int j = 0;
		while (i < descriptions.size() && j < t.size()) {
			String description = descriptions.get(i);
			Timestamp start = t.get(j);
			Timestamp end = t.get(j + 1);
			i += 1;
			j += 2;
			try {
				Statement stmt = conn.createStatement();
				String updateQuery = "insert into appointments values (?, ?, ?, ?)";
				PreparedStatement prep = conn.prepareStatement("insert into appointments values (?, ?, ?, ?)");
				prep.setInt(1, id);
				prep.setTimestamp(2, start);
				prep.setTimestamp(3, end);
				prep.setString(4, description);
				prep.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}
}