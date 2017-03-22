package ru.kpfu.itis.util;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class EmailSenderUtil {

    private SimpleMailMessage message;
    private static JavaMailSenderImpl mailSender;
    private static EmailSenderUtil emailSenderUtil;

    public synchronized static EmailSenderUtil getInstance() {
        if (emailSenderUtil == null) return new EmailSenderUtil();
        else {
            return emailSenderUtil;
        }
    }

    private EmailSenderUtil() {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        message = new SimpleMailMessage();
        message.setTo("ilgiz1996@mail.ru");
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(properties);

    }

    public void send(String email, String password, String subject, String text) throws MailException {
        mailSender.setUsername(email);
        mailSender.setPassword(password);

        message.setFrom(email);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
