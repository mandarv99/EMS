/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author rupesht
 */
public class SendMailUtil {

    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "465";
    private static final String SOCKET_FACTORY_CLASS = "javax.net.ssl.SSLSocketFactory";

    public static void sendMail(final String to, final String subject, final String body) {

        Thread thread = new Thread() {
            public void run() {
                try {
                    final String username = "2406roop@gmail.com";
                    final String password = "roop@1988";
                    Properties props = new Properties();
                    props.put("mail.smtp.host", HOST);
                    props.put("mail.smtp.socketFactory.port", PORT);
                    props.put("mail.smtp.socketFactory.class",
                            SOCKET_FACTORY_CLASS);
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", PORT);
                    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

                    Message message = new MimeMessage(session);
                    InternetAddress fromAddr = new InternetAddress(username, "My Event");
                    message.setFrom(fromAddr);
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(to));
                    message.setSubject(subject);
                    message.setSentDate(new Date());
                    message.setText(body);
                    message.setContent(body, "text/html");
                    Transport.send(message);

                    System.out.println("Done");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();

    }  

//    public static void main(String[] args) {
//        // sendMail("roop.talekar@gmail.com", "Hi all", "Test");
//
//        // System.out.println(Long.toHexString(Double.doubleToLongBits(Math.random())));      
//    }
}
