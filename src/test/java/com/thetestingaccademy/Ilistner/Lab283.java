package com.thetestingaccademy.Ilistner;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Lab283 {

    @Test(groups = "Test")
    public void test1(){
        System.out.println("This is Test 1");
        Assert.assertTrue(true);
    }

    @Test(groups = "Test")
    public void test2(){
        System.out.println("This is Test 2");
        Assert.assertTrue(true);
    }

    @AfterSuite
    public void emailToQALead(){
        System.out.println("After Suite Execution");
        System.out.println("Sending Email");

        String to = "ratul.pmc@gmail.com";
        String from = "ratul.pmc@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");  // Port for TLS
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Get the default Session object
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ratul.pmc@gmail.com", "efnnjamlgvmehsrx"); // Your email and password
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(from));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is the body of the email.");

            // Send message
            Transport.send(message);
            System.out.println("Message sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    }


