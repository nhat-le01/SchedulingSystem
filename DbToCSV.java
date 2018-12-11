import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbToCSV {
	public static void main(String[] args) {
		String filename = "C:/myWebProject/currentUser.txt";
		try {
			FileWriter fw = new FileWriter(filename);
			Connection conn = myConnection.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from clients where id = ?");
			// String query = "select * from clients";
			// Statement stmt = conn.createStatement();
			prep.setInt(1, 1);
			ResultSet rs = prep.executeQuery();
			fw.append("Id");
			fw.append('\t');
			fw.append("Username");
			fw.append('\t');
			fw.append("Password");
			fw.append('\t');
			fw.append("Email");
			fw.append('\t');
			fw.append("Phone number");
			fw.append("\r\n");

			while (rs.next()) {
				fw.append(rs.getString(1));
				fw.append('\t');
				fw.append(rs.getString(2));
				fw.append('\t');
				fw.append(rs.getString(3));
				fw.append('\t');
				fw.append(rs.getString(4));
				fw.append('\t');
				fw.append(rs.getString(5));
				fw.append("\r\n");
			}

			PreparedStatement prepApp = conn
					.prepareStatement("select begin, end, description from appointments where id = ?");
			prepApp.setInt(1, 3);
			ResultSet app = prepApp.executeQuery();

			while (app.next()) {
				fw.append(app.getString(1));
				fw.append('\t');
				fw.append(app.getString(2));
				fw.append('\t');
				fw.append(app.getString(3));
				fw.append('\t');
				fw.append("\r\n");
			}
			fw.flush();
			fw.close();
			conn.close();
			System.out.println("CSV File is created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}