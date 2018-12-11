import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
//import java.util.Time;
import java.sql.Timestamp;

public class EmailTester {

	public static void main(String[] args) {
		System.out.println("This test should send an email 10s from now.");
		long time;
		long afterTime = 0;
		time = System.currentTimeMillis();
		System.out.println("Before (millisecond): " + time);
		System.out.println("Theoretical: " + (time + 10000L));
		while (System.currentTimeMillis() < time + 100000000000L) {
			if (System.currentTimeMillis() >= time + 10000L) {
				afterTime = System.currentTimeMillis();
				System.out.println("After:" + afterTime);
				new EmailSend().createEmail();
				break;
			}
		}
		System.out.println("Check if it does:... " + (afterTime - time) / 1000 + "s has passed.");
		System.out.println("done");
	}

}