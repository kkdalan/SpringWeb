package com.ezpay.web.util.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SimpleMail {

     private String smtpHost = null;
     private String from = null;

     public void sendMail(String email, String subject, String text) {
          JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
          senderImpl.setHost(getSmtpHost());
          
          SimpleMailMessage mailMessage = new SimpleMailMessage();
          mailMessage.setTo(email);
          mailMessage.setFrom(getFrom());
          mailMessage.setSubject(subject);
          mailMessage.setText(text);
          senderImpl.send(mailMessage);
          
     }

     public String getSmtpHost() {
          return smtpHost;
     }

     public void setSmtpHost(String smtpHost) {
          this.smtpHost = smtpHost;
     }

     public String getFrom() {
          return from;
     }

     public void setFrom(String from) {
          this.from = from;
     }

}
