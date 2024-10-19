package util;
import jakarta.activation.FileDataSource;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
public class EmailSendingUtil {
    public static void create(String to, String subject, String text, String file) {
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("vinuthsriarampth@gmail.com")
                    .to(to)
                    .withSubject(subject)
                    .withPlainText(text)
                    .withAttachment("Bill.pdf",  new FileDataSource(file))
                    .buildEmail();

            Mailer mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 465, "vinuthsriarampth@gmail.com", "zptb pykr obvt omkh")
                    .withTransportStrategy(TransportStrategy.SMTPS)
                    .buildMailer();

            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void create(String to, String subject, String text) {
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("vinuthsriarampth@gmail.com")
                    .to(to)
                    .withSubject(subject)
                    .withPlainText(text)
                    .buildEmail();

            Mailer mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 465, "vinuthsriarampth@gmail.com", "zptb pykr obvt omkh")
                    .withTransportStrategy(TransportStrategy.SMTPS)
                    .buildMailer();

            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
