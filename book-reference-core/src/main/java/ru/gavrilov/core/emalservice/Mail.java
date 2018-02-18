package ru.gavrilov.core.emalservice;

import ru.gavrilov.core.helpers.LoadProperty;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Mail {
    private static final String ENCODING = "UTF-8";
    private static final Properties DEV_PROPERTY = LoadProperty.loadProperty();

    public static void sendSimpleMessage(String to, String content, String subject) throws MessagingException, UnsupportedEncodingException {
        Message msg = new MimeMessage(getSession());
        msg.setFrom(new InternetAddress(DEV_PROPERTY.getProperty("mail.address")));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(content);
        Transport.send(msg);
    }

    public static void sendMultiMessage(String to, String content, String subject) throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = new MimeMessage(getSession());

        msg.setFrom(new InternetAddress(DEV_PROPERTY.getProperty("mail.address")));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject, ENCODING);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/plain; charset=" + ENCODING + "");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(DEV_PROPERTY.getProperty("mail.attachment"));
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName(MimeUtility.encodeText(source.getName()));
        multipart.addBodyPart(attachmentBodyPart);

        msg.setContent(multipart);

        Transport.send(msg);
    }

    private static Properties getPropertiseMail() {
        Properties props = System.getProperties();
        props.put("mail.smtp.port", DEV_PROPERTY.getProperty("mail.smtpPort"));
        props.put("mail.smtp.host", DEV_PROPERTY.getProperty("mail.smtpHost"));
        props.put("mail.smtp.socketFactory.port", DEV_PROPERTY.getProperty("mail.smtpPort"));
        props.put("mail.smtp.socketFactory.class", DEV_PROPERTY.getProperty("mail.socketFactory"));
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset", ENCODING);
        return props;
    }

    private static Session getSession() {
        Authenticator auth = new MailAuthenticator(DEV_PROPERTY.getProperty("mail.login"), DEV_PROPERTY.getProperty("mail.password"));
        Session session = Session.getDefaultInstance(getPropertiseMail(), auth);
        return session;
    }
}
