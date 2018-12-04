import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.*;
import java.awt.*;
import java.io.FileWriter;

public class databaseAction {
	public databaseAction() {

	}

	public static boolean isUsernameExisted(String newusername) {
		Connection conn = myConnection.getConnection();
		boolean result = true;
		try {
			Statement stmt = conn.createStatement();
			PreparedStatement prep = conn.prepareStatement("select * from clients where username = ?");
			// String query = "select * from clients " + "where username = " +
			// '"newusername"' ";
			prep.setString(1, newusername);
			ResultSet rset = prep.executeQuery();
			// username does not exist
			if (!rset.next()) {
				result = false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	public static boolean isPasswordMatched(String username, String password) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement("select password from clients where username = ?");
			prep.setString(1, username);
			ResultSet rset = prep.executeQuery();
			if (rset.next()) {
				if (rset.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static boolean correctNameAndPassword(String username, String password) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn
					.prepareStatement("select id, username, password from clients where username = ? and password = ?");
			prep.setString(1, username);
			prep.setString(2, password);
			ResultSet rset = prep.executeQuery();
			if (rset.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void createNewUser(String username, String password, String email, String phonenumber) {
		Connection conn = myConnection.getConnection();
		try {
			// check the last row of the table,
			// if the last row is empty, this is the first user, other wise, increase to id
			// number
			String query = "select id from clients order by id desc limit 1";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int last_id = 0;
			if (!rset.next()) {
				// the set is empty
				// String first_user = "insert into clients " + "values (0, " + username + ", "
				// + password + " )";
				// String temp = "insert into clients values(0, ?, ?)";
				PreparedStatement prep = conn.prepareStatement("insert into clients values(0, ?, ?, ?, ?)");
				System.out.println("empty");
				prep.setString(1, username);
				prep.setString(2, password);
				prep.setString(3, email);
				prep.setString(4, phonenumber);
				int countInserted = prep.executeUpdate();
				System.out.println("Updated " + countInserted);
			} else {
				System.out.println("not empty");
				// while (rset.next()) {
				System.out.println("here sfdgsdgdf");
				last_id = rset.getInt("id");
				// break;

				last_id += 1;
				System.out.println("next id is " + last_id);
				// String new_user = "insert into clients " + "values (" + last_id + " , " +
				// username + ", " + password + " )";
				PreparedStatement prep = conn.prepareStatement("insert into clients values(?, ?, ?, ?, ?)");
				prep.setInt(1, last_id);
				prep.setString(2, username);
				prep.setString(3, password);
				prep.setString(4, email);
				prep.setString(5, phonenumber);
				int countInserted = prep.executeUpdate();
				System.out.println("Insert updated " + countInserted);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void changePassword(int id, String newpassword) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement("update clients set password = ? where id = ?");
			prep.setString(1, newpassword);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void changePhoneNumber(int id, String newPhoneNumber) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement("update clients set phonenumber = ? where id = ?");
			prep.setString(1, newPhoneNumber);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void changeEmail(int id, String newEmail) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement("update clients set email = ? where id = ?");
			prep.setString(1, newEmail);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void changeUsername(int id, String newusername) {
		Connection conn = myConnection.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement("update clients set username = ? where id = ?");
			prep.setString(1, newusername);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static int getIdGivenUsername(String username) {
		Connection conn = myConnection.getConnection();
		int result = 0;
		try {
			PreparedStatement prep = conn.prepareStatement("select id from clients where username = ?");
			prep.setString(1, username);
			ResultSet rset = prep.executeQuery();
			rset.next();
			result = rset.getInt("id");
			return result;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public static void getAppointmentsGivenId(int id) {

	}

	public static void addAppointment(int id, Timestamp start, Timestamp end, String description) {
		Connection conn = myConnection.getConnection();
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
	//A function to check if a new appointment is conflict with existing appointments
	public static boolean isConflict(int id, CalendarEvent newEvent) {
		ArrayList<CalendarEvent> currentEvents = getAllAppointments(id);
		for (CalendarEvent e : currentEvents) {
			LocalTime s = e.getStart();
			LocalTime en = e.getEnd();
			if (s.isBefore(newEvent.getStart()) && newEvent.getStart().isBefore(en)) {
				return true;
			}
			else if (newEvent.getEnd().isAfter(s) && newEvent.getStart().isBefore(s)) {
				return true;
			}
		}
		return false;
	}
	public static void addAppointment(int id, int day, int month, int year, int hour, int minute, String description) {
		// Date date = new Date(year, month, day);

		Calendar cale = new GregorianCalendar();
		cale.set(Calendar.YEAR, year);
		cale.set(Calendar.MONTH, month - 1);
		cale.set(Calendar.DATE, day);
		cale.set(Calendar.HOUR_OF_DAY, hour);
		cale.set(Calendar.MINUTE, minute);

		Timestamp ts = new Timestamp(cale.getTimeInMillis());

		Connection conn = myConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			// String updateQuery = "insert into appointments " + "values('" + id + "', '" +
			// begin + "', '" + end + "', "
			// + description + ")";
			// String updateQuery = "insert into appointments values (?, ?, ?)";
			PreparedStatement prep = conn.prepareStatement("insert into appointments values (?, ?, ?)");
			prep.setInt(1, id);
			prep.setTimestamp(2, ts);
			prep.setString(3, description);
			prep.executeUpdate();
			// int updateCounted = stmt.executeUpdate(updateQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// public static void add
	// Cancel an appointment given a timestamp
	public static void cancelAppointment(Timestamp ts) {

	}

	public static void exportScheduleToAFile(int id) {
		String filename = "C:/myWebProject/currentUser.txt";
		try {
			FileWriter fw = new FileWriter(filename);
			Connection conn = myConnection.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from clients where id = ?");
			// String query = "select * from clients";
			// Statement stmt = conn.createStatement();
			prep.setInt(1, id);
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
			prepApp.setInt(1, id);
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
			//System.out.println("CSV File is created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> showRepresentation(int id) {
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<CalendarEvent> events = getAllAppointments(id);
		for (CalendarEvent ev : events) {
			l.add(ev.getText());
		}
		return l;
	}

	public static void cancelAppointmentAtIndex(int id, String description) {
		ArrayList<CalendarEvent> events = getAllAppointments(id);
		Connection conn = myConnection.getConnection();
		try {
			// Statement stmt = conn.createStatement();
			PreparedStatement prep = conn.prepareStatement("delete from appointments where description = ?");
			prep.setString(1, description);
			prep.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<CalendarEvent> getAllAppointments(int id) {
		ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
		Connection conn = myConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			PreparedStatement prep = conn
					.prepareStatement("select begin, end, description from appointments where id = ?");
			prep.setInt(1, id);
			ResultSet r = prep.executeQuery();
			while (r.next()) {
				Timestamp start = r.getTimestamp("begin");
				Timestamp end = r.getTimestamp("end");
				String description = r.getString("description");
				Calendar cal = Calendar.getInstance();
				cal.setTime(start);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DATE);
				int startHour = cal.get(Calendar.HOUR_OF_DAY);
				int startMinute = cal.get(Calendar.MINUTE);
				
				cal.setTime(end);
				int endHour = cal.get(Calendar.HOUR_OF_DAY);
				int endMinute = cal.get(Calendar.MINUTE);
				events.add(new CalendarEvent(LocalDate.of(year, month, day), LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute), description, Color.PINK));
			}
			return events;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return events;

	}

}
