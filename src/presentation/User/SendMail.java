package presentation.User;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;
public class SendMail {
    private static final String from = "nhminh22@clc.fitus.edu.vn";
    private static final String appPass = "erbd vxij fsuc hczf";

    public SendMail(String to, String pass) {
        try{
            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Mail Subject");

            // Add custom headers
            message.setHeader("X-Priority", "1"); // High priority
            message.setHeader("X-MSMail-Priority", "High");
            message.setHeader("Importance", "High");

            Multipart multipart = new MimeMultipart();

            // Create the plain text part
            BodyPart plainTextPart = new MimeBodyPart();
            plainTextPart.setText("");
            multipart.addBodyPart(plainTextPart);

            // Create the HTML part
            BodyPart htmlPart = new MimeBodyPart();
            String htmlContent = "<p>Hello there,<br>" +
                    "<br>" +
                    "This is Chat-System.<br>" +
                    "We noticed you requested a password reset. Your new password is below:<br>" +
                    "<br>" + pass + "<br>" +
                    "<br>" +
                    "Do not share this with anyone for security reasons.<br>" +
                    "If you didn’t request this, someone might have misspelled your email.<br>" +
                    "<br>" +
                    "Thanks,<br>" +
                    "Your Chat-System</p>";
            htmlPart.setContent(htmlContent, "text/html");
            multipart.addBodyPart(htmlPart);

            // Set the complete message parts
            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getEmailSession() {
        return Session.getInstance(getProp(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPass);
            }
        });
    }

    private static Properties getProp() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return prop;
    }
}
