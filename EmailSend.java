
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {
	// Constructor
    	public EmailSend()
    	{
    		
    	}
    	
    	public void createEmail()
    	{
	        try{
	            String host ="smtp.gmail.com" ;
	            String user = "testuser9403@gmail.com";
	            String pass = "Wtgdgtwtw98";
	            String to = "nhatle0296@gmail.com";
	            String from = "testuser9403@gmail.com";
	            String subject = "JavaToEmail";
	            String messageText = "This is a Java to Email test message.";
	            
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
