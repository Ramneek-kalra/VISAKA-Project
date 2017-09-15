import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.swing.JOptionPane;
  
public class NewClass1 {  
 public static void Mail(String to,String pass,String from,String s,String m) {    
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true"); //Allow gmail to access permission to send mail or recieve 
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(from,pass);//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress(from));
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject(s);  
   message.setText(m);  
     
   //send message  
   Transport.send(message);  
  } catch (MessagingException e) {
  System.out.println(e);}  
   
 }  
}  