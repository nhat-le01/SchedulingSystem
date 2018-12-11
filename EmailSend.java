import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {
	private String des, em;
	
	// Constructor
    	public EmailSend(String description, String email, int hour, int min, int sec)
    	{
    		des = description;
    		em = email;
    		int math = (hour * 3600000) + (min * 60000) + (sec * 1000);
    		long mathLong = Long.valueOf(math);
    		long time;
    		long afterTime = 0;
    		time = System.currentTimeMillis();
    		System.out.println("Before (millisecond): " + time);
    		System.out.println("Theoretical: " + (time + mathLong));
    		while (System.currentTimeMillis() < time + 1000000000000000000L)
    		{
    			if (System.currentTimeMillis() >= time + mathLong)
    			{
    				afterTime = System.currentTimeMillis();
    				System.out.println("After:" + afterTime);
    				createEmail();
    				break;
    			}
    		}
    		System.out.println("Check if it does:... " + (afterTime - time)/1000 + "s has passed.");
    		System.out.println("done");
    	}
    	
    	private void createEmail()
    	{
	        try{
	            String host ="smtp.gmail.com" ;
	            String user = "testuser9403@gmail.com";
	            String pass = "Wtgdgtwtw98";
	            String to = em;
	            String from = "testuser9403@gmail.com";
	            String subject = "Reminder for Appointment";
	            String messageText = "Description: " + des;
	            
	            boolean sessionDebug = false;
	
	            Properties props = System.getProperties();
	
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");
	
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);
	
	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("message send successfully");
	        }catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
    	}
}