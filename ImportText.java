import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ImportText {
	private int ID;
	private String user;
	private String email;
	private String pass;
	private String phone;
	private ArrayList<String> list;
	private ArrayList<Timestamp> time = new ArrayList<Timestamp>();
	private ArrayList<String> description = new ArrayList<String>();

	public ImportText(String address) throws Exception {
		FileReader file = new FileReader(address);
		BufferedReader reader = new BufferedReader(file);

		String text = "";
		String line = reader.readLine();
		int skip = 0;
		while (line != null) {
			line = "\t" + line;
			if (skip != 0) {
				text += line;
			}
			line = reader.readLine();
			skip++;
		}
		list = new ArrayList<String>(Arrays.asList(text.replaceAll("\r\n", "\t").split("\t")));
		list.removeAll(Arrays.asList("", null));
		for (int count = 0; count < list.size(); count++) {
			System.out.println("Count " + count + ": " + list.get(count));
		}
		setID();
		System.out.println("ID: " + ID);
		setUser();
		System.out.println("User: " + user);
		setPass();
		System.out.println("Pass: " + pass);
		setEmail();
		System.out.println("Email: " + email);
		setPhone();
		System.out.println("Phone: " + phone);
		int jump = 0;
		for (int index = 5; index < list.size(); index++) {
			if (jump == 2) {
				System.out.println("Description was picked");
				setDescription(index);
				jump = -1;
			} else {
				System.out.println("Apointment was picked");
				setAppointment(index);
			}
			jump++;
		}
	}

	private void setID() {
		String number = list.get(0);
		ID = Integer.parseInt(number);
	}

	private void setUser() {
		user = list.get(1);
	}

	private void setPass() {
		pass = list.get(2);
	}

	private void setEmail() {
		email = list.get(3);
	}

	private void setPhone() {
		phone = list.get(4);
	}

	private void setAppointment(int index) throws ParseException {
		String temp = list.get(index);
		Timestamp x = convertStringToTimestamp(temp);
		time.add(x);
	}

	private void setDescription(int index) {
		String temp = list.get(index);
		description.add(temp);
	}

	private static Timestamp convertStringToTimestamp(String str_date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = (Date) df.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
			return timeStampDate;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

	public void printList() {
		System.out.println(list);
	}

	public ArrayList<String> getDescription() {
		return description;
	}

	public void printDescription() {
		System.out.println(description);
	}

	public void printTimestamp() {
		System.out.println(time);
	}

	public int getID() {
		return ID;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public ArrayList<Timestamp> getTimestamp() {
		return time;
	}
}